package ru.mos.gispro.client.navigation;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import ru.mos.gispro.client.GWTViewer;

/**
 * Created by IntelliJ IDEA.
 * User: ekoklin
 * Date: 17.03.11
 * Time: 11:39
 * To change this template use File | Settings | File Templates.
 */
public class Navigation implements ClickHandler
{
    private   JavaScriptObject      navigation;
    private   HandlerRegistration   handlerRegistration;

    public Navigation (HandlerRegistration  handlerRegistration)
    {
        this.handlerRegistration = handlerRegistration;
    }
    public void onClick(ClickEvent event)
    {
        GWTViewer.deactivateControls();
        activate();
    }

    public void activate()
    {
        if (navigation == null)
            navigation = test();
        activate(navigation);
        if (handlerRegistration != null)
        {
            Document.get().getElementById("map").getStyle().setCursor(Style.Cursor.DEFAULT);
            handlerRegistration.removeHandler();
            handlerRegistration = null;
        }
    }

    protected native void activate(JavaScriptObject navigation)
    /*-{
        for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
        {
            if ( $wnd.map.controls[indexControl].active  &&
               ( $wnd.map.controls[indexControl].displayClass == "olControlZoomBox" ||
                 $wnd.map.controls[indexControl].displayClass == "olControlNavigation"))
                 $wnd.map.controls[indexControl].deactivate();
        }
        navigation.activate();
    }-*/;

    protected native JavaScriptObject test()
    /*-{
        var navigation = new $wnd.OpenLayers.Control.Navigation();
        $wnd.map.addControl(navigation);
        return navigation;
    }-*/;
}
