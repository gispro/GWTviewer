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

//    public    final   static    String      GLOBE_ICON                = "globe-green.ico";

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
        if (service instanceof ArcGIS93)
            return service.getLayerOpacity();
        else
            return 1;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void addArcGIS93Layer(String name, String url, TreeGrid baseTree, LayerUtils layerUtils)
    {
        baseMaps[BASEMAP_COMMON] = new TreeNode();
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
	public void addGoogleStreetsLayer(TreeGrid treeGrid)
    {
        addGoogleLayer(treeGrid, BASEMAP_GOOGLE_STREETS, GoogleMaps.MapTypeId.ROADMAP);

        ((MapService) baseMaps[BASEMAP_GOOGLE_STREETS].getAttributeAsObject(String_service)).invalidate();
        treeGrid.selectRecord  (baseMaps[BASEMAP_GOOGLE_STREETS]);
        treeGrid.deselectRecord(baseMaps[BASEMAP_GOOGLE_STREETS]);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void addGoogleSatelliteLayer(TreeGrid treeGrid)
    {
        addGoogleLayer(treeGrid, BASEMAP_GOOGLE_SATTELITE, GoogleMaps.MapTypeId.SATELLITE);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void addGoogleHybridLayer(TreeGrid treeGrid)
    {
        addGoogleLayer(treeGrid, BASEMAP_GOOGLE_HYBRID, GoogleMaps.MapTypeId.HYBRID);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void addGoogleLayer(TreeGrid treeGrid, int idx, GoogleMaps.MapTypeId type)
    {
        baseMaps[idx] = new TreeNode();
        baseMaps[idx].setAttribute(ATTRIBUTE_LAYOUT,  baseMapsCaptions[idx][0]);
        String idPrefix = Integer.toString(baseMaps[idx].hashCode()) + "_";
        baseMaps[idx].setID(idPrefix + "-1");
        baseMaps[idx].setAttribute(String_service  , new GoogleMaps(baseMapsCaptions[idx][1], type));
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
//        baseMaps[idx].setIcon(GLOBE_ICON);
        treeGrid.getData().add(baseMaps[idx], treeGrid.getData().getRoot());
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
                setLayerZOrder(layer, 1000 - k);
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
        }
        setLayerZIndex(rootNodes);

        if ((nodes.length > 10) && GWTViewer.project.getConfigFile().equalsIgnoreCase("MosRegion"))
            GWTViewer.expandTreeNode(treeGrid);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
