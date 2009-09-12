/**
 * VError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class VError  implements java.io.Serializable {
    private int percode;

    private java.lang.String perrmsg;

    public VError() {
    }

    public VError(
           int percode,
           java.lang.String perrmsg) {
           this.percode = percode;
           this.perrmsg = perrmsg;
    }


    /**
     * Gets the percode value for this VError.
     * 
     * @return percode
     */
    public int getPercode() {
        return percode;
    }


    /**
     * Sets the percode value for this VError.
     * 
     * @param percode
     */
    public void setPercode(int percode) {
        this.percode = percode;
    }


    /**
     * Gets the perrmsg value for this VError.
     * 
     * @return perrmsg
     */
    public java.lang.String getPerrmsg() {
        return perrmsg;
    }


    /**
     * Sets the perrmsg value for this VError.
     * 
     * @param perrmsg
     */
    public void setPerrmsg(java.lang.String perrmsg) {
        this.perrmsg = perrmsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VError)) return false;
        VError other = (VError) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.percode == other.getPercode() &&
            ((this.perrmsg==null && other.getPerrmsg()==null) || 
             (this.perrmsg!=null &&
              this.perrmsg.equals(other.getPerrmsg())));
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
        _hashCode += getPercode();
        if (getPerrmsg() != null) {
            _hashCode += getPerrmsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
