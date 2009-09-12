package afip.facturaElectronica.handshake.exceptions;

/**
 * Exception para modelar los errores. Wrappiable
 * @author lagromayor
 *
 */
public abstract class GenericModelException extends Exception {

	public GenericModelException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericModelException(String message) {
		super(message);
	}
		
}
