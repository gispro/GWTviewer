package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class JSONLegendsIcon extends JavaScriptObject
{
	protected JSONLegendsIcon() {}

	public final native String  label ()  /*-{ return this.label; }-*/;
	public final native String  icon  ()  /*-{ return this.url;   }-*/;
}
