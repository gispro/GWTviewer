
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Map Server Identify Result object provides information about an 'identify result'.
 * 
 * <p>Java class for MapServerIdentifyResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapServerIdentifyResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LayerID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Properties" type="{http://www.esri.com/schemas/ArcGIS/9.3}PropertySet" minOccurs="0"/>
 *         &lt;element name="Shape" type="{http://www.esri.com/schemas/ArcGIS/9.3}Geometry" minOccurs="0"/>
 *         &lt;element name="Relationships" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfMapServerRelationship" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MapServerIdentifyResult", propOrder = {
    "layerID",
    "name",
    "properties",
    "shape",
    "relationships"
})
public class MapServerIdentifyResult {

    @XmlElement(name = "LayerID")
    protected int layerID;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Properties")
    protected PropertySet properties;
    @XmlElement(name = "Shape")
    protected Geometry shape;
    @XmlElement(name = "Relationships")
    protected ArrayOfMapServerRelationship relationships;

    /**
     * Gets the value of the layerID property.
     * 
     */
    public int getLayerID() {
        return layerID;
    }

    /**
     * Sets the value of the layerID property.
     * 
     */
    public void setLayerID(int value) {
        this.layerID = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link PropertySet }
     *     
     */
    public PropertySet getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertySet }
     *     
     */
    public void setProperties(PropertySet value) {
        this.properties = value;
    }

    /**
     * Gets the value of the shape property.
     * 
     * @return
     *     possible object is
     *     {@link Geometry }
     *     
     */
    public Geometry getShape() {
        return shape;
    }

    /**
     * Sets the value of the shape property.
     * 
     * @param value
     *     allowed object is
     *     {@link Geometry }
     *     
     */
    public void setShape(Geometry value) {
        this.shape = value;
    }

    /**
     * Gets the value of the relationships property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMapServerRelationship }
     *     
     */
    public ArrayOfMapServerRelationship getRelationships() {
        return relationships;
    }

    /**
     * Sets the value of the relationships property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMapServerRelationship }
     *     
     */
    public void setRelationships(ArrayOfMapServerRelationship value) {
        this.relationships = value;
    }

}
