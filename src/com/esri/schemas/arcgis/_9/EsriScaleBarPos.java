
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriScaleBarPos.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriScaleBarPos">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriScaleBarAbove"/>
 *     &lt;enumeration value="esriScaleBarBeforeLabels"/>
 *     &lt;enumeration value="esriScaleBarAfterLabels"/>
 *     &lt;enumeration value="esriScaleBarBeforeBar"/>
 *     &lt;enumeration value="esriScaleBarAfterBar"/>
 *     &lt;enumeration value="esriScaleBarBelow"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriScaleBarPos")
@XmlEnum
public enum EsriScaleBarPos {


    /**
     * Above bar and labels.
     * 
     */
    @XmlEnumValue("esriScaleBarAbove")
    ESRI_SCALE_BAR_ABOVE("esriScaleBarAbove"),

    /**
     * Before labels.
     * 
     */
    @XmlEnumValue("esriScaleBarBeforeLabels")
    ESRI_SCALE_BAR_BEFORE_LABELS("esriScaleBarBeforeLabels"),

    /**
     * After labels.
     * 
     */
    @XmlEnumValue("esriScaleBarAfterLabels")
    ESRI_SCALE_BAR_AFTER_LABELS("esriScaleBarAfterLabels"),

    /**
     * Before bar.
     * 
     */
    @XmlEnumValue("esriScaleBarBeforeBar")
    ESRI_SCALE_BAR_BEFORE_BAR("esriScaleBarBeforeBar"),

    /**
     * After bar.
     * 
     */
    @XmlEnumValue("esriScaleBarAfterBar")
    ESRI_SCALE_BAR_AFTER_BAR("esriScaleBarAfterBar"),

    /**
     * Below bar and labels.
     * 
     */
    @XmlEnumValue("esriScaleBarBelow")
    ESRI_SCALE_BAR_BELOW("esriScaleBarBelow");
    private final String value;

    EsriScaleBarPos(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriScaleBarPos fromValue(String v) {
        for (EsriScaleBarPos c: EsriScaleBarPos.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
