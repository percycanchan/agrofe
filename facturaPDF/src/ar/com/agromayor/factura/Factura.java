package ar.com.agromayor.factura;


import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import ar.com.agromayor.DB.factura.FacturaCabecera;
import ar.com.agromayor.DB.factura.FacturaItems;
import ar.com.agromayor.Jasper.factura.ItemsFactory;
import ar.com.agromayor.factura.componentes.Cabecera;
import ar.com.agromayor.factura.componentes.Emisor;
import ar.com.agromayor.factura.componentes.Items;
import ar.com.agromayor.factura.componentes.Receptor;
import ar.com.agromayor.factura.componentes.Totales;

/**
 * Modela los Getter y Setters que utiliza el reporte. Dentro se modelan los formatos de los datos
 *
 */
public class Factura {
	Cabecera cabecera;
	Emisor emisor;
	Receptor receptor;
	Totales totales;
	ItemsFactory items;
	
	public void setDatos(FacturaCabecera factCab){
		this.cabecera = new Cabecera(factCab);
		this.emisor = new Emisor(factCab.getFacturaEmisor());
		this.receptor = new Receptor(factCab.getFacturaReceptor());
		this.totales = new Totales(factCab.getFacturaTotales());

		Collection<Object> collection = new Vector<Object>();

		//A ItemsFactory le llegan Items
		// e Items tiene un atributo del tipo FacturaItems
		Set<FacturaItems> lista = factCab.getFacturaItemses();
		for (Iterator<FacturaItems> iterator = lista.iterator(); iterator.hasNext();) {
			Items item = new Items( iterator.next());
			collection.add(item);
		}
		this.items = new ItemsFactory();
		this.items.setItems( collection );
		
			
	}
	
	// ------ Metodo utilizado por JasperReport
	public Factura getMe()
	{
		return this;
	}

	public Cabecera getCabecera() {
		return cabecera;
	}

	public Emisor getEmisor() {
		return emisor;
	}

	public Receptor getReceptor() {
		return receptor;
	}

	public Totales getTotales() {
		return totales;
	}

	public ItemsFactory getItems() {
		return items;
	}

}
