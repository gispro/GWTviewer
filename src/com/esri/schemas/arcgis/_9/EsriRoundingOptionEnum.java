
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriRoundingOptionEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriRoundingOptionEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriRoundNumberOfDecimals"/>
 *     &lt;enumeration value="esriRoundNumberOfSignificantDigits"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriRoundingOptionEnum")
@XmlEnum
public enum EsriRoundingOptionEnum {


    /**
     * Specify the number of decimal places.
     * 
     */
    @XmlEnumValue("esriRoundNumberOfDecimals")
    ESRI_ROUND_NUMBER_OF_DECIMALS("esriRoundNumberOfDecimals"),

    /**
     * Specify the number of significant digits.
     * 
     */
    @XmlEnumValue("esriRoundNumberOfSignificantDigits")
    ESRI_ROUND_NUMBER_OF_SIGNIFICANT_DIGITS("esriRoundNumberOfSignificantDigits");
    private final String value;

    EsriRoundingOptionEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriRoundingOptionEnum fromValue(String v) {
        for (EsriRoundingOptionEnum c: EsriRoundingOptionEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
