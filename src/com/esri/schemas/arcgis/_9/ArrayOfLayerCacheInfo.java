
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of LayerCacheInfo objects.
 * 
 * <p>Java class for ArrayOfLayerCacheInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLayerCacheInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LayerCacheInfo" type="{http://www.esri.com/schemas/ArcGIS/9.3}LayerCacheInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLayerCacheInfo", propOrder = {
    "layerCacheInfo"
})
public class ArrayOfLayerCacheInfo {

    @XmlElement(name = "LayerCacheInfo", required = true)
    protected LayerCacheInfo layerCacheInfo;

    /**
     * Gets the value of the layerCacheInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LayerCacheInfo }
     *     
     */
    public LayerCacheInfo getLayerCacheInfo() {
        return layerCacheInfo;
    }

    /**
     * Sets the value of the layerCacheInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LayerCacheInfo }
     *     
     */
    public void setLayerCacheInfo(LayerCacheInfo value) {
        this.layerCacheInfo = value;
    }

}
