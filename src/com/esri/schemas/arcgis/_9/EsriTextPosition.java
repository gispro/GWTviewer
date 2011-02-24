
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriTextPosition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriTextPosition">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriTPNormal"/>
 *     &lt;enumeration value="esriTPSuperscript"/>
 *     &lt;enumeration value="esriTPSubscript"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriTextPosition")
@XmlEnum
public enum EsriTextPosition {


    /**
     * The text draws normally.
     * 
     */
    @XmlEnumValue("esriTPNormal")
    ESRI_TP_NORMAL("esriTPNormal"),

    /**
     * The text draws as superscript text.
     * 
     */
    @XmlEnumValue("esriTPSuperscript")
    ESRI_TP_SUPERSCRIPT("esriTPSuperscript"),

    /**
     * The text draws as subscript text.
     * 
     */
    @XmlEnumValue("esriTPSubscript")
    ESRI_TP_SUBSCRIPT("esriTPSubscript");
    private final String value;

    EsriTextPosition(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriTextPosition fromValue(String v) {
        for (EsriTextPosition c: EsriTextPosition.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
