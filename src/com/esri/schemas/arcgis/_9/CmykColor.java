
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * A color in the CMYK(Cyan Magenta Yellow, Black) color system.
 * 
 * <p>Java class for CmykColor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CmykColor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Color">
 *       &lt;sequence>
 *         &lt;element name="Cyan" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="Magenta" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="Yellow" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="Black" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="Overprint" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsSpot" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SpotDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SpotPercent" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CmykColor", propOrder = {
    "cyan",
    "magenta",
    "yellow",
    "black",
    "overprint",
    "isSpot",
    "spotDescription",
    "spotPercent"
})
public class CmykColor
    extends Color
{

    @XmlElement(name = "Cyan")
    @XmlSchemaType(name = "unsignedByte")
    protected short cyan;
    @XmlElement(name = "Magenta")
    @XmlSchemaType(name = "unsignedByte")
    protected short magenta;
    @XmlElement(name = "Yellow")
    @XmlSchemaType(name = "unsignedByte")
    protected short yellow;
    @XmlElement(name = "Black")
    @XmlSchemaType(name = "unsignedByte")
    protected short black;
    @XmlElement(name = "Overprint")
    protected boolean overprint;
    @XmlElement(name = "IsSpot")
    protected boolean isSpot;
    @XmlElement(name = "SpotDescription", required = true)
    protected String spotDescription;
    @XmlElement(name = "SpotPercent")
    protected short spotPercent;

    /**
     * Gets the value of the cyan property.
     * 
     */
    public short getCyan() {
        return cyan;
    }

    /**
     * Sets the value of the cyan property.
     * 
     */
    public void setCyan(short value) {
        this.cyan = value;
    }

    /**
     * Gets the value of the magenta property.
     * 
     */
    public short getMagenta() {
        return magenta;
    }

    /**
     * Sets the value of the magenta property.
     * 
     */
    public void setMagenta(short value) {
        this.magenta = value;
    }

    /**
     * Gets the value of the yellow property.
     * 
     */
    public short getYellow() {
        return yellow;
    }

    /**
     * Sets the value of the yellow property.
     * 
     */
    public void setYellow(short value) {
        this.yellow = value;
    }

    /**
     * Gets the value of the black property.
     * 
     */
    public short getBlack() {
        return black;
    }

    /**
     * Sets the value of the black property.
     * 
     */
    public void setBlack(short value) {
        this.black = value;
    }

    /**
     * Gets the value of the overprint property.
     * 
     */
    public boolean isOverprint() {
        return overprint;
    }

    /**
     * Sets the value of the overprint property.
     * 
     */
    public void setOverprint(boolean value) {
        this.overprint = value;
    }

    /**
     * Gets the value of the isSpot property.
     * 
     */
    public boolean isIsSpot() {
        return isSpot;
    }

    /**
     * Sets the value of the isSpot property.
     * 
     */
    public void setIsSpot(boolean value) {
        this.isSpot = value;
    }

    /**
     * Gets the value of the spotDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpotDescription() {
        return spotDescription;
    }

    /**
     * Sets the value of the spotDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpotDescription(String value) {
        this.spotDescription = value;
    }

    /**
     * Gets the value of the spotPercent property.
     * 
     */
    public short getSpotPercent() {
        return spotPercent;
    }

    /**
     * Sets the value of the spotPercent property.
     * 
     */
    public void setSpotPercent(short value) {
        this.spotPercent = value;
    }

}
