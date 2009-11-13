package afip.facturaElectronica.conexion.tcp.exception;

import afip.facturaElectronica.handshake.exceptions.GenericModelException;

public class ErrorAlLeerComunicacionException extends GenericModelException {
	private static final long serialVersionUID = 8913837569963496911L;

	public ErrorAlLeerComunicacionException(String message, Throwable cause) {
		super(message, cause);
	}

	public ErrorAlLeerComunicacionException(String message) {
		super(message);
	}
}
