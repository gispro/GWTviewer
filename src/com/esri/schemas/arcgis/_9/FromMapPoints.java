
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
 *         &lt;element name="MapPoints" type="{http://www.esri.com/schemas/ArcGIS/9.3}Multipoint"/>
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
    "mapPoints"
})
@XmlRootElement(name = "FromMapPoints")
public class FromMapPoints {

    @XmlElement(name = "MapDescription", required = true)
    protected MapDescription mapDescription;
    @XmlElement(name = "MapImageDisplay", required = true)
    protected ImageDisplay mapImageDisplay;
    @XmlElement(name = "MapPoints", required = true)
    protected Multipoint mapPoints;

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
     * Gets the value of the mapPoints property.
     * 
     * @return
     *     possible object is
     *     {@link Multipoint }
     *     
     */
    public Multipoint getMapPoints() {
        return mapPoints;
    }

    /**
     * Sets the value of the mapPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Multipoint }
     *     
     */
    public void setMapPoints(Multipoint value) {
        this.mapPoints = value;
    }

}
