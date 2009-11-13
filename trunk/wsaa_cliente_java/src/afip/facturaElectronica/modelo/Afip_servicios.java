package afip.facturaElectronica.modelo;

import java.rmi.RemoteException;

import afip.facturaElectronica.db.TipoDeComprobante;
import afip.facturaElectronica.handshake.configuracion.FAConfiguracion;
import afip.facturaElectronica.handshake.exceptions.FaltaConfigCabeceraXMLException;
import afip.facturaElectronica.handshake.exceptions.NoPudoEnviarLoteException;
import afip.facturaElectronica.handshake.exceptions.NoPudoObtenerCantidadMaximaException;
import afip.facturaElectronica.handshake.exceptions.NoPudoObtenerUltimoIDException;
import afip.facturaElectronica.handshake.exceptions.NoPudoObtenerUltimoNumeroFacturaException;
import afip.facturaElectronica.handshake.exceptions.SystemException;
import afip.facturaElectronica.handshake.exceptions.servicioNoDisponibleException;
import afip.facturaElectronica.handshake.tratamientoErrores.TratamientoErrores;
import afip.facturaElectronica.handshake.wsfe.DummyResponse;
import afip.facturaElectronica.handshake.wsfe.FEAuthRequest;
import afip.facturaElectronica.handshake.wsfe.FECabeceraRequest;
import afip.facturaElectronica.handshake.wsfe.FEDetalleRequest;
import afip.facturaElectronica.handshake.wsfe.FELastCMPtype;
import afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse;
import afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse;
import afip.facturaElectronica.handshake.wsfe.FERequest;
import afip.facturaElectronica.handshake.wsfe.FEResponse;
import afip.facturaElectronica.handshake.wsfe.FEUltNroResponse;
import afip.facturaElectronica.handshake.wsfe.ServiceLocator;
import afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub;
import afip.facturaElectronica.serializacion.Serializer;

/**
 * clase que se instancia para procesar las facturas
 * 
 * @author lagromayor
 * 
 */
public class Afip_servicios {
	//actúa como secuenciador del ID que se va a enviar
	Long proximoID = null;
	
	/**
	 * Obtiene la cantidad de facturas que puede recibir la AFIP
	 * 
	 * @return
	 * @throws NoPudoObtenerCantidadMaximaException
	 */
	public Integer getCantidadMaximaRegistros(long cuit)
			throws NoPudoObtenerCantidadMaximaException {
		ServiceSoap12Stub binding;
		try {
			binding = (ServiceSoap12Stub) new ServiceLocator()
					.getServiceSoap12();
		} catch (javax.xml.rpc.ServiceException jre) {
			if (jre.getLinkedCause() != null)
				jre.getLinkedCause().printStackTrace();
			throw new NoPudoObtenerCantidadMaximaException(
					"JAX-RPC ServiceException caught: " + jre);
		}

		// Time out after a minute
		binding.setTimeout(FAConfiguracion.getTiempoEspera());

		// Test operation
		FERecuperaQTYResponse value = null;
		try {
			FEAuthRequest feAuthReq = new FEAuthRequest(cuit);

			value = binding.FERecuperaQTYRequest(feAuthReq);

			// valido que los datos que se encuentran en la respuesta del WS no
			// haya errores
			if (!TratamientoErrores.esRespuestaOK(value.getRError()
					.getPercode())) {
				throw new NoPudoObtenerCantidadMaximaException(value
						.getRError().getPercode(), value.getRError()
						.getPerrmsg());
			}

		} catch (RemoteException e) {
			e.printStackTrace();
			throw new NoPudoObtenerCantidadMaximaException(e.toString());
		} catch (FaltaConfigCabeceraXMLException e) {
			e.printStackTrace();
			throw new NoPudoObtenerCantidadMaximaException(e.toString());
		}

		return value.getQty().getValue();
	}

