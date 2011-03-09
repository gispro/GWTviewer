package ru.mos.gispro.client.layer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.mos.gispro.client.*;
import ru.mos.gispro.client.Service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.data.WebService;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

public class ArcGIS93 implements MapService
{
	private       JavaScriptObject                 layer;
	public        String                           name;
	private       String                           url;
	private       String                           urlIdentify;
	private       String                           projection;
	private       List<String>                     ids;
	private       TreeNode                         treeNode;
	private       boolean                          isServiceVisible;
	private       String                           layers;
	private       Tree                             data;
	private       TreeGrid                         treeGrid;

    private       WebService                       zipCodeService;

    private final MapServiceInfoAsync              mapServiceInfo = GWT.create(MapServiceInfo.class);

    private       Map<String, List<LegendInfo>>    images         = new HashMap<String, List<LegendInfo>>();
    private       boolean                          isImage        = false;
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
    public native JavaScriptObject addArcgisMapService(String name, String address, String projection)
    /*-{
        var layer = new $wnd.OpenLayers.Layer.ArcGIS93Rest(
                name, address,
            {
                minZoomLevel: 4,
                maxZoomLevel: 17,
                maxResolution: $wnd.maxResolution,
                displayOutsideMaxExtent:"false",
                transitionEffect:'resize',
                transparent: "true"
            },
            {
                wrapDateLine: "true",
                singleTile: "true",
                ratio: 1,
                projection: new $wnd.OpenLayers.Projection(projection)
            });
        $wnd.map.addLayer(layer);
        return layer;
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public ArcGIS93(String name, String url, String projection, TreeNode treeNode, Tree data, TreeGrid treeGrid)
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
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public ArcGIS93(String name, String url, String urlIdentify, String projection, TreeNode treeNode, Tree data,
                                                                                    TreeGrid treeGrid)
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
			layer = addArcgisMapService(name, url + "/export", projection);

			mapServiceInfo.legendsTrue(url, new AsyncCallback<Map<String, List<LegendInfo>>>()
            {
				public void onFailure(Throwable caught)
                {
//					System.out.println("onFailure");
					for (TreeNode test : data.getAllNodes(treeNode))
                    {
						test.setIcon(null);
					}
    			}

				public void onSuccess(Map<String, List<LegendInfo>> result)
                {
					images = result;
					isImage = true;
                    // Window.alert("ArcGIS93.callBack : legendsTrue.onSuccess");
					for (TreeNode test : data.getAllNodes(treeNode))
                    {
						List<LegendInfo> legendInfos = images.get(test.getAttributeAsString("layerID"));
						if (legendInfos == null || legendInfos.size() == 0)
							test.setIcon(null);
						else
							//                            	if (legendInfos != null && legendInfos.size() != 0)
						{
							if (legendInfos.size() == 1)
								test.setIcon(legendInfos.get(0).getIcon());
							else
                            {
								test.setIcon(null);
								for (LegendInfo li : legendInfos)
                                {
									TreeNode legendNode = new TreeNode();
									legendNode.setAttribute("Layout", li.getLabel());
									legendNode.setIcon(li.getIcon());
									legendNode.setAttribute("isNodeGroup", false);
									legendNode.setEnabled(false);
									data.add(legendNode, test);
								}
							}
						}
					}
					treeGrid.redraw();
//					System.out.println("onSuccess");
				}
			});

			new JSONRequest().get(url + "?f=json",	new JSONRequestHandler()
            {
				public void onRequestComplete(JavaScriptObject json)
                {
					Service service = json.cast();
					String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
					Object mapService = treeNode.getAttributeAsObject("service");

					List<TreeNode> treeNodes = new ArrayList(); //TreeNode[service.layers().length()]

                    // int cycle = 0;
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
						String test = childNode.getIcon();

						if (!isImage)
							childNode.setIcon("ajax-loader.gif");
						else
                        {
							List<LegendInfo> legendInfos = images.get(childNode.getAttributeAsString("layerID"));
							if (legendInfos != null && legendInfos.size() != 0)
                            {
								if (legendInfos.size() == 1)
									childNode.setIcon(legendInfos.get(0).getIcon());
								else
                                {
									int index = 0;
									for (LegendInfo li : legendInfos)
                                    {
										TreeNode legendNode = new TreeNode();
										legendNode.setAttribute("Layout", li.getLabel());
										legendNode.setID(idPrefix + Integer.toString(service.layers().get(i).id()) +
                                                              "_" + Integer.toString(++index));
										legendNode.setIcon(li.getIcon());
										legendNode.setAttribute("isNodeGroup", false);
										legendNode.setEnabled(false);
										data.add(legendNode, test);
									}
								}
						    }
					    }
//                      if (!childNode.getAttribute("isNodeGroup").equalsIgnoreCase("false")) // && cycle++ < 3)
//                      {
                            // childNode.setCanExpand(false);
                           // com.google.gwt.user.client.Window.alert(childNode.getAttribute("Layout"));
//                      }
                        treeNodes.add(childNode);
					}

					TreeNode[] nodes = new TreeNode[]{};
					nodes = treeNodes.toArray(nodes);
					data.linkNodes(nodes);
//							if (treeGrid.isSelected(treeNode))
					updateSelectedLayers((MapService) mapService, treeNode, true);
				}
			});
		}
		setLayers(layer, "show:" + layers);
		if (layer != null)
			setVisibility(layer, isServiceVisible);

		LayerUtils.initLayerOrder(treeGrid);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void layerVisibility(String id, boolean isLayerVisible)
    {
//        System.out.println("Layers bef: " + layers);
		if (isLayerVisible)
        {
			if (ids.contains(id))
				return;
			ids.add(id);
			layers = ids.toString();
			layers = layers.substring(1, layers.length() - 1);
		} else
        {
			if (!ids.contains(id))
				return;
			ids.remove(id);
			layers = ids.toString();
			layers = layers.substring(1, layers.length() - 1);
		}
//        System.out.println("Layers after: " + layers);
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
}
