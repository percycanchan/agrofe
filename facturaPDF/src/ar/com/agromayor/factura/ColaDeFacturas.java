package ar.com.agromayor.factura;

import java.util.Iterator;

import ar.com.agromayor.DB.Exceptions.DBExcetion;
import ar.com.agromayor.DB.Exceptions.ErrorEnConsultaException;
import ar.com.agromayor.DB.Exceptions.NoHayMasFacturasExcetion;
import ar.com.agromayor.DB.factura.FacturaCabecera;
import ar.com.agromayor.DB.DAO.GlobalDAO;


/**
 * Es un "gestor de colas". Los hilos le piden las facturas a procesar.
 * Internamente es el que se comunica con la DB
 * @author BETY
 *
 */
public class ColaDeFacturas {
	Iterator<Object> facturaCabeceraIterator = null;
	
	
	public void inicializar() throws DBExcetion{
		facturaCabeceraIterator = GlobalDAO.getInstance().getFacturaDAO().getFacturaCabeceraIteratorSinPDF();
		
	}

	/**
	 * Devuelve el ID de una factura para procesar
	 * @return
	 * @throws NoHayMasFacturasExcetion
	 * @throws ErrorEnConsultaException 
	 * @throws DBExcetion 
	 */
	public synchronized Object get() throws NoHayMasFacturasExcetion, DBExcetion{
		if (! facturaCabeceraIterator.hasNext()){
			throw new NoHayMasFacturasExcetion();
		}
		
			return facturaCabeceraIterator.next();
	}
	
	public /*synchronized*/ void update(FacturaCabecera facturaCab) throws DBExcetion{
		GlobalDAO.getInstance().getFacturaDAO().updateFacturaCabecera(facturaCab);
	}
	
	public /*synchronized*/ FacturaCabecera getFactura(long id) throws DBExcetion{
		return GlobalDAO.getInstance().getFacturaDAO().getFacturaCabecera(id);
	}
	
}
