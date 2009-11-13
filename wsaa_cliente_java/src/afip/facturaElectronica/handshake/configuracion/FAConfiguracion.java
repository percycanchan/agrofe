package afip.facturaElectronica.handshake.configuracion;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Se utiliza un Singleton para encapsular la configuración del sistema
 * 
 * @author lagromayor
 */
public class FAConfiguracion {
	private static FAConfiguracion instance = null;
	private static Afip_datos_wsaa datos_wsaa = new Afip_datos_wsaa();
	
	private static String endpoint = null;
	private static String service = null;
	private static String dstDN = null;
	private static String p12file = null;
	private static String signer = null;
	private static String p12pass = null;
	private static Long TicketTime = null;
	private static String contenedorCertificados = null;
//	private static Long cuit = null;
	
	private static String xmlWSAA = null;
	private static String pathLog = null;

	/**
	 * Tiempo de espera de la respuesta de la AFIP. En milisegundos
	 */
	private static Integer tiempoEspera = null;

	/**
	 * código de la AFIP. 1= si presta servicio
	 */
	private static Integer codigoServicio = null;
	
	
	/**
	 * Codigo de estado de los registros. Si las facturas del lote tiene ese valor se mandan para la afip 
	 */
	private static Integer estadoAProcesar = null;
	
	
	/**
	 * La cantidad máxima de facturas q se pueden enviar. Se obtiene del WS
	 */
	//TODO : falta setear la cantidad cuando se invoca el servicio
	private static Integer cantidadMaxAEnviar = 2;
	
	/**
	 * Codigos de Estado de las Facturas
	 */
	private static Integer codigoEstadoSinCAE = 1;
	private static Integer codigoEstadoEnviado = 2;
	private static Integer codigoEstadoError = 3;
	private static Integer codigoEstadoOK = 4;

	/**
	 * Ruta donde se almacenan los XML de intercambio
	 */
	private static String pathXML = null;
	



	private FAConfiguracion() {
		//super();
	}

	//public static FAConfiguracion getInstance() {
	static {
		// si no existe la instancia la creo y sete los parámetros
		if (instance == null) {
			instance = new FAConfiguracion();

			Properties config = new Properties();

			try {
				config.load(new FileInputStream("./wsaa_client.properties"));

				endpoint = config.getProperty("endpoint");
				service = config.getProperty("service");
				dstDN = config.getProperty("dstdn");
				p12file = config.getProperty("keystore");
				signer = config.getProperty("keystore-signer");
				p12pass = config.getProperty("keystore-password");
//				cuit = Long.valueOf(config.getProperty("CUIT"));
				TicketTime = new Long(config.getProperty("TicketTime"));
				
				tiempoEspera = Integer.decode( config.getProperty("tiempoDeEspera") );
				codigoServicio= Integer.decode( config.getProperty("codigoServicio") );
				
				pathXML = config.getProperty("pathXML");
				pathLog = config.getProperty("pathLog");
				
				estadoAProcesar = 1;
				
				// configuro el SSL
				//TODO falta agregar configuración de donde toma los certificados
				contenedorCertificados = "./jssecacerts";
				
				System.setProperty("javax.net.ssl.trustStore", contenedorCertificados);
				System.setProperty("javax.net.ssl.trustStorePassword", p12pass);
				
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}
		}

		//return new FAConfiguracion();
	}

	public static String getEndpoint() {
		return endpoint;
	}

	public static String getService() {
		return service;
	}

	public static String getDstDN() {
		return dstDN;
	}

	public static String getP12file() {
		return p12file;
	}

	public static String getSigner() {
		return signer;
	}

	public static String getP12pass() {
		return p12pass;
	}

	public static Long getTicketTime() {
		return TicketTime;
	}

	public static String getContenedorCertificados() {
		return contenedorCertificados;
	}

/*	public static Long getCuit() {
		return cuit;
	}
*/
	public static Integer getTiempoEspera(){
		return tiempoEspera;
	}

	public static Integer getCodigoServicio() {
		return codigoServicio;
	}
	
	public static int getEstadoDeProceso(){
		return estadoAProcesar;
	}

	public static int getCantidadMaxAEnviar(){
		return cantidadMaxAEnviar;
	}

	public static Integer getCodigoEstadoSinCAE() {
		return codigoEstadoSinCAE;
	}

	public static Integer getCodigoEstadoEnviado() {
		return codigoEstadoEnviado;
	}

	public static Integer getCodigoEstadoError() {
		return codigoEstadoError;
	}

	public static Integer getCodigoEstadoOK() {
		return codigoEstadoOK;
	}
	
	public static String getPathXML() {
		return pathXML;
	}

	/**
	 * Devuelve el XML que se envía al WSAA por un tema de debug.
	 * @return
	 */
	public static String getXmlWSAA() {
		return xmlWSAA;
	}

	/**
	 * Guarda el XML que se envía al WSAA por un tema de debug.
	 */
	public static void setXmlWSAA(String xmlWSAA) {
		FAConfiguracion.xmlWSAA = xmlWSAA;
	}

	public static String getPathLog() {
		return pathLog;
	}

	public static void setDatos_wsaa(Afip_datos_wsaa datos_wsaa) {
		FAConfiguracion.datos_wsaa = datos_wsaa;
	}

	public static Afip_datos_wsaa getDatos_wsaa() {
		return datos_wsaa;
	}
	
}
