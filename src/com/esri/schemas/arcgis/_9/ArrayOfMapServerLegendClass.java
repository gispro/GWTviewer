
package com.esri.schemas.arcgis._9;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of Map Server Legend Class objects.
 * 
 * <p>Java class for ArrayOfMapServerLegendClass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMapServerLegendClass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MapServerLegendClass" type="{http://www.esri.com/schemas/ArcGIS/9.3}MapServerLegendClass" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMapServerLegendClass", propOrder = {
    "mapServerLegendClass"
})
public class ArrayOfMapServerLegendClass {

    @XmlElement(name = "MapServerLegendClass")
    protected List<MapServerLegendClass> mapServerLegendClass;

    /**
     * Gets the value of the mapServerLegendClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapServerLegendClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapServerLegendClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapServerLegendClass }
     * 
     * 
     */
    public List<MapServerLegendClass> getMapServerLegendClass() {
        if (mapServerLegendClass == null) {
            mapServerLegendClass = new ArrayList<MapServerLegendClass>();
        }
        return this.mapServerLegendClass;
    }

}
