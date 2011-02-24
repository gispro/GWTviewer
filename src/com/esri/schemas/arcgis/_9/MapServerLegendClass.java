
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Map Server Legend Class object contains settings about a legend class.
 * 
 * <p>Java class for MapServerLegendClass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapServerLegendClass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SymbolImage" type="{http://www.esri.com/schemas/ArcGIS/9.3}ImageResult" minOccurs="0"/>
 *         &lt;element name="TransparentColor" type="{http://www.esri.com/schemas/ArcGIS/9.3}Color" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MapServerLegendClass", propOrder = {
    "label",
    "description",
    "symbolImage",
    "transparentColor"
})
public class MapServerLegendClass {

    @XmlElement(name = "Label", required = true)
    protected String label;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "SymbolImage")
    protected ImageResult symbolImage;
    @XmlElement(name = "TransparentColor")
    protected Color transparentColor;

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
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
     * Gets the value of the symbolImage property.
     * 
     * @return
     *     possible object is
     *     {@link ImageResult }
     *     
     */
    public ImageResult getSymbolImage() {
        return symbolImage;
    }

    /**
     * Sets the value of the symbolImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageResult }
     *     
     */
    public void setSymbolImage(ImageResult value) {
        this.symbolImage = value;
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

}
