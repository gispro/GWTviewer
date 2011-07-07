package ru.mos.gispro.client.elements;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.MouseDownEvent;
import com.smartgwt.client.widgets.events.MouseMoveEvent;
import com.smartgwt.client.widgets.events.MouseMoveHandler;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;
import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.client.IBaseMap;
import ru.mos.gispro.client.JSONRequestHandler;
import ru.mos.gispro.client.json.JSONHintConfig;
import ru.mos.gispro.client.json.JSONIdentify;
import ru.mos.gispro.client.json.JSONIdentifyItem;
import ru.mos.gispro.client.layer.ArcGIS93;
import ru.mos.gispro.client.window.Hint;
import ru.mos.gispro.client.window.HintTreatment;
import ru.mos.gispro.client.window.HintWindow;
import ru.mos.gispro.client.window.TreatmentWindow;
import ru.mos.gispro.shared.Treatment;

public class MouseHintHandler implements MouseMoveHandler
{
    private         TreeGrid           treeGrid        = null ;
    private         long               time            =  0   ;
    private         String             marker          = ""   ;
    private         boolean            isChecked       = false;
    private         boolean            isHintloaded    = false;

    private         Hint               hint            = null ;
    private         HintTreatment      hintTreatment   = null ;
    private         Treatment          treatment       = null ;
    private         TreatmentWindow    treatmentWindow = null ;

    private         Canvas             canvas          = null ;

    private         HintWindow         hintWindow      = null ;
    private         IBaseMap           iCallback       = null ;

    private         int                mouse_x         = 0;
    private         int                mouse_y         = 0;
    private         int                OFFSET_LEFT     = 0;
    private         int                OFFSET_TOP      = 0;
    private         JsArrayString      keysArray       = null;
    private         JSONIdentifyItem   jsonItem        = null;
    
    private         boolean            cursorIsOut     = true;           
    
