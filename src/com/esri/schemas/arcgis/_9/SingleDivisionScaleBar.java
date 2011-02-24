
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A map surround for displaying a single division scale bar.
 * 
 * <p>Java class for SingleDivisionScaleBar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SingleDivisionScaleBar">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}ScaleBar">
 *       &lt;sequence>
 *         &lt;element name="FillSymbol" type="{http://www.esri.com/schemas/ArcGIS/9.3}FillSymbol" minOccurs="0"/>
 *         &lt;element name="DivisionMarkSymbol" type="{http://www.esri.com/schemas/ArcGIS/9.3}LineSymbol" minOccurs="0"/>
 *         &lt;element name="SubdivisionMarkSymbol" type="{http://www.esri.com/schemas/ArcGIS/9.3}LineSymbol" minOccurs="0"/>
 *         &lt;element name="DivisionMarkHeight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="SubdivisionMarkHeight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="MarkPosition" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriVertPosEnum" minOccurs="0"/>
 *         &lt;element name="MarkFrequency" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriScaleBarFrequency" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SingleDivisionScaleBar", propOrder = {
    "fillSymbol",
    "divisionMarkSymbol",
    "subdivisionMarkSymbol",
    "divisionMarkHeight",
    "subdivisionMarkHeight",
    "markPosition",
    "markFrequency"
})
public class SingleDivisionScaleBar
    extends ScaleBar
{

    @XmlElement(name = "FillSymbol")
    protected FillSymbol fillSymbol;
    @XmlElement(name = "DivisionMarkSymbol")
    protected LineSymbol divisionMarkSymbol;
    @XmlElement(name = "SubdivisionMarkSymbol")
    protected LineSymbol subdivisionMarkSymbol;
    @XmlElement(name = "DivisionMarkHeight")
    protected Double divisionMarkHeight;
    @XmlElement(name = "SubdivisionMarkHeight")
    protected Double subdivisionMarkHeight;
    @XmlElement(name = "MarkPosition")
    protected EsriVertPosEnum markPosition;
    @XmlElement(name = "MarkFrequency")
    protected EsriScaleBarFrequency markFrequency;

    /**
     * Gets the value of the fillSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link FillSymbol }
     *     
     */
    public FillSymbol getFillSymbol() {
        return fillSymbol;
    }

    /**
     * Sets the value of the fillSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link FillSymbol }
     *     
     */
    public void setFillSymbol(FillSymbol value) {
        this.fillSymbol = value;
    }

    /**
     * Gets the value of the divisionMarkSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link LineSymbol }
     *     
     */
    public LineSymbol getDivisionMarkSymbol() {
        return divisionMarkSymbol;
    }

    /**
     * Sets the value of the divisionMarkSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineSymbol }
     *     
     */
    public void setDivisionMarkSymbol(LineSymbol value) {
        this.divisionMarkSymbol = value;
    }

    /**
     * Gets the value of the subdivisionMarkSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link LineSymbol }
     *     
     */
    public LineSymbol getSubdivisionMarkSymbol() {
        return subdivisionMarkSymbol;
    }

    /**
     * Sets the value of the subdivisionMarkSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineSymbol }
     *     
     */
    public void setSubdivisionMarkSymbol(LineSymbol value) {
        this.subdivisionMarkSymbol = value;
    }

    /**
     * Gets the value of the divisionMarkHeight property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDivisionMarkHeight() {
        return divisionMarkHeight;
    }

    /**
     * Sets the value of the divisionMarkHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDivisionMarkHeight(Double value) {
        this.divisionMarkHeight = value;
    }

    /**
     * Gets the value of the subdivisionMarkHeight property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSubdivisionMarkHeight() {
        return subdivisionMarkHeight;
    }

    /**
     * Sets the value of the subdivisionMarkHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSubdivisionMarkHeight(Double value) {
        this.subdivisionMarkHeight = value;
    }

    /**
     * Gets the value of the markPosition property.
     * 
     * @return
     *     possible object is
     *     {@link EsriVertPosEnum }
     *     
     */
    public EsriVertPosEnum getMarkPosition() {
        return markPosition;
    }

    /**
     * Sets the value of the markPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriVertPosEnum }
     *     
     */
    public void setMarkPosition(EsriVertPosEnum value) {
        this.markPosition = value;
    }

    /**
     * Gets the value of the markFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link EsriScaleBarFrequency }
     *     
     */
    public EsriScaleBarFrequency getMarkFrequency() {
        return markFrequency;
    }

    /**
     * Sets the value of the markFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriScaleBarFrequency }
     *     
     */
    public void setMarkFrequency(EsriScaleBarFrequency value) {
        this.markFrequency = value;
    }

}
