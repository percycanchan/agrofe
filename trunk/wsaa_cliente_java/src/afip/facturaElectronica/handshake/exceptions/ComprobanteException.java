package afip.facturaElectronica.handshake.exceptions;

import afip.facturaElectronica.db.TipoDeComprobante;

/**
 * Exception cuando se realiza una acción inválida
 * @author Agro
 *
 */
public class ComprobanteException extends GenericModelException{
	private static final long serialVersionUID = 7854823467722674977L;
	public TipoDeComprobante cpr = null;
	
	public ComprobanteException(String e){
		super(e);
	}
	
	public ComprobanteException(TipoDeComprobante pcpr, String desc){
		super(desc);
		this.cpr = pcpr;

	}

}
