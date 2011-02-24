package ru.mos.gispro.tveravtodor.client.layer;

import com.google.gwt.core.client.JavaScriptObject;

public class OSM implements MapService {

	private JavaScriptObject layer;
	private boolean isServiceVisible;
	private String name;

	public OSM(String name) {
		this.name = name;
		isServiceVisible = false;
	}

	public void visibility(boolean isServiceVisible) {
		if (layer == null)
			layer = addOSM(name);
		if (layer != null)
			setVisibility(layer, isServiceVisible);
	}

	public void layerVisibility(String id, boolean isLayerVisible) {
	}

	public void invalidate() {
	}

	private native JavaScriptObject addOSM(String name) /*-{
		$wnd.alert("1");
		var layer = new $wnd.OpenLayers.Layer.OSM.Mapnik(name, {sphericalMercator:true});
		$wnd.alert("2");
		layer.projection = new $wnd.OpenLayers.Projection("EPSG:4326");
		$wnd.alert("2.5");
		$wnd.map.addLayer(layer);
		$wnd.alert("3");
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
