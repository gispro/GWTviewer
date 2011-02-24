package ru.mos.gispro.tveravtodor.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.smartgwt.client.types.LayoutResizeBarPolicy;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.CloseClientEvent;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import ru.mos.gispro.tveravtodor.client.JSONRequestHandler;
import ru.mos.gispro.tveravtodor.client.TverAvtoDor;
import ru.mos.gispro.tveravtodor.client.geometry.GeometryManager;
import ru.mos.gispro.tveravtodor.client.json.JSONFind;
import ru.mos.gispro.tveravtodor.client.json.JSONFindItem;
import ru.mos.gispro.tveravtodor.client.json.JSONPolyLine;
import ru.mos.gispro.tveravtodor.client.json.JSONPolygon;

/**
 * User: dima
 * Date: 20.11.2010
 * Time: 16:15:56
 */

public class FindButton extends ToolStripButton
{
    public static       String URL_FIND_NAS_PUNKT   = "";
    public static       String URL_FIND_TITUL_DOROG = "";
    public static       String URL_FIND_STREETS     = "";

	public static final String FIND_NAS_PUNKT       = "Населенные пункты";
    public static       String FIND_ULITSI          = "Улицы";
	public static       String FIND_TITUL_DOROG     = "Титулы дорог";

	public static final String FIND_RESHIM_POS      = "Приблизить";
	public static final String FIND_RESHIM_PEREYTI  = "Перейти";

