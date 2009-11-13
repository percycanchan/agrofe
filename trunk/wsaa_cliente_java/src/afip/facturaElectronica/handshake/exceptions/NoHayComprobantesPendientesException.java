package afip.facturaElectronica.handshake.exceptions;

import afip.facturaElectronica.db.TipoDeComprobante;

/**
 * Exception cuando no hay Comprobantes para obtener el CAE
 * @author Agro
 *
 */
public class NoHayComprobantesPendientesException extends GenericModelException{
	private static final long serialVersionUID = 7854823467722674977L;
	public TipoDeComprobante cpr = null;
	
	public NoHayComprobantesPendientesException(String e){
		super(e);
	}
	
	public NoHayComprobantesPendientesException(TipoDeComprobante pcpr, String desc){
		super(desc);
		this.cpr = pcpr;

	}

}
