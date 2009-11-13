package afip.facturaElectronica.conexion.tcp.exception;

import afip.facturaElectronica.handshake.exceptions.GenericModelException;

public class ErrorAlLeerXMLException extends GenericModelException {
	private static final long serialVersionUID = 3512566325916937992L;

	public ErrorAlLeerXMLException(String message, Throwable cause) {
		super(message, cause);
	}

	public ErrorAlLeerXMLException(String message) {
		super(message);
	}
}
