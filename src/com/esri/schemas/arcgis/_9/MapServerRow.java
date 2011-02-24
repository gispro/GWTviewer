
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Map Server Row object contains information about a row.
 * 
 * <p>Java class for MapServerRow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapServerRow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Properties" type="{http://www.esri.com/schemas/ArcGIS/9.3}PropertySet" minOccurs="0"/>
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
@XmlType(name = "MapServerRow", propOrder = {
    "name",
    "properties",
    "relationships"
})
public class MapServerRow {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Properties")
    protected PropertySet properties;
    @XmlElement(name = "Relationships")
    protected ArrayOfMapServerRelationship relationships;

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
