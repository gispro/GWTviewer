package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONFind extends JavaScriptObject {
	protected JSONFind() {
	}

	public final native JsArray<JSONFindItem> results() /*-{ return this.results; }-*/;
}
