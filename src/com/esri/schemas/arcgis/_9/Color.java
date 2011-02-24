
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Color complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Color">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UseWindowsDithering" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AlphaValue" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Color", propOrder = {
    "useWindowsDithering",
    "alphaValue"
})
@XmlSeeAlso({
    CmykColor.class,
    RgbColor.class,
    HsvColor.class,
    GrayColor.class,
    HlsColor.class
})
public abstract class Color {

    @XmlElement(name = "UseWindowsDithering")
    protected Boolean useWindowsDithering;
    @XmlElement(name = "AlphaValue")
    @XmlSchemaType(name = "unsignedByte")
    protected Short alphaValue;

    /**
     * Gets the value of the useWindowsDithering property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseWindowsDithering() {
        return useWindowsDithering;
    }

    /**
     * Sets the value of the useWindowsDithering property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseWindowsDithering(Boolean value) {
        this.useWindowsDithering = value;
    }

    /**
     * Gets the value of the alphaValue property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getAlphaValue() {
        return alphaValue;
    }

    /**
     * Sets the value of the alphaValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setAlphaValue(Short value) {
        this.alphaValue = value;
    }

}
