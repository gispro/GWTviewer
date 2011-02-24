
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Segment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Segment">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Curve">
 *       &lt;sequence>
 *         &lt;element name="FromPoint" type="{http://www.esri.com/schemas/ArcGIS/9.3}Point"/>
 *         &lt;element name="ToPoint" type="{http://www.esri.com/schemas/ArcGIS/9.3}Point"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Segment", propOrder = {
    "fromPoint",
    "toPoint"
})
@XmlSeeAlso({
    BezierCurve.class,
    CircularArc.class,
    EllipticArc.class,
    Line.class
})
public abstract class Segment
    extends Curve
{

    @XmlElement(name = "FromPoint", required = true)
    protected Point fromPoint;
    @XmlElement(name = "ToPoint", required = true)
    protected Point toPoint;

    /**
     * Gets the value of the fromPoint property.
     * 
     * @return
     *     possible object is
     *     {@link Point }
     *     
     */
    public Point getFromPoint() {
        return fromPoint;
    }

    /**
     * Sets the value of the fromPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Point }
     *     
     */
    public void setFromPoint(Point value) {
        this.fromPoint = value;
    }

    /**
     * Gets the value of the toPoint property.
     * 
     * @return
     *     possible object is
     *     {@link Point }
     *     
     */
    public Point getToPoint() {
        return toPoint;
    }

    /**
     * Sets the value of the toPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Point }
     *     
     */
    public void setToPoint(Point value) {
        this.toPoint = value;
    }

}
