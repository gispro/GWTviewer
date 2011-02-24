
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriTextCase.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriTextCase">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriTCNormal"/>
 *     &lt;enumeration value="esriTCLowercase"/>
 *     &lt;enumeration value="esriTCAllCaps"/>
 *     &lt;enumeration value="esriTCSmallCaps"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriTextCase")
@XmlEnum
public enum EsriTextCase {


    /**
     * The text draws normally.
     * 
     */
    @XmlEnumValue("esriTCNormal")
    ESRI_TC_NORMAL("esriTCNormal"),

    /**
     * The text draws as all lowercase.
     * 
     */
    @XmlEnumValue("esriTCLowercase")
    ESRI_TC_LOWERCASE("esriTCLowercase"),

    /**
     * The text draws as all capitals.
     * 
     */
    @XmlEnumValue("esriTCAllCaps")
    ESRI_TC_ALL_CAPS("esriTCAllCaps"),

    /**
     * The text draws as small capitals.
     * 
     */
    @XmlEnumValue("esriTCSmallCaps")
    ESRI_TC_SMALL_CAPS("esriTCSmallCaps");
    private final String value;

    EsriTextCase(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriTextCase fromValue(String v) {
        for (EsriTextCase c: EsriTextCase.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
