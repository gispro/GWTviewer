var configMosAvtoDor =
{
    "withAuthorization"         : false,
    "withRegistration"          : false,
    "withOrganization"          : false,
    "withDepartment"            : false,

    "imageFormat"               : "png",
    
    "debug_ServiceADD"          : false,
    "debug_InfoURL_Alert"       : false,

    "toolButtonFullExtent"      : false,

    "mosregion_municipalities"  : true,
    
    "isTverAvtoDor"             : false,
    "isMosAvtoDor"              : true,
    "isMosRegion"               : false,

    "withHeader"                : false,
    
    "pageTitul"                 : "Электронная карта Московской области",
    "urlQuickSearch"            : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn/MapServer/find?layers=20,10,14,17&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindNasPunkt"           : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn/MapServer/find?layers=20&f=json&searchFields=Find&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindStreets"            : "http://maps.gispro.ru/ArcGIS/rest/services/MOSOBL/mosobl_osn/MapServer/find?layers=1&f=json&searchFields=Find&&searchText=<0>&contains=true&sr=102113&returnGeometry=true",

    "urlFindTitulDorog"         : "http://maps.gispro.ru/ArcGIS/rest/services/MAD/mad_event_04_02_2011/MapServer/find?layers=5&f=json&searchFields=mad_structure.sde.L_DOR.n_dor&&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlFindNomerDorog"         : "http://maps.gispro.ru/ArcGIS/rest/services/MAD/mad_event_04_02_2011/MapServer/find?layers=5&f=json&searchFields=mad_structure.sde.L_DOR.sum_field&&searchText=<0>&contains=true&sr=102113&returnGeometry=true",
    "urlRoadSoft"               : "",

    "baseMapURL"                : "http://maps.gispro.ru/ArcGIS/rest/services/MAD/mad_osn/MapServer",
    "baseMapName"               : "Московская область - Картооснова",
    "baseMapType"               : "ArcGIS93",

    "LegendsURL"                : "http://maps.gispro.ru:8080/MapServices/RESTLegends?soapUrl=<0>&f=pjson",
    "legendsURL_old"            : "", 
    "legendsURL_new"            : "", 
    "legendsURLServlet_old"     : "http://maps.gispro.ru:8080/",
    "legendsURLServlet_new"     : "http://maps.gispro.ru:8080/",

    "urlHelp"                   : "",   
    
    "hintJSON"                  : "MosAvtodorHint.json",

	"centerX"                   : 4187808.01,
	"centerY"                   : 7509054.01,
    "zoom"                      : 4,
	"mapServices" :
	[
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
                    "hint":true
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