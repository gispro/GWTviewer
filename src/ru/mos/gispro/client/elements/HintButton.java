package ru.mos.gispro.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.LayoutResizeBarPolicy;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Canvas;
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
import ru.mos.gispro.client.window.Contractors;

/**
 * User: dima
 * Date: 20.11.2010
 * Time: 15:49:27
 */
public class HintButton extends ToolStripButton
{
	private                   HandlerRegistration     handlerRegistration;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public native void goURL(String url)
    /*-{
		$wnd.window.open(url);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	protected native void reactivateControls()
    /*-{
        for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
        {
            if ($wnd.map.controls[indexControl].displayClass != "olControlNavigationHistory")
                $wnd.map.controls[indexControl].deactivate();
            if ($wnd.map.controls[indexControl].displayClass == "olControlMousePosition")
                $wnd.map.controls[indexControl].activate();
        }
    }-*/;
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
    private native String getInfo()
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
    private native void showHint()
    /*-{
           $wnd.onFeatureSelect(null);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public HintButton(final TreeGrid treeGrid, final Canvas canvas)
    {
		final Tree data = treeGrid.getTree();

		this.setIcon("MActionIdentify.png");
		this.setIconSize(24);
		this.setHeight(30);
		this.setActionType(SelectionType.RADIO);
		this.setRadioGroup("mapAction");

		this.addClickHandler(new ClickHandler()
        {
//			Window      winModal;
//			boolean     isPointSelected = false;
			TreeGrid    tree2;
			ListGrid    list2;
			Tree        data2;
			RecordList  data3;
            int         activeRequest = 0;
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            private void createHandlerRegistration()
            {
                handlerRegistration = canvas.addClickHandler(new ClickHandler()
                {
                    public void onClick(ClickEvent event)
                    {
                        com.google.gwt.user.client.Window.alert("IdentifyButton : " + isSelected());
                        if (isSelected())
                        {
                            showHint();
                            return;
                        }
                        com.google.gwt.user.client.Window.alert("IdentifyButton : " + isSelected());
                        if (!isSelected()) return;

//                        winModal.show();
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
                            catch (Exception e) {continue;}

                            Object mapService = service22.getAttributeAsObject("service");
                            String name = mapService.getClass().getName();
                            if (name.equals(ArcGIS93.class.getName()))
                            {
                                String url = ((ArcGIS93) mapService).UrlIdentify() + "/identify?";
                                url += "geometryType=esriGeometryPoint&tolerance=7&" +
                                        "sr=102113&returnGeometry=true&f=json&layers=all:" +
                                        ((ArcGIS93) mapService).Layers().replaceAll(", ", ",") + "&" + getInfo();
//                                if (GWTViewer.config.debug_InfoURL_Alert())
//                                    com.google.gwt.user.client.Window.alert("IdentifyButton\n" + url);

                                class jsonRequestHandler implements JSONRequestHandler
                                {
                                    public int      request;
                                    public ArcGIS93 service;

                                    public void onRequestComplete(JavaScriptObject json)
                                    {
                                        if (activeRequest > request)
                                            return;
                                        JSONIdentify identify = json.cast();
                                        if (identify.results().length() == 0)
                                            return;

                                        TreeNode treeNode = new TreeNode();
                                        treeNode.setAttribute("Layout", service.name);
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
                                    }
                                }
                                jsonRequestHandler requestHandler = new jsonRequestHandler();
                                requestHandler.request = activeRequest;
                                requestHandler.service = (ArcGIS93) mapService;
                                new JSONRequest().get(url, requestHandler);
                            }
                        }
                    }
                });
            }
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			public void onClick(ClickEvent event)
            {
//              com.google.gwt.user.client.Window.alert("IdentifyButton");
//				Document.get().getElementById("map").getStyle().setCursor(isSelected() ? Style.Cursor.CROSSHAIR : Style.Cursor.DEFAULT);
				reactivateControls();
				if (isSelected())
                    createHandlerRegistration();
				else
					handlerRegistration.removeHandler();

//				if (!isPointSelected)
//					return;
			}
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		});
	}
}
