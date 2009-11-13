package afip.facturaElectronica.modelo;

import afip.facturaElectronica.conexion.tcp.respuestas.RespuestaTCPError;
import afip.facturaElectronica.conexion.tcp.respuestas.RespuestaTCPOk;
import afip.facturaElectronica.handshake.exceptions.NoExisteFacturaEnLaColeccionException;
import afip.facturaElectronica.handshake.exceptions.NoHayComprobantesPendientesException;
import afip.facturaElectronica.handshake.exceptions.NoPudoEnviarLoteException;
import afip.facturaElectronica.handshake.exceptions.NoPudoObtenerUltimoIDException;
import afip.facturaElectronica.handshake.exceptions.servicioNoDisponibleException;
import afip.facturaElectronica.handshake.wsfe.FEResponse;
import afip.facturaElectronica.modelo.cola.ComprobantesAProcesar;

public class WSHandler extends Thread {

	public void run() {
		Afip_servicios wsServicios = new Afip_servicios();
		Comprobante cpr = null;
		FEResponse respuestaAFIP = null;

		try {

			// verifico que el servicio WS esté disponible
			boolean noDisponible = true;
			while (noDisponible) {
				try {
					wsServicios.inicializar();
					noDisponible = false;
				} catch (servicioNoDisponibleException e) {
					sleep(60000);
				}
			}
			
			// quedo loopeando esperando hasta que haya elementos que procesar
			while (!Thread.currentThread().isInterrupted()) {
				try {
					// obtengo los comprobantes de la DB y los marco en estado
					// Enviando
					// TODO: falta hacer un secuenciador para el ID que se
					// inicializa. VERIFICAR SI ES UN ID UNICO PARA TODAS LAS
					// EMPRESAS O UN SECUENCIADOR PARA CADA EMRESA
					cpr = ComprobantesAProcesar.getInstance().getPendientes();
				
					long idEnvio = wsServicios.getProximoID(cpr.getCuit());
					cpr.prepararTandaDeFacturas(idEnvio);

					// Cuando hay Comprobantes para procesar los envío a la AFIP
					respuestaAFIP = wsServicios.enviarFacturas(cpr, idEnvio);

					// completo el CAE en la colección de facturas
					cpr.grabarRespuestaAFIP(respuestaAFIP);

					// envío la respuesta de OK
					cpr.enviarDatos(new RespuestaTCPOk());
				} catch (NoHayComprobantesPendientesException e) {
					// si llegó hasta acá es que no hay comprobantes para pedir.
					// Deberia rechazar la conexión
					cpr.enviarDatos(new RespuestaTCPError(
							"No hay Comprobantes pendientes de Aprobar", e));
					e.printStackTrace();
				} catch (NoPudoEnviarLoteException e) {
					// si no pudo enviar el lote debo volverlos a estado
					// pendiente.
					// avisarle a todas las conexiones del error para que lo
					// soluciones.
					cpr.enviarDatos(new RespuestaTCPError(
							"No pudo enviar el Lote", e));
					e.printStackTrace();
				} catch (NoExisteFacturaEnLaColeccionException e) {
					cpr.enviarDatos(new RespuestaTCPError(
							"Se produjo un error al grabar los datos del CAE",
							e));
					e.printStackTrace();
				} catch (NoPudoObtenerUltimoIDException e) {
					// por algún motivo no pudo obtener el último ID
					cpr.enviarDatos(new RespuestaTCPError(
							"No se pudo obtener el Secuenciador desde la AFIP",
							e));
					e.printStackTrace();
				}
			} // fin While

		} catch (InterruptedException e) {
			// si hay una interrupción deberia validar algúna variable de
			// que el servicio se quiere stopear
			ComprobantesAProcesar.getInstance().enviarDatosATodosLosComprobantes(new RespuestaTCPError(
					"Se detuvo el servicio de Obtención de CAE", e));
			e.printStackTrace();
			System.exit(-1);
		}

	}
}
