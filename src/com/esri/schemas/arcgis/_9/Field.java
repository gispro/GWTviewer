
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ESRI Field Object.
 * 
 * <p>Java class for Field complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Field">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriFieldType"/>
 *         &lt;element name="IsNullable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Length" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Precision" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Scale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Required" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Editable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DomainFixed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="GeometryDef" type="{http://www.esri.com/schemas/ArcGIS/9.3}GeometryDef" minOccurs="0"/>
 *         &lt;element name="AliasName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ModelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultValue" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="Domain" type="{http://www.esri.com/schemas/ArcGIS/9.3}Domain" minOccurs="0"/>
 *         &lt;element name="RasterDef" type="{http://www.esri.com/schemas/ArcGIS/9.3}RasterDef" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Field", propOrder = {
    "name",
    "type",
    "isNullable",
    "length",
    "precision",
    "scale",
    "required",
    "editable",
    "domainFixed",
    "geometryDef",
    "aliasName",
    "modelName",
    "defaultValue",
    "domain",
    "rasterDef"
})
public class Field {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Type", required = true)
    protected EsriFieldType type;
    @XmlElement(name = "IsNullable")
    protected boolean isNullable;
    @XmlElement(name = "Length")
    protected int length;
    @XmlElement(name = "Precision")
    protected int precision;
    @XmlElement(name = "Scale")
    protected int scale;
    @XmlElement(name = "Required")
    protected Boolean required;
    @XmlElement(name = "Editable")
    protected Boolean editable;
    @XmlElement(name = "DomainFixed")
    protected Boolean domainFixed;
    @XmlElement(name = "GeometryDef")
    protected GeometryDef geometryDef;
    @XmlElement(name = "AliasName")
    protected String aliasName;
    @XmlElement(name = "ModelName")
    protected String modelName;
    @XmlElement(name = "DefaultValue")
    protected Object defaultValue;
    @XmlElement(name = "Domain")
    protected Domain domain;
    @XmlElement(name = "RasterDef")
    protected RasterDef rasterDef;

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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link EsriFieldType }
     *     
     */
    public EsriFieldType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriFieldType }
     *     
     */
    public void setType(EsriFieldType value) {
        this.type = value;
    }

    /**
     * Gets the value of the isNullable property.
     * 
     */
    public boolean isIsNullable() {
        return isNullable;
    }

    /**
     * Sets the value of the isNullable property.
     * 
     */
    public void setIsNullable(boolean value) {
        this.isNullable = value;
    }

    /**
     * Gets the value of the length property.
     * 
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     */
    public void setLength(int value) {
        this.length = value;
    }

    /**
     * Gets the value of the precision property.
     * 
     */
    public int getPrecision() {
        return precision;
    }

    /**
     * Sets the value of the precision property.
     * 
     */
    public void setPrecision(int value) {
        this.precision = value;
    }

    /**
     * Gets the value of the scale property.
     * 
     */
    public int getScale() {
        return scale;
    }

    /**
     * Sets the value of the scale property.
     * 
     */
    public void setScale(int value) {
        this.scale = value;
    }

    /**
     * Gets the value of the required property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequired() {
        return required;
    }

    /**
     * Sets the value of the required property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequired(Boolean value) {
        this.required = value;
    }

    /**
     * Gets the value of the editable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEditable() {
        return editable;
    }

    /**
     * Sets the value of the editable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEditable(Boolean value) {
        this.editable = value;
    }

    /**
     * Gets the value of the domainFixed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDomainFixed() {
        return domainFixed;
    }

    /**
     * Sets the value of the domainFixed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDomainFixed(Boolean value) {
        this.domainFixed = value;
    }

    /**
     * Gets the value of the geometryDef property.
     * 
     * @return
     *     possible object is
     *     {@link GeometryDef }
     *     
     */
    public GeometryDef getGeometryDef() {
        return geometryDef;
    }

    /**
     * Sets the value of the geometryDef property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryDef }
     *     
     */
    public void setGeometryDef(GeometryDef value) {
        this.geometryDef = value;
    }

    /**
     * Gets the value of the aliasName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasName() {
        return aliasName;
    }

    /**
     * Sets the value of the aliasName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasName(String value) {
        this.aliasName = value;
    }

    /**
     * Gets the value of the modelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets the value of the modelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelName(String value) {
        this.modelName = value;
    }

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDefaultValue(Object value) {
        this.defaultValue = value;
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link Domain }
     *     
     */
    public Domain getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link Domain }
     *     
     */
    public void setDomain(Domain value) {
        this.domain = value;
    }

    /**
     * Gets the value of the rasterDef property.
     * 
     * @return
     *     possible object is
     *     {@link RasterDef }
     *     
     */
    public RasterDef getRasterDef() {
        return rasterDef;
    }

    /**
     * Sets the value of the rasterDef property.
     * 
     * @param value
     *     allowed object is
     *     {@link RasterDef }
     *     
     */
    public void setRasterDef(RasterDef value) {
        this.rasterDef = value;
    }

}
