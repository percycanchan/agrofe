package afip.facturaElectronica.handshake.exceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import afip.facturaElectronica.handshake.configuracion.FAConfiguracion;

/**
 * Exception para modelar errores. No Wrappiable
 * @author lagromayor
 *
 */
public class SystemException extends RuntimeException {

	public SystemException(String message, Throwable obj) {
		super(message, obj);
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(Throwable obj) {
		super(obj);
	}
	
	public void grabarException(String excep){
		
		SimpleDateFormat dateformat = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss"); 
		
		try {
			FileWriter fw = new FileWriter(FAConfiguracion.getInstance().getPathLog()+"logError_"+dateformat +".txt", true);
			BufferedWriter bw = new BufferedWriter(fw);;
			PrintWriter salida = new PrintWriter(bw);
		
			salida.println(excep);
			salida.close();
			
		} catch (java.io.IOException ioex) {
			System.out.println("se presento el error al grabar logError: "
					+ ioex.toString());
		}
	}
	
}
