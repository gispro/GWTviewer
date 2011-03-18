package ru.mos.gispro.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.core.client.GWT;

import com.smartgwt.client.types.*;
import com.smartgwt.client.widgets.*;
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

import ru.mos.gispro.client.elements.*;

import ru.mos.gispro.client.geometry.GeometryManager;
import ru.mos.gispro.client.geometry.GeometryManager1;

import ru.mos.gispro.client.json.*;

import ru.mos.gispro.client.layer.*;
import ru.mos.gispro.client.navigation.Navigation;
import ru.mos.gispro.client.navigation.NavigationHistory;
import ru.mos.gispro.client.tad.LinearGraphButton;
import ru.mos.gispro.client.tad.PasportButton;
import ru.mos.gispro.client.tad.VideoButton;

import com.google.gwt.user.client.rpc.AsyncCallback;

import ru.mos.gispro.client.window.Authorization;
import ru.mos.gispro.client.window.BaseMapWindow;
import ru.mos.gispro.client.window.PropertyLayerWindow;
import ru.mos.gispro.client.window.Registration;

import java.util.*;

public class GWTViewer implements EntryPoint, IBaseMap
{
    public static        JSONConfig            config       ;
    public               JSONProject           project      ;
    private              Authorization         authorization;
    private              Registration          registration ;

                         JSONTerrs             terrs;
    private              VLayout               pageLayout;

    private              Tree                  data;
    private              TreeGrid              treeGrid;
    private              Tree                  baseData;

    private              TreeGrid              baseTree;
    private              BaseMapWindow         baseMapWindow;

    private              String                currentLayer;
    private              TreeNode              currentNode;
    private              Label                 currentLayerLabel = new Label("");

    private              PropertyLayerWindow   propertyLayerWindow;
    private              HandlerRegistration   handlerRegistration;
    private              LayerUtils            layerUtils             = null;

    public  static final  String                ACTION_RESULT_SUCCESS = "success";

    public  static final MapServiceInfoAsync    MapServiceInfoServlet = GWT.create(MapServiceInfo.class);

    public  static final String                 LAYER_TYPE_ARC_GIS_93 = "ArcGIS93";
    public  static final String                 LAYER_TYPE_WMS        = "WMS";

    private              boolean                withBaseMap           = true;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public native void initMap()
    /*-{
        $wnd.map = new $wnd.OpenLayers.Map("map", $wnd.options);
        $wnd.initMap();
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public native void addYandex()
    /*-{
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
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public native void mapToCenter(double lon, double lat)
    /*-{
        $wnd.map.setCenter(new $wnd.OpenLayers.LonLat(lon,lat),3);
//		$wnd.map.setCenter(new $wnd.OpenLayers.LonLat($wnd.configLayers.centerX,$wnd.configLayers.centerY),3);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    public native void zoomToMaxExtent() /*-{
//        $wnd.map.zoomToMaxExtent();
//    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public native void zoomTo(Integer lvl)
    /*-{
        $wnd.map.zoomTo(lvl);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
    class NavigationHistory
    {
        NavigationHistory(ToolStripButton prev, ToolStripButton next)
        {
            this.prev = prev;
            this.next = next;
        }

        public void activate()
        {
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
*/
//
//        void update() {
//            prev.setDisabled(isPreviousStackEmpty(navigationHistory));
//            next.setDisabled(isNextStackEmpty(navigationHistory));
//        }
//
//        public native boolean isPreviousStackEmpty(JavaScriptObject navigationHistory)
//        /*-{
//            return navigationHistory.previousStack.length <= 1;
//        }-*/;
//
//        public native boolean isNextStackEmpty(JavaScriptObject navigationHistory)
//        /*-{
//            return navigationHistory.nextStack.length == 0;
//        }-*/;
//
//        public native boolean previous(JavaScriptObject navigationHistory)
//        /*-{
//            return navigationHistory.previousTrigger() == null;
//        }-*/;
//
//        public native boolean next(JavaScriptObject navigationHistory)
//       /*-{
//            return navigationHistory.nextTrigger() == null;
//        }-*/;
//
//        protected native JavaScriptObject test()
//        /*-{
//            var navigationHistory = new $wnd.OpenLayers.Control.NavigationHistory();
//            var this_ = this;
//            navigationHistory.onPreviousChange = function(state, lendth){
//                this_.@ru.mos.gispro.client.GWTViewer.NavigationHistory::update()();
//            };
//            navigationHistory.onNextChange = function(state, lendth){
//                this_.@ru.mos.gispro.client.GWTViewer.NavigationHistory::update()();
//            };
//
//            $wnd.map.addControl(navigationHistory);
//            return navigationHistory;
//        }-*/;
//
//        ToolStripButton prev, next;
//        public JavaScriptObject navigationHistory;
//    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
    class Navigation implements ClickHandler
    {
        public void onClick(ClickEvent event)
        {
            deactivateControls();
            activate();
        }