    public  static  int                hintDelay       = 150;
    public  final   int                TITLE_LENGTH    = 38;
    public  final   int                CONTENT_LENGTH  = 43;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public MouseHintHandler (TreeGrid treeGrid, Canvas canvas, int OFFSET_LEFT, int OFFSET_TOP, IBaseMap iCallback)
    {
        this.treeGrid    = treeGrid;
        this.canvas      = canvas;
        this.OFFSET_LEFT = OFFSET_LEFT;
        this.OFFSET_TOP  = OFFSET_TOP;
        
        if (GWTViewer.config.isMosRegion())
        	this.OFFSET_TOP  = 180;
        this.iCallback   = iCallback;

//        com.google.gwt.user.client.Window.alert("MouseHintHandler");
        new Timer()
        {
            public void run()
            {
            	if (cursorIsOut)
            		return;
                String mark = getMarkerLocation();
//                if (mark != null)
//                	com.google.gwt.user.client.Window.alert("MouseHintHandler.run : mark = " + mark);
                if ((mark != null) && mark.equals(marker))
                {
                	if (time == 0)
                	{
                		time = System.currentTimeMillis();
                	}
                	else if (System.currentTimeMillis() > (time + hintDelay))
                	{
//                		System.out.println ("MouseHintHandler.run : isChecked = " + isChecked + ", mark = " + mark + ", marker = " + marker);
                		if (!isChecked)
                		{
                			isChecked = true;
                			time      = 0;
//                			System.out.println ("MouseHintHandler.run : hintDelay = " + hintDelay + ", time = " + time + 
//                            	                ", System.currentTimeMillis() = " + System.currentTimeMillis() + " , " +  
//                            		                (System.currentTimeMillis() > (time + hintDelay)));
//                			com.google.gwt.user.client.Window.alert("MouseHintHandler.onTimer :\n" +
//                                                                     marker + "\n" + mark + "\n\n" + time + // "\n" + System.currentTimeMillis() + "\n delta = " +
//                                                                     (System.currentTimeMillis() - time));
                			findObjectHint();
//             				time = System.currentTimeMillis();
                		}
                	}
                }
            }
        }.scheduleRepeating(hintDelay);
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
        var str = null;
        if (mouse != null)
        {
        	var point = $wnd.map.getLonLatFromPixel(mouse.lastXy);
        	if (point != null)
        	{
        		str = "mapExtent=" + extent.left + "," + extent.bottom + "," + extent.right + "," + extent.top + "&";
        		str = str + "geometry=" + point.lon + "," + point.lat + "&";
        		str = str + "imageDisplay=" + size.w + "," + size.h + "," + "96";
        	}
        }
        return str;
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private native String getMarkerLocation()
    /*-{
        var mouse;
        for (indexControl = 0; indexControl < $wnd.map.controls.length; ++indexControl)
        {
            if ($wnd.map.controls[indexControl].displayClass == "olControlMousePosition")
            {
                mouse = $wnd.map.controls[indexControl];
                break;
            }
        }
        var point = null;
        if (mouse != null)
        	point = $wnd.map.getLonLatFromPixel(mouse.lastXy);
        if (point != null)
        	return point.lon + "," + point.lat;
        else
            return null;
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void findObjectHint ()
    {
    	if (isChecked)
    	{
//            System.out.println ("MouseHintHandler.findObjectHint");
    		int idx = marker.indexOf(",");
    		if (idx > 0)
    			findObject();
    	}
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
    public void onMouseMoveOut(MouseOutEvent event)
    {
/*    	
        if (((hint != null) && hint.isVisible() && !hint.isPointInside(event.getX(), event.getY())) ||
       		((hintTreatment != null) && hintTreatment.isVisible() && !hintTreatment.isPointInside(event.getX(), event.getY())))
        {
            cursorIsOut = true;
        	hideHint();
        }
*/        
    	cursorIsOut = true;
        if ((hint != null) && hint.isVisible() && !hint.isPointInside(event.getX(), event.getY()))
        	hideHint();
        if ((hintTreatment != null) && hintTreatment.isVisible() && !hintTreatment.isPointInside(event.getX(), event.getY()))
        	hideHint();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void onMouseMoveEntry()
    {
        cursorIsOut = false;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void onMouseMove (MouseMoveEvent event)
    {
        marker = getMarkerLocation();
        time   = 0;
        if (!isChecked && ((hint == null) || !hint.isPointInside(event.getX(), event.getY())) &&
        		          ((hintTreatment == null) || !hintTreatment.isPointInside(event.getX(), event.getY())))
        {
            mouse_x = event.getX();
            mouse_y = event.getY();
        }
       	isChecked = false;
//        System.out.println ("MouseHintHandler.onMouseMove : " + event.getX() + ", " + event.getY());
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setLayoutsPanelWidth (int w)
    {
    	this.OFFSET_LEFT = w;
       	if (hint != null)
            hint.setOffsetParams(this.OFFSET_LEFT, this.OFFSET_TOP);
       	if (hintTreatment != null)
       		hintTreatment.setOffsetParams(this.OFFSET_LEFT, this.OFFSET_TOP);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void showObjectHint (String desc)
    {
    	if (!isChecked)
    		return;
    	
   		isChecked = false;
    	time      = 0;
//    	System.out.println ("MouseHintHandler.showObjectHint");
    	if (hint == null)
        {
            hint = new Hint();
            hint.setOffsetParams(this.OFFSET_LEFT, this.OFFSET_TOP);
            canvas.addChild(hint);
        }
        hint.setVisible(true);
//      System.out.println ("showObjectHint : mouse_x = " + mouse_x + ", canvas.getWidth() = " + canvas.getWidth());
//      System.out.println ("showObjectHint : mouse_y = " + mouse_y + ", canvas.getHeight() = " + canvas.getHeight());
        
        int x = mouse_x;
        int y = mouse_y;
        if ((canvas.getWidth() + hint.OFFSET_LEFT - mouse_x - Hint.WIDTH) < 0)
        	x = mouse_x - Hint.WIDTH;
        if ((canvas.getHeight() + hint.OFFSET_TOP) < (mouse_y + Hint.HEIGTH))
        	y = mouse_y - Hint.HEIGTH;

// System.out.println ("MouseHintHandler.showObjectHint : OFFSET_LEFT = " + this.OFFSET_LEFT + ", hint.OFFSET_LEFT = " + hint.OFFSET_LEFT);
        
        hint.setText(desc, x, y);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void hideHint()
    {
        if (hint != null)
            hint.setVisible(false);
        if (hintTreatment != null)
        	hintTreatment.setVisible(false);
        marker = "";
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public boolean isHintVisible()
    {
        return ((hint != null) && hint.isVisible());
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public boolean isHintTreatmentVisible()
    {
        return ((hintTreatment != null) && hintTreatment.isVisible());
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void showFullInfo ()
    {
//        com.google.gwt.user.client.Window.alert("MouseHintHandler.showFullInfo ...");
        if (hintWindow == null)
            hintWindow = new HintWindow();
        hintWindow.showData(jsonItem, keysArray);
        hintWindow.show();
        hideHint();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void showFullTreatment ()
    {
        if (treatmentWindow == null)
        	treatmentWindow = new TreatmentWindow(iCallback);
        treatmentWindow.showData(treatment);
        treatmentWindow.show();
        hideHint();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public boolean isHintWindowClicked(MouseDownEvent mouseDownEvent)
    {
        if (hint == null)
            return false;
        else
        {
//            com.google.gwt.user.client.Window.alert("MouseHintHandler.isHintWindowClicked : " + hint.isPointInside(mouseDownEvent.getX(), mouseDownEvent.getY()));
            return hint.isPointInside(mouseDownEvent.getX(), mouseDownEvent.getY());
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public boolean isHintTreatmentClicked(MouseDownEvent mouseDownEvent)
    {
        if (hintTreatment == null)
            return false;
        else
        {
//            com.google.gwt.user.client.Window.alert("MouseHintHandler.isHintWindowClicked : " + hint.isPointInside(mouseDownEvent.getX(), mouseDownEvent.getY()));
            return hintTreatment.isPointInside(mouseDownEvent.getX(), mouseDownEvent.getY());
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    class jsonRequestHandler implements JSONRequestHandler
    {
        public void onRequestComplete(JavaScriptObject json)
        {
            JSONIdentify identify = json.cast();
//            System.out.println ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nonRequestComplete : " + identify.results().length());
            if ((identify.results().length() == 0) && !isHintloaded)
            {
//                closePopup();
                hideHint();
                return;
            }
            if (isHintloaded)
                return;

//           	System.out.println ("MouseHintHandler.jsonRequestHandler 0 ...");
            isHintloaded = true;
            String desc  = "";
            String title = null;
            int    idx   = -1;
//             System.out.println ("GWTViewer.hintHeader.hintDesc().length() = " + GWTViewer.hintHeader.hintDesc().length());
            int layerNumber = 0;
            for (int i = 0; i < identify.results().length(); i++)
            {
                for (int j = 0; j < GWTViewer.hintHeader.hintDesc().length(); j++)
                {
                    JSONHintConfig hint = GWTViewer.hintHeader.hintItem(j).cast();
//                    System.out.println ("" + i + ". hint.subLayer() = " + hint.subLayer() + ", " + identify.results().get(i).layerName());
                    if (hint.isTitle() && hint.subLayer().trim().equalsIgnoreCase(identify.results().get(i).layerName()))
                    {
                        idx = i;
                        layerNumber = hint.layerNumber();
                        break;
                    }
                }
                if (idx >= 0)
                    break;
            }
//            System.out.println ("idx = " + idx + ", layerNumber = " + layerNumber);
            if (idx == -1)
            	return;

            keysArray = identify.results().get(idx).attributesKeys();
            jsonItem  = identify.results().get(idx);
            
            for (int k = 0; k < keysArray.length(); k++)
            {
                if (title == null)
                {
//                	System.out.println ("GWTViewer.hintHeader.hintDesc().length() = " + GWTViewer.hintHeader.hintDesc().length());
                	for (int j = 0; j < GWTViewer.hintHeader.hintDesc().length(); j++)
                    {
//                      System.out.println ("\tj = " + j);
                        JSONHintConfig hint = GWTViewer.hintHeader.hintItem(j).cast();
                        if (hint.isTitle() && (hint.layerNumber() == layerNumber))
                        {
/*                        	
                        	System.out.println ("\tk = " + k + ", j = " + j + 
                        			            ", keysArray.get(k).trim() = " + keysArray.get(k).trim() + 
                        			            ", hint.identifier() = " + hint.identifier() +
                        			            ", layerNumber = " + layerNumber);
*/                        	
                            if (keysArray.get(k).trim().equalsIgnoreCase(hint.identifier()))
                            {
                                layerNumber = hint.layerNumber();
                                title = identify.results().get(idx).attributesByKey(keysArray.get(k));
                                if (title.length() > TITLE_LENGTH)
                                    title = title.substring(0, TITLE_LENGTH - 2) + "...";
                                title = hint.html().replace("<0>", title);
                                break;
                            }
                        }
                    }
                } else
                	break;
            }
//          System.out.println ("layerNumber = " + layerNumber + ", title= " + title);

            if (title != null)
            {
                for (int k = 0; k < keysArray.length(); ++k)
                {
                    for (int j = 0; j < GWTViewer.hintHeader.hintDesc().length(); j++)
                    {
                        JSONHintConfig hint = GWTViewer.hintHeader.hintItem(j).cast();
                        if ((hint.layerNumber() == layerNumber) && (!hint.isTitle()))
                        {
                            if ((keysArray.get(k).trim().equalsIgnoreCase(hint.identifier())))
                            {
                            	String temp = hint.html().replace("<0>", identify.results().get(idx).attributesByKey(keysArray.get(k)));
                            	
                            	int    anf	= temp.indexOf(">&nbsp;") + ">&nbsp;".length(); 
                            	int    end	= temp.indexOf("</div>");
//                            	System.out.println ("anf = " + anf + ", end= " + end + ", temp = " + temp);
                            	String txt  = temp.substring(anf, end);

                            	if (txt.length() > CONTENT_LENGTH)
                            	{
                            		int len = txt.length() - CONTENT_LENGTH; 
                            		txt = identify.results().get(idx).attributesByKey(keysArray.get(k));

//                            		System.out.println ("txt = " + txt + ", len = " + len + ", temp = " + temp);
                            		txt = txt.substring(0, txt.length() - len - 2) + "...";
                            		temp = hint.html().replace("<0>", txt);
                            	}

                            	desc += temp;
                            }
                        }
                    }
                }
            }
            if (isChecked)
            {
            	if ((title != null) && (desc.length() > 0))
            	{
//                   	System.out.println ("MouseHintHandler.jsonRequestHandler 1 ...");
            		desc = title + desc;
            		if (desc.length() > 0)
            			showObjectHint(desc);
            	}
            	else
            		isHintloaded = false;
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void findObject()
    {
    	if ((iCallback != null) && iCallback.isIdentifySelected())
    		return;
    		
        Tree data = treeGrid.getData();
        isHintloaded = false;
        treatment = null;
        if (iCallback != null)
        	treatment = iCallback.isTreatmentChoosed(marker);
//       	System.out.println ("MouseHintHandler : treatment = " + treatment);
        if (treatment == null)
        {
        	if ((hintTreatment != null) && hintTreatment.isVisible())
//        	{
//             	System.out.println ("MouseHintHandler : findObject - treatment = " + treatment + ", hintTreatment = " + hintTreatment + ", hintTreatment.isVisible() = " + hintTreatment.isVisible());
        		hintTreatment.setVisible(false);
//        	}
//           	System.out.println ("MouseHintHandler : marker = " + marker);
        	for (TreeNode serviceObj : data.getChildren(data.getRoot()))
        	{
        		if ((treeGrid.isSelected(serviceObj) == null) || !treeGrid.isSelected(serviceObj))
        			continue;

        		Object serviceMap  = serviceObj.getAttributeAsObject("service");
        		if (serviceMap != null)
        		{
        			String serviceName = serviceMap.getClass().getName();
        			if (serviceName.equals(ArcGIS93.class.getName()))
        			{
        				if (((ArcGIS93)serviceMap).isServiceWithHint())
        				{
        					String url = ((ArcGIS93) serviceMap).UrlIdentify() + "/identify?";
        					url += "geometryType=esriGeometryPoint&tolerance=7&" +
                                   "sr=102113&returnGeometry=true&f=json&layers=all:" + 
                                   ((ArcGIS93) serviceMap).getActiveLayersList () + "&" + geObjectInfo();
        					jsonRequestHandler requestHandler = new jsonRequestHandler();
//                        	System.out.println ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nfindObject : " + url);
        					new JSONRequest().get(url, requestHandler);
        				}
        			}
        		}
        	}
        }
        else
        {
        	if (!isChecked)
        		return;
        	if ((hint != null) && hint.isVisible())
           		 hint.setVisible(false);
        	
        	isChecked = false;
        	time      = 0;
 //       	System.out.println ("0. MouseHintHandler.showObjectHint");
        	if (hintTreatment == null)
            {
        		hintTreatment = new HintTreatment();
        		hintTreatment.setOffsetParams(this.OFFSET_LEFT, this.OFFSET_TOP);
                canvas.addChild(hintTreatment);
            }
//          System.out.println ("showObjectHint : mouse_x = " + mouse_x + ", canvas.getWidth() = " + canvas.getWidth());
//          System.out.println ("showObjectHint : mouse_y = " + mouse_y + ", canvas.getHeight() = " + canvas.getHeight());
            
            int x = mouse_x;
            int y = mouse_y;
            if ((canvas.getWidth() + hintTreatment.OFFSET_LEFT - mouse_x - HintTreatment.WIDTH) < 0)
            	x = mouse_x - HintTreatment.WIDTH;
            if ((canvas.getHeight() + hintTreatment.OFFSET_TOP) < (mouse_y + HintTreatment.HEIGTH))
            	y = mouse_y - HintTreatment.HEIGTH;

    // System.out.println ("MouseHintHandler.showObjectHint : OFFSET_LEFT = " + this.OFFSET_LEFT + ", hint.OFFSET_LEFT = " + hint.OFFSET_LEFT);
//    		com.google.gwt.user.client.Window.alert("MouseHintHandler - loadTreatmentDesc : treatment.getCategory() = " + treatment.getCategory());
            if (treatment.getCategory() == null)
            {
                GWTViewer.MapServiceInfoServlet.loadTreatmentDesc(treatment.getId(), new AsyncCallback<String>()
                        {
                        	public void onFailure(Throwable caught)
                        	{
                        		com.google.gwt.user.client.Window.alert("MouseHintHandler - loadTreatmentDesc : onFailure = " + caught);
                        	}
                        	public void onSuccess(String content)
                        	{
//                        		com.google.gwt.user.client.Window.alert("MouseHintHandler - loadTreatmentDesc : onSuccess = " + content);
//                            	System.out.println ("0. MouseHintHandler.showObjectHint : content = " + content);
                        		iCallback.setTreatmentDesc(treatment, content);
                        	}
                        });
            }
            if ((treatment.getCategory() != null) && (treatment.getCategory().trim().length() > 0))
            {
            	hintTreatment.setText(treatment, x, y);
            	hintTreatment.setVisible(true);
//            	System.out.println ("1. MouseHintHandler.showObjectHint : treatment.getCategory() = " + treatment.getCategory());
            } else
            	hintTreatment.setVisible(false);
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
