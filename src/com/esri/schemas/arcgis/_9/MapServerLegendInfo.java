
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Map Server Legend Info object provides legend information for a layer.
 * 
 * <p>Java class for MapServerLegendInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapServerLegendInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LayerID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LegendGroups" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfMapServerLegendGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MapServerLegendInfo", propOrder = {
    "layerID",
    "name",
    "legendGroups"
})
public class MapServerLegendInfo {

    @XmlElement(name = "LayerID")
    protected int layerID;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "LegendGroups")
    protected ArrayOfMapServerLegendGroup legendGroups;

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
     * Gets the value of the legendGroups property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMapServerLegendGroup }
     *     
     */
    public ArrayOfMapServerLegendGroup getLegendGroups() {
        return legendGroups;
    }

    /**
     * Sets the value of the legendGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMapServerLegendGroup }
     *     
     */
    public void setLegendGroups(ArrayOfMapServerLegendGroup value) {
        this.legendGroups = value;
    }

}
