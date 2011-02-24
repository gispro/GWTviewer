
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ESRI Geometry Definition Object.
 * 
 * <p>Java class for GeometryDef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeometryDef">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AvgNumPoints" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GeometryType" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriGeometryType"/>
 *         &lt;element name="HasM" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="HasZ" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SpatialReference" type="{http://www.esri.com/schemas/ArcGIS/9.3}SpatialReference"/>
 *         &lt;element name="GridSize0" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="GridSize1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="GridSize2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeometryDef", propOrder = {
    "avgNumPoints",
    "geometryType",
    "hasM",
    "hasZ",
    "spatialReference",
    "gridSize0",
    "gridSize1",
    "gridSize2"
})
public class GeometryDef {

    @XmlElement(name = "AvgNumPoints")
    protected int avgNumPoints;
    @XmlElement(name = "GeometryType", required = true)
    protected EsriGeometryType geometryType;
    @XmlElement(name = "HasM")
    protected boolean hasM;
    @XmlElement(name = "HasZ")
    protected boolean hasZ;
    @XmlElement(name = "SpatialReference", required = true)
    protected SpatialReference spatialReference;
    @XmlElement(name = "GridSize0")
    protected Double gridSize0;
    @XmlElement(name = "GridSize1")
    protected Double gridSize1;
    @XmlElement(name = "GridSize2")
    protected Double gridSize2;

    /**
     * Gets the value of the avgNumPoints property.
     * 
     */
    public int getAvgNumPoints() {
        return avgNumPoints;
    }

    /**
     * Sets the value of the avgNumPoints property.
     * 
     */
    public void setAvgNumPoints(int value) {
        this.avgNumPoints = value;
    }

    /**
     * Gets the value of the geometryType property.
     * 
     * @return
     *     possible object is
     *     {@link EsriGeometryType }
     *     
     */
    public EsriGeometryType getGeometryType() {
        return geometryType;
    }

    /**
     * Sets the value of the geometryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriGeometryType }
     *     
     */
    public void setGeometryType(EsriGeometryType value) {
        this.geometryType = value;
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

    /**
     * Gets the value of the gridSize0 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGridSize0() {
        return gridSize0;
    }

    /**
     * Sets the value of the gridSize0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGridSize0(Double value) {
        this.gridSize0 = value;
    }

    /**
     * Gets the value of the gridSize1 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGridSize1() {
        return gridSize1;
    }

    /**
     * Sets the value of the gridSize1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGridSize1(Double value) {
        this.gridSize1 = value;
    }

    /**
     * Gets the value of the gridSize2 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGridSize2() {
        return gridSize2;
    }

    /**
     * Sets the value of the gridSize2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGridSize2(Double value) {
        this.gridSize2 = value;
    }

}
