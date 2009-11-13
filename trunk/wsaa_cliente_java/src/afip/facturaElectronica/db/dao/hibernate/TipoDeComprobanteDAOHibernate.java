package afip.facturaElectronica.db.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import afip.facturaElectronica.db.TipoDeComprobante;
import afip.facturaElectronica.db.dao.TipoDeComprobanteDAO;
import afip.facturaElectronica.modelo.Comprobante;


public class TipoDeComprobanteDAOHibernate implements TipoDeComprobanteDAO {
	
	public TipoDeComprobante getTipoDeComprobante(Comprobante cpr) {
		TipoDeComprobante tipoDeComprobante = null;
		try {
            Session sess = HibernateSessionFactory.currentSession();
            HibernateSessionFactory.beginTransaction();
            
			tipoDeComprobante = (TipoDeComprobante) sess.createCriteria(TipoDeComprobante.class)
			                                            .add(Restrictions.idEq(cpr.getTipoDeComprobante().getComprobantePK()))
			                                            .uniqueResult();
           
            HibernateSessionFactory.commitTransaction();
	    } catch(HibernateException e) {
	    	e.printStackTrace();
	        HibernateSessionFactory.rollbackTransaction();
	    } finally {
	        HibernateSessionFactory.closeSession();
	    }
	    return tipoDeComprobante;
	}

	@SuppressWarnings("unchecked")
	public List<TipoDeComprobante> getTipoDeComprobantes() {
		List<TipoDeComprobante> tipoDeComprobantes = null;
		try {
            Session sess = HibernateSessionFactory.currentSession();
            HibernateSessionFactory.beginTransaction();
            
            tipoDeComprobantes = (List<TipoDeComprobante>) sess.createCriteria(TipoDeComprobante.class).list();
            
            HibernateSessionFactory.commitTransaction();
	    } catch(HibernateException e) {
	    	e.printStackTrace();
	        HibernateSessionFactory.rollbackTransaction();
	    } finally {
	        HibernateSessionFactory.closeSession();
	    }
	    return tipoDeComprobantes;
	}
	
	public void saveTipoDeComprobante(TipoDeComprobante tipoDeComprobante) {
        try {
            Session sess = HibernateSessionFactory.currentSession();
            HibernateSessionFactory.beginTransaction();
            
            sess.saveOrUpdate(tipoDeComprobante);
            HibernateSessionFactory.commitTransaction();
            
        } catch (HibernateException e) {
        	e.printStackTrace();
            HibernateSessionFactory.rollbackTransaction();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
	
	
}
