package ar.com.agromayor.factura.componentes;

import ar.com.agromayor.DB.factura.FacturaItems;
import ar.com.agromayor.common.funciones.Funciones;

/**
 * Modela los Getter y Setters que utiliza el reporte. Dentro se modelan los formatos de los datos
 *
 */
public class Items {	
	FacturaItems items;
	
	public Items(FacturaItems items){
		this.items = items;
	}
	
	public Items getMe(){
		return this;
	}
	
	public String getCodigo(){
		return items.getDetCodProd();
	}
	
	public String getDescripcion(){
		return items.getDetDescripcion();
	}
	
	public String getCantidad(){
		return items.getDetCantidad();
	}
	
	public String getValorUnitario(){
		return Funciones.formatearImportes(items.getDetPrecioUnitario());
	}
	
	public String getSubTotal(){
		return Funciones.formatearImportes(items.getDetSubTotal());
	}

}
