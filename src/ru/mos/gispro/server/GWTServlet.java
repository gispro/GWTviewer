package ru.mos.gispro.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import java.io.InputStream;
// import org.apache.commons.io.IOUtils;

import ru.mos.gispro.client.GWTViewer;

@SuppressWarnings("serial")
public class GWTServlet extends HttpServlet
{
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		File   baseDir = new File(this.getServletContext().getRealPath("/"));
		String path    = baseDir.getAbsolutePath() + File.separatorChar + "Project.js";
		
        String dsc = loadFileContent (path);
//		System.out.println ("doGet : path = " + path);
//		System.out.println ("doGet : dsc\n" + dsc);
//        if (dsc.length() > 0)
       	dsc = getFileConfigName (dsc);
        
		response.setContentType ("text/html;charset=UTF-8");
		
        PrintWriter out = response.getWriter();
        
        StringBuilder content = new StringBuilder();
        content.append("<h3>Приложение GWTViewer</h3>Версия : " + GWTViewer.APP_VERSION);
        content.append("<p></p><strong>Файл конфигурации &lt;" + dsc + "&gt;</strong><br>");
        
        path = baseDir.getAbsolutePath() + File.separatorChar + dsc;
        dsc = loadFileContent (path);
        if (dsc.length() > 0)
        {
        	dsc = dsc.replace("\n", "<br>"  );
        	dsc = dsc.replace(" " , "&nbsp;");
        	dsc = dsc.replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
        }
        content.append(dsc);

        out.println(content);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private String loadFileContent (String fpath)
	{
		String  content = "File <" + fpath + "> not found";
//    	try {
   		File f = new File (fpath);
//    		System.out.println ("0. loadFileContent : " + f);
   		if (f.exists())
   		{
//    		System.out.println ("1. loadFileContent : FILE EXISTS - " + fpath);
/*    			
    			InputStream is = new FileInputStream (fpath);
    			content = IOUtils.toString( is );
*/    			
   			String str = "";
   		    try {
    				      
    			FileInputStream   fis = new FileInputStream(fpath);
    			InputStreamReader isr = new InputStreamReader(fis,"UTF8");
    			BufferedReader    in  = new BufferedReader(isr);
   		        while ((str = in.readLine()) != null)
    		        	content += "\n" + str;
   		        in .close();
   		        isr.close();
   		        fis.close();
   		    } catch (IOException e) {}
   		}
//		} catch (IOException e) {}
		return content;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private String getFileConfigName (String content)
	{
		String fname = null;
		int idx = content.indexOf("\"configFile\"");
		if (idx > 0)
		{
			idx += 13;
			int end = content.indexOf(",", idx);
			if (end == -1)
				end = content.indexOf("\n", idx);

			if (end > 0)
				fname = content.substring(idx, end);
				
			fname = fname.replace(':', ' ');
			fname = fname.replace('"', ' ');
			fname = fname.trim() + ".js";
		}
		return fname;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
