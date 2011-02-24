
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of rings ordered by their containment relationship; optionally has measure, height and ID attributes.
 * 
 * <p>Java class for PolygonN complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PolygonN">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Polygon">
 *       &lt;sequence>
 *         &lt;element name="HasID" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="HasZ" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="HasM" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Extent" type="{http://www.esri.com/schemas/ArcGIS/9.3}Envelope" minOccurs="0"/>
 *         &lt;element name="RingArray" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfRing"/>
 *         &lt;element name="SpatialReference" type="{http://www.esri.com/schemas/ArcGIS/9.3}SpatialReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PolygonN", propOrder = {
    "hasID",
    "hasZ",
    "hasM",
    "extent",
    "ringArray",
    "spatialReference"
})
public class PolygonN
    extends Polygon
{

    @XmlElement(name = "HasID")
    protected boolean hasID;
    @XmlElement(name = "HasZ")
    protected boolean hasZ;
    @XmlElement(name = "HasM")
    protected boolean hasM;
    @XmlElement(name = "Extent")
    protected Envelope extent;
    @XmlElement(name = "RingArray", required = true)
    protected ArrayOfRing ringArray;
    @XmlElement(name = "SpatialReference")
    protected SpatialReference spatialReference;

    /**
     * Gets the value of the hasID property.
     * 
     */
    public boolean isHasID() {
        return hasID;
    }

    /**
     * Sets the value of the hasID property.
     * 
     */
    public void setHasID(boolean value) {
        this.hasID = value;
    }

    /**
     * Gets the value of the hasZ property.
     * 
     */
    public boolean isHasZ() {
        return hasZ;
    }

    /**
     * Sets the value of the hasZ property.
     * 
     */
    public void setHasZ(boolean value) {
        this.hasZ = value;
    }

    /**
     * Gets the value of the hasM property.
     * 
     */
    public boolean isHasM() {
        return hasM;
    }

    /**
     * Sets the value of the hasM property.
     * 
     */
    public void setHasM(boolean value) {
        this.hasM = value;
    }

    /**
     * Gets the value of the extent property.
     * 
     * @return
     *     possible object is
     *     {@link Envelope }
     *     
     */
    public Envelope getExtent() {
        return extent;
    }

    /**
     * Sets the value of the extent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Envelope }
     *     
     */
    public void setExtent(Envelope value) {
        this.extent = value;
    }

    /**
     * Gets the value of the ringArray property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRing }
     *     
     */
    public ArrayOfRing getRingArray() {
        return ringArray;
    }

    /**
     * Sets the value of the ringArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRing }
     *     
     */
    public void setRingArray(ArrayOfRing value) {
        this.ringArray = value;
    }

    /**
     * Gets the value of the spatialReference property.
     * 
     * @return
     *     possible object is
     *     {@link SpatialReference }
     *     
     */
    public SpatialReference getSpatialReference() {
        return spatialReference;
    }

    /**
     * Sets the value of the spatialReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpatialReference }
     *     
     */
    public void setSpatialReference(SpatialReference value) {
        this.spatialReference = value;
    }

}
