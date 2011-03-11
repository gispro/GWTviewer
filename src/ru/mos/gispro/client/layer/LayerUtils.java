package ru.mos.gispro.client.layer;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LayerUtils
{
    public    final   static    String   String_Layout    = "Layout";
    public    final   static    String   String_service   = "service";
    public    final   static    String   String_isService = "isService";

    private           static    TreeNode googleStreets    = null;
    private           static    TreeNode googleSattelite  = null;
    private           static    TreeNode googleHybrid     = null;

    private           static    TreeNode bmRoad           = null;
    private           static    TreeNode bmSattelite      = null;
    private           static    TreeNode bmHybrid         = null;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void addArcGIS93Layer(String name, String url, TreeGrid treeGrid, Boolean select)
    {
		addArcGIS93Layer(name, url, url, treeGrid, select);
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
	public static void addArcGIS93Layer(String name, String url, String urlIdentify, TreeGrid treeGrid, boolean select)
    {
		Tree data = treeGrid.getData();

		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute(String_Layout, name + " ");
		String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");
		treeNode.setAttribute(String_service  , new ArcGIS93 (name, url, urlIdentify, "EPSG:102113",
                                                              treeNode, data, treeGrid));
		treeNode.setAttribute(String_isService, true);

		data.add(treeNode, data.getRoot());

		treeGrid.selectRecord(treeNode);

		if (!select)
			treeGrid.deselectRecord(treeNode);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void addWMSLayer(String name, String url, String layerName, TreeGrid treeGrid, Boolean select)
    {
		Tree data = treeGrid.getData();

		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute(String_Layout, name);
		String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");
		treeNode.setAttribute(String_service  , new WMS(name, url, layerName, "EPSG:900913"));
		treeNode.setAttribute(String_isService, true);

		data.add(treeNode, data.getRoot());
		if (select)
			treeGrid.selectRecord(treeNode);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void addGoogleStreetsLayer(TreeGrid treeGrid, TreeNode node)
    {
		Tree data = treeGrid.getData();

		String idPrefix;
		googleStreets = new TreeNode();
		googleStreets.setAttribute(String_Layout, "Google Карта");
		idPrefix = Integer.toString(googleStreets.hashCode()) + "_";
		googleStreets.setID(idPrefix + "-1");
		googleStreets.setAttribute(String_service  , new GoogleMaps("Google streets", GoogleMaps.MapTypeId.ROADMAP));
		googleStreets.setAttribute(String_isService, true);
        googleStreets.setIcon("globe-green.ico");
		data.add(googleStreets, node); // data.getRoot());

		((MapService) googleStreets.getAttributeAsObject("service")).invalidate();
		treeGrid.selectRecord(googleStreets);
		treeGrid.deselectRecord(googleStreets);
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void addGoogleSatelliteLayer(TreeGrid treeGrid, TreeNode node)
    {
		Tree data = treeGrid.getData();

		googleSattelite = new TreeNode();
		googleSattelite.setAttribute(String_Layout, "Google Спутник");
		String idPrefix = Integer.toString(googleSattelite.hashCode()) + "_";
		googleSattelite.setID(idPrefix + "-1");
		googleSattelite.setAttribute(String_service  , new GoogleMaps("Google satellite", GoogleMaps.MapTypeId.SATELLITE));
		googleSattelite.setAttribute(String_isService, true);
        googleSattelite.setIcon("globe-green.ico");
		data.add(googleSattelite, node); // , data.getRoot());
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void addGoogleHybridLayer(TreeGrid treeGrid, TreeNode node)
    {
		Tree data = treeGrid.getData();

		googleHybrid = new TreeNode();
		googleHybrid.setAttribute(String_Layout, "Google Гибрид");
		String idPrefix = Integer.toString(googleHybrid.hashCode()) + "_";
		googleHybrid.setID(idPrefix + "-1");
		googleHybrid.setAttribute(String_service  , new GoogleMaps("Google satellite", GoogleMaps.MapTypeId.HYBRID));
		googleHybrid.setAttribute(String_isService, true);
        googleHybrid.setIcon("globe-green.ico");
		data.add(googleHybrid, node); //  data.getRoot());
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void addBingMapRoadLayer(TreeGrid treeGrid, TreeNode node)
    {
        Tree data = treeGrid.getData();

        String idPrefix;
//        TreeNode treeNode = new TreeNode();
        bmRoad = new TreeNode();
        bmRoad.setAttribute(String_Layout, "Bing Map Карта");
        idPrefix = Integer.toString(bmRoad.hashCode()) + "_";
        bmRoad.setID(idPrefix + "-1");
        bmRoad.setAttribute(String_service  , new BingMaps("Bing Maps", BingMaps.MapTypeId.Road));
        bmRoad.setAttribute(String_isService, true);
        bmRoad.setIcon("globe-green.ico");
        data.add(bmRoad, node); // data.getRoot());

//        ((MapService) bmRoad.getAttributeAsObject("service")).invalidate();
//        treeGrid.selectRecord  (bmRoad);
//        treeGrid.deselectRecord(bmRoad);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void addBingMapSatelliteLayer(TreeGrid treeGrid, TreeNode node)
    {
        Tree data = treeGrid.getData();

        bmSattelite = new TreeNode();
        bmSattelite.setAttribute(String_Layout, "Bing Map Спутник");
        String idPrefix = Integer.toString(bmSattelite.hashCode()) + "_";
        bmSattelite.setID(idPrefix + "-1");
        bmSattelite.setAttribute(String_service  , new BingMaps("Bing Maps Satellite", BingMaps.MapTypeId.Aerial));
        bmSattelite.setAttribute(String_isService, true);
        bmSattelite.setIcon("globe-green.ico");
        data.add(bmSattelite, node); // data.getRoot());
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void addBingMapHybridLayer(TreeGrid treeGrid, TreeNode node)
    {
        Tree data = treeGrid.getData();

        bmHybrid = new TreeNode();
        bmHybrid.setAttribute(String_Layout, "Bing Map Гибрид");
        String idPrefix = Integer.toString(bmHybrid.hashCode()) + "_";
        bmHybrid.setID(idPrefix + "-1");
        bmHybrid.setAttribute(String_service  , new BingMaps("Bing Maps Hybrid", BingMaps.MapTypeId.Hybrid));
        bmHybrid.setAttribute(String_isService, true);
        bmHybrid.setIcon("globe-green.ico");
        data.add(bmHybrid, node); // data.getRoot());
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void addOSMLayer(TreeGrid treeGrid)
    {
		Tree data = treeGrid.getData();

		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute(String_Layout, "Open street map");
		String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");
		treeNode.setAttribute(String_service  , new OSM("Open street map"));
		treeNode.setAttribute(String_isService, true);
		data.add(treeNode, data.getRoot());
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void initLayerOrder(TreeGrid treeGrid)
    {
		TreeNode root = treeGrid.getTree().getRoot();

		List<TreeNode> rootNodes = new ArrayList<TreeNode>();
		TreeNode[] nodes = treeGrid.getTree().getChildren(root);

		for (TreeNode n : nodes)
        {
            if (treeGrid.getTree().getParent(n) != root)
                continue;
   			rootNodes.add(n);
		}
        if (googleStreets != null)
            rootNodes.add(googleStreets);
        if (googleSattelite != null)
            rootNodes.add(googleSattelite);
        if (googleHybrid != null)
            rootNodes.add(googleHybrid);

        if (bmRoad != null)
            rootNodes.add(bmRoad);
        if (bmSattelite != null)
            rootNodes.add(bmSattelite);
        if (bmHybrid != null)
            rootNodes.add(bmHybrid);

		for (int k = 0; k < rootNodes.size(); k++)
        {
            String service = (String) rootNodes.get(k).getAttribute(String_service);
            if (service != null)
            {
			    JavaScriptObject layer = ((MapService)rootNodes.get(k).getAttributeAsObject(String_service)).getLayer();
			    if (layer == null)
                    continue;
			    setLayerZOrder(layer, 1000 - k);
            }
		}
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
