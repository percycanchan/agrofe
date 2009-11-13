package afip.facturaElectronica.conexion.tcp;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import afip.facturaElectronica.conexion.tcp.exception.ConexionRemotaFinalizadaException;
import afip.facturaElectronica.conexion.tcp.exception.ErrorAlLeerComunicacionException;
import afip.facturaElectronica.conexion.tcp.exception.ErrorAlLeerXMLException;

public class Conexion { // ya no tiene que ser Runnable
	Mensaje mensaje;
	//SocketChannel sock;
	
	/*@SuppressWarnings("unused")
	private Conexion(){}
	
	public Conexion(SocketChannel sock){
		this.sock = sock;
	}*/

	/**
	 * Lee los datos que llegan por el canal de comunicaicones
	 * @throws ConexionRemotaFinalizadaException
	 */
	public void readData(SocketChannel sock) 
		throws  ConexionRemotaFinalizadaException, ErrorAlLeerXMLException, ErrorAlLeerComunicacionException
	{		

		int cantLeida;
		String xmlAProcesar = "";
		// Aqui vamos a ir metiendo los datos que vengan del socket
		ByteBuffer buf = ByteBuffer.allocate(1024);

		// Aqui nada mas leemos lo que venga por el canal de comunicaciones TCP
		try {
			buf.clear();
	
			for (;;) {
				cantLeida = sock.read(buf);
		
				//Si la cantidad leida el -1 => la conexión desde el host fue finalizada
				if (cantLeida == -1){
					throw new ConexionRemotaFinalizadaException("Conexión Finalizada");
				}

					//Comienzo a leer la entrada de datos (llega un XML)
					buf.rewind();
					Charset charset = Charset.forName("UTF-8");
					CharsetDecoder decoder = charset.newDecoder();
					xmlAProcesar += (decoder.decode(buf).toString().substring(0, cantLeida));	
					
					if (! buf.hasRemaining()){
						break;
					}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new ErrorAlLeerComunicacionException("Error al leer la entrada de datos", e);
		}
		
		mensaje = new Mensaje(xmlAProcesar);
	}

	/**
	 * Devuelve el mensaje leido del canal de comunicacionesTCP
	 * @return
	 */
	public Mensaje getMensaje() {
		return mensaje;
	}

	/**
	 * Encargado de enviar datos al Host
	 * @param sock
	 * @param message
	 */
	public void sendData(SocketChannel sock, String mensaje) throws IOException {
		ByteBuffer buf = ByteBuffer.allocate(1024);
		CharBuffer enviar = CharBuffer.allocate(1024);
		
		// le metemos los datos al buffer y luego hay que prepararlo para
		// escritura
		buf.flip();
		
		enviar.put(mensaje);
		enviar.rewind();
		Charset charset = Charset.forName("UTF-8");
		CharsetEncoder encoder = charset.newEncoder();
		
		try {
			buf = encoder.encode(enviar) ;
		} catch (CharacterCodingException e1) {
			e1.printStackTrace();
		}
		while (buf.hasRemaining()) {
			sock.write(buf);		
		}
		sock.write(encoder.encode(CharBuffer.wrap(""+'\r'+'\n' )));

	}
}