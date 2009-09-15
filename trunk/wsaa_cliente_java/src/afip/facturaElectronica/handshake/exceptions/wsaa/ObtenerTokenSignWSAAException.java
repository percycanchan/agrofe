package afip.facturaElectronica.handshake.exceptions.wsaa;

import afip.facturaElectronica.handshake.exceptions.SystemException;

public class ObtenerTokenSignWSAAException extends SystemException
{
	private static final long serialVersionUID = 2331599882238518468L;

	public ObtenerTokenSignWSAAException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ObtenerTokenSignWSAAException(String message)
	{
		super(message);
	}
}
