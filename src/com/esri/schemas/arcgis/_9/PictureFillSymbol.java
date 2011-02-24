
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A fill symbol based on either a BMP or an EMF picture.
 * 
 * <p>Java class for PictureFillSymbol complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PictureFillSymbol">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}FillSymbol">
 *       &lt;sequence>
 *         &lt;element name="Picture" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="BgColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="FgColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="BitmapTransColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="XSeparation" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="YSeparation" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Swap1BitColor" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Angle" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="XOffset" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="YOffset" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="XScale" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="YScale" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PictureFillSymbol", propOrder = {
    "picture",
    "bgColor",
    "fgColor",
    "bitmapTransColor",
    "xSeparation",
    "ySeparation",
    "swap1BitColor",
    "angle",
    "xOffset",
    "yOffset",
    "xScale",
    "yScale"
})
public class PictureFillSymbol
    extends FillSymbol
{

    @XmlElement(name = "Picture", required = true)
    protected byte[] picture;
    @XmlElement(name = "BgColor")
    protected Color bgColor;
    @XmlElement(name = "FgColor")
    protected Color fgColor;
    @XmlElement(name = "BitmapTransColor")
    protected Color bitmapTransColor;
    @XmlElement(name = "XSeparation")
    protected Double xSeparation;
    @XmlElement(name = "YSeparation")
    protected Double ySeparation;
    @XmlElement(name = "Swap1BitColor")
    protected Boolean swap1BitColor;
    @XmlElement(name = "Angle")
    protected Double angle;
    @XmlElement(name = "XOffset")
    protected Double xOffset;
    @XmlElement(name = "YOffset")
    protected Double yOffset;
    @XmlElement(name = "XScale", defaultValue = "1.0")
    protected Double xScale;
    @XmlElement(name = "YScale", defaultValue = "1.0")
    protected Double yScale;

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
     * Gets the value of the xSeparation property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getXSeparation() {
        return xSeparation;
    }

    /**
     * Sets the value of the xSeparation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setXSeparation(Double value) {
        this.xSeparation = value;
    }

    /**
     * Gets the value of the ySeparation property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getYSeparation() {
        return ySeparation;
    }

    /**
     * Sets the value of the ySeparation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setYSeparation(Double value) {
        this.ySeparation = value;
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

    /**
     * Gets the value of the angle property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAngle() {
        return angle;
    }

    /**
     * Sets the value of the angle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAngle(Double value) {
        this.angle = value;
    }

    /**
     * Gets the value of the xOffset property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getXOffset() {
        return xOffset;
    }

    /**
     * Sets the value of the xOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setXOffset(Double value) {
        this.xOffset = value;
    }

    /**
     * Gets the value of the yOffset property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getYOffset() {
        return yOffset;
    }

    /**
     * Sets the value of the yOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setYOffset(Double value) {
        this.yOffset = value;
    }

    /**
     * Gets the value of the xScale property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getXScale() {
        return xScale;
    }

    /**
     * Sets the value of the xScale property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setXScale(Double value) {
        this.xScale = value;
    }

    /**
     * Gets the value of the yScale property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getYScale() {
        return yScale;
    }

    /**
     * Sets the value of the yScale property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setYScale(Double value) {
        this.yScale = value;
    }

}
