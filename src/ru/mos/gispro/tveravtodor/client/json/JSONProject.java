package ru.mos.gispro.tveravtodor.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONProject extends JavaScriptObject
{
	protected JSONProject() { }

    public final native String getConfigFile () /*-{ return this.configFile; }-*/;
}
