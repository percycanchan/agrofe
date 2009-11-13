package afip.facturaElectronica.conexion.tcp.respuestas;

public class RespuestaTCPOk extends RespuestaTCP {



	@Override
	public String getRespuestaXML() {
		return "OK";
	}

}
