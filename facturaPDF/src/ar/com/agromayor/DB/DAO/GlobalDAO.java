package ar.com.agromayor.DB.DAO;

import java.io.Serializable;

import ar.com.agromayor.DB.DAO.Hibernate.FacturaCabeceraDAOHibernate;


public class GlobalDAO implements Serializable {
	private static final long serialVersionUID = 6748716944007557815L;
	// ----------------------------------------------------------- Variables De Instancia
	private static GlobalDAO instance = null;
	private FacturaCabeceraDAO facturaCabeceraDAO = null;

    
	// ----------------------------------------------------------- Métodos Públicos
    public FacturaCabeceraDAO getFacturaDAO() {
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
