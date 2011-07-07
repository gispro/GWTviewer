package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class JSONPoint extends JavaScriptObject
{
	protected JSONPoint() {}

	public final native boolean isPoint()  /*-{ return ((this.x != null) && (this.y != null)); }-*/;
	public final native double  coordx ()  /*-{ return this.x;                                 }-*/;
	public final native double  coordy ()  /*-{ return this.y;                                 }-*/;
}
