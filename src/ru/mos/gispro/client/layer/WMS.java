package ru.mos.gispro.client.layer;

import com.google.gwt.core.client.JavaScriptObject;

public class WMS implements MapService {

	private  String            name;
	private  String            url;
	private  String            layers;
	private  String            projection;
	private  JavaScriptObject  layer;
    private  float             layerOpacity = 1;

	public WMS(String name, String url, String layers, String projection) {
		this.name = name;
		this.url = url;
		this.layers = layers;
		this.projection = projection;
	}

	public String Url() {
		return url;
	}

	public void visibility(boolean isServiceVisible) {
		if (layer == null)
			layer = AddWMS(name, url, layers, "EPSG:900913");
		if (layer != null)
			setVisibility(layer, isServiceVisible);
	}

	public void layerVisibility(String id, boolean isLayerVisible) {
	}

	public void invalidate() {
	}

	private native void setVisibility(JavaScriptObject layer,
	                                  boolean isLayoutVisible) /*-{
		layer.setVisibility(isLayoutVisible);
	}-*/;

	public native JavaScriptObject AddWMS(String name, String address,
	                                      String layers, String projection) /*-{
		var layer = new $wnd.OpenLayers.Layer.WMS(
		        name, address,
		{
		    layers: layers,
		    srs: new $wnd.OpenLayers.Projection(projection),
		    format: 'image/png',
		    tiled: 'true',
		    transparent: "true"
		},
		{
		    singleTile: "true",
		    ratio: 1,
		    buffer: 0,
		    displayOutsideMaxExtent: "true"
		}
		);
		$wnd.map.addLayer(layer);
		return layer;
	}-*/;

	public JavaScriptObject getLayer() {
		return layer;
	}

	public void setLayer(JavaScriptObject layer) {
		this.layer = layer;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public float getLayerOpacity()
    {
        return layerOpacity;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setLayerOpacity (float layerOpacity)
    {
        this.layerOpacity = layerOpacity;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
