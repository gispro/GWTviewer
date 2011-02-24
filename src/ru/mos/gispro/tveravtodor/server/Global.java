package ru.mos.gispro.tveravtodor.server;

import ru.mos.gispro.tveravtodor.shared.References;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

public class Global
{
	public  static          String               HOST                  = "";
	public  static          String               DATABASE              = "";
	public  static          String               LOGIN                 = "";
	public  static          String               PASSWORD              = "";
	public  static          String               PORT                  = "";
	public  static          String               PATH                  = "";

	public  static          boolean              onIDE                 = false;
	public  static          boolean              logDB                 = true;
    private static          String               TIME_FORMAT           = "HH:mm:ss";
    private static          SimpleDateFormat     sdf                   = new SimpleDateFormat(TIME_FORMAT);
	
	public  static          boolean              onHash                = true;
	
	public  static  final   String               ACTION_RESULT_SUCCESS = "success";
	public  static  final   String               ACTION_RESULT_EXCEPT  = "Exception :" ;
	public  static  final   String               ACTION_RESULT_FAILED  = "failed" ;

	public  static          String               CONFIG_FILE           = ""       ;
	public  static  final   String               SESSION_LOGIN         = "login"  ;
	public  static  final   String               MESSAGE_DIGEST_MD5    = "MD5"    ;
	
	public  static  final   String               LOG_SECTION_DATAMODULE = "DataModule\t"; 
	public  static  final   String               LOG_SECTION_SERVLET    = "Servlet   \t";
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void rememberSessionLogin (HttpSession session, String login)
	{
		if (session != null)
			session.setAttribute(SESSION_LOGIN, login);
    }
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void removeSessionLogin (HttpSession session)
	{
		if (session != null)
			session.removeAttribute(SESSION_LOGIN);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static String getSessionLogin (HttpSession session)
	{
		String result = "";
		if (session != null)
			result = (String) session.getAttribute(SESSION_LOGIN);
		return result;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static String convertListToStringJSON (List<References> list, String title)
	{
		StringBuilder result = new StringBuilder();
		
		result.append("{\"" + title + "\" : [");
		for (int i = 0; i < list.size(); i++)
		{
			References ref = list.get(i);
			result.append("\n\t{\n\t\t\"id\"\t: " + ref.getId() + ",\n");
			result.append("\t\t\"name\"\t: \"" + ref.getName() + "\"\n\t}");
			if (i < (list.size() - 1))
				result.append(',');
		}
		result.append("\n]}");
		return result.toString();
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static String getMessageDigest (String password)
	{
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance (MESSAGE_DIGEST_MD5);
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		} 

		if (md != null)
			md.update(password.getBytes());
		byte[] hash = md.digest();
		String d = "";
		for (int i = 0; i < hash.length; i++)
		{
			int v = hash[i] & 0xFF;
			if (v < 16) d += "0";
			d += Integer.toString(v, 16).toUpperCase();
		}
	    return d;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void writeLog (String message)
	{
		if (logDB)
			System.out.println (sdf.format(new Date()) + "\t" + message);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
