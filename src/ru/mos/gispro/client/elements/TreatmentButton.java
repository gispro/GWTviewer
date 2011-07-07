package ru.mos.gispro.client.elements;

import ru.mos.gispro.client.IBaseMap;
import ru.mos.gispro.client.window.TreatmentForm;

import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.tree.TreeGrid;

public class TreatmentButton extends ToolStripButton
{
	private                   HandlerRegistration     handlerRegistration;
    private                   TreatmentForm           treatmentForm;
	private                   boolean                 isClickHandlerOn = false;  
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	protected native void reactivateControls()
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
    private native String getPointLocation()
    /*-{
        var extent = $wnd.map.getExtent();
        var size   = $wnd.map.getSize  ();
        var mouse;
        for (indexControl = 0; indexControl < $wnd.map.controls.length; ++indexControl)
        {
            if ($wnd.map.controls[indexControl].displayClass == "olControlMousePosition")
            {
                mouse = $wnd.map.controls[indexControl];
                break;
            }
        }
        var str = null;
        if (mouse != null)
        {
       		var point = $wnd.map.getLonLatFromPixel(mouse.lastXy);
        	if (point != null)
        		str = point.lon + "," + point.lat;
       	}
        return str;
    }-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public TreatmentButton(final TreeGrid treeGrid, final Canvas canvas, final IBaseMap iCallback)
    {
		this.setIcon("treatment.png");
		this.setIconSize(24);
		this.setHeight  (30);
		this.setActionType(SelectionType.RADIO);
		this.setRadioGroup("mapAction");
		
//		this.iCallback = iCallback;
		
		this.addClickHandler(new ClickHandler()
        {
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            private void createHandlerRegistration()
            {
                handlerRegistration = canvas.addClickHandler(new ClickHandler()
                {
                    public void onClick(ClickEvent event)
                    {
                        if (!isSelected()) return;
//        	            com.google.gwt.user.client.Window.alert("TreatmentButton.handlerRegistration : isSelected = " + isSelected());
        	            String point = getPointLocation();
        	            if (point != null)
        	            {
        	            	treatmentForm.drawLocation(point);
        	            	treatmentForm.drawEmail("alexandr@yandex.ru");
        	            }
//    	            	com.google.gwt.user.client.Window.alert("TreatmentButton.handlerRegistration : getPointLocation() = " + point);
        	            treatmentForm.show();
                    }
                });
                isClickHandlerOn = true;
            }
			public void onClick(ClickEvent event)
			{
				reactivateControls();
				if (treatmentForm == null)
					treatmentForm = new TreatmentForm(iCallback);
				if (isSelected())
				{
		            if (!isClickHandlerOn)
		            	createHandlerRegistration();
				} else
					handlerRegistration.removeHandler();
			}
        });
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public boolean isTreatmentFormOpened()
	{
		return ((treatmentForm != null) && (treatmentForm.isVisible()));
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void hideTreatmentForm()
	{
		if ((treatmentForm != null) && (treatmentForm.isVisible()))
			treatmentForm.hide();
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
