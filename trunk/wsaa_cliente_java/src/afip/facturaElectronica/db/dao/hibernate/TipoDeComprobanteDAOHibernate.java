package afip.facturaElectronica.db.dao.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import afip.facturaElectronica.db.TipoDeComprobante;
import afip.facturaElectronica.db.TipoDeComprobantePK;
import afip.facturaElectronica.db.dao.TipoDeComprobanteDAO;


public class TipoDeComprobanteDAOHibernate implements TipoDeComprobanteDAO {
	
	public TipoDeComprobante getTipoDeComprobante(int punto_vta, int tipo_cbte) {
		TipoDeComprobante tipoDeComprobante = null;
		try {
            Session sess = HibernateSessionFactory.currentSession();
            HibernateSessionFactory.beginTransaction();
            
            TipoDeComprobantePK tipoCprPK = new TipoDeComprobantePK();
            tipoCprPK.setPunto_vta(punto_vta);
            tipoCprPK.setTipo_cbte(tipo_cbte);
			tipoDeComprobante = (TipoDeComprobante) sess.createCriteria(TipoDeComprobante.class).add(Restrictions.idEq(tipoCprPK)).uniqueResult();
           
            HibernateSessionFactory.commitTransaction();
	    } catch(HibernateException e) {
	    	e.printStackTrace();
	        HibernateSessionFactory.rollbackTransaction();
	    } finally {
	        HibernateSessionFactory.closeSession();
	    }
	    return tipoDeComprobante;
	}

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
