package ar.com.agromayor.DB.codigoDescripciones;

import java.util.HashMap;
import java.util.Map;

public abstract class CodigoMoneda {
	private static Map<String, String> moneda = null;

	public static String getDescipcion(String codigo) {
		inicialize();

		return moneda.get(codigo);
	}

	private static void inicialize() {
		if (moneda == null) {
			moneda = new HashMap<String, String>();
		

			moneda.put("PES", "Pesos");
			moneda.put("USD", "Dolares");
								
		}
	}
}
