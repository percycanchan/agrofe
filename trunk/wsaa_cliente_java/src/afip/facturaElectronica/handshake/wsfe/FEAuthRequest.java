/**
 * FEAuthRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

import afip.facturaElectronica.handshake.configuracion.FAConfiguracion;

public class FEAuthRequest  implements java.io.Serializable {
	private static final long serialVersionUID = -6233166783729634745L;

	private java.lang.String token;

    private java.lang.String sign;

    private long cuit;

    /**
     * Genera la Cabecera de Autenticación con los datos autmaticamente
     */
    public FEAuthRequest(long cuit) {
		this.cuit= cuit;
		this.sign = FAConfiguracion.getDatos_wsaa().getSign();
		this.token = FAConfiguracion.getDatos_wsaa().getToken();
    	
    }
    
    @SuppressWarnings("unused")
	private FEAuthRequest(){}

    /**
     * Gets the token value for this FEAuthRequest.
     * 
     * @return token
     */
    public java.lang.String getToken() {
        return token;
    }


    /**
     * Sets the token value for this FEAuthRequest.
     * 
     * @param token
     */
    public void setToken(java.lang.String token) {
        this.token = token;
    }


    /**
     * Gets the sign value for this FEAuthRequest.
     * 
     * @return sign
     */
    public java.lang.String getSign() {
        return sign;
    }


    /**
     * Sets the sign value for this FEAuthRequest.
     * 
     * @param sign
     */
    public void setSign(java.lang.String sign) {
        this.sign = sign;
    }


    /**
     * Gets the cuit value for this FEAuthRequest.
     * 
     * @return cuit
     */
    public long getCuit() {
        return cuit;
    }


    /**
     * Sets the cuit value for this FEAuthRequest.
     * 
     * @param cuit
     */
    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FEAuthRequest)) return false;
        FEAuthRequest other = (FEAuthRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.token==null && other.getToken()==null) || 
             (this.token!=null &&
              this.token.equals(other.getToken()))) &&
            ((this.sign==null && other.getSign()==null) || 
             (this.sign!=null &&
              this.sign.equals(other.getSign()))) &&
            this.cuit == other.getCuit();
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
        if (getToken() != null) {
            _hashCode += getToken().hashCode();
        }
        if (getSign() != null) {
            _hashCode += getSign().hashCode();
        }
        _hashCode += new Long(getCuit()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
