
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ESRI RecordSet Object.
 * 
 * <p>Java class for RecordSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecordSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fields" type="{http://www.esri.com/schemas/ArcGIS/9.3}Fields"/>
 *         &lt;element name="Records" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfRecord"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordSet", propOrder = {
    "fields",
    "records"
})
public class RecordSet {

    @XmlElement(name = "Fields", required = true)
    protected Fields fields;
    @XmlElement(name = "Records", required = true)
    protected ArrayOfRecord records;

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
     * Gets the value of the records property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRecord }
     *     
     */
    public ArrayOfRecord getRecords() {
        return records;
    }

    /**
     * Sets the value of the records property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRecord }
     *     
     */
    public void setRecords(ArrayOfRecord value) {
        this.records = value;
    }

}
