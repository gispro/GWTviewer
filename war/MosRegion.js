var configMosRegion =
{
    "withAuthorization"         : false,
    "withRegistration"          : false,
    "withOrganization"          : false,
    "withDepartment"            : false,

    "imageFormat"               : "png24",

    "debug_ServiceADD"          : false,
    "debug_InfoURL_Alert"       : false,

    "toolButtonFullExtent"      : false,

    "mosregion_municipalities"  : true,

    "isTverAvtoDor"             : false,
    "isMosAvtoDor"              : false,
    "isMosRegion"               : true,

    "withHeader"                : true,

    "pageTitul"                 : "Электронная карта Московской области",
    "urlQuickSearch"            : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/find_mosregion/MapServer/find?layers=2,0,3&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindNasPunkt"           : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/find_mosregion/MapServer/find?layers=2&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindStreets"            : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/find_mosregion/MapServer/find?layers=1&f=json&searchFields=Find&&searchText=<0>&contains=true&sr=102113&returnGeometry=true",

    "urlFindTitulDorog"         : "",
    "urlFindNomerDorog"         : "",
    "urlRoadSoft"               : "",

    "baseMapURL"                : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn_1mln/MapServer",
    "baseMapName"               : "Московская область - Картооснова",
    "baseMapType"               : "ArcGIS93",

    "LegendsURL"                : "http://maps.gispro.ru:8080/MapServices/RESTLegends?soapUrl=<0>&f=pjson",
    "legendsURL_old"            : "http://portal:8080/", 
    "legendsURL_new"            : "http://maps.gispro.ru:8080/",
    "legendsURLServlet_old"     : "http://maps.gispro.ru:8080/",
    "legendsURLServlet_new"     : "http://maps.gispro.ru:8080/",

    "urlHelp"                   : "http://maps.gispro.ru:8080/MosRegion/doc/MosRegion Presentation.ppt",   
    
    "hintJSON"                  : "MosRegionHint.json",

	"centerX"                   : 4187808.01,
	"centerY"                   : 7509054.01,
    "zoom"                      : 4,
	"mapServices" : 
	[
				{
					"name":"Административные единицы",
					"type":"ArcGIS93",
					"serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/adm_mosobl/MapServer",
					"infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/adm_mosobl/MapServer",
					"serviceName":"",
					"selected":false,
                    "hint":false
				},
                {
                    "name":"Объекты строительства",
                    "type":"ArcGIS93",
                    "serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/invest_objects/MapServer",
                    "infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/invest_objects/MapServer",
                    "serviceName":"",
                    "selected":false,
                    "hint":true
                },
                {
                    "name":"Земельные участки и налоги",
                    "type":"ArcGIS93",
                    "serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_kadastr/MapServer",
                    "infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_kadastr/MapServer",
                    "serviceName":"",
                    "selected":false,
                    "hint":true
                },
                {
                    "name":"Население",
                    "type":"ArcGIS93",
                    "serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/population/MapServer",
                    "infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/population/MapServer",
                    "serviceName":"",
                    "selected":false,
                    "hint":false
                },
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
                    "name":"Дорожная инфраструктура",
                    "type":"ArcGIS93",
                    "serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/road_infr/MapServer",
                    "infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/road_infr/MapServer",
                    "serviceName":"",
                    "selected":false,
                    "hint":false
                },
                {
                    "name":"Сельское хозяйство",
                    "type":"ArcGIS93",
                    "serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/agro_lands/MapServer",
                    "infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/agro_lands/MapServer",
                    "serviceName":"",
                    "selected":false,
                    "hint":false
                },
				{
					"name":"Трубопроводы",
					"type":"ArcGIS93",
					"serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/pipe_transport/MapServer",
					"infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/pipe_transport/MapServer",
					"serviceName":"",
					"selected":false,
                    "hint":false
				},
				{
					"name":"ЛЭП",
					"type":"ArcGIS93",
					"serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_lep/MapServer",
					"infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_lep/MapServer",
					"serviceName":"",
					"selected":false,
                    "hint":false
				},
				{
					"name":"Московская область - Картооснова",
					"type":"ArcGIS93",
					"serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn_1mln/MapServer",
					"infoServiceUrl":"",
					"serviceName":"",
					"selected":false,
                    "hint":false
				}
	]
};
