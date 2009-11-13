package afip.facturaElectronica.handshake.configuracion;

import java.util.Date;

import afip.facturaElectronica.handshake.exceptions.FaltaConfigCabeceraXMLException;

/**
 * Clase que contiene la configuración del WSAA y el cuit del contribuyente
 * Realiza las verificaciones necesarias y los tiempos de expiración
 * @author lagromayor
 *
 */
public class Afip_datos_wsaa {
	private String token = null;
	private String sign = null;
	private Date ttl = null;
	//private Long cuit = null;
	private Integer cantMaxReg = null;


	public String getToken() {
		if (token == null){
			throw new FaltaConfigCabeceraXMLException("no se encuentra configurado el Token - WSAA");		
		}
		return token;
	}
	
	public String getSign() {
		if (sign == null){
			throw new FaltaConfigCabeceraXMLException("no se encuentra configurado el Sign - WSAA");	
		}
		return sign;
	}
	
/*	public Long getCuit() {
		if (cuit == null){
			throw new FaltaConfigCabeceraXMLException("El cuit del Contribuyente no está configurado");
		}
		return cuit;
	}*/

	public Integer getCantMaxReg() {
		if (cantMaxReg == null){
			throw new FaltaConfigCabeceraXMLException("No se configuró la cantidad máxima de registros que se pueden enviar a la AFIP - WSN");
		}
		return cantMaxReg;
	}
	
	public Date getTTL() {
		if (ttl == null){
			throw new FaltaConfigCabeceraXMLException("No se configuró el Tiempo de Expiración del Token/Sign AFIP - WSN");
		}
		return ttl;
	}
	
	
	public void setToken(String ptoken) {
		token = ptoken;
	}
	
	public void setSign(String psign) {
		sign = psign;
	}

/*	public void setCuit(Long pcuit) {
		cuit = pcuit;
	}*/

	public void setCantMaxReg(Integer pCantidad){
		cantMaxReg = pCantidad;
	}

	public void setTTL(Date ttl2) {
		ttl = ttl2;
	}
}
