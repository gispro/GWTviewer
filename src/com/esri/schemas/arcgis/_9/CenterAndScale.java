
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Center And Scale object allows you to change the spatial extent of a map by specifying the center and scale.
 * 
 * <p>Java class for CenterAndScale complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CenterAndScale">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}MapArea">
 *       &lt;sequence>
 *         &lt;element name="Center" type="{http://www.esri.com/schemas/ArcGIS/9.3}Point" minOccurs="0"/>
 *         &lt;element name="Scale" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="DPI" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DevBottom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DevLeft" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DevTop" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DevRight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CenterAndScale", propOrder = {
    "center",
    "scale",
    "dpi",
    "devBottom",
    "devLeft",
    "devTop",
    "devRight"
})
public class CenterAndScale
    extends MapArea
{

    @XmlElement(name = "Center")
    protected Point center;
    @XmlElement(name = "Scale")
    protected double scale;
    @XmlElement(name = "DPI")
    protected Double dpi;
    @XmlElement(name = "DevBottom")
    protected Integer devBottom;
    @XmlElement(name = "DevLeft")
    protected Integer devLeft;
    @XmlElement(name = "DevTop")
    protected Integer devTop;
    @XmlElement(name = "DevRight")
    protected Integer devRight;

    /**
     * Gets the value of the center property.
     * 
     * @return
     *     possible object is
     *     {@link Point }
     *     
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Sets the value of the center property.
     * 
     * @param value
     *     allowed object is
     *     {@link Point }
     *     
     */
    public void setCenter(Point value) {
        this.center = value;
    }

    /**
     * Gets the value of the scale property.
     * 
     */
    public double getScale() {
        return scale;
    }

    /**
     * Sets the value of the scale property.
     * 
     */
    public void setScale(double value) {
        this.scale = value;
    }

    /**
     * Gets the value of the dpi property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDPI() {
        return dpi;
    }

    /**
     * Sets the value of the dpi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDPI(Double value) {
        this.dpi = value;
    }

    /**
     * Gets the value of the devBottom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDevBottom() {
        return devBottom;
    }

    /**
     * Sets the value of the devBottom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDevBottom(Integer value) {
        this.devBottom = value;
    }

    /**
     * Gets the value of the devLeft property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDevLeft() {
        return devLeft;
    }

    /**
     * Sets the value of the devLeft property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDevLeft(Integer value) {
        this.devLeft = value;
    }

    /**
     * Gets the value of the devTop property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDevTop() {
        return devTop;
    }

    /**
     * Sets the value of the devTop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDevTop(Integer value) {
        this.devTop = value;
    }

    /**
     * Gets the value of the devRight property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDevRight() {
        return devRight;
    }

    /**
     * Sets the value of the devRight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDevRight(Integer value) {
        this.devRight = value;
    }

}
