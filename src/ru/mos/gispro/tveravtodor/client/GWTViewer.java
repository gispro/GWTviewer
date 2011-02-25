package ru.mos.gispro.tveravtodor.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.core.client.GWT;

import com.smartgwt.client.types.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

import ru.mos.gispro.tveravtodor.client.elements.*;

import ru.mos.gispro.tveravtodor.client.geometry.GeometryManager;
import ru.mos.gispro.tveravtodor.client.geometry.GeometryManager1;

import ru.mos.gispro.tveravtodor.client.json.JSONConfig;
import ru.mos.gispro.tveravtodor.client.json.JSONLayerConfig;
import ru.mos.gispro.tveravtodor.client.json.JSONTerrs;
import ru.mos.gispro.tveravtodor.client.json.JSONProject;

import ru.mos.gispro.tveravtodor.client.layer.*;
import ru.mos.gispro.tveravtodor.client.tad.LinearGraphButton;
import ru.mos.gispro.tveravtodor.client.tad.PasportButton;
import ru.mos.gispro.tveravtodor.client.tad.VideoButton;

import com.google.gwt.user.client.rpc.AsyncCallback;

import ru.mos.gispro.tveravtodor.client.window.Authorization;
import ru.mos.gispro.tveravtodor.client.window.Registration;

import java.util.*;

public class GWTViewer implements EntryPoint
{
    public static JSONConfig      config       ;
    public        JSONProject     project      ;
    private       Authorization   authorization;
    private       Registration    registration ;
                  JSONTerrs       terrs;
    private       VLayout         pageLayout;

                  Tree            data;
                  TreeGrid        treeGrid;

                  String          currentLayer;
                  TreeNode        currentNode;
                  Label           currentLayerLabel = new Label("");

                  Window          propertyLayerWindow;

    public static final  String   ACTION_RESULT_SUCCESS = "success";

    public static final  MapServiceInfoAsync MapServiceInfoServlet = GWT.create(MapServiceInfo.class);

    public static final String LAYER_TYPE_ARC_GIS_93 = "ArcGIS93";
    public static final String LAYER_TYPE_WMS        = "WMS";

    public native void initMap() /*-{
        $wnd.map = new $wnd.OpenLayers.Map("map", $wnd.options);
        $wnd.initMap2();
    }-*/;

    public native void addYandex() /*-{
        var layer = new $wnd.OpenLayers.Layer.Yandex("Yandex",
        {
        minZoomLevel: 3,
        maxZoomLevel: 12,
        maxExtent:new $wnd.OpenLayers.Bounds(-20037508, -20037508, 20037508, 20037508.34),
        sphericalMercator: true
        },
        {
        singleTile: "true",
        ratio: 1,
        buffer: 0,
        displayOutsideMaxExtent: "true"
        });
        $wnd.map.addLayer(layer);
    }-*/;

    public native void mapToCenter(double lon, double lat) /*-{
        $wnd.map.setCenter(new $wnd.OpenLayers.LonLat(lon,lat),3);
//		$wnd.map.setCenter(new $wnd.OpenLayers.LonLat($wnd.configLayers.centerX,$wnd.configLayers.centerY),3);
    }-*/;

    public native void zoomToMaxExtent() /*-{
        $wnd.map.zoomToMaxExtent();
    }-*/;

    public native void zoomTo(Integer lvl) /*-{
        $wnd.map.zoomTo(lvl);
    }-*/;

    class NavigationHistory {

        NavigationHistory(ToolStripButton prev, ToolStripButton next) {
            this.prev = prev;
            this.next = next;
        }

