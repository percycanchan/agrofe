package afip.facturaElectronica.db;

import java.io.Serializable;

/**
 * Modela la unicidad de un Comprobante y la empresa a la que le pertenece
 * También modela la PK de la tabla FEL_TIPO_COMPROBANTES.
 * @author BETY
 */
public class TipoDeComprobantePK implements Serializable {
	private static final long serialVersionUID = 1969236023222693632L;
	private int tipo_cbte;
	private int punto_vta;
	private long cuit;
	
	@SuppressWarnings("unused")
	private TipoDeComprobantePK(){
	}
	
	public TipoDeComprobantePK(long cuit, int tipo_cbte, int punto_vta) {
		this.cuit = cuit;
		this.tipo_cbte = tipo_cbte;
		this.punto_vta = punto_vta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cuit ^ (cuit >>> 32));
		result = prime * result + punto_vta;
		result = prime * result + tipo_cbte;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		TipoDeComprobantePK other = (TipoDeComprobantePK) obj;
		if (cuit != other.cuit)
			return false;
		if (punto_vta != other.punto_vta)
			return false;
		if (tipo_cbte != other.tipo_cbte)
			return false;
		return true;
	}

	public long getCuit() {
		return cuit;
	}

	public int getTipo_cbte() {
		return tipo_cbte;
	}

	public int getPunto_vta() {
		return punto_vta;
	}

	public void setTipo_cbte(int tipoCbte) {
		tipo_cbte = tipoCbte;
	}

	public void setPunto_vta(int puntoVta) {
		punto_vta = puntoVta;
	}
}
