package afip.facturaElectronica.db;

import java.io.Serializable;

public class TipoDeComprobantePK implements Serializable {
	private static final long serialVersionUID = 1969236023222693632L;
	private int tipo_cbte;
	private int punto_vta;
	
	public TipoDeComprobantePK(){
	}
	
	public TipoDeComprobantePK(int tipo_cbte, int punto_vta){
		this.tipo_cbte = tipo_cbte;
		this.punto_vta = punto_vta;
	}

	public int getTipo_cbte() {
		return tipo_cbte;
	}

	public int getPunto_vta() {
		return punto_vta;
	}

	public void setTipo_cbte(int tipo_cbte) {
		this.tipo_cbte = tipo_cbte;
	}

	public void setPunto_vta(int punto_vta) {
		this.punto_vta = punto_vta;
	}
	
	
}
