
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for esriImageFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="esriImageFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esriImageNone"/>
 *     &lt;enumeration value="esriImageBMP"/>
 *     &lt;enumeration value="esriImageJPG"/>
 *     &lt;enumeration value="esriImageDIB"/>
 *     &lt;enumeration value="esriImageTIFF"/>
 *     &lt;enumeration value="esriImagePNG"/>
 *     &lt;enumeration value="esriImagePNG24"/>
 *     &lt;enumeration value="esriImageEMF"/>
 *     &lt;enumeration value="esriImagePS"/>
 *     &lt;enumeration value="esriImagePDF"/>
 *     &lt;enumeration value="esriImageAI"/>
 *     &lt;enumeration value="esriImageGIF"/>
 *     &lt;enumeration value="esriImageSVG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "esriImageFormat")
@XmlEnum
public enum EsriImageFormat {


    /**
     * None
     * 
     */
    @XmlEnumValue("esriImageNone")
    ESRI_IMAGE_NONE("esriImageNone"),

    /**
     * BMP
     * 
     */
    @XmlEnumValue("esriImageBMP")
    ESRI_IMAGE_BMP("esriImageBMP"),

    /**
     * JPG
     * 
     */
    @XmlEnumValue("esriImageJPG")
    ESRI_IMAGE_JPG("esriImageJPG"),

    /**
     * DIB
     * 
     */
    @XmlEnumValue("esriImageDIB")
    ESRI_IMAGE_DIB("esriImageDIB"),

    /**
     * TIFF
     * 
     */
    @XmlEnumValue("esriImageTIFF")
    ESRI_IMAGE_TIFF("esriImageTIFF"),

    /**
     * PNG
     * 
     */
    @XmlEnumValue("esriImagePNG")
    ESRI_IMAGE_PNG("esriImagePNG"),

    /**
     * PNG24
     * 
     */
    @XmlEnumValue("esriImagePNG24")
    ESRI_IMAGE_PNG_24("esriImagePNG24"),

    /**
     * EMF
     * 
     */
    @XmlEnumValue("esriImageEMF")
    ESRI_IMAGE_EMF("esriImageEMF"),

    /**
     * PS
     * 
     */
    @XmlEnumValue("esriImagePS")
    ESRI_IMAGE_PS("esriImagePS"),

    /**
     * PDF
     * 
     */
    @XmlEnumValue("esriImagePDF")
    ESRI_IMAGE_PDF("esriImagePDF"),

    /**
     * AI
     * 
     */
    @XmlEnumValue("esriImageAI")
    ESRI_IMAGE_AI("esriImageAI"),

    /**
     * GIF
     * 
     */
    @XmlEnumValue("esriImageGIF")
    ESRI_IMAGE_GIF("esriImageGIF"),

    /**
     * SVG
     * 
     */
    @XmlEnumValue("esriImageSVG")
    ESRI_IMAGE_SVG("esriImageSVG");
    private final String value;

    EsriImageFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EsriImageFormat fromValue(String v) {
        for (EsriImageFormat c: EsriImageFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
