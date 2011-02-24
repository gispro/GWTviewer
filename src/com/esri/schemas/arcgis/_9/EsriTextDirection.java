
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriTextDirection.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriTextDirection">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriTDHorizontal"/>
 *     &lt;enumeration value="esriTDAngle"/>
 *     &lt;enumeration value="esriTDVertical"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriTextDirection")
@XmlEnum
public enum EsriTextDirection {


    /**
     * The text draws horizontally.
     * 
     */
    @XmlEnumValue("esriTDHorizontal")
    ESRI_TD_HORIZONTAL("esriTDHorizontal"),

    /**
     * The text draws along an angle.
     * 
     */
    @XmlEnumValue("esriTDAngle")
    ESRI_TD_ANGLE("esriTDAngle"),

    /**
     * The text draws vertically.
     * 
     */
    @XmlEnumValue("esriTDVertical")
    ESRI_TD_VERTICAL("esriTDVertical");
    private final String value;

    EsriTextDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriTextDirection fromValue(String v) {
        for (EsriTextDirection c: EsriTextDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
