package ru.mos.gispro.client.layer;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dima
 * Date: 21.11.2010
 * Time: 12:09:25
 */

public class LayerUtils
{
	public static void addArcGIS93Layer(String name, String url, TreeGrid treeGrid, Boolean select)
    {
		addArcGIS93Layer(name, url, url, treeGrid, select);
	}

    public static native void setLayerZOrder(JavaScriptObject layer, int order)
    /*-{
        layer.setZIndex(order);
    }-*/;

    public static native void setLayerOpacity(JavaScriptObject layer, float opacity)
    /*-{
        layer.setOpacity(opacity);
    }-*/;

	public static void addArcGIS93Layer(String name, String url, String urlIdentify, TreeGrid treeGrid, boolean select)
    {
		Tree data = treeGrid.getData();

		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute("Layout", name + " ");
		String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");
		treeNode.setAttribute( "service", new ArcGIS93 (name, url, urlIdentify, "EPSG:102113", treeNode, data, treeGrid));
		treeNode.setAttribute("isService", true);

		data.add(treeNode, data.getRoot());

		treeGrid.selectRecord(treeNode);

		if (!select)
			treeGrid.deselectRecord(treeNode);
	}

	public static void addWMSLayer(String name, String url, String layerName, TreeGrid treeGrid, Boolean select)
    {
		Tree data = treeGrid.getData();

		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute("Layout", name);
		String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");
		treeNode.setAttribute("service", new WMS(name, url, layerName, "EPSG:900913"));
		treeNode.setAttribute("isService", true);

		data.add(treeNode, data.getRoot());
		if (select)
			treeGrid.selectRecord(treeNode);
	}

	public static void addGoogleStreetsLayer(TreeGrid treeGrid)
    {
		Tree data = treeGrid.getData();

		String idPrefix;
		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute("Layout", "Google Карта");
		idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");
		treeNode.setAttribute("service", new GoogleMaps("Google streets", GoogleMaps.MapTypeId.ROADMAP));
		treeNode.setAttribute("isService", true);
		data.add(treeNode, data.getRoot());
		((MapService) treeNode.getAttributeAsObject("service")).invalidate();

		treeGrid.selectRecord(treeNode);
		treeGrid.deselectRecord(treeNode);

	}

	public static void addGoogleSatelliteLayer(TreeGrid treeGrid)
    {
		Tree data = treeGrid.getData();

		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute("Layout", "Google Спутник");
		String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");
		treeNode.setAttribute("service", new GoogleMaps("Google satellite", GoogleMaps.MapTypeId.SATELLITE));
		treeNode.setAttribute("isService", true);
		data.add(treeNode, data.getRoot());
	}

	public static void addGoogleHybridLayer(TreeGrid treeGrid) {

		Tree data = treeGrid.getData();

		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute("Layout", "Google Гибрид");
		String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");
		treeNode.setAttribute("service", new GoogleMaps("Google satellite", GoogleMaps.MapTypeId.HYBRID));
		treeNode.setAttribute("isService", true);
		data.add(treeNode, data.getRoot());
	}

	public static void addOSMLayer(TreeGrid treeGrid)
    {
		Tree data = treeGrid.getData();

		TreeNode treeNode = new TreeNode();
		treeNode.setAttribute("Layout", "Open street map");
		String idPrefix = Integer.toString(treeNode.hashCode()) + "_";
		treeNode.setID(idPrefix + "-1");
		treeNode.setAttribute("service", new OSM("Open street map"));
		treeNode.setAttribute("isService", true);
		data.add(treeNode, data.getRoot());
	}

	public static void initLayerOrder(TreeGrid treeGrid)
    {
		TreeNode root = treeGrid.getTree().getRoot();

		List<TreeNode> rootNodes = new ArrayList<TreeNode>();
		TreeNode[] nodes = treeGrid.getTree().getChildren(root);

		int i = -1;
		for (TreeNode n : nodes)
        {
			i++;
			if (treeGrid.getTree().getParent(n) != root)
                continue;
			rootNodes.add(n);
		}
		for (int k = 0; k < rootNodes.size(); k++)
        {
			JavaScriptObject layer = ((MapService)rootNodes.get(k).getAttributeAsObject("service")).getLayer();
			if (layer == null)
                continue;
			setLayerZOrder(layer, 1000 - k);
		}
	}
}
