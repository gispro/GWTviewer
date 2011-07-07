var configTverAvtoDor =
{
    "withAuthorization"         : false,
    "withRegistration"          : false,
    "withOrganization"          : false,
    "withDepartment"            : false,

    "imageFormat"               : "png",
    
    "debug_ServiceADD"          : false,
    "debug_InfoURL_Alert"       : false,

    "toolButtonFullExtent"      : true,

    "mosregion_municipalities"  : false,

    "isTverAvtoDor"             : true,
    "isMosAvtoDor"              : false,
    "isMosRegion"               : false,

    "withHeader"                : false,

    "pageTitul"                 : "Дорожный Фонд Тверской области",
    "urlQuickSearch"            : "http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo100_tver/MapServer/find?layers=25,11&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindNasPunkt"           : "http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo100_tver/MapServer/find?layers=25&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindStreets"            : "",

    "urlFindTitulDorog"         : "http://maps.gispro.ru/ArcGIS/rest/services/TVER/routes_kinsh_local_db/MapServer/find?layers=45&f=json&searchFields=Titul_road&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindNomerDorog"         : "",
    "urlRoadSoft"               : "http://maps.gispro.ru/RoadSoft/",

    "baseMapURL"                : "http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo1mln100_tver/MapServer",
    "baseMapName"               : "Тверская область - Топооснова",
    "baseMapType"               : "ArcGIS93",
    
    "LegendsURL"                : "http://maps.gispro.ru:8080/MapServices/RESTLegends?soapUrl=<0>&f=pjson",
    "legendsURL_old"            : "http://portal:8080/", 
    "legendsURL_new"            : "http://94.139.241.77:8080/",
    "legendsURLServlet_old"     : "http://maps.gispro.ru:8080/",
    "legendsURLServlet_new"     : "http://maps.gispro.ru:8080/",

    "urlHelp"                   : "",   
    
    "hintJSON"                  : "TverAvtoDorHint.json",

	"centerX"                   : 3831023.8569686,
	"centerY"                   : 7795697.8578676,
    "zoom"                      : 3,
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
                    "serviceName":"",
                    "selected":true,
                    "hint":true
                },

                {
                    "name":"Тверская область - Топооснова",
                    "type":"ArcGIS93",
                    "serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo1mln100_tver/MapServer",
                    "infoServiceUrl":"",
                    "serviceName":"",
                    "selected":true,
                    "hint":false
                }
	]
};
