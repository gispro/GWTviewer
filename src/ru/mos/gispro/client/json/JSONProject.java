package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class JSONProject extends JavaScriptObject
{
	protected JSONProject() { }

    public final native String getConfigFile () /*-{ return this.configFile; }-*/;
}
