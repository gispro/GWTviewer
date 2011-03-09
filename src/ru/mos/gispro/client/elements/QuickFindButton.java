package ru.mos.gispro.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.client.JSONRequestHandler;
import ru.mos.gispro.client.geometry.GeometryManager;
import ru.mos.gispro.client.json.JSONFind;
import ru.mos.gispro.client.json.JSONFindItem;

public class QuickFindButton extends ToolStripButton
{
    private                     int      activeRequest  = 0;
	public   static     final   String   QUICK_FIND     = "Быстрый поиск";
    public   static     final   String   ALIAS_CLASS_ID = "Код объекта";

	public QuickFindButton(final TextItem textBox)
    {
		this.setIcon("findbutton.png");
		this.setIconSize(24);
		this.setHeight(30);
		this.setActionType(SelectionType.RADIO);
		this.setRadioGroup("mapAction");

		this.addClickHandler(new ClickHandler()
        {
			Window winModal;
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			public void findTask(String where, final String what)
            {
				String url = "";

				if (QUICK_FIND.equals(where))
                    url = GWTViewer.config.getURLQuickSearch();
                url = url.replaceAll("<0>", what);
                
                class FindRequestHandler implements JSONRequestHandler
                {
					public int request;

					public void onRequestComplete(JavaScriptObject json)
                    {
						if (activeRequest > request) return;

						JSONFind find = json.cast();
//                        com.google.gwt.user.client.Window.alert("0. onRequestComplete : find.results().length() = " + find.results().length()); //  + "\n" + find.results().toString());

						int resCount = find.results().length();

						if (resCount == 0)
                        {
							com.google.gwt.user.client.Window.alert(what + " не найдено");
							return;
						}

						if (resCount == 1)
                        {
							JSONFindItem item = find.results().get(0);
							GeometryManager.draw(item.geometry(), true, true);
						} else
                        {
							winModal = new Window();
							winModal.setTitle("Поиск");
							winModal.setHeight(300);
							winModal.setWidth(400);
							winModal.setShowMaximizeButton(true);
							winModal.centerInPage();
							winModal.setCanDragResize(true);

							final ListGrid listGrid = new ListGrid();
							listGrid.setWidth100();
							listGrid.setHeight100();

							ListGridField nameField = new ListGridField("name", "Объект");
							nameField.setType(ListGridFieldType.TEXT);
							ListGridField itemField = new ListGridField("item");
							itemField.setType(ListGridFieldType.TEXT);
							listGrid.setFields(nameField);
							listGrid.setEmptyMessage("");

                            nameField.setCanReorder(false);    nameField.setCanFreeze(false);    nameField.setCanHide  (false);
                            nameField.setCanGroupBy(false);    nameField.setCanFilter(false);    nameField.setCanSort  (false);

                            ClassIDSorter sorter = new ClassIDSorter();
                            for (int i = 0; i < resCount; i++)
                            {
                                JsArrayString keys = find.results().get(i).attributesKeys();
                                boolean with_class_id = false;
                                for (int j = 0; j < keys.length(); j++)
                                {
                                    if (ALIAS_CLASS_ID.equalsIgnoreCase(keys.get(j)))
                                    {
//                                        com.google.gwt.user.client.Window.alert("onRequestComplete : " + find.results().get(i).value() + ", class_id = " + find.results().get(i).attributesByKey(ALIAS_CLASS_ID));
                                        sorter.addItem(i, find.results().get(i).attributesByKey(ALIAS_CLASS_ID));
                                        with_class_id = true;
                                        break;
                                    }
                                }
                                if (!with_class_id)
                                {
                                    sorter.addItem(i, "-1");
//                                    com.google.gwt.user.client.Window.alert("onRequestComplete : " + find.results().get(i).value() + ", i = " + i);
                                }
//                                com.google.gwt.user.client.Window.alert("1. onRequestComplete : attribs = " + attribs);
                            }
//                            com.google.gwt.user.client.Window.alert("winModal : resCount = " + resCount);

                            // int idx = -1;
//                            com.google.gwt.user.client.Window.alert("resCount : " + resCount + ", sorter.getItemCount() = " + sorter.getItemCount());
							for (int i = 0; i < resCount; i++)
                            {
                                if (i <= sorter.getItemCount())
                                {
                                    int idx = sorter.getItem(i).i;
//                                com.google.gwt.user.client.Window.alert("i = " + i + ", idx : " + idx + ", class_id = " + sorter.getItem(idx).class_id);
								    String name = find.results().get(idx).value();
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
								    record.setAttribute("item", find.results().get(idx));
								    listGrid.addData(record);
                                }
							}

							listGrid.addClickHandler(new ClickHandler()
                            {
								public void onClick(ClickEvent clickEvent)
                                {
									JSONFindItem item = (JSONFindItem) listGrid.getSelectedRecord().getAttributeAsObject("item");
									if (item == null) return;

									JsArrayString keys = item.attributesKeys();

									for (int k = 0; k < keys.length(); k++)
                                    {
										GeometryManager.clearGeometry();
										GeometryManager.draw(item.geometry(), true, true);
									}
								}
							});
							winModal.addItem(listGrid);
							winModal.show();
                            sorter.destroy();
						}

//						for (int i = 0; i < resCount; i++) {
//							JSONFindItem item = find.results().get(i);
//							GeometryManager.draw(item.geometry(), false, false);
//						}
					}
				}
				FindRequestHandler findRequestHandler = new FindRequestHandler();
				findRequestHandler.request = activeRequest;
				new JSONRequest().get(url, findRequestHandler);
			}

			public void onClick(ClickEvent event)
            {
				GeometryManager.clearGeometry();
				findTask(QUICK_FIND, textBox.getValue().toString());
			}
		});
	}
}
