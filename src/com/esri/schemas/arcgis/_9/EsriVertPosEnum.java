
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriVertPosEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriVertPosEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriAbove"/>
 *     &lt;enumeration value="esriTop"/>
 *     &lt;enumeration value="esriOn"/>
 *     &lt;enumeration value="esriBottom"/>
 *     &lt;enumeration value="esriBelow"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriVertPosEnum")
@XmlEnum
public enum EsriVertPosEnum {


    /**
     * Positioned above scalebar.
     * 
     */
    @XmlEnumValue("esriAbove")
    ESRI_ABOVE("esriAbove"),

    /**
     * Aligned with top of scalebar.
     * 
     */
    @XmlEnumValue("esriTop")
    ESRI_TOP("esriTop"),

    /**
     * Vertically centered on scalebar.
     * 
     */
    @XmlEnumValue("esriOn")
    ESRI_ON("esriOn"),

    /**
     * Aligned with bottom of scalebar.
     * 
     */
    @XmlEnumValue("esriBottom")
    ESRI_BOTTOM("esriBottom"),

    /**
     * Positioned below scalebar.
     * 
     */
    @XmlEnumValue("esriBelow")
    ESRI_BELOW("esriBelow");
    private final String value;

    EsriVertPosEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriVertPosEnum fromValue(String v) {
        for (EsriVertPosEnum c: EsriVertPosEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
