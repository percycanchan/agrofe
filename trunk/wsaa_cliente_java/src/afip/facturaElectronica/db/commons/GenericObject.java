package afip.facturaElectronica.db.commons;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * Clase Abstracta que representa un Objeto Persistible.
 * 
 * @author Agro
 *
 */
@MappedSuperclass
public abstract class GenericObject implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4187846827821228129L;
	//----------------------------------------------------------- Variables De Instancia
	/**
	 * Surrogate Id.
	 */
	protected Long id;
	
    //----------------------------------------------------------- Getters y Setters
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DAT_NUMERO")
	public Long getId() {
		return id;
	}
    
    protected void setId(final Long id) {
    	this.id = id;
    }
	
}
