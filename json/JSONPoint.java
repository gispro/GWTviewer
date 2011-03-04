package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * User: dima
 * Date: 30.11.2010
 * Time: 0:25:33
 */
public class JSONPoint extends JavaScriptObject {

	protected JSONPoint() {
	}

	public final native String coordx() /*-{ return this.x; }-*/;
	public final native String coordy() /*-{ return this.y; }-*/;

}
