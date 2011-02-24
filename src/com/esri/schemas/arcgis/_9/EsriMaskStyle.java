
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriMaskStyle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriMaskStyle">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriMSNone"/>
 *     &lt;enumeration value="esriMSHalo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriMaskStyle")
@XmlEnum
public enum EsriMaskStyle {


    /**
     * No mask.
     * 
     */
    @XmlEnumValue("esriMSNone")
    ESRI_MS_NONE("esriMSNone"),

    /**
     * The text mask style is halo.
     * 
     */
    @XmlEnumValue("esriMSHalo")
    ESRI_MS_HALO("esriMSHalo");
    private final String value;

    EsriMaskStyle(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriMaskStyle fromValue(String v) {
        for (EsriMaskStyle c: EsriMaskStyle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
