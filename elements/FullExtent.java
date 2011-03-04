package ru.mos.gispro.client.elements;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import ru.mos.gispro.client.GWTViewer;

/**
 * Created by IntelliJ IDEA.
 * User: ekoklin
 * Date: 04.03.11
 * Time: 11:53
 * To change this template use File | Settings | File Templates.
 */
public class FullExtent  implements ClickHandler
{
    public void onClick(ClickEvent event)
    {
        GWTViewer.deactivateControls();
        activate();
    }

    public void activate()
    {
        doDeactivate();
        zoomToMaxExtent();
        zoomTo(4);
        doActivate();
        mapToCenter(GWTViewer.config.centerX(), GWTViewer.config.centerY());
    }

    public native void zoomTo(Integer lvl)
    /*-{
        $wnd.map.zoomTo(lvl);
    }-*/;
    public native void zoomToMaxExtent()
    /*-{
        $wnd.map.zoomToMaxExtent();
    }-*/;

    public native void mapToCenter(double lon, double lat)
    /*-{
        $wnd.map.setCenter(new $wnd.OpenLayers.LonLat(lon,lat),3);
    }-*/;

    protected native void doDeactivate()
    /*-{
        for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
        {
            if ($wnd.map.controls[indexControl].displayClass == "olControlNavigationHistory")
                $wnd.map.controls[indexControl].deactivate();
        }
    }-*/;

    protected native void doActivate()
    /*-{
        for (indexControl = 0;  indexControl < $wnd.map.controls.length; ++indexControl)
            if ($wnd.map.controls[indexControl].displayClass == "olControlNavigationHistory")
                $wnd.map.controls[indexControl].activate();
    }-*/;
}
