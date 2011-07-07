package ru.mos.gispro.client.window;

import com.google.gwt.core.client.JsArrayString;
import com.smartgwt.client.data.RecordList;
// import com.smartgwt.client.types.LayoutResizeBarPolicy;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.CloseClientEvent;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
// import com.smartgwt.client.widgets.layout.HLayout;
// import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.client.json.JSONIdentifyItem;

public class HintWindow extends Window
{
    private        ListGrid    list   = null;
    private        RecordList  data   = null;
    private        int         FIELDW = 150;
    public  static int         HEIGHT = 460;
    public  static int         WIDTH  = 470;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public HintWindow()
    {
        setTitle("\u0418\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u044F");                             // Информация
        setHeight (HEIGHT);
        setWidth  (WIDTH );
        setShowMaximizeButton(false);
        centerInPage();
        setCanDragResize(true);

        list = new ListGrid();
        list.setHeight100()  ;
        list.setWidth100()   ;
        ListGridField field = new ListGridField("field", "\u041F\u043E\u043B\u0435");                         // Поле
        ListGridField value = new ListGridField("value", "\u0417\u043D\u0430\u0447\u0435\u043D\u0438\u0435"); // Значение

        field.setWidth(FIELDW);
        list.setFields(field, value);

        field.setCanReorder(false);    field.setCanFreeze(false);    field.setCanHide  (false);
        field.setCanGroupBy(false);    field.setCanFilter(false);    field.setCanSort  (false);
        value.setCanReorder(false);    value.setCanSort  (false);    value.setCanFreeze(false);
        value.setCanGroupBy(false);    value.setCanFilter(false);    value.setCanHide  (false);

        addItem(list);

        addCloseClickHandler(new CloseClickHandler()
        {
            public void onCloseClick(CloseClientEvent event)
            {
                hide();
            }
        });
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void showData (JSONIdentifyItem jsonItem, JsArrayString keysArray)
    {
        if (data == null)
            data = new RecordList();
        data.removeList(data.toArray());
        for (int k = 0; k < keysArray.length(); ++k)
        {
            if (!"OBJECTID".equalsIgnoreCase(keysArray.get(k)))
            {
                ListGridRecord record = new ListGridRecord();
                record.setAttribute("field", keysArray.get(k));
                if (!jsonItem.attributesByKey(keysArray.get(k)).equalsIgnoreCase("null"))
                    record.setAttribute("value", jsonItem.attributesByKey(keysArray.get(k)));
                data.add(record);
            }
        }
        list.setData(data);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
