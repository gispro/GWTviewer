package ru.mos.gispro.client.layer;

import com.google.gwt.core.client.JavaScriptObject;

public class BingMaps implements MapService
{
	private  JavaScriptObject  layer;
	private  MapTypeId         mapTypeId;
	private  boolean           isServiceVisible;
	private  String            name;

	public enum MapTypeId
    {
		Road, Aerial, Hybrid
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public BingMaps(String name, MapTypeId mapTypeId)
    {
		this.mapTypeId = mapTypeId;
		this.name = name;
		isServiceVisible = false;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private native void setVisibility(JavaScriptObject layer, boolean isLayoutVisible)
    /*-{
        layer.setVisibility(isLayoutVisible);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private native JavaScriptObject addBingMapSatellite(String name, String mapTypeId)
    /*-{
        var layer = new $wnd.OpenLayers.Layer.VirtualEarth(name, {
                                                            type: eval("$wnd.VEMapStyle." + mapTypeId),
                                                            sphericalMercator:true,
                                                            minZoomLevel: 4,
                                                            maxZoomLevel: 17,
                                                            maxResolution: $wnd.maxResolution,
                                                            visibility: true
                                                            }
        );
        $wnd.map.addLayer(layer);
        return layer;
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void visibility(boolean isServiceVisible)
    {
		if (layer == null)
			layer = addBingMapSatellite(name, mapTypeId.toString());
		if (layer != null)
			setVisibility(layer, isServiceVisible);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void layerVisibility(String id, boolean isLayerVisible) {}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void invalidate() { }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public JavaScriptObject getLayer()
    {
		return layer;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void setLayer(JavaScriptObject layer)
    {
		this.layer = layer;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
