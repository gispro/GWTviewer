package ru.mos.gispro.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONConfig extends JavaScriptObject
{
	protected JSONConfig() { }

    public final native boolean          withAuthorization         () /*-{ return this.withAuthorization;        }-*/;
    public final native boolean          withRegistration          () /*-{ return this.withRegistration;         }-*/;
    public final native boolean          withOrganization          () /*-{ return this.withOrganization;         }-*/;
    public final native boolean          withDepartment            () /*-{ return this.withDepartment;           }-*/;

	public final native double           centerX                   () /*-{ return this.centerX;                  }-*/;
	public final native double           centerY                   () /*-{ return this.centerY;                  }-*/;
    public final native int              zoom                      () /*-{ return this.zoom;                     }-*/;
	public final native JsArray          layers                    () /*-{ return this.mapServices;              }-*/;
	public final native JavaScriptObject layer                (int i) /*-{ return this.mapServices[i];           }-*/;

    public final native boolean          isTverAvtoDor             () /*-{ return this.isTverAvtoDor;            }-*/;
    public final native boolean          isMosAvtoDor              () /*-{ return this.isMosAvtoDor;             }-*/;
    public final native boolean          isMosRegion               () /*-{ return this.isMosRegion;              }-*/;

    public final native boolean          municipalities            () /*-{ return this.mosregion_municipalities; }-*/;
    public final native boolean          toolButtonFullExtent      () /*-{ return this.toolButtonFullExtent;     }-*/;
    public final native boolean          withHeader                () /*-{ return this.withHeader;               }-*/;

    public final native String           getPageTitle              () /*-{ return this.pageTitul;                }-*/;
    public final native String           getURLQuickSearch         () /*-{ return this.urlQuickSearch;           }-*/;
    public final native String           getURLFindNasPunkt        () /*-{ return this.urlFindNasPunkt;          }-*/;
    public final native String           getURLFindStreets         () /*-{ return this.urlFindStreets;           }-*/;
    public final native String           findTitulDorog            () /*-{ return this.urlFindTitulDorog;        }-*/;
    public final native String           getURLRoadSoft            () /*-{ return this.urlRoadSoft;              }-*/;

    public final native String           getBaseMapURL             () /*-{ return this.baseMapURL;               }-*/;
    public final native String           getBaseMapTitle           () /*-{ return this.baseMapTitle;             }-*/;
    public final native String           getBaseMapType            () /*-{ return this.baseMapType;              }-*/;

    public final native boolean          debug_serviceADD          () /*-{ return this.debug_ServiceADD;         }-*/;
    public final native boolean          debug_InfoURL_Alert       () /*-{ return this.debug_InfoURL_Alert;      }-*/;
}
