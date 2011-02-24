
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Feature Extent object allows you to zoom to selected features in a layer.
 * 
 * <p>Java class for FeatureExtent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeatureExtent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}MapArea">
 *       &lt;sequence>
 *         &lt;element name="DefaultScale" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ExpandRatio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="FeatureIDs" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfInt" minOccurs="0"/>
 *         &lt;element name="LayerID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MapName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeatureExtent", propOrder = {
    "defaultScale",
    "expandRatio",
    "featureIDs",
    "layerID",
    "mapName"
})
public class FeatureExtent
    extends MapArea
{

    @XmlElement(name = "DefaultScale")
    protected double defaultScale;
    @XmlElement(name = "ExpandRatio", defaultValue = "1.0")
    protected double expandRatio;
    @XmlElement(name = "FeatureIDs")
    protected ArrayOfInt featureIDs;
    @XmlElement(name = "LayerID")
    protected int layerID;
    @XmlElement(name = "MapName", required = true)
    protected String mapName;

    /**
     * Gets the value of the defaultScale property.
     * 
     */
    public double getDefaultScale() {
        return defaultScale;
    }

    /**
     * Sets the value of the defaultScale property.
     * 
     */
    public void setDefaultScale(double value) {
        this.defaultScale = value;
    }

    /**
     * Gets the value of the expandRatio property.
     * 
     */
    public double getExpandRatio() {
        return expandRatio;
    }

    /**
     * Sets the value of the expandRatio property.
     * 
     */
    public void setExpandRatio(double value) {
        this.expandRatio = value;
    }

    /**
     * Gets the value of the featureIDs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getFeatureIDs() {
        return featureIDs;
    }

    /**
     * Sets the value of the featureIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setFeatureIDs(ArrayOfInt value) {
        this.featureIDs = value;
    }

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

}
