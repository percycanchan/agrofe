package afip.facturaElectronica.handshake.exceptions;

public class NoPudoObtenerCantidadMaximaException extends GenericModelException{
	private static final long serialVersionUID = 5086647145970550704L;
	Integer codError = null;
	String descError = null;
	
	public NoPudoObtenerCantidadMaximaException(String e){
		super(e);
	}
	
	public NoPudoObtenerCantidadMaximaException(int cod, String e){
		super(e);
		this.codError = cod;
		this.descError = e;
	}

}
