
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriScaleBarResizeHint.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriScaleBarResizeHint">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriScaleBarFixed"/>
 *     &lt;enumeration value="esriScaleBarAutoDivision"/>
 *     &lt;enumeration value="esriScaleBarAutoDivisions"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriScaleBarResizeHint")
@XmlEnum
public enum EsriScaleBarResizeHint {


    /**
     * Use specified division and number of divisions.
     * 
     */
    @XmlEnumValue("esriScaleBarFixed")
    ESRI_SCALE_BAR_FIXED("esriScaleBarFixed"),

    /**
     * Use specified number of divisions and calculate division.
     * 
     */
    @XmlEnumValue("esriScaleBarAutoDivision")
    ESRI_SCALE_BAR_AUTO_DIVISION("esriScaleBarAutoDivision"),

    /**
     * Use specified division and calculate number of divisions.
     * 
     */
    @XmlEnumValue("esriScaleBarAutoDivisions")
    ESRI_SCALE_BAR_AUTO_DIVISIONS("esriScaleBarAutoDivisions");
    private final String value;

    EsriScaleBarResizeHint(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriScaleBarResizeHint fromValue(String v) {
        for (EsriScaleBarResizeHint c: EsriScaleBarResizeHint.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
