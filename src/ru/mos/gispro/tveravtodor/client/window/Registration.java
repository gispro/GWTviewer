package ru.mos.gispro.client.window;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

// import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.client.References;

public class Registration extends WindowBase
{
	private   final   static   int                   WIDTH                 = 290;
	private   final   static   int                   HEIGHT                = 250; 

	private   final   static   String                CONTROL_NAME          = "tiName"          ;
	private   final   static   String                CONTROL_SNAME         = "siFName"         ;
	private   final   static   String                CONTROL_PNAME         = "piFName"         ;
	private   final   static   String                CONTROL_LOGIN         = "tiLogin"         ;
	private   final   static   String                CONTROL_PASSWORD      = "piPassword"      ;
	private   final   static   String                CONTROL_ORGANIZATIONS = "cbiOrganizations";
	private   final   static   String                CONTROL_DEPARTMENTS   = "cbiDepartments"  ;
	
	private                    DynamicForm           accountForm           = null;
	private                    ComboBoxItem          cbItemOrganizations   = null;
	private                    ComboBoxItem          cbItemDepartments     = null;
	
	private                    Label                 labelException        = null;
	private   final   static   String                POSITION_ID           = "0";

	private   final            int                   COMPONENT_WIDTH       = 170;
	private   final            int                   CONTROL_PANEL_LEFT    =  60;
	private   final            int                   LINK_AUTHORIZ_WIDTH   = 275;     

	private   final   static   String                LIST_organizations    = "organizations";
	private   final   static   String                LIST_departments      = "departments"  ;
	private   final   static   String                LIST_id               = "id"           ;
	private   final   static   String                LIST_name             = "name"         ;
	
	public    final   static   String                CMD_AUTHORIZATION     = "Authorization";
	public    final   static   String                ACTION_RESULT_SUCCESS = "success"      ;
	
	public    final   static   String                COMBO_BOX_TYPE        = "comboBox";
                                                                             // Закрыть
    private   final   static   String                CAPTION_CLOSE         = "\u0417\u0430\u043A\u0440\u044B\u0442\u044C";
                                                                             // Авторизация
	private   final   static   String                AUTHORIZATION         = "\u0410\u0432\u0442\u043E\u0440\u0438\u0437\u0430\u0446\u0438\u044F";
                                                                             // Организация
	private   final   static   String                CAPTION_ORGANIZATION  = "\u041E\u0440\u0433\u0430\u043D\u0438\u0437\u0430\u0446\u0438\u044F";
                                                                             // Подразделение
	private   final   static   String                CAPTION_DEPARTMENT    = "\u041F\u043E\u0434\u0440\u0430\u0437\u0434\u0435\u043B\u0435\u043D\u0438\u0435";
                                                                             // Имя
	private   final   static   String                CAPTION_NAME          = "\u0418\u043C\u044F";
                                                                             // Фамилия
	private   final   static   String                CAPTION_SNAME         = "\u0424\u0430\u043C\u0438\u043B\u0438\u044F";
                                                                             // Отчество
	private   final   static   String                CAPTION_PNAME         = "\u041E\u0442\u0447\u0435\u0441\u0442\u0432\u043E";
                                                                             // Логин
	private   final   static   String                CAPTION_LOGIN         = "\u041B\u043E\u0433\u0438\u043D";
                                                                             // Пароль
	private   final   static   String                CAPTION_PASSWORD      = "\u041F\u0430\u0440\u043E\u043B\u044C";
                                                                             // Регистрация в системе
	private   final   static   String                WINDOW_TITLE          = "\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F\u0020\u0432\u0020\u0441\u0438\u0441\u0442\u0435\u043C\u0435";
	                                                                         // Выберите организацию
	private   final   static   String                LIST_STUB_ORGANIZ     = "\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435\u0020\u043E\u0440\u0433\u0430\u043D\u0438\u0437\u0430\u0446\u0438\u044E";          
	                                                                         // Выберите подразделение
	private   final   static   String                LIST_STUB_DEPARTMENT  = "\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435\u0020\u043F\u043E\u0434\u0440\u0430\u0437\u0434\u0435\u043B\u0435\u043D\u0438\u0435";                
                                                                             // Ошибка! Все поля обязательны для заполнения
	private   final   static   String                EXCEPT_EMPTY_FIELD    = "\u041E\u0448\u0438\u0431\u043A\u0430\u0021\u0020\u0412\u0441\u0435\u0020\u043F\u043E\u043B\u044F\u0020\u043E\u0431\u044F\u0437\u0430\u0442\u0435\u043B\u044C\u043D\u044B\u0020\u0434\u043B\u044F\u0020\u0437\u0430\u043F\u043E\u043B\u043D\u0435\u043D\u0438\u044F";                
                                                                             // Ошибка! Не выбрана организация
	private   final   static   String                EXCEPT_ORGANIZATION   = "\u041E\u0448\u0438\u0431\u043A\u0430\u0021\u0020\u041D\u0435\u0020\u0432\u044B\u0431\u0440\u0430\u043D\u0430\u0020\u043E\u0440\u0433\u0430\u043D\u0438\u0437\u0430\u0446\u0438\u044F";                
                                                                             // Ошибка! Не выбрано подразделение
	private   final   static   String                EXCEPT_DEPARTMENT     = "\u041E\u0448\u0438\u0431\u043A\u0430\u0021\u0020\u041D\u0435\u0020\u0432\u044B\u0431\u0440\u0430\u043D\u043E\u0020\u043F\u043E\u0434\u0440\u0430\u0437\u0434\u0435\u043B\u0435\u043D\u0438\u0435";                
                                                                             // Ошибка! Значение поля "Логин" не соответсвует email
	private   final   static   String                EXCEPT_LOGIN          = "\u0424\u043E\u0440\u043C\u0430\u0442\u0020\u0020\u0437\u043D\u0430\u0447\u0435\u043D\u0438\u044F\u0020\u0027\u041B\u043E\u0433\u0438\u043D\u0027\u0020\u043D\u0435\u0020\u0441\u043E\u043E\u0442\u0432\u0435\u0442\u0441\u0432\u0443\u0435\u0442\u0020\u0065\u006D\u0061\u0069\u006C";                
	
