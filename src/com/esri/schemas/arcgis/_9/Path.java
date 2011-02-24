
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A sequence of connected segments.
 * 
 * <p>Java class for Path complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Path">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Curve">
 *       &lt;sequence>
 *         &lt;element name="PointArray" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfPoint" minOccurs="0"/>
 *         &lt;element name="SegmentArray" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfSegment" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Path", propOrder = {
    "pointArray",
    "segmentArray"
})
@XmlSeeAlso({
    Ring.class
})
public class Path
    extends Curve
{

    @XmlElement(name = "PointArray")
    protected ArrayOfPoint pointArray;
    @XmlElement(name = "SegmentArray")
    protected ArrayOfSegment segmentArray;

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

    /**
     * Gets the value of the segmentArray property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSegment }
     *     
     */
    public ArrayOfSegment getSegmentArray() {
        return segmentArray;
    }

    /**
     * Sets the value of the segmentArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSegment }
     *     
     */
    public void setSegmentArray(ArrayOfSegment value) {
        this.segmentArray = value;
    }

}
