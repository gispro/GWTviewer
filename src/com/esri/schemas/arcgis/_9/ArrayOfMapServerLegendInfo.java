
package com.esri.schemas.arcgis._9;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of Map Server Legend Info objects.
 * 
 * <p>Java class for ArrayOfMapServerLegendInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMapServerLegendInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MapServerLegendInfo" type="{http://www.esri.com/schemas/ArcGIS/9.3}MapServerLegendInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMapServerLegendInfo", propOrder = {
    "mapServerLegendInfo"
})
public class ArrayOfMapServerLegendInfo {

    @XmlElement(name = "MapServerLegendInfo")
    protected List<MapServerLegendInfo> mapServerLegendInfo;

    /**
     * Gets the value of the mapServerLegendInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapServerLegendInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapServerLegendInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapServerLegendInfo }
     * 
     * 
     */
    public List<MapServerLegendInfo> getMapServerLegendInfo() {
        if (mapServerLegendInfo == null) {
            mapServerLegendInfo = new ArrayList<MapServerLegendInfo>();
        }
        return this.mapServerLegendInfo;
    }

}
