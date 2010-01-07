package ar.com.agromayor.portal.db.dao.hibernate;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import ar.com.agromayor.portal.db.configuracion.Configuracion;
import ar.com.agromayor.portal.db.exceptions.SystemException;

/**
 * Maneja las sesiones de la DB
 * @author Agro
 *
 */
public class HibernateSessionFactory {
    // ----------------------------------------------------------- Variables De Instancia Est�ticas
    private static final SessionFactory sessionFactory;
	private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();
    

	// ----------------------------------------------------------- Porci�n Est�tica
    static {
            try {
            	//Configuration cfg = new AnnotationConfiguration();
                //sessionFactory = cfg.configure().buildSessionFactory();
                
                
            	Configuration cfg = new AnnotationConfiguration();
                
                File f = new File(Configuracion.getRutaConfigHiberante());
                cfg.configure(f);
      
                sessionFactory = cfg.buildSessionFactory();
                
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
    
	// ----------------------------------------------------------- M�todos P�blicos Est�ticos
    public static Session currentSession() throws SystemException {
            Session session = (Session) threadSession.get();
            try {
                if (session == null) {
                    session = sessionFactory.openSession();
                    threadSession.set(session);
                }
         } catch(HibernateException e) {
        	 e.printStackTrace();
             throw new SystemException("Existio un problema obteniendo la Current Session",e);
         }
            return session;
    }
    
    public static void closeSession() throws SystemException {
        try {
            Session session = threadSession.get();
            threadSession.set(null);
            if(session != null && session.isOpen())
                session.close();
        } catch(HibernateException e) {
        	e.printStackTrace();
            throw new SystemException("Existi� un problema al cerrar la Session", e);
        }
    }
    
    public static void beginTransaction() throws SystemException {
        try {
            Transaction tx = threadTransaction.get();
            if(tx == null) {
                    tx = currentSession().beginTransaction();
                    threadTransaction.set(tx);
            }
        } catch (HibernateException e) {
        	e.printStackTrace();
            throw new SystemException("Existi� un problema al crear la Transacci�n", e);
        }
        
    }
    
    public static void commitTransaction() throws SystemException {
        try {
            Transaction tx = threadTransaction.get();
            
            if(tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
                tx.commit();
            threadTransaction.set(null);
        } catch (HibernateException e) {
        	e.printStackTrace();
        }
        
    }
    
    public static void rollbackTransaction() throws SystemException {
        try {
            Transaction tx = threadTransaction.get();
            threadTransaction.set(null);
            if(tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
                tx.rollback();
            closeSession();
        } catch (HibernateException e) {
        	e.printStackTrace();
            throw new SystemException("Existi� un Problema en el RollBack", e);
        }
        
    }
}
     
