package ru.mos.gispro.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.widgets.events.MouseMoveEvent;
import com.smartgwt.client.widgets.events.MouseMoveHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;
import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.client.JSONRequestHandler;
import ru.mos.gispro.client.json.JSONHintConfig;
import ru.mos.gispro.client.json.JSONIdentify;
import ru.mos.gispro.client.layer.ArcGIS93;

public class MouseHintHandler implements MouseMoveHandler
{
    private       TreeGrid    treeGrid     = null ;
    private       long        time         =  0   ;
    private       String      marker       = ""   ;
    private       boolean     isChecked    = false;
    private       boolean     isClosed     = true ;
    private       boolean     isHintloaded = false;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public MouseHintHandler (TreeGrid treeGrid)
    {
        this.treeGrid   = treeGrid;
        time = System.currentTimeMillis();
        new Timer()
        {
            public void run()
            {
                String mark = getMarkerLocation();
                if (mark.equals(marker))
                {
                    if (System.currentTimeMillis() > (time + GWTViewer.config.hintDelay()))
                    {
                        if (!isChecked && !isClosed)
                        {
                            isChecked = true;
                            isClosed  = true;
//                                com.google.gwt.user.client.Window.alert("MouseHintHandler.onTimer :\n" +
//                                        marker + "\n" + mark + "\n\n" + time + // "\n" + System.currentTimeMillis() + "\n delta = " +
//                                        (System.currentTimeMillis() - time));
                            findObjectHint();
                            time = System.currentTimeMillis();
                        }
                    }
                } else {
                    isChecked = false;
                    isClosed  = false;
                    time = System.currentTimeMillis();
                }
            }
        }.scheduleRepeating(500);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private native String geObjectInfo()
    /*-{
        var extent = $wnd.map.getExtent();
        var size   = $wnd.map.getSize  ();
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
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private native String getMarkerLocation()
    /*-{
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
        return point.lon + "," + point.lat;
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private native void showHint(float lon, float lat, String hint)
    /*-{
            $wnd.hintMarker = new $wnd.OpenLayers.LonLat(lon, lat);
            $wnd.onFeatureSelect(hint);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private native void closePopup()
    /*-{
            $wnd.onPopupClose(null);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void findObjectHint ()
    {
        int idx = marker.indexOf(",");
        if (idx > 0)
            findObject();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void showObjectHint (String desc)
    {
        int idx = marker.indexOf(",");
        String lon = marker.substring(0, idx);
        String lat = marker.substring(idx + 1);
        showHint(Float.valueOf(lon), Float.valueOf(lat), desc);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void onMouseMove (MouseMoveEvent event)
    {
        closePopup();
        if (!isChecked)
            marker = getMarkerLocation();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    class jsonRequestHandler implements JSONRequestHandler
    {
        public void onRequestComplete(JavaScriptObject json)
        {
            JSONIdentify identify = json.cast();
            if ((identify.results().length() == 0) && !isHintloaded)
            {
//                closePopup();
                return;
            }
            if (isHintloaded)
                return;
            isHintloaded = true;
            String desc  = "";
            String title = null;
            JsArrayString keys = identify.results().get(0).attributesKeys();

            int layerNumber = 0;
            // select title & layerNumber
            for (int k = 0; k < keys.length(); ++k)
            {
                if (title == null)
                {
                    for (int j = 0; j < GWTViewer.config.hintDesc().length(); j++)
                    {
                        JSONHintConfig hint = GWTViewer.config.hintItem(j).cast();
                        if (hint.isTitle())
                        {
                            if ((keys.get(k).trim().equalsIgnoreCase(hint.identifier())))
                            {
                                layerNumber = hint.layerNumber();
                                title = identify.results().get(0).attributesByKey(keys.get(k));
                                if (title.length() > 28)
                                    title = title.substring(0, 25) + "...";
                                title = hint.html().replace("<0>", title);
                                break;
                            }
                        }
                    }
                }
            }
//            com.google.gwt.user.client.Window.alert("jsonRequestHandler : layerNumber = " + layerNumber + ", " + title);
            if (title != null)
            {
                for (int k = 0; k < keys.length(); ++k)
                {
                    for (int j = 0; j < GWTViewer.config.hintDesc().length(); j++)
                    {
                        JSONHintConfig hint = GWTViewer.config.hintItem(j).cast();
                        if ((hint.layerNumber() == layerNumber) && (!hint.isTitle()))
                        {
                            if ((keys.get(k).trim().equalsIgnoreCase(hint.identifier())))
                            {
                                if (identify.results().get(0).attributesByKey(keys.get(k)).length() < 30)
                                    desc += hint.html().replace("<0>", identify.results().get(0).attributesByKey(keys.get(k)));
                                else
                                    desc += hint.html().replace("<0>", identify.results().get(0).attributesByKey(keys.get(k)).substring(0, 27) + "...");
                            }
                        }
                    }
                }
            }
/*
                for (int j = 0; j < GWTViewer.config.hintDesc().length(); j++)
                {
                    JSONHintConfig hint = GWTViewer.config.hintItem(j).cast();
                    if ((keys.get(k).trim().equalsIgnoreCase(hint.identifier())))
                    {
//                        if (j == 0)
                        if (hint.isTitle())
                        {
                            title = identify.results().get(0).attributesByKey(keys.get(k));
                            if (title.length() > 28)
                                title = title.substring(0, 25) + "...";
                            title = hint.html().replace("<0>", title);
                        } else {
                            if (identify.results().get(0).attributesByKey(keys.get(k)).length() < 30)
                                desc += hint.html().replace("<0>", identify.results().get(0).attributesByKey(keys.get(k)));
                            else
                                desc += hint.html().replace("<0>", identify.results().get(0).attributesByKey(keys.get(k)).substring(0, 27) + "...");
                        }
                    }
                }
*/
//            }
            desc = title + desc;
            if (desc.length() > 0)
            {
//                desc += "<div style=\"float:right;\"><input id=\"btnEntry\" type=\"button\" value=\"alert\" onclick=\"alert(\"Hello\")\"></div>";
//                desc += "<div style=\"float:left;\"><a href=\"btnEntry\">link...</a></div>";
                showObjectHint(desc);
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void findObject()
    {
        Tree data = treeGrid.getData();
        isHintloaded = false;
        for (TreeNode serviceObj : data.getChildren(data.getRoot()))
        {
             if (!treeGrid.isSelected(serviceObj))
                  continue;
            Object serviceMap  = serviceObj.getAttributeAsObject("service");
            String serviceName = serviceMap.getClass().getName();
            if (serviceName.equals(ArcGIS93.class.getName()))
            {
                if (((ArcGIS93)serviceMap).isServiceWithHint())
                {
                    String url = ((ArcGIS93) serviceMap).UrlIdentify() + "/identify?";
                    url += "geometryType=esriGeometryPoint&tolerance=7&" +
                            "sr=102113&returnGeometry=true&f=json&layers=all:" +
                            ((ArcGIS93) serviceMap).Layers().replaceAll(", ", ",") + "&" + geObjectInfo();
                    jsonRequestHandler requestHandler = new jsonRequestHandler();
                    new JSONRequest().get(url, requestHandler);
//                    break;
                }
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
