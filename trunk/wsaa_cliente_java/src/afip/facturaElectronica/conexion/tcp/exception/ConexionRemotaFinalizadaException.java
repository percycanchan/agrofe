package afip.facturaElectronica.conexion.tcp.exception;

import afip.facturaElectronica.handshake.exceptions.GenericModelException;

public class ConexionRemotaFinalizadaException extends GenericModelException {
	private static final long serialVersionUID = -6376763718454875850L;

	public ConexionRemotaFinalizadaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConexionRemotaFinalizadaException(String message) {
		super(message);
	}
}
