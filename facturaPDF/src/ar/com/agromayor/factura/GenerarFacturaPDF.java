package ar.com.agromayor.factura;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import ar.com.agromayor.DB.Exceptions.DBExcetion;
import ar.com.agromayor.DB.Exceptions.NoHayMasFacturasExcetion;
import ar.com.agromayor.DB.factura.FacturaCabecera;
import ar.com.agromayor.Jasper.factura.FacturaJasper;
import ar.com.agromayor.common.configuracion.ConfigDirectorios;
import ar.com.agromayor.common.configuracion.ConfigValores;

/**
 * Clase que se encarga generar la Factura (completa los datos en el reporte y lo exporta en PDF -en un directorio y con un nombre determinado-)
 * Extiende de Thread, se puede ejecutar como multiHilo
 * @author Agro
 *
 */
public class GenerarFacturaPDF  extends Thread{
	JasperReport report;
	ColaDeFacturas cola;
	boolean continuar = true;
	
	String ErrorNroInternoCpr = null;
	 
	public void run()  {
		Date inicio = new Date();
		int contador = 0;
		
		try{
			while (continuar){
				FacturaCabecera facturaCab = null;
				Factura factura = null;
				String rutaPDF;

				// para verificar performance
				contador = contador+1;
				
				// Pido una factura. (Solo el ID por un problema al realizar un Update desde varios Hilos)
				Long idFactura = (Long) cola.get();
				facturaCab = cola.getFactura(idFactura);
				
				// Genero el tipo de Factura que se envía a FacturaJasper
				factura = new Factura();
				factura.setDatos(facturaCab);
				
				// Genero una factura para enviarle al reporte. No la modela, solo dentro tiene los metodos necesarios por JasperReports
				FacturaJasper factJasper = new FacturaJasper();
				factJasper.setFactura(factura);
				
				// Genero el nombre del PDF
				rutaPDF = factJasper.getDestinoPDF();				
				// Genero el Reporte
				convertir_informe(report,
						          rutaPDF,
						          new JRBeanCollectionDataSource(factJasper.getBeanCollection()));

				// Modifico los valoser de la factura
				facturaCab.setFactPdf(ConfigValores.conPDF);
				facturaCab.setFactPdfRuta(rutaPDF);
				
				// Grabo la factura
				cola.update(facturaCab);
				//facturaCab.update();
			}
		} catch (JRException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (NoHayMasFacturasExcetion e) {
			// No es error. No hay mas facturas en la DB
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);

		} catch (DBExcetion e) {
			e.printStackTrace();
			System.exit(-1);
		}

		// Hilo Finalizado - Para testing de Performance
		Date fin = new Date();
		System.out.println("inicio: "+ inicio);
		System.out.println("Fin: "+ fin);
		System.out.println("Cantidad: "+contador);
	} 
	
	/**
	 * Realiza los pasos de Completado de Datos del reporte y Exportación a PDF
	 * @param report
	 * @param pdf
	 * @param jrBeanCollectionDataSource
	 * @throws JRException
	 */
	private void convertir_informe(JasperReport report, String pdf, JRBeanCollectionDataSource jrBeanCollectionDataSource) throws JRException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("RUTA_FUENTE", ConfigDirectorios.rutaReporteFuente);

		//System.out.println("Rellenando Datos...");
		JasperPrint print = JasperFillManager.fillReport(report, parameters, jrBeanCollectionDataSource);

		//System.out.println("Exportando a PDF...");
		JasperExportManager.exportReportToPdfFile(print, pdf);

		//System.out.println("Proceso Finalizado...");
	}


	public void setReport(JasperReport report) {
		this.report = report;
	}


	public void setCola(ColaDeFacturas cola) {
		this.cola = cola;
	}

	public void detenerHilo(){
		continuar = false;
	}
	
}
