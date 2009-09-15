package afip.facturaElectronica.handshake.exceptions.wsaa;

import afip.facturaElectronica.handshake.exceptions.SystemException;

public class NoPudoConectarWSAAException extends SystemException
{
	private static final long serialVersionUID = 2331599882238518468L;

	public NoPudoConectarWSAAException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public NoPudoConectarWSAAException(String message)
	{
		super(message);
	}
}
