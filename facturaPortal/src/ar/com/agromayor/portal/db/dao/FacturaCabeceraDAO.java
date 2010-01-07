package ar.com.agromayor.portal.db.dao;

import java.util.List;

import ar.com.agromayor.portal.db.FacturaCabecera;
import ar.com.agromayor.portal.db.exceptions.DBExcetion;

/**
 * Define los metodos que implementa Factura contra la DB
 * @author BETY
 *
 */
public interface FacturaCabeceraDAO {
	public List<FacturaCabecera> getFacturas (Integer cliente) throws DBExcetion;
}
