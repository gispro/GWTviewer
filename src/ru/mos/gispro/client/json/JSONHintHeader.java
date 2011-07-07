package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONHintHeader extends JavaScriptObject
{
	protected JSONHintHeader() {}

    public final native int                        hintDelay       () /*-{ return this.hintDelay;   }-*/;
    public final native int                        hintWidth       () /*-{ return this.hintWidth;   }-*/;
    public final native int                        hintHeight      () /*-{ return this.hintHeight;  }-*/;
    public final native String                     hintColor       () /*-{ return this.hintColor;   }-*/;
    public final native int                        infoHeight      () /*-{ return this.infoHeight;  }-*/;
    public final native int                        infoWidth       () /*-{ return this.infoWidth;   }-*/;
	public final native JsArray <JavaScriptObject> hintDesc        () /*-{ return this.hintDesc;    }-*/;
    public final native JavaScriptObject           hintItem   (int i) /*-{ return this.hintDesc[i]; }-*/;
}
