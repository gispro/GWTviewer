package ru.mos.gispro.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import ru.mos.gispro.client.json.JSONProject;

public class ProjectLoader
{
	JSONProject project;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	protected native JavaScriptObject loadConfig()
	/*-{
		return $wnd.projectJSON;
	}-*/;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public ProjectLoader()
	{
		project = loadConfig().cast();
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public JSONProject getConfig()
	{
		return project;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