        public void activate() {
            if (navigationHistory == null)
                navigationHistory = test();

            prev.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    previous(navigationHistory);
                }
            });
            next.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    next(navigationHistory);
                }
            });

            update();
        }

        void update() {
            prev.setDisabled(isPreviousStackEmpty(navigationHistory));
            next.setDisabled(isNextStackEmpty(navigationHistory));
        }

        public native boolean isPreviousStackEmpty(JavaScriptObject navigationHistory) /*-{
            return navigationHistory.previousStack.length <= 1;
        }-*/;

        public native boolean isNextStackEmpty(JavaScriptObject navigationHistory) /*-{
            return navigationHistory.nextStack.length == 0;
        }-*/;

        public native boolean previous(JavaScriptObject navigationHistory) /*-{
            return navigationHistory.previousTrigger() == null;
        }-*/;

        public native boolean next(JavaScriptObject navigationHistory) /*-{
        return navigationHistory.nextTrigger() == null;
        }-*/;

        protected native JavaScriptObject test() /*-{
            var navigationHistory = new $wnd.OpenLayers.Control.NavigationHistory();
            var this_ = this;
            navigationHistory.onPreviousChange = function(state, lendth){
                this_.@ru.mos.gispro.tveravtodor.client.GWTViewer.NavigationHistory::update()();
            };
            navigationHistory.onNextChange = function(state, lendth){
                this_.@ru.mos.gispro.tveravtodor.client.GWTViewer.NavigationHistory::update()();
            };

            $wnd.map.addControl(navigationHistory);
            return navigationHistory;
        }-*/;

        ToolStripButton prev, next;
        public JavaScriptObject navigationHistory;
    }

    public native void addVectorLayer() /*-{


//            var myStyles = new OpenLayers.StyleMap({
//                "default": new OpenLayers.Style({
//                    pointRadius: "${type}", // sized according to type attribute
//                    fillColor: "#ffcc66",
//                    strokeColor: "#ff9933",
//                    strokeWidth: 2,
//                    graphicZIndex: 1
//                }),
//                "select": new OpenLayers.Style({
//                    fillColor: "#66ccff",
//                    strokeColor: "#3399ff",
//                    graphicZIndex: 2
//                })
//            });

            $wnd.vectors = new $wnd.OpenLayers.Layer.Vector(
                "Vector Layer",
                {
                    styleMap : new $wnd.OpenLayers.StyleMap({
                                            pointRadius: "${type}", // sized according to type attribute
//                                          strokeWidth: $wnd.configLayers.strokeWidth,
//                                          strokeColor: $wnd.configLayers.strokeColor,
//	                                        strokeOpacity : $wnd.configLayers.strokeOpacity,
//                                          fillColor : $wnd.configLayers.fillColor,
//                                          fillOpacity : $wnd.configLayers.fillOpacity

                                            strokeWidth: $wnd.layerParams.strokeWidth,
                                            strokeColor: $wnd.layerParams.strokeColor,
                                            strokeOpacity : $wnd.layerParams.strokeOpacity,
                                            fillColor : $wnd.layerParams.fillColor,
                                            fillOpacity : $wnd.layerParams.fillOpacity
                                        })
                }
            );
            $wnd.map.addLayer($wnd.vectors);
            $wnd.vectors.setZIndex(2000);
    }-*/;

    public native void addVectorLayer1() /*-{
            $wnd.vectors1 = new $wnd.OpenLayers.Layer.Vector(
                "Vector Layer1",
                {
                    styleMap : new $wnd.OpenLayers.StyleMap({
                                            pointRadius: "${type}", // sized according to type attribute
//                                          strokeWidth: $wnd.configLayers.strokeWidth1,
//                                          strokeColor: $wnd.configLayers.strokeColor1,
//	                                        strokeOpacity : $wnd.configLayers.strokeOpacity1,
//                                          fillColor : $wnd.configLayers.fillColor1,
//                                          fillOpacity : $wnd.configLayers.fillOpacity1
                                            strokeWidth: $wnd.layerParams.strokeWidth1,
                                            strokeColor: $wnd.layerParams.strokeColor1,
                                            strokeOpacity : $wnd.layerParams.strokeOpacity1,
                                            fillColor : $wnd.layerParams.fillColor1,
                                            fillOpacity : $wnd.layerParams.fillOpacity1
                                        })
                }
            );
            $wnd.map.addLayer($wnd.vectors1);
            $wnd.vectors1.setZIndex(2001);
    }-*/;


    public static native void deactivateControls() /*-{
    for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
    {
        if ($wnd.map.controls[indexControl].displayClass != "olControlNavigationHistory")
            $wnd.map.controls[indexControl].deactivate();
        if ($wnd.map.controls[indexControl].displayClass == "olControlMousePosition")
            $wnd.map.controls[indexControl].activate();
    }
    }-*/;


    public void createPropertyLayerWindow() {

        propertyLayerWindow = new Window();

        propertyLayerWindow.setTitle("Настройки сервиса");
        propertyLayerWindow.setHeight(190);
        propertyLayerWindow.setWidth(500);
        propertyLayerWindow.setShowMaximizeButton(true);
        propertyLayerWindow.centerInPage();
        propertyLayerWindow.setCanDragResize(false);


        Canvas layerManageCanvas = new Canvas();
        layerManageCanvas.setWidth100();
        layerManageCanvas.setHeight100();

        Label infoLayerNameLabel = new Label("Слой:");
        infoLayerNameLabel.setHeight(30);
        infoLayerNameLabel.setWidth(50);
        infoLayerNameLabel.setTop(10);
        infoLayerNameLabel.setLeft(10);


        currentLayerLabel.setHeight(30);
        currentLayerLabel.setWidth(300);
        currentLayerLabel.setTop(10);
        currentLayerLabel.setLeft(100);

        Button upLayerButton = new Button("");
        upLayerButton.setIcon("upcontrol.png");
        upLayerButton.setIconSize(16);
        upLayerButton.setIconAlign("center");
        upLayerButton.setHeight(30);
        upLayerButton.setWidth(24);
        upLayerButton.setTop(10);
        upLayerButton.setLeft(410);

        upLayerButton.setTooltip("Поднять слой вверх. (отдалить)");
        upLayerButton.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent clickEvent) {

                TreeNode root = treeGrid.getTree().getRoot();

                List<TreeNode> rootNodes = new ArrayList<TreeNode>();
                List<TreeNode> newRootNodes = new ArrayList<TreeNode>();
                List<Integer> rootIds = new ArrayList<Integer>();

                TreeNode[] nodes = treeGrid.getTree().getChildren(root);

                int i = -1;
                for (TreeNode n : nodes) {
                    i++;
                    if (treeGrid.getTree().getParent(n)!=root)continue;
                    rootNodes.add(n);
                    rootIds.add(i);
                    newRootNodes.add(n);
                }

                for (int k = 0; k < rootNodes.size(); k++) {
                    if (rootNodes.get(k) == currentNode) {
                        if (k == 0) break;
                        treeGrid.getTree().move(currentNode, root, rootIds.get(k-1));

                        TreeNode tn = newRootNodes.get(k-1);
                        newRootNodes.set(k-1, currentNode);
                        newRootNodes.set(k, tn);
                        break;
                    }
                }

                for (int k = 0; k < newRootNodes.size(); k++) {
                    JavaScriptObject layer = ((MapService)newRootNodes.get(k).getAttributeAsObject("service")).getLayer();
                    if (layer == null) continue;
                    LayerUtils.setLayerZOrder(layer, 1000-k);
                }

            }
        });

        Button downLayerButton = new Button("");
        downLayerButton.setIcon("downcontrol.png");
        downLayerButton.setIconSize(16);
        downLayerButton.setIconAlign("center");
        downLayerButton.setHeight(30);
        downLayerButton.setWidth(24);
        downLayerButton.setTop(10);
        downLayerButton.setLeft(444);
        downLayerButton.setValign(VerticalAlignment.CENTER);
        downLayerButton.setTooltip("Опустить слой вниз. (приблизить)");
        downLayerButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {

                TreeNode root = treeGrid.getTree().getRoot();

                List<TreeNode> rootNodes = new ArrayList<TreeNode>();
                List<TreeNode> newRootNodes = new ArrayList<TreeNode>();
                List<Integer> rootIds = new ArrayList<Integer>();

                TreeNode[] nodes = treeGrid.getTree().getChildren(root);

                int i = -1;
                for (TreeNode n : nodes) {
                    i++;
                    if (treeGrid.getTree().getParent(n)!=root)continue;
                    rootNodes.add(n);
                    rootIds.add(i);
                    newRootNodes.add(n);
                }

                for (int k = 0; k < rootNodes.size(); k++) {
                    if (rootNodes.get(k) == currentNode) {
                        if (k == rootNodes.size()) break;
                        treeGrid.getTree().move(rootNodes.get(k+1), root, rootIds.get(k));
                        TreeNode tn = newRootNodes.get(k+1);
                        newRootNodes.set(k+1, currentNode);
                        newRootNodes.set(k, tn);
                        break;
                    }
                }

                for (int k = 0; k < newRootNodes.size(); k++) {
                    JavaScriptObject layer = ((MapService)newRootNodes.get(k).getAttributeAsObject("service")).getLayer();
                    if (layer == null) continue;
                    LayerUtils.setLayerZOrder(layer, 1000-k);
                }

            }
        });

        Label infoSliderNameLabel = new Label("Прозрачность:");
        infoSliderNameLabel.setHeight(60);
        infoSliderNameLabel.setWidth(60);
        infoSliderNameLabel.setTop(50);
        infoSliderNameLabel.setLeft(10);

        final Slider opacitySlider = new Slider("");
        opacitySlider.setPadding(10);
        opacitySlider.setVertical(false);
        opacitySlider.setHeight(60);
        opacitySlider.setWidth(368);
        opacitySlider.setMinValue(0);
        opacitySlider.setMaxValue(100);
        opacitySlider.setNumValues(101);
        opacitySlider.setTop(50);
        opacitySlider.setLeft(100);
        opacitySlider.setShowTitle(false);

        opacitySlider.addDrawHandler(new DrawHandler() {
            public void onDraw(DrawEvent drawEvent) {
                opacitySlider.addValueChangedHandler(new ValueChangedHandler() {
                    public void onValueChanged(ValueChangedEvent event) {
                        JavaScriptObject layer = ((MapService)currentNode.getAttributeAsObject("service")).getLayer();
                        LayerUtils.setLayerOpacity(layer, (float) event.getValue() / 100f);
                    }
                });
            }
        });

        Label attentionLabel = new Label("Порядок слоев влияет на их видимость при отображении");
        attentionLabel.setHeight(30);
        attentionLabel.setTop(120);
