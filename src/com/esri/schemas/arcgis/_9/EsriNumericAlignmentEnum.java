
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriNumericAlignmentEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriNumericAlignmentEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriAlignRight"/>
 *     &lt;enumeration value="esriAlignLeft"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriNumericAlignmentEnum")
@XmlEnum
public enum EsriNumericAlignmentEnum {


    /**
     * Right-justify formatted numbers within the AlignmentWidth.
     * 
     */
    @XmlEnumValue("esriAlignRight")
    ESRI_ALIGN_RIGHT("esriAlignRight"),

    /**
     * Left-justify formatted numbers.
     * 
     */
    @XmlEnumValue("esriAlignLeft")
    ESRI_ALIGN_LEFT("esriAlignLeft");
    private final String value;

    EsriNumericAlignmentEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriNumericAlignmentEnum fromValue(String v) {
        for (EsriNumericAlignmentEnum c: EsriNumericAlignmentEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