	/**
	 * Retorna el último ID enviado a la AFIP para una empresa determinada. Se usa como secuenciador en el
	 * envío de lotes
	 * 
	 * @return
	 * @throws NoPudoObtenerUltimoIDException
	 */
	public Long getUltimoID(long cuit) throws NoPudoObtenerUltimoIDException {
		ServiceSoap12Stub binding;
		try {
			binding = (ServiceSoap12Stub) new ServiceLocator()
					.getServiceSoap12();
		} catch (javax.xml.rpc.ServiceException jre) {
			if (jre.getLinkedCause() != null)
				jre.getLinkedCause().printStackTrace();
			throw new NoPudoObtenerUltimoIDException(
					"JAX-RPC ServiceException caught: " + jre);
		}

		// Time out after a minute
		binding.setTimeout(FAConfiguracion.getTiempoEspera());

		FEUltNroResponse value = null;
		try {

			FEAuthRequest feAuthReq = new FEAuthRequest(cuit);

			value = binding.FEUltNroRequest(feAuthReq);

			// valido que los datos que se encuentran en la respuesta del WS no
			// haya errores
			if (!TratamientoErrores.esRespuestaOK(value.getRError()
					.getPercode())) {
				throw new NoPudoObtenerUltimoIDException(value.getRError()
						.getPercode(), value.getRError().getPerrmsg());
			}

		} catch (RemoteException e) {
			e.printStackTrace();
			throw new NoPudoObtenerUltimoIDException(e.toString());
		} catch (FaltaConfigCabeceraXMLException e) {
			e.printStackTrace();
			throw new NoPudoObtenerUltimoIDException(e.toString());
		}

		return value.getNro().getValue();
	}

	/**
	 * Retorna el próximo ID enviado a la AFIP. Se usa como secuenciador en el
	 * envío de lotes. Por cada llamada se incrementa en 1
	 * 
	 * @return
	 * @throws NoPudoObtenerUltimoIDException
	 */
	public long getProximoID(long cuit) throws NoPudoObtenerUltimoIDException {
		if (proximoID == null){
			proximoID = getUltimoID(cuit)+1;
			return proximoID;
		}
		proximoID += 1;
		return proximoID;
	}

	/**
	 * Envía un conjunto de Facturas a la AFIP. Recibe por parámetro la
	 * colección del tipo FEDetalleRequest y devuelve el objeto FEResponse.
	 * 
	 * @param feDetalles
	 * @return
	 */
	public FEResponse enviarFacturas(Comprobante cpr, long idEnvio) //long cuit , List<Factura> feDetalles)
			throws NoPudoEnviarLoteException {
		
		int cantFacturas;
		
		Serializer xml = new Serializer();
		ServiceSoap12Stub binding;
		try {
			binding = (ServiceSoap12Stub) new ServiceLocator()
					.getServiceSoap12();
		} catch (javax.xml.rpc.ServiceException jre) {
			if (jre.getLinkedCause() != null)
				jre.getLinkedCause().printStackTrace();
			throw new NoPudoEnviarLoteException(
					"JAX-RPC ServiceException caught: " + jre);
		}

		// Time out after a minute
		binding.setTimeout(FAConfiguracion.getTiempoEspera());
		Long proximoID;
		FEResponse value = null;
		
		// Seteo los datos de Autenticación. Lo hace al instanciar la clase
		FEAuthRequest feAuth = new FEAuthRequest(cpr.getCuit());
		try {
			cantFacturas = cpr.getFacturas().size();
			proximoID = idEnvio;
			
			// Seteo la cabecera
			FECabeceraRequest feCabecera = new FECabeceraRequest();
			feCabecera.setCantidadreg(cantFacturas);
			feCabecera.setId(proximoID);
			feCabecera.setPresta_serv(FAConfiguracion.getCodigoServicio());

			// Seteo el detalle
			FERequest feReq = new FERequest();

			FEDetalleRequest feDetallesArray[];
			feDetallesArray = new FEDetalleRequest[cantFacturas];
			cpr.getFacturas().toArray(feDetallesArray);

			feReq.setFecr(feCabecera);
			feReq.setFedr(feDetallesArray);

			
			
			// envío el lote
			xml.escribirContainer(feAuth, feReq);
			value = binding.FEAutRequest(feAuth, feReq);
			xml.escribirContainer(value);
			
			// valido que los datos que se encuentran en la respuesta del WS no
			// haya errores
			if (!TratamientoErrores.esRespuestaOK(value.getRError()
					.getPercode())) {
				throw new NoPudoEnviarLoteException(value.getRError()
						.getPercode(), value.getRError().getPerrmsg());
			}

		} catch (RemoteException e) {
			e.printStackTrace();
			throw new NoPudoEnviarLoteException(e.toString());
		}

		return value;
	}

