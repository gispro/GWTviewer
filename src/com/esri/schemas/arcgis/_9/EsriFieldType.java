
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriFieldType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriFieldType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriFieldTypeInteger"/>
 *     &lt;enumeration value="esriFieldTypeSmallInteger"/>
 *     &lt;enumeration value="esriFieldTypeDouble"/>
 *     &lt;enumeration value="esriFieldTypeSingle"/>
 *     &lt;enumeration value="esriFieldTypeString"/>
 *     &lt;enumeration value="esriFieldTypeDate"/>
 *     &lt;enumeration value="esriFieldTypeGeometry"/>
 *     &lt;enumeration value="esriFieldTypeOID"/>
 *     &lt;enumeration value="esriFieldTypeBlob"/>
 *     &lt;enumeration value="esriFieldTypeGlobalID"/>
 *     &lt;enumeration value="esriFieldTypeRaster"/>
 *     &lt;enumeration value="esriFieldTypeGUID"/>
 *     &lt;enumeration value="esriFieldTypeXML"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriFieldType")
@XmlEnum
public enum EsriFieldType {


    /**
     * Long Integer.
     * 
     */
    @XmlEnumValue("esriFieldTypeInteger")
    ESRI_FIELD_TYPE_INTEGER("esriFieldTypeInteger"),

    /**
     * Integer.
     * 
     */
    @XmlEnumValue("esriFieldTypeSmallInteger")
    ESRI_FIELD_TYPE_SMALL_INTEGER("esriFieldTypeSmallInteger"),

    /**
     * Double-precision floating-point number.
     * 
     */
    @XmlEnumValue("esriFieldTypeDouble")
    ESRI_FIELD_TYPE_DOUBLE("esriFieldTypeDouble"),

    /**
     * Single-precision floating-point number.
     * 
     */
    @XmlEnumValue("esriFieldTypeSingle")
    ESRI_FIELD_TYPE_SINGLE("esriFieldTypeSingle"),

    /**
     * Character string.
     * 
     */
    @XmlEnumValue("esriFieldTypeString")
    ESRI_FIELD_TYPE_STRING("esriFieldTypeString"),

    /**
     * Date.
     * 
     */
    @XmlEnumValue("esriFieldTypeDate")
    ESRI_FIELD_TYPE_DATE("esriFieldTypeDate"),

    /**
     * Geometry.
     * 
     */
    @XmlEnumValue("esriFieldTypeGeometry")
    ESRI_FIELD_TYPE_GEOMETRY("esriFieldTypeGeometry"),

    /**
     * Long Integer representing an object identifier.
     * 
     */
    @XmlEnumValue("esriFieldTypeOID")
    ESRI_FIELD_TYPE_OID("esriFieldTypeOID"),

    /**
     * Binary Large Object.
     * 
     */
    @XmlEnumValue("esriFieldTypeBlob")
    ESRI_FIELD_TYPE_BLOB("esriFieldTypeBlob"),

    /**
     * ESRI Global ID.
     * 
     */
    @XmlEnumValue("esriFieldTypeGlobalID")
    ESRI_FIELD_TYPE_GLOBAL_ID("esriFieldTypeGlobalID"),

    /**
     * Raster.
     * 
     */
    @XmlEnumValue("esriFieldTypeRaster")
    ESRI_FIELD_TYPE_RASTER("esriFieldTypeRaster"),

    /**
     * Globally Unique Identifier.
     * 
     */
    @XmlEnumValue("esriFieldTypeGUID")
    ESRI_FIELD_TYPE_GUID("esriFieldTypeGUID"),

    /**
     * XML Document
     * 
     */
    @XmlEnumValue("esriFieldTypeXML")
    ESRI_FIELD_TYPE_XML("esriFieldTypeXML");
    private final String value;

    EsriFieldType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriFieldType fromValue(String v) {
        for (EsriFieldType c: EsriFieldType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
