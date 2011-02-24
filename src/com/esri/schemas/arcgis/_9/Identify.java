
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
 *         &lt;element name="SearchShape" type="{http://www.esri.com/schemas/ArcGIS/9.3}Geometry"/>
 *         &lt;element name="Tolerance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdentifyOption" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriIdentifyOption"/>
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
    "searchShape",
    "tolerance",
    "identifyOption",
    "layerIDs"
})
@XmlRootElement(name = "Identify")
public class Identify {

    @XmlElement(name = "MapDescription", required = true)
    protected MapDescription mapDescription;
    @XmlElement(name = "MapImageDisplay", required = true)
    protected ImageDisplay mapImageDisplay;
    @XmlElement(name = "SearchShape", required = true)
    protected Geometry searchShape;
    @XmlElement(name = "Tolerance")
    protected int tolerance;
    @XmlElement(name = "IdentifyOption", required = true)
    protected EsriIdentifyOption identifyOption;
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
     * Gets the value of the searchShape property.
     * 
     * @return
     *     possible object is
     *     {@link Geometry }
     *     
     */
    public Geometry getSearchShape() {
        return searchShape;
    }

    /**
     * Sets the value of the searchShape property.
     * 
     * @param value
     *     allowed object is
     *     {@link Geometry }
     *     
     */
    public void setSearchShape(Geometry value) {
        this.searchShape = value;
    }

    /**
     * Gets the value of the tolerance property.
     * 
     */
    public int getTolerance() {
        return tolerance;
    }

    /**
     * Sets the value of the tolerance property.
     * 
     */
    public void setTolerance(int value) {
        this.tolerance = value;
    }

    /**
     * Gets the value of the identifyOption property.
     * 
     * @return
     *     possible object is
     *     {@link EsriIdentifyOption }
     *     
     */
    public EsriIdentifyOption getIdentifyOption() {
        return identifyOption;
    }

    /**
     * Sets the value of the identifyOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriIdentifyOption }
     *     
     */
    public void setIdentifyOption(EsriIdentifyOption value) {
        this.identifyOption = value;
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
