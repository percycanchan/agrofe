package ar.com.agromayor.DB.codigoDescripciones;

import java.util.HashMap;
import java.util.Map;

public abstract class CodigoComprobante {
	private static Map<String, String> comprobante = null;

	public static String getDescipcion(String codigo) {
		inicialize();
		return comprobante.get(codigo);
	}

	private static void inicialize() {
		if (comprobante == null) {
			comprobante = new HashMap<String, String>();
		
			comprobante.put("01", "Facturas A");
			comprobante.put("02", "Notas de Débito A");
			comprobante.put("03", "Notas de Crédito A");
			comprobante.put("04", "Recibos A");
			comprobante.put("05", "Notas de Venta al contado A");
			comprobante.put("06", "Facturas B");
			comprobante.put("07", "Notas de Débito B");
			comprobante.put("08", "Notas de Crédito B");
			comprobante.put("09", "Recibos B");
			comprobante.put("10", "Notas de Venta al contado B");
			comprobante.put("39", "Otros comprobantes A que cumplan con la R.G. N° 3419");
			comprobante.put("40", "Otros comprobantes B que cumplan con la R.G. N° 3419");
			comprobante.put("60", "Cuenta de Venta y Líquido producto A");
			comprobante.put("61", "Cuenta de Venta y Líquido producto B");
			comprobante.put("63", "Liquidación A");
			comprobante.put("64", "Liquidación B");
					
		}
	}
}
