
package com.esri.schemas.arcgis._9;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of Map JSONLayer Info objects.
 * 
 * <p>Java class for ArrayOfMapLayerInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMapLayerInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MapLayerInfo" type="{http://www.esri.com/schemas/ArcGIS/9.3}MapLayerInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMapLayerInfo", propOrder = {
    "mapLayerInfo"
})
public class ArrayOfMapLayerInfo {

    @XmlElement(name = "MapLayerInfo")
    protected List<MapLayerInfo> mapLayerInfo;

    /**
     * Gets the value of the mapLayerInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapLayerInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapLayerInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapLayerInfo }
     * 
     * 
     */
    public List<MapLayerInfo> getMapLayerInfo() {
        if (mapLayerInfo == null) {
            mapLayerInfo = new ArrayList<MapLayerInfo>();
        }
        return this.mapLayerInfo;
    }

}
