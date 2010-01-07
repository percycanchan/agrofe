package ar.com.agromayor.portal.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Response;

import ar.com.agromayor.db.codigoDescripciones.CodigoComprobante;
import ar.com.agromayor.portal.base.InnerPage;
import ar.com.agromayor.portal.db.FacturaCabecera;
import ar.com.agromayor.portal.db.PortalUsuarios;
import ar.com.agromayor.portal.db.dao.FacturaCabeceraDAO;
import ar.com.agromayor.portal.db.exceptions.DBExcetion;

public class ShowComprobantes extends InnerPage{
	@SessionState
	private PortalUsuarios usuario;
	
	@Inject
	private Messages messages;

	public String getPageTitle() {
		return messages.get("titulo");
	}
	public String getHeaderTitle() {
		return messages.get("header");
	}
	public String getHeaderCliente() {
		return messages.get("headerCliente") + usuario.getUsrNombre();
	}
	
	@Inject
	@Service("facturaCabeceraDAO")
	private FacturaCabeceraDAO facturaCabeceraDAO; // Con esto vamos a inyectar el bean "userDao" de
											// Spring
	
	@Property
	private FacturaCabecera facturaCabecera;

	@Persist
	private List<FacturaCabecera> facturas;
	
	public List<FacturaCabecera> getFacturaCabeceras() throws DBExcetion {
		facturas = facturaCabeceraDAO.getFacturas(usuario.getUsrCodigo());
		return facturas;
	}
	
	
	public String getNombreFactura(){
		return CodigoComprobante.getDescipcion(facturaCabecera.getCabTipoCpr())
				+"-"+facturaCabecera.getCabSucursal()
				+"-"+facturaCabecera.getCabCprNumero();
	}
	
	private FacturaCabecera getFactura(long cabNroInterno){
		for (Iterator<FacturaCabecera> iterator = facturas.iterator(); iterator.hasNext();) {
			FacturaCabecera it = iterator.next();
			System.out.println(it.getCabNroInterno());
			if (it.getCabNroInterno() == cabNroInterno){
				return it;
			}
			
		}
		return null;
	}
	
	// ------Descargar comprobante
	//con esto permito descargar un archivo
	// TODO deberia hacer una abstracción.... 
	StreamResponse onActionFromLinkDownload(long cabNroInterno){
		final FacturaCabecera fact =  getFactura(cabNroInterno);
		
		return new StreamResponse() {

			public String getContentType() {
				return "application/pdf";
			}

			public InputStream getStream() throws IOException {

				File f = new File(fact.getFactPdfRuta());
				InputStream in = new FileInputStream(f);
				return in;
			}

			public void prepareResponse(Response response) {
				response.setHeader("Content-disposition", 
						"Attachment; filename="+
						fact.getCabSucursal()
						+"-"+fact.getCabCprNumero());
						//TODO se que es una grasada pero es tarde y no tengo ganas de modificarlo
			}
		};
	}
	

}
