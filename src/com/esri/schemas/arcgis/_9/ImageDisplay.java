
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Image Display object contains the display characteristics of the image to be generated.
 * 
 * <p>Java class for ImageDisplay complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageDisplay">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ImageHeight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ImageWidth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ImageDPI" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TransparentColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageDisplay", propOrder = {
    "imageHeight",
    "imageWidth",
    "imageDPI",
    "transparentColor"
})
public class ImageDisplay {

    @XmlElement(name = "ImageHeight")
    protected int imageHeight;
    @XmlElement(name = "ImageWidth")
    protected int imageWidth;
    @XmlElement(name = "ImageDPI")
    protected double imageDPI;
    @XmlElement(name = "TransparentColor")
    protected Color transparentColor;

    /**
     * Gets the value of the imageHeight property.
     * 
     */
    public int getImageHeight() {
        return imageHeight;
    }

    /**
     * Sets the value of the imageHeight property.
     * 
     */
    public void setImageHeight(int value) {
        this.imageHeight = value;
    }

    /**
     * Gets the value of the imageWidth property.
     * 
     */
    public int getImageWidth() {
        return imageWidth;
    }

    /**
     * Sets the value of the imageWidth property.
     * 
     */
    public void setImageWidth(int value) {
        this.imageWidth = value;
    }

    /**
     * Gets the value of the imageDPI property.
     * 
     */
    public double getImageDPI() {
        return imageDPI;
    }

    /**
     * Sets the value of the imageDPI property.
     * 
     */
    public void setImageDPI(double value) {
        this.imageDPI = value;
    }

    /**
     * Gets the value of the transparentColor property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getTransparentColor() {
        return transparentColor;
    }

    /**
     * Sets the value of the transparentColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setTransparentColor(Color value) {
        this.transparentColor = value;
    }

}
