package ru.mos.gispro.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.MouseMoveEvent;
import com.smartgwt.client.widgets.events.MouseMoveHandler;
import com.smartgwt.client.widgets.events.MouseUpEvent;
import com.smartgwt.client.widgets.events.MouseUpHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;
import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.client.JSONRequestHandler;
import ru.mos.gispro.client.json.JSONIdentify;
import ru.mos.gispro.client.layer.ArcGIS93;
import ru.mos.gispro.client.layer.WMS;

import java.sql.Time;

public class MouseHintHandler implements MouseMoveHandler
{
    private                    TreeGrid    treeGrid  = null ;
    private                    long        time      =  0   ;
    private                    String      marker    = ""   ;
    private                    boolean     isChecked = false;
    private                    boolean     isClosed  = true ;
    private   final   static   String      STRING_TITLE      = "\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435\u0020\u043E\u0440\u0433\u0430\u043D\u0438\u0437\u0430\u0446\u0438\u0438"; // "Название организации";
//    private   final   static   String      STRING_IDENTIFIER = "\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435\u0020\u043E\u0440\u0433\u0430\u043D\u0438\u0437\u0430\u0446\u0438\u0438"; // "Название организации";

//    private   final   static  String       HINT_TITLE_DIV_ON = "<div style=\"font-size:1.3em;align='center';width='200px';font-weight:bold;\">";
    private   final   static  String       HINT_TITLE_DIV_ON = "<div style=\"font-size:1.3em;font-weight:bold;\">";
    private   final   static  String       HINT_DIV_OFF      = "</div>";
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public MouseHintHandler (TreeGrid treeGrid)
    {
        this.treeGrid = treeGrid;
        time = System.currentTimeMillis();
        new Timer()
        {
            public void run()
            {
                String mark = getMarkerLocation();
                if (mark.equals(marker))
                {
                    if (System.currentTimeMillis() > (time + 100))
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
//            alert("0. showHint  : " + lon + ", " + lat + ", " + hint);
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
        {
            findObject();
//            String lon = marker.substring(0, idx);
//            String lat = marker.substring(idx + 1);
//            showHint(Float.valueOf(lon), Float.valueOf(lat), "<div style='font-size:.8em'>Show Hint...</div>");
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void showObjectHint (String desc)
    {
        int idx = marker.indexOf(",");
        String lon = marker.substring(0, idx);
        String lat = marker.substring(idx + 1);
//        showHint(Float.valueOf(lon), Float.valueOf(lat), "<div style='font-size:.8em'>Show Hint...</div>");
        showHint(Float.valueOf(lon), Float.valueOf(lat), "<div style='font-size:.8em'>" + desc + "</div>");
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
        if (!isChecked)
            marker = getMarkerLocation();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
    public void onMouseUp(MouseUpEvent mouseUpEvent)
    {
        marker = getMarkerLocation();
        showObjectHint();
    }
*/
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    class jsonRequestHandler implements JSONRequestHandler
    {
//        public int      request;
//        public ArcGIS93 service;
        public void onRequestComplete(JavaScriptObject json)
        {
//  com.google.gwt.user.client.Window.alert("MouseHintHandler.isObjectSelect.jsonRequestHandler ...");
//          if (activeRequest > request)
//              return;
//  com.google.gwt.user.client.Window.alert("MouseHintHandler.jsonRequestHandler...");
            JSONIdentify identify = json.cast();
//  com.google.gwt.user.client.Window.alert("MouseHintHandler.isObjectSelect.jsonRequestHandler ... : identify.results().length() = " + identify.toString()); // json.toString());
            if (identify.results().length() == 0)
            {
                closePopup();
                return;
            }
//  com.google.gwt.user.client.Window.alert("MouseHintHandler.isObjectSelect.jsonRequestHandler ... : " + identify.results().length());
//  com.google.gwt.user.client.Window.alert("MouseHintHandler.isObjectSelect ... : " + name + ", " + url);

            String desc  = "";
            String title = "";
            for (int i = 0; i < identify.results().length(); i++)
            {
//                TreeNode treeNode2 = new TreeNode();
//                treeNode2.setAttribute("Layout", identify.results().get(i).layerName());
//                treeNode2.setAttribute("item", identify.results().get(i));
                JsArrayString keys = identify.results().get(i).attributesKeys();
//              desc = desc + ", " + identify.results().get(i).layerName() + ", " + identify.results().get(i).attributesByKey("");
                for (int k = 0; k < keys.length(); ++k)
                {
                    if (!"OBJECTID".equalsIgnoreCase(keys.get(k)))
                    {
//                        record.setAttribute("field", keys.get(k));
//                        record.setAttribute("value", item.attributesByKey(keys.get(k)));
                        if (keys.get(k).equalsIgnoreCase(STRING_TITLE))
                        {
//                            desc = identify.results().get(i).attributesByKey(keys.get(k));
                            title = HINT_TITLE_DIV_ON + identify.results().get(i).attributesByKey(keys.get(k)) +
                                   HINT_DIV_OFF;
/*
    private   final   static  String       HINT_TABLE_ON     = "<table><tr><td colspan='2'>";
    private   final   static  String       HINT_TABLE_TD_END = "</td>";
    private   final   static  String       HINT_TABLE_OFF    = "</table>";

*/
                            break;
                        }
                    }
                }
                desc = title + desc;
                break;
            }
            if (desc.length() > 0)
                showObjectHint(desc);

//            TreeNode treeNode = new TreeNode();
//            treeNode.setAttribute("Layout", service.name);
/*
                        data2.add(treeNode, data2.getRoot());
                        for (int i = 0; i < identify.results().length(); ++i)
                        {
                            TreeNode treeNode2 = new TreeNode();
                            treeNode2.setAttribute("Layout", identify.results().get(i).layerName());
                            treeNode2.setAttribute("item", identify.results().get(i));
                            data2.add(treeNode2, treeNode);
                            data2.openAll();

                            if (data2.getAllNodes().length < 3)
                                tree2.selectRecord(treeNode2);
                        }
*/
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void findObject()
    {
        Tree data = treeGrid.getData();
//        com.google.gwt.user.client.Window.alert("MouseHintHandler.findObject : data.getChildren(data.getRoot()).length =  " + data.getChildren(data.getRoot()).length);
        for (TreeNode service : data.getChildren(data.getRoot()))
        {
            Object mapService = service.getAttributeAsObject("service");
            String name = mapService.getClass().getName();
            if (name.equals(ArcGIS93.class.getName()))
            {
                if (((ArcGIS93)mapService).isServiceWithHint())
                {
                    String url = ((ArcGIS93) mapService).UrlIdentify() + "/identify?";
                    url += "geometryType=esriGeometryPoint&tolerance=7&" +
                            "sr=102113&returnGeometry=true&f=json&layers=all:" +
                            ((ArcGIS93) mapService).Layers().replaceAll(", ", ",") + "&" + geObjectInfo();

//                    com.google.gwt.user.client.Window.alert("MouseHintHandler.findObject : url = " + url);
                    jsonRequestHandler requestHandler = new jsonRequestHandler();
//                  requestHandler.request = activeRequest;
//                  requestHandler.service = (ArcGIS93) mapService;
                    new JSONRequest().get(url, requestHandler);
                    break;
                }
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
