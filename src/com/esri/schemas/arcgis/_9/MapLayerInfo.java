
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Map JSONLayer Info object provides read-only information about a layer in a map.
 * 
 * <p>Java class for MapLayerInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapLayerInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LayerID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LayerType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SourceDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HasLabels" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanSelect" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanScaleSymbols" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MinScale" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="MaxScale" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Extent" type="{http://www.esri.com/schemas/ArcGIS/9.3}Envelope" minOccurs="0"/>
 *         &lt;element name="HasHyperlinks" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="HasAttributes" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanIdentify" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanFind" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsFeatureLayer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Fields" type="{http://www.esri.com/schemas/ArcGIS/9.3}Fields" minOccurs="0"/>
 *         &lt;element name="DisplayField" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IDField" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IsComposite" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SubLayerIDs" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfInt" minOccurs="0"/>
 *         &lt;element name="ParentLayerID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FieldAliases" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfString" minOccurs="0"/>
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
@XmlType(name = "MapLayerInfo", propOrder = {
    "layerID",
    "name",
    "description",
    "layerType",
    "sourceDescription",
    "hasLabels",
    "canSelect",
    "canScaleSymbols",
    "minScale",
    "maxScale",
    "extent",
    "hasHyperlinks",
    "hasAttributes",
    "canIdentify",
    "canFind",
    "isFeatureLayer",
    "fields",
    "displayField",
    "idField",
    "isComposite",
    "subLayerIDs",
    "parentLayerID",
    "fieldAliases",
    "copyrightText"
})
public class MapLayerInfo {

    @XmlElement(name = "LayerID")
    protected int layerID;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "LayerType", required = true)
    protected String layerType;
    @XmlElement(name = "SourceDescription", required = true)
    protected String sourceDescription;
    @XmlElement(name = "HasLabels")
    protected boolean hasLabels;
    @XmlElement(name = "CanSelect")
    protected boolean canSelect;
    @XmlElement(name = "CanScaleSymbols")
    protected boolean canScaleSymbols;
    @XmlElement(name = "MinScale")
    protected double minScale;
    @XmlElement(name = "MaxScale")
    protected double maxScale;
    @XmlElement(name = "Extent")
    protected Envelope extent;
    @XmlElement(name = "HasHyperlinks")
    protected boolean hasHyperlinks;
    @XmlElement(name = "HasAttributes")
    protected boolean hasAttributes;
    @XmlElement(name = "CanIdentify")
    protected boolean canIdentify;
    @XmlElement(name = "CanFind")
    protected boolean canFind;
    @XmlElement(name = "IsFeatureLayer")
    protected boolean isFeatureLayer;
    @XmlElement(name = "Fields")
    protected Fields fields;
    @XmlElement(name = "DisplayField", required = true)
    protected String displayField;
    @XmlElement(name = "IDField", required = true)
    protected String idField;
    @XmlElement(name = "IsComposite")
    protected boolean isComposite;
    @XmlElement(name = "SubLayerIDs")
    protected ArrayOfInt subLayerIDs;
    @XmlElement(name = "ParentLayerID")
    protected int parentLayerID;
    @XmlElement(name = "FieldAliases")
    protected ArrayOfString fieldAliases;
    @XmlElement(name = "CopyrightText", required = true)
    protected String copyrightText;

    /**
     * Gets the value of the layerID property.
     * 
     */
    public int getLayerID() {
        return layerID;
    }

    /**
     * Sets the value of the layerID property.
     * 
     */
    public void setLayerID(int value) {
        this.layerID = value;
    }

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
     * Gets the value of the layerType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLayerType() {
        return layerType;
    }

    /**
     * Sets the value of the layerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLayerType(String value) {
        this.layerType = value;
    }

    /**
     * Gets the value of the sourceDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceDescription() {
        return sourceDescription;
    }

    /**
     * Sets the value of the sourceDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceDescription(String value) {
        this.sourceDescription = value;
    }

    /**
     * Gets the value of the hasLabels property.
     * 
     */
    public boolean isHasLabels() {
        return hasLabels;
    }

    /**
     * Sets the value of the hasLabels property.
     * 
     */
    public void setHasLabels(boolean value) {
        this.hasLabels = value;
    }

    /**
     * Gets the value of the canSelect property.
     * 
     */
    public boolean isCanSelect() {
        return canSelect;
    }

    /**
     * Sets the value of the canSelect property.
     * 
     */
    public void setCanSelect(boolean value) {
        this.canSelect = value;
    }

    /**
     * Gets the value of the canScaleSymbols property.
     * 
     */
    public boolean isCanScaleSymbols() {
        return canScaleSymbols;
    }

    /**
     * Sets the value of the canScaleSymbols property.
     * 
     */
    public void setCanScaleSymbols(boolean value) {
        this.canScaleSymbols = value;
    }

    /**
     * Gets the value of the minScale property.
     * 
     */
    public double getMinScale() {
        return minScale;
    }

    /**
     * Sets the value of the minScale property.
     * 
     */
    public void setMinScale(double value) {
        this.minScale = value;
    }

    /**
     * Gets the value of the maxScale property.
     * 
     */
    public double getMaxScale() {
        return maxScale;
    }

    /**
     * Sets the value of the maxScale property.
     * 
     */
    public void setMaxScale(double value) {
        this.maxScale = value;
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
     * Gets the value of the hasHyperlinks property.
     * 
     */
    public boolean isHasHyperlinks() {
        return hasHyperlinks;
    }

    /**
     * Sets the value of the hasHyperlinks property.
     * 
     */
    public void setHasHyperlinks(boolean value) {
        this.hasHyperlinks = value;
    }

    /**
     * Gets the value of the hasAttributes property.
     * 
     */
    public boolean isHasAttributes() {
        return hasAttributes;
    }

    /**
     * Sets the value of the hasAttributes property.
     * 
     */
    public void setHasAttributes(boolean value) {
        this.hasAttributes = value;
    }

    /**
     * Gets the value of the canIdentify property.
     * 
     */
    public boolean isCanIdentify() {
        return canIdentify;
    }

    /**
     * Sets the value of the canIdentify property.
     * 
     */
    public void setCanIdentify(boolean value) {
        this.canIdentify = value;
    }

    /**
     * Gets the value of the canFind property.
     * 
     */
    public boolean isCanFind() {
        return canFind;
    }

    /**
     * Sets the value of the canFind property.
     * 
     */
    public void setCanFind(boolean value) {
        this.canFind = value;
    }

    /**
     * Gets the value of the isFeatureLayer property.
     * 
     */
    public boolean isIsFeatureLayer() {
        return isFeatureLayer;
    }

    /**
     * Sets the value of the isFeatureLayer property.
     * 
     */
    public void setIsFeatureLayer(boolean value) {
        this.isFeatureLayer = value;
    }

    /**
     * Gets the value of the fields property.
     * 
     * @return
     *     possible object is
     *     {@link Fields }
     *     
     */
    public Fields getFields() {
        return fields;
    }

    /**
     * Sets the value of the fields property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields }
     *     
     */
    public void setFields(Fields value) {
        this.fields = value;
    }

    /**
     * Gets the value of the displayField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayField() {
        return displayField;
    }

    /**
     * Sets the value of the displayField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayField(String value) {
        this.displayField = value;
    }

    /**
     * Gets the value of the idField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDField() {
        return idField;
    }

    /**
     * Sets the value of the idField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDField(String value) {
        this.idField = value;
    }

    /**
     * Gets the value of the isComposite property.
     * 
     */
    public boolean isIsComposite() {
        return isComposite;
    }

    /**
     * Sets the value of the isComposite property.
     * 
     */
    public void setIsComposite(boolean value) {
        this.isComposite = value;
    }

    /**
     * Gets the value of the subLayerIDs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getSubLayerIDs() {
        return subLayerIDs;
    }

    /**
     * Sets the value of the subLayerIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setSubLayerIDs(ArrayOfInt value) {
        this.subLayerIDs = value;
    }

    /**
     * Gets the value of the parentLayerID property.
     * 
     */
    public int getParentLayerID() {
        return parentLayerID;
    }

    /**
     * Sets the value of the parentLayerID property.
     * 
     */
    public void setParentLayerID(int value) {
        this.parentLayerID = value;
    }

    /**
     * Gets the value of the fieldAliases property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getFieldAliases() {
        return fieldAliases;
    }

    /**
     * Sets the value of the fieldAliases property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setFieldAliases(ArrayOfString value) {
        this.fieldAliases = value;
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
