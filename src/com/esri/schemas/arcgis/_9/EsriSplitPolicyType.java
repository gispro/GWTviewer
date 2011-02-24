
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriSplitPolicyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriSplitPolicyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriSPTGeometryRatio"/>
 *     &lt;enumeration value="esriSPTDuplicate"/>
 *     &lt;enumeration value="esriSPTDefaultValue"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriSplitPolicyType")
@XmlEnum
public enum EsriSplitPolicyType {


    /**
     * Geometry-ratioed split policy.
     * 
     */
    @XmlEnumValue("esriSPTGeometryRatio")
    ESRI_SPT_GEOMETRY_RATIO("esriSPTGeometryRatio"),

    /**
     * Duplicate split policy.
     * 
     */
    @XmlEnumValue("esriSPTDuplicate")
    ESRI_SPT_DUPLICATE("esriSPTDuplicate"),

    /**
     * Default value split policy.
     * 
     */
    @XmlEnumValue("esriSPTDefaultValue")
    ESRI_SPT_DEFAULT_VALUE("esriSPTDefaultValue");
    private final String value;

    EsriSplitPolicyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriSplitPolicyType fromValue(String v) {
        for (EsriSplitPolicyType c: EsriSplitPolicyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
