/**
 * FEUltNroResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class FEUltNroResponse  implements java.io.Serializable {
    private afip.facturaElectronica.handshake.wsfe.UltNroResponse nro;

    private afip.facturaElectronica.handshake.wsfe.VError RError;

    public FEUltNroResponse() {
    }

    public FEUltNroResponse(
           afip.facturaElectronica.handshake.wsfe.UltNroResponse nro,
           afip.facturaElectronica.handshake.wsfe.VError RError) {
           this.nro = nro;
           this.RError = RError;
    }


    /**
     * Gets the nro value for this FEUltNroResponse.
     * 
     * @return nro
     */
    public afip.facturaElectronica.handshake.wsfe.UltNroResponse getNro() {
        return nro;
    }


    /**
     * Sets the nro value for this FEUltNroResponse.
     * 
     * @param nro
     */
    public void setNro(afip.facturaElectronica.handshake.wsfe.UltNroResponse nro) {
        this.nro = nro;
    }


    /**
     * Gets the RError value for this FEUltNroResponse.
     * 
     * @return RError
     */
    public afip.facturaElectronica.handshake.wsfe.VError getRError() {
        return RError;
    }


    /**
     * Sets the RError value for this FEUltNroResponse.
     * 
     * @param RError
     */
    public void setRError(afip.facturaElectronica.handshake.wsfe.VError RError) {
        this.RError = RError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FEUltNroResponse)) return false;
        FEUltNroResponse other = (FEUltNroResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nro==null && other.getNro()==null) || 
             (this.nro!=null &&
              this.nro.equals(other.getNro()))) &&
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
        if (getNro() != null) {
            _hashCode += getNro().hashCode();
        }
        if (getRError() != null) {
            _hashCode += getRError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