        public void activate()
        {
            if (navigation == null)
                navigation = test();
            activate(navigation);
            if (handlerRegistration != null)
            {
                Document.get().getElementById("map").getStyle().setCursor(Cursor.DEFAULT);
                handlerRegistration.removeHandler();
                handlerRegistration = null;
            }
        }
*/
//        protected native void activate(JavaScriptObject navigation)
//        /*-{
//            for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
//            {
//                if ($wnd.map.controls[indexControl].active
//                    && ( $wnd.map.controls[indexControl].displayClass == "olControlZoomBox" ||
//                         $wnd.map.controls[indexControl].displayClass == "olControlNavigation"))
//                    $wnd.map.controls[indexControl].deactivate();
//            }
//            navigation.activate();
//        }-*/;
//
//        protected native JavaScriptObject test()
//        /*-{
//            var navigation = new $wnd.OpenLayers.Control.Navigation();
//            $wnd.map.addControl(navigation);
//            return navigation;
//        }-*/;
//
//        private JavaScriptObject navigation;
//    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public native void addVectorLayer()
    /*-{
            $wnd.vectors = new $wnd.OpenLayers.Layer.Vector(
                "Vector Layer",
                {
                    styleMap : new $wnd.OpenLayers.StyleMap({
                                            pointRadius   : "${type}", // sized according to type attribute
                                            strokeWidth   : $wnd.layerParams.strokeWidth  ,
                                            strokeColor   : $wnd.layerParams.strokeColor  ,
                                            strokeOpacity : $wnd.layerParams.strokeOpacity,
                                            fillColor     : $wnd.layerParams.fillColor    ,
                                            fillOpacity   : $wnd.layerParams.fillOpacity
                                        })
                }
            );
            $wnd.map.addLayer($wnd.vectors);
            $wnd.vectors.setZIndex(2000);
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public native void addVectorLayer1()
    /*-{
            $wnd.vectors1 = new $wnd.OpenLayers.Layer.Vector(
                "Vector Layer1",
                {
                    styleMap : new $wnd.OpenLayers.StyleMap({
                                            pointRadius   : "${type}", // sized according to type attribute
                                            strokeWidth   : $wnd.layerParams.strokeWidth1  ,
                                            strokeColor   : $wnd.layerParams.strokeColor1  ,
                                            strokeOpacity : $wnd.layerParams.strokeOpacity1,
                                            fillColor     : $wnd.layerParams.fillColor1    ,
                                            fillOpacity   : $wnd.layerParams.fillOpacity1
                                        })
                }
            );
            $wnd.map.addLayer($wnd.vectors1);
            $wnd.vectors1.setZIndex(2001);
    }-*/;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static native void deactivateControls()
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
/*
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
             com.google.gwt.user.client.Window.alert("JSONRequest.get : callbackName = " + callbackName +
                                                     ", JSONRequestHandler = " + handler + "\n" + url);
			createCallbackFunction(handler, callbackName);
            addScript(url);
		}
*/
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		public native void addScript(String url)
//        /*-{
//             var scr = document.createElement("script");
//             scr.setAttribute("language", "JavaScript"     );
//             scr.setAttribute("text"    , "text/javascript");
//             scr.setAttribute("src"     , url);
//             document.getElementsByTagName("head")[0].appendChild(scr);
//        }-*/;
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		private native void createCallbackFunction(JSONRequestHandler handler, String callbackName)
//        /*-{
//            tmpcallback = function(jsonObj)
//            {
//               handler.@ru.mos.gispro.client.JSONRequestHandler::onRequestComplete(Lcom/google/gwt/core/client/JavaScriptObject;)(jsonObj);
//            };
//            eval( "window." + callbackName + "=tmpcallback" );
//        }-*/;
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
    class ContentRequest
    {
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        public void get(String url, ContentRequestHandler handler)
        {
            String callbackName = "DocumentCallback" + handler.hashCode();
            get(url + "&callback=" + callbackName, callbackName, handler);
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        public void get(String url, String callbackName, ContentRequestHandler handler)
        {
            com.google.gwt.user.client.Window.alert("Contractor.ContentRequest.get : callbackName = " + callbackName +
                                                    ", ContentRequestHandler = " + handler + "\n" + url);
            createCallbackFunction(handler, callbackName);
            addScript(url);
        }
*/
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        public native void addScript(String url)
//        /*-{
//                var scr = document.createElement("script");
//                scr.setAttribute("language", "JavaScript");
//                scr.setAttribute("type", "text/javascript");
//                scr.setAttribute("src", url);
//                document.getElementsByTagName("head")[0].appendChild(scr);
//        }-*/;
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        private native void createCallbackFunction(ContentRequestHandler handler, String callbackName)
//        /*-{
//                 tmpcallback = function(j)
//                {
//                    handler.@ru.mos.gispro.client.ContentRequestHandler::onRequestComplete(Lcom/google/gwt/xml/client/Document;)(j);
//                };
//              eval( "window." + callbackName + "=tmpcallback" );
//        }-*/;
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
    class ServiceHandler implements JSONRequestHandler
    {
		public void onRequestComplete(JavaScriptObject content)
        {
			// JSONIdentify identify = content.cast();
            com.google.gwt.user.client.Window.alert("JSONObject : " + content);
//            com.google.gwt.user.client.Window.alert("" + content.toString().length());
		}
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    class ContentHandler implements ContentRequestHandler
    {
		public void onRequestComplete(com.google.gwt.xml.client.Document content)
        {
			// JSONIdentify identify = content.cast();
            com.google.gwt.user.client.Window.alert("XML : " + content);
//            com.google.gwt.user.client.Window.alert("" + content.toString().length());
		}
	}
*/
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void onModuleLoad()
    {
        project = new ProjectLoader().getConfig();
        config  = new ConfigLoader(project.getConfigFile()).getConfig();
/*
        String url = Contractors.SERVICE_URL_CONTRACTORS.replaceFirst("<0>", String.valueOf(30091)); // Contractors.SERVICE_URL_START + "30091" + Contractors.SERVICE_URL_END;
//        url = "http://maps.gispro.ru:8080/MAD/yyy.xml";
        url = "http://maps.gispro.ru:18080/geoserver/wfs?request=GetFeature&typename=uno:admpol&propertyname=caption,class_id,name_adm1";
//        url = "http://www.rbc.ru";
//        url = URL.encode(url);
//        com.google.gwt.user.client.Window.alert(url);

        ContentRequest request = new ContentRequest();
        ContentHandler serviceHandler = new ContentHandler();
        request.get(url, serviceHandler);

        JSONRequest jsonRequest = new JSONRequest();
        ServiceHandler service = new ServiceHandler();
        jsonRequest.get("http://maps.gispro.ru/ArcGIS/rest/services/MAD/mad_podrad_04_02_2011/MapServer?f=json&pretty=true", service);
//        jsonRequest.get(url, service);
*/
/*
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url);
        try {
            requestBuilder.sendRequest(null, new RequestCallback()
              {
                    public void onError(Request request, Throwable exception)
                    {
                        com.google.gwt.user.client.Window.alert("requestBuilder.sendRequest - onError : " + request );
                    }
                    public void onResponseReceived(Request request, Response response)
                    {
                        com.google.gwt.user.client.Window.alert("" + response + ", status ="  + response.getStatusCode());
                        if (response != null)
                        com.google.gwt.user.client.Window.alert("onResponseReceived.response.getText().length() = " +
                               response.getText().length() + ", response.getStatusCode())  = " + response.getStatusCode());
                    }
              });
        } catch (RequestException ex) {
            com.google.gwt.user.client.Window.alert("RequestException");
        }
*/
//        com.google.gwt.user.client.Window.alert("onModuleLoad.loadPeople ...");
/*
        GWTViewer.MapServiceInfoServlet.loadPeople("30091", new AsyncCallback<String>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(String content)
			{
				com.google.gwt.user.client.Window.alert("MapServiceInfoServlet.loadPeople - onSuccess : content = " + content);
			}
		});
*/
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
        layerUtils = new LayerUtils();

        HLayout mainLayout = new HLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        mainLayout.setDefaultResizeBars(LayoutResizeBarPolicy.MIDDLE);

        VLayout layoutLayers = new VLayout();
        layoutLayers.setHeight100();
        layoutLayers.setWidth("20%");

        final TreeNode root = new TreeNode("");

        data = new Tree();
        data.setModelType(TreeModelType.PARENT);
        data.setRootValue(1);
        data.setRoot(root);
        data.setNameProperty(LayerUtils.ATTRIBUTE_LAYOUT);

        treeGrid = new TreeGrid();
        treeGrid.setShowOpenIcons(true);
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

        final TreeNode baseRoot = new TreeNode("");

        baseData = new Tree      ();
        baseData.setModelType    (TreeModelType.PARENT);
        baseData.setRootValue    (1);
        baseData.setRoot         (baseRoot);
        baseData.setNameProperty (LayerUtils.ATTRIBUTE_LAYOUT);

        baseTree = new TreeGrid();
        baseTree.setShowOpenIcons        (true);
        baseTree.setShowDropIcons        (false);
        baseTree.setSelectionAppearance  (SelectionAppearance.CHECKBOX);
        baseTree.setShowSelectedStyle    (false);
        baseTree.setShowPartialSelection (false);
//		baseTree.setCascadeSelection(false);
        baseTree.setCanSort              (false);
        baseTree.setCanReorderFields     (false);
        baseTree.setCanReorderRecords    (false);
        baseTree.setData                 (baseData);
        baseTree.setHeaderHeight(0);
        baseTree.getField(0).setTitle("BaseMap");

        treeGrid.addCellClickHandler(new CellClickHandler()
        {
            public void onCellClick(CellClickEvent event)
            {
                TreeNode node = treeGrid.getTree().findById(event.getRecord().getAttribute("id"));
                while (treeGrid.getTree().getParent(node) != root)
                    node = treeGrid.getTree().getParent(node);
                String s = node.getAttribute(LayerUtils.ATTRIBUTE_LAYOUT);
                currentLayer = s;
                currentLayerLabel.setContents(s);
                currentNode = node;
                if (propertyLayerWindow != null)
                    propertyLayerWindow.setCurrentNode(currentNode);
            }
        });

        ToolStrip toolStripLayers = new ToolStrip();
        toolStripLayers.setWidth100();
        toolStripLayers.setHeight(40);
                                         // UNICODE - Список слоев
        Label contentLayers = new Label ("\u0421\u043F\u0438\u0441\u043E\u043A\u0020\u0441\u043B\u043E\u0435\u0432");
        contentLayers.setHeight(30);
        contentLayers.setStyleName("contentLabel");

        toolStripLayers.addSpacer(10);
        toolStripLayers.addMember(contentLayers);

        ToolStripButton addMapButton = null;
//		addMapButton.setTooltip("Добавить сервис");

        if (config.debug_serviceADD())
        {
            addMapButton = new AddMapButton(treeGrid, layerUtils);
            addMapButton.setTooltip("Добавить сервис");
        }

        ToolStripButton propertyLayerButton = new ToolStripButton();
        propertyLayerButton.setTooltip("\u041D\u0430\u0441\u0442\u0440\u043E\u0438\u0442\u044C\u0020\u043F\u043E\u0440\u044F\u0434\u043E\u043A\u0020\u0438\u0020\u043F\u0440\u043E\u0437\u0440\u0430\u0447\u043D\u043E\u0441\u0442\u044C\u0020\u0441\u043B\u043E\u0435\u0432"); // ""Настроить порядок и прозрачность слоев"
        propertyLayerButton.setIcon("Layer_Properties.png");
        propertyLayerButton.setIconSize(24);
        propertyLayerButton.setHeight(30);

        propertyLayerButton.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                if (propertyLayerWindow == null)
                    propertyLayerWindow = new PropertyLayerWindow(treeGrid, currentNode, currentLayerLabel);
                propertyLayerWindow.setCurrentNode(currentNode);
                propertyLayerWindow.show();
            }
        });

