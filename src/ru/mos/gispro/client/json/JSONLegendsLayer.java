package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONLegendsLayer extends JavaScriptObject
{
	protected JSONLegendsLayer() {}

	public final native int                        layerId  ()  /*-{ return this.layerId;   }-*/;
	public final native String                     layerName()  /*-{ return this.layerName; }-*/;
	public final native JsArray <JavaScriptObject> legends  ()  /*-{ return this.legend;    }-*/;
}
