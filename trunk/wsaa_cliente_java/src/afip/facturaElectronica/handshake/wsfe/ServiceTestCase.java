/**
 * ServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class ServiceTestCase extends junit.framework.TestCase {
    public ServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testServiceSoapWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoapAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1ServiceSoapFERecuperaQTYRequest() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse value = null;
        value = binding.FERecuperaQTYRequest(new afip.facturaElectronica.handshake.wsfe.FEAuthRequest());
        // TBD - validate results
    }

    public void test2ServiceSoapFEDummy() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        afip.facturaElectronica.handshake.wsfe.DummyResponse value = null;
        value = binding.FEDummy();
        // TBD - validate results
        value.toString();
    }

    public void test3ServiceSoapFERecuperaLastCMPRequest() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse value = null;
        value = binding.FERecuperaLastCMPRequest(new afip.facturaElectronica.handshake.wsfe.FEAuthRequest(), new afip.facturaElectronica.handshake.wsfe.FELastCMPtype());
        // TBD - validate results
    }

    public void test4ServiceSoapFEUltNroRequest() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        afip.facturaElectronica.handshake.wsfe.FEUltNroResponse value = null;
        value = binding.FEUltNroRequest(new afip.facturaElectronica.handshake.wsfe.FEAuthRequest());
        // TBD - validate results
    }

    public void test5ServiceSoapFEAutRequest() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);
        
        // Test operation
        afip.facturaElectronica.handshake.wsfe.FEResponse value = null;
        value = binding.FEAutRequest(new afip.facturaElectronica.handshake.wsfe.FEAuthRequest(), new afip.facturaElectronica.handshake.wsfe.FERequest());
        // TBD - validate results
        value.toString();
    }

    public void test6ServiceSoapFEConsultaCAERequest() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap_BindingStub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        afip.facturaElectronica.handshake.wsfe.FEConsultaCAEResponse value = null;
        value = binding.FEConsultaCAERequest(new afip.facturaElectronica.handshake.wsfe.FEAuthRequest(), new afip.facturaElectronica.handshake.wsfe.FEConsultaCAEReq());
        // TBD - validate results
    }

    public void testServiceSoap12WSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap12Address() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test7ServiceSoap12FERecuperaQTYRequest() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse value = null;
        value = binding.FERecuperaQTYRequest(new afip.facturaElectronica.handshake.wsfe.FEAuthRequest());
        // TBD - validate results
    }

    public void test8ServiceSoap12FEDummy() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        afip.facturaElectronica.handshake.wsfe.DummyResponse value = null;
        value = binding.FEDummy();
        // TBD - validate results
    }

    public void test9ServiceSoap12FERecuperaLastCMPRequest() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse value = null;
        value = binding.FERecuperaLastCMPRequest(new afip.facturaElectronica.handshake.wsfe.FEAuthRequest(), new afip.facturaElectronica.handshake.wsfe.FELastCMPtype());
        // TBD - validate results
    }

    public void test10ServiceSoap12FEUltNroRequest() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        afip.facturaElectronica.handshake.wsfe.FEUltNroResponse value = null;
        value = binding.FEUltNroRequest(new afip.facturaElectronica.handshake.wsfe.FEAuthRequest());
        // TBD - validate results
    }

    public void test11ServiceSoap12FEAutRequest() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        afip.facturaElectronica.handshake.wsfe.FEResponse value = null;
        
        value = binding.FEAutRequest(new afip.facturaElectronica.handshake.wsfe.FEAuthRequest(), new afip.facturaElectronica.handshake.wsfe.FERequest());
        // TBD - validate results
    }

    public void test12ServiceSoap12FEConsultaCAERequest() throws Exception {
        afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub binding;
        try {
            binding = (afip.facturaElectronica.handshake.wsfe.ServiceSoap12Stub)
                          new afip.facturaElectronica.handshake.wsfe.ServiceLocator().getServiceSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        afip.facturaElectronica.handshake.wsfe.FEConsultaCAEResponse value = null;
        value = binding.FEConsultaCAERequest(new afip.facturaElectronica.handshake.wsfe.FEAuthRequest(), new afip.facturaElectronica.handshake.wsfe.FEConsultaCAEReq());
        // TBD - validate results
    }

}
