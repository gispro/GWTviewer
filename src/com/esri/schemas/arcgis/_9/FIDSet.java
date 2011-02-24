
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ESRI FID Set object.
 * 
 * <p>Java class for FIDSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FIDSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIDArray" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIDSet", propOrder = {
    "fidArray"
})
public class FIDSet {

    @XmlElement(name = "FIDArray", required = true)
    protected ArrayOfInt fidArray;

    /**
     * Gets the value of the fidArray property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getFIDArray() {
        return fidArray;
    }

    /**
     * Sets the value of the fidArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setFIDArray(ArrayOfInt value) {
        this.fidArray = value;
    }

}
