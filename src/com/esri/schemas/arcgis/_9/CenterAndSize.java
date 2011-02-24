
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Center And Size object allows you to change the spatial extent of a map by specifying the center, size and units.
 * 
 * <p>Java class for CenterAndSize complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CenterAndSize">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}MapArea">
 *       &lt;sequence>
 *         &lt;element name="Center" type="{http://www.esri.com/schemas/ArcGIS/9.3}Point" minOccurs="0"/>
 *         &lt;element name="Height" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Units" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CenterAndSize", propOrder = {
    "center",
    "height",
    "width",
    "units"
})
public class CenterAndSize
    extends MapArea
{

    @XmlElement(name = "Center")
    protected Point center;
    @XmlElement(name = "Height")
    protected double height;
    @XmlElement(name = "Width")
    protected double width;
    @XmlElement(name = "Units", required = true)
    protected String units;

    /**
     * Gets the value of the center property.
     * 
     * @return
     *     possible object is
     *     {@link Point }
     *     
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Sets the value of the center property.
     * 
     * @param value
     *     allowed object is
     *     {@link Point }
     *     
     */
    public void setCenter(Point value) {
        this.center = value;
    }

    /**
     * Gets the value of the height property.
     * 
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     */
    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Gets the value of the width property.
     * 
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     */
    public void setWidth(double value) {
        this.width = value;
    }

    /**
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnits(String value) {
        this.units = value;
    }

}
