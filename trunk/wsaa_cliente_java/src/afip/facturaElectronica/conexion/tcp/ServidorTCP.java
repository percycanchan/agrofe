package afip.facturaElectronica.conexion.tcp;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class ServidorTCP extends Thread  {
	public void run() {
		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			
			// esto es importante. Es para que no sea loqueante al manejar las conexiones
			server.configureBlocking(false); 
			Selector sel = Selector.open();
			
			// registramos para recibir aviso cuando lleguen conexiones nuevas
			server.register(sel, SelectionKey.OP_ACCEPT); 
			server.socket().bind(new InetSocketAddress(6001));

			while (true) {
				// Este metodo bloquea hasta que pase algo
				sel.select();

				// Llegamos aqui cuando ya entra una conexion o hay datos que
				// leer
				for (Iterator<SelectionKey> iter = sel.selectedKeys()
						.iterator(); iter.hasNext();) {

					// Esta llave nos dice que es lo que esta pasando
					SelectionKey skey = iter.next();
					// Hay que quitar el evento del iterador
					iter.remove();
					
					//Acepto una conexión nueva
					if ((skey.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {

						// hay una conexion entrante, hay que aceptarla
						SocketChannel sock = server.accept();

						// Creamos la conexion y la registramos con el selector y el socket.
						// notese que la conexion no sabe nada del socket aqui
						Conexion conn = new Conexion();
						sock.configureBlocking(false);
						sock.register(sel, SelectionKey.OP_READ , conn);

					//Manejo las Escrituras que realizan las conexiones sobre el canal de comunicaciones
					} else if ((skey.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
						(new ConexionHandler(skey)).leerDatos();
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}