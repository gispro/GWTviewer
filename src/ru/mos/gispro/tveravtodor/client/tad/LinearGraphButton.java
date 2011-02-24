package ru.mos.gispro.tveravtodor.client.tad;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import ru.mos.gispro.tveravtodor.client.JSONRequestHandler;
import ru.mos.gispro.tveravtodor.client.json.JSONIdentify;
import ru.mos.gispro.tveravtodor.client.TverAvtoDor;

public class LinearGraphButton extends ToolStripButton
{
	HandlerRegistration handlerRegistration;

	public native void goURL(String url) /*-{
		$wnd.window.open(url);
    }-*/;

	public LinearGraphButton(final Canvas canvas)
    {
		this.setIcon("lingraph.png");
		this.setIconSize(24);
		this.setHeight(30);
		this.setActionType(SelectionType.RADIO);
		this.setRadioGroup("mapAction");

		this.addClickHandler(new ClickHandler() {

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

			public void onClick(ClickEvent event)
            {
//				Document.get().getElementById("map").getStyle().setCursor(isSelected() ? Style.Cursor.CROSSHAIR : Style.Cursor.DEFAULT);
				test22();

				if (isSelected()) {
					handlerRegistration = canvas.addClickHandler(new ClickHandler() {

						public void onClick(ClickEvent event) {

							if (!isSelected()) return;

							++activeRequest;

							String url = "http://maps.gispro.ru/ArcGIS/rest/services/TVER/routes_tver_region_compalex/MapServer/" + "/identify?";
							url += "geometryType=esriGeometryPoint&tolerance=7&" +
									"sr=102113&returnGeometry=true&f=json&layers=all:52" + "&" + getInfo();

							class CCC implements JSONRequestHandler {
								public int request;

								public void onRequestComplete(JavaScriptObject json) {
									if (activeRequest > request)
										return;
									JSONIdentify identify = json.cast();
									if (identify.results().length() == 0)
										return;

									String km = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(5));
									String m = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(6));
									String km1 = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(7));
									String m1 = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(8));
									String id = identify.results().get(0).attributesByKey(identify.results().get(0).attributesKeys().get(12));
									// String urlgo = "http://94.198.33.13:8000/roadsoft/ldTPassport/LDPage.aspx?__WP=RoadPassport_OUDH&RoadID="+id+"&BeginKm="+km+"&BeginM="+m+"&EndKm="+km1+"&EndM="+m1+"&Date=";
                                    String urlgo = TverAvtoDor.config.getURLRoadSoft() + "ldTPassport/LDPage.aspx?__WP=RoadPassport_OUDH&RoadID="+id+"&BeginKm="+km+"&BeginM="+m+"&EndKm="+km1+"&EndM="+m1+"&Date=";
                                    goURL(urlgo);
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
