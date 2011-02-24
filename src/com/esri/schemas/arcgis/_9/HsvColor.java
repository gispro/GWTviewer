
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * A color in the HSV (Hue, Saturation, Value) color system.
 * 
 * <p>Java class for HsvColor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HsvColor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Color">
 *       &lt;sequence>
 *         &lt;element name="Hue" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Saturation" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HsvColor", propOrder = {
    "hue",
    "saturation",
    "value"
})
public class HsvColor
    extends Color
{

    @XmlElement(name = "Hue")
    protected short hue;
    @XmlElement(name = "Saturation")
    @XmlSchemaType(name = "unsignedByte")
    protected short saturation;
    @XmlElement(name = "Value")
    @XmlSchemaType(name = "unsignedByte")
    protected short value;

    /**
     * Gets the value of the hue property.
     * 
     */
    public short getHue() {
        return hue;
    }

    /**
     * Sets the value of the hue property.
     * 
     */
    public void setHue(short value) {
        this.hue = value;
    }

    /**
     * Gets the value of the saturation property.
     * 
     */
    public short getSaturation() {
        return saturation;
    }

    /**
     * Sets the value of the saturation property.
     * 
     */
    public void setSaturation(short value) {
        this.saturation = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public short getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(short value) {
        this.value = value;
    }

}
