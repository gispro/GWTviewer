var mark_red = OpenLayers.Util.extend ({}, OpenLayers.Feature.Vector.style['default']);

mark_red.graphicWidth    = 21;
mark_red.graphicHeight   = 25;
mark_red.graphicOpacity  = 0.9;
// mark_red.cursor          = "pointer";
mark_red.graphicXOffset  = -(mark_red.graphicWidth/2); //  default is -(style_mark.graphicWidth/2);
mark_red.graphicYOffset  = -mark_red.graphicHeight;
mark_red.externalGraphic = "images/marker-red.png";
// graphicTitle only works in Firefox and Internet Explorer
// mark_red.graphicTitle = "this is a test tooltip";

var mark_gold = OpenLayers.Util.extend ({}, OpenLayers.Feature.Vector.style['default']);
mark_gold.graphicWidth    = 21;
mark_gold.graphicHeight   = 25;
mark_gold.graphicOpacity  = 0.9;
// mark_gold.cursor          = "pointer";
mark_gold.graphicXOffset  = -(mark_gold.graphicWidth/2);
mark_gold.graphicYOffset  = -mark_gold.graphicHeight;
mark_gold.externalGraphic = "images/marker-gold.png";

var mark_green = OpenLayers.Util.extend ({}, OpenLayers.Feature.Vector.style['default']);
mark_green.graphicWidth    = 21;
mark_green.graphicHeight   = 25;
mark_green.graphicOpacity  = 0.9;
// mark_green.cursor          = "pointer";
mark_green.graphicXOffset  = -(mark_green.graphicWidth/2);
mark_green.graphicYOffset  = -mark_green.graphicHeight;
mark_green.externalGraphic = "images/marker-green.png";
	
var treats = new OpenLayers.Layer.Vector(
     "VectorTreatments",
     {
    	 styleMap : new OpenLayers.StyleMap({
    		 pointRadius   : "${radius}",
    		 strokeWidth   : 3          ,
    		 strokeOpacity : 0.6        ,
    		 strokeColor   : "#ff0000"  ,
    		 fillColor     : "#00ff00"  ,
    		 fillOpacity   : 0.4
    	 })
     }
);
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function drawTreatment(x, y, count, id)
{
	var point = new OpenLayers.Geometry.Point(x, y);

	var feature = null;
	if (count == 1)
		feature = new OpenLayers.Feature.Vector(point, null, mark_green);
	else if (count <= 4)
		feature = new OpenLayers.Feature.Vector(point, null, mark_gold );
	else
		feature = new OpenLayers.Feature.Vector(point, null, mark_red  );
	
	feature.id = id;
	treats.addFeatures([feature]);
};
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function removeTreatment(id)
{
	var features = treats.getFeatureById (id);
	if (features != null)
		treats.removeFeatures(features); 
};
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function setStyleOpacity (opacity)
{
	mark_red  .graphicOpacity = opacity;	
	mark_gold .graphicOpacity = opacity;
	mark_green.graphicOpacity = opacity;
	if (opacity > 0.2)
	{
		mark_red  .cursor = 'pointer';
		mark_gold .cursor = 'pointer';
		mark_green.cursor = 'pointer';
	}
	else
	{
		mark_red  .cursor = 'default';
		mark_gold .cursor = 'default';
		mark_green.cursor = 'default';
	}
	treats.redraw();
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
