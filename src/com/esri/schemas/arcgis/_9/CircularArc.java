
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * XML shim class for CircularArc.
 * 
 * <p>Java class for CircularArc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CircularArc">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Segment">
 *       &lt;sequence>
 *         &lt;element name="CenterPoint" type="{http://www.esri.com/schemas/ArcGIS/9.3}Point"/>
 *         &lt;element name="FromAngle" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ToAngle" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="IsCounterClockwise" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsMinor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsLine" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CircularArc", propOrder = {
    "centerPoint",
    "fromAngle",
    "toAngle",
    "isCounterClockwise",
    "isMinor",
    "isLine"
})
public class CircularArc
    extends Segment
{

    @XmlElement(name = "CenterPoint", required = true)
    protected Point centerPoint;
    @XmlElement(name = "FromAngle")
    protected Double fromAngle;
    @XmlElement(name = "ToAngle")
    protected Double toAngle;
    @XmlElement(name = "IsCounterClockwise")
    protected boolean isCounterClockwise;
    @XmlElement(name = "IsMinor")
    protected boolean isMinor;
    @XmlElement(name = "IsLine")
    protected boolean isLine;

    /**
     * Gets the value of the centerPoint property.
     * 
     * @return
     *     possible object is
     *     {@link Point }
     *     
     */
    public Point getCenterPoint() {
        return centerPoint;
    }

    /**
     * Sets the value of the centerPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Point }
     *     
     */
    public void setCenterPoint(Point value) {
        this.centerPoint = value;
    }

    /**
     * Gets the value of the fromAngle property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFromAngle() {
        return fromAngle;
    }

    /**
     * Sets the value of the fromAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFromAngle(Double value) {
        this.fromAngle = value;
    }

    /**
     * Gets the value of the toAngle property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getToAngle() {
        return toAngle;
    }

    /**
     * Sets the value of the toAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setToAngle(Double value) {
        this.toAngle = value;
    }

    /**
     * Gets the value of the isCounterClockwise property.
     * 
     */
    public boolean isIsCounterClockwise() {
        return isCounterClockwise;
    }

    /**
     * Sets the value of the isCounterClockwise property.
     * 
     */
    public void setIsCounterClockwise(boolean value) {
        this.isCounterClockwise = value;
    }

    /**
     * Gets the value of the isMinor property.
     * 
     */
    public boolean isIsMinor() {
        return isMinor;
    }

    /**
     * Sets the value of the isMinor property.
     * 
     */
    public void setIsMinor(boolean value) {
        this.isMinor = value;
    }

    /**
     * Gets the value of the isLine property.
     * 
     */
    public boolean isIsLine() {
        return isLine;
    }

    /**
     * Sets the value of the isLine property.
     * 
     */
    public void setIsLine(boolean value) {
        this.isLine = value;
    }

}
