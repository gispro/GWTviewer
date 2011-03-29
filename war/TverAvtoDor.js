var configTverAvtoDor =
{
// DEBUG
    "debug_ServiceADD"          : false,
    "debug_InfoURL_Alert"       : false,

//~~~~~ ToolButton "zoomFullExtend" ~~~~~
    "toolButtonFullExtent"      : true,
//~~~~~ MosRegion ~~~~~
    "mosregion_municipalities"  : false,

    "isTverAvtoDor"             : true,
    "pageTitul"                 : "Дорожный Фонд Тверской области",
    "urlQuickSearch"            : "http://maps.gispro.ru:30080/ArcGIS/rest/services/tver_osn/MapServer/find?layers=25,11&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindNasPunkt"           : "http://maps.gispro.ru:30080/ArcGIS/rest/services/tver_osn/MapServer/find?layers=25&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindTitulDorog"         : "http://maps.gispro.ru:30080/ArcGIS/rest/services/routes_tver_region/MapServer/find?layers=53&f=json&searchFields=Titul&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindStreets"            : "",
    "urlRoadSoft"               : "http://maps.gispro.ru:30080/RoadSoft/",

    "baseMapTitle"              : "Тверская область - Топооснова",
    "serviceUrl"                : "http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo100_tver/MapServer",
    "baseMapType"               : "ArcGIS93",

	"centerX"    : 3831023.8569686,
	"centerY"    : 7795697.8578676,
    "zoom"       : 3,
	"mapServices":
	        [
	            {
	                "name":"Кадастровое деление",
	                "type":"ArcGIS93",
	                "serviceUrl":"http://maps.rosreestr.ru/ArcGIS/rest/services/Cadastre/Cadastre/MapServer",
	                "infoServiceUrl":"http://maps.rosreestr.ru/ArcGIS/rest/services/Cadastre/CadastreInfo/MapServer",
	                "serviceName":"",
	                "selected":false,
                    "hint":false
	            },

                {
                    "name":"Видео по дорогам",
                    "type":"ArcGIS93",
                    "serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/TVER/video/MapServer",
                    "infoServiceUrl":"",
                    "serviceName":"",
                    "selected":false,
                    "hint":false
                },

                {
                    "name":"Тверская область - Информация",
                    "type":"ArcGIS93",
                    "serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/TVER/routes_kinsh_local_db/MapServer",
                    "infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/TVER/routes_kinsh_local_db/MapServer",
                    "serviceUrl1":"http://maps.gispro.ru:30080/ArcGIS/rest/services/routes_tver_region/MapServer",
                    "infoServiceUrl1":"http://maps.gispro.ru:30080/ArcGIS/rest/services/routes_tver_region/MapServer",
                    "serviceName":"",
                    "selected":true,
                    "hint":false
                },

                {
                    "name":"Тверская область - Топооснова",
                    "type":"ArcGIS93",
                    "serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo100_tver/MapServer",
                    "serviceUrl_old":"http://maps.gispro.ru:30080/ArcGIS/rest/services/tver_osn/MapServer",
                    "infoServiceUrl":"",
                    "serviceName":"",
                    "selected":true,
                    "hint":false
                }
	        ]
//~~~~~ TverAvtoDor END ~~~~~
};