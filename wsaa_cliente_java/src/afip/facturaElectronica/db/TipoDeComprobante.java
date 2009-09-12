package afip.facturaElectronica.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import afip.facturaElectronica.db.commons.GenericObject;

/**
 * Clase que contiene la factura a enviar al WS-AFIP
 * @author lagromayor
 *
 */
public class TipoDeComprobante  implements Serializable  {

	private static final long serialVersionUID = 4187842237821228129L;

	private TipoDeComprobantePK comprobantePK;
    private String error;
    private String estaActivo;
    

    public TipoDeComprobantePK getComprobantePK(){
    	return comprobantePK;
    }
    
	public String getError() {
		return error;
	}
	
	public String getEstaActivo() {
		return estaActivo;
	}
    

	public void setError(String error) {
		this.error = error;
	}
	public void setEstaActivo(String estaActivo) {
		this.estaActivo = estaActivo;
	}
	
	public void setComprobantePK(TipoDeComprobantePK comprobantePK){
		this.comprobantePK = comprobantePK;
	}

}
