package afip.facturaElectronica.db.dao;

import java.util.List;
import afip.facturaElectronica.db.TipoDeComprobante;
import afip.facturaElectronica.modelo.Comprobante;

public interface TipoDeComprobanteDAO {
		
	    public TipoDeComprobante getTipoDeComprobante(Comprobante cpr);
	    public void saveTipoDeComprobante(TipoDeComprobante tipoCpr);
	    public List<TipoDeComprobante> getTipoDeComprobantes();
	   
}
