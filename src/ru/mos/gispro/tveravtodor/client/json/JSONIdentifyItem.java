package ru.mos.gispro.tveravtodor.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

public class JSONIdentifyItem extends JavaScriptObject {

	protected JSONIdentifyItem() {
	}

	public final native int layerId() /*-{ return this.layerId; }-*/;

	public final native String layerName() /*-{ return this.layerName; }-*/;

	public final native JavaScriptObject attributes() /*-{ return this.attributes;}-*/;

	public final native JavaScriptObject geometry() /*-{ return this.geometry; }-*/;

	public final native String attributesByKey(String key) /*-{ return this.attributes[key].toString();}-*/;

	public final native JsArrayString attributesKeys() /*-{
    	var keys = [];
    	for (var key in this.attributes)
    	{
    		keys.push(key)
    	}
    	return keys;
    }-*/;
}
