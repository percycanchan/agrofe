package ar.com.agromayor.portal.db.dao;

import java.io.Serializable;

import ar.com.agromayor.portal.db.dao.hibernate.FacturaCabeceraDAOHibernate;
import ar.com.agromayor.portal.db.dao.hibernate.PortalUsuariosDAOHibernate;



public class GlobalDAO implements Serializable {
	private static final long serialVersionUID = 6748716944007557815L;
	// ----------------------------------------------------------- Variables De Instancia
	private static GlobalDAO instance = null;
	private PortalUsuariosDAO fortalUsuariosDAO = null;
	private FacturaCabeceraDAO facturaCabeceraDAO = null;
    
	// ----------------------------------------------------------- M�todos P�blicos
    public PortalUsuariosDAO getPortalUsuariosDAO() {
        if(fortalUsuariosDAO == null) {
        	fortalUsuariosDAO = new PortalUsuariosDAOHibernate();
        }
        return fortalUsuariosDAO;
    }
        
    
    public FacturaCabeceraDAO getFacturaCabeceraDAO() {
        if(facturaCabeceraDAO == null) {
        	facturaCabeceraDAO = new FacturaCabeceraDAOHibernate();
        }
        return facturaCabeceraDAO;
    }
   
    
    public static GlobalDAO getInstance() {
    	if(instance == null) {
    		instance = new GlobalDAO();
    	}
    	return instance;
    }
    
}
