
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriUnits.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriUnits">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriUnknownUnits"/>
 *     &lt;enumeration value="esriInches"/>
 *     &lt;enumeration value="esriPoints"/>
 *     &lt;enumeration value="esriFeet"/>
 *     &lt;enumeration value="esriYards"/>
 *     &lt;enumeration value="esriMiles"/>
 *     &lt;enumeration value="esriNauticalMiles"/>
 *     &lt;enumeration value="esriMillimeters"/>
 *     &lt;enumeration value="esriCentimeters"/>
 *     &lt;enumeration value="esriMeters"/>
 *     &lt;enumeration value="esriKilometers"/>
 *     &lt;enumeration value="esriDecimalDegrees"/>
 *     &lt;enumeration value="esriDecimeters"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriUnits")
@XmlEnum
public enum EsriUnits {


    /**
     * Unknown.
     * 
     */
    @XmlEnumValue("esriUnknownUnits")
    ESRI_UNKNOWN_UNITS("esriUnknownUnits"),

    /**
     * Inches.
     * 
     */
    @XmlEnumValue("esriInches")
    ESRI_INCHES("esriInches"),

    /**
     * Points.
     * 
     */
    @XmlEnumValue("esriPoints")
    ESRI_POINTS("esriPoints"),

    /**
     * Feet.
     * 
     */
    @XmlEnumValue("esriFeet")
    ESRI_FEET("esriFeet"),

    /**
     * Yards.
     * 
     */
    @XmlEnumValue("esriYards")
    ESRI_YARDS("esriYards"),

    /**
     * Miles.
     * 
     */
    @XmlEnumValue("esriMiles")
    ESRI_MILES("esriMiles"),

    /**
     * Nautical miles.
     * 
     */
    @XmlEnumValue("esriNauticalMiles")
    ESRI_NAUTICAL_MILES("esriNauticalMiles"),

    /**
     * Millimeters.
     * 
     */
    @XmlEnumValue("esriMillimeters")
    ESRI_MILLIMETERS("esriMillimeters"),

    /**
     * Centimeters.
     * 
     */
    @XmlEnumValue("esriCentimeters")
    ESRI_CENTIMETERS("esriCentimeters"),

    /**
     * Meters.
     * 
     */
    @XmlEnumValue("esriMeters")
    ESRI_METERS("esriMeters"),

    /**
     * Kilometers.
     * 
     */
    @XmlEnumValue("esriKilometers")
    ESRI_KILOMETERS("esriKilometers"),

    /**
     * Decimal degrees.
     * 
     */
    @XmlEnumValue("esriDecimalDegrees")
    ESRI_DECIMAL_DEGREES("esriDecimalDegrees"),

    /**
     * Decimeters.
     * 
     */
    @XmlEnumValue("esriDecimeters")
    ESRI_DECIMETERS("esriDecimeters");
    private final String value;

    EsriUnits(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriUnits fromValue(String v) {
        for (EsriUnits c: EsriUnits.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
