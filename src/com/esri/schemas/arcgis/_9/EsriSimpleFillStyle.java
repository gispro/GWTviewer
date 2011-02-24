
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriSimpleFillStyle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriSimpleFillStyle">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriSFSSolid"/>
 *     &lt;enumeration value="esriSFSNull"/>
 *     &lt;enumeration value="esriSFSHorizontal"/>
 *     &lt;enumeration value="esriSFSVertical"/>
 *     &lt;enumeration value="esriSFSForwardDiagonal"/>
 *     &lt;enumeration value="esriSFSBackwardDiagonal"/>
 *     &lt;enumeration value="esriSFSCross"/>
 *     &lt;enumeration value="esriSFSDiagonalCross"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriSimpleFillStyle")
@XmlEnum
public enum EsriSimpleFillStyle {


    /**
     * Solid fill.
     * 
     */
    @XmlEnumValue("esriSFSSolid")
    ESRI_SFS_SOLID("esriSFSSolid"),

    /**
     * Empty fill.
     * 
     */
    @XmlEnumValue("esriSFSNull")
    ESRI_SFS_NULL("esriSFSNull"),

    /**
     * Horizontal hatch fill ------.
     * 
     */
    @XmlEnumValue("esriSFSHorizontal")
    ESRI_SFS_HORIZONTAL("esriSFSHorizontal"),

    /**
     * Vertical hatch fill ||||||.
     * 
     */
    @XmlEnumValue("esriSFSVertical")
    ESRI_SFS_VERTICAL("esriSFSVertical"),

    /**
     *  45-degree downward, left-to-right hatch fill  \\\.
     * 
     */
    @XmlEnumValue("esriSFSForwardDiagonal")
    ESRI_SFS_FORWARD_DIAGONAL("esriSFSForwardDiagonal"),

    /**
     *  45-degree upward, left-to-right hatch fill //////.
     * 
     */
    @XmlEnumValue("esriSFSBackwardDiagonal")
    ESRI_SFS_BACKWARD_DIAGONAL("esriSFSBackwardDiagonal"),

    /**
     * Horizontal and vertical crosshatch ++++++.
     * 
     */
    @XmlEnumValue("esriSFSCross")
    ESRI_SFS_CROSS("esriSFSCross"),

    /**
     *  45-degree crosshatch xxxxxx.
     * 
     */
    @XmlEnumValue("esriSFSDiagonalCross")
    ESRI_SFS_DIAGONAL_CROSS("esriSFSDiagonalCross");
    private final String value;

    EsriSimpleFillStyle(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriSimpleFillStyle fromValue(String v) {
        for (EsriSimpleFillStyle c: EsriSimpleFillStyle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
