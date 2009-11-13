package afip.facturaElectronica.modelo.cola;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import afip.facturaElectronica.conexion.tcp.respuestas.RespuestaTCPError;
import afip.facturaElectronica.handshake.exceptions.ComprobanteException;
import afip.facturaElectronica.handshake.exceptions.NoHayComprobantesPendientesException;
import afip.facturaElectronica.modelo.Comprobante;

/**
 * (Singleton) Encargado de encolar el grupo de facturas a enviar. Intermediario
 * entre los Hilos de los Comprobantes a enviar (Comprobante) y el manejador de
 * Envios al WSFA (PoolFacturas)
 * 
 * @author agro
 * 
 */
public class ComprobantesAProcesar {// implements AgregarACola, QuitarDeCola {
	public static BlockingQueue<Comprobante> comprobantes = null;
	private static Comprobante cprActual = null;
	private static ComprobantesAProcesar singleton = null;

	private ComprobantesAProcesar() {
	}

	public static ComprobantesAProcesar getInstance() {
		if (singleton == null) {
			singleton = new ComprobantesAProcesar();
			comprobantes = new LinkedBlockingQueue<Comprobante>();
		}
		return singleton;
	}

	/**
	 * Agrega el tipo de Comprobante a Enviar al final de la Cola Si ya posee
	 * algún comprobante solamente le agrego al conexiónTCP
	 */
	public void addComprobante(Comprobante cpr) throws InterruptedException,
			ComprobanteException {
		boolean continuarLoop = true;

		// busco si existen comprobantes en la colección. Si está se agrego la
		// conexiónTCP
		for (Iterator<Comprobante> iterator = comprobantes.iterator(); iterator
				.hasNext()
				&& continuarLoop == true;) {
			Comprobante comprobante = iterator.next();

			if (comprobante.equals(cpr)) {
				comprobante.addConexionTCP(cpr.getMiUnicaConexionTCP());
				continuarLoop = false;
			}

		}

		// si no se encontró un comprobante cargado en la colección lo agrego a
		// la cola
		if (continuarLoop == true) {
			comprobantes.put(cpr);
		}
	}

	/**
	 * Toma el Comprobante pendiente en la Cola
	 * 
	 * @param proximoID
	 * @throws InterruptedException
	 */
	public Comprobante getPendientes() throws InterruptedException,
			NoHayComprobantesPendientesException {
		// Tomo un Comprobante de la Cola y lo dejo como pendiente de
		// envio
		getComprobante();
		return cprActual;
	}

	/**
	 * Toma uno de los Comprobantes que se encuentras para procesar
	 */
	private void getComprobante() throws InterruptedException,
			NoHayComprobantesPendientesException {
		// en este punto se queda esperando hasta que haya elementos en la cola
		// para enviar
		cprActual = comprobantes.take();
	}

	/**
	 * Envía un mensaje masivo a todos los Comprobantes (actual y pendiente) y a sus ConexionesTCP
	 * @param respuesta
	 */
	public void enviarDatosATodosLosComprobantes(
			RespuestaTCPError respuesta) {
		
		//si el Comprobante actual no es nulo le envío el mensaje
		if (cprActual != null){
			cprActual.enviarDatos(respuesta);
		}
		
		for (Iterator<Comprobante> iterator = comprobantes.iterator(); iterator.hasNext();) {
			Comprobante cpr = iterator.next();
			cpr.enviarDatos(respuesta);
		}
		
	}

	/**
	 * Updeteo en la DB el estado de las facturas. Las paso a estado Enviando
	 * 
	 * @throws NoHayComprobantesPendientesException
	 */
/*	public void prepararTandaDeFacturas(Long proximoID)
			throws NoHayComprobantesPendientesException {

		// cuando hay Comprobantes le pido que los busque en la DB y los marque
		// en estado Enviando. Con esto permito que si se agregan mas
		// Comprobantes del mismo tipo se envíen todos juntos
		cprActual.prepararTandaDeFacturas(proximoID);

	}*/

	/**
	 * Envia una respuesta a la conexionTCP
	 * 
	 * @param mensaje
	 */
	/*
	 * public void enviarDatos(String mensaje){ cprActual.enviarDatos(mensaje);
	 * }
	 */

}