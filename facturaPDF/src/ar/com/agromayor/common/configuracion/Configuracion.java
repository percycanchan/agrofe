package ar.com.agromayor.common.configuracion;

import org.apache.log4j.PropertyConfigurator;

public abstract class Configuracion {
	private static String rutaConfigJasper = System.getProperty("user.dir")+"\\config\\jasperreports.properties";
	private static String rutaConfigLog4J = System.getProperty("user.dir")+"\\config\\log4j.properties";
	private static String rutaConfigHiberante= System.getProperty("user.dir")+"\\config\\hibernate.cfg.xml";
	
	
	
	public static void inicializar(){
		System.setProperty("net.sf.jasperreports.properties",  rutaConfigJasper);
        PropertyConfigurator.configure(rutaConfigLog4J);
        
        // TODO falta inicializar las Clases con la Descripción de los Códigos 
        //      obteniendo los datos desde la DB
	}

	public static String getRutaConfigJasper() {
		return rutaConfigJasper;
	}

	public static String getRutaConfigLog4J() {
		return rutaConfigLog4J;
	}

	public static String getRutaConfigHiberante() {
		return rutaConfigHiberante;
	}

	public static void setRutaConfigJasper(String rutaConfigJasper) {
		Configuracion.rutaConfigJasper = rutaConfigJasper;
	}

	public static void setRutaConfigLog4J(String rutaConfigLog4J) {
		Configuracion.rutaConfigLog4J = rutaConfigLog4J;
	}

	public static void setRutaConfigHiberante(String rutaConfigHiberante) {
		Configuracion.rutaConfigHiberante = rutaConfigHiberante;
	}
	
	
}
