
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * ESRI Query Filter Object.
 * 
 * <p>Java class for QueryFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubFields" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WhereClause" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SpatialReferenceFieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Resolution" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="OutputSpatialReference" type="{http://www.esri.com/schemas/ArcGIS/9.3}SpatialReference" minOccurs="0"/>
 *         &lt;element name="FIDSet" type="{http://www.esri.com/schemas/ArcGIS/9.3}FIDSet" minOccurs="0"/>
 *         &lt;element name="PostfixClause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FilterDefs" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfFilterDef" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryFilter", propOrder = {
    "subFields",
    "whereClause",
    "spatialReferenceFieldName",
    "resolution",
    "outputSpatialReference",
    "fidSet",
    "postfixClause",
    "filterDefs"
})
@XmlSeeAlso({
    SpatialFilter.class
})
public class QueryFilter {

    @XmlElement(name = "SubFields")
    protected String subFields;
    @XmlElement(name = "WhereClause", required = true)
    protected String whereClause;
    @XmlElement(name = "SpatialReferenceFieldName")
    protected String spatialReferenceFieldName;
    @XmlElement(name = "Resolution")
    protected double resolution;
    @XmlElement(name = "OutputSpatialReference")
    protected SpatialReference outputSpatialReference;
    @XmlElement(name = "FIDSet")
    protected FIDSet fidSet;
    @XmlElement(name = "PostfixClause")
    protected String postfixClause;
    @XmlElement(name = "FilterDefs")
    protected ArrayOfFilterDef filterDefs;

    /**
     * Gets the value of the subFields property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubFields() {
        return subFields;
    }

    /**
     * Sets the value of the subFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubFields(String value) {
        this.subFields = value;
    }

    /**
     * Gets the value of the whereClause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhereClause() {
        return whereClause;
    }

    /**
     * Sets the value of the whereClause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhereClause(String value) {
        this.whereClause = value;
    }

    /**
     * Gets the value of the spatialReferenceFieldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpatialReferenceFieldName() {
        return spatialReferenceFieldName;
    }

    /**
     * Sets the value of the spatialReferenceFieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpatialReferenceFieldName(String value) {
        this.spatialReferenceFieldName = value;
    }

    /**
     * Gets the value of the resolution property.
     * 
     */
    public double getResolution() {
        return resolution;
    }

    /**
     * Sets the value of the resolution property.
     * 
     */
    public void setResolution(double value) {
        this.resolution = value;
    }

    /**
     * Gets the value of the outputSpatialReference property.
     * 
     * @return
     *     possible object is
     *     {@link SpatialReference }
     *     
     */
    public SpatialReference getOutputSpatialReference() {
        return outputSpatialReference;
    }

    /**
     * Sets the value of the outputSpatialReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpatialReference }
     *     
     */
    public void setOutputSpatialReference(SpatialReference value) {
        this.outputSpatialReference = value;
    }

    /**
     * Gets the value of the fidSet property.
     * 
     * @return
     *     possible object is
     *     {@link FIDSet }
     *     
     */
    public FIDSet getFIDSet() {
        return fidSet;
    }

    /**
     * Sets the value of the fidSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link FIDSet }
     *     
     */
    public void setFIDSet(FIDSet value) {
        this.fidSet = value;
    }

    /**
     * Gets the value of the postfixClause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostfixClause() {
        return postfixClause;
    }

    /**
     * Sets the value of the postfixClause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostfixClause(String value) {
        this.postfixClause = value;
    }

    /**
     * Gets the value of the filterDefs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFilterDef }
     *     
     */
    public ArrayOfFilterDef getFilterDefs() {
        return filterDefs;
    }

    /**
     * Sets the value of the filterDefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFilterDef }
     *     
     */
    public void setFilterDefs(ArrayOfFilterDef value) {
        this.filterDefs = value;
    }

}
