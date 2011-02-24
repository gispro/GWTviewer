
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The layer cache info object provides information about a layer's cache in a cached map service.
 * 
 * <p>Java class for LayerCacheInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LayerCacheInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LayerID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="HasCache" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LayerCacheInfo", propOrder = {
    "layerID",
    "hasCache"
})
public class LayerCacheInfo {

    @XmlElement(name = "LayerID")
    protected int layerID;
    @XmlElement(name = "HasCache")
    protected boolean hasCache;

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
     * Gets the value of the hasCache property.
     * 
     */
    public boolean isHasCache() {
        return hasCache;
    }

    /**
     * Sets the value of the hasCache property.
     * 
     */
    public void setHasCache(boolean value) {
        this.hasCache = value;
    }

}
