package ar.com.agromayor.DB.Exceptions;


public class NoHayMasFacturasExcetion extends GenericModelException{
	private static final long serialVersionUID = 5086647145970550704L;
	Integer codError = null;
	String descError = null;
	
	public NoHayMasFacturasExcetion(String e){
		super(e);
	}
	
	public NoHayMasFacturasExcetion(){
	}
	
	public NoHayMasFacturasExcetion(int cod, String e){
		super(e);
		this.codError = cod;
		this.descError = e;
	}

}
