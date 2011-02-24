package ru.mos.gispro.tveravtodor.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONIdentify extends JavaScriptObject {
	protected JSONIdentify() {
	}

	public final native JsArray<JSONIdentifyItem> results() /*-{ return this.results; }-*/;
}
