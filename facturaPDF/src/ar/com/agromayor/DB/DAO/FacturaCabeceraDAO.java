package ar.com.agromayor.DB.DAO;

import java.util.Iterator;
import java.util.List;

import ar.com.agromayor.DB.Exceptions.DBExcetion;
import ar.com.agromayor.DB.factura.FacturaCabecera;

/**
 * Define los metodos que implementa Factura contra la DB
 * @author BETY
 *
 */
public interface FacturaCabeceraDAO {
	public FacturaCabecera getFacturaCabecera (Long id) throws DBExcetion;
	public List<FacturaCabecera> getFacturaCabecera() throws DBExcetion;
	
	public List<FacturaCabecera> getFacturaCabeceraSinPDF();
	
	public void updateFacturaCabecera(FacturaCabecera factura) throws DBExcetion;
	//public void saveFacturas(List<FacturaCabecera> facturas);
	
	//-- metodos para querys scroll
	public Iterator<Object> getFacturaCabeceraIteratorSinPDF() throws DBExcetion;
	//public boolean next(ScrollableResults facturaScroll) throws DBExcetion;
	//public FacturaCabecera get(ScrollableResults facturaScroll) throws DBExcetion;
	
}
