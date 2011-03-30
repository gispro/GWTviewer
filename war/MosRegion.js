var configMosRegion =
{
// Authorizationa & registration
    "withAuthorization"         : false,
    "withRegistration"          : true,
    "withOrganization"          : false,
    "withDepartment"            : false,
// DEBUG
    "debug_ServiceADD"          : false,
    "debug_InfoURL_Alert"       : false,

//~~~~~ ToolButton "zoomFullExtend" ~~~~~
    "toolButtonFullExtent"      : false,

    "mosregion_municipalities"  : true,
    "isTverAvtoDor"             : false,
// Header
    "withHeader"                : true,

    "pageTitul"                 : "Электронная карта Московской области",
    "urlQuickSearch"            : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn/MapServer/find?layers=20,10,14,17&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindNasPunkt"           : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn/MapServer/find?layers=20&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindStreets"            : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn/MapServer/find?layers=1&f=json&searchFields=Find&&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "baseMapTitle"              : "Московская область - Картооснова",
    "baseMapURL"                : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn/MapServer",
    "baseMapType"               : "ArcGIS93",
    "urlFindTitulDorog"         : "",
    "urlRoadSoft"               : "",

	"centerX"     : 4187808.01,
	"centerY"     : 7509054.01,
    "zoom"        : 4,
	"mapServices" : [
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
                    "selected":true,
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
                    "selected":true,
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
					"serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn/MapServer",
					"infoServiceUrl":"",
					"serviceName":"",
					"selected":true,
                    "hint":false
				}
	]
};
