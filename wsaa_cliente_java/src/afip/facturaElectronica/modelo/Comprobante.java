package afip.facturaElectronica.modelo;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import afip.facturaElectronica.conexion.tcp.Conexion;
import afip.facturaElectronica.conexion.tcp.respuestas.RespuestaTCP;
import afip.facturaElectronica.db.Factura;
import afip.facturaElectronica.db.TipoDeComprobante;
import afip.facturaElectronica.db.commons.CompletaCAE;
import afip.facturaElectronica.db.dao.GlobalDAO;
import afip.facturaElectronica.handshake.exceptions.ComprobanteException;
import afip.facturaElectronica.handshake.exceptions.NoExisteFacturaEnLaColeccionException;
import afip.facturaElectronica.handshake.exceptions.NoHayComprobantesPendientesException;
import afip.facturaElectronica.handshake.exceptions.TipoDeComprobanteException;
import afip.facturaElectronica.handshake.wsfe.FEResponse;
import afip.facturaElectronica.modelo.cola.ComprobantesAProcesar;

/**
 * Modela el grupo de facturas a procesar (CUIT, Tipo de Comprobante y Punto de Venta)
 * Funciona para envío individual o para facturación recursiva
 * @author agro
 */
public class Comprobante {//implements AgregarACola {
	private TipoDeComprobante tipoDeComprobante = null;

	//facturas a enviar
	private List<Factura> facturas = null;
	
	//Cola donde se ponen los Comprobantes (a mi mismo) para luego se envien a la afip. La cola es compartida por todos!
	private ComprobantesAProcesar facturasAProcesar = null;
	
	//Se almacenan todas las conexiones por TCP que solicitaron CAE para un mismo Tipo de Comprobante (distinta numeración!)
	//Si son varios usuarios los que piden CAE => se guadran las conexionesTCP para luego comunicarme con el cliente
	private Set<SelectionKey> conexionTCP = null;

	/**
	 * Constructor para el envío de comprobantes de múltiples empresas
	 */
	public Comprobante(TipoDeComprobante tipoDeComprobante, SelectionKey skey, ComprobantesAProcesar pcolaFactura) throws TipoDeComprobanteException{
		//comprobante que identifica una Empresa y su Comprobante
		this.tipoDeComprobante = tipoDeComprobante;
		//El pool de facturas que comparten todos los comprobantes
		facturasAProcesar = pcolaFactura;
		
		conexionTCP = new HashSet<SelectionKey>();
		conexionTCP.add(skey);
	}

	/**
	 * Constructor para el envío de Facturación Recurrente (única Empresa)
	 */
	public Comprobante(long cuit, int tipoCpr, int puntoVta) throws TipoDeComprobanteException {
		//comprobante que identifica una Empresa y su Comprobante
		tipoDeComprobante = new TipoDeComprobante(cuit, tipoCpr, puntoVta);
	}
	
	/**
	 * Prepara una Tanda de Facturas que haya pendientes para enviar para el
	 * Tipo de Comprobante, Punto de Venta y CUIT
	 */
	public void prepararTandaDeFacturas(long proximoID) throws NoHayComprobantesPendientesException{
		buscarFacturasAAutorizar();
		setEstadoEnviando(proximoID);
	}
	
	/**
	 * Realiza la consulta de las factuas a enviar
	 */
	private void buscarFacturasAAutorizar() throws NoHayComprobantesPendientesException {
		facturas = GlobalDAO.getInstance().getFacturaDAO().getFacturas(
				tipoDeComprobante.getComprobantePK());
		
		//verifico que haya facturas para enviar
		if (facturas.size() == 0) {
			throw new NoHayComprobantesPendientesException(tipoDeComprobante, "s");
		}
	}

	/**
	 * Se agrega (a si mimso) a la cola de FacturasAProcesar
	 * @throws ComprobanteException 
	 */
	public void addComprobante()throws InterruptedException, ComprobanteException{
		// una vez obtenida las facturas a enviar me envío a mi mismo ya que
		// quedo esperando hasta que temrine de procesarme
		facturasAProcesar.addComprobante(this);
	}


