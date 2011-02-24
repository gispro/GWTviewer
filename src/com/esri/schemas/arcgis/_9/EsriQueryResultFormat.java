
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriQueryResultFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriQueryResultFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriQueryResultRecordSetAsObject"/>
 *     &lt;enumeration value="esriQueryResultKMLAsMime"/>
 *     &lt;enumeration value="esriQueryResultKMLAsURL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriQueryResultFormat")
@XmlEnum
public enum EsriQueryResultFormat {


    /**
     * Indicates RecordSet.
     * 
     */
    @XmlEnumValue("esriQueryResultRecordSetAsObject")
    ESRI_QUERY_RESULT_RECORD_SET_AS_OBJECT("esriQueryResultRecordSetAsObject"),

    /**
     * Indicates KML.
     * 
     */
    @XmlEnumValue("esriQueryResultKMLAsMime")
    ESRI_QUERY_RESULT_KML_AS_MIME("esriQueryResultKMLAsMime"),

    /**
     * Indicates KML.
     * 
     */
    @XmlEnumValue("esriQueryResultKMLAsURL")
    ESRI_QUERY_RESULT_KML_AS_URL("esriQueryResultKMLAsURL");
    private final String value;

    EsriQueryResultFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriQueryResultFormat fromValue(String v) {
        for (EsriQueryResultFormat c: EsriQueryResultFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
