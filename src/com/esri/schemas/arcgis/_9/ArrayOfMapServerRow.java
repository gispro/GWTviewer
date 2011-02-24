
package com.esri.schemas.arcgis._9;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of Map Server Row objects.
 * 
 * <p>Java class for ArrayOfMapServerRow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMapServerRow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MapServerRow" type="{http://www.esri.com/schemas/ArcGIS/9.3}MapServerRow" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMapServerRow", propOrder = {
    "mapServerRow"
})
public class ArrayOfMapServerRow {

    @XmlElement(name = "MapServerRow")
    protected List<MapServerRow> mapServerRow;

    /**
     * Gets the value of the mapServerRow property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapServerRow property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapServerRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapServerRow }
     * 
     * 
     */
    public List<MapServerRow> getMapServerRow() {
        if (mapServerRow == null) {
            mapServerRow = new ArrayList<MapServerRow>();
        }
        return this.mapServerRow;
    }

}
