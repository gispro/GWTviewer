package ru.mos.gispro.client.navigation;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

/**
 * Created by IntelliJ IDEA.
 * User: ekoklin
 * Date: 17.03.11
 * Time: 11:38
 * To change this template use File | Settings | File Templates.
 */
public class NavigationHistory
{
    ToolStripButton         prev, next;
    public JavaScriptObject navigationHistory;

    public NavigationHistory(ToolStripButton prev, ToolStripButton next)
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

    void update() {
        prev.setDisabled(isPreviousStackEmpty(navigationHistory));
        next.setDisabled(isNextStackEmpty(navigationHistory));
    }

    public native boolean isPreviousStackEmpty(JavaScriptObject navigationHistory)
    /*-{
        return navigationHistory.previousStack.length <= 1;
    }-*/;

    public native boolean isNextStackEmpty(JavaScriptObject navigationHistory)
    /*-{
        return navigationHistory.nextStack.length == 0;
    }-*/;

    public native boolean previous(JavaScriptObject navigationHistory)
    /*-{
        return navigationHistory.previousTrigger() == null;
    }-*/;

    public native boolean next(JavaScriptObject navigationHistory)
   /*-{
        return navigationHistory.nextTrigger() == null;
    }-*/;

    protected native JavaScriptObject test()
    /*-{
        var navigationHistory = new $wnd.OpenLayers.Control.NavigationHistory();
        var this_ = this;
        navigationHistory.onPreviousChange = function(state, lendth){
            this_.@ru.mos.gispro.client.navigation.NavigationHistory::update()();
        };
        navigationHistory.onNextChange = function(state, lendth){
            this_.@ru.mos.gispro.client.navigation.NavigationHistory::update()();
        };

        $wnd.map.addControl(navigationHistory);
        return navigationHistory;
    }-*/;
}
