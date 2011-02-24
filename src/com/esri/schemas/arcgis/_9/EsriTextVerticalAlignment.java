
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriTextVerticalAlignment.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriTextVerticalAlignment">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriTVATop"/>
 *     &lt;enumeration value="esriTVACenter"/>
 *     &lt;enumeration value="esriTVABaseline"/>
 *     &lt;enumeration value="esriTVABottom"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriTextVerticalAlignment")
@XmlEnum
public enum EsriTextVerticalAlignment {


    /**
     * The text is aligned at the top.
     * 
     */
    @XmlEnumValue("esriTVATop")
    ESRI_TVA_TOP("esriTVATop"),

    /**
     * The text is aligned at the center.
     * 
     */
    @XmlEnumValue("esriTVACenter")
    ESRI_TVA_CENTER("esriTVACenter"),

    /**
     * The text is aligned at the baseline.
     * 
     */
    @XmlEnumValue("esriTVABaseline")
    ESRI_TVA_BASELINE("esriTVABaseline"),

    /**
     * The text is aligned at the bottom.
     * 
     */
    @XmlEnumValue("esriTVABottom")
    ESRI_TVA_BOTTOM("esriTVABottom");
    private final String value;

    EsriTextVerticalAlignment(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriTextVerticalAlignment fromValue(String v) {
        for (EsriTextVerticalAlignment c: EsriTextVerticalAlignment.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
