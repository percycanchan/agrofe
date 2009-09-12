package afip.facturaElectronica.modelo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import sun.awt.SunHints.Value;

import afip.facturaElectronica.db.Factura;
import afip.facturaElectronica.db.commons.CompletaCAE;
import afip.facturaElectronica.handshake.configuracion.FAConfiguracion;
import afip.facturaElectronica.handshake.exceptions.FaltaConfigCabeceraXMLException;
import afip.facturaElectronica.handshake.exceptions.NoPudoEnviarLoteException;
import afip.facturaElectronica.handshake.exceptions.NoPudoObtenerCantidadMaximaException;
import afip.facturaElectronica.handshake.exceptions.NoPudoObtenerUltimoIDException;
import afip.facturaElectronica.handshake.exceptions.NoPudoObtenerUltimoNumeroFacturaException;
import afip.facturaElectronica.handshake.exceptions.SystemException;
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

/**
 * clase que se instancia para procesar las facturas
 * 
 * @author lagromayor
 * 
 */
public class Afip_servicios {

	/**
	 * Obtiene la cantidad de facturas que puede recibir la AFIP
	 * 
	 * @return
	 * @throws NoPudoObtenerCantidadMaximaException
	 */
	public Integer getCantidadMaximaRegistros()
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
		binding.setTimeout(FAConfiguracion.getInstance().getTiempoEspera());

		// Test operation
		FERecuperaQTYResponse value = null;
		try {
			FEAuthRequest feAuthReq = new FEAuthRequest();

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
	 * Retorna el último ID enviado a la AFIP. Se usa como secuenciador en el
	 * envío de lotes
	 * 
	 * @return
	 * @throws NoPudoObtenerUltimoIDException
	 */
	public Long getUltimoID() throws NoPudoObtenerUltimoIDException {
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
		binding.setTimeout(FAConfiguracion.getInstance().getTiempoEspera());

		FEUltNroResponse value = null;
		try {

			FEAuthRequest feAuthReq = new FEAuthRequest();

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
	 * envío de lotes
	 * 
	 * @return
	 * @throws NoPudoObtenerUltimoIDException
	 */
	public Long getProximoID() throws NoPudoObtenerUltimoIDException {
		return getUltimoID() + 1;
	}

	/**
	 * Envía un conjunto de Facturas a la AFIP. Recibe por parámetro la
	 * colección del tipo FEDetalleRequest y devuelve el objeto FEResponse.
	 * 
	 * @param feDetalles
	 * @return
	 */
	public FEResponse enviarFacturas(List<Factura> feDetalles)
			throws NoPudoEnviarLoteException {
		
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
		binding.setTimeout(FAConfiguracion.getInstance().getTiempoEspera());
		Long proximoID;
		FEResponse value = null;

		// Seteo los datos de Autenticación. Lo hace al instanciar la clase
		FEAuthRequest feAuth = new FEAuthRequest();
		try {
			proximoID = getProximoID();
			CompletaCAE.marcarEnvioFacturas(feDetalles, proximoID);
			
			// Seteo la cabecera
			FECabeceraRequest feCabecera = new FECabeceraRequest();
			feCabecera.setCantidadreg(feDetalles.size());
			feCabecera.setId(proximoID);
			feCabecera.setPresta_serv(FAConfiguracion.getCodigoServicio());

			// Seteo el detalle
			FERequest feReq = new FERequest();

			FEDetalleRequest feDetallesArray[];
			feDetallesArray = new FEDetalleRequest[feDetalles.size()];
			feDetalles.toArray(feDetallesArray);

			feReq.setFecr(feCabecera);
			feReq.setFedr(feDetallesArray);

			// envío el lote
			value = binding.FEAutRequest(feAuth, feReq);

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
		} catch (NoPudoObtenerUltimoIDException e) {
			e.printStackTrace();
			throw new NoPudoEnviarLoteException(e.toString());
		}

		return value;
	}

	public Integer getUltimoNroComprobante(Integer sucursal,
			Integer tipoComprobante)
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
		binding.setTimeout(FAConfiguracion.getInstance().getTiempoEspera());

		FERecuperaLastCMPResponse value = null;
		FEAuthRequest feAut = new FEAuthRequest();
		FELastCMPtype ultimoCpr = new FELastCMPtype(sucursal, tipoComprobante);

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

	@SuppressWarnings("null")
	public boolean servicioDisponible() {
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
		value.getAppserver();
		try {
			// Time out after a minute
			binding.setTimeout(FAConfiguracion.getInstance().getTiempoEspera());

			value = binding.FEDummy();
			// TBD - validate results
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new SystemException(e.toString());
		}

		return true;
	}
}
