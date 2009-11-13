/**
 * FEResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class FEResponse  implements java.io.Serializable {
	private static final long serialVersionUID = 4828236075185280702L;

	private afip.facturaElectronica.handshake.wsfe.FECabeceraResponse fecResp;

    private afip.facturaElectronica.handshake.wsfe.FEDetalleResponse[] fedResp;

    private afip.facturaElectronica.handshake.wsfe.VError RError;

    public FEResponse() {
    }

    public FEResponse(
           afip.facturaElectronica.handshake.wsfe.FECabeceraResponse fecResp,
           afip.facturaElectronica.handshake.wsfe.FEDetalleResponse[] fedResp,
           afip.facturaElectronica.handshake.wsfe.VError RError) {
           this.fecResp = fecResp;
           this.fedResp = fedResp;
           this.RError = RError;
    }


    /**
     * Gets the fecResp value for this FEResponse.
     * 
     * @return fecResp
     */
    public afip.facturaElectronica.handshake.wsfe.FECabeceraResponse getFecResp() {
        return fecResp;
    }


    /**
     * Sets the fecResp value for this FEResponse.
     * 
     * @param fecResp
     */
    public void setFecResp(afip.facturaElectronica.handshake.wsfe.FECabeceraResponse fecResp) {
        this.fecResp = fecResp;
    }


    /**
     * Gets the fedResp value for this FEResponse.
     * 
     * @return fedResp
     */
    public afip.facturaElectronica.handshake.wsfe.FEDetalleResponse[] getFedResp() {
        return fedResp;
    }


    /**
     * Sets the fedResp value for this FEResponse.
     * 
     * @param fedResp
     */
    public void setFedResp(afip.facturaElectronica.handshake.wsfe.FEDetalleResponse[] fedResp) {
        this.fedResp = fedResp;
    }


    /**
     * Gets the RError value for this FEResponse.
     * 
     * @return RError
     */
    public afip.facturaElectronica.handshake.wsfe.VError getRError() {
        return RError;
    }


    /**
     * Sets the RError value for this FEResponse.
     * 
     * @param RError
     */
    public void setRError(afip.facturaElectronica.handshake.wsfe.VError RError) {
        this.RError = RError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FEResponse)) return false;
        FEResponse other = (FEResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fecResp==null && other.getFecResp()==null) || 
             (this.fecResp!=null &&
              this.fecResp.equals(other.getFecResp()))) &&
            ((this.fedResp==null && other.getFedResp()==null) || 
             (this.fedResp!=null &&
              java.util.Arrays.equals(this.fedResp, other.getFedResp()))) &&
            ((this.RError==null && other.getRError()==null) || 
             (this.RError!=null &&
              this.RError.equals(other.getRError())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getFecResp() != null) {
            _hashCode += getFecResp().hashCode();
        }
        if (getFedResp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFedResp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFedResp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRError() != null) {
            _hashCode += getRError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
