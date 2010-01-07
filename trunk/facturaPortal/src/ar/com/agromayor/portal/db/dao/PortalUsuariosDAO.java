package ar.com.agromayor.portal.db.dao;

import ar.com.agromayor.portal.db.PortalUsuarios;
import ar.com.agromayor.portal.db.exceptions.DBExcetion;

/**
 * Define los metodos que implementa Factura contra la DB
 * @author BETY
 *
 */
public interface PortalUsuariosDAO {
	public PortalUsuarios validarUsuario (int id, String pass) throws DBExcetion;
	public PortalUsuarios deciHola();
}
