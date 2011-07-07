package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONPolyLine extends JavaScriptObject
{
	protected JSONPolyLine() {}

	public final native boolean                   isPolylines    ()                        /*-{ return (this.paths != null);                      }-*/;
	public final native JsArray<JavaScriptObject> polylinesItems ()                        /*-{ return this.paths;                                }-*/;
	public final native double                    x              (int polyline, int coord) /*-{ return this.paths[polyline][coord][0];            }-*/;
	public final native double                    y              (int polyline, int coord) /*-{ return this.paths[polyline][coord][1];            }-*/;
	public final native String                    coordx         (int polyline, int coord) /*-{ return this.paths[polyline][coord][0].toString(); }-*/;
	public final native String                    coordy         (int polyline, int coord) /*-{ return this.paths[polyline][coord][1].toString(); }-*/;
}
