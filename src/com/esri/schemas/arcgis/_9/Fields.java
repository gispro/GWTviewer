
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ESRI Fields Object.
 * 
 * <p>Java class for Fields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Fields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FieldArray" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfField"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fields", propOrder = {
    "fieldArray"
})
public class Fields {

    @XmlElement(name = "FieldArray", required = true)
    protected ArrayOfField fieldArray;

    /**
     * Gets the value of the fieldArray property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfField }
     *     
     */
    public ArrayOfField getFieldArray() {
        return fieldArray;
    }

    /**
     * Sets the value of the fieldArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfField }
     *     
     */
    public void setFieldArray(ArrayOfField value) {
        this.fieldArray = value;
    }

}
