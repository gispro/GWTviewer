package ru.mos.gispro.client.window;

// import com.smartgwt.client.types.LayoutResizeBarPolicy;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextAreaWrap;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.CloseClientEvent;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
// import com.smartgwt.client.widgets.layout.VLayout;

import ru.mos.gispro.client.IBaseMap;
import ru.mos.gispro.shared.Treatment;

public class TreatmentWindow extends Window
{
	private DynamicForm treatmentForm   = null;
	private Canvas      treatmentCanvas = null;
	private int         HEIGHT          = 600;
	private int         WIDTH           = 400;
//	private IBaseMap    iCallback       = null;
	private Treatment   treatment       = null;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public TreatmentWindow(final IBaseMap iCallback)
    {
                                                                        // Обращение населения
        setTitle("\u041E\u0431\u0440\u0430\u0449\u0435\u043D\u0438\u0435\u0020\u043D\u0430\u0441\u0435\u043B\u0435\u043D\u0438\u044F");
        setHeight (HEIGHT);
        setWidth  (WIDTH );

        setShowMaximizeButton(false);
        centerInPage();
        setCanDragResize(true);
        
		treatmentCanvas = new Canvas();   
		treatmentCanvas.setHeight (20);   
		treatmentCanvas.setPadding(10);
		treatmentCanvas.setTop    (20);
		
		treatmentForm = new DynamicForm();   
		treatmentForm.setHeight  (250);
		treatmentForm.setPadding ( 10);
//		treatmentForm.setMargin  (  0);
//		treatmentForm.setTop     ( 10);

		treatmentForm.setNumCols(2);
		treatmentForm.setTitleWidth(110);
		
//		treatmentForm.setIsGroup(true);   
//		treatmentForm.setGroupTitle("\u041E\u0431\u0440\u0430\u0449\u0435\u043D\u0438\u0435");   // Обращение

																	// Дата обращения 			
        TextItem  reported = new TextItem ("tiReported");    reported.setTitle ("\u0414\u0430\u0442\u0430\u0020\u043E\u0431\u0440\u0430\u0449\u0435\u043D\u0438\u044F");
                                                             reported.setWidth("*");
                                                             // reported.disable();
                                                             
        TextItem  email    = new TextItem ("tiEmail"   );    email   .setTitle ("Email");
                                                             email.setWidth("*");   
                                                                                // Долгота
        TextItem  lon      = new TextItem ("tiLon"     );    lon     .setTitle ("\u0414\u043E\u043B\u0433\u043E\u0442\u0430");
                                                             lon.setWidth("*");   
        TextItem  lat      = new TextItem ("tiLat"     );    lat     .setTitle ("\u0428\u0438\u0440\u043E\u0442\u0430");
                                                             lat.setWidth("*");   
                                                                                // Присоединившихся
        TextItem  count    = new TextItem ("tiCount"   );    count   .setTitle ("\u041F\u0440\u0438\u0441\u043E\u0435\u0434\u0438\u043D\u0438\u0432\u0448\u0438\u0445\u0441\u044F");
                                                             count.setWidth("*");   
        
        TextAreaItem text  = new TextAreaItem("tiText" );    text.setTitle("\u0422\u0435\u043A\u0441\u0442");  // Текст
        TitleOrientation titleOrientation = TitleOrientation.TOP;
        text.setTitleOrientation(titleOrientation);
        text.setWrap(TextAreaWrap.SOFT);
        text.setColSpan(2);
        text.setWidth ("*");   
        text.setHeight("*");
        
        treatmentForm.setFields(reported, email, lon, lat, count, text);


        final DynamicForm feedBack = new DynamicForm(); 
                               // Обратная связь
        feedBack.setGroupTitle("<font style=\"font-size:12px;font-weight:bold;color:#0000dd\">\u041E\u0431\u0440\u0430\u0442\u043D\u0430\u044F\u0020\u0441\u0432\u044F\u0437\u044C</font>");   
        feedBack.setIsGroup(true);   
        feedBack.setWidth100();
        feedBack.setHeight (200);   
//        feedBack.setHeight ("*");   
        feedBack.setNumCols(2);
        feedBack.setPadding(5);
        feedBack.setMargin (10);
//      feedBack.setTop   (20);
        feedBack.setTitleWidth(90);
        
                                                                                      // Рассмотрена
        TextItem  considered   = new TextItem ("tiConsidered"    ); considered.setTitle ("\u0420\u0430\u0441\u0441\u043C\u043E\u0442\u0440\u0435\u043D\u0430");
                                                                    considered.setWidth("*");
                                                                                      // Организация
        TextItem  organization = new TextItem ("tiOrganization"  ); organization.setTitle ("\u041E\u0440\u0433\u0430\u043D\u0438\u0437\u0430\u0446\u0438\u044F");
                                                                    organization.setWidth("*");   
        TextAreaItem resolution = new TextAreaItem("tiResolution"); resolution.setTitle("\u0420\u0435\u0437\u043E\u043B\u044E\u0446\u0438\u044F");  // Резолюция
        resolution.setTitleOrientation(titleOrientation);
        resolution.setWrap(TextAreaWrap.SOFT);
        resolution.setColSpan(2);
        resolution.setWidth ("*");   
        resolution.setHeight("*");

        feedBack.setFields(considered, organization, resolution);

        Canvas dividerCanvas = new Canvas();   
        dividerCanvas.setHeight(5);   
        dividerCanvas.setContents ("<hr>");
        
        Label linkJoin = new Label();   
        linkJoin.setAlign(Alignment.RIGHT);
//        linkJoin.setStyleName(Authorization.CSS_LABEL_LINK);
        linkJoin.setHeight  (20);
        linkJoin.setWidth100(  );
        linkJoin.setPadding (10);
        linkJoin.setContents("<font style=\"font-size:11px;font-style:italic;text-decoration:underline;padding-right:15px;color:#0000ff;cursor:pointer;\">" +
        		                   "\u041F\u0440\u0438\u0441\u043E\u0435\u0434\u0438\u043D\u044F\u044E\u0441\u044C</font>"); // Присоединяюсь
        linkJoin.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
//				com.google.gwt.user.client.Window.alert("0. linkJoin ...");
				if (iCallback != null)
					iCallback.joinTreatment(treatment, treatment.getId(), "");
                hide();
			}
		});
        
        addItem(treatmentCanvas);
        addItem(treatmentForm  );
        addItem(linkJoin       );
        addItem(dividerCanvas  );
        addItem(feedBack       );
        addCloseClickHandler(new CloseClickHandler()
        {
            public void onCloseClick(CloseClientEvent event)
            {
                hide();
            }
        });
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void showData (Treatment treatment)
    {
    	this.treatment = treatment;
    	treatmentCanvas.setContents ("<font style=\"font-size:14px;font-weight:bold;color:#cc00cc\">" + treatment.getCategory() + "</font>");
    	
//    	treatmentForm.setDisabled(true);
    	treatmentForm.setValue("tiReported", treatment.getReported());
    	treatmentForm.setValue("tiEmail"   , treatment.getEmail   ());
    	treatmentForm.setValue("tiCount"   , treatment.getCount   ());
    	String content = treatment.getContent ();
    	if (content.indexOf("<br>") > 0)
    		content = content.replace("<br>", "\n");
    	treatmentForm.setValue("tiText"    , content);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
