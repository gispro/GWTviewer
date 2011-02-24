
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Image Type object contains information about the type of image to be generated.
 * 
 * <p>Java class for ImageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ImageFormat" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriImageFormat"/>
 *         &lt;element name="ImageReturnType" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriImageReturnType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageType", propOrder = {
    "imageFormat",
    "imageReturnType"
})
public class ImageType {

    @XmlElement(name = "ImageFormat", required = true)
    protected EsriImageFormat imageFormat;
    @XmlElement(name = "ImageReturnType", required = true)
    protected EsriImageReturnType imageReturnType;

    /**
     * Gets the value of the imageFormat property.
     * 
     * @return
     *     possible object is
     *     {@link EsriImageFormat }
     *     
     */
    public EsriImageFormat getImageFormat() {
        return imageFormat;
    }

    /**
     * Sets the value of the imageFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriImageFormat }
     *     
     */
    public void setImageFormat(EsriImageFormat value) {
        this.imageFormat = value;
    }

    /**
     * Gets the value of the imageReturnType property.
     * 
     * @return
     *     possible object is
     *     {@link EsriImageReturnType }
     *     
     */
    public EsriImageReturnType getImageReturnType() {
        return imageReturnType;
    }

    /**
     * Sets the value of the imageReturnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriImageReturnType }
     *     
     */
    public void setImageReturnType(EsriImageReturnType value) {
        this.imageReturnType = value;
    }

}
