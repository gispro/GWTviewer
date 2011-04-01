var configMosAvtoDor =
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
    "isMosAvtoDor"              : true,
// Header
    "withHeader"                : false,

    "pageTitul"                 : "Электронная карта Московской области",
    "urlQuickSearch"            : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn/MapServer/find?layers=20,10,14,17&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindNasPunkt"           : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn/MapServer/find?layers=20&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindStreets"            : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn/MapServer/find?layers=1&f=json&searchFields=Find&&searchText=<0>&contains=true&sr=102113&returnGeometry=true",

    "baseMapURL"                : "http://maps.gispro.ru/ArcGIS/rest/services/MAD/mad_osn/MapServer",
    "baseMapType"               : "ArcGIS93",

    "urlFindTitulDorog"         : "",
    "urlRoadSoft"               : "",

    "hintDelay"   : 500,
    "hintDesc"    : [
                 {
                    "identifier" : "Краткое название",
                    "isTitle"    : true,
                    "layerN"     : 1,
                    "html"       : "<div style=\"font-size:1em;font-weight:bold;\"><0></div>"
                 },
                 {
                    "identifier" : "ГородРабАдр",
                    "isTitle"    : false,
                    "layerN"     : 1,
                    "html"       : "<div style=\"font-size:.9em;font-style:italic;\">Место : <0></div>"
                 },
                 {
                    "identifier" : "Телефон",
                    "isTitle"    : false,
                    "layerN"     : 1,
                    "html"       : "<div style=\"font-size:.9em;font-style:italic;\">Телефон : <0></div>"
                 }
    ],

	"centerX"     : 4187808.01,
	"centerY"     : 7509054.01,
    "zoom"        : 4,
	"mapServices" : [
				{
					"name":"Московская область - Подрядчики",
					"type":"ArcGIS93",
					"serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MAD/mad_podrad_04_02_2011/MapServer",
					"infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MAD/mad_podrad_04_02_2011/MapServer",
					"serviceName":"",
					"selected":true,
                    "hint":true
				},
				{
					"name":"Московская область - Дорожная инфраструктура",
					"type":"ArcGIS93",
					"serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MAD/mad_event_04_02_2011/MapServer",
					"infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MAD/mad_event_04_02_2011/MapServer",
					"serviceName":"",
					"selected":true,
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
					"name":"Административные единицы",
					"type":"ArcGIS93",
					"serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/adm_mosobl/MapServer",
					"infoServiceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/adm_mosobl/MapServer",
					"serviceName":"",
					"selected":false,
                    "hint":false
				},
				{
					"name":"Московская область - Картооснова",
					"type":"ArcGIS93",
					"serviceUrl":"http://maps.gispro.ru/ArcGIS/rest/services/MAD/mad_osn/MapServer",
					"infoServiceUrl":"",
					"serviceName":"",
					"selected":true,
                    "hint":false
				}
	]
};