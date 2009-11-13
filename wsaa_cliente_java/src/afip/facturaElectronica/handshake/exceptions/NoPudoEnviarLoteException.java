package afip.facturaElectronica.handshake.exceptions;

public class NoPudoEnviarLoteException extends GenericModelException{
	private static final long serialVersionUID = 8211994042800112260L;
	Integer codError = null;
	String descError = null;
	
	public NoPudoEnviarLoteException(String e){
		super(e);
	}
	
	public NoPudoEnviarLoteException(int cod, String e){
		super(e);
		this.codError = cod;
		this.descError = e;
	}

}
