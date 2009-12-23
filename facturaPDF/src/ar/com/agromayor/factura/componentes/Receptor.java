package ar.com.agromayor.factura.componentes;

import ar.com.agromayor.DB.codigoDescripciones.CodigoDocumento;
import ar.com.agromayor.DB.codigoDescripciones.CodigoTipoDeResponsable;
import ar.com.agromayor.DB.factura.FacturaReceptor;
import ar.com.agromayor.common.configuracion.ConfigFormatos;

/**
 * Modela los Getter y Setters que utiliza el reporte. Dentro se modelan los formatos de los datos
 *
 */
public class Receptor {
	FacturaReceptor receptor;
	
	public Receptor(FacturaReceptor receptor){
		super();
		this.receptor = receptor;
	}
	
	public String getCodigoCliente(){
		if (  (receptor.getId().getRecSubcuenta() == 0)){
			return String.valueOf(receptor.getId().getRecCodigo());
		}
		
		return receptor.getId().getRecCodigo()
		      +ConfigFormatos.separadorClienteSubcuenta
		      + receptor.getId().getRecSubcuenta();
	}
	
	public String getNombre(){
		return receptor.getRecNombre();
		/*
		// Formatea segun Nombre y Apellido
		String nombre = null;
		if (FacturaValores.formatoApellidoNombre){
			nombre = "ApellidO" +
			       FacturaValores.separadorApellidoNombre +
			       receptor.getRecNombre();
		}else{
			nombre = receptor.getRecNombre()+
	           FacturaValores.separadorApellidoNombre +
	           "ApellidO" ;
		}
		
		return nombre;*/
	}
	
	public String getDireccion(){
		return receptor.getRecCalle() +
			   " "+ receptor.getRecNumero()+
		       "  Piso: "+ ( receptor.getRecPiso() == null ? "--" : receptor.getRecPiso()) + 
		       "  Dpto: "+ ( receptor.getRecDepto() == null ? "--" : receptor.getRecDepto());
	}
	
	public String getCodigoPostal(){
		return receptor.getRecCodPostal();
	}
	
	public String getLocalidad(){
		return receptor.getRecLocalidad();
	}
	
	public String getProvincia(){
		return receptor.getRecProvincia();
	}
	
	public String getTipoResponsable(){
		return CodigoTipoDeResponsable.getDescipcion(receptor.getRecTipoResp()); 
	}
	
	public String getCondIIBB(){
		return receptor.getRecCondIibb();
	}
	
	public String getNumeroIIBB(){
		return receptor.getRecNroIibb();
	}
	
	public String getNroDocumento(){
		return receptor.getRecNroDoc();
	}
	
	public String getTipoDocumento(){
		return CodigoDocumento.getDescipcion(receptor.getRecTipoDoc());
	}
}
