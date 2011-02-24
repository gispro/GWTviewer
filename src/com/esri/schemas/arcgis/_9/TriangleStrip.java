
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A continuous 3D strip of triangles, where each triangle after the first shares an edge with the preceding triangle.
 * 
 * <p>Java class for TriangleStrip complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TriangleStrip">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Geometry">
 *       &lt;sequence>
 *         &lt;element name="PointArray" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfPoint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TriangleStrip", propOrder = {
    "pointArray"
})
public class TriangleStrip
    extends Geometry
{

    @XmlElement(name = "PointArray")
    protected ArrayOfPoint pointArray;

    /**
     * Gets the value of the pointArray property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPoint }
     *     
     */
    public ArrayOfPoint getPointArray() {
        return pointArray;
    }

    /**
     * Sets the value of the pointArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPoint }
     *     
     */
    public void setPointArray(ArrayOfPoint value) {
        this.pointArray = value;
    }

}
