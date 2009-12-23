package ar.com.agromayor.DB.DAO.Hibernate;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import ar.com.agromayor.DB.Exceptions.SystemException;
import ar.com.agromayor.common.configuracion.Configuracion;


/**
 * Maneja las sesiones de la DB
 * @author Agro
 *
 */
public class HibernateSessionFactory {
    // ----------------------------------------------------------- Variables De Instancia Estáticas
    private static final SessionFactory sessionFactory;
	private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();
    

	// ----------------------------------------------------------- Porción Estática
    static {
            try {
                Configuration cfg = new AnnotationConfiguration();
                
                File f = new File(Configuracion.getRutaConfigHiberante());
                cfg.configure(f);
      
                sessionFactory = cfg.buildSessionFactory();
                
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
    
	// ----------------------------------------------------------- Métodos Públicos Estáticos
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
            throw new SystemException("Existió un problema al cerrar la Session", e);
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
            throw new SystemException("Existió un problema al crear la Transacción", e);
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
            throw new SystemException("Existió un Problema en el RollBack", e);
        }
        
    }
}
     
