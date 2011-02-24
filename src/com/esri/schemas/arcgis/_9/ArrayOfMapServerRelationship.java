
package com.esri.schemas.arcgis._9;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of Map Server Relationship objects.
 * 
 * <p>Java class for ArrayOfMapServerRelationship complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMapServerRelationship">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MapServerRelationship" type="{http://www.esri.com/schemas/ArcGIS/9.3}MapServerRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMapServerRelationship", propOrder = {
    "mapServerRelationship"
})
public class ArrayOfMapServerRelationship {

    @XmlElement(name = "MapServerRelationship")
    protected List<MapServerRelationship> mapServerRelationship;

    /**
     * Gets the value of the mapServerRelationship property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapServerRelationship property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapServerRelationship().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapServerRelationship }
     * 
     * 
     */
    public List<MapServerRelationship> getMapServerRelationship() {
        if (mapServerRelationship == null) {
            mapServerRelationship = new ArrayList<MapServerRelationship>();
        }
        return this.mapServerRelationship;
    }

}
