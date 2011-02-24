
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriSpatialRelEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriSpatialRelEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriSpatialRelUndefined"/>
 *     &lt;enumeration value="esriSpatialRelIntersects"/>
 *     &lt;enumeration value="esriSpatialRelEnvelopeIntersects"/>
 *     &lt;enumeration value="esriSpatialRelIndexIntersects"/>
 *     &lt;enumeration value="esriSpatialRelTouches"/>
 *     &lt;enumeration value="esriSpatialRelOverlaps"/>
 *     &lt;enumeration value="esriSpatialRelCrosses"/>
 *     &lt;enumeration value="esriSpatialRelWithin"/>
 *     &lt;enumeration value="esriSpatialRelContains"/>
 *     &lt;enumeration value="esriSpatialRelRelation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriSpatialRelEnum")
@XmlEnum
public enum EsriSpatialRelEnum {


    /**
     * No Defined Spatial Relationship.
     * 
     */
    @XmlEnumValue("esriSpatialRelUndefined")
    ESRI_SPATIAL_REL_UNDEFINED("esriSpatialRelUndefined"),

    /**
     * Query Geometry Intersects Target Geometry.
     * 
     */
    @XmlEnumValue("esriSpatialRelIntersects")
    ESRI_SPATIAL_REL_INTERSECTS("esriSpatialRelIntersects"),

    /**
     * Envelope of Query Geometry Intersects Envelope of Target Geometry.
     * 
     */
    @XmlEnumValue("esriSpatialRelEnvelopeIntersects")
    ESRI_SPATIAL_REL_ENVELOPE_INTERSECTS("esriSpatialRelEnvelopeIntersects"),

    /**
     * Query Geometry Intersects Index entry for Target Geometry (Primary Index Filter).
     * 
     */
    @XmlEnumValue("esriSpatialRelIndexIntersects")
    ESRI_SPATIAL_REL_INDEX_INTERSECTS("esriSpatialRelIndexIntersects"),

    /**
     * Query Geometry Touches Target Geometry.
     * 
     */
    @XmlEnumValue("esriSpatialRelTouches")
    ESRI_SPATIAL_REL_TOUCHES("esriSpatialRelTouches"),

    /**
     * Query Geometry Overlaps Target Geometry.
     * 
     */
    @XmlEnumValue("esriSpatialRelOverlaps")
    ESRI_SPATIAL_REL_OVERLAPS("esriSpatialRelOverlaps"),

    /**
     * Query Geometry Crosses Target Geometry.
     * 
     */
    @XmlEnumValue("esriSpatialRelCrosses")
    ESRI_SPATIAL_REL_CROSSES("esriSpatialRelCrosses"),

    /**
     * Query Geometry is Within Target Geometry.
     * 
     */
    @XmlEnumValue("esriSpatialRelWithin")
    ESRI_SPATIAL_REL_WITHIN("esriSpatialRelWithin"),

    /**
     * Query Geometry Contains Target Geometry.
     * 
     */
    @XmlEnumValue("esriSpatialRelContains")
    ESRI_SPATIAL_REL_CONTAINS("esriSpatialRelContains"),

    /**
     * Query geometry IBE(Interior-Boundary-Exterior) relationship with target geometry.
     * 
     */
    @XmlEnumValue("esriSpatialRelRelation")
    ESRI_SPATIAL_REL_RELATION("esriSpatialRelRelation");
    private final String value;

    EsriSpatialRelEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriSpatialRelEnum fromValue(String v) {
        for (EsriSpatialRelEnum c: EsriSpatialRelEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
