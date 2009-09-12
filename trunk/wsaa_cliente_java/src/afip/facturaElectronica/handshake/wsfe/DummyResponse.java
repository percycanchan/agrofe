/**
 * DummyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class DummyResponse  implements java.io.Serializable {
    private java.lang.String appserver;

    private java.lang.String dbserver;

    private java.lang.String authserver;

    public DummyResponse() {
    }

    public DummyResponse(
           java.lang.String appserver,
           java.lang.String dbserver,
           java.lang.String authserver) {
           this.appserver = appserver;
           this.dbserver = dbserver;
           this.authserver = authserver;
    }


    /**
     * Gets the appserver value for this DummyResponse.
     * 
     * @return appserver
     */
    public java.lang.String getAppserver() {
        return appserver;
    }


    /**
     * Sets the appserver value for this DummyResponse.
     * 
     * @param appserver
     */
    public void setAppserver(java.lang.String appserver) {
        this.appserver = appserver;
    }


    /**
     * Gets the dbserver value for this DummyResponse.
     * 
     * @return dbserver
     */
    public java.lang.String getDbserver() {
        return dbserver;
    }


    /**
     * Sets the dbserver value for this DummyResponse.
     * 
     * @param dbserver
     */
    public void setDbserver(java.lang.String dbserver) {
        this.dbserver = dbserver;
    }


    /**
     * Gets the authserver value for this DummyResponse.
     * 
     * @return authserver
     */
    public java.lang.String getAuthserver() {
        return authserver;
    }


    /**
     * Sets the authserver value for this DummyResponse.
     * 
     * @param authserver
     */
    public void setAuthserver(java.lang.String authserver) {
        this.authserver = authserver;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DummyResponse)) return false;
        DummyResponse other = (DummyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.appserver==null && other.getAppserver()==null) || 
             (this.appserver!=null &&
              this.appserver.equals(other.getAppserver()))) &&
            ((this.dbserver==null && other.getDbserver()==null) || 
             (this.dbserver!=null &&
              this.dbserver.equals(other.getDbserver()))) &&
            ((this.authserver==null && other.getAuthserver()==null) || 
             (this.authserver!=null &&
              this.authserver.equals(other.getAuthserver())));
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
        if (getAppserver() != null) {
            _hashCode += getAppserver().hashCode();
        }
        if (getDbserver() != null) {
            _hashCode += getDbserver().hashCode();
        }
        if (getAuthserver() != null) {
            _hashCode += getAuthserver().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
