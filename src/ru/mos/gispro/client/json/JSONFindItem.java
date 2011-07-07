package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class JSONFindItem extends JavaScriptObject
{
	protected JSONFindItem() {}

	public final native int               layerId()                    /*-{ return this.layerId; }-*/;
	public final native String            layerName()                  /*-{ return this.layerName; }-*/;
	public final native String            value()                      /*-{ return this.value; }-*/;
	public final native JavaScriptObject  geometry()                   /*-{ return this.geometry; }-*/;
	public final native JavaScriptObject  rings()                      /*-{ return this.geometry.rings; }-*/;
	public final native JavaScriptObject  attributes()                 /*-{ return this.attributes;}-*/;
	public final native String            attributesByKey(String key)  /*-{ return this.attributes[key].toString();}-*/;
    public final native JavaScriptObject  polygon()                    /*-{ return this.geometry.rings[0]; }-*/;

	public final native JsArrayString attributesKeys()
    /*-{
    	var keys = [];
    	for (var key in this.attributes)
    	{
    		keys.push(key)
    	}
    	return keys;
    }-*/;
}
