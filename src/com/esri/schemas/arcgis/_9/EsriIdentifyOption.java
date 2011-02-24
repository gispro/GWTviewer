
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriIdentifyOption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriIdentifyOption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriIdentifyTopmost"/>
 *     &lt;enumeration value="esriIdentifyAllLayers"/>
 *     &lt;enumeration value="esriIdentifyVisibleLayers"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriIdentifyOption")
@XmlEnum
public enum EsriIdentifyOption {


    /**
     * Topmost JSONLayer.
     * 
     */
    @XmlEnumValue("esriIdentifyTopmost")
    ESRI_IDENTIFY_TOPMOST("esriIdentifyTopmost"),

    /**
     * All layers.
     * 
     */
    @XmlEnumValue("esriIdentifyAllLayers")
    ESRI_IDENTIFY_ALL_LAYERS("esriIdentifyAllLayers"),

    /**
     * Visible layers.
     * 
     */
    @XmlEnumValue("esriIdentifyVisibleLayers")
    ESRI_IDENTIFY_VISIBLE_LAYERS("esriIdentifyVisibleLayers");
    private final String value;

    EsriIdentifyOption(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriIdentifyOption fromValue(String v) {
        for (EsriIdentifyOption c: EsriIdentifyOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
