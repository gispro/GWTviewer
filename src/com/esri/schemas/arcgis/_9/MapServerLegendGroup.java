
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Map Server Legend Group object provides information about a legend group.
 * 
 * <p>Java class for MapServerLegendGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapServerLegendGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Heading" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LegendClasses" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfMapServerLegendClass" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MapServerLegendGroup", propOrder = {
    "heading",
    "legendClasses"
})
public class MapServerLegendGroup {

    @XmlElement(name = "Heading", required = true)
    protected String heading;
    @XmlElement(name = "LegendClasses")
    protected ArrayOfMapServerLegendClass legendClasses;

    /**
     * Gets the value of the heading property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeading() {
        return heading;
    }

    /**
     * Sets the value of the heading property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeading(String value) {
        this.heading = value;
    }

    /**
     * Gets the value of the legendClasses property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMapServerLegendClass }
     *     
     */
    public ArrayOfMapServerLegendClass getLegendClasses() {
        return legendClasses;
    }

    /**
     * Sets the value of the legendClasses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMapServerLegendClass }
     *     
     */
    public void setLegendClasses(ArrayOfMapServerLegendClass value) {
        this.legendClasses = value;
    }

}
