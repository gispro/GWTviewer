
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A map surround for displaying a scale bar.
 * 
 * <p>Java class for ScaleBar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScaleBar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BarHeight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Division" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Divisions" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="DivisionsBeforeZero" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="Subdivisions" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="Units" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriUnits" minOccurs="0"/>
 *         &lt;element name="UnitLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitLabelPosition" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriScaleBarPos" minOccurs="0"/>
 *         &lt;element name="UnitLabelGap" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="UnitLabelSymbol" type="{http://www.esri.com/schemas/ArcGIS/9.3}TextSymbol" minOccurs="0"/>
 *         &lt;element name="LabelFrequency" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriScaleBarFrequency" minOccurs="0"/>
 *         &lt;element name="LabelPosition" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriVertPosEnum" minOccurs="0"/>
 *         &lt;element name="LabelGap" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="LabelSymbol" type="{http://www.esri.com/schemas/ArcGIS/9.3}TextSymbol" minOccurs="0"/>
 *         &lt;element name="NumberFormat" type="{http://www.esri.com/schemas/ArcGIS/9.3}NumericFormat" minOccurs="0"/>
 *         &lt;element name="ResizeHint" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriScaleBarResizeHint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScaleBar", propOrder = {
    "barHeight",
    "division",
    "divisions",
    "divisionsBeforeZero",
    "subdivisions",
    "units",
    "unitLabel",
    "unitLabelPosition",
    "unitLabelGap",
    "unitLabelSymbol",
    "labelFrequency",
    "labelPosition",
    "labelGap",
    "labelSymbol",
    "numberFormat",
    "resizeHint"
})
@XmlSeeAlso({
    AlternatingScaleBar.class,
    SingleDivisionScaleBar.class
})
public abstract class ScaleBar {

    @XmlElement(name = "BarHeight")
    protected Double barHeight;
    @XmlElement(name = "Division")
    protected Double division;
    @XmlElement(name = "Divisions")
    protected Short divisions;
    @XmlElement(name = "DivisionsBeforeZero")
    protected Short divisionsBeforeZero;
    @XmlElement(name = "Subdivisions")
    protected Short subdivisions;
    @XmlElement(name = "Units")
    protected EsriUnits units;
    @XmlElement(name = "UnitLabel")
    protected String unitLabel;
    @XmlElement(name = "UnitLabelPosition")
    protected EsriScaleBarPos unitLabelPosition;
    @XmlElement(name = "UnitLabelGap")
    protected Double unitLabelGap;
    @XmlElement(name = "UnitLabelSymbol")
    protected TextSymbol unitLabelSymbol;
    @XmlElement(name = "LabelFrequency")
    protected EsriScaleBarFrequency labelFrequency;
    @XmlElement(name = "LabelPosition")
    protected EsriVertPosEnum labelPosition;
    @XmlElement(name = "LabelGap")
    protected Double labelGap;
    @XmlElement(name = "LabelSymbol")
    protected TextSymbol labelSymbol;
    @XmlElement(name = "NumberFormat")
    protected NumericFormat numberFormat;
    @XmlElement(name = "ResizeHint")
    protected EsriScaleBarResizeHint resizeHint;

