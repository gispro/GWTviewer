package ru.mos.gispro.client.window;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

//import com.google.gwt.dom.client.Document;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;
import ru.mos.gispro.client.ContentRequestHandler;
import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.client.JSONRequestHandler;

// import com.google.gwt.user.client.HTTPRequest;
// import com.google.gwt.user.client.ResponseTextHandler;
/**
 * Окно <Подрядчиков> для MosAvtoDor
 *
 * User: ekoklin
 * Date: 25.02.11
 * Time: 17:40
 */
public class Contractors extends WindowBase
{
    public    final   static    int                  WIDTH                   = 720;
    public    final   static    int                  HEIGHT                  = 400;

    private                     DynamicForm          headerForm              = null;
    private                     ListGrid             list                    = null;
    private                     RecordList           data                    = null;

    private   final   static    String               CONTROL_ORGANIZATION    = "tiOrganization";
    private   final   static    String               CONTROL_CITY            = "tiCity";
    private   final   static    String               CONTROL_STREET          = "tiStreet";
    private   final   static    String               CONTROL_PHONE           = "tiPhone";
    private   final   static    String               CONTROL_FAX             = "tiFax";

    private   final   static    String               STRING_field            = "field";
    private   final   static    String               STRING_value            = "value";
                                                                               // Подрядчики
    private   final   static    String               WINDOW_TITLE            = "\u041F\u043E\u0434\u0440\u044F\u0434\u0447\u0438\u043A\u0438";
                                                                               // Организация
    private   final   static    String               CAPTION_ORGANIZATION    = "\u041E\u0440\u0433\u0430\u043D\u0438\u0437\u0430\u0446\u0438\u044F";
                                                                               // Город
    private   final   static    String               CAPTION_CITY            = "\u0413\u043E\u0440\u043E\u0434";
                                                                               // Улица
    private   final   static    String               CAPTION_STREET          = "\u0423\u043B\u0438\u0446\u0430";
                                                                               // Телефон
    private   final   static    String               CAPTION_PHONE           = "\u0422\u0435\u043B\u0435\u0444\u043E\u043D";
                                                                               // Факс
    private   final   static    String               CAPTION_FAX             = "\u0424\u0430\u043A\u0441";

                                                                               // Полное название
    private   final   static    String               FIELD_ORGANIZATION      = "\u041F\u043E\u043B\u043D\u043E\u0435\u0020\u043D\u0430\u0437\u0432\u0430\u043D\u0438\u0435";
                                                                               // ГородРабАдр
    private   final   static    String               FIELD_CITY              = "\u0413\u043E\u0440\u043E\u0434\u0420\u0430\u0431\u0410\u0434\u0440";
                                                                               // УлицаРабАдр
    private   final   static    String               FIELD_STREET            = "\u0423\u043B\u0438\u0446\u0430\u0420\u0430\u0431\u0410\u0434\u0440";

