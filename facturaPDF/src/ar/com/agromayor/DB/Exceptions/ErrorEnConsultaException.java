package ar.com.agromayor.DB.Exceptions;


public class ErrorEnConsultaException extends GenericModelException{
	private static final long serialVersionUID = 5086647145970550704L;
	Integer codError = null;
	String descError = null;
	
	public ErrorEnConsultaException(String e){
		super(e);
	}
	
	public ErrorEnConsultaException(Exception e){
		super(e);
	}
	
	public ErrorEnConsultaException(){
	}
	
	public ErrorEnConsultaException(int cod, String e){
		super(e);
		this.codError = cod;
		this.descError = e;
	}

}
