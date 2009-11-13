package afip.facturaElectronica.handshake.exceptions;


/**
 * Exception para modelar errores. No Wrappiable
 * @author lagromayor
 *
 */
public class SystemException extends RuntimeException {
	private static final long serialVersionUID = 6363972660660445549L;

	public SystemException(String message, Throwable obj) {
		super(message, obj);
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(Throwable obj) {
		super(obj);
	}
	
/*	public void grabarException(String excep){
		
		SimpleDateFormat dateformat = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss"); 
		
		try {
			FileWriter fw = new FileWriter(FAConfiguracion.getPathLog()+"logError_"+dateformat +".txt", true);
			BufferedWriter bw = new BufferedWriter(fw);;
			PrintWriter salida = new PrintWriter(bw);
		
			salida.println(excep);
			salida.close();
			
		} catch (java.io.IOException ioex) {
			System.out.println("se presento el error al grabar logError: "
					+ ioex.toString());
		}
	}
	*/
}
