
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriSearchOrder.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriSearchOrder">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriSearchOrderSpatial"/>
 *     &lt;enumeration value="esriSearchOrderAttribute"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriSearchOrder")
@XmlEnum
public enum EsriSearchOrder {


    /**
     * Spatial query is applied first.
     * 
     */
    @XmlEnumValue("esriSearchOrderSpatial")
    ESRI_SEARCH_ORDER_SPATIAL("esriSearchOrderSpatial"),

    /**
     * Attribute query is applied first.
     * 
     */
    @XmlEnumValue("esriSearchOrderAttribute")
    ESRI_SEARCH_ORDER_ATTRIBUTE("esriSearchOrderAttribute");
    private final String value;

    EsriSearchOrder(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriSearchOrder fromValue(String v) {
        for (EsriSearchOrder c: EsriSearchOrder.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
