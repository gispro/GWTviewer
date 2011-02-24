package ru.mos.gispro.tveravtodor.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;

public class JSONLayer extends JavaScriptObject {

	// Overlay types always have protected, zero-arg ctors
	protected JSONLayer() {
	}

	// Typically, methods on overlay types are JSNI
	public final native int id() /*-{ return this.id; }-*/;

	public final native String name() /*-{ return this.name; }-*/;

	public final native int parentLayerId() /*-{ return this.parentLayerId; }-*/;

	public final native boolean defaultVisibility() /*-{ return this.defaultVisibility; }-*/;

	public final native JsArrayInteger subLayerIds() /*-{ return this.subLayerIds; }-*/;
}