	public Integer getUltimoNroComprobante(TipoDeComprobante comprobante)
			throws NoPudoObtenerUltimoNumeroFacturaException {
		ServiceSoap12Stub binding;
		try {
			binding = (ServiceSoap12Stub) new ServiceLocator()
					.getServiceSoap12();
		} catch (javax.xml.rpc.ServiceException jre) {
			if (jre.getLinkedCause() != null)
				jre.getLinkedCause().printStackTrace();
			throw new NoPudoObtenerUltimoNumeroFacturaException(
					"JAX-RPC ServiceException caught: " + jre);
		}
		// Time out after a minute
		binding.setTimeout(FAConfiguracion.getTiempoEspera());

		FERecuperaLastCMPResponse value = null;
		FEAuthRequest feAut = new FEAuthRequest(comprobante.getComprobantePK().getCuit());
		FELastCMPtype ultimoCpr = new FELastCMPtype(comprobante.getComprobantePK().getPunto_vta()
				                                   ,comprobante.getComprobantePK().getTipo_cbte());

		try {
			value = binding.FERecuperaLastCMPRequest(feAut, ultimoCpr);

			// valido que los datos que se encuentran en la respuesta del WS no
			// haya errores
			if (!TratamientoErrores.esRespuestaOK(value.getRError()
					.getPercode())) {
				throw new NoPudoObtenerUltimoNumeroFacturaException(value
						.getRError().getPercode(), value.getRError()
						.getPerrmsg());
			}

		} catch (RemoteException e) {
			e.printStackTrace();
			throw new NoPudoObtenerUltimoNumeroFacturaException(e.toString());
		}

		return value.getCbte_nro();
	}

	public void servicioDisponible() throws servicioNoDisponibleException {
		ServiceSoap12Stub binding;

		try {
			binding = (ServiceSoap12Stub) new ServiceLocator()
					.getServiceSoap12();
		} catch (javax.xml.rpc.ServiceException jre) {
			if (jre.getLinkedCause() != null)
				jre.getLinkedCause().printStackTrace();
			throw new SystemException("JAX-RPC ServiceException caught: " + jre);
		}
		
		DummyResponse value = null;
		//value.getAppserver();
		try {
			// Time out after a minute
			binding.setTimeout(FAConfiguracion.getTiempoEspera());

			value = binding.FEDummy();
			
			if (   !(value.getAppserver().equalsIgnoreCase("OK"))
				|| !(value.getAuthserver().equalsIgnoreCase("OK"))
				|| !(value.getDbserver().equalsIgnoreCase("OK"))
			   )
			{
				throw new servicioNoDisponibleException("Aplicación: "+value.getAppserver()
						                               +" Autenticación: "+value.getAuthserver()
						                               +" Base de Datos: "+value.getDbserver()
						                               );
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new SystemException(e.toString());
		}

		//return estaDisponible;
	}

	/**
	 * Encargado de realizar la inicialización del servicio
	 * @throws servicioNoDisponibleException 
	 */
	public void inicializar() throws servicioNoDisponibleException {
		// verifico que el sevicio de WS esté Disponible
		servicioDisponible();
		
		// TODO: debería verificar si el ID del envío es general (el mismo secuenciador 
		// para todas las empresas) o es un ID individual (uno por empresa)
		//getProximoID(cuit)
		
	}
}
