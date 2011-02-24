package ru.mos.gispro.tveravtodor.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class JSONPolyLine extends JavaScriptObject {

	protected JSONPolyLine() {
	}

	public final native JavaScriptObject[] polylines() /*-{ return this.paths; }-*/;

	public final native JavaScriptObject[] coords(int polyline) /*-{ return this.paths[polyline] }-*/;

	public final native String coordx(int polyline, int coord) /*-{ return this.paths[polyline][coord][0].toString(); }-*/;

	public final native String coordy(int polyline, int coord) /*-{ return this.paths[polyline][coord][1].toString(); }-*/;

}
