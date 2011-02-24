
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Map Description object contains settings of a map in the current document.
 * 
 * <p>Java class for MapDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapDescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MapArea" type="{http://www.esri.com/schemas/ArcGIS/9.3}MapArea" minOccurs="0"/>
 *         &lt;element name="LayerDescriptions" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfLayerDescription" minOccurs="0"/>
 *         &lt;element name="Rotation" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="SpatialReference" type="{http://www.esri.com/schemas/ArcGIS/9.3}SpatialReference" minOccurs="0"/>
 *         &lt;element name="TransparentColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="SelectionColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="BackgroundSymbol" type="{http://www.esri.com/schemas/ArcGIS/9.3}FillSymbol" minOccurs="0"/>
 *         &lt;element name="CustomGraphics" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfGraphicElement" minOccurs="0"/>
 *         &lt;element name="GeoTransformation" type="{http://www.esri.com/schemas/ArcGIS/9.3}GeoTransformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MapDescription", propOrder = {
    "name",
    "mapArea",
    "layerDescriptions",
    "rotation",
    "spatialReference",
    "transparentColor",
    "selectionColor",
    "backgroundSymbol",
    "customGraphics",
    "geoTransformation"
})
public class MapDescription {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "MapArea")
    protected MapArea mapArea;
    @XmlElement(name = "LayerDescriptions")
    protected ArrayOfLayerDescription layerDescriptions;
    @XmlElement(name = "Rotation")
    protected double rotation;
    @XmlElement(name = "SpatialReference")
    protected SpatialReference spatialReference;
    @XmlElement(name = "TransparentColor")
    protected Color transparentColor;
    @XmlElement(name = "SelectionColor")
    protected Color selectionColor;
    @XmlElement(name = "BackgroundSymbol")
    protected FillSymbol backgroundSymbol;
    @XmlElement(name = "CustomGraphics")
    protected ArrayOfGraphicElement customGraphics;
    @XmlElement(name = "GeoTransformation")
    protected GeoTransformation geoTransformation;

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
     * Gets the value of the mapArea property.
     * 
     * @return
     *     possible object is
     *     {@link MapArea }
     *     
     */
    public MapArea getMapArea() {
        return mapArea;
    }

    /**
     * Sets the value of the mapArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapArea }
     *     
     */
    public void setMapArea(MapArea value) {
        this.mapArea = value;
    }

    /**
     * Gets the value of the layerDescriptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLayerDescription }
     *     
     */
    public ArrayOfLayerDescription getLayerDescriptions() {
        return layerDescriptions;
    }

    /**
     * Sets the value of the layerDescriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLayerDescription }
     *     
     */
    public void setLayerDescriptions(ArrayOfLayerDescription value) {
        this.layerDescriptions = value;
    }

    /**
     * Gets the value of the rotation property.
     * 
     */
    public double getRotation() {
        return rotation;
    }

    /**
     * Sets the value of the rotation property.
     * 
     */
    public void setRotation(double value) {
        this.rotation = value;
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
     * Gets the value of the transparentColor property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getTransparentColor() {
        return transparentColor;
    }

    /**
     * Sets the value of the transparentColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setTransparentColor(Color value) {
        this.transparentColor = value;
    }

    /**
     * Gets the value of the selectionColor property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getSelectionColor() {
        return selectionColor;
    }

    /**
     * Sets the value of the selectionColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setSelectionColor(Color value) {
        this.selectionColor = value;
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
     * Gets the value of the customGraphics property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGraphicElement }
     *     
     */
    public ArrayOfGraphicElement getCustomGraphics() {
        return customGraphics;
    }

    /**
     * Sets the value of the customGraphics property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGraphicElement }
     *     
     */
    public void setCustomGraphics(ArrayOfGraphicElement value) {
        this.customGraphics = value;
    }

    /**
     * Gets the value of the geoTransformation property.
     * 
     * @return
     *     possible object is
     *     {@link GeoTransformation }
     *     
     */
    public GeoTransformation getGeoTransformation() {
        return geoTransformation;
    }

    /**
     * Sets the value of the geoTransformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoTransformation }
     *     
     */
    public void setGeoTransformation(GeoTransformation value) {
        this.geoTransformation = value;
    }

}
