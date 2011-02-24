package ru.mos.gispro.tveravtodor.client.window;

import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.CloseClientEvent;

// import com.gispro.client.EastLineConstants;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class WindowBase extends Window
{
	protected    AsyncCallback<String>        callback = null;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public WindowBase(String title, int width, int height, final AsyncCallback<String> callback)
	{
		this.callback = callback     ;
		this.setTitle        (title );   
		this.setWidth        (width );   
		this.setHeight       (height);
		
		this.setIsModal      (true  );   
//		this.setShowModalMask(true  );   
		this.centerInPage    (      );  
		setShowMaximizeButton(false );
		setCanDragResize     (false );
		
		this.addCloseClickHandler(new CloseClickHandler()
        {   
            public void onCloseClick(CloseClientEvent event)
            {   
            	closeForm(); 
            }
        });
		createUserInterface ();
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	protected void createUserInterface() {}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void closeForm()
	{
//		System.out.println ("WindowBase - closeForm()");
		this.destroy();
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
