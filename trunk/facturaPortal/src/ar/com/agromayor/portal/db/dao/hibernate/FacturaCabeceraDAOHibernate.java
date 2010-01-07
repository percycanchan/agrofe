package ar.com.agromayor.portal.db.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import ar.com.agromayor.portal.db.FacturaCabecera;
import ar.com.agromayor.portal.db.dao.FacturaCabeceraDAO;
import ar.com.agromayor.portal.db.exceptions.DBExcetion;

public class FacturaCabeceraDAOHibernate implements FacturaCabeceraDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<FacturaCabecera> getFacturas(Integer cliente) throws DBExcetion {
		List<FacturaCabecera> listaCpr = null;
		try{
			Session sess = HibernateSessionFactory.currentSession();
			
			listaCpr = (List<FacturaCabecera>) 
			            sess.createCriteria(FacturaCabecera.class)
			               .add(Restrictions.eq("recCodigo", cliente))
			               .add(Restrictions.eq("factPdf", 1))
			               .addOrder(Order.desc("cabFechaCpr"))
			               .list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new DBExcetion("no se pudo realizar la consulta");
		} finally {
			// HibernateSessionFactory.closeSession();
		}
		return listaCpr;
	}

}
