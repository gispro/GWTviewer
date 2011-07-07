package ru.mos.gispro.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import ru.mos.gispro.client.JSONRequestHandler;
import ru.mos.gispro.client.geometry.GeometryManager;
import ru.mos.gispro.client.geometry.GeometryManager1;
import ru.mos.gispro.client.json.JSONFind;
import ru.mos.gispro.client.json.JSONFindItem;

public class TerrTreePickTree extends IPickTreeItem {

	public static final String FIRST_LEVEL = "FIRST_LEVEL";
	public static final String SECOND_LEVEL = "SECOND_LEVEL";

	public TerrTreePickTree()
	{
		this.setCanSelectParentItems(true);
                      // Территория
		this.setTitle("\u0422\u0435\u0440\u0440\u0438\u0442\u043E\u0440\u0438\u044F");
//        this.setEmptyMenuMessage("Выберите территорию");
                                 // Выберите муниц. образование;
		this.setEmptyMenuMessage("\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435\u0020\u043C\u0443\u043D\u0438\u0446\u002E\u0020\u043E\u0431\u0440\u0430\u0437\u043E\u0432\u0430\u043D\u0438\u0435");
		this.setName("TerrTreePickTree"); //Выберите муниц.образование");
                                  // Нет данных
		this.setEmptyMenuMessage("\u041D\u0435\u0442\u0020\u0434\u0430\u043D\u043D\u044B\u0445");
                                  // Выберите муниц. образование
		this.setEmptyDisplayValue("\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435\u0020\u043C\u0443\u043D\u0438\u0446\u002E\u0020\u043E\u0431\u0440\u0430\u0437\u043E\u0432\u0430\u043D\u0438\u0435");
		                     // Выберите муниц. образование");
		this.setDefaultValue("\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435\u0020\u043C\u0443\u043D\u0438\u0446\u002E\u0020\u043E\u0431\u0440\u0430\u0437\u043E\u0432\u0430\u043D\u0438\u0435"); 
		this.setHeight(35);
		this.addChangedHandler(new com.smartgwt.client.widgets.form.fields.events.ChangedHandler()
		{
			int activeRequest = 0;
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			class JSONRequest
			{
				public void get(String url, JSONRequestHandler handler)
				{
					String callbackName = "JSONCallback" + handler.hashCode();
					get(url + "&callback=" + callbackName, callbackName, handler);
				}

				public void get(String url, String callbackName, JSONRequestHandler handler)
				{
					createCallbackFunction(handler, callbackName);
					addScript(url);
				}

				public native void addScript(String url)
				/*-{
	                   var scr = document.createElement("script");
                       scr.setAttribute("language", "JavaScript");
                       scr.setAttribute("src", url);
                       document.getElementsByTagName("head")[0].appendChild(scr);
                }-*/;

				private native void createCallbackFunction(JSONRequestHandler obj, String callbackName)
				/*-{
	                   tmpcallback = function(j)
	                   {
	                      obj.@ru.mos.gispro.client.JSONRequestHandler::onRequestComplete(Lcom/google/gwt/core/client/JavaScriptObject;)(j);
	                   };
	                   eval( "window." + callbackName + "=tmpcallback" );
                }-*/;
			}
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			public void findTask(String where, String what)
			{
				String url = "";
				if (SECOND_LEVEL.equals(where)) {
					url = "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/adm_mosobl/MapServer/find?layers=1&f=json&searchFields=RAY_NAME_1&";
				}
				if (FIRST_LEVEL.equals(where)) {
					what = what.replace(" го", "");
					what = what.replace(" ЗАТО", "");
					url = "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/adm_mosobl/MapServer/find?layers=0&f=json&searchFields=caption&";
				}
				url += "searchText=" + what + "&contains=true&sr=102113&returnGeometry=true";
// com.google.gwt.user.client.Window.alert("findTask : where = " + where + ", what = " + what + " \n " + url);
				class FindRequestHandler implements JSONRequestHandler
				{
					public int request;

					public void onRequestComplete(JavaScriptObject json)
					{
						if (activeRequest > request) return;

						JSONFind find = json.cast();
						int resCount = find.results().length();

						if (resCount == 0)
						{
							com.google.gwt.user.client.Window.alert("Ничего не найдено");
							return;
						}
						JSONFindItem item = find.results().get(0);
						GeometryManager1.clearGeometry();
						GeometryManager1.draw(item.geometry(), true, true);
					}
				}

				FindRequestHandler findRequestHandler = new FindRequestHandler();
				findRequestHandler.request = activeRequest;
				new JSONRequest().get(url, findRequestHandler);
			}
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			public void onChanged(ChangedEvent changedEvent)
			{
				String s = changedEvent.getValue().toString();
				String[] t = s.split("/");

				GeometryManager.clearGeometry();
				if (t.length == 2)
				{
					String req = t[t.length-1];
					findTask(FIRST_LEVEL, req);
				}
				if (t.length == 3)
				{
					String req = t[t.length-1];
					findTask(SECOND_LEVEL, req);
				}

			}
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		});
	}
}
