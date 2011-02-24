
package com.esri.schemas.arcgis._9;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Graphic Element Obejct.
 * 
 * <p>Java class for GraphicElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GraphicElement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.esri.com/schemas/ArcGIS/9.3}Element">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GraphicElement")
@XmlSeeAlso({
    MarkerElement.class,
    LineElement.class,
    EllipseElement.class,
    ParagraphTextElement.class,
    TextElement.class,
    PolygonElement.class,
    CircleElement.class,
    RectangleElement.class
})
public abstract class GraphicElement
    extends Element
{


}
