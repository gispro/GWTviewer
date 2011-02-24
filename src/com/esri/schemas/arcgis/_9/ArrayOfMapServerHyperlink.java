
package com.esri.schemas.arcgis._9;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of Map Server Hyperlink objects.
 * 
 * <p>Java class for ArrayOfMapServerHyperlink complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMapServerHyperlink">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MapServerHyperlink" type="{http://www.esri.com/schemas/ArcGIS/9.3}MapServerHyperlink" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMapServerHyperlink", propOrder = {
    "mapServerHyperlink"
})
public class ArrayOfMapServerHyperlink {

    @XmlElement(name = "MapServerHyperlink")
    protected List<MapServerHyperlink> mapServerHyperlink;

    /**
     * Gets the value of the mapServerHyperlink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapServerHyperlink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapServerHyperlink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapServerHyperlink }
     * 
     * 
     */
    public List<MapServerHyperlink> getMapServerHyperlink() {
        if (mapServerHyperlink == null) {
            mapServerHyperlink = new ArrayList<MapServerHyperlink>();
        }
        return this.mapServerHyperlink;
    }

}
