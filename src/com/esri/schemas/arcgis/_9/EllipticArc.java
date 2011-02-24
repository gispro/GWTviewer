
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * XML shim class for EllipticArc.
 * 
 * <p>Java class for EllipticArc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EllipticArc">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Segment">
 *       &lt;sequence>
 *         &lt;element name="EllipseStd" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CenterPoint" type="{http://www.esri.com/schemas/ArcGIS/9.3}Point"/>
 *         &lt;element name="Rotation" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="MinorMajorRatio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="IsCounterClockWise" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsMinor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EllipticArc", propOrder = {
    "ellipseStd",
    "centerPoint",
    "rotation",
    "minorMajorRatio",
    "isCounterClockWise",
    "isMinor"
})
public class EllipticArc
    extends Segment
{

    @XmlElement(name = "EllipseStd")
    protected boolean ellipseStd;
    @XmlElement(name = "CenterPoint", required = true)
    protected Point centerPoint;
    @XmlElement(name = "Rotation")
    protected double rotation;
    @XmlElement(name = "MinorMajorRatio")
    protected double minorMajorRatio;
    @XmlElement(name = "IsCounterClockWise")
    protected boolean isCounterClockWise;
    @XmlElement(name = "IsMinor")
    protected boolean isMinor;

    /**
     * Gets the value of the ellipseStd property.
     * 
     */
    public boolean isEllipseStd() {
        return ellipseStd;
    }

    /**
     * Sets the value of the ellipseStd property.
     * 
     */
    public void setEllipseStd(boolean value) {
        this.ellipseStd = value;
    }

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
     * Gets the value of the rotation property.
     * 
     */
    public double getRotation() {
        return rotation;
    }

    /**
     * Sets the value of the rotation property.
     * 
     */
    public void setRotation(double value) {
        this.rotation = value;
    }

    /**
     * Gets the value of the minorMajorRatio property.
     * 
     */
    public double getMinorMajorRatio() {
        return minorMajorRatio;
    }

    /**
     * Sets the value of the minorMajorRatio property.
     * 
     */
    public void setMinorMajorRatio(double value) {
        this.minorMajorRatio = value;
    }

    /**
     * Gets the value of the isCounterClockWise property.
     * 
     */
    public boolean isIsCounterClockWise() {
        return isCounterClockWise;
    }

    /**
     * Sets the value of the isCounterClockWise property.
     * 
     */
    public void setIsCounterClockWise(boolean value) {
        this.isCounterClockWise = value;
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

}
