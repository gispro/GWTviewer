
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A Tile Image Info object.
 * 
 * <p>Java class for TileImageInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TileImageInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CacheTileFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CompressionQuality" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Antialiasing" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TileImageInfo", propOrder = {
    "cacheTileFormat",
    "compressionQuality",
    "antialiasing"
})
public class TileImageInfo {

    @XmlElement(name = "CacheTileFormat", required = true)
    protected String cacheTileFormat;
    @XmlElement(name = "CompressionQuality")
    protected int compressionQuality;
    @XmlElement(name = "Antialiasing", required = true)
    protected String antialiasing;

    /**
     * Gets the value of the cacheTileFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCacheTileFormat() {
        return cacheTileFormat;
    }

    /**
     * Sets the value of the cacheTileFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCacheTileFormat(String value) {
        this.cacheTileFormat = value;
    }

    /**
     * Gets the value of the compressionQuality property.
     * 
     */
    public int getCompressionQuality() {
        return compressionQuality;
    }

    /**
     * Sets the value of the compressionQuality property.
     * 
     */
    public void setCompressionQuality(int value) {
        this.compressionQuality = value;
    }

    /**
     * Gets the value of the antialiasing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAntialiasing() {
        return antialiasing;
    }

    /**
     * Sets the value of the antialiasing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAntialiasing(String value) {
        this.antialiasing = value;
    }

}
