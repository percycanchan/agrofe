package afip.facturaElectronica.handshake.wsaa;

import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import afip.facturaElectronica.handshake.configuracion.FAConfiguracion;
import afip.facturaElectronica.handshake.exceptions.FaltaConfigCabeceraXMLException;
import afip.facturaElectronica.handshake.exceptions.wsaa.NoPudoConectarWSAAException;
import afip.facturaElectronica.handshake.exceptions.wsaa.ObtenerTokenSignWSAAException;
import afip.facturaElectronica.modelo.Afip_datos_wsaa;

public class Afip_wsaa_conectar {
	private String LoginTicketResponse = null;

	private FAConfiguracion configWSAA = FAConfiguracion.getInstance();

	private String endpoint = configWSAA.getEndpoint();
	private String service = configWSAA.getService();
	private String dstDN = configWSAA.getDstDN();

	private String p12file = configWSAA.getP12file();
	private String signer = configWSAA.getSigner();
	private String p12pass = configWSAA.getP12pass();

	private Long TicketTime = configWSAA.getTicketTime();

	public void conectarWSAA() throws NoPudoConectarWSAAException, ObtenerTokenSignWSAAException {
		this.LoginTicketResponse = null;

		this.configWSAA = FAConfiguracion.getInstance();

		this.endpoint = configWSAA.getEndpoint();
		this.service = configWSAA.getService();
		this.dstDN = configWSAA.getDstDN();

		this.p12file = configWSAA.getP12file();
		this.signer = configWSAA.getSigner();
		this.p12pass = configWSAA.getP12pass();

		this.TicketTime = configWSAA.getTicketTime();
		// Create LoginTicketRequest_xml_cms
		System.out.println("Fin de configuración de parámetros");
		
		byte[] LoginTicketRequest_xml_cms = Afip_wsaa_client.create_cms(
				p12file, p12pass, signer, dstDN, service, TicketTime);
		
		System.out.println("Ticket Generado. Enviandolo.....");
		
		// Get LoginTicketResponse by teh invocation of AFIP wsaa

		try {
			LoginTicketResponse = Afip_wsaa_client.invoke_wsaa(
					LoginTicketRequest_xml_cms, endpoint);
		} catch (Exception e2) {
			throw new NoPudoConectarWSAAException("Error al enviar XML al WSAA. "+e2);
		}
		
		// Get token & sign from LoginTicketResponse
		try {
			Reader tokenReader = new StringReader(LoginTicketResponse);
			Document tokenDoc = new SAXReader(false).read(tokenReader);

			String expirationTime = tokenDoc.valueOf("/loginTicketResponse/header/expirationTime");	
			String token = tokenDoc.valueOf("/loginTicketResponse/credentials/token");
			String sign = tokenDoc.valueOf("/loginTicketResponse/credentials/sign");

			//formateo la la fecha de expiración
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date ttl = formatoDelTexto.parse(expirationTime);
			
			// encapsulo el TA
			Afip_datos_wsaa.setToken(token);
			Afip_datos_wsaa.setSign(sign);
			Afip_datos_wsaa.setCuit(configWSAA.getCuit());
			Afip_datos_wsaa.setTTL(ttl);
			
			System.out.println("Respuesta. Token:"+ token +" . Sign: "+sign+ " . Tiempo de Expiración: "+expirationTime);
			
		} catch (Exception e) {
			throw new ObtenerTokenSignWSAAException("Error al separar datos del ticker WSAA. "+e);
		}
	}
}
