/**
 * FEConsultaCAEResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class FEConsultaCAEResponse  implements java.io.Serializable {
	private static final long serialVersionUID = -698242845113386459L;

	private int resultado;

    private afip.facturaElectronica.handshake.wsfe.VError RError;

    public FEConsultaCAEResponse() {
    }

    public FEConsultaCAEResponse(
           int resultado,
           afip.facturaElectronica.handshake.wsfe.VError RError) {
           this.resultado = resultado;
           this.RError = RError;
    }


    /**
     * Gets the resultado value for this FEConsultaCAEResponse.
     * 
     * @return resultado
     */
    public int getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this FEConsultaCAEResponse.
     * 
     * @param resultado
     */
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the RError value for this FEConsultaCAEResponse.
     * 
     * @return RError
     */
    public afip.facturaElectronica.handshake.wsfe.VError getRError() {
        return RError;
    }


    /**
     * Sets the RError value for this FEConsultaCAEResponse.
     * 
     * @param RError
     */
    public void setRError(afip.facturaElectronica.handshake.wsfe.VError RError) {
        this.RError = RError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FEConsultaCAEResponse)) return false;
        FEConsultaCAEResponse other = (FEConsultaCAEResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.resultado == other.getResultado() &&
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
        _hashCode += getResultado();
        if (getRError() != null) {
            _hashCode += getRError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
