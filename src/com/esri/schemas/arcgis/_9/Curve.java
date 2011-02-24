
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Curve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Curve">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Geometry">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Curve")
@XmlSeeAlso({
    Path.class,
    Segment.class,
    Polycurve.class
})
public abstract class Curve
    extends Geometry
{


}