                                                                               // Должность
    private   final   static    String               CAPTION_POSITION        = "\u0414\u043E\u043B\u0436\u043D\u043E\u0441\u0442\u044C";
                                                                               // Фамилия Имя Отчество
    private   final   static    String               CAPTION_NAME            = "\u0424\u0430\u043C\u0438\u043B\u0438\u044F\u0020\u0418\u043C\u044F\u0020\u041E\u0442\u0447\u0435\u0441\u0442\u0432\u043E";
                                                                               // Сотовый телефон
    private   final   static    String               CAPTION_MOBILE_PHONE    = "\u0421\u043E\u0442\u043E\u0432\u044B\u0439\u0020\u0442\u0435\u043B\u0435\u0444\u043E\u043D";
                                                                               // Домашний телефон
    private   final   static    String               CAPTION_HOME_PHONE      = "\u0414\u043E\u043C\u0430\u0448\u043D\u0438\u0439\u0020\u0442\u0435\u043B\u0435\u0444\u043E\u043D";

//  private   final   static    String               SERVICE_URL_START       = "http://maps.gispro.ru/arcgis/services/MAD/mad_structure/GeoDataServer/WFSServer?request=GetFeature&typename=s_people&filter=%3Cogc:Filter%20xmlns:ogc=%22" +
//                                                                             "http://www.opengis.net/ogc%22%20xmlns:gml=%22456789" +
//                                                                             "http://www.opengis.net/gml%22%20xmlns:xsi=%22" +
//                                                                             "http://www.w3.org/2001/XMLSchema-instance%22%20xsi:schemaLocation=%22" +
//                                                                             "http://www.opengis.net/ogc/filter/1.0.0/filter.xsd%20" +
//                                                                             "http://www.opengis.net/gml/2.1/geometry.xsd%22" +
//                                                                             "%3E%3Cogc:PropertyIsEqualTo" +
//                                                                             "%3E%3Cogc:PropertyName%3Eid_organiz%3C/ogc:PropertyName%3E%3Cogc:Literal%3E";

//    private   final   static    String               SERVICE_URL_START       = "http://maps.gispro.ru/arcgis/services/MAD/mad_structure/GeoDataServer/WFSServer?request=GetFeature&typename=s_people&filter=" +
//                                                                               "<ogc:Filter xmlns:ogc=\"http://www.opengis.net/ogc\"%20 xmlns:gml=\"http://www.opengis.net/gml\"%20 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"%20" +
//                                                                               "xsi:schemaLocation=\"http://www.opengis.net/ogc/filter/1.0.0/filter.xsd%20 http://www.opengis.net/gml/2.1/geometry.xsd\">" +
//                                                                               "<ogc:PropertyIsEqualTo><ogc:PropertyName>id_organiz</ogc:PropertyName><ogc:Literal>";
    public   final   static    String               SERVICE_URL_START       = "http://maps.gispro.ru/arcgis/services/MAD/mad_structure/GeoDataServer/WFSServer?request=GetFeature&typename=s_people&filter=" +
                                                                               "<ogc:Filter><ogc:PropertyIsEqualTo><ogc:PropertyName>id_organiz</ogc:PropertyName><ogc:Literal>";
//    public   final   static    String               SERVICE_URL_END         = "</ogc:Literal></ogc:PropertyIsEqualTo></ogc:Filter>";

    public   final   static    String               SERVICE_URL_CONTRACTORS = "http://maps.gispro.ru/arcgis/services/MAD/mad_structure/GeoDataServer/WFSServer?request=GetFeature&typename=s_people&filter=" +
                                                                               "<ogc:Filter><ogc:PropertyIsEqualTo><ogc:PropertyName>id_organiz</ogc:PropertyName><ogc:Literal><0></ogc:Literal></ogc:PropertyIsEqualTo></ogc:Filter>";

