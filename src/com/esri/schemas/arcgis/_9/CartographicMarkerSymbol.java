
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Cartographic marker symbol properties.
 *       
 * 
 * <p>Java class for CartographicMarkerSymbol complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CartographicMarkerSymbol">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}MarkerSymbol">
 *       &lt;sequence>
 *         &lt;element name="XScale" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="YScale" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CartographicMarkerSymbol", propOrder = {
    "xScale",
    "yScale"
})
@XmlSeeAlso({
    PictureMarkerSymbol.class,
    CharacterMarkerSymbol.class
})
public abstract class CartographicMarkerSymbol
    extends MarkerSymbol
{

    @XmlElement(name = "XScale", defaultValue = "1.0")
    protected double xScale;
    @XmlElement(name = "YScale", defaultValue = "1.0")
    protected double yScale;

    /**
     * Gets the value of the xScale property.
     * 
     */
    public double getXScale() {
        return xScale;
    }

    /**
     * Sets the value of the xScale property.
     * 
     */
    public void setXScale(double value) {
        this.xScale = value;
    }

    /**
     * Gets the value of the yScale property.
     * 
     */
    public double getYScale() {
        return yScale;
    }

    /**
     * Sets the value of the yScale property.
     * 
     */
    public void setYScale(double value) {
        this.yScale = value;
    }

}
