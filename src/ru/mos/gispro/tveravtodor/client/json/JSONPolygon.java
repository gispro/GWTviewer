package ru.mos.gispro.tveravtodor.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class JSONPolygon extends JavaScriptObject {

	protected JSONPolygon() {
	}

	public final native JavaScriptObject[] polygons() /*-{ return this.rings; }-*/;

	public final native JavaScriptObject polygon(int i) /*-{ return this.rings[i]; }-*/;

	public final native JavaScriptObject[] coords(int polygon) /*-{ return this.rings[polygon]; }-*/;

	public final native String coordx(int polygon, int coord) /*-{ return this.rings[polygon][coord][0].toString(); }-*/;

	public final native String coordy(int polygon, int coord) /*-{ return this.rings[polygon][coord][1].toString(); }-*/;

}
