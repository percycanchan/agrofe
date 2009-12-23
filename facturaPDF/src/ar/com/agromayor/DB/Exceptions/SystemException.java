package ar.com.agromayor.DB.Exceptions;


/**
 * Exception para modelar errores. No Wrappiable
 * @author lagromayor
 *
 */
public class SystemException extends RuntimeException {
	private static final long serialVersionUID = 6363972660660445549L;

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
