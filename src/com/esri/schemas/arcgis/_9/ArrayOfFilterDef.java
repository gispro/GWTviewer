
package com.esri.schemas.arcgis._9;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An array of filter definition objects.
 * 
 * <p>Java class for ArrayOfFilterDef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFilterDef">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FilterDef" type="{http://www.esri.com/schemas/ArcGIS/9.3}FilterDef" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFilterDef", propOrder = {
    "filterDef"
})
public class ArrayOfFilterDef {

    @XmlElement(name = "FilterDef")
    protected List<FilterDef> filterDef;

    /**
     * Gets the value of the filterDef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filterDef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilterDef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FilterDef }
     * 
     * 
     */
    public List<FilterDef> getFilterDef() {
        if (filterDef == null) {
            filterDef = new ArrayList<FilterDef>();
        }
        return this.filterDef;
    }

}
