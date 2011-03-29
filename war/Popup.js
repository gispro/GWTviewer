var popup        ;
var hintMarker  = null;
// var hintMarkers = null;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
function onPopupClose(evt)
{
	alert("onPopupClose ...");
//    if ((hintMarkers != null) && (hintMarker != null))
//        hintMarkers.removeMarker(hintMarker);
    popup.destroy();
    popup = null;
}
*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function onFeatureSelect(hint)
{
//	alert("0. onFeatureSelect : " + hintMarker + ", " + hint);
//    if (popup != null)
//        onPopupClose(null);
//    if (hintMarkers == null)
//    {
//        hintMarkers = new OpenLayers.Layer.Markers("\u041C\u0435\u0442\u043A\u0438");    // Метки
////        hintMarkers.setZIndex(1000);
//        map.addLayer(hintMarkers);
//    }
//    alert("1. onFeatureSelect : : " + hintMarker + ", " + hintMarkers);
//    hintMarkers.addMarker(new OpenLayers.Marker(hintMarker, null));
//    alert("2. onFeatureSelect : ");

//    if (popup == null)
//    {
        popup = new OpenLayers.Popup.FramedCloud("markerPopup", hintMarker, null,
                                                  hint,
                                                  null, false, null); // true, onPopupClose); // function(){onPopupClose(null);});
//     alert("1. onFeatureSelect : " + hintMarker);
        hintMarker.popup = popup;
        popup.feature = hintMarker;
        popup.closeOnMove = true;
/*
 popup.autoSize = false;
 alert("2. onFeatureSelect : " + map);
 AutoSizeFramedCloud = OpenLayers.Class(OpenLayers.Popup.FramedCloud, { 'autoSize': true });
 */
        map.addPopup(popup, true); // , AutoSizeFramedCloud);
//    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
