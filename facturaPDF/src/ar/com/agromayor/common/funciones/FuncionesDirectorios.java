package ar.com.agromayor.common.funciones;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FuncionesDirectorios {
	static List<String> cacheRutas = new ArrayList<String>();
	
	/**
	 * Verfica la existencia de una ruta (diretorio o archivo)
	 */
	private static File verificarRuta(String ruta) throws IOException {
		String directorio = ruta;
		if (!directorio.endsWith(File.separator)) {
			directorio = directorio + File.separator;
		}
		File rutaFile = new File(directorio);
		if (!rutaFile.exists()) {
			throw new IOException();
		}

		return rutaFile;

	}

	/**
	 * Verifica la existencia de un Directorio
	 */
	public static String verificaRutaDirectorio(String ruta) throws IOException {
		File directorio = verificarRuta(ruta);

		if (!directorio.isDirectory()) {
			throw new IOException("No es la ruta válida de un directorio: "
					+ directorio.getPath());
		}
		
		return directorio.getCanonicalPath();
	}

	/**
	 * Verifica la existencia de un Archivo
	 */
	public static String verificaRutaArchivo(String ruta) throws IOException {
		File directorio = verificarRuta(ruta);

		if (!directorio.isFile()) {
			throw new IOException("No es la ruta válida de un archivo: "
					+ directorio.getPath());
		}
		return directorio.getPath();
	}

	
	private static boolean existeRutaCacheada(String ruta){
		if (cacheRutas.contains(ruta)){
			return true;
		}
		return false;
	}
	/**
	 * Crea (Si no existe) una ruta en base a los directorios enviados en el
	 * parámetro vectorizado.
	 * 
	 * @param rutas
	 * @return
	 *  Devuelve la ruta nueva
	 *  
	 * @throws IOException
	 */
	public static String crearDirectorio(String rutaBase, String[] rutas) throws IOException {
		String ruta = rutaBase;
		boolean continuar = true;
		
		if (rutas[0] == null) {
			throw new IOException("Parámetro vacío");
		}

		for (int i = 0; (i < rutas.length && continuar); i++) {
			if (rutas[i] == null){//esto es x si se envía un Array con espacios sin datos
				continuar = false;
			}else{
				ruta = ruta + File.separator + rutas[i];
			}
		}
		
		//Si existe la ruta en el Caché, la devuelvo
		if (existeRutaCacheada(ruta)){
			return ruta + File.separator;	
		}
		
		// Si no existe la creo y la agrego al caché
		File directorioNuevo = new File(ruta);
		if (! directorioNuevo.mkdirs()){
			if (! directorioNuevo.exists()){
				throw new IOException("No se generó la ruta: "+ruta+". Verifique los permisos");
			}
		}
		
		cacheRutas.add(ruta);
		
		return ruta + File.separator;

	}
}
