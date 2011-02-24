
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriGeometryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriGeometryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriGeometryPoint"/>
 *     &lt;enumeration value="esriGeometryMultipoint"/>
 *     &lt;enumeration value="esriGeometryPolyline"/>
 *     &lt;enumeration value="esriGeometryPolygon"/>
 *     &lt;enumeration value="esriGeometryMultiPatch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriGeometryType")
@XmlEnum
public enum EsriGeometryType {


    /**
     * A single zero dimensional geometry.
     * 
     */
    @XmlEnumValue("esriGeometryPoint")
    ESRI_GEOMETRY_POINT("esriGeometryPoint"),

    /**
     * An ordered collection of points.
     * 
     */
    @XmlEnumValue("esriGeometryMultipoint")
    ESRI_GEOMETRY_MULTIPOINT("esriGeometryMultipoint"),

    /**
     * An ordered collection of paths.
     * 
     */
    @XmlEnumValue("esriGeometryPolyline")
    ESRI_GEOMETRY_POLYLINE("esriGeometryPolyline"),

    /**
     * A collection of rings ordered by their containment relationship.
     * 
     */
    @XmlEnumValue("esriGeometryPolygon")
    ESRI_GEOMETRY_POLYGON("esriGeometryPolygon"),

    /**
     * A collection of surface patches.
     * 
     */
    @XmlEnumValue("esriGeometryMultiPatch")
    ESRI_GEOMETRY_MULTI_PATCH("esriGeometryMultiPatch");
    private final String value;

    EsriGeometryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriGeometryType fromValue(String v) {
        for (EsriGeometryType c: EsriGeometryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
