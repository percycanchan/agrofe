package afip.facturaElectronica.conexion.tcp.respuestas;

public class RespuestaTCPError extends RespuestaTCP {
	String mensaje;
	Throwable error;
	
	public RespuestaTCPError(String mensaje, Throwable error){
		this.mensaje = mensaje;
		this.error = error;
	}
	

	@Override
	public String getRespuestaXML() {
		return "Error: "+mensaje;
	}

}
