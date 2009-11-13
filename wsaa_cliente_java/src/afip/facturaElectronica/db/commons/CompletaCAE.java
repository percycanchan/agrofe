package afip.facturaElectronica.db.commons;

import java.util.Iterator;
import java.util.List;

import afip.facturaElectronica.db.Factura;
import afip.facturaElectronica.db.dao.GlobalDAO;
import afip.facturaElectronica.handshake.configuracion.FAConfiguracion;
import afip.facturaElectronica.handshake.exceptions.NoExisteFacturaEnLaColeccionException;
import afip.facturaElectronica.handshake.wsfe.FEDetalleResponse;
import afip.facturaElectronica.handshake.wsfe.FEResponse;

/**
 * Se encarga de completar el CAE de los datos recibidos de la AFIP en el objeto que se obtuvo de la DB
 * para luego persistirlo.
 * Si hay error en algúna factura (no tiene CAE) sale por exception para tratar el error
 * @author lagromayor
 *
 */
public abstract class CompletaCAE {
	
	/**
	 * Completa el CAE/Fecha CAE/Estado a las facturas que se obtuvieron de la DB
	 * @param facturas
	 * @param respuestaAFIP
	 * @throws NoExisteFacturaEnLaColeccionException
	 */
	public static void completarCAE(List<Factura> facturas , FEResponse respuestaAFIP)throws NoExisteFacturaEnLaColeccionException{
		FEDetalleResponse[] detalleFacturas =respuestaAFIP.getFedResp();
		
		int x=0;
		
		//recorre el Array con el detalle de las facturas que llegó a la AFIP y lo guardo en las Facturas que llamé de la DB
		while(x<detalleFacturas.length){ 
			Factura factura = devolvemeFactura(facturas, detalleFacturas[x]);
			
			//si el CAE llegó nulo de la AFIP, le seteo el valor de Estado en Error
			//si llegó con CAE lo setea en OK 
			if (detalleFacturas[x].getCae() == null){
				factura.setEstado(FAConfiguracion.getCodigoEstadoError());
			}
			else{
				factura.setCae(Long.valueOf(detalleFacturas[x].getCae()));
				factura.setFecha_vto(detalleFacturas[x].getFecha_vto());
				factura.setEstado(FAConfiguracion.getCodigoEstadoOK());
			}
			
			factura.setMotivo(detalleFacturas[x].getMotivo());
			factura.setResultado(detalleFacturas[x].getResultado());
			
		    x++;
		   }
	}

	/**
	 * busca un detalle de factura (que llegó de la AFIP) en la coleccion de Facturas (que se obtuvieron de la DB)
	 * @param facturas
	 * @param detalleFactura
	 * @return
	 * @throws NoExisteFacturaEnLaColeccionException
	 */
	public static Factura devolvemeFactura(List<Factura> facturas, FEDetalleResponse detalleFactura) throws NoExisteFacturaEnLaColeccionException{
		//sete la factura para buscarla en al colección que me llega por parametro.
		//factura tiene seteado el equals para estos 3 campos
		Factura factura = new Factura();
		factura.setPunto_vta(detalleFactura.getPunto_vta());
		factura.setTipo_cbte(detalleFactura.getTipo_cbte());
		factura.setCbt_desde(detalleFactura.getCbt_desde());
		factura.setCbt_hasta(detalleFactura.getCbt_hasta());
		
		int index = facturas.indexOf(factura);
		if (index < 0){
			System.err.println("No existe la factura: "+detalleFactura.getPunto_vta()+"-"+detalleFactura.getTipo_cbte()+"-"+detalleFactura.getCbt_desde()+"-"+detalleFactura.getCbt_hasta());
			throw new NoExisteFacturaEnLaColeccionException("No existe la factura: "+detalleFactura.getPunto_vta()+"-"+detalleFactura.getTipo_cbte()+"-"+detalleFactura.getCbt_desde()+"-"+detalleFactura.getCbt_hasta());
		}
		Factura facturaOrig =facturas.get( index );
		return facturaOrig;
	}

	/**
	 * Recorre la coleccion de facturas que se está por enviar y le setea el campo ID_ENVIO y el estado de enviado. Luego lo refleja en la base
	 * @param facturas
	 * @param proximoID
	 */
	public static void marcarEnvioFacturas(List<Factura> facturas, long proximoID) {
		for (Iterator<Factura> facturaIter = facturas.iterator(); facturaIter.hasNext();){
			Factura factura;
			factura = facturaIter.next();
			factura.setIdEnvio(proximoID);
			factura.setEstado(FAConfiguracion.getCodigoEstadoEnviado());
		}
		GlobalDAO.getInstance().getFacturaDAO().saveFacturas(facturas);
	}
}
