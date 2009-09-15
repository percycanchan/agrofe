package afip.facturaElectronica.serializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import afip.facturaElectronica.db.Factura;
import afip.facturaElectronica.handshake.configuracion.FAConfiguracion;
import afip.facturaElectronica.handshake.exceptions.SerializationException;
import afip.facturaElectronica.handshake.wsfe.FECabeceraRequest;
import afip.facturaElectronica.handshake.wsfe.FECabeceraResponse;
import afip.facturaElectronica.handshake.wsfe.FEDetalleRequest;
import afip.facturaElectronica.handshake.wsfe.FEDetalleResponse;
import afip.facturaElectronica.handshake.wsfe.FERequest;
import afip.facturaElectronica.handshake.wsfe.FEResponse;
import afip.facturaElectronica.handshake.wsfe.VError;

import com.thoughtworks.xstream.XStream;

public class Serializer {
	XStream serializer;

	public Serializer() {
		serializer = new XStream();

		// Seteo alias para reducir el tamaño del XML
		serializer.alias("envio", FERequest.class);
		serializer.alias("factura", Factura.class);

		serializer.omitField(FECabeceraRequest.class, "__hashCodeCalc");
		serializer.omitField(FEDetalleRequest.class, "__hashCodeCalc");
		serializer.omitField(FERequest.class, "__hashCodeCalc");
		serializer.omitField(FEDetalleRequest.class, "tipo_doc");
		serializer.omitField(FEDetalleRequest.class, "nro_doc");
		serializer.omitField(FEDetalleRequest.class, "tipo_cbte");
		serializer.omitField(FEDetalleRequest.class, "punto_vta");
		serializer.omitField(FEDetalleRequest.class, "cbt_desde");
		serializer.omitField(FEDetalleRequest.class, "cbt_hasta");
		serializer.omitField(FEDetalleRequest.class, "imp_total");
		serializer.omitField(FEDetalleRequest.class, "imp_tot_conc");
		serializer.omitField(FEDetalleRequest.class, "imp_neto");
		serializer.omitField(FEDetalleRequest.class, "impto_liq");
		serializer.omitField(FEDetalleRequest.class, "impto_liq_rni");
		serializer.omitField(FEDetalleRequest.class, "imp_op_ex");
		 

		
		
		serializer.alias("respuesta", FEResponse.class);
		serializer.alias("detalleRespuesta", FEDetalleResponse.class);
		
		
		serializer.omitField(FECabeceraResponse.class, "__hashCodeCalc");
		serializer.omitField(FEResponse.class, "__hashCodeCalc");
		serializer.omitField(FEDetalleResponse.class, "__hashCodeCalc");
		serializer.omitField(VError.class, "__hashCodeCalc");

		// Utilizo como método de lectura / escritura de referencias el método
		// por ID, resulta
		// más fácil de entender y de trabajar a mano el archivo utilizando éste
		// método.
		serializer.setMode(XStream.ID_REFERENCES);
	}

	/*
	 * public Container leerContainer(String path) { try { FileInputStream
	 * stream = new FileInputStream(path); Container container =
	 * leerContainer(stream); stream.close(); return container; } catch
	 * (FileNotFoundException ex) { throw new
	 * SerializationException("No se encontró el archivo " + path + ".", ex); }
	 * catch (IOException ex) { throw new
	 * SerializationException("No se pudo leer el archivo " + path + ".", ex); }
	 * }
	 * 
	 * @SuppressWarnings("unchecked") public Container leerContainer(InputStream
	 * stream) { try { return (Container) serializer.fromXML(stream); } catch
	 * (Exception ex) { throw new
	 * SerializationException("No se pudo leer correctamente el XML.", ex); } }
	 */

	// Para el XML que se le envía a la AFIP
	public void escribirContainer(FERequest envio) {
		String path = FAConfiguracion.getInstance().getPathXML()
				+ envio.getFecr().getId() + "_"
				+ envio.getFedr()[1].getTipo_cbte() + "_"
				+ envio.getFedr()[1].getPunto_vta() + "_Envio.xml";

		try {
			FileOutputStream stream = new FileOutputStream(path);
			escribirContainer(envio, stream);
			stream.close();
		} catch (IOException ex) {
			throw new SerializationException("No se pudo escribir el archivo "
					+ path + ".", ex);
		}
	}

	// Escribe el archivo que se envió a la AFIP
	public void escribirContainer(FERequest envio, OutputStream stream) {
		try {
			serializer.toXML(envio, stream);
		} catch (Exception ex) {
			throw new SerializationException(
					"No se pudo escribir correctamente el XML.", ex);
		}
	}

	// Para el XML que se obtiene a la AFIP
	public void escribirContainer(FEResponse respuesta) {
		String path = FAConfiguracion.getInstance().getPathXML()
				+ respuesta.getFecResp().getId() + "_"
				+ respuesta.getFedResp()[1].getTipo_cbte() + "_"
				+ respuesta.getFedResp()[1].getPunto_vta() + "_Respuesta.xml";

		try {
			FileOutputStream stream = new FileOutputStream(path);
			escribirContainer(respuesta, stream);
			stream.close();
		} catch (IOException ex) {
			throw new SerializationException("No se pudo escribir el archivo "
					+ path + ".", ex);
		}
	}

	// Escribe el archivo obtenido de la AFIP
	public void escribirContainer(FEResponse container, OutputStream stream) {
		try {
			serializer.toXML(container, stream);
		} catch (Exception ex) {
			throw new SerializationException(
					"No se pudo escribir correctamente el XML.", ex);
		}
	}
}
