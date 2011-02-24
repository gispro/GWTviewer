package ru.mos.gispro.tveravtodor.client.window;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import ru.mos.gispro.tveravtodor.client.MapServiceInfo;
import ru.mos.gispro.tveravtodor.client.MapServiceInfoAsync;
import ru.mos.gispro.tveravtodor.client.TverAvtoDor;

public class Authorization extends WindowBase
{
	private   final   static    int                  WIDTH                   = 280;
	private   final   static    int                  HEIGHT                  = 180;

	private                     DynamicForm          accountForm             = null;
	private                     Label                labelException          = null;

	private   final   static    String               CONTROL_LOGIN           = "tiLogin";
	private   final   static    String               CONTROL_PASSWORD        = "piPassword";
	
	public    final   static    String               CSS_LABEL_LINK          = "LabelLink";
	
	public    final   static    String               CSS_LABEL_ERROR         = "LabelError";

	public    final   static    String               CMD_REGISTRATION        = "Registration";
                                                                               // Авторизация в системе
    private   final   static    String               WINDOW_TITLE            = "\u0410\u0432\u0442\u043E\u0440\u0438\u0437\u0430\u0446\u0438\u044F\u0020\u0432\u0020\u0441\u0438\u0441\u0442\u0435\u043C\u0435";
                                                                               // Регистрация
	public    final   static    String               REGISTRATION            = "\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F";
	                                                                           // Ошибка! Все поля должны быть заполнены
	public    final   static    String               EXCEPTION_EMPTY         = "\u041E\u0448\u0438\u0431\u043A\u0430\u0021\u0020\u0412\u0435\u0441\u0020\u043F\u043E\u043B\u044F\u0020\u0434\u043E\u043B\u0436\u043D\u044B\u0020\u0431\u044B\u0442\u044C\u0020\u0437\u0430\u043F\u043E\u043B\u043D\u0435\u043D\u044B";
                                                                              // Логин
    public    final   static    String               CAPTION_LOGIN           = "\u041B\u043E\u0433\u0438\u043D";
                                                                               // Пароль 
    public    final   static    String               CAPTION_PASSWORD        = "\u041F\u0430\u0440\u043E\u043B\u044C";
                                                                               // Закрыть
    private   final   static   String                CAPTION_CLOSE           = "\u0417\u0430\u043A\u0440\u044B\u0442\u044C";
    private   final   static   String                ERROR_USER_NOT_FOUND    = "\u041F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u0435\u043B\u044C\u0020\u043D\u0435\u0020\u043D\u0430\u0439\u0434\u0435\u043D";

//    private final MapServiceInfoAsync mapServiceInfo = GWT.create(MapServiceInfo.class);
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public Authorization (final AsyncCallback<String> callback)
	{
		super(WINDOW_TITLE, WIDTH, HEIGHT, callback);
		
		this.setShowMinimizeButton(false);
		
		VLayout layout = new VLayout();
		layout.layoutChildren(null);
		
		accountForm = new DynamicForm();   
		accountForm.setWidth100();   
		accountForm.setPadding(5);
//        backGround.setBorder("1px solid #ff0");
        TextItem     login    = new TextItem    (CONTROL_LOGIN   );    login   .setTitle (CAPTION_LOGIN);
        PasswordItem password = new PasswordItem(CONTROL_PASSWORD);    password.setTitle (CAPTION_PASSWORD);
        accountForm.setFields(login, password);

        Label linkRegistration = null;
		if (TverAvtoDor.config.withRegistration())
		{
			linkRegistration = new Label();   
			linkRegistration.setAlign(Alignment.RIGHT);
			linkRegistration.setStyleName(CSS_LABEL_LINK);
 			linkRegistration.setHeight  ( 20);
			linkRegistration.setWidth   (265);
			linkRegistration.setContents(REGISTRATION);   

			linkRegistration.addClickHandler(new ClickHandler()
			{
				public void onClick(ClickEvent event)
				{
					callback.onSuccess(CMD_REGISTRATION);
					closeForm();
				}
			});
		}
        labelException = new Label();   
        labelException.setAlign(Alignment.CENTER);
        labelException.setStyleName(CSS_LABEL_ERROR);
        labelException.setHeight(35);   
        labelException.setWidth100();   
        labelException.setMargin(5);
 //       labelException.setBorder("1px solid #0aa");
        labelException.setContents("");   

        HLayout controlPanel = new HLayout();
        controlPanel.setHeight("30px");
        controlPanel.setLayoutLeftMargin(55);

        Button btnOk = null;
       	btnOk = new Button("Ok");
        btnOk.addClickHandler(new ClickHandler()
        {   
            public void onClick(ClickEvent event)
            {
            	onOkClick();
            }   
        });
        Button btnClose = new Button(CAPTION_CLOSE);
        btnClose.setTop (10);
        btnClose.addClickHandler(new ClickHandler()
        {   
            public void onClick(ClickEvent event)
            {
            	closeForm();
            }   
        });
        controlPanel.addMember(btnOk   );
        controlPanel.addMember(btnClose);
        
        layout.addMember(accountForm);
        if (linkRegistration != null)
        	layout.addMember(linkRegistration);
        layout.addMember(labelException);
        layout.addMember(controlPanel  );
        addItem(layout);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void onOkClick()
	{
   		labelException.setContents ("");
   		if (!isEmpty())
   			userConnect();
   		else
   			labelException.setContents (EXCEPTION_EMPTY);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private boolean isEmpty()
	{
		String lg = (String) accountForm.getValue(CONTROL_LOGIN  );
		String pw = (String) accountForm.getValue(CONTROL_PASSWORD); 
		return (((lg == null) || ((lg != null) && (lg.trim().length() == 0))) ||
		        ((pw == null) || ((pw != null) && (pw.trim().length() == 0))));
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void userConnect()
	{
//		Window.alert("Authorization.userConnect : login = " + (String) accountForm.getValue(CONTROL_LOGIN   ) + ", " +
//                                                              (String) accountForm.getValue(CONTROL_PASSWORD));
//		System.out.println ("Authorization.userConnect - " + (String) accountForm.getValue(CONTROL_LOGIN   ) + ", " +
//                                                             (String) accountForm.getValue(CONTROL_PASSWORD));
        TverAvtoDor.MapServiceInfoServlet.userConnect((String) accountForm.getValue(CONTROL_LOGIN   ),
				                                      (String) accountForm.getValue(CONTROL_PASSWORD),
				                                      new AsyncCallback<String>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(String content)
			{
//				System.out.println ("Authorization.userConnect - AsyncCallback.onSuccess : content = " + content);
//				Window.alert("Authorization.userConnect - AsyncCallback.onSuccess : content = " + content + " => EastLine");
				if (content == null)
					labelException.setContents (ERROR_USER_NOT_FOUND);
				else
//				{
					callback.onSuccess(content);
//					closeForm();
//				}
			}
		});
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
