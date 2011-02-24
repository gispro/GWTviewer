
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
 *         &lt;element name="ScaleBar" type="{http://www.esri.com/schemas/ArcGIS/9.3}ScaleBar" minOccurs="0"/>
 *         &lt;element name="MapDescription" type="{http://www.esri.com/schemas/ArcGIS/9.3}MapDescription"/>
 *         &lt;element name="MapDisplay" type="{http://www.esri.com/schemas/ArcGIS/9.3}ImageDisplay"/>
 *         &lt;element name="BackGroundColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="ImageDescription" type="{http://www.esri.com/schemas/ArcGIS/9.3}ImageDescription"/>
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
    "scaleBar",
    "mapDescription",
    "mapDisplay",
    "backGroundColor",
    "imageDescription"
})
@XmlRootElement(name = "ExportScaleBar")
public class ExportScaleBar {

    @XmlElement(name = "ScaleBar")
    protected ScaleBar scaleBar;
    @XmlElement(name = "MapDescription", required = true)
    protected MapDescription mapDescription;
    @XmlElement(name = "MapDisplay", required = true)
    protected ImageDisplay mapDisplay;
    @XmlElement(name = "BackGroundColor")
    protected Color backGroundColor;
    @XmlElement(name = "ImageDescription", required = true)
    protected ImageDescription imageDescription;

    /**
     * Gets the value of the scaleBar property.
     * 
     * @return
     *     possible object is
     *     {@link ScaleBar }
     *     
     */
    public ScaleBar getScaleBar() {
        return scaleBar;
    }

    /**
     * Sets the value of the scaleBar property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScaleBar }
     *     
     */
    public void setScaleBar(ScaleBar value) {
        this.scaleBar = value;
    }

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
     * Gets the value of the mapDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link ImageDisplay }
     *     
     */
    public ImageDisplay getMapDisplay() {
        return mapDisplay;
    }

    /**
     * Sets the value of the mapDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageDisplay }
     *     
     */
    public void setMapDisplay(ImageDisplay value) {
        this.mapDisplay = value;
    }

    /**
     * Gets the value of the backGroundColor property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getBackGroundColor() {
        return backGroundColor;
    }

    /**
     * Sets the value of the backGroundColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setBackGroundColor(Color value) {
        this.backGroundColor = value;
    }

    /**
     * Gets the value of the imageDescription property.
     * 
     * @return
     *     possible object is
     *     {@link ImageDescription }
     *     
     */
    public ImageDescription getImageDescription() {
        return imageDescription;
    }

    /**
     * Sets the value of the imageDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageDescription }
     *     
     */
    public void setImageDescription(ImageDescription value) {
        this.imageDescription = value;
    }

}
