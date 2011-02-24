
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * XML shim class for fill symbols that don't implement IXMLSerialize.
 * 
 * <p>Java class for XMLBinaryFillSymbol complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XMLBinaryFillSymbol">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}FillSymbol">
 *       &lt;sequence>
 *         &lt;element name="Data" type="{http://www.esri.com/schemas/ArcGIS/9.3}XMLPersistedObject"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLBinaryFillSymbol", propOrder = {
    "data"
})
public class XMLBinaryFillSymbol
    extends FillSymbol
{

    @XmlElement(name = "Data", required = true)
    protected XMLPersistedObject data;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link XMLPersistedObject }
     *     
     */
    public XMLPersistedObject getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLPersistedObject }
     *     
     */
    public void setData(XMLPersistedObject value) {
        this.data = value;
    }

}
