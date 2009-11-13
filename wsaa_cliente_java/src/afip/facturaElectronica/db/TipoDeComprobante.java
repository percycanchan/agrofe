package afip.facturaElectronica.db;

import java.io.Serializable;

import afip.facturaElectronica.handshake.exceptions.TipoDeComprobanteException;

/**
 * Clase que define la factura a enviar al WS-AFIP
 * @author lagromayor
 *
 */
public class TipoDeComprobante  implements Serializable  {
	private static final long serialVersionUID = 4187842237821228129L;
	private TipoDeComprobantePK comprobantePK;	

	public void setComprobantePK(TipoDeComprobantePK comprobantePK) {
		this.comprobantePK = comprobantePK;
	}
	//contiene el error que se progujo en la AFIP
    private String error;
    private String estaActivo;
    
    public TipoDeComprobante (long cuit, int tipo_cbte, int punto_vta) throws TipoDeComprobanteException{
    	comprobantePK = new TipoDeComprobantePK(cuit, tipo_cbte, punto_vta);
    }

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comprobantePK == null) ? 0 : comprobantePK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		TipoDeComprobante other = (TipoDeComprobante) obj;
		if (comprobantePK == null) {
			if (other.comprobantePK != null)
				return false;
		} else if (!comprobantePK.equals(other.comprobantePK))
			return false;
		return true;
	}
	
}
