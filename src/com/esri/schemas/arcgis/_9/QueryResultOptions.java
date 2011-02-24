
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Query Result Options
 * 
 * <p>Java class for QueryResultOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryResultOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Format" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriQueryResultFormat"/>
 *         &lt;element name="FormatProperties" type="{http://www.esri.com/schemas/ArcGIS/9.3}PropertySet" minOccurs="0"/>
 *         &lt;element name="GeoTransformation" type="{http://www.esri.com/schemas/ArcGIS/9.3}GeoTransformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryResultOptions", propOrder = {
    "format",
    "formatProperties",
    "geoTransformation"
})
public class QueryResultOptions {

    @XmlElement(name = "Format", required = true)
    protected EsriQueryResultFormat format;
    @XmlElement(name = "FormatProperties")
    protected PropertySet formatProperties;
    @XmlElement(name = "GeoTransformation")
    protected GeoTransformation geoTransformation;

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link EsriQueryResultFormat }
     *     
     */
    public EsriQueryResultFormat getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriQueryResultFormat }
     *     
     */
    public void setFormat(EsriQueryResultFormat value) {
        this.format = value;
    }

    /**
     * Gets the value of the formatProperties property.
     * 
     * @return
     *     possible object is
     *     {@link PropertySet }
     *     
     */
    public PropertySet getFormatProperties() {
        return formatProperties;
    }

    /**
     * Sets the value of the formatProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertySet }
     *     
     */
    public void setFormatProperties(PropertySet value) {
        this.formatProperties = value;
    }

    /**
     * Gets the value of the geoTransformation property.
     * 
     * @return
     *     possible object is
     *     {@link GeoTransformation }
     *     
     */
    public GeoTransformation getGeoTransformation() {
        return geoTransformation;
    }

    /**
     * Sets the value of the geoTransformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoTransformation }
     *     
     */
    public void setGeoTransformation(GeoTransformation value) {
        this.geoTransformation = value;
    }

}
