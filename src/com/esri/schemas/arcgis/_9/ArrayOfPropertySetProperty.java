
package com.esri.schemas.arcgis._9;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ESRI PropertySet Property Array object.
 * 
 * <p>Java class for ArrayOfPropertySetProperty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPropertySetProperty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PropertySetProperty" type="{http://www.esri.com/schemas/ArcGIS/9.3}PropertySetProperty" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPropertySetProperty", propOrder = {
    "propertySetProperty"
})
public class ArrayOfPropertySetProperty {

    @XmlElement(name = "PropertySetProperty")
    protected List<PropertySetProperty> propertySetProperty;

    /**
     * Gets the value of the propertySetProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertySetProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertySetProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertySetProperty }
     * 
     * 
     */
    public List<PropertySetProperty> getPropertySetProperty() {
        if (propertySetProperty == null) {
            propertySetProperty = new ArrayList<PropertySetProperty>();
        }
        return this.propertySetProperty;
    }

}
