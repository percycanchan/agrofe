package ar.com.agromayor.portal.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import ar.com.agromayor.portal.base.InnerPage;
import ar.com.agromayor.portal.db.PortalUsuarios;
import ar.com.agromayor.portal.db.dao.PortalUsuariosDAO;
import ar.com.agromayor.portal.db.exceptions.DBExcetion;

public class Index extends InnerPage {
	
	// ---------Titulos del HTML
	@Inject
	private Messages messages;

	public String getPageTitle() {
		return messages.get("titulo");
	}
	public String getHeaderTitle() {
		return messages.get("header");
	}


	// ---------Pagina Destino
	@InjectPage
	private ShowComprobantes showCpr;

	
	//----------- Cliente DB
	@Inject
	@Service("portalUsuariosDAO")
	private PortalUsuariosDAO portalDAO; // Con esto vamos a inyectar el bean "userDao" de
											// Spring
	

	// --------------Campos Login HTML
	@Component
    private Form loginField;
	
	@Property
	@Persist	// esta anotacion es para que cuando reaparezca la p�gina no se pierda este valor
	private Integer uname;

	@Property
	private String pass;
	
	
	// Validación de Usuario y acceso a la página de Comprobantes
	Object onSuccessFromLoginField() throws DBExcetion {
		
		// Solamente se va a invocar este metodo cuando el username tenga un
		// valor, por las validaciones
		PortalUsuarios usr = portalDAO.validarUsuario(uname, pass);
		

		if (usr != null) {
			setUsuario(usr); // Con esto ya tendremos usuario cuando se haga el
			// render de la p�gina y ya aparecer� el campo para
			// dejar el comentario
			return showCpr;
		} 
		loginField.recordError("Cliente o Password Incorrectos.");
        return null;
	}
	
	
	

	
}
