package ru.mos.gispro.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
// import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import ru.mos.gispro.client.MapServiceInfo;
import ru.mos.gispro.shared.References;
import ru.mos.gispro.shared.Treatment;
import ru.mos.gispro.shared.User;

// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class MapServiceInfoImpl extends RemoteServiceServlet implements MapServiceInfo
{
	private           static   String   treatments               = null;
	private           static   String   treatmentsCategories     = null;
	
    public    final   static   String   JSON_ORGANIZATIONS_TITLE = "organizations";
    public    final   static   String   JSON_DEPARTMENTS_TITLE   = "departments"  ;
    public    final   static   String   JSON_CATEGORIES_TITLE    = "categories"   ;
    public    final   static   String   JSON_TREATMENTS_TITLE    = "treatments"   ;

    private   final   static   String   JSON_ORGANIZATIONS_STUB  = "{\"organisations\" : []}";
    private   final   static   String   JSON_DEPARTMENTS_STUB    = "{\"departments\" : []}";
    private   final   static   String   JSON_CATEGORIES_STUB     = "{\"categories\" : [{\"id\":1,\"name\":\"ЖКХ\"},{\"id\":2,\"name\":\"МВД\"},{\"id\":3,\"name\":\"Прочее\"}]}";
    private   final   static   String   JSON_TREATMENTS_STUB     = "{\"treatments\" : []}";

    private   final   static   String   JSON_TREATMENTS_TEMPL    = "{\"treatments\" : [<0>]}";

    private   final            String   TREATMENT_TEMPL          = "{\"id\":<0>,\"lon\":<1>,\"lat\":<2>,\"count\":<3>}";

    private   final            String   TREATMENT_1              = "{\"id\":1,\"lon\":4066120.2609918,\"lat\":7595886.4741164,\"count\":1}";
    private   final            String   TREATMENT_2              = "{\"id\":2,\"lon\":4012308.5930887,\"lat\":7581210.5646883,\"count\":3}";
    private   final            String   TREATMENT_3              = "{\"id\":3,\"lon\":3982956.7742324,\"lat\":7482148.1760484,\"count\":4}";
    private   final            String   TREATMENT_4              = "{\"id\":4,\"lon\":3941986.5270789,\"lat\":7542686.3024395,\"count\":5}";
//    private   final            String   TREATMENT_5              = "{\"id\":5,\"lon\":3976230.3157445,\"lat\":7611173.8797707,\"count\":6}";
//    private   final            String   TREATMENT_6              = "{\"id\":6,\"lon\":4041660.4119449,\"lat\":7424056.0345621,\"count\":9}";
    
    private   final            String   TREATMENT_DESC_STUB      = "{\"category\":\" \",\"reported\":\" \",\"content\":\" \"}";
    private   final            String   TREATMENT_DESC_1         = "{\"category\":\"Жилищно-коммунальное хозяйство1123 4567 890 qwerty uioasdfgh\",\"reported\":\"01.06.2011 23:22:11\",\"email\":\"first@first.ru\",\"content\":\"№1 Жалоба цйу йцу йцук ыва ячсмя ч муфык ыцуцыук фыв аяы Я ЫВ ячся чсфыувцыа ячсмячсячсмапр аер кервапчсмяч смч с мчсм чсмчсмчсмвкпукепукпчачс м \"}";
    private   final            String   TREATMENT_DESC_2         = "{\"category\":\"Жилищно-коммунальное хозяйство2\",\"reported\":\"03.06.2011 13:31:23\",\"email\":\"second@second.ru\",\"content\":\"№2 Замечание ясм ячсмыва у кпыкуеп ч сммсиьтсрьт кеарыепфывап ячаисмиьрьт вер ывепр вкп ваичсмичс итчвап ыуеп ыепр смтьопьа лшрщшщнденоыкер ыкер\"}";
    private   final            String   TREATMENT_DESC_3         = "{\"category\":\"Жилищно-коммунальное хозяйство3\",\"reported\":\"05.06.2011 15:45:34\",\"email\":\"third@third.ru\",\"content\":\"№3 Течь водопровода фуцкывап выап вапго прчспи чсмисьрлбшдюегшл енго цыен цуе йукекеркен окгл впртмиоь мрол гешлкегцкер фичсмитсрьнго укего ыккервег\"}";
    private   final            String   TREATMENT_DESC_4         = "{\"category\":\"Жилищно-коммунальное хозяйство4\",\"reported\":\"15.06.2011 12:25:45\",\"email\":\"fourth@fourth.ru\",\"content\":\"№4 Домофон входной двери  ФЫВ ФА ЫВФАП В ЧМыфв аывап ывап ывп вкепр еоабьтьолеврыкер ыукефвкпчсаптчапр вапр вапт ап ви ваи ыва выа выаа ыв ывр ыв ыва\"}";
    private   final            String   TREATMENT_DESC_5         = "{\"category\":\"Жилищно-коммунальное хозяйство5\",\"reported\":\"17.06.2011 08:33:56\",\"email\":\"fifth@fifth.ru\",\"content\":\"№5 Освещение лестничной площадки фыу афуа чваи чсми чспр ыукен ук ывпсями ви аено еу окерцер кер кер ук ваич см чмитчмит амппт мспит кер куер  кер кер к\"}";
    private   final            String   TREATMENT_DESC_6         = "{\"category\":\"Жилищно-коммунальное хозяйство6\",\"reported\":\"18.06.2011 10:52:52\",\"email\":\"sixth@sixth.ru\",\"content\":\"№6 Уборка территории фы ва фцуа фыуа фыва ыва фыва я чсмчсм ичаспи уе пукыепываи чсми чсми чспи чспи чсмип цуепнункрокуер ывер ваи ячсм чсми чси 4енкеп ывкеп\"}";
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private HttpSession getHttpSession ()
    {
        HttpServletRequest request = this.getThreadLocalRequest();
        return request.getSession();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String saveTreatment (String email, String lon, String lat, String category, String text)
                                                                              throws IllegalArgumentException
    {
		String result = "OK";
    	if (Global.onIDE)
    	{
			result += "/" + String.valueOf(987654);
    	}
    	else
    	{
    		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    		String dt = sdf.format(new Date());
//    	System.out.println ("saveTreatment : email = " + email + ", lon = " + lon + ", lat = " + lat +
//				                                     ", category = " + category + ", date = " + dt + "\n" + text);
    		DataModule dm  = new DataModule();

    		dm.Connect(Global.LOGIN, Global.PASSWORD);
    		int rc = -1;
    		if (dm.getConnection () != null)
    		{
    			rc = dm.insertTreatment (dm.getConnection (), lon, lat, category, dt, email, text);
    			dm.Disconnect();
//	    	System.out.println ("saveTreatment : rc = " + rc);
    		}
    		if (rc == -1)
    			result = "FAILED";
    		else
    		{
    			result += "/" + String.valueOf(rc);
    			refreshTreatments();
    		}
    	}
		return result;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String joinTreatment (int id, int count, String email) throws IllegalArgumentException
    {
		String result = "OK";

//		System.out.println ("0. MapServiceInfoImpl.joinTreatment : id = " + id + ", count = " + count + ", email = " + email);

		if (Global.onIDE)
    	{
			result += "/" + String.valueOf(987654);
    	}
    	else
    	{
//    		System.out.println ("1. MapServiceInfoImpl.joinTreatment");
    		DataModule dm  = new DataModule();

    		dm.Connect(Global.LOGIN, Global.PASSWORD);
    		int rc = -1;
    		if (dm.getConnection () != null)
    		{
    			rc = dm.joinTreatment (dm.getConnection (), id, count, email);
    			dm.Disconnect();
//	    	System.out.println ("2. MapServiceInfoImpl.joinTreatment : rc = " + rc);
    		}
    		if (rc == -1)
    			result = "FAILED";
    	}
		return result;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String loadTreatmentCategories() throws IllegalArgumentException
    {
    	if (treatmentsCategories == null)
    	{
	    	if (Global.onIDE)
    			treatmentsCategories = JSON_CATEGORIES_STUB; 
    		else
    		{
    			String content = null;
    			DataModule dm  = new DataModule();

    			dm.Connect(Global.LOGIN, Global.PASSWORD);
    			if ((dm.getConnection () != null) || Global.onIDE)
    			{
    				List<References> refs = DataModule.loadTreatmentCategories (dm.getConnection());
    				if (refs != null)
    					content = Global.convertListToStringJSON(refs, JSON_CATEGORIES_TITLE);
    				dm.Disconnect();
    			}
    			if (content == null)
    				content = JSON_CATEGORIES_STUB;
    			treatmentsCategories = content; 
    		}
    	}
   		return treatmentsCategories;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void refreshTreatments()
    {
    	treatments = null;
        DataModule dm  = new DataModule();
        dm.Connect(Global.LOGIN, Global.PASSWORD);
        if (dm.getConnection () != null)
        {
            List<Treatment> refs = DataModule.loadTreatments (dm.getConnection());
            dm.Disconnect();
            if (refs.size() > 0)
            {
    	        StringBuilder content = new StringBuilder();
            	for (int i = 0; i < refs.size(); i++)
            	{
	            	if (i > 0)
	            		content.append(",");
	            	Treatment treatment = refs.get(i);
	            	String tmp = TREATMENT_TEMPL.replace("<0>", String.valueOf(treatment.getId   ()));
	            	tmp        = tmp            .replace("<1>", String.valueOf(treatment.getLon  ()));
	            	tmp        = tmp            .replace("<2>", String.valueOf(treatment.getLat  ()));
	            	tmp        = tmp            .replace("<3>", String.valueOf(treatment.getCount()));
	            	content.append(tmp);
            	}
            	treatments = JSON_TREATMENTS_TEMPL.replace("<0>", content.toString());
            }
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String loadTreatments()
    {
    	if (treatments == null)
    	{
    		if (Global.onIDE)
    		{	
    			treatments = TREATMENT_1 + "," + TREATMENT_2 + "," + TREATMENT_3 + "," + 
    		                 TREATMENT_4;
    			treatments = JSON_TREATMENTS_TEMPL.replace("<0>", treatments);
    		} else
    		{
    	        DataModule dm  = new DataModule();
    	        dm.Connect(Global.LOGIN, Global.PASSWORD);
    	        if (dm.getConnection () != null)
    	        {
    	            List<Treatment> refs = DataModule.loadTreatments (dm.getConnection());
    	            dm.Disconnect();
    	            if (refs.size() > 0)
    	            {
    	    	        StringBuilder content = new StringBuilder();
    	            	for (int i = 0; i < refs.size(); i++)
    	            	{
        	            	if (i > 0)
        	            		content.append(",");
        	            	Treatment treatment = refs.get(i);
        	            	String tmp = TREATMENT_TEMPL.replace("<0>", String.valueOf(treatment.getId   ()));
        	            	tmp        = tmp            .replace("<1>", String.valueOf(treatment.getLon  ()));
        	            	tmp        = tmp            .replace("<2>", String.valueOf(treatment.getLat  ()));
        	            	tmp        = tmp            .replace("<3>", String.valueOf(treatment.getCount()));
        	            	content.append(tmp);
    	            	}
    	            	treatments = JSON_TREATMENTS_TEMPL.replace("<0>", content.toString());
    	            }
    	        }
    		}
    	}
    	if ((treatments != null) && (treatments.length() > 0))
    		return treatments;
    	else
    		return JSON_TREATMENTS_STUB;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String loadTreatmentDesc(int id)
    {
    	String desc = TREATMENT_DESC_STUB;
//		System.out.println ("0. MapServiceInfoImpl.loadTreatmentDesc : id = " + id);
		if (Global.onIDE)
		{	
	    	switch (id)
	    	{
	    		case 1: desc = TREATMENT_DESC_1; break;
	    		case 2: desc = TREATMENT_DESC_2; break;
	    		case 3: desc = TREATMENT_DESC_3; break;
	    		case 4: desc = TREATMENT_DESC_4; break;
	    		case 5: desc = TREATMENT_DESC_5; break;
	    		case 6: desc = TREATMENT_DESC_6; break;
	    	}
		} else
		{
	        DataModule dm = new DataModule();
	        dm.Connect(Global.LOGIN, Global.PASSWORD);
	        if (dm.getConnection () != null)
	        {
	        	desc = DataModule.loadTreatmentDesc (dm.getConnection(), id);
//				System.out.println ("1. MapServiceInfoImpl.loadTreatmentDesc : id = " + id + ", desc = " + desc);
	            dm.Disconnect();
	        }
		}
   		return desc;
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
    public String loadPeople (String id) throws IllegalArgumentException
    {
        String  content = null; // "1234567890"; // null;
//        Global.writeLog (Global.LOG_SECTION_SERVLET + "0. loadPeople : content - " + content);
        ContractorsDM dm = new ContractorsDM();

        dm.Connect();
        if (dm.getConnection () != null)
        {
            content = dm.loadContractors(id);
        }
        dm.Disconnect();
        return content;
    }
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String loadFileContent(String fname) throws IllegalArgumentException
    {
        String content = "";
		String fpath = getServletContext().getRealPath("/") + File.separatorChar + fname;
		File file = new File(fpath);
        if (file.exists())
            content = LoadFileContent(fpath);
        return content;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private static String LoadFileContent(String path)
	{
        int              size;
        byte             buffer[];
        String           content = null;
		FileInputStream  fis = null;
//		System.out.println (path);
		try
		{
			fis = new FileInputStream(path);
			try
			{
				size   = fis.available();
				buffer = new byte[size];
				int  bytes = fis.read(buffer, 0, size);
				content = new String (buffer, 0, bytes);
				fis.close();
			} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {	e.printStackTrace(); }
		return content;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public static void main(String[] args)
    {
//        String addr = "http://rest.ecto.advantum.ru/arcgis/services/Agriculture/MapServer?wsdl";
//        String addr = "http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo100_tver/MapServer";
//        String addr = "http://maps.gispro.ru/ArcGIS/rest/services/TVER/topo100_tver/MapServer";
//        String addr = "http://maps.gispro.ru/ArcGIS/rest/services/ESIMO/P0001/MapServer";

//        String addr = "http://maps.gispro.ru/ArcGIS/services/TVER/routes_tver_region_29112010/MapServer/";
//        MapServiceInfoImpl m = new MapServiceInfoImpl();
//        m.legendsTrue(addr);
		
//		MapServiceInfoImpl msi = new MapServiceInfoImpl();
//      System.out.println ("MapServiceInfoImpl :");
//      System.out.println ("" + msi.loadTreatmentCategories());
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
