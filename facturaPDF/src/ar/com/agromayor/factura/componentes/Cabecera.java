package ar.com.agromayor.factura.componentes;

import java.util.Date;

import ar.com.agromayor.DB.codigoDescripciones.CodigoComprobante;
import ar.com.agromayor.DB.codigoDescripciones.CodigoMoneda;
import ar.com.agromayor.DB.factura.FacturaCabecera;
import ar.com.agromayor.common.configuracion.ConfigFormatos;
import ar.com.agromayor.common.funciones.Funciones;

/**
 * Modela los Getter y Setters que utiliza el reporte. Dentro se modelan los formatos de los datos
 *
 */
public class Cabecera {
	private  FacturaCabecera cabecera;
	
	public Cabecera(FacturaCabecera cabecera){
		super();
		this.cabecera = cabecera;
	}
	
	public String getTipoCprDesc(){
		return CodigoComprobante.getDescipcion(cabecera.getCabTipoCpr());
	}
	
	public String getCodigoCpr(){
		return "Código Nº "+ cabecera.getCabTipoCpr();
	}
	
	public String getLetra(){
		return cabecera.getCabLetra();
	}
	
	public String getNroComprobante(){
		return Funciones.completarConCeros(cabecera.getCabSucursal(),4)
		       + ConfigFormatos.separadorSucursalNroCpr
		       + Funciones.completarConCeros(cabecera.getCabCprNumero(), 8)
		;
	}
	
	public String getFechaCpr(){
		return Funciones.formatearFecha(cabecera.getCabFechaCpr(), ConfigFormatos.formatoFecha);
	}
	
	public String getCodigoBarras(){
		return cabecera.getCabCodBarras();
	}
	
	public String getCondPago(){
		return cabecera.getCabCondPago();
	}
	
	public String getVencimiento(){
		return Funciones.formatearFecha(cabecera.getCabFechaVto(), ConfigFormatos.formatoFecha);
	}
	
	public String getOriginal(){
		return cabecera.getCabOrigDupli();
	}
	
	public String getPublicidad(){
		return cabecera.getCabPublicidad().toString();
	}

	public String getLeyenda1(){
		return cabecera.getCabLeyenda1();
	}

	public String getLeyenda2(){
		return cabecera.getCabLeyenda2();
	}
	
	public String getLeyenda3(){
		return cabecera.getCabLeyenda3();
	}

	public String getCodigoPago1(){
		return Funciones.agregaEnter(cabecera.getCabCodigoPago1(), ":");
	}

	public String getCodigoPago2(){
		return cabecera.getCabCodigoPago2();
	}

	public String getCodigoPago3(){
		return cabecera.getCabCodigoPago3();
	}

	public String getCodigoPago4(){
		return cabecera.getCabCodigoPago4();
	}

	public String getCodigoPago5(){
		return cabecera.getCabCodigoPago5();
	}
	
	public String getCuotaMes(){
		return Funciones.formatearFecha(cabecera.getCabCuotaMes(), ConfigFormatos.formatoFechaMesAño);
	}
	
	public String getImporteLetras(){
		return Funciones.toInitCaps(cabecera.getCabImporteLetras());
	}
	
	public String getMonedaDesc(){
		return CodigoMoneda.getDescipcion(cabecera.getCabCodMoneda());
	}
	
	public String getCAE(){
		return cabecera.getCabCaeCai();
	}
	
	public String getCaeVto(){
		return Funciones.formatearFecha(cabecera.getCabCaeVto(), ConfigFormatos.formatoFecha);
	}
	
	//-- Gettes con datos segun su formato (no son para le reporte!!!)
	/**
	 * Devuelve el dato sin formatear. No usar para el reporte!
	 */
	public Date FechaCpr(){
		return cabecera.getCabFechaCpr();
	}
	
	/**
	 * Devuelve el dato sin formatear. No usar para el reporte!
	 */
	public String TipoCpr(){
		return cabecera.getCabTipoCpr();
	}
	
	/**
	 * Devuelve el dato sin formatear. No usar para el reporte!
	 */
	public Short Sucursal(){
		return cabecera.getCabSucursal();
	}
	
	
	
}
