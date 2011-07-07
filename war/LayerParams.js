var layerParams =
{
	"strokeWidth": 5,
	"strokeColor": "#47FFFF",
	"strokeOpacity" : 0.6,
	"fillColor" : "#9dfdfd",
	"fillOpacity" : 0.4,

	"strokeWidth1": 5,
	"strokeColor1": "#47FFFF",
	"strokeOpacity1" : 0.6,
	"fillColor1" : "#9dfdfd",
	"fillOpacity1" : 0.0
};
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function clearGeometry()
{
	vectors.removeAllFeatures();
	vectors1.removeAllFeatures();
};
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function drawGeometry(geoJsonString, zoom, move)
{
	var features = geojson.read(geoJsonString);
	var bounds;
	if(features)
	{
		if(features.constructor != Array)
		{
			features = [features];
		}
		for(var i=0; i<features.length; ++i)
		{
			if (!bounds)
				bounds = features[i].geometry.getBounds();
			else
				bounds.extend(features[i].geometry.getBounds());
		}
		vectors.addFeatures(features);
		if (move)
		{
			if (zoom)
				map.zoomToExtent(bounds);
			else
				map.panTo(bounds.getCenterLonLat());
		}
	}
};
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function drawGeometry1(geoJsonString, zoom, move)
{
	var features = geojson.read(geoJsonString);
	var bounds;
	if(features)
	{
		if(features.constructor != Array)
		{
			features = [features];
		}
		for(var i=0; i<features.length; ++i)
		{
			if (!bounds)
				bounds = features[i].geometry.getBounds();
			else
				bounds.extend(features[i].geometry.getBounds());
		}
		vectors1.addFeatures(features);
		if (move)
		{
			if (zoom)
				map.zoomToExtent(bounds);
			else
				map.panTo(bounds.getCenterLonLat());
		}
	}
};
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function drawPoint(x, y, zoom, move)
{
	var feature = new OpenLayers.Feature.Vector
	(
		new OpenLayers.Geometry.Point(x, y),
		{
			type: 10
		}
	);

	vectors.addFeatures(feature);
	
	var bounds = feature.geometry.getBounds();
//	for(var i=0; i<feature.length; ++i)
	//{
//		if (!bounds)
//			bounds = feature.geometry.getBounds();
//		else
//			bounds.extend(feature.geometry.getBounds());
//	}

	if (move)
	{
		if (zoom)
			map.zoomToExtent(bounds);
		else
			map.panTo(bounds.getCenterLonLat());
	}
};
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function drawPoint1(x, y, zoom, move)
{
	var feature = new OpenLayers.Feature.Vector
	(
		new OpenLayers.Geometry.Point(x, y),
		{
			type: 10
		}
	);

	vectors1.addFeatures(feature);
	
	var bounds = feature.geometry.getBounds();

	if (move)
	{
		if (zoom)
			map.zoomToExtent(bounds);
		else
			map.panTo(bounds.getCenterLonLat());
	}
};
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
