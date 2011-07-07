package ru.mos.gispro.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Custom extends JavaScriptObject {

	// Overlay types always have protected, zero-arg ctors
	protected Custom() {
	}

	// Typically, methods on overlay types are JSNI
	public final native String serviceDescription() /*-{ return this.serviceDescription; }-*/;
}
