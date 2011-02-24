
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * XML shim class for BezierCurve.
 * 
 * <p>Java class for BezierCurve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BezierCurve">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Segment">
 *       &lt;sequence>
 *         &lt;element name="Degree" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ControlPointArray" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfPoint"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BezierCurve", propOrder = {
    "degree",
    "controlPointArray"
})
public class BezierCurve
    extends Segment
{

    @XmlElement(name = "Degree")
    protected int degree;
    @XmlElement(name = "ControlPointArray", required = true)
    protected ArrayOfPoint controlPointArray;

    /**
     * Gets the value of the degree property.
     * 
     */
    public int getDegree() {
        return degree;
    }

    /**
     * Sets the value of the degree property.
     * 
     */
    public void setDegree(int value) {
        this.degree = value;
    }

    /**
     * Gets the value of the controlPointArray property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPoint }
     *     
     */
    public ArrayOfPoint getControlPointArray() {
        return controlPointArray;
    }

    /**
     * Sets the value of the controlPointArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPoint }
     *     
     */
    public void setControlPointArray(ArrayOfPoint value) {
        this.controlPointArray = value;
    }

}
