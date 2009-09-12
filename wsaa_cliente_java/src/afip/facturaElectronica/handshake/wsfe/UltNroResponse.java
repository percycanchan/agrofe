/**
 * UltNroResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class UltNroResponse  implements java.io.Serializable {
    private long value;

    public UltNroResponse() {
    }

    public UltNroResponse(
           long value) {
           this.value = value;
    }


    /**
     * Gets the value value for this UltNroResponse.
     * 
     * @return value
     */
    public long getValue() {
        return value;
    }


    /**
     * Sets the value value for this UltNroResponse.
     * 
     * @param value
     */
    public void setValue(long value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UltNroResponse)) return false;
        UltNroResponse other = (UltNroResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.value == other.getValue();
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
        _hashCode += new Long(getValue()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
