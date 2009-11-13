package afip.facturaElectronica.conexion.tcp;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

import afip.facturaElectronica.handshake.exceptions.ComprobanteException;
import afip.facturaElectronica.handshake.exceptions.TipoDeComprobanteException;
import afip.facturaElectronica.modelo.Comprobante;
import afip.facturaElectronica.modelo.cola.ComprobantesAProcesar;

/**
 * es el encargado de realizar el pedido de CAE
 * 
 * @author BETY
 * 
 */
public class Procesador extends Thread {
	private SelectionKey skey;
	private Conexion conn;
	private SocketChannel sock;

	public Procesador(SelectionKey skey) {
		this.skey = skey;
		conn = (Conexion) skey.attachment();
		sock  = (SocketChannel) skey.channel();
	}

	// Este es nuestro componente que procesa todas las peticiones
	public void run() {
		try {
			// genero un comprobante
			Comprobante comprobante;
			try {
				comprobante = new Comprobante(conn.getMensaje().getTipoDeComprobante()
						, skey
						, ComprobantesAProcesar.getInstance());

				// agrego el comprobante en la cola de pendientes a procesar. Se
				// queda en la cola hasta que Thead de ServiciosAFIP lo solicite
				// para procesarlo
				comprobante.addComprobante();
			} catch (TipoDeComprobanteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ComprobanteException e) {
				e.printStackTrace();
				conn.sendData(sock, e.getMessage());
			} catch (InterruptedException e) {
				e.printStackTrace();
				conn.sendData(sock, e.getMessage());
			}
		} catch (IOException e) {
			// TODO: cerrar la conexion
			e.printStackTrace();
		}
	}

	public Conexion getConn() {
		return conn;
	}

	public SocketChannel getSock() {
		return sock;
	}
}