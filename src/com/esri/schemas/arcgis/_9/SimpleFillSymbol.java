
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A fill symbol comprised from a predefined set of styles.
 * 
 * <p>Java class for SimpleFillSymbol complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimpleFillSymbol">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}FillSymbol">
 *       &lt;sequence>
 *         &lt;element name="Style" type="{http://www.esri.com/schemas/ArcGIS/9.3}esriSimpleFillStyle"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleFillSymbol", propOrder = {
    "style"
})
public class SimpleFillSymbol
    extends FillSymbol
{

    @XmlElement(name = "Style", required = true)
    protected EsriSimpleFillStyle style;

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link EsriSimpleFillStyle }
     *     
     */
    public EsriSimpleFillStyle getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsriSimpleFillStyle }
     *     
     */
    public void setStyle(EsriSimpleFillStyle value) {
        this.style = value;
    }

}
