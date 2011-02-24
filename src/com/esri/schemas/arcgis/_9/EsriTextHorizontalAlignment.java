
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriTextHorizontalAlignment.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriTextHorizontalAlignment">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriTHALeft"/>
 *     &lt;enumeration value="esriTHACenter"/>
 *     &lt;enumeration value="esriTHARight"/>
 *     &lt;enumeration value="esriTHAFull"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriTextHorizontalAlignment")
@XmlEnum
public enum EsriTextHorizontalAlignment {


    /**
     * The text is left justified.
     * 
     */
    @XmlEnumValue("esriTHALeft")
    ESRI_THA_LEFT("esriTHALeft"),

    /**
     * The text is center justified.
     * 
     */
    @XmlEnumValue("esriTHACenter")
    ESRI_THA_CENTER("esriTHACenter"),

    /**
     * The text is right justified.
     * 
     */
    @XmlEnumValue("esriTHARight")
    ESRI_THA_RIGHT("esriTHARight"),

    /**
     * The text is fully justified.
     * 
     */
    @XmlEnumValue("esriTHAFull")
    ESRI_THA_FULL("esriTHAFull");
    private final String value;

    EsriTextHorizontalAlignment(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriTextHorizontalAlignment fromValue(String v) {
        for (EsriTextHorizontalAlignment c: EsriTextHorizontalAlignment.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
