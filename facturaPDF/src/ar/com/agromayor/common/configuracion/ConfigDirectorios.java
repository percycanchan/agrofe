package ar.com.agromayor.common.configuracion;

import java.io.IOException;

import ar.com.agromayor.common.funciones.FuncionesDirectorios;

/**
 * Contiene los directorios de los Reportes Fuente, destindo de los PDF, etc
 * 
 * @author BETY
 * 
 */
public class ConfigDirectorios {
	/**
	 * Carpeta donde se ecnuentran las imágenes que se usan para el reporte
	 */
	public static String carpetaImagenes = "imagenes";

	/**
	 * Ruta donde se encuentra el reporte fuente
	 */
	public static String rutaReporteFuente = null;

	/**
	 * Ruta donde se guardan los PDF generados. Es la base, en otro metodo se
	 * deine la distribución de las carpetar
	 */
	public static String rutaPDFBase = null;

	public static void setRutaReporteFuente(String ruta) throws IOException {
		rutaReporteFuente = FuncionesDirectorios.verificaRutaDirectorio(ruta);
	}

	public static void setRutaPDFBase(String ruta) throws IOException {
		rutaPDFBase = FuncionesDirectorios.verificaRutaDirectorio(ruta);
	}

}
