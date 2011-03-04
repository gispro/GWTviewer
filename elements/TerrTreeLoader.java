package ru.mos.gispro.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import ru.mos.gispro.client.json.JSONTerrs;

public class TerrTreeLoader {

	JSONTerrs terrTree;

	protected native JavaScriptObject loadConfig() /*-{
		return $wnd.terrsConfig;
	}-*/;

	public TerrTreeLoader() {
		terrTree = loadConfig().cast();
	}

	public JSONTerrs getTerrTree() {
		return terrTree;
	}


}
