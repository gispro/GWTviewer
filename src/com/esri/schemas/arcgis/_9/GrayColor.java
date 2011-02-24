
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * A color in the grayscale color system.
 * 
 * <p>Java class for GrayColor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GrayColor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Color">
 *       &lt;sequence>
 *         &lt;element name="GrayLevel" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrayColor", propOrder = {
    "grayLevel"
})
public class GrayColor
    extends Color
{

    @XmlElement(name = "GrayLevel")
    @XmlSchemaType(name = "unsignedByte")
    protected short grayLevel;

    /**
     * Gets the value of the grayLevel property.
     * 
     */
    public short getGrayLevel() {
        return grayLevel;
    }

    /**
     * Sets the value of the grayLevel property.
     * 
     */
    public void setGrayLevel(short value) {
        this.grayLevel = value;
    }

}
