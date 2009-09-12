/**
 * ServiceSoap_BindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class ServiceSoap_BindingSkeleton implements afip.facturaElectronica.handshake.wsfe.ServiceSoap_PortType, org.apache.axis.wsdl.Skeleton {
    private afip.facturaElectronica.handshake.wsfe.ServiceSoap_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "argAuth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEAuthRequest"), afip.facturaElectronica.handshake.wsfe.FEAuthRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("FERecuperaQTYRequest", _params, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FERecuperaQTYRequestResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FERecuperaQTYResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FERecuperaQTYRequest"));
        _oper.setSoapAction("http://ar.gov.afip.dif.facturaelectronica/FERecuperaQTYRequest");
        _myOperationsList.add(_oper);
        if (_myOperations.get("FERecuperaQTYRequest") == null) {
            _myOperations.put("FERecuperaQTYRequest", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("FERecuperaQTYRequest")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("FEDummy", _params, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEDummyResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "DummyResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEDummy"));
        _oper.setSoapAction("http://ar.gov.afip.dif.facturaelectronica/FEDummy");
        _myOperationsList.add(_oper);
        if (_myOperations.get("FEDummy") == null) {
            _myOperations.put("FEDummy", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("FEDummy")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "argAuth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEAuthRequest"), afip.facturaElectronica.handshake.wsfe.FEAuthRequest.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "argTCMP"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FELastCMPtype"), afip.facturaElectronica.handshake.wsfe.FELastCMPtype.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("FERecuperaLastCMPRequest", _params, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FERecuperaLastCMPRequestResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FERecuperaLastCMPResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FERecuperaLastCMPRequest"));
        _oper.setSoapAction("http://ar.gov.afip.dif.facturaelectronica/FERecuperaLastCMPRequest");
        _myOperationsList.add(_oper);
        if (_myOperations.get("FERecuperaLastCMPRequest") == null) {
            _myOperations.put("FERecuperaLastCMPRequest", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("FERecuperaLastCMPRequest")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "argAuth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEAuthRequest"), afip.facturaElectronica.handshake.wsfe.FEAuthRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("FEUltNroRequest", _params, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEUltNroRequestResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEUltNroResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEUltNroRequest"));
        _oper.setSoapAction("http://ar.gov.afip.dif.facturaelectronica/FEUltNroRequest");
        _myOperationsList.add(_oper);
        if (_myOperations.get("FEUltNroRequest") == null) {
            _myOperations.put("FEUltNroRequest", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("FEUltNroRequest")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "argAuth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEAuthRequest"), afip.facturaElectronica.handshake.wsfe.FEAuthRequest.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "Fer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FERequest"), afip.facturaElectronica.handshake.wsfe.FERequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("FEAutRequest", _params, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEAutRequestResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEAutRequest"));
        _oper.setSoapAction("http://ar.gov.afip.dif.facturaelectronica/FEAutRequest");
        _myOperationsList.add(_oper);
        if (_myOperations.get("FEAutRequest") == null) {
            _myOperations.put("FEAutRequest", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("FEAutRequest")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "argAuth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEAuthRequest"), afip.facturaElectronica.handshake.wsfe.FEAuthRequest.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "argCAERequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEConsultaCAEReq"), afip.facturaElectronica.handshake.wsfe.FEConsultaCAEReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("FEConsultaCAERequest", _params, new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEConsultaCAERequestResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEConsultaCAEResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEConsultaCAERequest"));
        _oper.setSoapAction("http://ar.gov.afip.dif.facturaelectronica/FEConsultaCAERequest");
        _myOperationsList.add(_oper);
        if (_myOperations.get("FEConsultaCAERequest") == null) {
            _myOperations.put("FEConsultaCAERequest", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("FEConsultaCAERequest")).add(_oper);
    }

    public ServiceSoap_BindingSkeleton() {
        this.impl = new afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingImpl();
    }

    public ServiceSoap_BindingSkeleton(afip.facturaElectronica.handshake.wsfe.ServiceSoap_PortType impl) {
        this.impl = impl;
    }
    public afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse FERecuperaQTYRequest(afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth) throws java.rmi.RemoteException
    {
        afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse ret = impl.FERecuperaQTYRequest(argAuth);
        return ret;
    }

    public afip.facturaElectronica.handshake.wsfe.DummyResponse FEDummy() throws java.rmi.RemoteException
    {
        afip.facturaElectronica.handshake.wsfe.DummyResponse ret = impl.FEDummy();
        return ret;
    }

    public afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse FERecuperaLastCMPRequest(afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth, afip.facturaElectronica.handshake.wsfe.FELastCMPtype argTCMP) throws java.rmi.RemoteException
    {
        afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse ret = impl.FERecuperaLastCMPRequest(argAuth, argTCMP);
        return ret;
    }

    public afip.facturaElectronica.handshake.wsfe.FEUltNroResponse FEUltNroRequest(afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth) throws java.rmi.RemoteException
    {
        afip.facturaElectronica.handshake.wsfe.FEUltNroResponse ret = impl.FEUltNroRequest(argAuth);
        return ret;
    }

    public afip.facturaElectronica.handshake.wsfe.FEResponse FEAutRequest(afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth, afip.facturaElectronica.handshake.wsfe.FERequest fer) throws java.rmi.RemoteException
    {
        afip.facturaElectronica.handshake.wsfe.FEResponse ret = impl.FEAutRequest(argAuth, fer);
        return ret;
    }

    public afip.facturaElectronica.handshake.wsfe.FEConsultaCAEResponse FEConsultaCAERequest(afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth, afip.facturaElectronica.handshake.wsfe.FEConsultaCAEReq argCAERequest) throws java.rmi.RemoteException
    {
        afip.facturaElectronica.handshake.wsfe.FEConsultaCAEResponse ret = impl.FEConsultaCAERequest(argAuth, argCAERequest);
        return ret;
    }

}
