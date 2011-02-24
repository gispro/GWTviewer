
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriScaleBarFrequency.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriScaleBarFrequency">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriScaleBarNone"/>
 *     &lt;enumeration value="esriScaleBarOne"/>
 *     &lt;enumeration value="esriScaleBarMajorDivisions"/>
 *     &lt;enumeration value="esriScaleBarDivisions"/>
 *     &lt;enumeration value="esriScaleBarDivisionsAndFirstMidpoint"/>
 *     &lt;enumeration value="esriScaleBarDivisionsAndFirstSubdivisions"/>
 *     &lt;enumeration value="esriScaleBarDivisionsAndSubdivisions"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriScaleBarFrequency")
@XmlEnum
public enum EsriScaleBarFrequency {


    /**
     * None.
     * 
     */
    @XmlEnumValue("esriScaleBarNone")
    ESRI_SCALE_BAR_NONE("esriScaleBarNone"),

    /**
     * Midpoint.
     * 
     */
    @XmlEnumValue("esriScaleBarOne")
    ESRI_SCALE_BAR_ONE("esriScaleBarOne"),

    /**
     * Ends and zero.
     * 
     */
    @XmlEnumValue("esriScaleBarMajorDivisions")
    ESRI_SCALE_BAR_MAJOR_DIVISIONS("esriScaleBarMajorDivisions"),

    /**
     * All divisions.
     * 
     */
    @XmlEnumValue("esriScaleBarDivisions")
    ESRI_SCALE_BAR_DIVISIONS("esriScaleBarDivisions"),

    /**
     * All divisions plus midpoint of first interval.
     * 
     */
    @XmlEnumValue("esriScaleBarDivisionsAndFirstMidpoint")
    ESRI_SCALE_BAR_DIVISIONS_AND_FIRST_MIDPOINT("esriScaleBarDivisionsAndFirstMidpoint"),

    /**
     * All divisions plus subdivisions in first interval.
     * 
     */
    @XmlEnumValue("esriScaleBarDivisionsAndFirstSubdivisions")
    ESRI_SCALE_BAR_DIVISIONS_AND_FIRST_SUBDIVISIONS("esriScaleBarDivisionsAndFirstSubdivisions"),

    /**
     * All divisions and all subdivisions.
     * 
     */
    @XmlEnumValue("esriScaleBarDivisionsAndSubdivisions")
    ESRI_SCALE_BAR_DIVISIONS_AND_SUBDIVISIONS("esriScaleBarDivisionsAndSubdivisions");
    private final String value;

    EsriScaleBarFrequency(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriScaleBarFrequency fromValue(String v) {
        for (EsriScaleBarFrequency c: EsriScaleBarFrequency.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
