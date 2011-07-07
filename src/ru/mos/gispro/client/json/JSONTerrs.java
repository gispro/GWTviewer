package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONTerrs extends JavaScriptObject
{
	protected JSONTerrs() {}

	@SuppressWarnings("unchecked")
	public final native JsArray terrs() /*-{ return this.terrs; }-*/;

}
