/**
 * FERecuperaQTYResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class FERecuperaQTYResponse  implements java.io.Serializable {
    private afip.facturaElectronica.handshake.wsfe.FERecuperaQTY qty;

    private afip.facturaElectronica.handshake.wsfe.VError RError;

    public FERecuperaQTYResponse() {
    }

    public FERecuperaQTYResponse(
           afip.facturaElectronica.handshake.wsfe.FERecuperaQTY qty,
           afip.facturaElectronica.handshake.wsfe.VError RError) {
           this.qty = qty;
           this.RError = RError;
    }


    /**
     * Gets the qty value for this FERecuperaQTYResponse.
     * 
     * @return qty
     */
    public afip.facturaElectronica.handshake.wsfe.FERecuperaQTY getQty() {
        return qty;
    }


    /**
     * Sets the qty value for this FERecuperaQTYResponse.
     * 
     * @param qty
     */
    public void setQty(afip.facturaElectronica.handshake.wsfe.FERecuperaQTY qty) {
        this.qty = qty;
    }


    /**
     * Gets the RError value for this FERecuperaQTYResponse.
     * 
     * @return RError
     */
    public afip.facturaElectronica.handshake.wsfe.VError getRError() {
        return RError;
    }


    /**
     * Sets the RError value for this FERecuperaQTYResponse.
     * 
     * @param RError
     */
    public void setRError(afip.facturaElectronica.handshake.wsfe.VError RError) {
        this.RError = RError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FERecuperaQTYResponse)) return false;
        FERecuperaQTYResponse other = (FERecuperaQTYResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.qty==null && other.getQty()==null) || 
             (this.qty!=null &&
              this.qty.equals(other.getQty()))) &&
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
        if (getQty() != null) {
            _hashCode += getQty().hashCode();
        }
        if (getRError() != null) {
            _hashCode += getRError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
