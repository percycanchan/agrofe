package afip.facturaElectronica.handshake.wsaa;

import java.io.Reader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import afip.facturaElectronica.handshake.configuracion.FAConfiguracion;
import afip.facturaElectronica.handshake.exceptions.wsaa.NoPudoConectarWSAAException;
import afip.facturaElectronica.handshake.exceptions.wsaa.ObtenerTokenSignWSAAException;

/**
 * Clase Abstracta responsable de cargar la configuración y obtener el ticket de acceso del WSAA
 * @author Agro
 */
public abstract class Afip_wsaa_conectar {
	private static String LoginTicketResponse = null;

	private static String endpoint = FAConfiguracion.getEndpoint();
	private static String service = FAConfiguracion.getService();
	private static String dstDN = FAConfiguracion.getDstDN();

	private static String p12file = FAConfiguracion.getP12file();
	private static String signer = FAConfiguracion.getSigner();
	private static String p12pass = FAConfiguracion.getP12pass();

	private static Long TicketTime = FAConfiguracion.getTicketTime();

	public static void conectarWSAA() throws NoPudoConectarWSAAException, ObtenerTokenSignWSAAException {
		// Create LoginTicketRequest_xml_cms
		System.out.println("Fin de configuración de parámetros");
		
		byte[] LoginTicketRequest_xml_cms = Afip_wsaa_client.create_cms(
				p12file, p12pass, signer, 
				dstDN, service, TicketTime);
		
		System.out.println("Ticket Generado. Enviandolo.....");

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
			FAConfiguracion.getDatos_wsaa().setToken(token);
			FAConfiguracion.getDatos_wsaa().setSign(sign);
			//FAConfiguracion.getDatos_wsaa().setCuit(FAConfiguracion.getCuit());
			FAConfiguracion.getDatos_wsaa().setTTL(ttl);
			
			System.out.println("Respuesta. Token:"+ token +" . Sign: "+sign+ " . Tiempo de Expiración: "+expirationTime);
			
		} catch (Exception e) {
			throw new ObtenerTokenSignWSAAException("Error al separar datos del ticker WSAA. "+e);
		}
	}
}
