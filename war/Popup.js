var popup        ;
var hintMarker  = null;
// var hintMarkers = null;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function onPopupClose(evt)
{
//	alert("onPopupClose ...");
//    if ((hintMarkers != null) && (hintMarker != null))
//        hintMarkers.removeMarker(hintMarker);
    if (popup != null)
    {
        popup.destroy();
        popup = null;
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function onFeatureSelect(hint)
{
//	alert("0. onFeatureSelect : " + hintMarker + ", " + hint);
    if (popup != null)
        onPopupClose(null);
//    if (hintMarkers == null)
//    {
//        hintMarkers = new OpenLayers.Layer.Markers("\u041C\u0435\u0442\u043A\u0438");    // Метки
////        hintMarkers.setZIndex(1000);
//        map.addLayer(hintMarkers);
//    }
/*
    popup = new OpenLayers.Popup.FramedCloud("markerPopup", hintMarker, null,
                                              hint,
                                              null, false, null); // true, onPopupClose); // function(){onPopupClose(null);});

*/
    popup = new OpenLayers.Popup.Anchored("markerPopup", hintMarker, new OpenLayers.Size(200, 50),
                                           hint,
                                           null, false, null);
/**/
/*
    popup = new OpenLayers.Popup.AnchoredBubble("markerPopup", hintMarker, new OpenLayers.Size(200, 50),
                                              hint,
                                              null, false, null);
*/
/*
    popup = new OpenLayers.Popup("markerPopup", hintMarker, new OpenLayers.Size(180, 40),
                                              hint,
                                              null, false, null);
*/
    popup.setOpacity("0.8");
    popup.setBorder ("1px solid #333366");

    popup.setBackgroundColor("yellow");
    hintMarker.popup = popup;
    popup.feature = hintMarker;

//        popup.closeOnMove = true;
/*
 popup.autoSize = false;
 alert("2. onFeatureSelect : " + map);
 AutoSizeFramedCloud = OpenLayers.Class(OpenLayers.Popup.FramedCloud, { 'autoSize': true });
 */
        map.addPopup(popup); // , AutoSizeFramedCloud);
//    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
