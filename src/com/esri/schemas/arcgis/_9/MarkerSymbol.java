
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Marker Symbol Properties.
 *       
 * 
 * <p>Java class for MarkerSymbol complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MarkerSymbol">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Symbol">
 *       &lt;sequence>
 *         &lt;element name="Angle" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Color" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="Size" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="XOffset" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="YOffset" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MarkerSymbol", propOrder = {
    "angle",
    "color",
    "size",
    "xOffset",
    "yOffset"
})
@XmlSeeAlso({
    CartographicMarkerSymbol.class,
    SimpleMarkerSymbol.class
})
public abstract class MarkerSymbol
    extends Symbol
{

    @XmlElement(name = "Angle")
    protected double angle;
    @XmlElement(name = "Color")
    protected Color color;
    @XmlElement(name = "Size")
    protected double size;
    @XmlElement(name = "XOffset")
    protected double xOffset;
    @XmlElement(name = "YOffset")
    protected double yOffset;

    /**
     * Gets the value of the angle property.
     * 
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Sets the value of the angle property.
     * 
     */
    public void setAngle(double value) {
        this.angle = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setColor(Color value) {
        this.color = value;
    }

    /**
     * Gets the value of the size property.
     * 
     */
    public double getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     */
    public void setSize(double value) {
        this.size = value;
    }

    /**
     * Gets the value of the xOffset property.
     * 
     */
    public double getXOffset() {
        return xOffset;
    }

    /**
     * Sets the value of the xOffset property.
     * 
     */
    public void setXOffset(double value) {
        this.xOffset = value;
    }

    /**
     * Gets the value of the yOffset property.
     * 
     */
    public double getYOffset() {
        return yOffset;
    }

    /**
     * Sets the value of the yOffset property.
     * 
     */
    public void setYOffset(double value) {
        this.yOffset = value;
    }

}
