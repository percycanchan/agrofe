/**
 * FECabeceraRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class FECabeceraRequest  implements java.io.Serializable {
    private long id;

    private int cantidadreg;

    private int presta_serv;

    public FECabeceraRequest() {
    }

    public FECabeceraRequest(
           long id,
           int cantidadreg,
           int presta_serv) {
           this.id = id;
           this.cantidadreg = cantidadreg;
           this.presta_serv = presta_serv;
    }


    /**
     * Gets the id value for this FECabeceraRequest.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this FECabeceraRequest.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the cantidadreg value for this FECabeceraRequest.
     * 
     * @return cantidadreg
     */
    public int getCantidadreg() {
        return cantidadreg;
    }


    /**
     * Sets the cantidadreg value for this FECabeceraRequest.
     * 
     * @param cantidadreg
     */
    public void setCantidadreg(int cantidadreg) {
        this.cantidadreg = cantidadreg;
    }


    /**
     * Gets the presta_serv value for this FECabeceraRequest.
     * 
     * @return presta_serv
     */
    public int getPresta_serv() {
        return presta_serv;
    }


    /**
     * Sets the presta_serv value for this FECabeceraRequest.
     * 
     * @param presta_serv
     */
    public void setPresta_serv(int presta_serv) {
        this.presta_serv = presta_serv;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FECabeceraRequest)) return false;
        FECabeceraRequest other = (FECabeceraRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            this.cantidadreg == other.getCantidadreg() &&
            this.presta_serv == other.getPresta_serv();
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
        _hashCode += new Long(getId()).hashCode();
        _hashCode += getCantidadreg();
        _hashCode += getPresta_serv();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
