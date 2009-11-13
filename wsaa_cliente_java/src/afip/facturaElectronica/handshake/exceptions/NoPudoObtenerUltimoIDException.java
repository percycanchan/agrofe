package afip.facturaElectronica.handshake.exceptions;

public class NoPudoObtenerUltimoIDException extends GenericModelException{
	private static final long serialVersionUID = 8560524699812521807L;
	Integer codError = null;
	String descError = null;
	
	public NoPudoObtenerUltimoIDException(String e){
		super(e);
	}
	
	public NoPudoObtenerUltimoIDException(int cod, String e){
		super(e);
		this.codError = cod;
		this.descError = e;

	}

}
