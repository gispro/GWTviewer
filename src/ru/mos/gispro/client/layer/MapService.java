package ru.mos.gispro.client.layer;

import com.google.gwt.core.client.JavaScriptObject;

public interface MapService
{
	public   void              visibility       (boolean isServiceVisible);
	public   void              layerVisibility  (String id, boolean isLayerVisible);
	public   void              invalidate       ();
	public   JavaScriptObject  getLayer         ();
    public   float             getLayerOpacity  ();
    public   void              setLayerOpacity  (float layerOpacity);
    public   boolean           isServiceWithHint();
}
