/**
 * FELastCMPtype.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class FELastCMPtype  implements java.io.Serializable {
    private int ptoVta;

    private int tipoCbte;

    public FELastCMPtype() {
    }

    public FELastCMPtype(
           int ptoVta,
           int tipoCbte) {
           this.ptoVta = ptoVta;
           this.tipoCbte = tipoCbte;
    }


    /**
     * Gets the ptoVta value for this FELastCMPtype.
     * 
     * @return ptoVta
     */
    public int getPtoVta() {
        return ptoVta;
    }


    /**
     * Sets the ptoVta value for this FELastCMPtype.
     * 
     * @param ptoVta
     */
    public void setPtoVta(int ptoVta) {
        this.ptoVta = ptoVta;
    }


    /**
     * Gets the tipoCbte value for this FELastCMPtype.
     * 
     * @return tipoCbte
     */
    public int getTipoCbte() {
        return tipoCbte;
    }


    /**
     * Sets the tipoCbte value for this FELastCMPtype.
     * 
     * @param tipoCbte
     */
    public void setTipoCbte(int tipoCbte) {
        this.tipoCbte = tipoCbte;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FELastCMPtype)) return false;
        FELastCMPtype other = (FELastCMPtype) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ptoVta == other.getPtoVta() &&
            this.tipoCbte == other.getTipoCbte();
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
        _hashCode += getPtoVta();
        _hashCode += getTipoCbte();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
