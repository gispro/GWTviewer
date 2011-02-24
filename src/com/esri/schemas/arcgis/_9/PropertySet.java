
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ESRI Property Set object.
 * 
 * <p>Java class for PropertySet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertySet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PropertyArray" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfPropertySetProperty"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertySet", propOrder = {
    "propertyArray"
})
public class PropertySet {

    @XmlElement(name = "PropertyArray", required = true)
    protected ArrayOfPropertySetProperty propertyArray;

    /**
     * Gets the value of the propertyArray property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPropertySetProperty }
     *     
     */
    public ArrayOfPropertySetProperty getPropertyArray() {
        return propertyArray;
    }

    /**
     * Sets the value of the propertyArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPropertySetProperty }
     *     
     */
    public void setPropertyArray(ArrayOfPropertySetProperty value) {
        this.propertyArray = value;
    }

}
