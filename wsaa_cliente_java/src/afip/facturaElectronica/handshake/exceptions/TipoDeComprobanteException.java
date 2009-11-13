package afip.facturaElectronica.handshake.exceptions;

import afip.facturaElectronica.db.TipoDeComprobante;

/**
 * Exception cuando no hay Comprobantes para obtener el CAE
 * @author Agro
 *
 */
public class TipoDeComprobanteException extends GenericModelException{
	private static final long serialVersionUID = 7854823467722674977L;
	public TipoDeComprobante cpr = null;
	
	public TipoDeComprobanteException(String e){
		super(e);
	}
	
	public TipoDeComprobanteException(TipoDeComprobante pcpr, String desc){
		super(desc);
		this.cpr = pcpr;

	}

}
