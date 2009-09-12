package afip.facturaElectronica.db.dao;

import java.util.List;
import afip.facturaElectronica.db.TipoDeComprobante;

public interface TipoDeComprobanteDAO {
		
	    public TipoDeComprobante getTipoDeComprobante(int punto_vta, int tipo_cbte);
	    public void saveTipoDeComprobante(TipoDeComprobante tipoCpr);
	    public List<TipoDeComprobante> getTipoDeComprobantes();
	   
}
