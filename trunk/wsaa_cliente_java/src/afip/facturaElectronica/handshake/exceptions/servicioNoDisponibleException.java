package afip.facturaElectronica.handshake.exceptions;

public class servicioNoDisponibleException extends GenericModelException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7212423779163648610L;
	Integer codError = null;
	String descError = null;
	
	public servicioNoDisponibleException(String e){
		super(e);
	}
	
	public servicioNoDisponibleException(int cod, String e){
		super(e);
		this.codError = cod;
		this.descError = e;

	}

}
