package ru.mos.gispro.tveravtodor.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import ru.mos.gispro.tveravtodor.client.json.JSONProject;

public class LayersParamsLoader {

	JSONProject project;

	protected native JavaScriptObject loadConfig() /*-{
		return $wnd.projectJSON;
	}-*/;

	public LayersParamsLoader() {
		project = loadConfig().cast();
	}

	public JSONProject getConfig() {
		return project;
	}
}
