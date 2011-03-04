package ru.mos.gispro.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import ru.mos.gispro.client.json.JSONLayer;

public class Service extends JavaScriptObject {

	// Overlay types always have protected, zero-arg ctors
	protected Service() {
	}

	// Typically, methods on overlay types are JSNI
	public final native String serviceDescription() /*-{ return this.serviceDescription; }-*/;

	public final native String mapName() /*-{ return this.mapName; }-*/;

	public final native String description() /*-{ return this.description; }-*/;

	public final native String copyrightText() /*-{ return this.copyrightText; }-*/;

	public final native JsArray<JSONLayer> layers() /*-{ return this.layers; }-*/;

	public final native String spatialReference() /*-{ return this.spatialReference; }-*/;

	public final native String singleFusedMapCache() /*-{ return this.singleFusedMapCache; }-*/;

	public final native String initialExtent() /*-{ return this.initialExtent; }-*/;

	public final native String fullExtent() /*-{ return this.fullExtent; }-*/;

	public final native String units() /*-{ return this.units; }-*/;

	public final native String supportedImageFormatTypes() /*-{ return this.supportedImageFormatTypes; }-*/;

	public final native String documentInfo() /*-{ return this.documentInfo; }-*/;
}
