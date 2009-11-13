package afip.facturaElectronica.handshake.exceptions;

public class NoPudoObtenerUltimoNumeroFacturaException extends GenericModelException{
	private static final long serialVersionUID = 6380565444978179405L;
	Integer codError = null;
	String descError = null;
	
	public NoPudoObtenerUltimoNumeroFacturaException(String e){
		super(e);
	}
	
	public NoPudoObtenerUltimoNumeroFacturaException(int cod, String e){
		super(e);
		this.codError = cod;
		this.descError = e;

	}

}
