package ar.com.agromayor.portal.db.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ar.com.agromayor.portal.db.PortalUsuarios;
import ar.com.agromayor.portal.db.dao.PortalUsuariosDAO;
import ar.com.agromayor.portal.db.exceptions.DBExcetion;

public class PortalUsuariosDAOHibernate implements PortalUsuariosDAO {

	
	public PortalUsuarios validarUsuario(int id, String pass) throws DBExcetion {
		PortalUsuarios usuarios = null;
		try{
			Session sess = HibernateSessionFactory.currentSession();
			
			usuarios = (PortalUsuarios) 
			            sess.createCriteria(PortalUsuarios.class)
			               .add(Restrictions.idEq(id))
			               .add(Restrictions.eq("usrPass", pass))
			               .uniqueResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new DBExcetion("no se pudo realizar la consulta");
		} finally {
			// HibernateSessionFactory.closeSession();
		}
		return usuarios;
		
	}
	
	public PortalUsuarios deciHola(){
		return new PortalUsuarios(111223);
	}
/*
	public FacturaCabecera getFacturaCabecera(Long id) throws DBExcetion {
		FacturaCabecera factura = null;
		try {
			Session sess = HibernateSessionFactory.currentSession();
			// HibernateSessionFactory.beginTransaction();

			factura = (FacturaCabecera) sess.createCriteria(
					FacturaCabecera.class).add(Restrictions.idEq(id))
					.uniqueResult();

			// HibernateSessionFactory.commitTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			// HibernateSessionFactory.rollbackTransaction();
			throw new DBExcetion("no se pudo realizar la consulta");
		} finally {
			// HibernateSessionFactory.closeSession();
		}
		return factura;
	}

	@SuppressWarnings("unchecked")
	public List<FacturaCabecera> getFacturaCabecera() throws DBExcetion {
		List<FacturaCabecera> factura = null;

		try {
			Session sess = HibernateSessionFactory.currentSession();
			// HibernateSessionFactory.beginTransaction();

			factura = (List<FacturaCabecera>) sess.createCriteria(
					FacturaCabecera.class).list();

			// HibernateSessionFactory.commitTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			// HibernateSessionFactory.rollbackTransaction();
			throw new DBExcetion("no se pudo realizar la consulta");
		} finally {
			// HibernateSessionFactory.closeSession();
		}
		return factura;
	}

	public void updateFacturaCabecera(FacturaCabecera factura)
			throws DBExcetion {
		try {
			Session sess = HibernateSessionFactory.currentSession();
			HibernateSessionFactory.beginTransaction();

			sess.update(factura); // saveOrUpdate(factura);
			HibernateSessionFactory.commitTransaction();

		} catch (HibernateException e) {
			e.printStackTrace();
			HibernateSessionFactory.rollbackTransaction();
			throw new DBExcetion("no se pudo realizar el update");
		} finally {
			// HibernateSessionFactory.closeSession();
		}
	}
/*
	/**
	 * Devuelve una factura que no tengan geneado el PDF
	 */
/*	@SuppressWarnings("unchecked")
	@Override
	public List<FacturaCabecera> getFacturaCabeceraSinPDF() {
		List<FacturaCabecera> factura = null;
		try {
			Session sess = HibernateSessionFactory.currentSession();
			// HibernateSessionFactory.beginTransaction();

			factura = (List<FacturaCabecera>) sess.createCriteria(
					FacturaCabecera.class).setFetchMode("facturaCabecera",
					FetchMode.DEFAULT).add(
					Restrictions.eq("factPdf", ConfigValores.sinPDF)).list();

			// HibernateSessionFactory.commitTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			// HibernateSessionFactory.rollbackTransaction();
		} finally {
			// HibernateSessionFactory.closeSession();
		}
		return factura;
	}
*/
	// ---- M�todos para Consultas tipo Scroll
	/**
	 * Realiza la consulta para las Facturas sin PDF generado. Por un problema al realizar un update se pasa solo el ID y el hilo vuelve a realizar la consulta
	 * 
	 * @throws ErrorEnConsultaException
	 */
/*	@SuppressWarnings("unchecked")
	public Iterator<Object> getFacturaCabeceraIteratorSinPDF()	throws DBExcetion {
		
		Iterator<Object> facturaCabeceraIterator = null;
		
		try {
			Session sess = HibernateSessionFactory.currentSession();
			
			Query q = sess.createQuery("select cabNroInterno from FacturaCabecera where factPdf = :sinPDF");
			q.setBoolean("sinPDF",ConfigValores.sinPDF);
			
			//ListIterator<FacturaCabecera> fff = q.list().listIterator();
			//while (fff.hasNext()){System.out.println(fff.next().getCabCodBarras());}

		
			
			facturaCabeceraIterator = (Iterator<Object>)q.iterate();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new DBExcetion(e);
		} 
		
		return  facturaCabeceraIterator;
	}
*/

}
