package afip.facturaElectronica.conexion.tcp;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

import afip.facturaElectronica.conexion.tcp.exception.ConexionRemotaFinalizadaException;
import afip.facturaElectronica.conexion.tcp.exception.ErrorAlLeerComunicacionException;
import afip.facturaElectronica.conexion.tcp.exception.ErrorAlLeerXMLException;

/**
 * Objeto encargado de realizar la secuencia necesaria para obtener el CAE Lo
 * realiza en un Thead aparte
 * 
 * @author agro
 */
public class ConexionHandler {// implements Runnable {
	SelectionKey skey = null;

	//contructor
	public ConexionHandler(SelectionKey skey) {
		this.skey = skey;
	}
	
	public void leerDatos() {
		try {
			// El socket viene en el evento
			final SocketChannel sock = (SocketChannel) skey.channel();

			// Sacamos la conexion, que viene pegada al evento porque asi la
			// registramos
			final Conexion conn = (Conexion) skey.attachment();

			// este metodo me devuelve true cuando ya se leyo un
			// mensaje completo
			try {
				conn.readData(sock);
				
				//genero un Thread encargado de procesar el encío del cae
				new Thread(new Procesador(skey)).start();
				
			} catch (ConexionRemotaFinalizadaException e) {
				System.out.println("4.conexion cerrada =D");
				cerrarConexion ();
			} catch (ErrorAlLeerComunicacionException e) {
				e.printStackTrace();
				conn.sendData(sock, e.getMessage());
				cerrarConexion ();
			} catch (ErrorAlLeerXMLException e) {
				e.printStackTrace();
				conn.sendData(sock, e.getMessage());
				cerrarConexion ();
			}

			
		} catch (Exception e) {
			skey.cancel();
		}
	}
	
	private void cerrarConexion () throws IOException{
		skey.channel().close();
		skey.cancel();
	}

}
