package afip.facturaElectronica.conexion.tcp;

import java.io.Reader;
import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import afip.facturaElectronica.conexion.tcp.exception.ErrorAlLeerXMLException;
import afip.facturaElectronica.db.TipoDeComprobante;
import afip.facturaElectronica.handshake.exceptions.TipoDeComprobanteException;

public class Mensaje {
	private String mensaje;
	private TipoDeComprobante tipoDeCpr;
	

	public Mensaje(String xml) throws ErrorAlLeerXMLException {
		mensaje = xml;
		extraerTipoDeComprobante();
	}
	
	private void extraerTipoDeComprobante() throws ErrorAlLeerXMLException{
  		//extraigo los datos del XML
		try{
			Reader tokenReader = new StringReader(mensaje);
			Document tokenDoc = new SAXReader(false).read(tokenReader);

			long cuit = Long.parseLong(tokenDoc.valueOf("/pedirCAE/cuit"));	
			int tipoCpr = Integer.parseInt(tokenDoc.valueOf("/pedirCAE/tipoCpr"));
			int puntoVta = Integer.parseInt(tokenDoc.valueOf("/pedirCAE/puntoVta"));
			tipoDeCpr = new TipoDeComprobante(cuit, tipoCpr, puntoVta);
		} catch(DocumentException e) {
			throw new ErrorAlLeerXMLException("Error al leer el XML",e);
		} catch (TipoDeComprobanteException e){
			throw new ErrorAlLeerXMLException("Error al generar el Tipo de Comprobante desde el XML",e);
		}		
	}

	public String getMensaje() {
		return mensaje;
	}


	public TipoDeComprobante getTipoDeComprobante() {
		return tipoDeCpr;
	}

/*	public byte[] codifica() {
		return mensaje.getBytes();
	}*/
	
}
