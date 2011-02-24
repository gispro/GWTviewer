
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A line symbol comprised of a predefined set of styles.
 * 
 * <p>Java class for SimpleLineSymbol complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimpleLineSymbol">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}LineSymbol">
 *       &lt;sequence>
 *         &lt;element name="Style" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriSimpleLineStyle"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleLineSymbol", propOrder = {
    "style"
})
public class SimpleLineSymbol
    extends LineSymbol
{

    @XmlElement(name = "Style", required = true)
    protected EsriSimpleLineStyle style;

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link EsriSimpleLineStyle }
     *     
     */
    public EsriSimpleLineStyle getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriSimpleLineStyle }
     *     
     */
    public void setStyle(EsriSimpleLineStyle value) {
        this.style = value;
    }

}
