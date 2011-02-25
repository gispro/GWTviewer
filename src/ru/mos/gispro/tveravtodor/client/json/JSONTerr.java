package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class JSONTerr extends JavaScriptObject {
	protected JSONTerr() {
	}

	public final native String name() /*-{ return this.name; }-*/;
	public final native String[] subterrs() /*-{ return this.subterrs; }-*/;
	public final native String subterr(int i) /*-{ return this.subterrs[i]; }-*/;
	
}
