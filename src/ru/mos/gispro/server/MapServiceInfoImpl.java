package ru.mos.gispro.server;

import java.net.MalformedURLException;
import java.util.*;

import com.esri.schemas.arcgis._9.*;
import org.apache.commons.codec.binary.Base64;

import ru.mos.gispro.client.LegendInfo;
import ru.mos.gispro.client.MapServiceInfo;
import ru.mos.gispro.shared.References;
import ru.mos.gispro.shared.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class MapServiceInfoImpl extends RemoteServiceServlet implements MapServiceInfo
{
    public    final   static   String   JSON_ORGANIZATIONS_TITLE = "organizations";
    public    final   static   String   JSON_DEPARTMENTS_TITLE   = "departments"  ;

    private   final   static   String   JSON_ORGANIZATIONS_STUB  = "{\"organisations\" : []}";
    private   final   static   String   JSON_DEPARTMENTS_STUB    = "{\"departments\" : []}";
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Map<String,String> Legends(String input) throws IllegalArgumentException
    {
        Map<String,String> res = new HashMap<String,String>();

        String address;

        address = input.replace("?wsdl", "");
        address = address.replace("?WSDL", "");
        address = address.replace("/rest/", "/");

        String[] split = address.split("/");

        String localPart = split[split.length - 2] + "_" + split[split.length - 1];

        UniversalMapServer server = null;
        try {
            server = new UniversalMapServer(address, localPart);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        MapServerPort stub = server.getMapServerPort();

        ImageType imageType = new ImageType();
        imageType.setImageFormat(EsriImageFormat.ESRI_IMAGE_PNG);
        imageType.setImageReturnType(EsriImageReturnType.ESRI_IMAGE_RETURN_MIME_DATA);

        Integer mapCount = stub.getMapCount();

//        for (int mi = 0; mi < mapCount; mi++) {
            String mapName = stub.getMapName(0);

            ArrayOfMapServerLegendInfo response = stub.getLegendInfo(mapName, null, null, imageType);

            int iid = 0, gid = 0, cid = 0;
            for (MapServerLegendInfo i : response.getMapServerLegendInfo()) {
//                System.out.println("layerID     : " + i.getLayerID());
//                System.out.println("Name :      " + i.getName());

                String id = Integer.toString(i.getLayerID());

                byte[] image = i.getLegendGroups().getMapServerLegendGroup().get(0).getLegendClasses()
                    .getMapServerLegendClass().get(0).getSymbolImage().getImageData();

                byte[] imageBase64 = Base64.encodeBase64(image);

                res.put(id, "data:image/png;base64," + new String(imageBase64));

//                for (MapServerLegendGroup g : i.getLegendGroups().getMapServerLegendGroup()) {
////                    System.out.println("Heading     : " + g.getHeading());
//
//                    for (MapServerLegendClass c : g.getLegendClasses().getMapServerLegendClass()) {
////                        System.out.println("Label       : " + c.getLabel());
////                        System.out.println("Description : " + c.getDescription());
////                        System.out.println("Image       : " + c.getSymbolImage());
//
//                        LegendInfo legendInfo = new LegendInfo();
//
//                        legendInfo.setId(String.valueOf(iid) + "_" + String.valueOf(gid) + "_" + String.valueOf(cid));
//                        legendInfo.setLayerId(String.valueOf(i.getLayerID()));
//                        legendInfo.setName(i.getName());
//                        legendInfo.setHeading(g.getHeading());
//                        legendInfo.setLabel(c.getLabel());
//                        legendInfo.setDescription(c.getDescription());
//
//                        byte[] image = c.getSymbolImage().getImageData();
//                        try {
//                            String fileName = path + String.valueOf(iid) + "_" + String.valueOf(gid) + "_" + String.valueOf(cid) + ".png";
//                            writeFile(image, fileName);
//                            legendInfo.setIcon(fileName);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                            legendInfo.setIcon(null);
//                        }
//                        legendInfos.add(legendInfo);
//                        cid++;
//                    }
//                    gid++;
//                }
//                iid++;
            }
//        }
            return res;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Map<String,List<LegendInfo>> legendsTrue(String input) throws IllegalArgumentException
    {
        Map<String,List<LegendInfo>> res = new HashMap<String, List<LegendInfo>>();

        String address;

        address = input.replace("?wsdl", "");
        address = address.replace("?WSDL", "");
        address = address.replace("/rest/", "/");

        String[] split = address.split("/");

        String localPart = split[split.length - 2] + "_" + split[split.length - 1];

        UniversalMapServer server = null;
        try {
            server = new UniversalMapServer(address, localPart);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        MapServerPort stub = server.getMapServerPort();

        ImageType imageType = new ImageType();
        imageType.setImageFormat(EsriImageFormat.ESRI_IMAGE_PNG);
        imageType.setImageReturnType(EsriImageReturnType.ESRI_IMAGE_RETURN_MIME_DATA);


        Integer mapCount = stub.getMapCount();

//        for (int mi = 0; mi < mapCount; mi++) {

            String mapName = stub.getMapName(0);

            ArrayOfMapServerLegendInfo response = stub.getLegendInfo(mapName, null, null, imageType);

            int iid = 0, gid = 0, cid = 0;
            for (MapServerLegendInfo i : response.getMapServerLegendInfo()) {
//                System.out.println("layerID     : " + i.getLayerID());
//                System.out.println("Name :      " + i.getName());

                String id = Integer.toString(i.getLayerID());

                List<LegendInfo> legendInfos = new ArrayList<LegendInfo>();

                int labelId = 0;
                for (MapServerLegendGroup group : i.getLegendGroups().getMapServerLegendGroup()) {

//                    System.out.println("group.getHeading() : " + group.getHeading());
                    for (MapServerLegendClass clas : group.getLegendClasses().getMapServerLegendClass())
                    {
//                        System.out.println("id: " + id + "    label: " + clas.getLabel() + "  descr: " + clas.getDescription() + "           simbol: " + clas.getSymbolImage());

//                        byte[] image = i.getLegendGroups().getMapServerLegendGroup().get(0).getLegendClasses()
//                        .getMapServerLegendClass().get(0).getSymbolImage().getImageData();

                        byte[] image       = clas.getSymbolImage().getImageData();
                        byte[] imageBase64 = Base64.encodeBase64(image);

                        String label = id + "_" + labelId++ + "_" + clas.getLabel();

                        LegendInfo legendInfo = new LegendInfo();
                        legendInfo.setLayerId(id);
                        legendInfo.setLabelId(String.valueOf(labelId++));
                        legendInfo.setLabel(clas.getLabel());
                        legendInfo.setDescription(clas.getDescription());
                        legendInfo.setIcon("data:image/png;base64," + new String(imageBase64));
                        legendInfos.add(legendInfo);
//                        res.put(label, "data:image/png;base64," + new String(imageBase64));
                    }

                }

                res.put(id, legendInfos);
//                byte[] image = i.getLegendGroups().getMapServerLegendGroup().get(0).getLegendClasses()
//                    .getMapServerLegendClass().get(0).getSymbolImage().getImageData();
//
//                byte[] imageBase64 = Base64.encodeBase64(image);
//
//                res.put(id, "data:image/png;base64," + new String(imageBase64));

//                for (MapServerLegendGroup g : i.getLegendGroups().getMapServerLegendGroup()) {
////                    System.out.println("Heading     : " + g.getHeading());
//
//                    for (MapServerLegendClass c : g.getLegendClasses().getMapServerLegendClass()) {
////                        System.out.println("Label       : " + c.getLabel());
////                        System.out.println("Description : " + c.getDescription());
////                        System.out.println("Image       : " + c.getSymbolImage());
//
//                        LegendInfo legendInfo = new LegendInfo();
//
//                        legendInfo.setId(String.valueOf(iid) + "_" + String.valueOf(gid) + "_" + String.valueOf(cid));
//                        legendInfo.setLayerId(String.valueOf(i.getLayerID()));
//                        legendInfo.setName(i.getName());
//                        legendInfo.setHeading(g.getHeading());
//                        legendInfo.setLabel(c.getLabel());
//                        legendInfo.setDescription(c.getDescription());
//
//                        byte[] image = c.getSymbolImage().getImageData();
//                        try {
//                            String fileName = path + String.valueOf(iid) + "_" + String.valueOf(gid) + "_" + String.valueOf(cid) + ".png";
//                            writeFile(image, fileName);
//                            legendInfo.setIcon(fileName);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                            legendInfo.setIcon(null);
//                        }
//                        legendInfos.add(legendInfo);
//                        cid++;
//                    }
//                    gid++;
//                }
//                iid++;
            }
//        }
            return res;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private HttpSession getHttpSession ()
    {
        HttpServletRequest request = this.getThreadLocalRequest();
        return request.getSession();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String userConnect(String login, String password) throws IllegalArgumentException
    {
        Global.writeLog (Global.LOG_SECTION_SERVLET + "0. MapServiceInfoImpl : userConnect - login=" + login +
                                                      ", password=" + password);

        DataModule dm = new DataModule();
        if (Global.onIDE)
            return dm.getUser(login, password);
        else
        {
            User user = null;
            dm.Connect(Global.LOGIN, Global.PASSWORD);
            if (Global.onHash)
                user = dm.getUser(login, Global.getMessageDigest(password), Global.onHash);
            else
                user = dm.getUser(login, password, Global.onHash);

            Global.writeLog (Global.LOG_SECTION_SERVLET + "1. MapServiceInfoImpl : userConnect - user=" + user +
                                                          ", hash=" + Global.getMessageDigest(password));

            if ((user != null) && (user.isActive()))
            {
                Global.rememberSessionLogin (getHttpSession(), login);
                return user.getSname() + ' ' + user.getName() + '/' + user.getStatus();
            } else
                return null;
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String loadOrganizations() throws IllegalArgumentException
    {
        return loadReferences(DataModule.TABLE_ORGANIZATIONS, JSON_ORGANIZATIONS_TITLE, JSON_ORGANIZATIONS_STUB);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String loadDepartments() throws IllegalArgumentException
    {
        return loadReferences(DataModule.TABLE_DEPARTMENTS, JSON_DEPARTMENTS_TITLE, JSON_DEPARTMENTS_STUB);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private static String loadReferences(String table, String title, String stub)
    {
        String content = null;
        DataModule dm  = new DataModule();

        dm.Connect(Global.LOGIN, Global.PASSWORD);
        if ((dm.getConnection () != null) || Global.onIDE)
        {
            List<References> refs = DataModule.loadReferences (dm.getConnection(), table);
            if (refs != null)
                content = Global.convertListToStringJSON(refs, title);
            dm.Disconnect();
        }
        if (content == null)
            content = stub;
        return content;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String registration(String sname, String name, String pname, String login, String password,
                               String organization, String department, String position) throws IllegalArgumentException
    {
        Global.writeLog (Global.LOG_SECTION_SERVLET + "0. MapServiceInfoImpl : registration - " + sname + ", " + name + ", " + pname +
                                                      " / " + login + ", " + password + " / " +
                                                      organization + "," +  department + "," + position);
        String result = Global.ACTION_RESULT_SUCCESS;

        DataModule dm = new DataModule();
        try {
            dm.Connect(Global.LOGIN, Global.PASSWORD);
            if (dm.getConnection () != null)
            {
                // Validation
                String pw   = password;
                String hash = Global.getMessageDigest(password);
                if (Global.onHash)
                    pw = hash;

                if (dm.isNewUserDoubled(login, pw, Global.onHash))
                    return Global.ACTION_RESULT_EXCEPT + " doubled record";
                else
                {
                    int count = DataModule.getValue(dm.getConnection(), DataModule.SQL_SELECT_COUNT , DataModule.TABLE_USERS);
                    int id    = DataModule.getValue(dm.getConnection(), DataModule.SQL_SELECT_MAX_ID, DataModule.TABLE_USERS);

                    if (count == 0)
                        id = 0;
                    id++;

                    pw = "";
                    if (!Global.onHash)
                        pw = password;

                    Global.writeLog (Global.LOG_SECTION_SERVLET + "1. EastLineServletImpl : registration - create new user = id " + id + ", hash = " + hash);
                    int rc = dm.insertUser(DataModule.TABLE_USERS, id, sname, name, pname, login, pw,
                                           Integer.valueOf(organization), Integer.valueOf(department),
                                           Integer.valueOf(position), hash);
                    if (rc < 1)
                    {
                        result = Global.ACTION_RESULT_EXCEPT + " Connection to DataBase failed";
                        Global.writeLog (Global.LOG_SECTION_SERVLET + "result = " + result);
                    }
                }
            }
            else
                result = Global.ACTION_RESULT_EXCEPT + " Connection to DataBase failed";
        } finally {
            if (dm != null)
                dm.Disconnect();
        }
        Global.writeLog (Global.LOG_SECTION_SERVLET + "2. MapServiceInfoImpl : registration - result = " + result);
        return result;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
//        String addr = "http://rest.ecto.advantum.ru/arcgis/services/Agriculture/MapServer?wsdl";
//        String addr = "http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo100_tver/MapServer";
//        String addr = "http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo100_tver/MapServer";
//        String addr = "http://maps.gispro.ru/ArcGIS/rest/services/ESIMO/P0001/MapServer";

//        String addr = "http://maps.gispro.ru/ArcGIS/services/TVER/routes_tver_region_29112010/MapServer/";
//        MapServiceInfoImpl m = new MapServiceInfoImpl();
//        m.legendsTrue(addr);
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    public Map<String,String> Legends____wsc_dont_work(String input) throws IllegalArgumentException {
//
//        com.sforce.soap.ArcGIS93.ArrayOfMapServerLegendInfo info;
//        Map<String,String> res = new HashMap<String,String>();
//
//        try {
//            ConnectorConfig config = new ConnectorConfig();
////			config.setTransport(GaeHttpTransport.class);
//            String endpoint = input.replaceAll("/rest/", "/");
////			config.setAuthEndpoint(endpoint);
//            config.setServiceEndpoint(endpoint);
////			config.setTraceMessage(true);
//
//            SoapConnection test = Connector.newConnection(config);
//            com.sforce.soap.ArcGIS93.ImageType imageType = new com.sforce.soap.ArcGIS93.ImageType();
//            imageType.setImageFormat(com.sforce.soap.ArcGIS93.EsriImageFormat.esriImagePNG);
//            imageType.setImageReturnType(com.sforce.soap.ArcGIS93.EsriImageReturnType.esriImageReturnURL);
////	        imageType.setImageReturnType(com.sforce.soap.ArcGIS93.EsriImageReturnType.esriImageReturnMimeData);
//
//            info = test.GetLegendInfo(test.GetDefaultMapName(), null, null, imageType);
//
////			String baseUrl = "";
////	        try {
////				URL url2 = new URL(input);
////				baseUrl = url2.getProtocol() + "://"+ url2.getHost() + ":8399/arcgis/server/arcgisoutput/";
////			} catch (MalformedURLException e) {
////				e.printStackTrace();
////				return null;
////			}
//
//            String path = "../webapps/TverAvtoDor/images/img/" + input.hashCode() + "/";
//            File p = new File(path);
//            p.mkdirs();
//
//
//            for (MapServerLegendInfo x: info.getMapServerLegendInfo()) {
//                String id = Integer.toString(x.getLayerID());
//
//                byte[] image = x.getLegendGroups().getMapServerLegendGroup()[0].getLegendClasses()
//                    .getMapServerLegendClass()[0].getSymbolImage().getImageData();
//
//                try {
//                    String fileName = path + String.valueOf(id) + ".png";
//                    writeFile(image, fileName);
//                    res.put(id, "/img/" + input.hashCode() + "/" + fileName);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
////                String image = x.getLegendGroups().getMapServerLegendGroup()[0].getLegendClasses()
////					.getMapServerLegendClass()[0].getSymbolImage().getImageURL();
//
//
////				String image = x.getLegendGroups().getMapServerLegendGroup()[0].getLegendClasses()
////					.getMapServerLegendClass()[0].getSymbolImage().getImageURL();
//
//
////					.getMapServerLegendClass()[0].getSymbolImage().getImageURL();
////				image = baseUrl + image.replaceFirst(".*/", "");
////				res.put(id, image);
//            }
//        } catch (ConnectionException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//        return res;
//    }

