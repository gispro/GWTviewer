package ru.mos.gispro.server;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ContractorsDM 
{
    private static          String            HOST                     = "";
    private static          String            DATABASE                 = "";
    private static          String            PORT                     = "";
    private static          String            LOGIN                    = "";
    private static          String            PASSWORD                 = "";
	//~~~~~~~~~~~~~~~~~
    private static final    String            PROP_FILE                = "ru/mos/gispro/server/ServletImpl.properties";
    private static          Properties        PROPERTIES               = new Properties();

	private	static          String            url                      = null ;
	private                 Connection        connection               = null;

	public  static          String            TABLE_PEOPLES            = "sde.s_people";

	public  static  final   String            SQL_SELECT_PEOPLES       = "select job, name1, name2, name3, sot_tel, " +
                                                                         "dom_tel from <0> where id_organiz = ";
	//~~~~~~~~~~~~~~~~~~~ load static app properties ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    static {
    	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    	InputStream is = classLoader.getResourceAsStream(PROP_FILE);
    	if (is == null)
    	{
    		try {
    			throw new Exception ("Properties file '" + PROP_FILE + "' is missing");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	try {
    		PROPERTIES.load(is);
    		HOST          = PROPERTIES.getProperty("contractors.host"    );
    		DATABASE      = PROPERTIES.getProperty("contractors.database");
    		LOGIN         = PROPERTIES.getProperty("contractors.login"   );
    		PASSWORD      = PROPERTIES.getProperty("contractors.passowrd");
    		PORT          = PROPERTIES.getProperty("contractors.port"    );
    		TABLE_PEOPLES = PROPERTIES.getProperty("contractors.people"  );

    	} catch (IOException e) {
    		try {
    			throw new Exception("Cannot load properties file '" + PROP_FILE + "'.", e);
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
    	}
    }
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public ContractorsDM(){};
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public Connection getConnection ()
	{
		return connection;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void Disconnect ()
	{
		try {
			if (connection != null)
			{
				connection.close();
				connection = null;
			}
		} catch (SQLException e) {}
	};
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public String getURL (String host, String port, String database)
	{
		if (url == null)
		{
			if (database.length() > 0)
			    url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
			else
			    url = "jdbc:postgresql://" + host + ":" + port;
		}
		return url;
	};
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public String getURL ()
	{
		if (url == null)
		{
			if (DATABASE.length() > 0)
		        url = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;
			else
				url = "jdbc:sqlserver://" + HOST + ":" + PORT;
		}
		return url;
	};
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Процедура подключения к серверу БД
	 */
	public void Connect ()
	{
		try {
			try {
                Class.forName("org.postgresql.Driver").newInstance();
				Properties conProps = new Properties();
				conProps.setProperty("password"         , PASSWORD);
				conProps.setProperty("user"             , LOGIN   );
				conProps.setProperty("useUnicode"       , "true"  );
				conProps.setProperty("characterEncoding", "utf8"  );
				connection = (Connection) DriverManager.getConnection(getURL (), conProps);
			} catch (SQLException e)
			{
				connection = null;
				System.err.println("ErrorCode : " + e.getErrorCode());
				e.printStackTrace();
				// 0     - The Network Adapter could not establish the connection
				// 18456 - Login failed for user 'sysadm1'.
				// 4060  - Cannot open database "License" requested by the login. The login failed.
			}
		} catch (Exception e)
		{
			connection = null;
			e.printStackTrace();
		}
	};
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String loadContractors (String id)
    {
//        String result = "<wfs:FeatureCollection xsi:schemaLocation=\"http://maps.gispro.ru/arcgis/services/MAD/mad_structure/GeoDataServer/WFSServer http://maps.gispro.ru/arcgis/services/MAD/mad_structure/GeoDataServer/WFSServer?request=DescribeFeatureType%26version=1.1.0%26typename=s_people http://www.opengis.net/wfs http://schemas.opengis.net/wfs/1.1.0/wfs.xsd\">";
        String result = "<FeatureCollection>";

        Connection connect = getConnection();
        if (connect != null)
        {
            PreparedStatement st = null;
            ResultSet         rs = null;
            try
            {
                String sql = SQL_SELECT_PEOPLES.replaceFirst(DataModule.STR_BRACKED_ZERO, TABLE_PEOPLES);
                sql = sql + id;
                st = connect.prepareStatement(sql);
                rs = st.executeQuery();
                while (rs.next())
                {
//                    result += "<gml:featureMember><MAD_mad_structure:s_people><MAD_mad_structure:job>";
                    result += "<featureMember><MAD_mad_structure_s_people><MAD_mad_structure_job>";
                    result += rs.getString( 1) + "</MAD_mad_structure_job><MAD_mad_structure_name1>";
                    result += rs.getString( 2) + "</MAD_mad_structure_name1><MAD_mad_structure_name2>";
                    result += rs.getString( 3) + "</MAD_mad_structure_name2><MAD_mad_structure_name3>";
                    result += rs.getString( 4) + "</MAD_mad_structure_name3><MAD_mad_structure_sot_tel>";
                    result += rs.getString( 5) + "</MAD_mad_structure_sot_tel><MAD_mad_structure_dom_tel>";
                    result += rs.getString( 6) + "</MAD_mad_structure_dom_tel>";
                    result += "</MAD_mad_structure_s_people></featureMember>";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        result += "</wfs:FeatureCollection>";
        result += "</FeatureCollection>";
        return result;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
