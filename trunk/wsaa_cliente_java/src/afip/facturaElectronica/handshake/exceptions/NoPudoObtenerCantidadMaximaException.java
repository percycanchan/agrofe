package afip.facturaElectronica.handshake.exceptions;

public class NoPudoObtenerCantidadMaximaException extends GenericModelException{
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
