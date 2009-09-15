package afip.facturaElectronica.handshake.exceptions.wsaa;

import afip.facturaElectronica.handshake.exceptions.SystemException;

public class GenerarTicketWSAAException extends SystemException
{
	private static final long serialVersionUID = 2331599882238518468L;

	public GenerarTicketWSAAException(String message, Throwable cause)
	{
		super(message, cause);
		grabarException(message);
	}

	public GenerarTicketWSAAException(String message)
	{
		super(message);
		grabarException(message);
	}
	
}
