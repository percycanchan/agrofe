package ar.com.agromayor.DB.codigoDescripciones;

import java.util.HashMap;
import java.util.Map;

public abstract class CodigoDocumento {
	private static Map<String, String> documento = null;

	public static String getDescipcion(String codigo) {
		inicialize();

		return documento.get(codigo);
	}

	private static void inicialize() {
		if (documento == null) {
			documento = new HashMap<String, String>();

			documento.put("80", "CUIT");
			documento.put("86", "CUIL");
			documento.put("87", "CDI");
			documento.put("89", "LE");
			documento.put("90", "LC");
			documento.put("91", "CI extranjera");
			documento.put("92", "en trámite");
			documento.put("93", "Acta nacimiento");
			documento.put("95", "CI Bs. As. RNP");
			documento.put("96", "DNI");
			documento.put("94", "Pasaporte");
			documento.put("00", "CI Policía Federal");
			documento.put("01", "CI Buenos Aires");
			documento.put("07", "CI Mendoza");
			documento.put("08", "CI La Rioja");
			documento.put("09", "CI Salta");
			documento.put("10", "CI San Juan");
			documento.put("11", "CI San Luis");
			documento.put("12", "CI Santa Fe");
			documento.put("13", "CI Santiago del Estero");
			documento.put("14", "CI Tucumán");
			documento.put("16", "CI Chaco");
			documento.put("17", "CI Chubut");
			documento.put("18", "CI Formosa");
			documento.put("19", "CI Misiones");
			documento.put("20", "CI Neuquén");
		}
	}
}
