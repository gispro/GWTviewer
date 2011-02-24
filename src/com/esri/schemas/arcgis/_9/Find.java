
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MapDescription" type="{http://www.esri.com/schemas/ArcGIS/9.3}MapDescription"/>
 *         &lt;element name="MapImageDisplay" type="{http://www.esri.com/schemas/ArcGIS/9.3}ImageDisplay"/>
 *         &lt;element name="SearchString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Contains" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SearchFields" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FindOption" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriFindOption"/>
 *         &lt;element name="LayerIDs" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mapDescription",
    "mapImageDisplay",
    "searchString",
    "contains",
    "searchFields",
    "findOption",
    "layerIDs"
})
@XmlRootElement(name = "Find")
public class Find {

    @XmlElement(name = "MapDescription", required = true)
    protected MapDescription mapDescription;
    @XmlElement(name = "MapImageDisplay", required = true)
    protected ImageDisplay mapImageDisplay;
    @XmlElement(name = "SearchString", required = true)
    protected String searchString;
    @XmlElement(name = "Contains")
    protected boolean contains;
    @XmlElement(name = "SearchFields", required = true)
    protected String searchFields;
    @XmlElement(name = "FindOption", required = true)
    protected EsriFindOption findOption;
    @XmlElement(name = "LayerIDs", required = true)
    protected ArrayOfInt layerIDs;

    /**
     * Gets the value of the mapDescription property.
     * 
     * @return
     *     possible object is
     *     {@link MapDescription }
     *     
     */
    public MapDescription getMapDescription() {
        return mapDescription;
    }

    /**
     * Sets the value of the mapDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapDescription }
     *     
     */
    public void setMapDescription(MapDescription value) {
        this.mapDescription = value;
    }

    /**
     * Gets the value of the mapImageDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link ImageDisplay }
     *     
     */
    public ImageDisplay getMapImageDisplay() {
        return mapImageDisplay;
    }

    /**
     * Sets the value of the mapImageDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageDisplay }
     *     
     */
    public void setMapImageDisplay(ImageDisplay value) {
        this.mapImageDisplay = value;
    }

    /**
     * Gets the value of the searchString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchString() {
        return searchString;
    }

    /**
     * Sets the value of the searchString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchString(String value) {
        this.searchString = value;
    }

    /**
     * Gets the value of the contains property.
     * 
     */
    public boolean isContains() {
        return contains;
    }

    /**
     * Sets the value of the contains property.
     * 
     */
    public void setContains(boolean value) {
        this.contains = value;
    }

    /**
     * Gets the value of the searchFields property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchFields() {
        return searchFields;
    }

    /**
     * Sets the value of the searchFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchFields(String value) {
        this.searchFields = value;
    }

    /**
     * Gets the value of the findOption property.
     * 
     * @return
     *     possible object is
     *     {@link EsriFindOption }
     *     
     */
    public EsriFindOption getFindOption() {
        return findOption;
    }

    /**
     * Sets the value of the findOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriFindOption }
     *     
     */
    public void setFindOption(EsriFindOption value) {
        this.findOption = value;
    }

    /**
     * Gets the value of the layerIDs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getLayerIDs() {
        return layerIDs;
    }

    /**
     * Sets the value of the layerIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setLayerIDs(ArrayOfInt value) {
        this.layerIDs = value;
    }

}
