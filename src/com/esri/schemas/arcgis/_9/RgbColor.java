
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * A color in the RGB(Red Green Blue) color system.
 * 
 * <p>Java class for RgbColor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RgbColor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Color">
 *       &lt;sequence>
 *         &lt;element name="Red" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="Green" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="Blue" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RgbColor", propOrder = {
    "red",
    "green",
    "blue"
})
public class RgbColor
    extends Color
{

    @XmlElement(name = "Red")
    @XmlSchemaType(name = "unsignedByte")
    protected short red;
    @XmlElement(name = "Green")
    @XmlSchemaType(name = "unsignedByte")
    protected short green;
    @XmlElement(name = "Blue")
    @XmlSchemaType(name = "unsignedByte")
    protected short blue;

    /**
     * Gets the value of the red property.
     * 
     */
    public short getRed() {
        return red;
    }

    /**
     * Sets the value of the red property.
     * 
     */
    public void setRed(short value) {
        this.red = value;
    }

    /**
     * Gets the value of the green property.
     * 
     */
    public short getGreen() {
        return green;
    }

    /**
     * Sets the value of the green property.
     * 
     */
    public void setGreen(short value) {
        this.green = value;
    }

    /**
     * Gets the value of the blue property.
     * 
     */
    public short getBlue() {
        return blue;
    }

    /**
     * Sets the value of the blue property.
     * 
     */
    public void setBlue(short value) {
        this.blue = value;
    }

}