	public FindButton()
    {
		this.setIcon("MActionFind.png");
		this.setIconSize(24);
		this.setHeight(30);
		this.setActionType(SelectionType.RADIO);
		this.setRadioGroup("mapAction");

        URL_FIND_NAS_PUNKT   = TverAvtoDor.config.getURLFindNasPunkt();
        URL_FIND_STREETS     = TverAvtoDor.config.getURLFindStreets ();
        URL_FIND_TITUL_DOROG = TverAvtoDor.config.findTitulDorog    ();

        if (URL_FIND_STREETS.trim().length() == 0)
            FIND_ULITSI = null;
        if (URL_FIND_TITUL_DOROG.trim().length() == 0)
            FIND_TITUL_DOROG = null;

		this.addClickHandler(new ClickHandler()
        {
			Window winModal;
			ListGrid listGrid = new ListGrid();
			final ListGrid findAttrGrid = new ListGrid();
			final ListBox howListBox = new ListBox(false);

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

			public native void deactivateControls() /*-{
		    for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
		    {
		        if ($wnd.map.controls[indexControl].displayClass != "olControlNavigationHistory")
		            $wnd.map.controls[indexControl].deactivate();
		        if ($wnd.map.controls[indexControl].displayClass == "olControlMousePosition")
		            $wnd.map.controls[indexControl].activate();
		    }
		    }-*/;

			public void findTask(String where, final String what) {
				deactivateControls();
				
				String url = "";

				if (FIND_NAS_PUNKT.equals(where))
                {
//					url = "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn_21122010/MapServer//find?layers=18&f=json&searchFields=Find&";
//					url = "http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo100_tver/MapServer//find?layers=25&f=json&searchFields=Find&";
                    url = URL_FIND_NAS_PUNKT;
				}
    			else if ((FIND_TITUL_DOROG != null) && FIND_TITUL_DOROG.equals(where))
//  				url = "http://maps.gispro.ru/ArcGIS/rest/services/TVER/routes_tver_region_compalex/MapServer/find?layers=52&f=json&searchFields=Titul&";
                    url = URL_FIND_TITUL_DOROG;
			    else if ((FIND_ULITSI != null) && FIND_ULITSI.equals(where))
                {
//				    url = "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn_21122010/MapServer//find?layers=1&f=json&searchFields=Find&";
//				    url = "http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo100_tver/MapServer//find?layers=12&f=json&searchFields=Find&";
                    url = URL_FIND_STREETS;
    		    }
				// url += "searchText=" + what + "&contains=true&sr=102113&returnGeometry=true";
                url = url.replaceAll("<0>", what);

				class FindRequestHandler implements JSONRequestHandler {

					public int request;

					public void onRequestComplete(JavaScriptObject json) {

						if (activeRequest > request) return;

						JSONFind find = json.cast();
						int resCount = find.results().length();

						if (resCount == 0) {
							com.google.gwt.user.client.Window.alert(what + " не найдено");
							return;
						}

						listGrid.setData(new ListGridRecord[]{});

						for (int i = 0; i < resCount; i++)
                        {
							String name = find.results().get(i).value();
                            int comma = name.indexOf(",");
                            if (comma > 0)
                            {
                                int point = -1;
                                point = name.indexOf(".", comma + 1);
                                if (point > comma)
                                    name = name.substring(0, point) + name.substring(point + 1);
                            }

							ListGridRecord record = new ListGridRecord();
							record.setAttribute("name", name);
							record.setAttribute("item", find.results().get(i));
							listGrid.addData(record);
						}
					}
				}

				FindRequestHandler findRequestHandler = new FindRequestHandler();
				findRequestHandler.request = activeRequest;
				new JSONRequest().get(url, findRequestHandler);


			}

			public void findProcess() {

				JSONFindItem item = (JSONFindItem) listGrid.getSelectedRecord().getAttributeAsObject("item");
				if (item == null) return;

				findAttrGrid.setData(new ListGridRecord[]{});

				JsArrayString keys = item.attributesKeys();

//				com.google.gwt.user.client.Window.alert(keys.length() + "");


				for (int k = 0; k < keys.length(); k++) {

//					com.google.gwt.user.client.Window.alert(k + "");
//					com.google.gwt.user.client.Window.alert(keys.get(k));
//					com.google.gwt.user.client.Window.alert(item.attributesByKey(keys.get(k)));

					ListGridRecord record = new ListGridRecord();
					record.setAttribute("field", keys.get(k) + "");
					record.setAttribute("value", item.attributesByKey(keys.get(k)) + "");
					findAttrGrid.addData(record);
				}

//				com.google.gwt.user.client.Window.alert(findAttrGrid.getDataAsRecordList().isEmpty() + "");

				GeometryManager.clearGeometry();
				GeometryManager.draw(item.geometry(), FIND_RESHIM_POS.equals(howListBox.getItemText(howListBox.getSelectedIndex())), true);

			}

			public void onClick(ClickEvent event) {

				if (winModal == null) {

					winModal = new Window();
					winModal.setTitle("Поиск");
					winModal.setHeight(300);
					winModal.setWidth(400);
					winModal.setShowMaximizeButton(true);
					winModal.centerInPage();
					winModal.setCanDragResize(true);

					VLayout layout = new VLayout();

					HLayout whereLayout = new HLayout();
					whereLayout.setHeight("20px");
					whereLayout.setWidth100();

					Label whereLabel = new Label("Слой: ");
					whereLabel.setWidth("50px");
					whereLabel.setHeight("100%");
					whereLayout.addMember(whereLabel);

					final ListBox whereListBox = new ListBox(false);
					whereListBox.setHeight("20px");
					whereListBox.setWidth("250px");
					whereListBox.addItem(FIND_NAS_PUNKT);
                    if (FIND_TITUL_DOROG != null)
    					whereListBox.addItem(FIND_TITUL_DOROG);
//                    if (TverAvtoDor.config.isMosRegion() && (FIND_ULITSI != null))
                    if (FIND_ULITSI != null)
    					whereListBox.addItem(FIND_ULITSI);
					whereLayout.addMember(whereListBox);

					layout.addMember(whereLayout);

					HLayout howLayout = new HLayout();
					howLayout.setHeight("20px");
					howLayout.setWidth100();

					Label howLabel = new Label("Режим: ");
					howLabel.setWidth("50px");
					howLabel.setHeight("100%");
					howLayout.addMember(howLabel);

					howListBox.setHeight("20px");
					howListBox.setWidth("250px");
					howListBox.addItem(FIND_RESHIM_PEREYTI, FIND_RESHIM_PEREYTI);
					howListBox.addItem(FIND_RESHIM_POS, FIND_RESHIM_POS);
					howLayout.addMember(howListBox);

					layout.addMember(howLayout);

					HLayout askLayout = new HLayout();
					askLayout.setHeight("20px");
					askLayout.setWidth100();

					Label askLabel = new Label("Запрос: ");
					askLabel.setWidth("50px");
					askLabel.setHeight("100%");
					askLayout.addMember(askLabel);

					final TextBox textBox = new TextBox();
					textBox.setWidth("200px");
					textBox.setHeight("100%");
					askLayout.addMember(textBox);

					Button button = new Button("Искать");
					button.setHeight100();
					button.setWidth(50);
					button.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent clickEvent) {
							findTask(whereListBox.getItemText(whereListBox.getSelectedIndex()), textBox.getText());
						}
					});
					askLayout.addMember(button);

					layout.addMember(askLayout);

					Canvas resCanvas = new Canvas();
					resCanvas.setHeight("*");
					resCanvas.setWidth100();

					HLayout resLayout = new HLayout();
					resLayout.setHeight100();
					resLayout.setWidth100();

					listGrid.setHeight100();
					listGrid.setWidth("30%");
					listGrid.setSelectionType(SelectionStyle.SINGLE);

					ListGridField nameField = new ListGridField("name", "Объект");
					nameField.setType(ListGridFieldType.TEXT);
					ListGridField itemField = new ListGridField("item");
					itemField.setType(ListGridFieldType.TEXT);
					listGrid.setFields(nameField);
					listGrid.setEmptyMessage("");


//					final ListGrid findAttrGrid = new ListGrid();
					findAttrGrid.setEmptyMessage("");
					findAttrGrid.setHeight100();
					findAttrGrid.setWidth("70%");
					ListGridField nameAttrField = new ListGridField("field", "Поле");
					nameAttrField.setType(ListGridFieldType.TEXT);
					ListGridField valAttrField = new ListGridField("value", "Значение");
					valAttrField.setType(ListGridFieldType.TEXT);
					findAttrGrid.setFields(nameAttrField, valAttrField);


//					listGrid.addSelectionChangedHandler(new SelectionChangedHandler() {
//						public void onSelectionChanged(SelectionEvent clickEvent) {
//							findProcess();
//						}
//					});
					listGrid.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent clickEvent) {
							findProcess();
						}
					});

					resLayout.setDefaultResizeBars(LayoutResizeBarPolicy.MIDDLE);
					resLayout.addMember(listGrid);
					resLayout.addMember(findAttrGrid);

					resCanvas.addChild(resLayout);

					layout.addMember(resCanvas);

					winModal.addCloseClickHandler(new CloseClickHandler() {
						public void onCloseClick(CloseClientEvent closeClientEvent) {
							GeometryManager.clearGeometry();
							winModal.hide();
						}
					});

					winModal.addItem(layout);
					winModal.show();

				} else {
					winModal.show();
				}
			}
		});
	}
}
