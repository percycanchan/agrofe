/**
 * ServiceSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public interface ServiceSoap_PortType extends java.rmi.Remote {

    /**
     * Retorna la cantidad maxima de registros detalle que puede tener
     * una invocacion al FEAutorizarRequest
     */
    public afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse FERecuperaQTYRequest(afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth) throws java.rmi.RemoteException;

    /**
     * Metodo dummy para verificacion de funcionamiento
     */
    public afip.facturaElectronica.handshake.wsfe.DummyResponse FEDummy() throws java.rmi.RemoteException;

    /**
     * Retorna el ultimo comprobante autorizado  para el  tipo de
     * comprobante /cuit / punto  de venta ingresado
     */
    public afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse FERecuperaLastCMPRequest(afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth, afip.facturaElectronica.handshake.wsfe.FELastCMPtype argTCMP) throws java.rmi.RemoteException;

    /**
     * Retorna el ultimo número de Request.
     */
    public afip.facturaElectronica.handshake.wsfe.FEUltNroResponse FEUltNroRequest(afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth) throws java.rmi.RemoteException;

    /**
     * Dado un lote de comprobantes retorna el mismo  autorizado 
     * con el CAE otorgado
     */
    public afip.facturaElectronica.handshake.wsfe.FEResponse FEAutRequest(afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth, afip.facturaElectronica.handshake.wsfe.FERequest fer) throws java.rmi.RemoteException;

    /**
     * Consulta el CAE.
     */
    public afip.facturaElectronica.handshake.wsfe.FEConsultaCAEResponse FEConsultaCAERequest(afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth, afip.facturaElectronica.handshake.wsfe.FEConsultaCAEReq argCAERequest) throws java.rmi.RemoteException;
}
