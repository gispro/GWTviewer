package ru.mos.gispro.client.window;

import java.util.LinkedHashMap;

import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.client.IBaseMap;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.TextAreaWrap;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;

public class TreatmentForm extends Window
{
	private                    DynamicForm           form              = null;
	
	private                    String                lon               = null;
	private                    String                lat               = null;
                                                                         // Выберите категорию
	private   final   static   String                LIST_STUB_CATEGOR = "\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435\u0020\u043A\u0430\u0442\u0435\u0433\u043E\u0440\u0438\u044E";          
	private   final   static   String                LIST_name         = "name"         ;
	private                    IBaseMap              iCallback         = null;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public TreatmentForm(IBaseMap iCallback)
    {
    	this.iCallback = iCallback;
    	setTitle("\u0424\u043E\u0440\u043C\u0430\u0020\u043E\u0431\u0440\u0430\u0449\u0435\u043D\u0438\u044F"); // Форма обращения
    	setHeight(320);
    	setWidth(500);
    	setShowMaximizeButton(true);
    	centerInPage();
    	setCanDragResize(true);
    	setShowMaximizeButton(false);
    	
    	form = new DynamicForm();
    	form.setWidth100();
    	form.setHeight   (250);
    	form.setPadding  ( 10);
		form.setMargin  (  0);
//		form.setTop     ( 10);

    	form.setNumCols(2);
    	form.setTitleWidth(90);
		
    	ComboBoxItem cbCategories = new ComboBoxItem("cbCategories");   
    	cbCategories.setTitle("\u041A\u0430\u0442\u0435\u0433\u043E\u0440\u0438\u044F"); // Категория   
    	cbCategories.setType ("comboBox");
    	cbCategories.setWidth("*");

		TextItem  email = new TextItem ("tiEmail");    email.setTitle ("Email");
        TextItem  lon   = new TextItem ("tiLon"  );    lon  .setTitle ("\u0414\u043E\u043B\u0433\u043E\u0442\u0430");  // Долгота
        TextItem  lat   = new TextItem ("tiLat"  );    lat  .setTitle ("\u0428\u0438\u0440\u043E\u0442\u0430");

        email.setDisabled(true);
        lon  .setDisabled(true);
        lat  .setDisabled(true);
        email.setWidth   ("*" );
        lon  .setWidth   ("*" );   
        lat  .setWidth   ("*" );   
        
        TitleOrientation titleOrientation = TitleOrientation.TOP;

        TextAreaItem text  = new TextAreaItem("tiText" );
        text.setTitle("\u0422\u0435\u043A\u0441\u0442");  // Текст
        text.setTitleOrientation(titleOrientation);
        text.setWrap(TextAreaWrap.SOFT);
        text.setColSpan(2);
        text.setWidth ("*");   
        text.setHeight("*");
        
        HLayout layout = new HLayout(20);
        layout.setLayoutData(null);
//        layout.layoutChildren(null);
        layout.setMargin(10);
        layout.setWidth100();
//        layout.setBorder("1px solid #ff0000");

        Button btnOk = new Button("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C"); // Сохранить
        btnOk.setLeft(100); //  .setRight(10);
//        btnOk.setAlign(Layout.Alignment. .Alignment(); // .RIGHT);
//        btnOk.setRight(100);

        Button btnClose = new Button("\u0417\u0430\u043A\u0440\u044B\u0442\u044C"); // Закрыть
        btnClose.setRight(5);

        layout.addMember(btnOk   );
        layout.addMember(btnClose);

        btnOk.addClickHandler(new ClickHandler()
        {   
            public void onClick(ClickEvent event)
            {
            	saveTreatment();
            }   
        });

        btnClose.addClickHandler(new ClickHandler()
        {   
            public void onClick(ClickEvent event)
            {
            	hide();
            }   
        });

        form.setFields(cbCategories, lon, lat, email, text);
        addItem(form);
        addItem(layout);
        
		GWTViewer.MapServiceInfoServlet.loadTreatmentCategories(new AsyncCallback<String>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(String content)
			{
//				com.google.gwt.user.client.Window.alert("loadTreatmentCategories : content = " + content);
				loadReferences (content);
			}
		});
    	
    }
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void loadReferences (String content)
	{
		JSONValue  jsonValue = JSONParser.parseLenient(content);
		JSONObject json      = jsonValue.isObject(); 

		JSONArray list = json.get("categories").isArray();

		if (list.size() > 0)
		{
			LinkedHashMap<String, String> valueMap  = new LinkedHashMap<String, String>();
			valueMap.put(LIST_STUB_CATEGOR, LIST_STUB_CATEGOR); // "0", LIST_STUB_CATEGOR);
			
			for (int i = 0; i < list.size(); i++)
			{
				JSONObject rec = list.get(i).isObject();
//                valueMap.put(rec.get(LIST_id).toString(), rec.get(LIST_name).isString().stringValue());
                valueMap.put(rec.get(LIST_name).isString().stringValue(), rec.get(LIST_name).isString().stringValue());
			}
			if (form != null)
			{
				ComboBoxItem cbCategories = (ComboBoxItem) form.getItem("cbCategories");
				if (cbCategories != null)
					cbCategories.setValueMap(valueMap);
				cbCategories.setDefaultValue(LIST_STUB_CATEGOR);
			}
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void drawLocation(String point)
	{
    	int idx = point.indexOf(",");
    	lon = point.substring(0, idx);
    	lat = point.substring(idx + 1);

    	form.setValue("tiLon", lon);
    	form.setValue("tiLat", lat);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void drawEmail(String email)
	{
    	form.setValue("tiEmail", email);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void saveTreatment()
	{
		String message = "";
		String category = (String) form.getValue ("cbCategories");  
		String text     = (String) form.getValue ("tiText"      );
		
//		com.google.gwt.user.client.Window.alert("saveTreatment : " + category + ", " + text);
		if (category.equalsIgnoreCase(LIST_STUB_CATEGOR))
			message = LIST_STUB_CATEGOR;
		if ((message.length() == 0) && ((text == null) || (text.trim().length() == 0)))
			message = "\u0412\u0432\u0435\u0434\u0438\u0442\u0435\u0020\u0442\u0435\u043A\u0441\u0442\u0020\u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F"; // Введите текст сообщения";
		if (message.length() > 0)
			com.google.gwt.user.client.Window.alert(message);
		else
		{
			if (text.indexOf("\n") > 0)
				text = text.replaceAll("\n", "<br>");
			if (text.indexOf("\"") > 0)
				text = text.replaceAll("\"", "'");
			iCallback.saveTreatment(form.getValue("tiEmail").toString(), form.getValue("tiLon").toString(),
                                    form.getValue("tiLat"  ).toString(), category, text);
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
