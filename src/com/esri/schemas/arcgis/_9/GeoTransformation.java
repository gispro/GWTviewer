
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeoTransformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeoTransformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WKT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WKID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoTransformation", propOrder = {
    "wkt",
    "wkid"
})
public class GeoTransformation {

    @XmlElement(name = "WKT")
    protected String wkt;
    @XmlElement(name = "WKID")
    protected Integer wkid;

    /**
     * Gets the value of the wkt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWKT() {
        return wkt;
    }

    /**
     * Sets the value of the wkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWKT(String value) {
        this.wkt = value;
    }

    /**
     * Gets the value of the wkid property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWKID() {
        return wkid;
    }

    /**
     * Sets the value of the wkid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWKID(Integer value) {
        this.wkid = value;
    }

}
