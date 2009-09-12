/**
 * FERecuperaQTY.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class FERecuperaQTY  implements java.io.Serializable {
    private int value;

    public FERecuperaQTY() {
    }

    public FERecuperaQTY(
           int value) {
           this.value = value;
    }


    /**
     * Gets the value value for this FERecuperaQTY.
     * 
     * @return value
     */
    public int getValue() {
        return value;
    }


    /**
     * Sets the value value for this FERecuperaQTY.
     * 
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FERecuperaQTY)) return false;
        FERecuperaQTY other = (FERecuperaQTY) obj;
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
        _hashCode += getValue();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