    private   final   static    String               LIST_GRID_POSITION      = "position";
    private   final   static    String               LIST_GRID_NAME          = "name";
    private   final   static    String               LIST_GRID_MOBILE        = "mobile";
    private   final   static    String               LIST_GRID_PHONE         = "phone";
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public Contractors (int w, int h, int contractorID, RecordList data3)
	{
		super(WINDOW_TITLE, w, h, null);
        setCanDragResize (true);

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    class JSONRequest
        {
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		    public void get(String url, JSONRequestHandler handler)
            {
			    String callbackName = "JSONCallback" + handler.hashCode();
			    get(url + "&callback=" + callbackName, callbackName, handler);
		    }
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		    public void get(String url, String callbackName, JSONRequestHandler handler)
            {
                 com.google.gwt.user.client.Window.alert("Contractor.JSONRequest.get : callbackName = " + callbackName +
                                                     ", JSONRequestHandler = " + handler + "\n" + url);
    			createCallbackFunction(handler, callbackName);
	    		addScript(url);
    		}
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    	public native void addScript(String url) /*-{
                var scr = document.createElement("script");
                scr.setAttribute("language", "JavaScript");
                scr.setAttribute("type", "text/javascript");
                scr.setAttribute("src", url);
                document.getElementsByTagName("head")[0].appendChild(scr);
            }-*/;
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		    private native void createCallbackFunction(JSONRequestHandler handler, String callbackName)/*-{
                 tmpcallback = function(j)
                {
                    handler.@ru.mos.gispro.client.JSONRequestHandler::onRequestComplete(Lcom/google/gwt/core/client/JavaScriptObject;)(j);
                };
                eval( "window." + callbackName + "=tmpcallback" );
            }-*/;
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    	}
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        class ContentRequest
        {
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            public void get(String url, ContentRequestHandler handler)
            {
                String callbackName = "JSONCallback" + handler.hashCode();
                get(url + "&callback=" + callbackName, callbackName, handler);
            }
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            public void get(String url, String callbackName, ContentRequestHandler handler)
            {
                 com.google.gwt.user.client.Window.alert("Contractor.ContentRequest.get : callbackName = " + callbackName +
                                                         ", ContentRequestHandler = " + handler + "\n" + url);
                createCallbackFunction(handler, callbackName);
                addScript(url);
            }
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            public native void addScript(String url) /*-{
                var scr = document.createElement("script");
                scr.setAttribute("language", "JavaScript");
                scr.setAttribute("type", "text/javascript");
                scr.setAttribute("src", url);
                document.getElementsByTagName("head")[0].appendChild(scr);
            }-*/;
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            private native void createCallbackFunction(ContentRequestHandler handler, String callbackName)/*-{
                 tmpcallback = function(j)
                {
                    handler.@ru.mos.gispro.client.ContentRequestHandler::onRequestComplete(Lcom/google/gwt/xml/client/Document;)(j);
                };
                eval( "window." + callbackName + "=tmpcallback" );
            }-*/;
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        }
        //  handler.@ru.mos.gispro.client.ContentRequestHandler::onRequestComplete(Lcom/google/gwt/dom/client/Document;)(j);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        VLayout layout = new VLayout();
        layout.layoutChildren(null);

        headerForm = new DynamicForm();
        headerForm.setWidth(w - 20);
        headerForm.setNumCols(2);
        headerForm.setTitleWidth(100);
        headerForm.setPadding(5);
//      headerForm.setAlign(Alignment.CENTER);
//      headerForm.setBorder("1px solid blue");
//      headerForm.setCellBorder(1);

        TextItem organization = new TextItem (CONTROL_ORGANIZATION);    organization.setTitle (CAPTION_ORGANIZATION);
        TextItem city         = new TextItem (CONTROL_CITY        );    city        .setTitle (CAPTION_CITY        );
        TextItem street       = new TextItem (CONTROL_STREET      );    street      .setTitle (CAPTION_STREET      );
        TextItem phone        = new TextItem (CONTROL_PHONE       );    phone       .setTitle (CAPTION_PHONE       );
        TextItem fax          = new TextItem (CONTROL_FAX         );    fax         .setTitle (CAPTION_FAX         );

        organization.setWidth(headerForm  .getWidth() - 110);
        city        .setWidth(organization.getWidth());
        street      .setWidth(organization.getWidth());
        phone       .setWidth(organization.getWidth());
        fax         .setWidth(organization.getWidth());
        headerForm.setFields(organization, city, street, phone, fax);

        for (int i = 0; i < data3.getLength(); i++)
        {
            Record record = data3.get(i);
            String field  = record.getAttribute(STRING_field);
            if (field != null)
            {
                field = field.trim();
                if (field.equalsIgnoreCase(CAPTION_PHONE))
                    phone.setValue(record.getAttribute(STRING_value));
                else if (field.equalsIgnoreCase(FIELD_CITY))
                    city.setValue(record.getAttribute(STRING_value));
                else if (field.equalsIgnoreCase (CAPTION_FAX))
                    fax.setValue(record.getAttribute(STRING_value));
                else if (field.equalsIgnoreCase(FIELD_STREET))
                    street.setValue(record.getAttribute(STRING_value));
                else if (field.equalsIgnoreCase(FIELD_ORGANIZATION))
                    organization.setValue(record.getAttribute(STRING_value));
            }
        }
        list = new ListGrid();
        list.setWidth100();

        ListGridField position    = new ListGridField(LIST_GRID_POSITION, CAPTION_POSITION    );   position   .setWidth(200);
        ListGridField name        = new ListGridField(LIST_GRID_NAME    , CAPTION_NAME        );   name       .setWidth(260);
        ListGridField mobilePhone = new ListGridField(LIST_GRID_MOBILE  , CAPTION_MOBILE_PHONE);   mobilePhone.setWidth(120);
        ListGridField homePhone   = new ListGridField(LIST_GRID_PHONE   , CAPTION_HOME_PHONE  );   homePhone  .setWidth(120);

        position   .setCanReorder(false);    position   .setCanSort  (false);    position   .setCanFreeze(false);
        position   .setCanGroupBy(false);    position   .setCanFilter(false);    position   .setCanHide  (false);
        name       .setCanReorder(false);    name       .setCanSort  (false);    name       .setCanFreeze(false);
        name       .setCanGroupBy(false);    name       .setCanFilter(false);    name       .setCanHide  (false);
        mobilePhone.setCanReorder(false);    mobilePhone.setCanSort  (false);    mobilePhone.setCanFreeze(false);
        mobilePhone.setCanGroupBy(false);    mobilePhone.setCanFilter(false);    mobilePhone.setCanHide  (false);
        homePhone  .setCanReorder(false);    homePhone  .setCanSort  (false);    homePhone  .setCanFreeze(false);
        homePhone  .setCanGroupBy(false);    homePhone  .setCanFilter(false);    homePhone  .setCanHide  (false);

        list.setFields(position, name, mobilePhone, homePhone);

        layout.addMember(headerForm);
        layout.addMember(list      );

        data = new RecordList();
    	list.setData(data);

        addItem(layout);

        // String url = SERVICE_URL_START + String.valueOf(contractorID) + SERVICE_URL_END;
//        String url = SERVICE_URL_CONTRACTORS.replaceFirst("<0>", String.valueOf(contractorID));

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
        class ServiceHandler implements JSONRequestHandler
        {
		    public void onRequestComplete(JavaScriptObject content)
            {
			    // JSONIdentify identify = content.cast();
                com.google.gwt.user.client.Window.alert("ServiceHandler : " + content);
//            com.google.gwt.user.client.Window.alert("" + content.toString().length());
    		}
	    }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        class ServiceContent implements ContentRequestHandler
        {
            public void onRequestComplete(com.google.gwt.xml.client.Document content)
            {
                com.google.gwt.user.client.Window.alert("ServiceContent : " + content);
//            com.google.gwt.user.client.Window.alert("" + content.toString().length());
    		}
	    }
*/
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        String json = "http://maps.gispro.ru/ArcGIS/rest/services/MAD/mad_podrad_04_02_2011/MapServer/identify?geometryType=esriGeometryPoint&tolerance=7&sr=102113&returnGeometry=true&f=json&layers=all:0&mapExtent=3836809.1761773,7297476.3157445,4538806.8438227,7720631.7042555&geometry=4177412.5741551,7628907.2703297&imageDisplay=1148,692,96";
//        url = URL.encode(url);
//        com.google.gwt.user.client.Window.alert(url);
/*
        ServiceHandler serviceHandler = new ServiceHandler();
        new JSONRequest().get(json, serviceHandler);

        ServiceContent serviceContent = new ServiceContent();
        new ContentRequest().get(url, serviceContent);
*/
/*
         // JSON download has 1-second timeout
         setTimeout(function()
        {
            if (!window[callback + "done"])
            {
                handler.@com.google.gwt.sample.stockwatcher.client.StockWatcher::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;)(null);       }
                // cleanup
                document.body.removeChild(script);
                delete window[callback];
                delete window[callback + "done"];
            }, 1000);
        }
*/

/*
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url); // URL.encode(url));
        try {
              requestBuilder.sendRequest(null, new RequestCallback()
              {
                    public void onError(Request request, Throwable exception)
                    {
                        com.google.gwt.user.client.Window.alert("requestBuilder.sendRequest - onError : " + request );
                    }
                    public void onResponseReceived(Request request, Response response)
                    {
                        if ((response != null) && (response.getText().length() > 0))
                        {
                            com.google.gwt.user.client.Window.alert("onResponseReceived.response.getText().length() = " +
                                     response.getText().length() + ", response.getStatusCode())  = " + response.getStatusCode());
                            Document document = XMLParser.parse (response.getText());
                            Node collection = document.getFirstChild();
                            if (collection != null)
                            {
                                NodeList nodeList = collection.getChildNodes();
                                if (nodeList.getLength() > 0)
                                {
                                    for (int i = 0; i < nodeList.getLength(); i++)
                                    {
                                        NodeList desc = nodeList.item(i).getFirstChild().getChildNodes();
                                        String job = null, name = null, mobile = null, phone = null,
                                               name1 = null, name2 = null, name3 = null;
                                        for (int j = 0; j < desc.getLength(); j++)
                                        {
                                            if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure:name1"))
                                                name1 = extractValue (desc.item(j).toString());
                                            else if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure:name2"))
                                                name2 = extractValue(desc.item(j).toString());
                                            else if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure:name3"))
                                                name3 = extractValue(desc.item(j).toString());
                                            else if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure:job"))
                                                job = extractValue(desc.item(j).toString());
                                            else if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure:sot_tel"))
                                                mobile = extractValue(desc.item(j).toString());
                                            else if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure:dom_tel"))
                                                phone = extractValue(desc.item(j).toString());
                                            com.google.gwt.user.client.Window.alert("" + j + ".  nodeName = !" + desc.item(j).getNodeName() + "!, " + desc.item(j).getNodeValue() +
                                                          desc.item(j).toString());
                                        }
                                        com.google.gwt.user.client.Window.alert("" + i + ".  " + name1 + ", " + name2 + ", " + name3 + ", " + job + ", " + mobile + ", " + phone);
//                            com.google.gwt.user.client.Window.alert("onResponseReceived : people = " +
//                                                             people.getChildNodes(). .getAttributes().getNamedItem("MAD_mad_structure:job"));
                                        ListGridRecord record = new ListGridRecord();
                                        record.setAttribute(LIST_GRID_POSITION, job   );
                                        record.setAttribute(LIST_GRID_NAME    , name1 + " " + name2 + " " + name3);
                                        record.setAttribute(LIST_GRID_MOBILE  , mobile);
                                        record.setAttribute(LIST_GRID_PHONE   , phone );
                                        data.add (record);
                                    }
                                }
                            }
                        }
                    }
              });
        } catch (RequestException ex) {
//            com.google.gwt.user.client.Window.alert("RequestException");
        }
*/
        GWTViewer.MapServiceInfoServlet.loadPeople(String.valueOf(contractorID), new AsyncCallback<String>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(String content)
			{
//				com.google.gwt.user.client.Window.alert(content);
                if ((content != null) && (content.length() > 0))
                {
//                    com.google.gwt.user.client.Window.alert("0. onResponseReceived.content.length() = " + content.length());
                    Document document = null;
                    try {
                        document = XMLParser.parse (content);
                    } catch (Exception e){}
//                    com.google.gwt.user.client.Window.alert("1. onResponseReceived document = " + document);
                    Node collection = document.getFirstChild();
//                    com.google.gwt.user.client.Window.alert("2. onResponseReceived collection = " + collection);
                    if (collection != null)
                    {
                        NodeList nodeList = collection.getChildNodes();
                        if (nodeList.getLength() > 0)
                        {
                            for (int i = 0; i < nodeList.getLength(); i++)
                            {
                                NodeList desc = nodeList.item(i).getFirstChild().getChildNodes();
                                String job = null, name = null, mobile = null, phone = null,
                                       name1 = null, name2 = null, name3 = null;
                                for (int j = 0; j < desc.getLength(); j++)
                                {
                                    if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure_name1"))
                                        name1 = extractValue (desc.item(j).toString());
                                    else if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure_name2"))
                                        name2 = extractValue(desc.item(j).toString());
                                    else if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure_name3"))
                                        name3 = extractValue(desc.item(j).toString());
                                    else if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure_job"))
                                        job = extractValue(desc.item(j).toString());
                                    else if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure_sot_tel"))
                                        mobile = extractValue(desc.item(j).toString());
                                    else if (desc.item(j).getNodeName().equalsIgnoreCase("MAD_mad_structure_dom_tel"))
                                        phone = extractValue(desc.item(j).toString());
//                                    com.google.gwt.user.client.Window.alert("" + j + ".  nodeName = !" + desc.item(j).getNodeName() + "!, " + desc.item(j).getNodeValue() +
//                                                  desc.item(j).toString());
                                }
//                                com.google.gwt.user.client.Window.alert("" + i + ".  " + name1 + ", " + name2 + ", " + name3 + ", " + job + ", " + mobile + ", " + phone);
//                            com.google.gwt.user.client.Window.alert("onResponseReceived : people = " +
//                                                             people.getChildNodes(). .getAttributes().getNamedItem("MAD_mad_structure:job"));
                                ListGridRecord record = new ListGridRecord();
                                record.setAttribute(LIST_GRID_POSITION, job   );
                                record.setAttribute(LIST_GRID_NAME    , name1 + " " + name2 + " " + name3);
                                record.setAttribute(LIST_GRID_MOBILE  , mobile);
                                record.setAttribute(LIST_GRID_PHONE   , phone );
                                data.add (record);
                            }
                        }
                    }
                }
			}
		});
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String extractValue (String node)
    {
        String result = null;
        int start = node.indexOf('>');
        if (start++ > 0)
        {
            int end = node.indexOf('<', start);
            if (end > start)
                result = node.substring(start, end);
        }
        return result;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
