package afip.facturaElectronica.handshake.configuracion;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Se utiliza un Singleton para encapsular la configuración del sistema
 * 
 * @author lagromayor
 */
public class FAConfiguracion {
	private static FAConfiguracion instance = null;
	private static String endpoint = null;
	private static String service = null;
	private static String dstDN = null;
	private static String p12file = null;
	private static String signer = null;
	private static String p12pass = null;
	private static Long TicketTime = null;
	private static String contenedorCertificados = null;
	private static Long cuit = null;

	/**
	 * Tiempo en minutos antes de que expire el Token/Sing
	 */
	private static Date ttl = null;
	
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
	private static Integer cantidadMaxAEnviar = 5;
	
	/**
	 * Codigos de Estado de las Facturas
	 */
	private static Integer codigoEstadoSinCAE = 1;
	private static Integer codigoEstadoEnviado = 2;
	private static Integer codigoEstadoError = 3;
	private static Integer codigoEstadoOK = 4;
	
	
	private FAConfiguracion() {
		super();
	}

	public static FAConfiguracion getInstance() {
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
				cuit = Long.valueOf(config.getProperty("CUIT"));
				TicketTime = new Long(config.getProperty("TicketTime"));

				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("mm");
				ttl = formatoDelTexto.parse(config.getProperty("TTL"));
				
				tiempoEspera = Integer.decode( config.getProperty("tiempoDeEspera") );
				codigoServicio= Integer.decode( config.getProperty("codigoServicio") );
				
				estadoAProcesar = 1;
				
				// configuro el SSL
				contenedorCertificados = System.getProperty("java.home")
						+ "/lib/security/jssecacerts".replace('/',
								File.separatorChar);
				contenedorCertificados = "./jssecacerts";
				
				System.setProperty("javax.net.ssl.trustStore", contenedorCertificados);
				System.setProperty("javax.net.ssl.trustStorePassword", p12pass);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return new FAConfiguracion();
	}

	public String getEndpoint() {
		return endpoint;
	}

	public String getService() {
		return service;
	}

	public String getDstDN() {
		return dstDN;
	}

	public String getP12file() {
		return p12file;
	}

	public String getSigner() {
		return signer;
	}

	public String getP12pass() {
		return p12pass;
	}

	public Long getTicketTime() {
		return TicketTime;
	}

	public String getContenedorCertificados() {
		return contenedorCertificados;
	}

	public Long getCuit() {
		return cuit;
	}

	public Integer getTiempoEspera(){
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
	
	
		
}
