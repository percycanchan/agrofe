/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public interface Service extends javax.xml.rpc.Service {

/**
 * Web Service orientado  al  servicio  de Facturacion electronica
 */
    public java.lang.String getServiceSoapAddress();

    public afip.facturaElectronica.handshake.wsfe.ServiceSoap_PortType getServiceSoap() throws javax.xml.rpc.ServiceException;

    public afip.facturaElectronica.handshake.wsfe.ServiceSoap_PortType getServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getServiceSoap12Address();

    public afip.facturaElectronica.handshake.wsfe.ServiceSoap_PortType getServiceSoap12() throws javax.xml.rpc.ServiceException;

    public afip.facturaElectronica.handshake.wsfe.ServiceSoap_PortType getServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
