package ar.com.agromayor.portal.db.exceptions;


public class DBExcetion extends GenericModelException{
	private static final long serialVersionUID = 5086647145970550704L;
	Integer codError = null;
	String descError = null;
	
	public DBExcetion(String e){
		super(e);
	}

	public DBExcetion(Exception e){
		super(e);
	}
	
	public DBExcetion(){
	}
	
	public DBExcetion(int cod, String e){
		super(e);
		this.codError = cod;
		this.descError = e;
	}

}
