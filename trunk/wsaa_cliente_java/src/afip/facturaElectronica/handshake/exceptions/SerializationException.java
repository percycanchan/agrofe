package afip.facturaElectronica.handshake.exceptions;

public class SerializationException extends SystemException
{
	private static final long serialVersionUID = 2331599882238519468L;

	public SerializationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public SerializationException(String message)
	{
		super(message);
	}
}
