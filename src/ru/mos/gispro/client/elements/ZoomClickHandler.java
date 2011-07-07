package ru.mos.gispro.client.elements;

import ru.mos.gispro.client.GWTViewer;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Document;
import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 * Created by IntelliJ IDEA.
 * User: ekoklin
 * Date: 04.03.11
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
public class ZoomClickHandler implements ClickHandler
{
    private   JavaScriptObject     zoomBox             = null;
    private   HandlerRegistration  handlerRegistration = null;
    private   boolean              zoomOut             = false;

    public ZoomClickHandler(HandlerRegistration  handler, boolean zoomOut)
    {
        this.handlerRegistration = handler;
        this.zoomOut             = zoomOut;
    }

    public void onClick(ClickEvent event)
    {
        GWTViewer.deactivateControls();
        if ((zoomBox == null) && !zoomOut)
            zoomBox = zoomIn();
        else if ((zoomBox == null) && zoomOut)
            zoomBox = zoomOut();
        activate(zoomBox);
        if (handlerRegistration != null)
        {
            Document.get().getElementById("map").getStyle().setCursor(Style.Cursor.DEFAULT);
            handlerRegistration.removeHandler();
            handlerRegistration = null;
        }
    }

    protected native void activate(JavaScriptObject zoomBox)
    /*-{
        for (indexControl = 0; indexControl < $wnd.map.controls.length; ++indexControl)
        {
            if ($wnd.map.controls[indexControl].active && ( $wnd.map.controls[indexControl].displayClass == "olControlZoomBox" ||
                                                            $wnd.map.controls[indexControl].displayClass == "olControlNavigation"))
                $wnd.map.controls[indexControl].deactivate();
        }
        zoomBox.activate();
    }-*/;

    protected native JavaScriptObject zoomIn()
    /*-{
        var zoomBox = new $wnd.OpenLayers.Control.ZoomBox();
        $wnd.map.addControl(zoomBox);
        return zoomBox;
    }-*/;

    protected native JavaScriptObject zoomOut()
    /*-{
        var zoomBox = new $wnd.OpenLayers.Control.ZoomBox({displayClass: "ZoomBox", out: true});
        $wnd.map.addControl(zoomBox);
        return zoomBox;
    }-*/;
}
