/**
 * ServiceSoap12Stub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

@SuppressWarnings("unchecked")
public class ServiceSoap12Stub extends org.apache.axis.client.Stub implements
		afip.facturaElectronica.handshake.wsfe.ServiceSoap_PortType {
	private java.util.Vector cachedSerClasses = new java.util.Vector();
	private java.util.Vector cachedSerQNames = new java.util.Vector();
	private java.util.Vector cachedSerFactories = new java.util.Vector();
	private java.util.Vector cachedDeserFactories = new java.util.Vector();

	static org.apache.axis.description.OperationDesc[] _operations;

	static {
		_operations = new org.apache.axis.description.OperationDesc[6];
		_initOperationDesc1();
	}

	private static void _initOperationDesc1() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("FERecuperaQTYRequest");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/", "argAuth"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/",
						"FEAuthRequest"),
				afip.facturaElectronica.handshake.wsfe.FEAuthRequest.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FERecuperaQTYResponse"));
		oper
				.setReturnClass(afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FERecuperaQTYRequestResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[0] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("FEDummy");
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "DummyResponse"));
		oper
				.setReturnClass(afip.facturaElectronica.handshake.wsfe.DummyResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "FEDummyResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[1] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("FERecuperaLastCMPRequest");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/", "argAuth"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/",
						"FEAuthRequest"),
				afip.facturaElectronica.handshake.wsfe.FEAuthRequest.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/", "argTCMP"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/",
						"FELastCMPtype"),
				afip.facturaElectronica.handshake.wsfe.FELastCMPtype.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FERecuperaLastCMPResponse"));
		oper
				.setReturnClass(afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FERecuperaLastCMPRequestResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[2] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("FEUltNroRequest");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/", "argAuth"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/",
						"FEAuthRequest"),
				afip.facturaElectronica.handshake.wsfe.FEAuthRequest.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEUltNroResponse"));
		oper
				.setReturnClass(afip.facturaElectronica.handshake.wsfe.FEUltNroResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEUltNroRequestResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[3] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("FEAutRequest");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/", "argAuth"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/",
						"FEAuthRequest"),
				afip.facturaElectronica.handshake.wsfe.FEAuthRequest.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/", "Fer"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/",
						"FERequest"),
				afip.facturaElectronica.handshake.wsfe.FERequest.class, false,
				false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "FEResponse"));
		oper
				.setReturnClass(afip.facturaElectronica.handshake.wsfe.FEResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEAutRequestResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[4] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("FEConsultaCAERequest");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/", "argAuth"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/",
						"FEAuthRequest"),
				afip.facturaElectronica.handshake.wsfe.FEAuthRequest.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/",
						"argCAERequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/",
						"FEConsultaCAEReq"),
				afip.facturaElectronica.handshake.wsfe.FEConsultaCAEReq.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEConsultaCAEResponse"));
		oper
				.setReturnClass(afip.facturaElectronica.handshake.wsfe.FEConsultaCAEResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEConsultaCAERequestResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[5] = oper;

	}

	public ServiceSoap12Stub() throws org.apache.axis.AxisFault {
		this(null);
	}

	public ServiceSoap12Stub(java.net.URL endpointURL,
			javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public ServiceSoap12Stub(javax.xml.rpc.Service service)
			throws org.apache.axis.AxisFault {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		((org.apache.axis.client.Service) super.service)
				.setTypeMappingVersion("1.2");
		java.lang.Class cls;
		javax.xml.namespace.QName qName;
		javax.xml.namespace.QName qName2;
		java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
		java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
/*		java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
		java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
		java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
		java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
		java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
		java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
		java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
		java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;*/
		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"ArrayOfFEDetalleRequest");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FEDetalleRequest[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEDetalleRequest");
		qName2 = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEDetalleRequest");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"ArrayOfFEDetalleResponse");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FEDetalleResponse[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEDetalleResponse");
		qName2 = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEDetalleResponse");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "DummyResponse");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.DummyResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "FEAuthRequest");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FEAuthRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FECabeceraRequest");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FECabeceraRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FECabeceraResponse");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FECabeceraResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEConsultaCAEReq");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FEConsultaCAEReq.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEConsultaCAEResponse");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FEConsultaCAEResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEDetalleRequest");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FEDetalleRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEDetalleResponse");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FEDetalleResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "FELastCMPtype");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FELastCMPtype.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FERecuperaLastCMPResponse");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "FERecuperaQTY");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FERecuperaQTY.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FERecuperaQTYResponse");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "FERequest");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FERequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "FEResponse");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FEResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEUltNroResponse");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.FEUltNroResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "UltNroResponse");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.UltNroResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "vError");
		cachedSerQNames.add(qName);
		cls = afip.facturaElectronica.handshake.wsfe.VError.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

	}

	protected org.apache.axis.client.Call createCall()
			throws java.rmi.RemoteException {
		try {
			org.apache.axis.client.Call _call = super._createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}
			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}
			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}
			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}
			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}
			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}
			java.util.Enumeration keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				java.lang.String key = (java.lang.String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}
			// All the type mapping information is registered
			// when the first call is made.
			// The type mapping information is actually registered in
			// the TypeMappingRegistry of the service, which
			// is the reason why registration is only needed for the first call.
			synchronized (this) {
				if (firstCall()) {
					// must set encoding style before registering serializers
					_call.setEncodingStyle(null);
					for (int i = 0; i < cachedSerFactories.size(); ++i) {
						java.lang.Class cls = (java.lang.Class) cachedSerClasses
								.get(i);
						javax.xml.namespace.QName qName = (javax.xml.namespace.QName) cachedSerQNames
								.get(i);
						java.lang.Object x = cachedSerFactories.get(i);
						if (x instanceof Class) {
							java.lang.Class sf = (java.lang.Class) cachedSerFactories
									.get(i);
							java.lang.Class df = (java.lang.Class) cachedDeserFactories
									.get(i);
							_call
									.registerTypeMapping(cls, qName, sf, df,
											false);
						} else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
							org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory) cachedSerFactories
									.get(i);
							org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory) cachedDeserFactories
									.get(i);
							_call
									.registerTypeMapping(cls, qName, sf, df,
											false);
						}
					}
				}
			}
			return _call;
		} catch (java.lang.Throwable _t) {
			throw new org.apache.axis.AxisFault(
					"Failure trying to get the Call object", _t);
		}
	}

	public afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse FERecuperaQTYRequest(
			afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[0]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://ar.gov.afip.dif.facturaelectronica/FERecuperaQTYRequest");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FERecuperaQTYRequest"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { argAuth });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									afip.facturaElectronica.handshake.wsfe.FERecuperaQTYResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public afip.facturaElectronica.handshake.wsfe.DummyResponse FEDummy()
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[1]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://ar.gov.afip.dif.facturaelectronica/FEDummy");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "FEDummy"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (afip.facturaElectronica.handshake.wsfe.DummyResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (afip.facturaElectronica.handshake.wsfe.DummyResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									afip.facturaElectronica.handshake.wsfe.DummyResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse FERecuperaLastCMPRequest(
			afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth,
			afip.facturaElectronica.handshake.wsfe.FELastCMPtype argTCMP)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[2]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://ar.gov.afip.dif.facturaelectronica/FERecuperaLastCMPRequest");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FERecuperaLastCMPRequest"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					argAuth, argTCMP });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									afip.facturaElectronica.handshake.wsfe.FERecuperaLastCMPResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public afip.facturaElectronica.handshake.wsfe.FEUltNroResponse FEUltNroRequest(
			afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[3]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://ar.gov.afip.dif.facturaelectronica/FEUltNroRequest");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
		_call
				.setOperationName(new javax.xml.namespace.QName(
						"http://ar.gov.afip.dif.facturaelectronica/",
						"FEUltNroRequest"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { argAuth });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (afip.facturaElectronica.handshake.wsfe.FEUltNroResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (afip.facturaElectronica.handshake.wsfe.FEUltNroResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									afip.facturaElectronica.handshake.wsfe.FEUltNroResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public afip.facturaElectronica.handshake.wsfe.FEResponse FEAutRequest(
			afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth,
			afip.facturaElectronica.handshake.wsfe.FERequest fer)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[4]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://ar.gov.afip.dif.facturaelectronica/FEAutRequest");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/", "FEAutRequest"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					argAuth, fer });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (afip.facturaElectronica.handshake.wsfe.FEResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (afip.facturaElectronica.handshake.wsfe.FEResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									afip.facturaElectronica.handshake.wsfe.FEResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public afip.facturaElectronica.handshake.wsfe.FEConsultaCAEResponse FEConsultaCAERequest(
			afip.facturaElectronica.handshake.wsfe.FEAuthRequest argAuth,
			afip.facturaElectronica.handshake.wsfe.FEConsultaCAEReq argCAERequest)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[5]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://ar.gov.afip.dif.facturaelectronica/FEConsultaCAERequest");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://ar.gov.afip.dif.facturaelectronica/",
				"FEConsultaCAERequest"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					argAuth, argCAERequest });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (afip.facturaElectronica.handshake.wsfe.FEConsultaCAEResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (afip.facturaElectronica.handshake.wsfe.FEConsultaCAEResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									afip.facturaElectronica.handshake.wsfe.FEConsultaCAEResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

}
