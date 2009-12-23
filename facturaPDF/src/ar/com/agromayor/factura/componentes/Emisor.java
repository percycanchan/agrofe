package ar.com.agromayor.factura.componentes;

import ar.com.agromayor.DB.factura.FacturaEmisor;
import ar.com.agromayor.common.configuracion.ConfigDirectorios;
import ar.com.agromayor.common.configuracion.ConfigFormatos;
import ar.com.agromayor.common.funciones.Funciones;

/**
 * Modela los Getter y Setters que utiliza el reporte. Dentro se modelan los formatos de los datos
 * @author BETY
 *
 */
public class Emisor {
	private FacturaEmisor emisor;
	
	public Emisor (FacturaEmisor emisor){
		super();
		this.emisor = emisor;
	}
	
	public String getNombre(){
		return emisor.getEmiNombre();
	}
	
	public String getDireccion(){
		return Funciones.toInitCaps(emisor.getEmiCalle()) + " "
		       + emisor.getEmiNumero() + " - "
		       + emisor.getEmiPiso()+ "º Piso - "
		       + emisor.getEmiCodPostal()
		       ;
	}
	
	public String getBarrio(){
		return Funciones.toInitCaps(emisor.getEmiLocalidad() + " - "
		       +emisor.getEmiProvincia());
	}
	
	public String getWeb(){
		return emisor.getEmiDireccionWeb();
	}
	
	public String getTelefono(){
		return emisor.getEmiTelefono();
	}
	
	public String getTipoResponsable(){
		return emisor.getEmiTipoResp().toUpperCase();
	}
	
	public String getCUIT(){
		return emisor.getEmiCuit();
	}
	
	public String getIIBB(){
		return emisor.getEmiNroIibb();
	}
	
	public String getInicioActividades(){
		return (Funciones.formatearFecha(emisor.getEmiInicioAct(), ConfigFormatos.formatoFecha));
	}
	
	public String getLogoChico(){
		return getRutaImagenes()+
			   emisor.getEmiLogoChico();
	}
	
	public String getLogoMediano(){
		return  getRutaImagenes()+
		       emisor.getEmiLogoMediano();
	}
	
	//-- Metodos propios del Objeto
	private static String getRutaImagenes() {
		return ConfigDirectorios.rutaReporteFuente + java.io.File.separator
				+ ConfigDirectorios.carpetaImagenes + java.io.File.separator;
	}
	
}
