package ar.com.agromayor.main;

import java.io.IOException;
import java.util.Date;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import ar.com.agromayor.DB.Exceptions.DBExcetion;
import ar.com.agromayor.common.configuracion.ConfigDirectorios;
import ar.com.agromayor.common.configuracion.Configuracion;
import ar.com.agromayor.factura.ColaDeFacturas;
import ar.com.agromayor.factura.GenerarFacturaPDF;

public class Ejecutar {

	/**
	 * @param args
	 * @throws DBExcetion 
	 */
	public static void main(String[] args) throws DBExcetion {

		// Inicializo la configuración
		Configuracion.inicializar();

		// Seteo y Verifico la ruta del reporte fuente
		try {
			ConfigDirectorios.setRutaReporteFuente(System.getProperty("user.dir")+"\\src\\diseño\\");
			ConfigDirectorios.setRutaPDFBase(System.getProperty("user.dir")+"\\PDFs");
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}

		
		// Recompilo el reporte
		JasperReport report1 = null;
	
		ColaDeFacturas colaFacturas = null;
		try {			
			report1 = JasperCompileManager.compileReport(
					 ConfigDirectorios.rutaReporteFuente+"\\factura.jrxml");
			
			colaFacturas = new ColaDeFacturas();
			colaFacturas.inicializar();
			
		} catch (JRException e1) {
			e1.printStackTrace();
			System.exit(-1);
		} catch (DBExcetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Cantidad de Hilos a Ejecutar
		for (int i = 0; i < 4; i++) {
			
			GenerarFacturaPDF generar1 = new GenerarFacturaPDF();
			generar1.setCola(colaFacturas);
			generar1.setReport(report1);
			//generar1.run();
			generar1.start();
			System.out.println("Hilo "+i+" generado");
		}
		
		Date inicio = new Date();
		System.out.println("Inicio Principal: "+inicio);
		
	}
	


}