//		attentionLabel.setLeft(10);
        attentionLabel.setWidth100();
        attentionLabel.setMargin(10);
        attentionLabel.setStyleName("attentionLabel");

        layerManageCanvas.addChild(infoLayerNameLabel);
        layerManageCanvas.addChild(currentLayerLabel);
        layerManageCanvas.addChild(upLayerButton);
        layerManageCanvas.addChild(downLayerButton);

        layerManageCanvas.addChild(infoSliderNameLabel);
        layerManageCanvas.addChild(opacitySlider);
        layerManageCanvas.addChild(attentionLabel);

        propertyLayerWindow.addItem(layerManageCanvas);
    }

    HandlerRegistration hendlerRegistration;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void onModuleLoad()
    {
        project = new ProjectLoader().getConfig();
        config  = new ConfigLoader(project.getConfigFile()).getConfig();

        if (!config.withAuthorization())
            createUserInterface();
        else
            openFormAuthorization();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void openFormAuthorization()
    {
        authorization = new Authorization (new AsyncCallback<String>()
        {
            public void onFailure(Throwable caught) {}
            public void onSuccess(String content)
            {
                // com.google.gwt.user.client.Window.alert(content);
                if ((content != null) && content.equalsIgnoreCase("Registration"))
                    openFormRegistration();
                else
                {
                    authorization.closeForm();
                    createUserInterface();
                }
            }
        });
        authorization.show();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void openFormRegistration()
    {
        registration = new Registration(new AsyncCallback<String>()
        {
            public void onFailure(Throwable caught) {}
            public void onSuccess(String content)
            {
//                com.google.gwt.user.client.Window.alert("TverAvtoDor.openFormRegistration - AsyncCallback.content = " + content);
                if ((content != null) && (content.equalsIgnoreCase(ACTION_RESULT_SUCCESS) ||
                                          content.equalsIgnoreCase("Authorization")))
                {
                    registration.closeForm();
                    openFormAuthorization();
                }
            }
        });
        registration.show();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void createUserInterface()
    {
        Document.get().setTitle(config.getPageTitle());
        createPropertyLayerWindow();

        HLayout mainLayout = new HLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        mainLayout.setDefaultResizeBars(LayoutResizeBarPolicy.MIDDLE);

        VLayout layout2 = new VLayout();
        layout2.setHeight100();
        layout2.setWidth("20%");

        final TreeNode root = new TreeNode("");

        data = new Tree();
        data.setModelType(TreeModelType.PARENT);
        data.setRootValue(1);
        data.setRoot(root);
        data.setNameProperty("Layout");

        treeGrid = new TreeGrid();
        treeGrid.setShowOpenIcons(false);
        treeGrid.setShowDropIcons(false);
        treeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        treeGrid.setShowSelectedStyle(false);
        treeGrid.setShowPartialSelection(false);
//		treeGrid.setCascadeSelection(false);
        treeGrid.setCanSort(false);
        treeGrid.setCanReorderFields(false);
        treeGrid.setCanReorderRecords(false);
        treeGrid.setData(data);
        treeGrid.getField(0).setTitle("Картографические сервисы"); // todo косяк тут
        treeGrid.setHeaderHeight(0);


        treeGrid.addCellClickHandler(new CellClickHandler() {
            public void onCellClick(CellClickEvent event) {
                TreeNode node = treeGrid.getTree().findById(event.getRecord().getAttribute("id"));
                while (treeGrid.getTree().getParent(node)!=root)node = treeGrid.getTree().getParent(node);
                String s = node.getAttribute("Layout");
                currentLayer = s;
                currentLayerLabel.setContents(s);
                currentNode = node;
            }
        });

        ToolStrip toolStrip2 = new ToolStrip();
        toolStrip2.setWidth100();
        toolStrip2.setHeight(40);

                                         // UNICODE - Список слоев
        Label contentLayers = new Label ("\u0421\u043F\u0438\u0441\u043E\u043A\u0020\u0441\u043B\u043E\u0435\u0432");
        contentLayers.setHeight(30);
        contentLayers.setStyleName("contentLabel");

        toolStrip2.addSpacer(10);
        toolStrip2.addMember(contentLayers);

        ToolStripButton addMapButton = null;
//		addMapButton.setTooltip("Добавить сервис");

        if (config.debug_serviceADD())
        {
            addMapButton = new AddMapButton(treeGrid);
            addMapButton.setTooltip("Добавить сервис");
        }

        ToolStripButton propertyLayerButton = new ToolStripButton();
        propertyLayerButton.setTooltip("\u041D\u0430\u0441\u0442\u0440\u043E\u0438\u0442\u044C\u0020\u043F\u043E\u0440\u044F\u0434\u043E\u043A\u0020\u0438\u0020\u043F\u0440\u043E\u0437\u0440\u0430\u0447\u043D\u043E\u0441\u0442\u044C\u0020\u0441\u043B\u043E\u0435\u0432"); // ""Настроить порядок и прозрачность слоев"
        propertyLayerButton.setIcon("Layer_Properties.png");
        propertyLayerButton.setIconSize(24);
        propertyLayerButton.setHeight(30);

        propertyLayerButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                propertyLayerWindow.show();
            }
        });

        if (config.debug_serviceADD())
        {
            toolStrip2.addSpacer(5);
            toolStrip2.addButton(addMapButton);
        }
//		toolStrip2.addButton(propertyLayerButton);

        TerrTreePickTree treePickTreeItem = null;
        if (config.municipalities())
        {
            treePickTreeItem = new TerrTreePickTree();
//		treePickTreeItem.setCanSelectParentItems(true);
//		treePickTreeItem.setTitle("Территория");
//		treePickTreeItem.setEmptyMenuMessage("Выберите территорию");
//		treePickTreeItem.setName("Выберите территорию");
//		treePickTreeItem.setEmptyMenuMessage("Нет данных");
//		treePickTreeItem.setEmptyDisplayValue("Выберите территорию");
//		treePickTreeItem.setDefaultValue("Выберите территорию");
//		treePickTreeItem.setHeight(30);
//		treePickTreeItem.addChangedHandler(new com.smartgwt.client.widgets.form.fields.events.ChangedHandler() {
//			public void onChanged(ChangedEvent changedEvent) {
//				com.google.gwt.user.client.Window.alert("" + changedEvent.getValue());
//
//				TreeFind find = new TreeFind();
//				find.find("Каши");
//
//			}
//		});

            terrs = new TerrTreeLoader().getTerrTree();

            TerrTree terrTree = new TerrTree();
            terrTree.createTerrTree(terrs);
            treePickTreeItem.setValueTree(terrTree);
//		    toolStrip2.addFormItem(treePickTreeItem);      //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        }

        layout2.addMember(toolStrip2);
        layout2.addMember(treeGrid);
        mainLayout.addMember(layout2);

        VLayout layout = new VLayout();
        final Canvas canvas = new Canvas();

        ToolStrip toolStrip = new ToolStrip();
        toolStrip.setWidth100();
        toolStrip.setHeight(40);

        final ToolStripButton zoomLast = new ToolStripButton();
        zoomLast.setIcon("MActionZoomLast.png");
        zoomLast.setIconSize(24);
        zoomLast.setHeight(30);
        zoomLast.setTooltip("\u041D\u0430\u0437\u0430\u0434"); //  "Назад"
        final ToolStripButton zoomNext = new ToolStripButton();
        zoomNext.setIcon("MActionZoomNext.png");
        zoomNext.setIconSize(24);
        zoomNext.setHeight(30);
        zoomNext.setTooltip("\u0412\u043F\u0435\u0440\u0435\u0434"); // "Вперед";

        final ToolStripButton zoomIn = new ToolStripButton();
        zoomIn.setIcon("MActionZoomIn.png");
        zoomIn.setIconSize(24);
        zoomIn.setHeight(30);
        zoomIn.setActionType(SelectionType.RADIO);
        zoomIn.setRadioGroup("mapAction");
        zoomIn.setTooltip("\u041F\u0440\u0438\u0431\u043B\u0438\u0437\u0438\u0442\u044C"); // "Приблизить");
        zoomIn.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                deactivateControls();
                if (zoomBox == null)
                    zoomBox = test();
                activate(zoomBox);
                if (hendlerRegistration != null) {
                    Document.get().getElementById("map").getStyle().setCursor(Cursor.DEFAULT);
                    hendlerRegistration.removeHandler();
                    hendlerRegistration = null;
                }
            }

            protected native void activate(JavaScriptObject zoomBox) /*-{

                for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
                {
                    if ($wnd.map.controls[indexControl].active
                        && ( $wnd.map.controls[indexControl].displayClass == "olControlZoomBox" || $wnd.map.controls[indexControl].displayClass == "olControlNavigation"))
                        $wnd.map.controls[indexControl].deactivate();
                }
                zoomBox.activate();
            }-*/;

            protected native JavaScriptObject test() /*-{
                var zoomBox = new $wnd.OpenLayers.Control.ZoomBox();
                $wnd.map.addControl(zoomBox);
                return zoomBox;
            }-*/;

            private JavaScriptObject zoomBox;
        });

        final ToolStripButton zoomOut = new ToolStripButton();
        zoomOut.setIcon("MActionZoomOut.png");
        zoomOut.setIconSize(24);
        zoomOut.setHeight(30);
        zoomOut.setActionType(SelectionType.RADIO);
        zoomOut.setRadioGroup("mapAction");
        zoomOut.setTooltip("\u041E\u0442\u0434\u0430\u043B\u0438\u0442\u044C"); // "Отдалить"
        zoomOut.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                deactivateControls();
                if (zoomBox == null)
                    zoomBox = test();
                activate(zoomBox);
                if (hendlerRegistration != null) {
                    Document.get().getElementById("map").getStyle().setCursor(Cursor.DEFAULT);
                    hendlerRegistration.removeHandler();
                    hendlerRegistration = null;
                }
            }

            protected native void activate(JavaScriptObject zoomBox) /*-{
                for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
                {
                    if ($wnd.map.controls[indexControl].active
                        && ( $wnd.map.controls[indexControl].displayClass == "olControlZoomBox" || $wnd.map.controls[indexControl].displayClass == "olControlNavigation"))
                        $wnd.map.controls[indexControl].deactivate();
                }
                zoomBox.activate();
            }-*/;

            protected native JavaScriptObject test() /*-{
                var zoomBox = new $wnd.OpenLayers.Control.ZoomBox({displayClass: "ZoomBox", out: true});
                $wnd.map.addControl(zoomBox);
                return zoomBox;
            }-*/;

            private JavaScriptObject zoomBox;
        });

        ToolStripButton zoomFullExtent = null;
        if (config.toolButtonFullExtent())
        {
            zoomFullExtent = new ToolStripButton();
            zoomFullExtent.setIcon("MActionZoomFullExtent.png");
            zoomFullExtent.setIconSize(24);
            zoomFullExtent.setHeight(30);
            zoomFullExtent.setTooltip("\u0412\u0441\u044F\u0020\u043A\u0430\u0440\u0442\u0430"); // "Вся карта"
        }
        class FullExtent implements ClickHandler {

            public void onClick(ClickEvent event) {
                deactivateControls();
                activate();
            }

            public void activate() {
                test();
                zoomToMaxExtent();
                zoomTo(3);
                test2();
                mapToCenter(config.centerX(), config.centerY());
            }

            protected native void test() /*-{
                for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
                {
                    if ($wnd.map.controls[indexControl].displayClass == "olControlNavigationHistory")
                        $wnd.map.controls[indexControl].deactivate();
                }
            }-*/;

            protected native void test2() /*-{
            for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
                    if ($wnd.map.controls[indexControl].displayClass == "olControlNavigationHistory")
                        $wnd.map.controls[indexControl].activate();
            }-*/;
        }

        FullExtent fullExtent = new FullExtent();
        if (config.toolButtonFullExtent())
            zoomFullExtent.addClickHandler(fullExtent);

        final ToolStripButton pan = new ToolStripButton();
        pan.setIcon("MActionPan.png");
        pan.setIconSize(24);
        pan.setHeight(30);
        pan.setActionType(SelectionType.RADIO);
        pan.setRadioGroup("mapAction");
        pan.setTooltip("\u041F\u0430\u043D\u043E\u0440\u0430\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435"); // ""Панорамирование"
        class Navigation implements ClickHandler {

            public void onClick(ClickEvent event) {

                deactivateControls();

                activate();

            }

            public void activate() {
                if (navigation == null)
                    navigation = test();
                activate(navigation);
                if (hendlerRegistration != null) {
                    Document.get().getElementById("map").getStyle().setCursor(Cursor.DEFAULT);
                    hendlerRegistration.removeHandler();
                    hendlerRegistration = null;
                }
            }

            protected native void activate(JavaScriptObject navigation) /*-{
                for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
                {
                    if ($wnd.map.controls[indexControl].active
                        && ( $wnd.map.controls[indexControl].displayClass == "olControlZoomBox" || $wnd.map.controls[indexControl].displayClass == "olControlNavigation"))
                        $wnd.map.controls[indexControl].deactivate();
                }
                navigation.activate();
            }-*/;

            protected native JavaScriptObject test() /*-{
                var navigation = new $wnd.OpenLayers.Control.Navigation();
                $wnd.map.addControl(navigation);
                return navigation;
            }-*/;

            private JavaScriptObject navigation;
        }

        Navigation navigation = new Navigation();
        pan.addClickHandler(navigation);

        final ToolStripButton identify = new IdentifyButton(treeGrid, canvas);
        identify.setTooltip("\u0418\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u044F"); // "Информация"
        final ToolStripButton find = new FindButton();
        find.setTooltip("\u0420\u0430\u0441\u0448\u0438\u0440\u0435\u043D\u043D\u044B\u0439\u0020\u043F\u043E\u0438\u0441\u043A"); // "Расширенный поиск"

        ToolStripButton roadPasport = null;
        ToolStripButton linearGraph = null;
        ToolStripButton video       = null;
        if (config.isTverAvtoDor())
        {
            roadPasport = new PasportButton(canvas);
            roadPasport.setTooltip("\u041F\u0430\u0441\u043F\u043E\u0440\u0442\u0020\u0434\u043E\u0440\u043E\u0433\u0438"); // "Паспорт дороги"
            linearGraph = new LinearGraphButton(canvas);
            linearGraph.setTooltip("\u041B\u0438\u043D\u0435\u0439\u043D\u044B\u0439\u0020\u0433\u0440\u0430\u0444\u0438\u043A"); // ""Линейный график"
            video = new VideoButton(canvas);
            video.setTooltip("\u0412\u0438\u0434\u0435\u043E\u0020\u043F\u043E\u0020\u0434\u043E\u0440\u043E\u0433\u0435"); // ""Видео по дороге"
        }
        final ToolStripButton clearGeometry = new ToolStripButton();
        clearGeometry.setIcon("MActionClearSelect.png");
        clearGeometry.setIconSize(24);
        clearGeometry.setHeight(30);
        clearGeometry.setWidth(30);
        clearGeometry.setActionType(SelectionType.BUTTON);
        clearGeometry.setTooltip("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C\u0020\u0432\u044B\u0431\u043E\u0440\u043A\u0443"); //  "Очистить выборку"
        clearGeometry.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                GeometryManager.clearGeometry();
                GeometryManager1.clearGeometry();
            }
        });
                                                      // Поиск
        TextItem quickSearchTextItem = new TextItem("\u041F\u043E\u0438\u0441\u043A");
