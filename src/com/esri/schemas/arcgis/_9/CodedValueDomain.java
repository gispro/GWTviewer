
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * ESRI Attribute set constraint object.
 * 
 * <p>Java class for CodedValueDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CodedValueDomain">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Domain">
 *       &lt;sequence>
 *         &lt;element name="CodedValues" type="{http://www.esri.com/schemas/ArcGIS/9.3}ArrayOfCodedValue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodedValueDomain", propOrder = {
    "codedValues"
})
@XmlSeeAlso({
    BitMaskCodedValueDomain.class
})
public class CodedValueDomain
    extends Domain
{

    @XmlElement(name = "CodedValues", required = true)
    protected ArrayOfCodedValue codedValues;

    /**
     * Gets the value of the codedValues property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCodedValue }
     *     
     */
    public ArrayOfCodedValue getCodedValues() {
        return codedValues;
    }

    /**
     * Sets the value of the codedValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCodedValue }
     *     
     */
    public void setCodedValues(ArrayOfCodedValue value) {
        this.codedValues = value;
    }

}
