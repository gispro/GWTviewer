package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONLegends extends JavaScriptObject
{
	// Overlay types always have protected, zero-arg ctors
	protected JSONLegends() {}

	public final native JsArray <JavaScriptObject> layers   ()       /*-{ return this.layers;       }-*/;
	public final native JavaScriptObject           layer    (int i)  /*-{ return this.layers[i];    }-*/;
	public final native int                        layerId  ()       /*-{ return this.layerId;      }-*/;
	public final native String                     layerName()       /*-{ return this.layerName;    }-*/;
	public final native JsArray <JavaScriptObject> legends  ()       /*-{ return this.legend;       }-*/;
}
