
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MapName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LayerDescription" type="{http://www.esri.com/schemas/ArcGIS/9.3}LayerDescription"/>
 *         &lt;element name="QueryFilter" type="{http://www.esri.com/schemas/ArcGIS/9.3}QueryFilter"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mapName",
    "layerDescription",
    "queryFilter"
})
@XmlRootElement(name = "QueryFeatureCount2")
public class QueryFeatureCount2 {

    @XmlElement(name = "MapName", required = true)
    protected String mapName;
    @XmlElement(name = "LayerDescription", required = true)
    protected LayerDescription layerDescription;
    @XmlElement(name = "QueryFilter", required = true)
    protected QueryFilter queryFilter;

    /**
     * Gets the value of the mapName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapName() {
        return mapName;
    }

    /**
     * Sets the value of the mapName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapName(String value) {
        this.mapName = value;
    }

    /**
     * Gets the value of the layerDescription property.
     * 
     * @return
     *     possible object is
     *     {@link LayerDescription }
     *     
     */
    public LayerDescription getLayerDescription() {
        return layerDescription;
    }

    /**
     * Sets the value of the layerDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link LayerDescription }
     *     
     */
    public void setLayerDescription(LayerDescription value) {
        this.layerDescription = value;
    }

    /**
     * Gets the value of the queryFilter property.
     * 
     * @return
     *     possible object is
     *     {@link QueryFilter }
     *     
     */
    public QueryFilter getQueryFilter() {
        return queryFilter;
    }

    /**
     * Sets the value of the queryFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryFilter }
     *     
     */
    public void setQueryFilter(QueryFilter value) {
        this.queryFilter = value;
    }

}
