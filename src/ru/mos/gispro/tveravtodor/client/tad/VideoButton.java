package ru.mos.gispro.tveravtodor.client.tad;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.CloseClientEvent;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import ru.mos.gispro.tveravtodor.client.JSONRequestHandler;
import ru.mos.gispro.tveravtodor.client.geometry.GeometryManager;
import ru.mos.gispro.tveravtodor.client.json.JSONIdentify;
import ru.mos.gispro.tveravtodor.client.GWTViewer;

import java.util.ArrayList;
import java.util.List;

public class VideoButton extends ToolStripButton
{
	HandlerRegistration handlerRegistration;

	public native void goURL(String url) /*-{
		$wnd.window.open(url);
    }-*/;

	public VideoButton(final Canvas canvas)
    {
		this.setIcon("film.png");
		this.setIconSize(24);
		this.setHeight(30);
		this.setActionType(SelectionType.RADIO);
		this.setRadioGroup("mapAction");

		this.addClickHandler(new ClickHandler()
        {
			Window winModal;
			boolean isPointSelected = false;

			protected native void test22() /*-{
            for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
            {
                if ($wnd.map.controls[indexControl].displayClass != "olControlNavigationHistory")
                    $wnd.map.controls[indexControl].deactivate();
                if ($wnd.map.controls[indexControl].displayClass == "olControlMousePosition")
                    $wnd.map.controls[indexControl].activate();
            }
	        }-*/;

			class JSONRequest {

				public void get(String url, JSONRequestHandler handler) {
					String callbackName = "JSONCallback" + handler.hashCode();
					get(url + "&callback=" + callbackName, callbackName, handler);
				}

				public void get(String url, String callbackName,
				                JSONRequestHandler handler) {
					createCallbackFunction(handler, callbackName);
					addScript(url);
				}

				public native void addScript(String url) /*-{
                                 var scr = document.createElement("script");
                                 scr.setAttribute("language", "JavaScript");
                                 scr.setAttribute("src", url);
                                 document.getElementsByTagName("head")[0].appendChild(scr);
                                 }-*/;

				private native void createCallbackFunction(JSONRequestHandler obj,
				                                           String callbackName)/*-{
                            tmpcallback = function(j) {
                            obj.@ru.mos.gispro.tveravtodor.client.JSONRequestHandler::onRequestComplete(Lcom/google/gwt/core/client/JavaScriptObject;)(j);
                            };
                            eval( "window." + callbackName + "=tmpcallback" );
                            }-*/;
			}

			int activeRequest = 0;

			public void onClick(ClickEvent event) {


//				Document.get().getElementById("map").getStyle().setCursor(isSelected() ? Style.Cursor.CROSSHAIR : Style.Cursor.DEFAULT);
				test22();

				if (isSelected())
                {
					handlerRegistration = canvas.addClickHandler(new ClickHandler()
                    {
						public void onClick(ClickEvent event)
                        {
							if (!isSelected()) return;

							++activeRequest;

							String url = "http://maps.gispro.ru/ArcGIS/rest/services/TVER/video/MapServer/" + "/identify?";
							url += "geometryType=esriGeometryPoint&tolerance=7&" +
									"sr=102113&returnGeometry=true&f=json&layers=all:0" + "&" + getInfo();

//							com.google.gwt.user.client.Window.alert(url);

							class CCC implements JSONRequestHandler {
								public int request;

								public void onRequestComplete(JavaScriptObject json) {
									if (activeRequest > request)
										return;
									final JSONIdentify identify = json.cast();
									if (identify.results().length() == 0)
										return;


									List<String> radios = new ArrayList<String>();
									for (int a = 5; a < 12; a++) {
										String s = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(a));
										String n = identify.results().get(0).attributesKeys().get(a);
										if (s == null)continue;
										if ("".equals(s))continue;
										radios.add(n);
									}

									if (radios.size() == 0)return;

									String title = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(2));

									winModal = new Window();
									winModal.setTitle("Видео по дороге: " + title);
									winModal.setHeight(300);
									winModal.setWidth(500);
									winModal.setShowMaximizeButton(true);
									winModal.setIsModal(true);
									winModal.setCanDragResize(true);
									winModal.centerInPage();
									winModal.setCanDragResize(true);
									winModal.addCloseClickHandler(new CloseClickHandler() {
										public void onCloseClick(CloseClientEvent event) {
											GeometryManager.clearGeometry();
											winModal.hide();
											winModal.destroy();
										}
									});

//									final Label label = new Label(title);
//									label.setTop(10);
//									label.setLeft(10);
//									label.setWidth(400);

									final RadioGroupItem radioGroupItem = new RadioGroupItem();
									radioGroupItem.setTitle("Камера");
									radioGroupItem.setWidth(400);
									String[] r = new String[1];
									r = radios.toArray(r);
									radioGroupItem.setValueMap(r);
//											"Прямое, левая камера",
//											"Прямое, правая камера",
//											"Прямое, боковая камера",
//											"Обратное, левая камера",
//											"Обратное, правая камера",
//											"Обратное, боковая камера",
//											"Прямое, задняя камера",
//											"Обратное, задняя камера");

									
									ButtonItem button = new ButtonItem("Открыть");
									button.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
										public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent clickEvent) {
//											com.google.gwt.user.client.Window.alert("1");
											String radio = radioGroupItem.getAttribute("value");
											String urlgo = "";
//											com.google.gwt.user.client.Window.alert(radio);
											if ("Прямое, левая камера".equals(radio)) {
												urlgo = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(5));
											}
											if ("Прямое, боковая камера".equals(radio)) {
												urlgo = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(6));
											}
											if ("Обратное, левая камера".equals(radio)) {
												urlgo = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(7));
											}
											if ("Обратное, правая камера".equals(radio)) {
												urlgo = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(8));
											}
											if ("Обратное, боковая камера".equals(radio)) {
												urlgo = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(9));
											}
											if ("Прямое, задняя камера".equals(radio)) {
												urlgo = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(10));
											}
											if ("Обратное, задняя камера".equals(radio)) {
												urlgo = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(11)); 
											}
//											com.google.gwt.user.client.Window.alert(urlgo);
											goURL(urlgo);
										}
									});


									DynamicForm form = new DynamicForm();
									form.setTop(30);
									form.setLeft(10);
									form.setFields(radioGroupItem, button);
									winModal.addChild(form);
									winModal.show();
								}
							}

							CCC ccc = new CCC();
							ccc.request = activeRequest;
							new JSONRequest().get(url, ccc);
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
					handlerRegistration.removeHandler();
				}
			}
		});
	}
}
