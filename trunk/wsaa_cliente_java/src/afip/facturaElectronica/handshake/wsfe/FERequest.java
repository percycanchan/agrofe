/**
 * FERequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class FERequest  implements java.io.Serializable {
	private static final long serialVersionUID = 4292327414120214105L;

	private afip.facturaElectronica.handshake.wsfe.FECabeceraRequest fecr;

    private afip.facturaElectronica.handshake.wsfe.FEDetalleRequest[] fedr;

    public FERequest() {
    }

    public FERequest(
           afip.facturaElectronica.handshake.wsfe.FECabeceraRequest fecr,
           afip.facturaElectronica.handshake.wsfe.FEDetalleRequest[] fedr) {
           this.fecr = fecr;
           this.fedr = fedr;
    }


    /**
     * Gets the fecr value for this FERequest.
     * 
     * @return fecr
     */
    public afip.facturaElectronica.handshake.wsfe.FECabeceraRequest getFecr() {
        return fecr;
    }


    /**
     * Sets the fecr value for this FERequest.
     * 
     * @param fecr
     */
    public void setFecr(afip.facturaElectronica.handshake.wsfe.FECabeceraRequest fecr) {
        this.fecr = fecr;
    }


    /**
     * Gets the fedr value for this FERequest.
     * 
     * @return fedr
     */
    public afip.facturaElectronica.handshake.wsfe.FEDetalleRequest[] getFedr() {
        return fedr;
    }


    /**
     * Sets the fedr value for this FERequest.
     * 
     * @param fedr
     */
    public void setFedr(afip.facturaElectronica.handshake.wsfe.FEDetalleRequest[] fedr) {
        this.fedr = fedr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FERequest)) return false;
        FERequest other = (FERequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fecr==null && other.getFecr()==null) || 
             (this.fecr!=null &&
              this.fecr.equals(other.getFecr()))) &&
            ((this.fedr==null && other.getFedr()==null) || 
             (this.fedr!=null &&
              java.util.Arrays.equals(this.fedr, other.getFedr())));
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
        if (getFecr() != null) {
            _hashCode += getFecr().hashCode();
        }
        if (getFedr() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFedr());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFedr(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
