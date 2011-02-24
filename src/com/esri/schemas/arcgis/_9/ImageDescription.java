
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Image Description object contains settings of the image to be generated.
 * 
 * <p>Java class for ImageDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageDescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ImageType" type="{http://www.esri.com/schemas/ArcGIS/9.3}ImageType" minOccurs="0"/>
 *         &lt;element name="ImageDisplay" type="{http://www.esri.com/schemas/ArcGIS/9.3}ImageDisplay" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageDescription", propOrder = {
    "imageType",
    "imageDisplay"
})
public class ImageDescription {

    @XmlElement(name = "ImageType")
    protected ImageType imageType;
    @XmlElement(name = "ImageDisplay")
    protected ImageDisplay imageDisplay;

    /**
     * Gets the value of the imageType property.
     * 
     * @return
     *     possible object is
     *     {@link ImageType }
     *     
     */
    public ImageType getImageType() {
        return imageType;
    }

    /**
     * Sets the value of the imageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageType }
     *     
     */
    public void setImageType(ImageType value) {
        this.imageType = value;
    }

    /**
     * Gets the value of the imageDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link ImageDisplay }
     *     
     */
    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }

    /**
     * Sets the value of the imageDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageDisplay }
     *     
     */
    public void setImageDisplay(ImageDisplay value) {
        this.imageDisplay = value;
    }

}
