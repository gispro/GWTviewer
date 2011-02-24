
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A LOD Info object.
 * 
 * <p>Java class for LODInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LODInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LevelID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Scale" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Resolution" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LODInfo", propOrder = {
    "levelID",
    "scale",
    "resolution"
})
public class LODInfo {

    @XmlElement(name = "LevelID")
    protected int levelID;
    @XmlElement(name = "Scale")
    protected double scale;
    @XmlElement(name = "Resolution")
    protected double resolution;

    /**
     * Gets the value of the levelID property.
     * 
     */
    public int getLevelID() {
        return levelID;
    }

    /**
     * Sets the value of the levelID property.
     * 
     */
    public void setLevelID(int value) {
        this.levelID = value;
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
     * Gets the value of the resolution property.
     * 
     */
    public double getResolution() {
        return resolution;
    }

    /**
     * Sets the value of the resolution property.
     * 
     */
    public void setResolution(double value) {
        this.resolution = value;
    }

}
