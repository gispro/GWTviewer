
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriCachedMapServiceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriCachedMapServiceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriSingleFusedMapCache"/>
 *     &lt;enumeration value="esriIndividualLayerCaches"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriCachedMapServiceType")
@XmlEnum
public enum EsriCachedMapServiceType {


    /**
     * Single fused map cached service
     * 
     */
    @XmlEnumValue("esriSingleFusedMapCache")
    ESRI_SINGLE_FUSED_MAP_CACHE("esriSingleFusedMapCache"),

    /**
     * Separate layer cached service
     * 
     */
    @XmlEnumValue("esriIndividualLayerCaches")
    ESRI_INDIVIDUAL_LAYER_CACHES("esriIndividualLayerCaches");
    private final String value;

    EsriCachedMapServiceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriCachedMapServiceType fromValue(String v) {
        for (EsriCachedMapServiceType c: EsriCachedMapServiceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
