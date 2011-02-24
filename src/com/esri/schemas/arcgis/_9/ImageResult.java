
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Image Result object contains information about the generated image.
 * 
 * <p>Java class for ImageResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ImageData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="ImageURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ImageHeight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ImageWidth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ImageDPI" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageResult", propOrder = {
    "imageData",
    "imageURL",
    "imageHeight",
    "imageWidth",
    "imageDPI"
})
public class ImageResult {

    @XmlElement(name = "ImageData")
    protected byte[] imageData;
    @XmlElement(name = "ImageURL", required = true)
    protected String imageURL;
    @XmlElement(name = "ImageHeight")
    protected int imageHeight;
    @XmlElement(name = "ImageWidth")
    protected int imageWidth;
    @XmlElement(name = "ImageDPI")
    protected double imageDPI;

    /**
     * Gets the value of the imageData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImageData() {
        return imageData;
    }

    /**
     * Sets the value of the imageData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImageData(byte[] value) {
        this.imageData = ((byte[]) value);
    }

    /**
     * Gets the value of the imageURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Sets the value of the imageURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageURL(String value) {
        this.imageURL = value;
    }

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

}
