package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class JSONLayerConfig extends JavaScriptObject{

	protected JSONLayerConfig() {}

	public final native String name          () /*-{ return this.name;           }-*/;
	public final native String type          () /*-{ return this.type;           }-*/;
	public final native String serviceUrl    () /*-{ return this.serviceUrl;     }-*/;
	public final native String infoServiceUrl() /*-{ return this.infoServiceUrl; }-*/;
	public final native String serviceName   () /*-{ return this.serviceName;    }-*/;
    public final native boolean selected     () /*-{ return this.selected;       }-*/;
	public final native boolean withHint     () /*-{ return this.hint;           }-*/;
}
