
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Cache control info object.
 * 
 * <p>Java class for CacheControlInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CacheControlInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClientCachingAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CacheControlInfo", propOrder = {
    "clientCachingAllowed"
})
public class CacheControlInfo {

    @XmlElement(name = "ClientCachingAllowed")
    protected boolean clientCachingAllowed;

    /**
     * Gets the value of the clientCachingAllowed property.
     * 
     */
    public boolean isClientCachingAllowed() {
        return clientCachingAllowed;
    }

    /**
     * Sets the value of the clientCachingAllowed property.
     * 
     */
    public void setClientCachingAllowed(boolean value) {
        this.clientCachingAllowed = value;
    }

}
