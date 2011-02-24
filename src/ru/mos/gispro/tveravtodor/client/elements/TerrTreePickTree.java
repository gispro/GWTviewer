package ru.mos.gispro.tveravtodor.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import ru.mos.gispro.tveravtodor.client.JSONRequestHandler;
import ru.mos.gispro.tveravtodor.client.geometry.GeometryManager;
import ru.mos.gispro.tveravtodor.client.geometry.GeometryManager1;
import ru.mos.gispro.tveravtodor.client.json.JSONFind;
import ru.mos.gispro.tveravtodor.client.json.JSONFindItem;

public class TerrTreePickTree extends IPickTreeItem {

	public static final String FIRST_LEVEL = "FIRST_LEVEL";
	public static final String SECOND_LEVEL = "SECOND_LEVEL";

	public TerrTreePickTree() {

		this.setCanSelectParentItems(true);
		this.setTitle("Территория");
//        this.setEmptyMenuMessage("Выберите территорию");
		this.setEmptyMenuMessage("Выберите муниц. образование");
		this.setName("Выберите муниц.образование");
		this.setEmptyMenuMessage("Нет данных");
		this.setEmptyDisplayValue("Выберите муниц. образование");
		this.setDefaultValue("Выберите муниц. образование");
		this.setHeight(35);
		this.addChangedHandler(new com.smartgwt.client.widgets.form.fields.events.ChangedHandler() {


			class JSONRequest {

				public void get(String url, JSONRequestHandler handler) {
					String callbackName = "JSONCallback" + handler.hashCode();
					get(url + "&callback=" + callbackName, callbackName, handler);
				}

				public void get(String url, String callbackName, JSONRequestHandler handler) {
					createCallbackFunction(handler, callbackName);
					addScript(url);
				}

				public native void addScript(String url) /*-{
	                              var scr = document.createElement("script");
	                              scr.setAttribute("language", "JavaScript");
	                              scr.setAttribute("src", url);
	                              document.getElementsByTagName("head")[0].appendChild(scr);
	                              }-*/;

				private native void createCallbackFunction(JSONRequestHandler obj, String callbackName)/*-{
	                         tmpcallback = function(j) {
	                         obj.@ru.mos.gispro.tveravtodor.client.JSONRequestHandler::onRequestComplete(Lcom/google/gwt/core/client/JavaScriptObject;)(j);
	                         };
	                         eval( "window." + callbackName + "=tmpcallback" );
	                         }-*/;
			}

			int activeRequest = 0;

			public void findTask(String where, String what) {

				String url = "";

				if (SECOND_LEVEL.equals(where)) {
					url = "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/adm_mosobl/MapServer//find?layers=1&f=json&searchFields=RAY_NAME_1&";
				}
				if (FIRST_LEVEL.equals(where)) {
					url = "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/adm_mosobl/MapServer//find?layers=0&f=json&searchFields=caption&";
				}

				url += "searchText=" + what + "&contains=true&sr=102113&returnGeometry=true";

//				Window.alert(url);

				class FindRequestHandler implements JSONRequestHandler {

					public int request;

					public void onRequestComplete(JavaScriptObject json) {

						if (activeRequest > request) return;

						JSONFind find = json.cast();
						int resCount = find.results().length();

						if (resCount == 0) {
							com.google.gwt.user.client.Window.alert("Ничего не найдено");
							return;
						}

//						if (resCount == 1) {
							JSONFindItem item = find.results().get(0);
							GeometryManager1.clearGeometry();
							GeometryManager1.draw(item.geometry(), true, true);
//						}
					}
				}

				FindRequestHandler findRequestHandler = new FindRequestHandler();
				findRequestHandler.request = activeRequest;
				new JSONRequest().get(url, findRequestHandler);

			}




			public void onChanged(ChangedEvent changedEvent) {
				String s = changedEvent.getValue().toString();
				String[] t = s.split("/");

				GeometryManager.clearGeometry();
				if (t.length == 2) {
					String req = t[t.length-1];
					findTask(FIRST_LEVEL, req);
				}
				if (t.length == 3) {
					String req = t[t.length-1];
					findTask(SECOND_LEVEL, req);
				}

			}
		});

	}
}
