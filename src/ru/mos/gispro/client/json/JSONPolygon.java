package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONPolygon extends JavaScriptObject
{
	protected JSONPolygon() {}

	public final native boolean                   isPolygons ()                        /*-{ return (this.rings != null);                     }-*/;
	public final native JsArray<JavaScriptObject> polygons   ()                        /*-{ return this.rings;                               }-*/;
	public final native JsArray<JavaScriptObject> coords     (int polygon)             /*-{ return this.rings[polygon];                      }-*/;
	public final native String                    coordx     (int polygon, int coord)  /*-{ return this.rings[polygon][coord][0].toString(); }-*/;
	public final native String                    coordy     (int polygon, int coord)  /*-{ return this.rings[polygon][coord][1].toString(); }-*/;
}
