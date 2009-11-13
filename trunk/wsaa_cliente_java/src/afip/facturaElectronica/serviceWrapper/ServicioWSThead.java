package afip.facturaElectronica.serviceWrapper;

import java.util.List;

import afip.facturaElectronica.db.Factura;
import afip.facturaElectronica.db.commons.CompletaCAE;
import afip.facturaElectronica.db.dao.GlobalDAO;
import afip.facturaElectronica.handshake.wsaa.Afip_wsaa_conectar;
import afip.facturaElectronica.handshake.wsfe.FEResponse;
import afip.facturaElectronica.modelo.Afip_servicios;
import afip.facturaElectronica.modelo.Comprobante;

public class ServicioWSThead extends Thread  {

	// constructor
	ServicioWSThead() {
	}

	public void run() {
		try {
			// genero una instancia y me conecto para obtener el Token y Sign

			Afip_wsaa_conectar.conectarWSAA();

			Afip_servicios wsServicios = new Afip_servicios();

			/*
			 * boolean pepe = wsServicios.servicioDisponible(); if (pepe){
			 * String pae = "a"; pae.toString(); }
			 */
			/*
			 * Integer cantidad = null; cantidad =
			 * wsServicios.getCantidadMaximaRegistros();
			 * System.out.println(cantidad);
			 * 
			 * 
			 * Long ultimoID = null; ultimoID = wsServicios.getUltimoID();
			 * ultimoID.toString(); System.out.println(ultimoID);
			 */
			
			Comprobante cpr = new Comprobante(33709284509L, 1, 1007);

			Integer ultimoCpr = null;
			ultimoCpr = wsServicios.getUltimoNroComprobante(cpr.getTipoDeComprobante());
			System.out.println("");
			System.out.println(ultimoCpr);

			/*
			 * List<Factura> feDetalles = new ArrayList<Factura>(); Factura
			 * feDetalle1= new Factura();
			 * 
			 * feDetalle1.setTipo_doc(80); feDetalle1.setNro_doc(
			 * Long.valueOf("30707074570")); feDetalle1.setTipo_cbte(10);
			 * feDetalle1.setPunto_vta(1008); feDetalle1.setCbt_desde(1);
			 * feDetalle1.setCbt_hasta(1); feDetalle1.setImp_total(1949.77);
			 * feDetalle1.setImp_tot_conc(0.00);
			 * feDetalle1.setImp_neto(1611.38); feDetalle1.setImpto_liq(338.39);
			 * feDetalle1.setImpto_liq_rni(0.00); feDetalle1.setImp_op_ex(0.00);
			 * feDetalle1.setFecha_cbte("20080915");
			 * feDetalle1.setFecha_serv_desde("20080701");
			 * feDetalle1.setFecha_serv_hasta("20080730");
			 * feDetalle1.setFecha_venc_pago("20080920");
			 * 
			 * 
			 * feDetalles.add(feDetalle1);
			 * 
			 * FEResponse dato = wsServicios.enviarFacturas(feDetalles);
			 * dato.toString();
			 */

			/*
			 * List<Factura> facturas =
			 * GlobalDAO.getInstance().getFacturaDAO().getFacturas();
			 * 
			 * System.out.println(facturas.size());
			 * 
			 * for(Factura factura : facturas){
			 * System.out.println(factura.getFel_id_lote()); }
			 */
			/*
			 * List<TipoDeComprobante> tipoDeComprobantes =
			 * GlobalDAO.getInstance
			 * ().getTipoDeComprobanteDAO().getTipoDeComprobantes();
			 * System.out.println(tipoDeComprobantes.size());
			 * 
			 * for(TipoDeComprobante tipoDeComprobante : tipoDeComprobantes){
			 * System.out.println("-------------------------");
			 * System.out.println
			 * (tipoDeComprobante.getComprobantePK().getPunto_vta
			 * ()+" - "+tipoDeComprobante.getComprobantePK().getTipo_cbte());
			 * 
			 * List<Factura> facturas =
			 * GlobalDAO.getInstance().getFacturaDAO().getFacturas
			 * (tipoDeComprobante.getComprobantePK());
			 * 
			 * 
			 * for (Iterator<Factura> it = facturas.iterator(); it.hasNext(); )
			 * { System.out.println("   >"+it.next().getFecha_cbte()); }
			 * 
			 * }
			 */

			List<Factura> facturas = GlobalDAO.getInstance().getFacturaDAO()
					.getFacturas(cpr.getTipoDeComprobante().getComprobantePK());

			if (facturas.size() == 0) {
				throw new Exception("Error en cantidad");
			} else {
				FEResponse dato = wsServicios.enviarFacturas(cpr, 123L);
				dato.toString();

				CompletaCAE.completarCAE(facturas, dato);
				facturas.toString();

				GlobalDAO.getInstance().getFacturaDAO().saveFacturas(facturas);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
