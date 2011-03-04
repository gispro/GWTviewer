package ru.mos.gispro.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import ru.mos.gispro.client.json.JSONConfig;

public class ConfigLoader
{
	JSONConfig   jsonConfig;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	protected native JavaScriptObject loadMosRegionConfig() /*-{
		return $wnd.configMosRegion;
	}-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    protected native JavaScriptObject loadTverAvtoDorConfig() /*-{
        return $wnd.configTverAvtoDor;
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    protected native JavaScriptObject loadMosAvtoDorConfig() /*-{
        return $wnd.configMosAvtoDor;
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public ConfigLoader(String project)
    {
        if (project.equalsIgnoreCase("MosRegion"))
            jsonConfig = loadMosRegionConfig().cast();
        else if (project.equalsIgnoreCase("TverAvtoDor"))
            jsonConfig = loadTverAvtoDorConfig().cast();
        else if (project.equalsIgnoreCase("MosAvtoDor"))
            jsonConfig = loadMosAvtoDorConfig().cast();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public JSONConfig getConfig()
    {
		return jsonConfig;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
