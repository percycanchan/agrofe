/**
 * FEResponse_Helper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package afip.facturaElectronica.handshake.wsfe;

public class FEResponse_Helper {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FEResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecResp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FecResp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FECabeceraResponse"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fedResp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FedResp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEDetalleResponse"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "FEDetalleResponse"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "RError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.facturaelectronica/", "vError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