        if (config.debug_serviceADD())
        {
            toolStripLayers.addSpacer(5);
            toolStripLayers.addButton(addMapButton);
        }
//		toolStripLayers.addButton(propertyLayerButton);

        TerrTreePickTree treePickTreeItem = null;
        if (config.municipalities())
        {
            treePickTreeItem = new TerrTreePickTree();
            terrs = new TerrTreeLoader().getTerrTree();

            TerrTree terrTree = new TerrTree();
            terrTree.createTerrTree(terrs);
            treePickTreeItem.setValueTree(terrTree);
//		    toolStripLayers.addFormItem(treePickTreeItem);      //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        }
/*
        SectionStack sectionStack = new SectionStack();
        sectionStack.setHeight(600);
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);
        sectionStack.setAnimateSections(true);
        sectionStack.setOverflow(Overflow.HIDDEN);

        SectionStackSection layersSection = new SectionStackSection();
                                             // Список слоев
        layersSection.setTitle("\u0421\u043F\u0438\u0441\u043E\u043A\u0020\u0441\u043B\u043E\u0435\u0432");
        layersSection.setExpanded(true);
        layersSection.setItems(treeGrid);
*/
        HLayout baseTreeLayout = new HLayout();
        baseTreeLayout.setWidth100();
        baseTreeLayout.setHeight(1); //200);
        baseTreeLayout.addMember(baseTree);

        layoutLayers.addMember(toolStripLayers);
        layoutLayers.addMember(treeGrid);
        layoutLayers.addMember(baseTreeLayout);
        mainLayout.addMember(layoutLayers);

        VLayout layout = new VLayout();
        final Canvas canvas = new Canvas();

        ToolStrip toolStrip = new ToolStrip();
        toolStrip.setWidth100();
        toolStrip.setHeight(40);

        ToolStripButton baseMap = null;
        if (withBaseMap)
        {
//            final BaseMapWindow baseMapWindow;
            if (baseMapWindow == null)
                baseMapWindow = new BaseMapWindow(this);

            baseMap = new ToolStripButton();
            baseMap.setIcon("Layer_Properties.png");
            baseMap.setIconSize(24);
            baseMap.setHeight(30);
                                  //  Картооснова
            baseMap.setTooltip("\u041A\u0430\u0440\u0442\u043E\u043E\u0441\u043D\u043E\u0432\u0430");
            baseMap.addClickHandler(new ClickHandler()
            {
                public void onClick(ClickEvent event)
                {
                    baseMapWindow.show();
                    // com.google.gwt.user.client.Window.alert("baseMap.addClickHandler");
                }
            });
        }

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
        zoomIn.addClickHandler(new ZoomClickHandler(handlerRegistration, false));

        final ToolStripButton zoomOut = new ToolStripButton();
        zoomOut.setIcon("MActionZoomOut.png");
        zoomOut.setIconSize(24);
        zoomOut.setHeight(30);
        zoomOut.setActionType(SelectionType.RADIO);
        zoomOut.setRadioGroup("mapAction");
                                                          // "Отдалить"
        zoomOut.setTooltip("\u041E\u0442\u0434\u0430\u043B\u0438\u0442\u044C");
        zoomOut.addClickHandler(new ZoomClickHandler(handlerRegistration, true));

        ToolStripButton zoomFullExtent = null;
        if (config.toolButtonFullExtent())
        {
            zoomFullExtent = new ToolStripButton();
            zoomFullExtent.setIcon("MActionZoomFullExtent.png");
            zoomFullExtent.setIconSize(24);
            zoomFullExtent.setHeight(30);
            zoomFullExtent.setTooltip("\u0412\u0441\u044F\u0020\u043A\u0430\u0440\u0442\u0430"); // "Вся карта"
        }

        FullExtent fullExtent = new FullExtent();
        if (config.toolButtonFullExtent())
            zoomFullExtent.addClickHandler(fullExtent);

        final ToolStripButton pan = new ToolStripButton();
        pan.setIcon("MActionPan.png");
        pan.setIconSize(24);
        pan.setHeight(30);
        pan.setActionType(SelectionType.RADIO);
        pan.setRadioGroup("mapAction");    // ""Панорамирование"
        pan.setTooltip("\u041F\u0430\u043D\u043E\u0440\u0430\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435");

        Navigation navigation = new Navigation(handlerRegistration);
        pan.addClickHandler(navigation);

        final ToolStripButton identify = new IdentifyButton(treeGrid, canvas);
                                         // "Информация"
        identify.setTooltip("\u0418\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u044F");
        final ToolStripButton find = new FindButton();
                                         // "Расширенный поиск"
        find.setTooltip("\u0420\u0430\u0441\u0448\u0438\u0440\u0435\u043D\u043D\u044B\u0439\u0020\u043F\u043E\u0438\u0441\u043A");

        ToolStripButton roadPasport = null;
        ToolStripButton linearGraph = null;
        ToolStripButton video       = null;
        if (config.isTverAvtoDor())
        {
            roadPasport = new PasportButton(canvas);
                                        // "Паспорт дороги"
            roadPasport.setTooltip("\u041F\u0430\u0441\u043F\u043E\u0440\u0442\u0020\u0434\u043E\u0440\u043E\u0433\u0438");
            linearGraph = new LinearGraphButton(canvas);
                                        // ""Линейный график"
            linearGraph.setTooltip("\u041B\u0438\u043D\u0435\u0439\u043D\u044B\u0439\u0020\u0433\u0440\u0430\u0444\u0438\u043A");
            video = new VideoButton(canvas);
                                        // ""Видео по дороге"
            video.setTooltip("\u0412\u0438\u0434\u0435\u043E\u0020\u043F\u043E\u0020\u0434\u043E\u0440\u043E\u0433\u0435");
        }
        final ToolStripButton clearGeometry = new ToolStripButton();
        clearGeometry.setIcon("MActionClearSelect.png");
        clearGeometry.setIconSize(24);
        clearGeometry.setHeight(30);
        clearGeometry.setWidth(30);
        clearGeometry.setActionType(SelectionType.BUTTON);
        clearGeometry.setTooltip("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C\u0020\u0432\u044B\u0431\u043E\u0440\u043A\u0443"); //  "Очистить выборку"
        clearGeometry.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
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
        if (withBaseMap)
            toolStrip.addButton(baseMap);
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
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        treeGrid.addSelectionChangedHandler(new SelectionChangedHandler()
        {
            Set<MapService> ser;
            Timer timer;

            protected void updateSelectedLayers(MapService mapService, TreeNode treeNode, boolean isSelected)
            {
                for (TreeNode childNode : data.getChildren(treeNode))
                {
                    try
                    {
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
                while (treeGrid.getTree().getParent(node) != root)
                    node = treeGrid.getTree().getParent(node);
                String s = node.getAttribute(LayerUtils.ATTRIBUTE_LAYOUT);
                currentLayer = s;
                currentLayerLabel.setContents(s);
                currentNode = node;
                if (propertyLayerWindow != null)
                    propertyLayerWindow.setCurrentNode(currentNode);
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

                Object mapService = treeNode.getAttributeAsObject(LayerUtils.String_service); //  "service");
                if (mapService == null)
                    return;

                if (treeNode.getAttributeAsBoolean(LayerUtils.String_isService)) //  "isService"))
                {
                    ((MapService) mapService).visibility(event.getState());
                    ser.add((MapService) mapService);

                    timer.cancel();
                    timer.schedule(500);
                    return;
                }

                if (treeNode.getAttributeAsBoolean("isNodeGroup"))
                {
                    updateSelectedLayers((MapService) mapService, treeNode, event.getState());

                    ser.add((MapService) mapService);

                    timer.cancel();
                    timer.schedule(500);
                    return;
                }

                String layerID = treeNode.getAttributeAsString("layerID");
                if (layerID == null)
                    return;

                while ((treeNode = data.getParent(treeNode)) != null)
                {
                    try {
                        if (!treeGrid.isSelected(treeNode))
                            return;
                    }
                    catch (Exception e) {
                        if (data.getRoot() != treeNode)
                            return;
                    }
                }

                ((MapService) mapService).layerVisibility(layerID, event.getState());
                ser.add((MapService) mapService);
                timer.cancel();
                timer.schedule(500);
            }
        });
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        baseTree.addSelectionChangedHandler(new SelectionChangedHandler()
        {
            Set<MapService> services;
            Timer timer;

            protected void updateSelectedLayers(MapService mapService, TreeNode treeNode, boolean isSelected)
            {
                for (TreeNode childNode : baseData.getChildren(treeNode))
                {
                    try
                    {
                        if (!baseTree.isSelected(childNode))
                            continue;
                    }
                    catch (Exception e) {
                        continue;
                    }

                    if (baseData.hasChildren(childNode))
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
/*
                TreeNode node = treeGrid.getTree().findById(event.getRecord().getAttribute("id"));
                while (treeGrid.getTree().getParent(node) != root)
                    node = treeGrid.getTree().getParent(node);
                String s = node.getAttribute(LayerUtils.ATTRIBUTE_LAYOUT);
                currentLayer = s;
                currentLayerLabel.setContents(s);
                currentNode = node;
                if (propertyLayerWindow != null)
                    propertyLayerWindow.setCurrentNode(currentNode);
*/
//                com.google.gwt.user.client.Window.alert("0. baseTree.onSelectionChanged");
                if (services == null)
                    services = new HashSet<MapService>();

                if (timer == null)
                    timer = new Timer()
                    {
                        public void run()
                        {
                            for (MapService d : services)
                            {
                                d.invalidate();
                            }
                            services.clear();
                        }
                    };

                TreeNode treeNode = (TreeNode) event.getRecord();
//                com.google.gwt.user.client.Window.alert("baseTree.onSelectionChanged : treeNode = " + treeNode.getAttribute(LayerUtils.ATTRIBUTE_LAYOUT));
                Object mapService = treeNode.getAttributeAsObject(LayerUtils.String_service);
                if (mapService == null)
                    return;

                if (treeNode.getAttributeAsBoolean(LayerUtils.String_isService))
                {
                    ((MapService) mapService).visibility(event.getState());
                    services.add((MapService) mapService);

                    timer.cancel();
                    timer.schedule(500);
                    return;
                }

                if (treeNode.getAttributeAsBoolean("isNodeGroup"))
                {
                    updateSelectedLayers((MapService) mapService, treeNode, event.getState());

                    services.add((MapService) mapService);

                    timer.cancel();
                    timer.schedule(500);
                    return;
                }

                String layerID = treeNode.getAttributeAsString("layerID");
                if (layerID == null)
                    return;

                while ((treeNode = baseData.getParent(treeNode)) != null)
                {
                    try {
                        if (!baseTree.isSelected(treeNode))
                            return;
                    }
                    catch (Exception e) {
                        if (baseData.getRoot() != treeNode)
                            return;
                    }
                }

                ((MapService) mapService).layerVisibility(layerID, event.getState());
                services.add((MapService) mapService);
                timer.cancel();
                timer.schedule(500);
            }
        });
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        String   idPrefix = "";
        TreeNode treeNode = new TreeNode();

        String baseMapURL   = config.getBaseMapURL  ();
        String baseMapTitle = config.getBaseMapTitle();
        String baseMapType  = config.getBaseMapType ();

        if (!withBaseMap)
        {
            for (int i = 0; i < config.layers().length(); i++)
            {
                JSONLayerConfig layer = config.layer(i).cast();
                if (LAYER_TYPE_ARC_GIS_93.equals(layer.type()))
                    layerUtils.addArcGIS93Layer (layer.name(), layer.serviceUrl(), layer.infoServiceUrl(), treeGrid,
                                                 layer.selected(), layerUtils);
                else if (LAYER_TYPE_WMS.equals(layer.type()))
                    LayerUtils.addWMSLayer (layer.name(), layer.serviceUrl(), layer.serviceName(), treeGrid, layer.selected());
            }
            layerUtils.addGoogleStreetsLayer    (treeGrid);
            layerUtils.addGoogleHybridLayer     (treeGrid);
            layerUtils.addGoogleSatelliteLayer  (treeGrid);

            layerUtils.addBingMapRoadLayer      (treeGrid);
            layerUtils.addBingMapSatelliteLayer (treeGrid);
            layerUtils.addBingMapHybridLayer    (treeGrid);
        }
        else
        {
            for (int i = 0; i < config.layers().length(); i++)
            {
                JSONLayerConfig layer = config.layer(i).cast();
                if (!layer.serviceUrl().equals(baseMapURL))
                {
                    if (LAYER_TYPE_ARC_GIS_93.equals(layer.type()))
                    {
                        layerUtils.addArcGIS93Layer (layer.name(), layer.serviceUrl(), layer.infoServiceUrl(),
                                                                   treeGrid, layer.selected(), layerUtils);
                    }
                    else if (LAYER_TYPE_WMS.equals(layer.type()))
                    {
                        LayerUtils.addWMSLayer (layer.name(), layer.serviceUrl(), layer.serviceName(),
                                                                                  treeGrid, layer.selected());
                    }
                } else
                    layerUtils.addArcGIS93Layer (layer.name(), layer.serviceUrl(), baseTree, layerUtils);
            }
            layerUtils.addGoogleStreetsLayer    (baseTree);
            layerUtils.addGoogleHybridLayer     (baseTree);
            layerUtils.addGoogleSatelliteLayer  (baseTree);

            layerUtils.addBingMapRoadLayer      (baseTree);
            layerUtils.addBingMapSatelliteLayer (baseTree);
            layerUtils.addBingMapHybridLayer    (baseTree);
        }
//		LayerUtils.addOSMLayer(treeGrid);
//      addYandex();

        addVectorLayer();
        addVectorLayer1();

        fullExtent.activate();
        navigation.activate();

        NavigationHistory navigationHistory = new NavigationHistory(zoomLast, zoomNext);
        navigationHistory.activate();

        zoomTo (4);
//        LayerUtils.initLayerOrder(treeGrid);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setBaseMap (String baseMap)
    {
        for (int i = 0; i < BaseMapWindow.baseMapList.length; i++)
        {
           if (BaseMapWindow.baseMapList[i].equalsIgnoreCase(baseMap))
           {
               for (int j = 0; j < layerUtils.baseMaps.length; j++)
               {
                   if (layerUtils.baseMaps[j] != null)
                   {
                       if (j == i)
                           baseTree.selectRecord(layerUtils.baseMaps[j]);
                       else
                           baseTree.deselectRecord(layerUtils.baseMaps[j]);
                   }
               }
               break;
           }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void closeBaseMapWindow ()
    {
        baseMapWindow.hide();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
        new Timer()
        {
            public void run()
            {
                cancel();
            }
        }.scheduleRepeating(10000);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
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