    private   List<References>                       departmentsList       = null;
    private   List<References>                       organizationsList     = null;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public Registration(final AsyncCallback<String> callback)
	{
		super(WINDOW_TITLE, WIDTH, HEIGHT, callback);
		this.setShowMinimizeButton(false);
//	}
//	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	protected void createUserInterface()
//	{
		int extHeight = 0;
		if (GWTViewer.config.withOrganization())
			extHeight += 28;
		if (GWTViewer.config.withDepartment())
			extHeight += 28;
		if (extHeight > 0)
			this.setHeight(HEIGHT + extHeight);

		VLayout layout = new VLayout();
		layout.layoutChildren(null);
		
		accountForm = new DynamicForm();   
		accountForm.setWidth100       (  );   
		accountForm.setPadding        ( 5);
//		accountForm.setBackgroundColor("#00ff00");
		accountForm.setTitleWidth     (90);
//		accountForm.setBorder("1px solid #ff0000");
		
		if (GWTViewer.config.withOrganization())
		{
			createOrganizationItem();
			cbItemOrganizations.setWidth(COMPONENT_WIDTH);
		}
		
		if (GWTViewer.config.withDepartment())
		{
			createDepartmentItem ();
			cbItemDepartments.setWidth(COMPONENT_WIDTH);
		}		
		
        TextItem     sname    = new TextItem    (CONTROL_SNAME   );     sname   .setTitle (CAPTION_SNAME   );
		TextItem     name     = new TextItem    (CONTROL_NAME    );     name    .setTitle (CAPTION_NAME    );   
        TextItem     pname    = new TextItem    (CONTROL_PNAME   );     pname   .setTitle (CAPTION_PNAME   );

        TextItem     login    = new TextItem    (CONTROL_LOGIN   );     login   .setTitle (CAPTION_LOGIN   );
        PasswordItem password = new PasswordItem(CONTROL_PASSWORD);     password.setTitle (CAPTION_PASSWORD);
		
        sname   .setWidth(COMPONENT_WIDTH);
        name    .setWidth(COMPONENT_WIDTH);
        pname   .setWidth(COMPONENT_WIDTH);
        login   .setWidth(COMPONENT_WIDTH);
        password.setWidth(COMPONENT_WIDTH);
        
		if (GWTViewer.config.withOrganization() || GWTViewer.config.withDepartment())
		{
			if (GWTViewer.config.withOrganization() && GWTViewer.config.withDepartment())
				accountForm.setFields(cbItemOrganizations, cbItemDepartments, sname, name, pname, login, password);
			else
			{
				if (GWTViewer.config.withOrganization())
					accountForm.setFields(cbItemOrganizations, sname, name, pname, login, password);
			
				if (GWTViewer.config.withDepartment())
					accountForm.setFields(cbItemDepartments, sname, name, pname, login, password);
			}
		} else
			accountForm.setFields(sname, name, pname, login, password);
        
        Label linkAuthorization = new Label();   
        linkAuthorization.setAlign(Alignment.RIGHT);
        linkAuthorization.setStyleName(Authorization.CSS_LABEL_LINK);
        linkAuthorization.setHeight ( 20);   
        linkAuthorization.setWidth  (LINK_AUTHORIZ_WIDTH);
        linkAuthorization.setContents(AUTHORIZATION);   
 //       linkAuthorization.setBorder("1px solid #aa0");

        linkAuthorization.addClickHandler(new ClickHandler()
        {
			public void onClick(ClickEvent event)
			{
				callback.onSuccess(CMD_AUTHORIZATION);
				closeForm();
			}
        });
        labelException = new Label();   
        labelException.setAlign(Alignment.CENTER);
        labelException.setStyleName(Authorization.CSS_LABEL_ERROR);
        labelException.setHeight(30);   
        labelException.setWidth100();   
        labelException.setMargin(5);
 //       labelException.setBorder("1px solid #0aa");
        labelException.setContents("");   
        
        HLayout controlPanel = new HLayout();
        controlPanel.setHeight("30px");
        controlPanel.setLayoutLeftMargin(CONTROL_PANEL_LEFT);

        Button btnOk = new Button(Authorization.REGISTRATION);
        btnOk.addClickHandler(new ClickHandler()
        {   
            public void onClick(ClickEvent event)
            {
            	onOkClick();
            }   
        });
        Button btnClose = new Button(CAPTION_CLOSE);
        btnClose.addClickHandler(new ClickHandler()
        {   
            public void onClick(ClickEvent event)
            {
            	closeForm();
            }   
        });
        controlPanel.addMember(btnOk   );
        controlPanel.addMember(btnClose);
        
		layout.addMember(accountForm      );
		layout.addMember(linkAuthorization);
		layout.addMember(labelException   );
		layout.addMember(controlPanel     );
		addItem(layout);

//		System.out.println ("Registration ...");
		if (GWTViewer.config.withOrganization())
		{
			GWTViewer.MapServiceInfoServlet.loadOrganizations(new AsyncCallback<String>()
			{
				public void onFailure(Throwable caught) {}
				public void onSuccess(String content)
				{
					loadReferences (LIST_organizations, CONTROL_ORGANIZATIONS, LIST_STUB_ORGANIZ, content);
				}
			});
		}
		if (GWTViewer.config.withDepartment())
		{
			GWTViewer.MapServiceInfoServlet.loadDepartments(new AsyncCallback<String>()
			{
				public void onFailure(Throwable caught) {}
				public void onSuccess(String content)
				{
					loadReferences (LIST_departments, CONTROL_DEPARTMENTS, LIST_STUB_DEPARTMENT, content);
				}
			});
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void createOrganizationItem ()
	{
		cbItemOrganizations = new ComboBoxItem(CONTROL_ORGANIZATIONS);   
		cbItemOrganizations.setTitle(CAPTION_ORGANIZATION);   
		cbItemOrganizations.setType(COMBO_BOX_TYPE);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void createDepartmentItem ()
	{
		cbItemDepartments = new ComboBoxItem(CONTROL_DEPARTMENTS);   
		cbItemDepartments.setTitle(CAPTION_DEPARTMENT);   
		cbItemDepartments.setType(COMBO_BOX_TYPE);
/*
		LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < EastLine_Base.list.departments().length(); i++)
        {
			JSONDepartment department = EastLine_Base.list.department(i).cast();
			if (department.isActive())
		        valueMap.put(department.id(), department.name());   
		}
		cbItemDepartments.setValueMap(valueMap);
*/		
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void loadReferences (String array, String control, String firstRecord, String content)
	{
		JSONValue  jsonValue = JSONParser.parse(content); //  .parseLenient(content);
		JSONObject json      = jsonValue.isObject(); 

		JSONArray list = json.get(array).isArray();

		if (list.size() > 0)
		{
			List<References>              valueList = new ArrayList<References>();
			LinkedHashMap<String, String> valueMap  = new LinkedHashMap<String, String>();
//			valueMap.put("0", "<b>" + firstRecord + "<b>");
			References ref = new References (0, firstRecord);
			valueMap .put("0", firstRecord);
			valueList.add(ref);
			
			for (int i = 0; i < list.size(); i++)
			{
				JSONObject rec = list.get(i).isObject();
				valueMap.put(rec.get(LIST_id).toString(), rec.get(LIST_name).isString().stringValue());
				ref = new References (Integer.valueOf(rec.get(LIST_id).toString()), 
	                                  rec.get(LIST_name).isString().stringValue());
                valueList.add(ref);
			}
			if (accountForm != null)
			{
				ComboBoxItem cbItem = (ComboBoxItem) accountForm.getItem(control);
				if (cbItem != null)
					cbItem.setValueMap(valueMap);
				cbItem.setDefaultValue(firstRecord);
			}
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private boolean isEmpty()
	{
		String sn = (String) accountForm.getValue(CONTROL_SNAME   );
		String nm = (String) accountForm.getValue(CONTROL_NAME    ); 
		String pn = (String) accountForm.getValue(CONTROL_PNAME   );
		String lg = (String) accountForm.getValue(CONTROL_LOGIN   );
		String pw = (String) accountForm.getValue(CONTROL_PASSWORD);
		
		return (((sn == null) || ((sn != null) && (sn.trim().length() == 0))) ||
		        ((nm == null) || ((nm != null) && (nm.trim().length() == 0))) ||
		        ((pn == null) || ((pn != null) && (pn.trim().length() == 0))) ||
		        ((lg == null) || ((lg != null) && (lg.trim().length() == 0))) ||
		        ((pw == null) || ((pw != null) && (pw.trim().length() == 0))));
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void onOkClick()
	{
		labelException.setContents("");
		if (isEmpty())
		{
			labelException.setContents(EXCEPT_EMPTY_FIELD);
			return;
		}

		String login        = (String) accountForm.getValue (CONTROL_LOGIN   ); 
		String password     = (String) accountForm.getValue (CONTROL_PASSWORD);
		String name         = (String) accountForm.getValue (CONTROL_NAME    );
		String sname        = (String) accountForm.getValue (CONTROL_SNAME   );
		String pname        = (String) accountForm.getValue (CONTROL_PNAME   );
		String organization = "0";
		String department   = "0";

		if (GWTViewer.config.withOrganization())
		{
			organization = (String) accountForm.getValue(CONTROL_ORGANIZATIONS);
			if (organizationsList != null)
			{
				for (int i = 0; i < organizationsList.size(); i++)
				{
					References ref = organizationsList.get(i);
					if (ref.getName().equalsIgnoreCase(organization))
					{
						organization = String.valueOf(ref.getId());
						break;
					}
				}
			}
		}
		if (GWTViewer.config.withDepartment())
		{
			department = (String) accountForm.getValue(CONTROL_DEPARTMENTS);
			if (departmentsList != null)
			{
				for (int i = 0; i < departmentsList.size(); i++)
				{
					References ref = departmentsList.get(i);
					if (ref.getName().equalsIgnoreCase(department))
					{
						department = String.valueOf(ref.getId());
						break;
					}
				}
			}
		}
			
		if (GWTViewer.config.withOrganization() && (organization.equals("0")))
		{
			labelException.setContents(EXCEPT_ORGANIZATION);
			labelException.redraw();
			return;
		}
		if (GWTViewer.config.withDepartment() && (department.equals("0")))
		{
			labelException.setContents(EXCEPT_DEPARTMENT);
			return;
		}
/*
		if ((login.indexOf('@') == -1) || (login.indexOf('.') == -1) || (login.indexOf('@') > login.indexOf('.')))
		{
			labelException.setContents(EXCEPT_LOGIN);
			return;
		}
*/
  		GWTViewer.MapServiceInfoServlet.registration(sname, name, pname, login, password, organization, department, POSITION_ID,
					                                   new AsyncCallback<String>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(String content)
			{
//                com.google.gwt.user.client.Window.alert("Registration - AsyncCallback.content = " + content);
				if ((content != null) && (content.equalsIgnoreCase(ACTION_RESULT_SUCCESS)))
				{
					callback.onSuccess(ACTION_RESULT_SUCCESS);
				} else
					labelException.setContents(content);
			}
		});
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
