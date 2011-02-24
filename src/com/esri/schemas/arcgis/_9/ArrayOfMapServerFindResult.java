
package com.esri.schemas.arcgis._9;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of Map Server Find Result objects.
 * 
 * <p>Java class for ArrayOfMapServerFindResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMapServerFindResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MapServerFindResult" type="{http://www.esri.com/schemas/ArcGIS/9.3}MapServerFindResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMapServerFindResult", propOrder = {
    "mapServerFindResult"
})
public class ArrayOfMapServerFindResult {

    @XmlElement(name = "MapServerFindResult")
    protected List<MapServerFindResult> mapServerFindResult;

    /**
     * Gets the value of the mapServerFindResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapServerFindResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapServerFindResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapServerFindResult }
     * 
     * 
     */
    public List<MapServerFindResult> getMapServerFindResult() {
        if (mapServerFindResult == null) {
            mapServerFindResult = new ArrayList<MapServerFindResult>();
        }
        return this.mapServerFindResult;
    }

}