	/**
 	 * Setea en la DB los Comprobantes a estado Enviado
	 * @param proximoID: es el ID con el que se envia el XML a la AFIP
	 */
	public void setEstadoEnviando(long proximoID) {
		// marco el grupo de facturas con el Estado de Enviado
		CompletaCAE.marcarEnvioFacturas(this.facturas, proximoID);

	}

	public TipoDeComprobante getTipoDeComprobante() {
		return tipoDeComprobante;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}
	
	public long getCuit(){
		return getTipoDeComprobante().getComprobantePK().getCuit();
	}
	

	public Set<SelectionKey> getConexionTCP() {
		return conexionTCP;
	}
/*
	public void setConexionTCP(Set<ConexionDeMentiritas> conexionTCP) {
		this.conexionTCP = conexionTCP;
	}
*/
	public void addConexionTCP(SelectionKey conecionTCP){
		this.conexionTCP.add(conecionTCP);
	}
	
	/**
	 * Devuelve la única conexiónTCP.
	 * @return la unica conexiónTCP
	 * @throws ComprobanteException si posee mas de una conexiónTCP
	 */
	public SelectionKey getMiUnicaConexionTCP() throws ComprobanteException{
		if (this.conexionTCP.size() != 1){
			throw new ComprobanteException(tipoDeComprobante, "Se esta intentando obtener la Única ConexiónTCP para un Comprobante que ya posee mas de una.");
		}
		return this.conexionTCP.iterator().next();
	}
	
	/**
	 * Envia un mismo mensaje a todas las conexiones que tenga el Comprobante
	 * @param mensaje
	 */
	public void enviarDatos(String mensaje){
		enviarDatosATodasLasConexiones(mensaje);
	}
	
	/**
	 * Envia un mismo mensaje a todas las conexiones que tenga el Comprobante
	 * @param mensaje
	 */
	public void enviarDatos(RespuestaTCP respuesta){
		enviarDatosATodasLasConexiones(respuesta.getRespuestaXML());
	}
	
	private void enviarDatosATodasLasConexiones(String mensaje){
		for (Iterator<SelectionKey> iterator = conexionTCP.iterator(); iterator.hasNext();) {
			SelectionKey skey = iterator.next();
			final SocketChannel sock = (SocketChannel) skey.channel();
			final Conexion conn = (Conexion) skey.attachment();

			try {
				conn.sendData(sock,mensaje);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * Modifica la coleccion de facturas con la respuesta de la AFIP
	 * @param respuestaAFIP
	 * @throws NoExisteFacturaEnLaColeccionException
	 */
	public void completarCAE(FEResponse respuestaAFIP) throws NoExisteFacturaEnLaColeccionException {
		CompletaCAE.completarCAE(this.facturas, respuestaAFIP);
		
	}

	/**
	 * Updetea las facturas en la DB
	 */
	public void saveFacturas() {
		GlobalDAO.getInstance().getFacturaDAO().saveFacturas(this.facturas);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((tipoDeComprobante == null) ? 0 : tipoDeComprobante
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Comprobante other = (Comprobante) obj;
		if (tipoDeComprobante == null) {
			if (other.tipoDeComprobante != null)
				return false;
		} else if (!tipoDeComprobante.equals(other.tipoDeComprobante))
			return false;
		return true;
	}

	/**
	 * Encargado de grabar la Respuesta de la AFIP en la DB
	 * @param respuestaAFIP el XML que devuelve WS
	 * @throws NoExisteFacturaEnLaColeccionException
	 */
	public void grabarRespuestaAFIP(FEResponse respuestaAFIP) throws NoExisteFacturaEnLaColeccionException {
		// completo la respuesta de la AFIP en la colección de facturas
		completarCAE(respuestaAFIP);
		
		//updeteo en la DB las facturas con la respuesta de la AFIP
		saveFacturas();
	}

}
