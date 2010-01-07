package ar.com.agromayor.db.codigoDescripciones;

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
		
			comprobante.put("01", "Factura A");
			comprobante.put("02", "Nota de Débito A");
			comprobante.put("03", "Nota de Crédito A");
			comprobante.put("04", "Recibo A");
			comprobante.put("05", "Nota de Venta al contado A");
			comprobante.put("06", "Factura B");
			comprobante.put("07", "Nota de Débito B");
			comprobante.put("08", "Nota de Crédito B");
			comprobante.put("09", "Recibo B");
			comprobante.put("10", "Nota de Venta al contado B");
			comprobante.put("39", "Otros comprobantes A que cumplan con la R.G. Nº 3419");
			comprobante.put("40", "Otros comprobantes B que cumplan con la R.G. Nº 3419");
			comprobante.put("60", "Cuenta de Venta y Líquido producto A");
			comprobante.put("61", "Cuenta de Venta y Líquido producto B");
			comprobante.put("63", "Liquidación A");
			comprobante.put("64", "Liquidación B");
					
		}
	}
}
