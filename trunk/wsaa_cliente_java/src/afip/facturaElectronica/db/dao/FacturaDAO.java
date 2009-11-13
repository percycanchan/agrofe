package afip.facturaElectronica.db.dao;

import java.util.List;
import afip.facturaElectronica.db.Factura;
import afip.facturaElectronica.db.TipoDeComprobantePK;

public interface FacturaDAO {
	public Factura getFactura(Long id);
	public List<Factura> getFacturas();
	public List<Factura> getFacturas(TipoDeComprobantePK tipoCpr);
	public void updateFactura(Factura factura);
	public void saveFacturas(List<Factura> facturas);
}
