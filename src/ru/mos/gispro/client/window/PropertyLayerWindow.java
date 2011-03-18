package ru.mos.gispro.client.window;

import com.smartgwt.client.widgets.Window;
import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;
import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.client.layer.LayerUtils;
import ru.mos.gispro.client.layer.MapService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ekoklin
 * Date: 14.03.11
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */
public class PropertyLayerWindow extends Window
{
    private   TreeGrid   tree;
    private   TreeNode   currentNode;
//    private   Label      label;
    private   Slider     opacitySlider = null;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    public PropertyLayerWindow (TreeGrid treeGrid)
    public PropertyLayerWindow (TreeGrid treeGrid, final TreeNode node, Label label)
    {
        this.tree        = treeGrid;
        this.currentNode = node    ;
//        this.label = label   ;

        setTitle("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0438\u0020\u0441\u0435\u0440\u0432\u0438\u0441\u0430");
        setHeight(190);
        setWidth(500);
        setShowMinimizeButton(false);
        setShowMaximizeButton(false);
//        setShowMaximizeButton(true);
        centerInPage();
        setCanDragResize(false);

        Canvas layerManageCanvas = new Canvas();
        layerManageCanvas.setWidth100();
        layerManageCanvas.setHeight100();
                                         // Слой:
        Label infoLayerNameLabel = new Label("\u0421\u043B\u043E\u0439\u003A");
        infoLayerNameLabel.setHeight(30);
        infoLayerNameLabel.setWidth(50);
        infoLayerNameLabel.setTop(10);
        infoLayerNameLabel.setLeft(10);

//        label = new Label();
        label.setHeight(30);
        label.setWidth(300);
        label.setTop(10);
        label.setLeft(100);

        Button upLayerButton = new Button("");
        upLayerButton.setIcon("upcontrol.png");
        upLayerButton.setIconSize(16);
        upLayerButton.setIconAlign("center");
        upLayerButton.setHeight(30);
        upLayerButton.setWidth(24);
        upLayerButton.setTop(10);
        upLayerButton.setLeft(410);

                              // Поднять слой вверх. (отдалить)
        upLayerButton.setTooltip("\u041F\u043E\u0434\u043D\u044F\u0442\u044C\u0020\u0441\u043B\u043E\u0439\u0020\u0432\u0432\u0435\u0440\u0445\u002E\u0020\u0028\u043E\u0442\u0434\u0430\u043B\u0438\u0442\u044C\u0029");
        upLayerButton.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent clickEvent)
            {
                moveLayer (true);
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
                               // Опустить слой вниз. (приблизить)
        downLayerButton.setTooltip("\u041E\u043F\u0443\u0441\u0442\u0438\u0442\u044C\u0020\u0441\u043B\u043E\u0439\u0020\u0432\u043D\u0438\u0437\u002E\u0020\u0028\u043F\u0440\u0438\u0431\u043B\u0438\u0437\u0438\u0442\u044C\u0029");
        downLayerButton.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent clickEvent)
            {
                moveLayer (false);
            }
        });
                                          // Прозрачность:
        Label infoSliderNameLabel = new Label("\u041F\u0440\u043E\u0437\u0440\u0430\u0447\u043D\u043E\u0441\u0442\u044C\u003A");
        infoSliderNameLabel.setHeight(60);
        infoSliderNameLabel.setWidth(60);
        infoSliderNameLabel.setTop(50);
        infoSliderNameLabel.setLeft(10);

        opacitySlider = new Slider("");
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

        opacitySlider.addDrawHandler(new DrawHandler()
        {
            public void onDraw(DrawEvent drawEvent)
            {
                opacitySlider.addValueChangedHandler(new ValueChangedHandler()
                {
                    public void onValueChanged(ValueChangedEvent event)
                    {
                        MapService service = (MapService) currentNode.getAttributeAsObject(LayerUtils.String_service);
                        if (service != null)
                        {
                            JavaScriptObject layer = service.getLayer();

                            float f = (float) event.getValue() / 100f;
                            LayerUtils.setLayerOpacity (layer, f);
                            service   .setLayerOpacity (f);
                        }
                    }
                });
            }
        });
                                    // Порядок слоев влияет на их видимость при отображении
        Label attentionLabel = new Label("\u041F\u043E\u0440\u044F\u0434\u043E\u043A\u0020\u0441\u043B\u043E\u0435\u0432\u0020\u0432\u043B\u0438\u044F\u0435\u0442\u0020\u043D\u0430\u0020\u0438\u0445\u0020\u0432\u0438\u0434\u0438\u043C\u043E\u0441\u0442\u044C\u0020\u043F\u0440\u0438\u0020\u043E\u0442\u043E\u0431\u0440\u0430\u0436\u0435\u043D\u0438\u0438");
        attentionLabel.setHeight(30);
        attentionLabel.setTop(120);
