
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriImageReturnType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriImageReturnType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriImageReturnURL"/>
 *     &lt;enumeration value="esriImageReturnMimeData"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriImageReturnType")
@XmlEnum
public enum EsriImageReturnType {


    /**
     * URL
     * 
     */
    @XmlEnumValue("esriImageReturnURL")
    ESRI_IMAGE_RETURN_URL("esriImageReturnURL"),

    /**
     * MimeData
     * 
     */
    @XmlEnumValue("esriImageReturnMimeData")
    ESRI_IMAGE_RETURN_MIME_DATA("esriImageReturnMimeData");
    private final String value;

    EsriImageReturnType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriImageReturnType fromValue(String v) {
        for (EsriImageReturnType c: EsriImageReturnType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