    /**
     * Gets the value of the barHeight property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBarHeight() {
        return barHeight;
    }

    /**
     * Sets the value of the barHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBarHeight(Double value) {
        this.barHeight = value;
    }

    /**
     * Gets the value of the division property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDivision() {
        return division;
    }

    /**
     * Sets the value of the division property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDivision(Double value) {
        this.division = value;
    }

    /**
     * Gets the value of the divisions property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getDivisions() {
        return divisions;
    }

    /**
     * Sets the value of the divisions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setDivisions(Short value) {
        this.divisions = value;
    }

    /**
     * Gets the value of the divisionsBeforeZero property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getDivisionsBeforeZero() {
        return divisionsBeforeZero;
    }

    /**
     * Sets the value of the divisionsBeforeZero property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setDivisionsBeforeZero(Short value) {
        this.divisionsBeforeZero = value;
    }

    /**
     * Gets the value of the subdivisions property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getSubdivisions() {
        return subdivisions;
    }

    /**
     * Sets the value of the subdivisions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setSubdivisions(Short value) {
        this.subdivisions = value;
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
     * Gets the value of the unitLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitLabel() {
        return unitLabel;
    }

    /**
     * Sets the value of the unitLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitLabel(String value) {
        this.unitLabel = value;
    }

    /**
     * Gets the value of the unitLabelPosition property.
     * 
     * @return
     *     possible object is
     *     {@link EsriScaleBarPos }
     *     
     */
    public EsriScaleBarPos getUnitLabelPosition() {
        return unitLabelPosition;
    }

    /**
     * Sets the value of the unitLabelPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriScaleBarPos }
     *     
     */
    public void setUnitLabelPosition(EsriScaleBarPos value) {
        this.unitLabelPosition = value;
    }

    /**
     * Gets the value of the unitLabelGap property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getUnitLabelGap() {
        return unitLabelGap;
    }

    /**
     * Sets the value of the unitLabelGap property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setUnitLabelGap(Double value) {
        this.unitLabelGap = value;
    }

    /**
     * Gets the value of the unitLabelSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link TextSymbol }
     *     
     */
    public TextSymbol getUnitLabelSymbol() {
        return unitLabelSymbol;
    }

    /**
     * Sets the value of the unitLabelSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextSymbol }
     *     
     */
    public void setUnitLabelSymbol(TextSymbol value) {
        this.unitLabelSymbol = value;
    }

    /**
     * Gets the value of the labelFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link EsriScaleBarFrequency }
     *     
     */
    public EsriScaleBarFrequency getLabelFrequency() {
        return labelFrequency;
    }

    /**
     * Sets the value of the labelFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriScaleBarFrequency }
     *     
     */
    public void setLabelFrequency(EsriScaleBarFrequency value) {
        this.labelFrequency = value;
    }

    /**
     * Gets the value of the labelPosition property.
     * 
     * @return
     *     possible object is
     *     {@link EsriVertPosEnum }
     *     
     */
    public EsriVertPosEnum getLabelPosition() {
        return labelPosition;
    }

    /**
     * Sets the value of the labelPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriVertPosEnum }
     *     
     */
    public void setLabelPosition(EsriVertPosEnum value) {
        this.labelPosition = value;
    }

    /**
     * Gets the value of the labelGap property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLabelGap() {
        return labelGap;
    }

    /**
     * Sets the value of the labelGap property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLabelGap(Double value) {
        this.labelGap = value;
    }

    /**
     * Gets the value of the labelSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link TextSymbol }
     *     
     */
    public TextSymbol getLabelSymbol() {
        return labelSymbol;
    }

    /**
     * Sets the value of the labelSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextSymbol }
     *     
     */
    public void setLabelSymbol(TextSymbol value) {
        this.labelSymbol = value;
    }

    /**
     * Gets the value of the numberFormat property.
     * 
     * @return
     *     possible object is
     *     {@link NumericFormat }
     *     
     */
    public NumericFormat getNumberFormat() {
        return numberFormat;
    }

    /**
     * Sets the value of the numberFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericFormat }
     *     
     */
    public void setNumberFormat(NumericFormat value) {
        this.numberFormat = value;
    }

    /**
     * Gets the value of the resizeHint property.
     * 
     * @return
     *     possible object is
     *     {@link EsriScaleBarResizeHint }
     *     
     */
    public EsriScaleBarResizeHint getResizeHint() {
        return resizeHint;
    }

    /**
     * Sets the value of the resizeHint property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriScaleBarResizeHint }
     *     
     */
    public void setResizeHint(EsriScaleBarResizeHint value) {
        this.resizeHint = value;
    }

}
