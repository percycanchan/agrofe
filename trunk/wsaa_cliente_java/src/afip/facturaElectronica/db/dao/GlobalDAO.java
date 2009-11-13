package afip.facturaElectronica.db.dao;

import java.io.Serializable;
import afip.facturaElectronica.db.dao.hibernate.FacturaDAOHibernate;
import afip.facturaElectronica.db.dao.hibernate.TipoDeComprobanteDAOHibernate;


public class GlobalDAO implements Serializable {
	private static final long serialVersionUID = 6748716944007557815L;
	// ----------------------------------------------------------- Variables De Instancia
	private static GlobalDAO instance = null;
	private FacturaDAO facturaDAO = null;
	private TipoDeComprobanteDAO tipoDeComprobanteDAO = null;

    
	// ----------------------------------------------------------- Métodos Públicos
    public FacturaDAO getFacturaDAO() {
        if(facturaDAO == null) {
        	facturaDAO = new FacturaDAOHibernate();
        }
        return facturaDAO;
    }
        
    public TipoDeComprobanteDAO getTipoDeComprobanteDAO() {
        if(tipoDeComprobanteDAO == null) {
        	tipoDeComprobanteDAO = new TipoDeComprobanteDAOHibernate();
        }
        return tipoDeComprobanteDAO;
    }
    
    public static GlobalDAO getInstance() {
    	if(instance == null) {
    		instance = new GlobalDAO();
    	}
    	return instance;
    }
    
}
