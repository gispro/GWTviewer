package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class JSONHintConfig extends JavaScriptObject
{
	protected JSONHintConfig() {}

	public final native String  identifier  () /*-{ return this.identifier; }-*/;
	public final native String  html        () /*-{ return this.html;       }-*/;
    public final native boolean isTitle     () /*-{ return this.isTitle;    }-*/;
    public final native int     layerNumber () /*-{ return this.layerN;     }-*/;
}
