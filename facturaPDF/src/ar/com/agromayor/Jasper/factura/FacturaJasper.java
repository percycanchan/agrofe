package ar.com.agromayor.Jasper.factura;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import ar.com.agromayor.DB.factura.FacturaCabecera;
import ar.com.agromayor.DB.factura.FacturaItems;
import ar.com.agromayor.common.configuracion.ConfigDirectorios;
import ar.com.agromayor.common.configuracion.ConfigFormatos;
import ar.com.agromayor.common.funciones.Funciones;
import ar.com.agromayor.common.funciones.FuncionesDirectorios;
import ar.com.agromayor.factura.Factura;

public class FacturaJasper {
	Factura factura;

	public void setFactura(Factura pfactura) {
		factura = pfactura;
	}

	// ---------JavaBeans para JasperReport

	/**
	 * Metodo que utiliza JasperReport para tomar las facturas a generar. En
	 * este caso una sola
	 */
	public Collection<Object> getBeanCollection() {
		Collection<Object> collection = new Vector<Object>();
		collection.add(factura);
		return collection;
	}
	
	/**
	 * Devuelve la ruta de destino del PDF. En el método define la composición
	 * @return
	 * @throws IOException 
	 */
	private String getRutaDetinoPDF() throws IOException{
		// TODO ¿Agregar una especie de caché para no preguntar continuamente si existe el directorio?
		
		String[] rutas = new String[3];
		rutas[0] = Funciones.formatearFecha(this.factura.getCabecera().FechaCpr(), ConfigFormatos.formatoFechaAmericano);
		rutas[1] = this.factura.getCabecera().TipoCpr();
		rutas[2] = String.valueOf(this.factura.getCabecera().Sucursal());
		
		return FuncionesDirectorios.crearDirectorio(ConfigDirectorios.rutaPDFBase,rutas);
	}
	
	/**
	 * Devuelve la ruta del archivo donde se guarda el PDF.
	 * @return
	 * @throws IOException
	 */
	public String getDestinoPDF() throws IOException {
		return getRutaDetinoPDF()+this.factura.getCabecera().getNroComprobante()+".PDF";
		
	}
	
	// -----Para TESTING desde el reporte
	/**
	 * Genero una Colección pero con una única factura
	 */
	public static Collection<Object> generateCollection() {
		// genero una coleccion de facturas
		Collection<Object> colCliente = new Vector<Object>();

		Factura factTest = new Factura();
		
		FacturaCabecera facturaCabecera = new FacturaCabecera();
		facturaCabecera.setCabLetra("B");
		facturaCabecera.setCabSucursal(Short.decode(String.valueOf(1007)));
		facturaCabecera.setCabCprNumero(332343);
		facturaCabecera.setCabCodBarras("1232142342333");
		
		Set<FacturaItems> set = new HashSet<FacturaItems>();
		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));		set.add(ItemsFactory.getFactItemAleatoreo(1));
		set.add(ItemsFactory.getFactItemAleatoreo(2));
		set.add(ItemsFactory.getFactItemAleatoreo(3));
		facturaCabecera.setFacturaItemses(set);
		

		factTest.setDatos(facturaCabecera);
//		ItemsFactory facccc = factTest.getItems();
//		String pepe = ((Items)(facccc.getBeanCollection().iterator().next())).getSubTotal();
		// agego la factura y la retorno para generar el reporte
		colCliente.add(factTest);
		return colCliente;
	}



}
