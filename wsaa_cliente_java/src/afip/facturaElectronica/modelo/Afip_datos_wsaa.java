package afip.facturaElectronica.modelo;

import java.util.Date;

import afip.facturaElectronica.handshake.exceptions.FaltaConfigCabeceraXMLException;

/**
 * Clase que contiene la configuración del WSAA y el cuit del contribuyente
 * Realiza las verificaciones necesarias y los tiempos de expiración
 * @author lagromayor
 *
 */
public abstract class Afip_datos_wsaa {
	private static String token = null;
	private static String sign = null;
	private static Date ttl = null;
	private static Long cuit = null;
	private static Integer cantMaxReg = null;


	public static String getToken() {
		if (token == null){
			throw new FaltaConfigCabeceraXMLException("no se encuentra configurado el Token - WSAA");		
		}
		return token;
	}
	
	public static String getSign() {
		if (sign == null){
			throw new FaltaConfigCabeceraXMLException("no se encuentra configurado el Sign - WSAA");	
		}
		return sign;
	}
	
	public static Long getCuit() {
		if (cuit == null){
			throw new FaltaConfigCabeceraXMLException("El cuit del Contribuyente no está configurado");
		}
		return cuit;
	}

	public static Integer getCantMaxReg() {
		if (cantMaxReg == null){
			throw new FaltaConfigCabeceraXMLException("No se configuró la cantidad máxima de registros que se pueden enviar a la AFIP - WSN");
		}
		return cantMaxReg;
	}
	
	public static Date getTTL() {
		if (ttl == null){
			throw new FaltaConfigCabeceraXMLException("No se configuró el Tiempo de Expiración del Token/Sign AFIP - WSN");
		}
		return ttl;
	}
	
	
	public static void setToken(String ptoken) {
		token = ptoken;
	}
	
	public static void setSign(String psign) {
		sign = psign;
	}

	public static void setCuit(Long pcuit) {
		cuit = pcuit;
	}

	public static void setCantMaxReg(Integer pCantidad){
		cantMaxReg = pCantidad;
	}

	public static void setTTL(Date ttl2) {
		ttl = ttl2;
	}
}
