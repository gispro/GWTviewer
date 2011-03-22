package ru.mos.gispro.client.window;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
// import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.client.IBaseMap;
import ru.mos.gispro.client.elements.BaseMapRecord;
// import ru.mos.gispro.client.window.WindowBase;

public class BaseMapWindow  extends WindowBase
{
    public    final   static    int                  WIDTH                   = 690;
    public    final   static    int                  HEIGHT                  = 550;
    private                     IBaseMap             callback                = null;

    private           static    BaseMapRecord[]      records                 = {
           new BaseMapRecord("\u041A\u0430\u0440\u0442\u043E\u043E\u0441\u043D\u043E\u0432\u0430\u0020\u041C\u043E\u0441\u043A\u043E\u0432\u0441\u043A\u043E\u0439\u0020\u043E\u0431\u043B\u0430\u0441\u0442\u0438",
                             "baseMap.png", "BaseMap"),
           null, null,
           new BaseMapRecord("\u0047\u006F\u006F\u0067\u006C\u0065\u0020\u041A\u0430\u0440\u0442\u0430",
                             "baseMapGoogleStreet.png"    , "GoogleStreets"  ),
            new BaseMapRecord("\u0047\u006F\u006F\u0067\u006C\u0065\u0020\u0413\u0438\u0431\u0440\u0438\u0434",
                              "baseMapGoogleHybrid.png"   , "GoogleHybrid"   ),
            new BaseMapRecord("\u0047\u006F\u006F\u0067\u006C\u0065\u0020\u0421\u043F\u0443\u0442\u043D\u0438\u043A",
                              "baseMapGoogleSatellite.png", "GoogleSatellite"),
            new BaseMapRecord("\u0042\u0069\u006E\u0067\u0020\u004D\u0061\u0070\u0020\u041A\u0430\u0440\u0442\u0430",
                              "baseMapGoogleSatellite.png", "BingMapStreets" ),
            new BaseMapRecord("\u0042\u0069\u006E\u0067\u0020\u004D\u0061\u0070\u0020\u0413\u0438\u0431\u0440\u0438\u0434",
                              "baseMapGoogleStreet.png"   , "BingMapHybrid"  ),
            new BaseMapRecord("\u0042\u0069\u006E\u0067\u0020\u004D\u0061\u0070\u0020\u0421\u043F\u0443\u0442\u043D\u0438\u043A",
                              "baseMapGoogleHybrid.png"   , "BingMapSatellite")
    };
                                                                               // Картооснова
    private   final   static    String               WINDOW_TITLE            = "\u041A\u0430\u0440\u0442\u043E\u043E\u0441\u043D\u043E\u0432\u0430";
    public    final   static    String[]             baseMapList             = {"BaseMap",
                                                                                "GoogleStreets" , "GoogleHybrid" , "GoogleSatellite",
                                                                                "BingMapStreets", "BingMapHybrid", "BingMapSatellite"};
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public BaseMapWindow (IBaseMap callback)
	{
		super(WINDOW_TITLE, WIDTH, HEIGHT, null);
        this.callback = callback;
//      setCanDragResize (true);
//      this.setMinimized(false);
        this.setIsModal(false);

        final TileGrid tileGrid = new TileGrid();
        tileGrid.setTileWidth (210);
        tileGrid.setTileHeight(160);
        tileGrid.setHeight100(); //     (550);
        tileGrid.setWidth100();
//         tileGrid.setCanReorderTiles(true);
        tileGrid.setShowAllRecords(true);
        tileGrid.setData(records);

        DetailViewerField pictureField = new DetailViewerField("picture");
        pictureField.setType("image");
        pictureField.setImageURLPrefix("");
        pictureField.setImageWidth(202);
        pictureField.setImageHeight(130);

        DetailViewerField nameField = new DetailViewerField("name");
//        DetailViewerField descField = new DetailViewerField("title");

        tileGrid.setFields(pictureField, nameField);
        addItem(tileGrid);

        tileGrid.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
//                com.google.gwt.user.client.Window.alert(tileGrid.getSelectedRecord().getAttribute("title") +
//                ", " + tileGrid.getSelectedRecord().getAttribute("name"));
                setBaseMap (tileGrid.getSelectedRecord().getAttribute("title"));
            }
        });
    }
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void setBaseMap (String baseMapName)
    {
        if (callback != null)
            callback.setBaseMap(baseMapName);
    }
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void closeForm()
    {
        if (callback != null)
            callback.closeBaseMapWindow();
        else
            super.closeForm();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
