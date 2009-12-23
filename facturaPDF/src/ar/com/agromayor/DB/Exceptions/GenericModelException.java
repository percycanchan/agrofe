package ar.com.agromayor.DB.Exceptions;

/**
 * Exception para modelar los errores. Wrappiable
 * @author lagromayor
 *
 */
public abstract class GenericModelException extends Exception {
	private static final long serialVersionUID = -567623999630063496L;

	public GenericModelException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericModelException(String message) {
		super(message);
	}
	
	public GenericModelException(Exception message) {
		super(message);
	}
	
	public GenericModelException() {
		super();
	}
		
}
