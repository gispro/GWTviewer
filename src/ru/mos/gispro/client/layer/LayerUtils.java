package ru.mos.gispro.client.layer;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;
import ru.mos.gispro.client.GWTViewer;

import java.util.ArrayList;
import java.util.List;

public class LayerUtils
{ 
    public    final   static    String      ATTRIBUTE_LAYOUT          = "Layout";
    public    final   static    String      String_service            = "service";
    public    final   static    String      String_isService          = "isService";

    public                      String      baseLayerURL              = null;
    private                     boolean     isAllServicesLoaded       = false;
    public             JavaScriptObject     stubGoogleLayer           = null;

    public                      TreeNode[]  baseMaps                  = {null, null, null, null, null, null, null};

    public                      String[][]  baseMapsCaptions          = {{"", ""},
                                                                         {"Google Карта"    , "Google streets"      },
                                                                         {"Google Гибрид"   , "Google hybrid"       },
                                                                         {"Google Спутник"  , "Google satellite"    },
                                                                         {"Bing Map Карта"  , "Bing Map Road"       },
                                                                         {"Bing Map Гибрид" , "Bing Maps Hybrid"    },
                                                                         {"Bing Map Спутник", "Bing Maps Satellite"}};
    public    final   static    int         BASEMAP_COMMON            = 0;
    public    final   static    int         BASEMAP_GOOGLE_STREETS    = 1;
    public    final   static    int         BASEMAP_GOOGLE_HYBRID     = 2;
    public    final   static    int         BASEMAP_GOOGLE_SATTELITE  = 3;
    public    final   static    int         BASEMAP_BINGMAP_STREETS   = 4;
    public    final   static    int         BASEMAP_BINGMAP_HYBRID    = 5;
    public    final   static    int         BASEMAP_BINGMAP_SATTELITE = 6;
    private                     boolean     isExpanded                = false; // true; //  
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public LayerUtils(){};
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void addArcGIS93Layer(String name, String url, TreeGrid treeGrid, Boolean select,
                                        LayerUtils layerUtils)
    {
		addArcGIS93Layer(name, url, url, treeGrid, select, layerUtils);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static native void setLayerZOrder(JavaScriptObject layer, int order)
    /*-{
        layer.setZIndex(order);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static native void setLayerOpacity(JavaScriptObject layer, float opacity)
    /*-{
        layer.setOpacity(opacity);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static float getLayerOpacity(MapService service)
    {
        if ((service instanceof ArcGIS93) || (service instanceof WMS))
            return service.getLayerOpacity();
        else
            return 1;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void addArcGIS93Layer(String name, String url, TreeGrid baseTree, LayerUtils layerUtils)
    {
		baseMaps[BASEMAP_COMMON] = new TreeNode();
		baseMaps[BASEMAP_COMMON].setAttribute(ATTRIBUTE_LAYOUT, name + " ");
		String idPrefix = Integer.toString(baseMaps[BASEMAP_COMMON].hashCode()) + "_";
		baseMaps[BASEMAP_COMMON].setID(idPrefix + "-1");

        baseMaps[BASEMAP_COMMON].setAttribute(String_service, new ArcGIS93 (name, url, "", "EPSG:102113",
                                              baseMaps[BASEMAP_COMMON], baseTree.getData(), baseTree, layerUtils));
        baseMaps[BASEMAP_COMMON].setAttribute (String_isService, true);

        baseTree.getData().add(baseMaps[BASEMAP_COMMON], baseTree.getData().getRoot());
        baseTree.selectRecord (baseMaps[BASEMAP_COMMON]);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void addArcGIS93Layer(String name, String url, String urlIdentify, TreeGrid treeGrid, boolean select,
                                                                                                 LayerUtils layerUtils)
    {
		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute(ATTRIBUTE_LAYOUT, name + " ");
		String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");

		treeNode.setAttribute(String_service, new ArcGIS93 (name, url, urlIdentify, "EPSG:102113", treeNode,
                                                                       treeGrid.getData(), treeGrid, layerUtils));
        treeNode.setAttribute(String_isService, true);

        treeGrid.getData().add(treeNode, treeGrid.getData().getRoot());

        treeGrid.selectRecord(treeNode);
        if (!select)
            treeGrid.deselectRecord(treeNode);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void addGoogleStreetsLayer(TreeGrid treeGrid, JavaScriptObject layer)
    {
        stubGoogleLayer = layer;
        addGoogleLayer(treeGrid, BASEMAP_GOOGLE_STREETS, GoogleMaps.MapTypeId.ROADMAP, layer);
////       ((MapService) baseMaps[BASEMAP_GOOGLE_STREETS].getAttributeAsObject(String_service)).invalidate();
//        treeGrid.selectRecord  (baseMaps[BASEMAP_GOOGLE_STREETS]);
//        treeGrid.deselectRecord(baseMaps[BASEMAP_GOOGLE_STREETS]);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void addGoogleSatelliteLayer(TreeGrid treeGrid)
    {
        addGoogleLayer(treeGrid, BASEMAP_GOOGLE_SATTELITE, GoogleMaps.MapTypeId.SATELLITE, null);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void addGoogleHybridLayer(TreeGrid treeGrid)
    {
        addGoogleLayer(treeGrid, BASEMAP_GOOGLE_HYBRID, GoogleMaps.MapTypeId.HYBRID, null);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void addGoogleLayer(TreeGrid treeGrid, int idx, GoogleMaps.MapTypeId type, JavaScriptObject layer)
    {
        baseMaps[idx] = new TreeNode();
        baseMaps[idx].setAttribute(ATTRIBUTE_LAYOUT,  baseMapsCaptions[idx][0]);
        String idPrefix = Integer.toString(baseMaps[idx].hashCode()) + "_";
        baseMaps[idx].setID(idPrefix + "-1");
        if (layer == null)
            baseMaps[idx].setAttribute(String_service, new GoogleMaps(baseMapsCaptions[idx][1], type));
        else
            baseMaps[idx].setAttribute(String_service, new GoogleMaps(layer, baseMapsCaptions[idx][1], type));
        baseMaps[idx].setAttribute(String_isService, true);
//        baseMaps[idx].setIcon(GLOBE_ICON);
        treeGrid.getData().add(baseMaps[idx], treeGrid.getData().getRoot());
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void addBingMapRoadLayer(TreeGrid treeGrid)
    {
        addBingMapLayer(treeGrid, BASEMAP_BINGMAP_STREETS, BingMaps.MapTypeId.Road);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void addBingMapHybridLayer(TreeGrid treeGrid)
    {
        addBingMapLayer(treeGrid, BASEMAP_BINGMAP_HYBRID, BingMaps.MapTypeId.Hybrid);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void addBingMapSatelliteLayer(TreeGrid treeGrid)
    {
        addBingMapLayer(treeGrid, BASEMAP_BINGMAP_SATTELITE, BingMaps.MapTypeId.Aerial);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void addBingMapLayer(TreeGrid treeGrid, int idx, BingMaps.MapTypeId type)
    {
        baseMaps[idx] = new TreeNode();
        baseMaps[idx].setAttribute(ATTRIBUTE_LAYOUT, baseMapsCaptions[idx][0]);
        String idPrefix = Integer.toString(baseMaps[idx].hashCode()) + "_";
        baseMaps[idx].setID(idPrefix + "-1");
        baseMaps[idx].setAttribute(String_service  , new BingMaps(baseMapsCaptions[idx][1], type));
        baseMaps[idx].setAttribute(String_isService, true);
//      baseMaps[idx].setIcon(GLOBE_ICON);
        treeGrid.getData().add(baseMaps[idx], treeGrid.getData().getRoot());
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void addWMSLayer(String name, String url, String layerName, TreeGrid treeGrid, Boolean select)
    {
		Tree data = treeGrid.getData();

		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute(ATTRIBUTE_LAYOUT, name);
		String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");
		treeNode.setAttribute(String_service  , new WMS(name, url, layerName, "EPSG:900913"));
		treeNode.setAttribute(String_isService, true);

		data.add(treeNode, data.getRoot());
		if (select)
			treeGrid.selectRecord(treeNode);
	}
   //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void addOSMLayer(TreeGrid treeGrid)
    {
		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute(ATTRIBUTE_LAYOUT, "Open street map");
		String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");
		treeNode.setAttribute(String_service  , new OSM("Open street map"));
		treeNode.setAttribute(String_isService, true);
		treeGrid.getData().add(treeNode, treeGrid.getData().getRoot());
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void setLayerZIndex(List<TreeNode> nodes)
    {
        for (int k = 0; k < nodes.size(); k++)
        {
            String service = (String) nodes.get(k).getAttribute(String_service);
            if (service != null)
            {
                JavaScriptObject layer = ((MapService)nodes.get(k).getAttributeAsObject(String_service)).getLayer();
                if (layer == null)
                    continue;
                setLayerZOrder(layer, -k - 1000);
//              setLayerZOrder(layer, 1000 - k);
            }
        }
//        com.google.gwt.user.client.Window.alert("LayerUtils.initLayerOrder : rootNodes.size() = " + nodes.size());
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void initLayerOrder(TreeGrid treeGrid)
    {
		TreeNode       root      = treeGrid.getTree().getRoot();
		List<TreeNode> rootNodes = new ArrayList<TreeNode>();
		TreeNode[]     nodes     = treeGrid.getTree().getChildren(root);

		for (TreeNode n : nodes)
        {
            if (treeGrid.getTree().getParent(n) != root)
                continue;
   			rootNodes.add(n);
		}
        for (int i = 0; i < baseMaps.length; i++)
        {
            if (baseMaps[i] != null)
                rootNodes.add(baseMaps[i]);
//    		System.out.println ("1." + i + " initLayerOrder : baseMaps[i] = " + baseMaps[i].getAttribute("Layout"));
        }
        setLayerZIndex(rootNodes);

        if (GWTViewer.project.getConfigFile().equalsIgnoreCase("MosRegion"))
        {
//        	com.google.gwt.user.client.Window.alert("0. LayerUtils - GWTViewer.config.layers().length() : " + GWTViewer.config.layers().length() + ", nodes.length = " + nodes.length);
        	if (nodes.length >= GWTViewer.config.layers().length() - 1)
        	{
//            	com.google.gwt.user.client.Window.alert("1. LayerUtils ... ");
        		expandTreeNode (treeGrid);
        		if (GWTViewer.TREATMENT_ON)
        			addTreatmentNode (treeGrid);
        	}
        }
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void rebuildStubGoogleLayer (TreeGrid treeGrid, String url)
    {
        if (!isAllServicesLoaded && url.equalsIgnoreCase(baseLayerURL))
        {
            isAllServicesLoaded = true;
           	if ((stubGoogleLayer != null) && (baseMaps[BASEMAP_GOOGLE_STREETS] != null))
           	{
           		treeGrid.selectRecord  (baseMaps[BASEMAP_GOOGLE_STREETS]);
           		treeGrid.deselectRecord(baseMaps[BASEMAP_GOOGLE_STREETS]);
           		setLayerOpacity(stubGoogleLayer, 1);
           	}
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void expandTreeNode (TreeGrid treeGrid)
    {
        if (!isExpanded)
        {
            TreeNode[] nodes = treeGrid.getTree().getChildren(treeGrid.getTree().getRoot());
            int idx = 0;
            for (TreeNode n : nodes)
            {
                if ((idx == 0) || (idx == 2) || (idx == 3))
                {
                    treeGrid.getData().openFolder(n);
                    if ((idx == 2) && !isExpanded)
                    {
                        TreeNode[] chidren = treeGrid.getTree().getChildren(n);
                        if (chidren.length > 0)
                        {
//                        com.google.gwt.user.client.Window.alert("expandTreeNode = " + chidren.length);
                            for (TreeNode ch : chidren)
//                            {
                                treeGrid.getData().openFolder(ch);
//                            }
                            isExpanded = true;
                        }
                    }
//                com.google.gwt.user.client.Window.alert("expandTreeNode = " + n.getAttribute(LayerUtils.ATTRIBUTE_LAYOUT));
                }
                idx++;
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void addTreatmentNode (TreeGrid treeGrid)
    {
//    	com.google.gwt.user.client.Window.alert("0. LayerUtils.addTreatmentNode");
    	if (GWTViewer.treatmentNode == null)
    	{
//        	com.google.gwt.user.client.Window.alert("1. LayerUtils.addTreatmentNode");

        	GWTViewer.treatmentNode = new TreeNode();
    		GWTViewer.treatmentNode.setAttribute("id"            , "treatmentNode"      );
    		GWTViewer.treatmentNode.setAttribute(ATTRIBUTE_LAYOUT, "\u041E\u0431\u0440\u0430\u0449\u0435\u043D\u0438\u044F\u0020\u043D\u0430\u0441\u0435\u043B\u0435\u043D\u0438\u044F"); // "Обращения населения");
//    		GWTViewer.treatmentNode.setAttribute(String_service  , ""                   );
//    		GWTViewer.treatmentNode.setAttribute(String_isService, false                );
    		GWTViewer.treatmentNode.setAttribute("layerID"       , ""                   );
    		GWTViewer.treatmentNode.setTitle    ("\u041E\u0431\u0440\u0430\u0449\u0435\u043D\u0438\u044F\u0020\u043D\u0430\u0441\u0435\u043B\u0435\u043D\u0438\u044F"); // "Обращения населения");
    		treeGrid.getData().add(GWTViewer.treatmentNode, treeGrid.getData().getRoot());
    		
    	
    		TreeNode legendNode0 = new TreeNode();
    		legendNode0.setAttribute(ATTRIBUTE_LAYOUT, "\u0415\u0434\u0438\u043D\u0438\u0447\u043D\u043E\u0435\u0020\u043E\u0431\u0440\u0430\u0449\u0435\u043D\u0438\u0435"); // Единичное обращение");
    		legendNode0.setAttribute("isNodeGroup", false);
    		legendNode0.setEnabled(false);
    		legendNode0.setAttribute("canSelect", false);
    		legendNode0.setIcon("marker-green.png");
            treeGrid.getData().add(legendNode0, GWTViewer.treatmentNode);

    		TreeNode legendNode1 = new TreeNode();
    		legendNode1.setAttribute(ATTRIBUTE_LAYOUT, "\u041F\u043E\u0434\u0434\u0435\u0440\u0436\u0430\u043D\u043D\u043E\u0435\u0020\u043E\u0431\u0440\u0430\u0449\u0435\u043D\u0438\u0435"); // Поддержанное обращение");
    		legendNode1.setAttribute("isNodeGroup", false);
    		legendNode1.setEnabled(false);
    		legendNode1.setAttribute("canSelect", false);
    		legendNode1.setIcon("marker-gold.png");
            treeGrid.getData().add(legendNode1, GWTViewer.treatmentNode);

    		TreeNode legendNode2 = new TreeNode();
    		legendNode2.setAttribute(ATTRIBUTE_LAYOUT, "\u041F\u043E\u0434\u0434\u0435\u0440\u0436\u0430\u043D\u043D\u043E\u0435\u0020\u043C\u043D\u043E\u0433\u0438\u043C\u0438\u0020\u043E\u0431\u0440\u0430\u0449\u0435\u043D\u0438\u0435"); // Поддержанное многими обращение");
    		legendNode2.setAttribute("isNodeGroup", false);
    		legendNode2.setEnabled(false);
    		legendNode2.setAttribute("canSelect", false);
    		legendNode2.setIcon("marker-red.png");
            treeGrid.getData().add(legendNode2, GWTViewer.treatmentNode);
            
            treeGrid.getData().openFolder(GWTViewer.treatmentNode);
            
			treeGrid.selectRecord (GWTViewer.treatmentNode);
    	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
