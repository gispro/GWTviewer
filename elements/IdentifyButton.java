package ru.mos.gispro.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.LayoutResizeBarPolicy;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.CloseClientEvent;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;
import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.client.JSONRequestHandler;
import ru.mos.gispro.client.geometry.GeometryManager;
import ru.mos.gispro.client.json.JSONIdentify;
import ru.mos.gispro.client.json.JSONIdentifyItem;
import ru.mos.gispro.client.layer.ArcGIS93;
import ru.mos.gispro.client.layer.WMS;
import com.smartgwt.client.widgets.Canvas;

import ru.mos.gispro.client.window.Contractors;

/**
 * User: dima
 * Date: 20.11.2010
 * Time: 15:49:27
 */
public class IdentifyButton extends ToolStripButton
{
	HandlerRegistration handlerRegistration;
    private  final   static   String    TAG_FONT_HIDE_START       = "<font style=\"color:white\">";
    private  final   static   String    TAG_FONT_HIDE_END         = "</font>";
    private  final   static   String    STRING_IDENTIFIER         = "Идентификатор";
    private  final   static   String    STRING_CONTACTS_LINK      = "<font style=\"color:blue\"><b><u>Контакты ...<u><b></font>";
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public native void goURL(String url) /*-{
		$wnd.window.open(url);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public IdentifyButton(final TreeGrid treeGrid, final Canvas canvas)
    {
		final Tree data = treeGrid.getTree();

		this.setIcon("MActionIdentify.png");
		this.setIconSize(24);
		this.setHeight(30);
		this.setActionType(SelectionType.RADIO);
		this.setRadioGroup("mapAction");

		this.addClickHandler(new ClickHandler()
        {
			Window      winModal;
			boolean     isPointSelected = false;
			TreeGrid    tree2;
			ListGrid    list2;
			Tree        data2;
			RecordList  data3;
            int         activeRequest = 0;
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			protected native void test22()
            /*-{
                for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
                {
                    if ($wnd.map.controls[indexControl].displayClass != "olControlNavigationHistory")
                        $wnd.map.controls[indexControl].deactivate();
                    if ($wnd.map.controls[indexControl].displayClass == "olControlMousePosition")
                        $wnd.map.controls[indexControl].activate();
                }
            }-*/;
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			class JSONRequest
            {
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				public void get(String url, JSONRequestHandler handler)
                {
					String callbackName = "JSONCallback" + handler.hashCode();
					get(url + "&callback=" + callbackName, callbackName, handler);
				}
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				public void get(String url, String callbackName, JSONRequestHandler handler)
                {
					createCallbackFunction(handler, callbackName);
					addScript(url);
				}
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				public native void addScript(String url)
                /*-{
                    var scr = document.createElement("script");
                    scr.setAttribute("language", "JavaScript");
                    scr.setAttribute("src", url);
                    document.getElementsByTagName("head")[0].appendChild(scr);
                }-*/;
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				private native void createCallbackFunction(JSONRequestHandler obj, String callbackName)
                /*-{
                    tmpcallback = function(j)
                    {
                        obj.@ru.mos.gispro.client.JSONRequestHandler::onRequestComplete(Lcom/google/gwt/core/client/JavaScriptObject;)(j);
                    };
                    eval( "window." + callbackName + "=tmpcallback" );
                }-*/;
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			}
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			public void onClick(ClickEvent event)
            {
//              com.google.gwt.user.client.Window.alert("IdentifyButton");
//				Document.get().getElementById("map").getStyle().setCursor(isSelected() ? Style.Cursor.CROSSHAIR : Style.Cursor.DEFAULT);
				test22();
				if (winModal == null)
                {
					winModal = new Window();
					winModal.setTitle("Информация");
					winModal.setHeight(300);
					winModal.setWidth(500);
					winModal.setShowMaximizeButton(true);
					winModal.centerInPage();
					winModal.setCanDragResize(true);
					winModal.addCloseClickHandler(new CloseClickHandler()
                    {
						public void onCloseClick(CloseClientEvent event)
                        {
							deselect();
                            // activate(JavaScriptObject zoomBox);
							GeometryManager.clearGeometry();
							winModal.hide();
							winModal.destroy();
							winModal = null;
						}
					});

					HLayout layout = new HLayout();
					layout.setDefaultResizeBars(LayoutResizeBarPolicy.MIDDLE);

					tree2 = new TreeGrid();
                    tree2.setHeaderHeight(0);
					tree2.setWidth("50%");
					tree2.setTitle("Слой");
					tree2.setEmptyMessage("");
//					tree2.getField(0).setTitle("Объект");

					data2 = new Tree();
					data2.setRoot(new TreeNode(""));
					data2.setNameProperty("Layout");

					data2.openAll();

					tree2.setData(data2);
					tree2.addSelectionChangedHandler(new SelectionChangedHandler()
                    {
						public void onSelectionChanged(SelectionEvent event)
                        {
							TreeNode treeNode = (TreeNode) event.getRecord();

							data3.removeList(data3.toArray());
							JSONIdentifyItem item = (JSONIdentifyItem) treeNode.getAttributeAsObject("item");
							if (item == null)
								return;

							JsArrayString keys = item.attributesKeys();
							for (int k = 0; k < keys.length(); ++k)
                            {
                                if (!"OBJECTID".equalsIgnoreCase(keys.get(k)))
                                {
    								ListGridRecord record = new ListGridRecord();
                                    if (GWTViewer.config.isMosAvtoDor() && keys.get(k).equalsIgnoreCase(STRING_IDENTIFIER))
                                    {
	    							    record.setAttribute("field", STRING_CONTACTS_LINK);
                                        record.setAttribute("value", TAG_FONT_HIDE_START +
                                                                               item.attributesByKey(keys.get(k)) +
                                                                     TAG_FONT_HIDE_END);
                                    }
                                    else
                                    {
                                        record.setAttribute("field", keys.get(k));
                                        record.setAttribute("value", item.attributesByKey(keys.get(k)));
                                    }
			    					data3.add(record);
                                }
							}
							GeometryManager.clearGeometry();
							GeometryManager.draw(item.geometry(), false, false);
						}
					});

					list2 = new ListGrid();
					list2.setWidth("50%");
					ListGridField field = new ListGridField("field", "Поле");
					ListGridField value = new ListGridField("value", "Значение");
					list2.setFields(field, value);

                    field.setCanReorder(false);    field.setCanFreeze(false);    field.setCanHide  (false);
                    field.setCanGroupBy(false);    field.setCanFilter(false);
                    value.setCanReorder(false);    value.setCanSort  (false);    value.setCanFreeze(false);
                    value.setCanGroupBy(false);    value.setCanFilter(false);    value.setCanHide  (false);

					data3 = new RecordList();
					list2.setData(data3);
					list2.setEmptyMessage("");

                    if (GWTViewer.config.isMosAvtoDor())
                    {
                        list2.addCellClickHandler(new CellClickHandler()
                        {
                            public void onCellClick(CellClickEvent cellClickEvent)
                            {
                                if (STRING_CONTACTS_LINK.equalsIgnoreCase(cellClickEvent.getRecord().getAttribute("field")))
                                {
                                    String f = cellClickEvent.getRecord().getAttribute("value");
                                    f = f.substring(TAG_FONT_HIDE_START.length());
                                    f = f.substring(0, f.length() - TAG_FONT_HIDE_END.length());
                                    int w = Contractors.WIDTH;
                                    if (winModal.getWidth() > (w + 100))
                                        w = winModal.getWidth() + 100;
                                    int h = Contractors.HEIGHT;
                                    if (winModal.getHeight() > (h + 50))
                                        h = winModal.getHeight() + 50;
                                    Contractors contractors = new Contractors (w, h, Integer.valueOf(f), data3);
                                    contractors.show();
                                }
							}
                        });
                    }
                    else if (GWTViewer.config.isTverAvtoDor())
                    {
					    list2.addCellClickHandler(new CellClickHandler() {
						    public void onCellClick(CellClickEvent cellClickEvent)
                            {
//    							String f = cellClickEvent.getRecord().getAttribute("field");
			    				if ("Документ".equals(cellClickEvent.getRecord().getAttribute("field")))
                                {
//                              String u = "http://94.198.33.13:8000/RoadSoft/" + cellClickEvent.getRecord().getAttribute("value");
                                    String u = GWTViewer.config.getURLRoadSoft() + cellClickEvent.getRecord().getAttribute("value");
				    				goURL(u);
							    }
    						}
	    				});
                    }

					layout.addMember(tree2);
					layout.addMember(list2);

					winModal.addItem(layout);
				}
//                com.google.gwt.user.client.Window.alert("IdentifyButton : isSelected = " + isSelected ());
				if (isSelected())
                {
					handlerRegistration = canvas.addClickHandler(new ClickHandler()
                    {
						public void onClick(ClickEvent event)
                        {
//                            com.google.gwt.user.client.Window.alert("IdentifyButton : handlerRegistration = " + isSelected ());
							if (!isSelected()) return;

							winModal.show();
							data2.removeList(data2.getAllNodes());
							data3.removeList(data3.toArray());

							++activeRequest;
							for (TreeNode service22 : data.getChildren(data.getRoot()))
                            {
								try
                                {
									if (!treeGrid.isSelected(service22))
										continue;
								}
								catch (Exception e) {
									continue;
								}

								Object mapService = service22.getAttributeAsObject("service");
								String name = mapService.getClass().getName();
								if (name.equals(ArcGIS93.class.getName()))
                                {
									String url = ((ArcGIS93) mapService).UrlIdentify() + "/identify?";
									url += "geometryType=esriGeometryPoint&tolerance=7&" +
											"sr=102113&returnGeometry=true&f=json&layers=all:" + ((ArcGIS93) mapService).Layers().replaceAll(", ", ",") + "&" + getInfo();
                                    if (GWTViewer.config.debug_InfoURL_Alert())
                                        com.google.gwt.user.client.Window.alert("IdentifyButton\n" + url);
                                    
									class CCC implements JSONRequestHandler
                                    {
										public int request;
										public ArcGIS93 service;

										public void onRequestComplete(JavaScriptObject json)
                                        {
// com.google.gwt.user.client.Window.alert("CCC.onRequestComplete = " + json);
                                            if (activeRequest > request)
												return;
											JSONIdentify identify = json.cast();
											if (identify.results().length() == 0)
												return;

											TreeNode treeNode = new TreeNode();
											treeNode.setAttribute("Layout", service.name);
											data2.add(treeNode, data2.getRoot());
											for (int i = 0; i < identify.results().length(); ++i) {
												TreeNode treeNode2 = new TreeNode();
												treeNode2.setAttribute("Layout", identify.results().get(i).layerName());
												treeNode2.setAttribute("item", identify.results().get(i));
												data2.add(treeNode2, treeNode);
												data2.openAll();

												if (data2.getAllNodes().length < 3) {
													tree2.selectRecord(treeNode2);
												}
												
											}
										}
									}
									CCC ccc = new CCC();
									ccc.request = activeRequest;
									ccc.service = (ArcGIS93) mapService;
									new JSONRequest().get(url, ccc);
								}

								if (name.equals(WMS.class.getName()))
                                {
									String url = ((WMS) mapService).Url();

									class CCC implements JSONRequestHandler
                                    {
										public int request;
										public WMS service;

										public void onRequestComplete(JavaScriptObject json)
                                        {
											if (activeRequest > request)
												return;
											JSONIdentify identify = json.cast();
											int test = identify.results().length();

											TreeNode treeNode = new TreeNode();
//				                            treeNode.setAttribute("Layout", service.name + "_" + Integer.toString(test));
											data2.add(treeNode, data2.getRoot());
											for (int i = 0; i < identify.results().length(); ++i)
                                            {
												TreeNode treeNode2 = new TreeNode();
												treeNode2.setAttribute("Layout", identify.results().get(i).layerName());
												treeNode2.setAttribute("item", identify.results().get(i));
												data2.add(treeNode2, treeNode);
											}
										}
									}
								}
							}
						}

						private native String getInfo() /*-{
                            var extent = $wnd.map.getExtent();
                            var size = $wnd.map.getSize();
                            var mouse;
                            for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
                            {
                                if ($wnd.map.controls[indexControl].displayClass == "olControlMousePosition")
                                {
                                    mouse = $wnd.map.controls[indexControl];
                                    break;
                                }

                            }
                            var point = $wnd.map.getLonLatFromPixel(mouse.lastXy);
                            var str = "mapExtent=" + extent.left + "," + extent.bottom + "," + extent.right + "," + extent.top + "&";
                            str = str + "geometry=" + point.lon + "," + point.lat + "&";
                            str = str + "imageDisplay=" + size.w + "," + size.h + "," + "96";
                            return str;
                        }-*/;
					});
				} else {
//                    com.google.gwt.user.client.Window.alert("IdentifyButton : handlerRegistration.removeHandler()");
					handlerRegistration.removeHandler();
				}
				if (!isPointSelected)
					return;
			}
		});
	}
}
