package ar.com.agromayor.factura.componentes;

import ar.com.agromayor.DB.factura.FacturaTotales;
import ar.com.agromayor.common.funciones.Funciones;

public class Totales {
	FacturaTotales totales;
	
	public Totales(FacturaTotales totales){
		this.totales = totales;
	}
	
	public String getNetoGravado(){
		return Funciones.formatearImportes(totales.getTotNetoGravado());
	}
	
	public String getNoComputable(){
		return Funciones.formatearImportes(totales.getTotExento());
	}
	
	public String getSubTotal(){
		return Funciones.formatearImportes(totales.getTotExento().add(totales.getTotNetoGravado()));
	}
	
	public String getPercIIBB(){
		return Funciones.formatearImportes(totales.getTotPercImporteIibb());
	}
	
	public String getAlicIIBB(){
		return Funciones.formatearImportes(totales.getTotPercAlicIibb());
	}
	
	public String getProvIIBB(){
		return totales.getTotPercProvPerc();
	}
	
	public String getImpIVA(){
		return Funciones.formatearImportes(totales.getTotMontoIva());
	}
	
	public String getAlicIVA(){
		return Funciones.formatearImportes(totales.getTotAlicuota());
	}
	
	public String getPercepciones(){
		return Funciones.formatearImportes(totales.getTotPercepciones());
	}
	
	public String getAlicPercepciones(){
		return "----";
	}
	
	public String getTotal(){
		return Funciones.formatearImportes(totales.getTotTotal());
	}
	
	public String getValorAPagar(){
		return Funciones.formatearImportes(totales.getTotValorPagar());
	}
	
}
