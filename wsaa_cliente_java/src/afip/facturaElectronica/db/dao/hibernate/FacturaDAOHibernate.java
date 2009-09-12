package afip.facturaElectronica.db.dao.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import afip.facturaElectronica.db.Factura;
import afip.facturaElectronica.db.TipoDeComprobantePK;
import afip.facturaElectronica.db.dao.FacturaDAO;
import afip.facturaElectronica.handshake.configuracion.FAConfiguracion;

public class FacturaDAOHibernate implements FacturaDAO {

	public Factura getFactura(Long id) {
		Factura factura = null;
		try {
			Session sess = HibernateSessionFactory.currentSession();
			HibernateSessionFactory.beginTransaction();

			factura = (Factura) sess.createCriteria(Factura.class).add(
					Restrictions.idEq(id)).uniqueResult();

			HibernateSessionFactory.commitTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			HibernateSessionFactory.rollbackTransaction();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return factura;
	}

	public List<Factura> getFacturas() {
		List<Factura> factura = null;
		try {
			Session sess = HibernateSessionFactory.currentSession();
			HibernateSessionFactory.beginTransaction();

			factura = (List<Factura>) sess.createCriteria(Factura.class).list();

			HibernateSessionFactory.commitTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			HibernateSessionFactory.rollbackTransaction();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return factura;
	}

	public void saveFactura(Factura factura) {
		try {
			Session sess = HibernateSessionFactory.currentSession();
			HibernateSessionFactory.beginTransaction();

			sess.saveOrUpdate(factura);
			HibernateSessionFactory.commitTransaction();

		} catch (HibernateException e) {
			e.printStackTrace();
			HibernateSessionFactory.rollbackTransaction();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	/**
	 * guarda una coleccion de facturas.
	 * Por cada update comites si o si
	 * @param facturas
	 */
	public void saveFacturas(List<Factura> facturas) {
        try {
            Session sess = HibernateSessionFactory.currentSession();
            HibernateSessionFactory.beginTransaction();
            
            for (Iterator<Factura> factura= facturas.iterator(); factura.hasNext();){
            	Factura factSave = factura.next();
            	/*sess.saveOrUpdate(factSave);	
            	HibernateSessionFactory.commitTransaction();*/
            	
            	saveFactura(factSave);
            	
            }
            
            HibernateSessionFactory.commitTransaction();
            
        } catch (HibernateException e) {
        	e.printStackTrace();
            HibernateSessionFactory.rollbackTransaction();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
	
	public List<Factura> getFacturas(TipoDeComprobantePK tipoCpr) {
		List<Factura> factura = new ArrayList<Factura>();
		try {
			Session sess = HibernateSessionFactory.currentSession();
			HibernateSessionFactory.beginTransaction();

			factura = (List<Factura>) sess.createCriteria(Factura.class).add(
					Restrictions.eq("punto_vta", tipoCpr.getPunto_vta())).add(
					Restrictions.eq("tipo_cbte", tipoCpr.getTipo_cbte())).add(
					Restrictions.eq("estado", FAConfiguracion.getInstance()
							.getEstadoDeProceso())).addOrder(
					Order.asc("cbt_desde")).setMaxResults(
					FAConfiguracion.getCantidadMaxAEnviar()).list();

			HibernateSessionFactory.commitTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			HibernateSessionFactory.rollbackTransaction();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return factura;
	}

}
