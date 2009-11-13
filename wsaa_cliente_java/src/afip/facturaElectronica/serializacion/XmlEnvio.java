package afip.facturaElectronica.serializacion;

import afip.facturaElectronica.handshake.wsfe.FEAuthRequest;
import afip.facturaElectronica.handshake.wsfe.FERequest;

class XmlEnvio{
	FEAuthRequest feAuth;
	FERequest facturas;

	public XmlEnvio(FEAuthRequest feAuth, FERequest facturas){
		this.feAuth = feAuth;
		this.facturas = facturas;
	}

	public FEAuthRequest getFeAuth() {
		return feAuth;
	}

	public void setFeAuth(FEAuthRequest feAuth) {
		this.feAuth = feAuth;
	}

	public FERequest getFacturas() {
		return facturas;
	}

	public void setFacturas(FERequest facturas) {
		this.facturas = facturas;
	}
}
