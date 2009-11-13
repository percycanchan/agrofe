package afip.facturaElectronica.handshake.exceptions;

public class NoExisteFacturaEnLaColeccionException extends GenericModelException{
	private static final long serialVersionUID = 4250318254907753198L;
	Integer codError = null;
	String descError = null;
	
	public NoExisteFacturaEnLaColeccionException(String e){
		super(e);
	}
	
	public NoExisteFacturaEnLaColeccionException(int cod, String e){
		super(e);
		this.codError = cod;
		this.descError = e;

	}

}
