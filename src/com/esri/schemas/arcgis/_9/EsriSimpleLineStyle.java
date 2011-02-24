
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriSimpleLineStyle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriSimpleLineStyle">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriSLSSolid"/>
 *     &lt;enumeration value="esriSLSDash"/>
 *     &lt;enumeration value="esriSLSDot"/>
 *     &lt;enumeration value="esriSLSDashDotDot"/>
 *     &lt;enumeration value="esriSLSNull"/>
 *     &lt;enumeration value="esriSLSInsideFrame"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriSimpleLineStyle")
@XmlEnum
public enum EsriSimpleLineStyle {


    /**
     * The line is solid.
     * 
     */
    @XmlEnumValue("esriSLSSolid")
    ESRI_SLS_SOLID("esriSLSSolid"),

    /**
     * The line is dashed -------.
     * 
     */
    @XmlEnumValue("esriSLSDash")
    ESRI_SLS_DASH("esriSLSDash"),

    /**
     * The line is dotted .......
     * 
     */
    @XmlEnumValue("esriSLSDot")
    ESRI_SLS_DOT("esriSLSDot"),

    /**
     * The line has alternating dashes and double dots _.._.._.
     * 
     */
    @XmlEnumValue("esriSLSDashDotDot")
    ESRI_SLS_DASH_DOT_DOT("esriSLSDashDotDot"),

    /**
     * The line is invisible.
     * 
     */
    @XmlEnumValue("esriSLSNull")
    ESRI_SLS_NULL("esriSLSNull"),

    /**
     * The line will fit into it's bounding rectangle, if any.
     * 
     */
    @XmlEnumValue("esriSLSInsideFrame")
    ESRI_SLS_INSIDE_FRAME("esriSLSInsideFrame");
    private final String value;

    EsriSimpleLineStyle(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriSimpleLineStyle fromValue(String v) {
        for (EsriSimpleLineStyle c: EsriSimpleLineStyle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
