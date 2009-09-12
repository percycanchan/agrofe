package afip.facturaElectronica.handshake.exceptions;

/**
 * Exception para modelar errores. No Wrappiable
 * @author lagromayor
 *
 */
public class SystemException extends RuntimeException {

	public SystemException(String message, Throwable obj) {
		super(message, obj);
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(Throwable obj) {
		super(obj);
	}
	
}
