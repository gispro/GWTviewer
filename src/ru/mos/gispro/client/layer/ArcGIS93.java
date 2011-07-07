package ru.mos.gispro.client.layer;

import java.util.ArrayList;
import java.util.List;

import ru.mos.gispro.client.*;
import ru.mos.gispro.client.json.JSONLegends;
import ru.mos.gispro.client.json.JSONLegendsIcon;
import ru.mos.gispro.client.json.JSONLegendsLayer;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

public class ArcGIS93 implements MapService
{
	private        JavaScriptObject      layer;
	public         String                name;
	private        String                url;
	private        String                urlIdentify;
	private        String                projection;
	private        List<String>          ids;
	private        boolean               isServiceVisible;
	private        String                layers;

	private        TreeNode              treeNode;
	private        Tree                  data;
	private        TreeGrid              treeGrid;

    private        float                 layerOpacity = 1;
    public         boolean               withHint = false;

    private        LayerUtils            layerUtils     = null;
    public  static String                hintLayerName  = null;
    private        String                legendURL      = null;
//    private static String                LOAD_LEGENDS   = "http://maps.gispro.ru:8080/MapServices/RESTLegends?soapUrl=<0>&f=pjson";
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public class JSONRequest
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
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private native void setLayers(JavaScriptObject layer, String layers)
    /*-{
        layer.mergeNewParams({layers: layers});
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private native void setVisibility(JavaScriptObject layer, boolean isLayoutVisible)
    /*-{
        layer.setVisibility(isLayoutVisible);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public native JavaScriptObject addArcgisMapService(String name, String address, String projection, String imageFormat)
    /*-{
        var layer = new $wnd.OpenLayers.Layer.ArcGIS93Rest( name, address,
            {
                minZoomLevel            : 4,
                maxZoomLevel            : 17,
                maxResolution           : $wnd.maxResolution,
                displayOutsideMaxExtent : "false",
                transitionEffect        : 'resize',
                transparent             : "true",
				format                  : imageFormat                
            },
            {
                wrapDateLine : "true",
                singleTile   : "true",
                ratio        : 1,
                projection   : new $wnd.OpenLayers.Projection(projection)
            });
          $wnd.map.addLayer(layer);
        return layer;
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public ArcGIS93(String name, String url, String projection, TreeNode treeNode, Tree data, TreeGrid treeGrid,
                    LayerUtils layerUtils)
    {
		this.name        = name;
		this.url         = url;
		this.urlIdentify = url;
		this.projection  = projection;
		this.treeNode    = treeNode;
		this.data        = data;
		this.treeGrid    = treeGrid;
		this.ids         = new ArrayList<String>();
		this.layers      = "";
        this.layerUtils  = layerUtils;
        if ((hintLayerName != null) && hintLayerName.equalsIgnoreCase(name))
            this.withHint = true;
        else
            this.withHint = false;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public ArcGIS93(String name, String url, String urlIdentify, String projection, TreeNode treeNode, Tree data,
                                                                 TreeGrid treeGrid, LayerUtils layerUtils)
    {
		this.name        = name;
		this.url         = url;
		this.urlIdentify = urlIdentify;
		this.projection  = projection;
		this.treeNode    = treeNode;
		this.data        = data;
		this.treeGrid    = treeGrid;
		this.ids         = new ArrayList<String>();
		this.layers      = "";
        this.layerUtils  = layerUtils;
        if ((hintLayerName != null) && hintLayerName.equalsIgnoreCase(name))
            this.withHint = true;
        else
            this.withHint = false;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public String Url()
    {
		return url;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public String UrlIdentify()
    {
		return urlIdentify;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public String Layers()
    {
		return layers;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void visibility(boolean isServiceVisible)
    {
		this.isServiceVisible = isServiceVisible;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private boolean isImage(String fpath)
	{
		return (fpath.indexOf(".tmp") == -1);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    class ServiceHandler implements JSONRequestHandler
    {
		public void onRequestComplete(JavaScriptObject content)
        {
//            com.google.gwt.user.client.Window.alert("JSONObject : " + content);
			JSONLegends json                  = (JSONLegends) content.cast();
			JsArray <JavaScriptObject> layers = json.layers().cast();
			
//          com.google.gwt.user.client.Window.alert("" + content.toString().length());

//    		System.out.println ("treeNode = " + treeNode.getAttribute("Layout") + ", data.getAllNodes(treeNode).length = " + data.getAllNodes(treeNode).length);
        	for (TreeNode node : data.getAllNodes(treeNode))
            {
        		if (node.getAttributeAsString("layerID") != null)
        		{
        			int nodeLayerID = Integer.valueOf(node.getAttributeAsString("layerID"));
        		
        			for (int i = 0; i < layers.length(); i++)
        			{
        				JSONLegendsLayer layer = (JSONLegendsLayer) layers.get(i).cast();
        				int    layerID   = layer.layerId  ();
        				if (nodeLayerID == layerID)
        				{
//        					String layerName = layer.layerName();
        					JsArray <JavaScriptObject> legends = layer.legends().cast();

//        					parse += "layerID = " + layerID + "\tlayerName = " + layerName + "\tlegends.length() = " + legends.length()+ "\n";
        					if (legends.length() == 1)
        					{
    							JSONLegendsIcon legend = (JSONLegendsIcon) legends.get(0).cast();
//    							String label = legend.label();
//    							String icon  = legend.icon ();
    							if (isImage(legend.icon ()))
    							{
    								if ((GWTViewer.config.legendsURL_old().length() > 0) &&
   										(GWTViewer.config.legendsURL_new().length() > 0))
    								{
//    									System.out.println (GWTViewer.config.legendsURL_old() + ", " + GWTViewer.config.legendsURL_new());
   										String url = legend.icon ();
   										if (url.indexOf(GWTViewer.config.legendsURL_old()) >= 0)
   											url = url.replace(GWTViewer.config.legendsURL_old(),
   													          GWTViewer.config.legendsURL_new());
//    										com.google.gwt.user.client.Window.alert("old = " + legend.icon () + "\n new =" + url);
   										node.setIcon(url);
    									
    								} else
    									node.setIcon(legend.icon ());
/*    								
    								if (GWTViewer.config.isTverAvtoDor())
    								{
   										String url = legend.icon ();
   										if (url.indexOf("http://portal:8080/") >= 0)
   											url = url.replace("http://portal:8080/", "http://94.139.241.77:8080/");
//    										com.google.gwt.user.client.Window.alert("old = " + legend.icon () + "\n new =" + url);
   										node.setIcon(url);
    								} else
    									node.setIcon(legend.icon ());
*/    								
    							}
        					}
        					else
        					{
        						for (int j = 0; j < legends.length(); j++)
        						{
        							JSONLegendsIcon legend = (JSONLegendsIcon) legends.get(j).cast();
//        							String label = legend.label();
//        							String icon  = legend.icon ();
//        							parse += "\tlabel = !" + label + "!\ticon = " + icon + "\n";

        							TreeNode legendNode = new TreeNode();
        							legendNode.setAttribute("Layout", legend.label());
        							if (isImage(legend.icon ()))
        							{
           								if ((GWTViewer.config.legendsURL_old().length() > 0) &&
       										(GWTViewer.config.legendsURL_new().length() > 0))
            								{
//        									System.out.println (GWTViewer.config.legendsURL_old() + ", " + GWTViewer.config.legendsURL_new());
           										String url = legend.icon ();
           										if (url.indexOf(GWTViewer.config.legendsURL_old()) >= 0)
           											url = url.replace(GWTViewer.config.legendsURL_old(),
           													          GWTViewer.config.legendsURL_new());
           										legendNode.setIcon(url);
            								} else
            									legendNode.setIcon(legend.icon ());
/*        								
        								if (GWTViewer.config.isTverAvtoDor())
        								{
//        									if (GWTViewer.config.withDepartment())
//        									{
       										String url = legend.icon ();
       										if (url.indexOf("http://portal:8080/") >= 0)
       											url = url.replace("http://portal:8080/", "http://94.139.241.77:8080/");
//        										com.google.gwt.user.client.Window.alert("old = " + legend.icon () + "\n new =" + url);
       										legendNode.setIcon(url);
//        									} else {
//        										node.setIcon(legend.icon ());
//        									}
        								} else
        									legendNode.setIcon(legend.icon ());
*/        								
        							}
        							legendNode.setAttribute("isNodeGroup", false);
        							legendNode.setEnabled(false);
                                    legendNode.setAttribute("canSelect", false);
        							data.add(legendNode, node);
        						}
        					}
        				}
        			}
                }
			}
			treeGrid.redraw();
