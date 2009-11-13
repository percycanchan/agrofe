/**
 * FERecuperaLastCMPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class FERecuperaLastCMPResponse  implements java.io.Serializable {
	private static final long serialVersionUID = 28256730830247371L;

	private int cbte_nro;

    private afip.facturaElectronica.handshake.wsfe.VError RError;

    public FERecuperaLastCMPResponse() {
    }

    public FERecuperaLastCMPResponse(
           int cbte_nro,
           afip.facturaElectronica.handshake.wsfe.VError RError) {
           this.cbte_nro = cbte_nro;
           this.RError = RError;
    }


    /**
     * Gets the cbte_nro value for this FERecuperaLastCMPResponse.
     * 
     * @return cbte_nro
     */
    public int getCbte_nro() {
        return cbte_nro;
    }


    /**
     * Sets the cbte_nro value for this FERecuperaLastCMPResponse.
     * 
     * @param cbte_nro
     */
    public void setCbte_nro(int cbte_nro) {
        this.cbte_nro = cbte_nro;
    }


    /**
     * Gets the RError value for this FERecuperaLastCMPResponse.
     * 
     * @return RError
     */
    public afip.facturaElectronica.handshake.wsfe.VError getRError() {
        return RError;
    }


    /**
     * Sets the RError value for this FERecuperaLastCMPResponse.
     * 
     * @param RError
     */
    public void setRError(afip.facturaElectronica.handshake.wsfe.VError RError) {
        this.RError = RError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FERecuperaLastCMPResponse)) return false;
        FERecuperaLastCMPResponse other = (FERecuperaLastCMPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cbte_nro == other.getCbte_nro() &&
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
        _hashCode += getCbte_nro();
        if (getRError() != null) {
            _hashCode += getRError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
