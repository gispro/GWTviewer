
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A marker symbol based on either a BMP or an EMF picture.
 * 
 * <p>Java class for PictureMarkerSymbol complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PictureMarkerSymbol">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}CartographicMarkerSymbol">
 *       &lt;sequence>
 *         &lt;element name="BgColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="BitmapTransColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="Picture" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="FgColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="Swap1BitColor" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PictureMarkerSymbol", propOrder = {
    "bgColor",
    "bitmapTransColor",
    "picture",
    "fgColor",
    "swap1BitColor"
})
public class PictureMarkerSymbol
    extends CartographicMarkerSymbol
{

    @XmlElement(name = "BgColor")
    protected Color bgColor;
    @XmlElement(name = "BitmapTransColor")
    protected Color bitmapTransColor;
    @XmlElement(name = "Picture")
    protected byte[] picture;
    @XmlElement(name = "FgColor")
    protected Color fgColor;
    @XmlElement(name = "Swap1BitColor")
    protected Boolean swap1BitColor;

    /**
     * Gets the value of the bgColor property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getBgColor() {
        return bgColor;
    }

    /**
     * Sets the value of the bgColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setBgColor(Color value) {
        this.bgColor = value;
    }

    /**
     * Gets the value of the bitmapTransColor property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getBitmapTransColor() {
        return bitmapTransColor;
    }

    /**
     * Sets the value of the bitmapTransColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setBitmapTransColor(Color value) {
        this.bitmapTransColor = value;
    }

    /**
     * Gets the value of the picture property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPicture() {
        return picture;
    }

    /**
     * Sets the value of the picture property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPicture(byte[] value) {
        this.picture = ((byte[]) value);
    }

    /**
     * Gets the value of the fgColor property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getFgColor() {
        return fgColor;
    }

    /**
     * Sets the value of the fgColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setFgColor(Color value) {
        this.fgColor = value;
    }

    /**
     * Gets the value of the swap1BitColor property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSwap1BitColor() {
        return swap1BitColor;
    }

    /**
     * Sets the value of the swap1BitColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSwap1BitColor(Boolean value) {
        this.swap1BitColor = value;
    }

}