//            System.out.println ("ArcGIS93.ServiceHandler : \n" + parse);
		}
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	protected void updateSelectedLayers(MapService mapService, TreeNode treeNode, boolean isSelected)
    {
		for (TreeNode childNode : data.getChildren(treeNode))
        {
			boolean defaultVisibility = childNode.getAttributeAsBoolean("defaultVisibility");
			if (defaultVisibility)
				treeGrid.selectRecord(childNode);

			if (data.hasChildren(childNode))
				updateSelectedLayers(mapService, childNode, defaultVisibility & isSelected);
			else if (defaultVisibility && isSelected)
            {
				String layerID = childNode.getAttributeAsString("layerID");
				if (layerID == null)
					continue;
				mapService.layerVisibility(layerID, true);
			}
		}
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void invalidate()
    {
		if (layer == null)
        {
			layer = addArcgisMapService(name, url + "/export", projection, GWTViewer.config.imageFormat());
//			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//			System.out.println("ARCGIS93.invalidate : name = " + name);

			legendURL = url.replace("/rest/", "/");
			
//			System.out.println ("0. ArcGIS93.invalidate : legendURL = " + legendURL);
			if ((GWTViewer.config.legendsServlet_old() != GWTViewer.config.legendsServlet_new()) &&
				(legendURL.indexOf(GWTViewer.config.legendsServlet_old()) >= 0))
				legendURL = legendURL.replace(GWTViewer.config.legendsServlet_old(), GWTViewer.config.legendsServlet_new());
//			System.out.println ("1. ArcGIS93.invalidate : legendURL = " + legendURL);
			
//			legendURL = LOAD_LEGENDS.replace("<0>", legendURL);
			legendURL = GWTViewer.config.getLegendsURL().replace("<0>", legendURL);
//			System.out.println ("2. ArcGIS93.invalidate : legendURL = " + legendURL);
			
//            com.google.gwt.user.client.Window.alert("ArcGIS93.invalidate : legendURL = " + legendURL);
            
            new JSONRequest().get(url + "?f=json", new JSONRequestHandler()
            {
				public void onRequestComplete(JavaScriptObject json)
                {
					Service service = json.cast();
					String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
					Object mapService = treeNode.getAttributeAsObject("service");

					List<TreeNode> treeNodes = new ArrayList<TreeNode>();

//                  com.google.gwt.user.client.Window.alert("ArcGIS93.JSONRequest : name = " + name + "\n url = " + url + ", json = " + json);
					for (int i = 0; i < service.layers().length(); ++i)
                    {
						TreeNode childNode = new TreeNode();
						childNode.setID(idPrefix + Integer.toString(service.layers().get(i).id()));
						childNode.setParentID(idPrefix + Integer.toString(service.layers().get(i).parentLayerId()));
						childNode.setAttribute("Layout", service.layers().get(i).name());
//    	    	        childNode.setAttribute("Layout", Integer.toString(service.layers().get(i).id()) + "_" + service.layers().get(i).name());
//        	    	    childNode.setAttribute("Layout", Integer.toString(service.layers().get(i).id()) + "_" + Boolean.toString(service.layers().get(i).defaultVisibility()) + "_" + service.layers().get(i).name());
						childNode.setAttribute("layerID", Integer.toString(service.layers().get(i).id()));
						childNode.setAttribute("defaultVisibility", service.layers().get(i).defaultVisibility());
						JsArrayInteger subLayerIds = service.layers().get(i).subLayerIds();
						childNode.setAttribute("isNodeGroup", subLayerIds == null ? false : subLayerIds.length() != 0);
						childNode.setAttribute("service", mapService);
                        treeNodes.add(childNode);
					}

					TreeNode[] nodes = new TreeNode[]{};
					nodes = treeNodes.toArray(nodes);
					data.linkNodes(nodes);

					updateSelectedLayers((MapService) mapService, treeNode, true);
                    layerUtils.rebuildStubGoogleLayer (treeGrid, url);

                    // Load Legends
    		        ServiceHandler serviceHandler = new ServiceHandler();
    		        new JSONRequest().get(legendURL, serviceHandler);
                }
			});
		}
		setLayers(layer, "show:" + layers);
		if (layer != null)
			setVisibility(layer, isServiceVisible);

		layerUtils.initLayerOrder(treeGrid);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void layerVisibility(String id, boolean isLayerVisible)
    {
		if (isLayerVisible)
        {
			if (ids.contains(id))
				return;
			ids.add(id);
			layers = ids.toString();
			layers = layers.substring(1, layers.length() - 1);
		}
        else
        {
			if (!ids.contains(id))
				return;
			ids.remove(id);
			layers = ids.toString();
			layers = layers.substring(1, layers.length() - 1);
		}
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public JavaScriptObject getLayer()
    {
		return layer;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void setLayer(JavaScriptObject layer)
    {
		this.layer = layer;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public float getLayerOpacity ()
    {
        return layerOpacity;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void  setLayerOpacity (float layerOpacity)
    {
        this.layerOpacity = layerOpacity;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public boolean isServiceWithHint()
    {
        return withHint;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String getActiveLayersList ()
    {
    	String result = ""; 
    	for (TreeNode node : data.getAllNodes(treeNode))
    	{
    		if ((treeGrid.isSelected(node) != null) && treeGrid.isSelected(node))
    		{
    			if (!node.getAttributeAsBoolean("isNodeGroup") && (node.getAttributeAsString("layerID") != null))
    			{
    				TreeNode parent = data.getParent(node);
    				if ((parent != null) && (treeGrid.isSelected(parent) != null) && treeGrid.isSelected(parent))
    				{
    					if (result.length() > 0)
    						result += ",";
    					result += node.getAttributeAsString("layerID");
//    				System.out.println (node.getAttribute("Layout") + ", layerID = " + node.getAttributeAsString("layerID") +
//    						", isSelected = " + treeGrid.isSelected(node) + ", isNodeGroup = " + 
//    						node.getAttribute("isNodeGroup") + ", " +  treeGrid.isSelected(parent));
    				}
    			}
    		}
    	}
//		System.out.println ("layers = " + result);
    	return result; // Layers();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
