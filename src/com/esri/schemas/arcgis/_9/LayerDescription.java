
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The JSONLayer Description object contains settings of a layer in a map.
 * 
 * <p>Java class for LayerDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LayerDescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LayerID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Visible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ShowLabels" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ScaleSymbols" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SelectionFeatures" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfInt" minOccurs="0"/>
 *         &lt;element name="SelectionColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *         &lt;element name="SelectionSymbol" type="{http://www.esri.com/schemas/ArcGIS/9.3}Symbol" minOccurs="0"/>
 *         &lt;element name="SetSelectionSymbol" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SelectionBufferDistance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ShowSelectionBuffer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DefinitionExpression" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SourceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SelectionBufferSymbol" type="{http://www.esri.com/schemas/ArcGIS/9.3}FillSymbol" minOccurs="0"/>
 *         &lt;element name="LayerResultOptions" type="{http://www.esri.com/schemas/ArcGIS/9.3}LayerResultOptions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LayerDescription", propOrder = {
    "layerID",
    "visible",
    "showLabels",
    "scaleSymbols",
    "selectionFeatures",
    "selectionColor",
    "selectionSymbol",
    "setSelectionSymbol",
    "selectionBufferDistance",
    "showSelectionBuffer",
    "definitionExpression",
    "sourceID",
    "selectionBufferSymbol",
    "layerResultOptions"
})
public class LayerDescription {

    @XmlElement(name = "LayerID")
    protected int layerID;
    @XmlElement(name = "Visible")
    protected boolean visible;
    @XmlElement(name = "ShowLabels")
    protected boolean showLabels;
    @XmlElement(name = "ScaleSymbols")
    protected boolean scaleSymbols;
    @XmlElement(name = "SelectionFeatures")
    protected ArrayOfInt selectionFeatures;
    @XmlElement(name = "SelectionColor")
    protected Color selectionColor;
    @XmlElement(name = "SelectionSymbol")
    protected Symbol selectionSymbol;
    @XmlElement(name = "SetSelectionSymbol")
    protected boolean setSelectionSymbol;
    @XmlElement(name = "SelectionBufferDistance")
    protected double selectionBufferDistance;
    @XmlElement(name = "ShowSelectionBuffer")
    protected boolean showSelectionBuffer;
    @XmlElement(name = "DefinitionExpression", required = true)
    protected String definitionExpression;
    @XmlElement(name = "SourceID")
    protected String sourceID;
    @XmlElement(name = "SelectionBufferSymbol")
    protected FillSymbol selectionBufferSymbol;
    @XmlElement(name = "LayerResultOptions")
    protected LayerResultOptions layerResultOptions;

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
     * Gets the value of the visible property.
     * 
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sets the value of the visible property.
     * 
     */
    public void setVisible(boolean value) {
        this.visible = value;
    }

    /**
     * Gets the value of the showLabels property.
     * 
     */
    public boolean isShowLabels() {
        return showLabels;
    }

    /**
     * Sets the value of the showLabels property.
     * 
     */
    public void setShowLabels(boolean value) {
        this.showLabels = value;
    }

    /**
     * Gets the value of the scaleSymbols property.
     * 
     */
    public boolean isScaleSymbols() {
        return scaleSymbols;
    }

    /**
     * Sets the value of the scaleSymbols property.
     * 
     */
    public void setScaleSymbols(boolean value) {
        this.scaleSymbols = value;
    }

    /**
     * Gets the value of the selectionFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getSelectionFeatures() {
        return selectionFeatures;
    }

    /**
     * Sets the value of the selectionFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setSelectionFeatures(ArrayOfInt value) {
        this.selectionFeatures = value;
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
     * Gets the value of the selectionSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link Symbol }
     *     
     */
    public Symbol getSelectionSymbol() {
        return selectionSymbol;
    }

    /**
     * Sets the value of the selectionSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link Symbol }
     *     
     */
    public void setSelectionSymbol(Symbol value) {
        this.selectionSymbol = value;
    }

    /**
     * Gets the value of the setSelectionSymbol property.
     * 
     */
    public boolean isSetSelectionSymbol() {
        return setSelectionSymbol;
    }

    /**
     * Sets the value of the setSelectionSymbol property.
     * 
     */
    public void setSetSelectionSymbol(boolean value) {
        this.setSelectionSymbol = value;
    }

    /**
     * Gets the value of the selectionBufferDistance property.
     * 
     */
    public double getSelectionBufferDistance() {
        return selectionBufferDistance;
    }

    /**
     * Sets the value of the selectionBufferDistance property.
     * 
     */
    public void setSelectionBufferDistance(double value) {
        this.selectionBufferDistance = value;
    }

    /**
     * Gets the value of the showSelectionBuffer property.
     * 
     */
    public boolean isShowSelectionBuffer() {
        return showSelectionBuffer;
    }

    /**
     * Sets the value of the showSelectionBuffer property.
     * 
     */
    public void setShowSelectionBuffer(boolean value) {
        this.showSelectionBuffer = value;
    }

    /**
     * Gets the value of the definitionExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefinitionExpression() {
        return definitionExpression;
    }

    /**
     * Sets the value of the definitionExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefinitionExpression(String value) {
        this.definitionExpression = value;
    }

    /**
     * Gets the value of the sourceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceID() {
        return sourceID;
    }

    /**
     * Sets the value of the sourceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceID(String value) {
        this.sourceID = value;
    }

    /**
     * Gets the value of the selectionBufferSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link FillSymbol }
     *     
     */
    public FillSymbol getSelectionBufferSymbol() {
        return selectionBufferSymbol;
    }

    /**
     * Sets the value of the selectionBufferSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link FillSymbol }
     *     
     */
    public void setSelectionBufferSymbol(FillSymbol value) {
        this.selectionBufferSymbol = value;
    }

    /**
     * Gets the value of the layerResultOptions property.
     * 
     * @return
     *     possible object is
     *     {@link LayerResultOptions }
     *     
     */
    public LayerResultOptions getLayerResultOptions() {
        return layerResultOptions;
    }

    /**
     * Sets the value of the layerResultOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link LayerResultOptions }
     *     
     */
    public void setLayerResultOptions(LayerResultOptions value) {
        this.layerResultOptions = value;
    }

}
