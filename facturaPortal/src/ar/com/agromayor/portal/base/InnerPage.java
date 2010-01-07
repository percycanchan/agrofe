package ar.com.agromayor.portal.base;

import org.apache.tapestry5.annotations.SessionState;

import ar.com.agromayor.portal.db.PortalUsuarios;

public class InnerPage {
	  @SessionState
	  private PortalUsuarios usuario;
	  private boolean userExists;
	  
	  public void setUsuario(PortalUsuarios value) {
	    usuario = value;
	  }
	  public PortalUsuarios getUsuario() {
	    return userExists ? usuario : null;
	  }
	}
