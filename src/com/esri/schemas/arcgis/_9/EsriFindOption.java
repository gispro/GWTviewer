
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriFindOption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriFindOption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriFindVisibleLayers"/>
 *     &lt;enumeration value="esriFindAllLayers"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriFindOption")
@XmlEnum
public enum EsriFindOption {


    /**
     * Visible layers.
     * 
     */
    @XmlEnumValue("esriFindVisibleLayers")
    ESRI_FIND_VISIBLE_LAYERS("esriFindVisibleLayers"),

    /**
     * All layers.
     * 
     */
    @XmlEnumValue("esriFindAllLayers")
    ESRI_FIND_ALL_LAYERS("esriFindAllLayers");
    private final String value;

    EsriFindOption(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriFindOption fromValue(String v) {
        for (EsriFindOption c: EsriFindOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
