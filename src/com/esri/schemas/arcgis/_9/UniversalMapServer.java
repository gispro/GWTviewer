package com.esri.schemas.arcgis._9;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

@WebServiceClient(name = "Agriculture_MapServer", targetNamespace = "http://www.esri.com/schemas/ArcGIS/9.3", wsdlLocation = "http://rest.ecto.advantum.ru/arcgis/services/Agriculture/MapServer?wsdl")
public class UniversalMapServer extends Service{

//    private final static URL AGRICULTUREMAPSERVER_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.esri.schemas.arcgis._9.AgricultureMapServer.class.getName());

//    static {
//        URL url = null;
//        try {
//            URL baseUrl;
//            baseUrl = com.esri.schemas.arcgis._9.AgricultureMapServer.class.getResource(".");
////            url = new URL(baseUrl, "http://rest.ecto.advantum.ru/arcgis/services/Agriculture/MapServer?wsdl");
//            url = new URL(baseUrl, wsdlLocation);
//        } catch (MalformedURLException e) {
//            logger.warning("Failed to create URL for the wsdl Location: 'http://rest.ecto.advantum.ru/arcgis/services/Agriculture/MapServer?wsdl', retrying as a local file");
//            logger.warning(e.getMessage());
//        }
//        AGRICULTUREMAPSERVER_WSDL_LOCATION = url;
//    }

//    public UniversalMapServer(URL wsdlLocation, QName serviceName) {
//        super(wsdlLocation, serviceName);
//    }

//    public UniversalMapServer() {
//        super(AGRICULTUREMAPSERVER_WSDL_LOCATION, new QName("http://www.esri.com/schemas/ArcGIS/9.3", "Agriculture_MapServer"));
//    }

    public UniversalMapServer(String wsdl, String localPart) throws MalformedURLException {
        
        super(new URL(com.esri.schemas.arcgis._9.UniversalMapServer.class.getResource("."), wsdl), new QName("http://www.esri.com/schemas/ArcGIS/9.3", localPart));
//        super(new URL(com.esri.schemas.arcgis._9.UniversalMapServer.class.getResource("."), wsdl), new QName("http://www.esri.com/schemas/ArcGIS/9.3", "Cadastre_MapServer"));

    }

    /**
     *
     * @return
     *     returns MapServerPort
     */
    @WebEndpoint(name = "MapServerPort")
    public MapServerPort getMapServerPort() {
        return super.getPort(new QName("http://www.esri.com/schemas/ArcGIS/9.3", "MapServerPort"), MapServerPort.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MapServerPort
     */
    @WebEndpoint(name = "MapServerPort")
    public MapServerPort getMapServerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.esri.com/schemas/ArcGIS/9.3", "MapServerPort"), MapServerPort.class, features);
    }

}
