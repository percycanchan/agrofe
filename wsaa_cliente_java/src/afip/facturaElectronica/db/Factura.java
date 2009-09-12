package afip.facturaElectronica.db;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;

import afip.facturaElectronica.db.commons.GenericObject;
import afip.facturaElectronica.handshake.wsfe.FEDetalleRequest;
import afip.facturaElectronica.handshake.wsfe.FEDetalleResponse;

/**
 * Clase que contiene la factura a enviar al WS-AFIP
 * @author lagromayor
 *
 */
@Entity(name="FEL_LOTES")
public class Factura extends FEDetalleRequest{ //extends FEDetalleResponse{//extends GenericObject{
	private long fel_id_lote;
	private int tipo_doc;
    private long nro_doc;
    private int tipo_cbte;
    private int punto_vta;
    private long cbt_desde;
    private long cbt_hasta;
    private double imp_total;
    private double imp_tot_conc;
    private double imp_neto;
    private double impto_liq;
    private double impto_liq_rni;
    private double imp_op_ex;
    private String fecha_cbte;
    private String fecha_serv_desde;
    private String fecha_serv_hasta;
    private String fecha_venc_pago;
    //
    private int estado;
    private Long cae;
    private String fecha_vto;
    private String resultado;
    private String motivo;
    private Long idEnvio;
	
    @Id
    @Column(name = "FEL_ID_LOTE", nullable = false, length = 20)
    public long getFel_id_lote() {
		return fel_id_lote;
	}
    
    @Column(name = "FEL_TIPO_DOC_COMPRADOR", nullable = false, length = 20)
    @Override
    public int getTipo_doc() {
		return tipo_doc;
	}
    
    @Column(name = "FEL_NRO_DOC_COMPRADOR", nullable = false, length = 100)
    @Override
	public long getNro_doc() {
		return nro_doc;
	}
    
    @Column(name = "FEL_TIPO_COMPROBANTE", nullable = false)
    @Override
	public int getTipo_cbte() {
		return tipo_cbte;
	}
    
    @Column(name = "FEL_PUNTO_VENTA", nullable = false)
    @Override
	public int getPunto_vta() {
		return punto_vta;
	}
    
    @Column(name = "FEL_COMPROBANTE_DESDE", nullable = false)
    @Override
	public long getCbt_desde() {
		return cbt_desde;
	}
    
    @Column(name = "FEL_COMPROBANTE_HASTA", nullable = false)
    @Override
	public long getCbt_hasta() {
		return cbt_hasta;
	}
    
    @Column(name = "FEL_IMPORTE_TOTAL", nullable = false)
    @Override
	public double getImp_total() {
		return imp_total;
	}
    
    @Column(name = "FEL_IMPORTE_TOTAL_CONC", nullable = false)
    @Override
	public double getImp_tot_conc() {
		return imp_tot_conc;
	}
    
    @Column(name = "FEL_IMPORTE_NETO_GRAVADO", nullable = false)
    @Override
	public double getImp_neto() {
		return imp_neto;
	}
    
    @Column(name = "FEL_IMPORTE_LIQUIDADO", nullable = false)
    @Override
	public double getImpto_liq() {
		return impto_liq;
	}
    
    @Column(name = "FEL_IMPORTE_LIQUIDADO_RNI", nullable = false)
    @Override
	public double getImpto_liq_rni() {
		return impto_liq_rni;
	}
    
    @Column(name = "FEL_IMPORTE_EXENTO", nullable = false)
    @Override
	public double getImp_op_ex() {
		return imp_op_ex;
	}
        
    @Column(name = "FEL_FECHA_COMPROBANTE_STRING", nullable = false)
    @Override
    public String getFecha_cbte() {
		return fecha_cbte;
	}
	
    @Column(name = "FEL_FECHA_SERV_DESDE_STRING", nullable = false)
    @Override
	public String getFecha_serv_desde() {
		return fecha_serv_desde;
	}

    @Column(name = "FEL_FECHA_SERV_HASTA_STRING", nullable = false, length = 20)
    @Override
	public String getFecha_serv_hasta() {
		return fecha_serv_hasta;
	}

