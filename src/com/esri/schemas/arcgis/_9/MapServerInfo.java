
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Map Server Info object provides read-only information about a map.
 * 
 * <p>Java class for MapServerInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapServerInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FullExtent" type="{http://www.esri.com/schemas/ArcGIS/9.3}Envelope" minOccurs="0"/>
 *         &lt;element name="Extent" type="{http://www.esri.com/schemas/ArcGIS/9.3}Envelope" minOccurs="0"/>
 *         &lt;element name="SpatialReference" type="{http://www.esri.com/schemas/ArcGIS/9.3}SpatialReference" minOccurs="0"/>
 *         &lt;element name="MapLayerInfos" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfMapLayerInfo" minOccurs="0"/>
 *         &lt;element name="BackgroundColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="Bookmarks" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfMapServerBookmark" minOccurs="0"/>
 *         &lt;element name="DefaultMapDescription" type="{http://www.esri.com/schemas/ArcGIS/9.3}MapDescription" minOccurs="0"/>
 *         &lt;element name="Units" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriUnits"/>
 *         &lt;element name="SupportedImageReturnTypes" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriImageReturnType"/>
 *         &lt;element name="BackgroundSymbol" type="{http://www.esri.com/schemas/ArcGIS/9.3}FillSymbol" minOccurs="0"/>
 *         &lt;element name="CopyrightText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MapServerInfo", propOrder = {
    "name",
    "description",
    "fullExtent",
    "extent",
    "spatialReference",
    "mapLayerInfos",
    "backgroundColor",
    "bookmarks",
    "defaultMapDescription",
    "units",
    "supportedImageReturnTypes",
    "backgroundSymbol",
    "copyrightText"
})
public class MapServerInfo {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "FullExtent")
    protected Envelope fullExtent;
    @XmlElement(name = "Extent")
    protected Envelope extent;
    @XmlElement(name = "SpatialReference")
    protected SpatialReference spatialReference;
    @XmlElement(name = "MapLayerInfos")
    protected ArrayOfMapLayerInfo mapLayerInfos;
    @XmlElement(name = "BackgroundColor")
    protected Color backgroundColor;
    @XmlElement(name = "Bookmarks")
    protected ArrayOfMapServerBookmark bookmarks;
    @XmlElement(name = "DefaultMapDescription")
    protected MapDescription defaultMapDescription;
    @XmlElement(name = "Units", required = true)
    protected EsriUnits units;
    @XmlElement(name = "SupportedImageReturnTypes", required = true)
    protected EsriImageReturnType supportedImageReturnTypes;
    @XmlElement(name = "BackgroundSymbol")
    protected FillSymbol backgroundSymbol;
    @XmlElement(name = "CopyrightText", required = true)
    protected String copyrightText;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the fullExtent property.
     * 
     * @return
     *     possible object is
     *     {@link Envelope }
     *     
     */
    public Envelope getFullExtent() {
        return fullExtent;
    }

    /**
     * Sets the value of the fullExtent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Envelope }
     *     
     */
    public void setFullExtent(Envelope value) {
        this.fullExtent = value;
    }

    /**
     * Gets the value of the extent property.
     * 
     * @return
     *     possible object is
     *     {@link Envelope }
     *     
     */
    public Envelope getExtent() {
        return extent;
    }

    /**
     * Sets the value of the extent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Envelope }
     *     
     */
    public void setExtent(Envelope value) {
        this.extent = value;
    }

    /**
     * Gets the value of the spatialReference property.
     * 
     * @return
     *     possible object is
     *     {@link SpatialReference }
     *     
     */
    public SpatialReference getSpatialReference() {
        return spatialReference;
    }

    /**
     * Sets the value of the spatialReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpatialReference }
     *     
     */
    public void setSpatialReference(SpatialReference value) {
        this.spatialReference = value;
    }

    /**
     * Gets the value of the mapLayerInfos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMapLayerInfo }
     *     
     */
    public ArrayOfMapLayerInfo getMapLayerInfos() {
        return mapLayerInfos;
    }

    /**
     * Sets the value of the mapLayerInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMapLayerInfo }
     *     
     */
    public void setMapLayerInfos(ArrayOfMapLayerInfo value) {
        this.mapLayerInfos = value;
    }

    /**
     * Gets the value of the backgroundColor property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets the value of the backgroundColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setBackgroundColor(Color value) {
        this.backgroundColor = value;
    }

    /**
     * Gets the value of the bookmarks property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMapServerBookmark }
     *     
     */
    public ArrayOfMapServerBookmark getBookmarks() {
        return bookmarks;
    }

    /**
     * Sets the value of the bookmarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMapServerBookmark }
     *     
     */
    public void setBookmarks(ArrayOfMapServerBookmark value) {
        this.bookmarks = value;
    }

    /**
     * Gets the value of the defaultMapDescription property.
     * 
     * @return
     *     possible object is
     *     {@link MapDescription }
     *     
     */
    public MapDescription getDefaultMapDescription() {
        return defaultMapDescription;
    }

    /**
     * Sets the value of the defaultMapDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapDescription }
     *     
     */
    public void setDefaultMapDescription(MapDescription value) {
        this.defaultMapDescription = value;
    }

    /**
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link EsriUnits }
     *     
     */
    public EsriUnits getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriUnits }
     *     
     */
    public void setUnits(EsriUnits value) {
        this.units = value;
    }

    /**
     * Gets the value of the supportedImageReturnTypes property.
     * 
     * @return
     *     possible object is
     *     {@link EsriImageReturnType }
     *     
     */
    public EsriImageReturnType getSupportedImageReturnTypes() {
        return supportedImageReturnTypes;
    }

    /**
     * Sets the value of the supportedImageReturnTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriImageReturnType }
     *     
     */
    public void setSupportedImageReturnTypes(EsriImageReturnType value) {
        this.supportedImageReturnTypes = value;
    }

    /**
     * Gets the value of the backgroundSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link FillSymbol }
     *     
     */
    public FillSymbol getBackgroundSymbol() {
        return backgroundSymbol;
    }

    /**
     * Sets the value of the backgroundSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link FillSymbol }
     *     
     */
    public void setBackgroundSymbol(FillSymbol value) {
        this.backgroundSymbol = value;
    }

    /**
     * Gets the value of the copyrightText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCopyrightText() {
        return copyrightText;
    }

    /**
     * Sets the value of the copyrightText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCopyrightText(String value) {
        this.copyrightText = value;
    }

}
