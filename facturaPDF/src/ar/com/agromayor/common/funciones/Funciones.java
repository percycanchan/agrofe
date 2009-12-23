package ar.com.agromayor.common.funciones;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class Funciones {
	
	public static String completarConCeros(int cadena, int cantidad) {
		return String.format("%0" + cantidad + "d", cadena);
	}

	public static String formatearFecha(Date fecha, String formato) {
		return (new SimpleDateFormat(formato)).format(fecha);
	}

	public static String formatearImportes(Object importe) {
		// Locale.ITALIAN : me lo formatea como
		// Separador de decimales ','
		// Separador de miles '.'
		// "%,.2f" : le da el formato de 2 decimales y si es negativo le pone 0
		// "%(,.2f" : idema anterior, si es negativo lo encierra entre
		// paréntesis
		return String.format(Locale.ITALIAN, "%,.2f", importe);
	}

	/**
	 * Agrega un Caracter de Separador de Línea (Enter) luego de la 1ra ocurrencia del separador.
	 * @param texto
	 * @param separador
	 * @return
	 */
	public static String agregaEnter(String texto, String separador){
		char enter = Character.LINE_SEPARATOR;
		return texto.replaceFirst(separador, separador+enter);
	}



	/**
	 * Convierte la 1er letra de una palabra a mayúscula, el resto en Minúscula
	 * Recorre la frase buscando espacios
	 * @param inputString
	 * @return
	 */
	public static String toInitCaps(String inputString) {
		StringBuilder result = new StringBuilder();
		if (inputString != null && inputString.length() > 0) {
			for (String f : inputString.split(" ")) {
				if (result.length() > 0) {
					result.append(" ");
				}
				result.append(f.substring(0, 1).toUpperCase()).append(
						f.substring(1, f.length()).toLowerCase());
			}
		}
		return result.toString();
	}

	/**
	 * Convierte la 1er letra de una palabra a mayúscula, el resto en Minúscula
	 * Usanto StringTokenizer
	 * @param inputString
	 * @return
	 */
	public static String toPropoerCase(String inputString) {

		StringBuffer result = new StringBuffer();
		String[] list = null;
		if (inputString != null && inputString.length() > 0) {
			StringTokenizer tok = new StringTokenizer(inputString);
			if (tok.hasMoreElements())
				list = new String[tok.countTokens()];
			int n = 0;
			while (tok.hasMoreElements()) {
				list[n] = (String) tok.nextElement();
				n++;
			}
			if (list != null && list.length > 0) {
				for (int i = 0; i < list.length; i++) {
					String str = list[i];
					str = str.toLowerCase();
					char[] charArray = str.toCharArray();
					charArray[0] = Character.toUpperCase(charArray[0]); // list[i]
																		// = new
																		// String(charArray);
					result.append(new String(charArray));
					if (i < n)
						result.append(" ");
				}
			}
		}
		return result.toString();
	}

}