//	    attentionLabel.setLeft(10);
        attentionLabel.setWidth100();
        attentionLabel.setMargin(10);
        attentionLabel.setStyleName("attentionLabel");

        layerManageCanvas.addChild(infoLayerNameLabel);
        layerManageCanvas.addChild(label);
        layerManageCanvas.addChild(upLayerButton);
        layerManageCanvas.addChild(downLayerButton);

        layerManageCanvas.addChild(infoSliderNameLabel);
        layerManageCanvas.addChild(opacitySlider);
        layerManageCanvas.addChild(attentionLabel);

        addItem(layerManageCanvas);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setCurrentNode (TreeNode node)
    {
        this.currentNode = node;
        MapService service = (MapService) currentNode.getAttributeAsObject(LayerUtils.String_service);
        if (service != null)
            opacitySlider.setValue(LayerUtils.getLayerOpacity(service) * 100f);
//    com.google.gwt.user.client.Window.alert("PropertyLayerWindow.setCurrentNode : currentNode = " + currentNode.getAttribute(LayerUtils.ATTRIBUTE_LAYOUT));
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
    public void setCurrentNode ()
    {
        TreeNode[] nodes = tree.getTree().getChildren(tree.getTree().getRoot());

        for (TreeNode n : nodes)
        {
            if (tree.isSelected(n))
            {
                this.node = n;
                this.label.setContents(n.getAttribute(LayerUtils.ATTRIBUTE_LAYOUT));
                break;
            }
        }
        MapService service = (MapService) node.getAttributeAsObject("service");
        if (service != null)
            opacitySlider.setValue(LayerUtils.getLayerOpacity(service) * 100f);
    }
*/
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
    public TreeNode getCurrentNode ()
    {
        return node;
    }
*/
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void moveLayer (boolean moveUp)
    {
        TreeNode        root         = tree.getTree().getRoot();
        List<TreeNode>  rootNodes    = new ArrayList<TreeNode>();
        List<TreeNode>  newRootNodes = new ArrayList<TreeNode>();
        List<Integer>   rootIds      = new ArrayList<Integer>();

        TreeNode[] nodes = tree.getTree().getChildren(root);

        int i = -1;
        for (TreeNode n : nodes)
        {
            i++;
            if (tree.getTree().getParent(n)!=root)continue;
            rootNodes.add(n);
            rootIds.add(i);
            newRootNodes.add(n);
        }

        if (moveUp)
        {
            for (int k = 0; k < rootNodes.size(); k++)
            {
                if (rootNodes.get(k) == currentNode)
                {
                    if (k == 0) break;
                    tree.getTree().move(currentNode, root, rootIds.get(k-1));

                    TreeNode tn = newRootNodes.get(k-1);
                    newRootNodes.set(k-1, currentNode);
                    newRootNodes.set(k, tn);
                    break;
                }
            }
        }
        else
        {
            for (int k = 0; k < rootNodes.size(); k++)
            {
                if (rootNodes.get(k) == currentNode)
                {
                    if (k == rootNodes.size()) break;
                    tree.getTree().move(rootNodes.get(k+1), root, rootIds.get(k));

                    TreeNode tn = newRootNodes.get(k+1);
                    newRootNodes.set(k+1, currentNode);
                    newRootNodes.set(k, tn);
                    break;
                }
            }
        }
        LayerUtils.setLayerZIndex(newRootNodes);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
