
package com.esri.schemas.arcgis._9;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSurfacePatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSurfacePatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SurfacePatch" type="{http://www.esri.com/schemas/ArcGIS/9.3}Geometry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSurfacePatch", propOrder = {
    "surfacePatch"
})
public class ArrayOfSurfacePatch {

    @XmlElement(name = "SurfacePatch")
    protected List<Geometry> surfacePatch;

    /**
     * Gets the value of the surfacePatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surfacePatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSurfacePatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Geometry }
     * 
     * 
     */
    public List<Geometry> getSurfacePatch() {
        if (surfacePatch == null) {
            surfacePatch = new ArrayList<Geometry>();
        }
        return this.surfacePatch;
    }

}