    @Column(name = "FEL_FECHA_VTO_STRING", nullable = false)
    @Override
	public String getFecha_venc_pago() {
		return fecha_venc_pago;
	}
    
    @Column(name = "FEL_ESTADO", nullable = false)
    public int getEstado(){
    	return estado;
    }
    
    @Column(name = "FEL_CODIGO_CAE", nullable = true)
    public Long getCae(){
    	return cae;
    }

    @Column(name = "FEL_FECHA_VTO_CAE_STRING", nullable = true)
    public String getFecha_vto(){
    	return fecha_vto;
    }
    
    @Column(name = "FEL_MOTIVO", nullable = true, length = 500)
    public String getMotivo(){
    	return motivo;
    }

    @Column(name = "FEL_RESULTADO", nullable = true, length = 500)
    public String getResultado(){
    	return resultado;
    }
    
    @Column(name = "FEL_ID_ENVIO", nullable = true)
    public Long getIdEnvio(){
    	return idEnvio;
    }
    
    
    public void setFel_id_lote(long fel_id_lote) {
		this.fel_id_lote = fel_id_lote;
	}
    
    @Override
    public void setTipo_doc(int tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
    
    @Override
	public void setNro_doc(long nro_doc) {
		this.nro_doc = nro_doc;
	}
    
    @Override
	public void setTipo_cbte(int tipo_cbte) {
		this.tipo_cbte = tipo_cbte;
	}
    
    @Override
	public void setPunto_vta(int punto_vta) {
		this.punto_vta = punto_vta;
	}
    
    @Override
	public void setCbt_desde(long cbt_desde) {
		this.cbt_desde = cbt_desde;
	}
    
    @Override
	public void setCbt_hasta(long cbt_hasta) {
		this.cbt_hasta = cbt_hasta;
	}
    
    @Override
	public void setImp_total(double imp_total) {
		this.imp_total = imp_total;
	}
    
    @Override
	public void setImp_tot_conc(double imp_tot_conc) {
		this.imp_tot_conc = imp_tot_conc;
	}
    
    @Override
	public void setImp_neto(double imp_neto) {
		this.imp_neto = imp_neto;
	}
    
    @Override
	public void setImpto_liq(double impto_liq) {
		this.impto_liq = impto_liq;
	}
    
    @Override
	public void setImpto_liq_rni(double impto_liq_rni) {
		this.impto_liq_rni = impto_liq_rni;
	}
    
    @Override
	public void setImp_op_ex(double imp_op_ex) {
		this.imp_op_ex = imp_op_ex;
	}
    
    @Override
	public void setFecha_cbte(String fecha_cbte) {
		this.fecha_cbte = fecha_cbte;
	}
    
    @Override
	public void setFecha_serv_desde(String fecha_serv_desde) {
		this.fecha_serv_desde = fecha_serv_desde;
	}
    
    @Override
	public void setFecha_serv_hasta(String fecha_serv_hasta) {
		this.fecha_serv_hasta = fecha_serv_hasta;
	}
    
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}	
    
    @Override
	public void setFecha_venc_pago(String fecha_venc_pago) {
		this.fecha_venc_pago = fecha_venc_pago;
	}
    
	public void setEstado (int estado){
		this.estado = estado;
	}
	public void setCae (Long cae){
		this.cae = cae;
	}
	public void setFecha_vto (String fecha_vto){
		this.fecha_vto = fecha_vto;
	}
	public void setIdEnvio (Long idEnvio){
		this.idEnvio = idEnvio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;//super.hashCode();
		result = prime * result + (int) (this.cbt_desde ^ (this.cbt_desde >>> 32));
		result = prime * result + (int) (this.cbt_hasta ^ (this.cbt_hasta >>> 32));
		result = prime * result + this.punto_vta;
		result = prime * result + this.tipo_cbte;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		/*if (!super.equals(obj))
			return false;*/
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		if (this.cbt_desde != other.cbt_desde)
			return false;
		if (this.cbt_hasta != other.cbt_hasta)
			return false;
		if (this.punto_vta != other.punto_vta)
			return false;
		if (this.tipo_cbte != other.tipo_cbte)
			return false;
		return true;
	}
	
}
