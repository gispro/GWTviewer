
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An ordered collection of points; optionally has measure, height and ID attributes.
 * 
 * <p>Java class for MultipointB complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultipointB">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Multipoint">
 *       &lt;sequence>
 *         &lt;element name="Bytes" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultipointB", propOrder = {
    "bytes"
})
public class MultipointB
    extends Multipoint
{

    @XmlElement(name = "Bytes", required = true)
    protected byte[] bytes;

    /**
     * Gets the value of the bytes property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBytes() {
        return bytes;
    }

    /**
     * Sets the value of the bytes property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBytes(byte[] value) {
        this.bytes = ((byte[]) value);
    }

}