//		quickSearchTextItem.setHeight(30);
        QuickFindButton quickFindButton = new QuickFindButton(quickSearchTextItem);
                                   // Поиск
        quickFindButton.setTooltip("\u041F\u043E\u0438\u0441\u043A");

//		toolStrip.setAlign(Alignment.LEFT);
//		toolStrip.setAlign(VerticalAlignment.CENTER);

        toolStrip.addSpacer(4);
        toolStrip.addButton(zoomLast);
        toolStrip.addButton(zoomNext);
        toolStrip.addSpacer(6);
        toolStrip.addButton(pan);
        toolStrip.addButton(zoomIn);
        toolStrip.addButton(zoomOut);

        if (config.toolButtonFullExtent())
        {
            toolStrip.addButton(zoomFullExtent);
            toolStrip.addSpacer(6);
        } else
            toolStrip.addSpacer(6);

        toolStrip.addButton(identify);
        toolStrip.addButton(find);
        toolStrip.addButton(clearGeometry);
        toolStrip.addSpacer(6);

        if (config.isTverAvtoDor())
        {
            toolStrip.addButton(roadPasport);
            toolStrip.addButton(linearGraph);
            toolStrip.addButton(video);
            toolStrip.addSpacer(6);
        }
        toolStrip.addButton(propertyLayerButton);
        toolStrip.addSpacer(8);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        if (config.municipalities())
        {
            treePickTreeItem.setAlign(Alignment.LEFT);
            treePickTreeItem.setWidth(210);

            VLayout treePickLayout = new VLayout();
            treePickLayout.setWidth(230);
            treePickLayout.setHeight(34);
            treePickLayout.setMargin( 1);

            ToolStrip treePickToolStrip = new ToolStrip();
            treePickToolStrip.setWidth100();
//          treePickToolStrip.setTop(4);
            treePickToolStrip.setHeight100();
//          treePickToolStrip.setHeight(32);
            treePickToolStrip.addSpacer( 5);

            treePickToolStrip.addFormItem(treePickTreeItem);

            treePickLayout.addMember(treePickToolStrip);

            toolStrip.addMember(treePickLayout);
            toolStrip.addSpacer(10);
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        VLayout searchLayout = new VLayout();
        searchLayout.setWidth(240);
        searchLayout.setHeight(34);
        searchLayout.setMargin( 1);

        ToolStrip searchToolStrip = new ToolStrip();
        searchToolStrip.setWidth100();
        searchToolStrip.setHeight100();
        searchToolStrip.addSpacer(5);
        searchToolStrip.addFormItem(quickSearchTextItem);
        searchToolStrip.addButton(quickFindButton);

        searchLayout.addMember(searchToolStrip);
        toolStrip.addMember(searchLayout);
//      toolStrip.addSpacer(12);
//		toolStrip.addFormItem(quickSearchTextItem);
//		toolStrip.addButton(quickFindButton);


//		toolStrip.addSpacer(12);
//		toolStrip.addFormItem(treePickTreeItem);

        pan.select();

        HTMLFlow mapFlow = new HTMLFlow();
        mapFlow.setWidth100();
        mapFlow.setHeight100();

        canvas.addChild(mapFlow);

        layout.addMember(toolStrip);
        layout.addMember(canvas);
        mainLayout.addMember(layout);

//~~~~~~~~~~~~~~~~
        if (project.getConfigFile().equalsIgnoreCase("MosRegion") && config.withHeader())
        {
            createHeaderMosRegion();

            pageLayout.addMember(mainLayout);
            pageLayout.draw();

        } else
            mainLayout.draw();
//~~~~~~~~~~~~~~~~
        String content = "<div id=\"map\" style=\"width:100%;height:100%;overflow:hidden;\"></div>";
        mapFlow.setContents(content);
        mapFlow.redraw();
        initMap();

        treeGrid.addSelectionChangedHandler(new SelectionChangedHandler() {

            Set<MapService> ser;
            Timer timer;

            protected void updateSelectedLayers(MapService mapService, TreeNode treeNode, boolean isSelected) {
                for (TreeNode childNode : data.getChildren(treeNode)) {
                    try {
                        if (!treeGrid.isSelected(childNode))
                            continue;
                    }
                    catch (Exception e) {
                        continue;
                    }

                    if (data.hasChildren(childNode))
                        updateSelectedLayers(mapService, childNode, isSelected);
                    else {
                        String layerID = childNode.getAttributeAsString("layerID");
                        if (layerID == null)
                            continue;

                        mapService.layerVisibility(layerID, isSelected);
                    }
                }
            }

            public void onSelectionChanged(SelectionEvent event)
            {
                TreeNode node = treeGrid.getTree().findById(event.getRecord().getAttribute("id"));
                while (treeGrid.getTree().getParent(node)!=root)node = treeGrid.getTree().getParent(node);
                String s = node.getAttribute("Layout");
                currentLayer = s;
                currentLayerLabel.setContents(s);
                currentNode = node;

                if (ser == null)
                    ser = new HashSet<MapService>();

                if (timer == null)
                    timer = new Timer() {
                        public void run() {
                            for (MapService d : ser) {
                                d.invalidate();
                            }
                            ser.clear();
                        }
                    };

                TreeNode treeNode = (TreeNode) event.getRecord();

                Object mapService = treeNode.getAttributeAsObject("service");
                if (mapService == null)
                    return;

                if (treeNode.getAttributeAsBoolean("isService")) {
                    ((MapService) mapService).visibility(event.getState());
                    ser.add((MapService) mapService);

                    timer.cancel();
                    timer.schedule(500);
                    return;
                }

                if (treeNode.getAttributeAsBoolean("isNodeGroup")) {
                    updateSelectedLayers((MapService) mapService, treeNode, event.getState());

                    ser.add((MapService) mapService);

                    timer.cancel();
                    timer.schedule(500);
                    return;
                }

                String layerID = treeNode.getAttributeAsString("layerID");
                if (layerID == null)
                    return;

                while ((treeNode = data.getParent(treeNode)) != null) {
                    try {
                        if (!treeGrid.isSelected(treeNode))
                            return;
                    }
                    catch (Exception e) {
                        if (data.getRoot() != treeNode)
                            return;
                    }
                }

                ((MapService) mapService).layerVisibility(layerID,
                        event.getState());
                ser.add((MapService) mapService);
                timer.cancel();
                timer.schedule(500);
            }
        });

        String   idPrefix = "";
        TreeNode treeNode = new TreeNode();

        for (int i = 0; i < config.layers().length(); i++)
        {
            JSONLayerConfig layer = config.layer(i).cast();
//			com.google.gwt.user.client.Window.alert(layer.select() + "");

            if (LAYER_TYPE_ARC_GIS_93.equals(layer.type())) {
                LayerUtils.addArcGIS93Layer(
                        layer.name(),
                        layer.serviceUrl(),
                        layer.infoServiceUrl(),
                        treeGrid,
                        layer.selected()
                );
            } else if (LAYER_TYPE_WMS.equals(layer.type())) {
                LayerUtils.addWMSLayer(
                        layer.name(),
                        layer.serviceUrl(),
                        layer.serviceName(),
                        treeGrid,
                        layer.selected()
                );
            }
        }

        LayerUtils.addGoogleStreetsLayer  (treeGrid);
        LayerUtils.addGoogleHybridLayer   (treeGrid);
        LayerUtils.addGoogleSatelliteLayer(treeGrid);
//		LayerUtils.addOSMLayer(treeGrid);

        // addYandex();

        addVectorLayer();
        addVectorLayer1();


        fullExtent.activate();
        navigation.activate();

        NavigationHistory navigationHistory = new NavigationHistory(zoomLast, zoomNext);
        navigationHistory.activate();

        zoomTo (4);
        LayerUtils.initLayerOrder(treeGrid);
/*
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        new Timer()
        {
            public void run()
            {
                cancel();
            }
        }.scheduleRepeating(10000);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Заголовок для проекта MosRegion
     */
    private void createHeaderMosRegion()
    {
        pageLayout = new VLayout();
        pageLayout.setWidth100();
        pageLayout.setHeight100();

        HLayout headerHLayout = new HLayout();
        headerHLayout.setWidth100();
        headerHLayout.setHeight(40);
        headerHLayout.setBackgroundColor("#B7F1A1");

        Label titleLabel = new Label();
        titleLabel.setAlign(Alignment.CENTER);
        titleLabel.setHeight(30);
        titleLabel.setStyleName("titleLabel");
        titleLabel.setWidth100();
                                // UNICODE - Электронная карта Московской области
        titleLabel.setContents("\u042D\u043B\u0435\u043A\u0442\u0440\u043E\u043D\u043D\u0430\u044F\u0020\u043A\u0430\u0440\u0442\u0430\u0020\u041C\u043E\u0441\u043A\u043E\u0432\u0441\u043A\u043E\u0439\u0020\u043E\u0431\u043B\u0430\u0441\u0442\u0438");

        headerHLayout.addMember(titleLabel);

        pageLayout.addMember(headerHLayout);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
