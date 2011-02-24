
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriSimpleMarkerStyle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriSimpleMarkerStyle">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriSMSCircle"/>
 *     &lt;enumeration value="esriSMSSquare"/>
 *     &lt;enumeration value="esriSMSCross"/>
 *     &lt;enumeration value="esriSMSX"/>
 *     &lt;enumeration value="esriSMSDiamond"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriSimpleMarkerStyle")
@XmlEnum
public enum EsriSimpleMarkerStyle {


    /**
     * The marker is a circle.
     * 
     */
    @XmlEnumValue("esriSMSCircle")
    ESRI_SMS_CIRCLE("esriSMSCircle"),

    /**
     * The marker is a square.
     * 
     */
    @XmlEnumValue("esriSMSSquare")
    ESRI_SMS_SQUARE("esriSMSSquare"),

    /**
     * The marker is a cross.
     * 
     */
    @XmlEnumValue("esriSMSCross")
    ESRI_SMS_CROSS("esriSMSCross"),

    /**
     * The marker is an X.
     * 
     */
    @XmlEnumValue("esriSMSX")
    ESRI_SMSX("esriSMSX"),

    /**
     * The marker is a diamond.
     * 
     */
    @XmlEnumValue("esriSMSDiamond")
    ESRI_SMS_DIAMOND("esriSMSDiamond");
    private final String value;

    EsriSimpleMarkerStyle(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriSimpleMarkerStyle fromValue(String v) {
        for (EsriSimpleMarkerStyle c: EsriSimpleMarkerStyle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
