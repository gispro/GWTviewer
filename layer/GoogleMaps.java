package ru.mos.gispro.client.layer;

import com.google.gwt.core.client.JavaScriptObject;

public class GoogleMaps implements MapService {

	private JavaScriptObject layer;
	private MapTypeId mapTypeId;
	private boolean isServiceVisible;
	private String name;

	public enum MapTypeId {
		HYBRID, ROADMAP, SATELLITE, TERRAIN
	}

	public GoogleMaps(String name, MapTypeId mapTypeId) {
		this.mapTypeId = mapTypeId;
		this.name = name;
		isServiceVisible = false;
	}

	public void visibility(boolean isServiceVisible) {
		if (layer == null)
			layer = addGoogleSatellite(name, mapTypeId.toString());
		if (layer != null)
			setVisibility(layer, isServiceVisible);
	}

	public void layerVisibility(String id, boolean isLayerVisible) {
	}

	public void invalidate() {
	}

	private native JavaScriptObject addGoogleSatellite(String name,
	                                                   String mapTypeId) /*-{
		var layer = new $wnd.OpenLayers.Layer.Google(name,
		    {
		        type: eval("$wnd.google.maps.MapTypeId." + mapTypeId),
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

	private native void setVisibility(JavaScriptObject layer,
	                                  boolean isLayoutVisible) /*-{
		layer.setVisibility(isLayoutVisible);
	}-*/;

	public JavaScriptObject getLayer() {
		return layer;
	}

	public void setLayer(JavaScriptObject layer) {
		this.layer = layer;
	}
}
