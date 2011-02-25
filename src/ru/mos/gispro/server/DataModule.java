package ru.mos.gispro.server;

/**
 * Модуль работы с Базой Данных
 * @author ekoklin
 */

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import ru.mos.gispro.shared.References;
import ru.mos.gispro.shared.User;

public class DataModule
{
	//~~~~~~~~~~~~~~~~~
    private static final    String            PROP_FILE                = "ru/mos/gispro/server/ServletImpl.properties";
    private static          Properties        PROPERTIES               = new Properties();

	private	static          String            url                      = null ;
	private                 Connection        connection               = null;
	
	public  static  final   String            STATUS_USER              = "user"      ;
	public  static  final   String            STATUS_SUPERUSER         = "superuser" ;

	public  static  final   String            SQL_SELECT_COUNT         = "select count(*) from ";
	public  static  final   String            SQL_SELECT_MAX_ID        = "select max(id) from ";

	public  static  final   String            STR_BRACKED_ZERO         = "<0>";
	public  static          String            TABLE_USERS              = "public.users";
	public  static          String            TABLE_ORGANIZATIONS      = "public.organizations";
	public  static          String            TABLE_DEPARTMENTS        = "public.departments";
	
	public  static  final   String            SQL_SELECT_REFERENCESS   = "select id, name from <0> where active = '1'";

	public  static  final   String            SQL_LOGIN_DOUBLED_HASH = "select COUNT(*) from <0> " +
			                                                              "where login = '<1>' and hash = '<2>'";
	public  static  final   String            SQL_LOGIN_DOUBLED_PASS = "select COUNT(*) from <0> " +
                                                                          "where login = '<1>' and hash = '<2>'";

	public  static  final   String            SQL_SELECT_USER_ON_PASS  = "select id, firstname, middlename, lastname, "      +
			                                                                  "status, active, organizationID, "             +
			                                                                  "departmentID, positionID "                    +
			                                                                "from <0> "                                      +
			                                                            "where login = ? and password = ?"                   ;
	public  static  final   String            SQL_SELECT_USER_ON_HASH  = "select id, firstname, middlename, lastname, "      +
			                                                                  "status, active, organizationID, "             +
			                                                                  " departmentID, positionID "                   +
			                                                                "from <0> "                                      +
			                                                            "where login = ? and hash = ?"                       ;
	public  static  final   String            SQL_USER_INSERT          = "insert into <0> "                                  +
			                                                              "(id, firstname, middlename, lastname, "           +
			                                                              "organizationID, departmentID, positionID, "       +
			                                                              "login, password, hash, status, active) "          +
			                                                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'guest', '1')";
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
    		Global.HOST          = PROPERTIES.getProperty("host"         );
    		Global.DATABASE      = PROPERTIES.getProperty("database"     );
    		Global.LOGIN         = PROPERTIES.getProperty("login"        );
    		Global.PASSWORD      = PROPERTIES.getProperty("password"     );
    		Global.PORT          = PROPERTIES.getProperty("port"         );
    		Global.CONFIG_FILE   = PROPERTIES.getProperty("config"       );
    		String ide           = PROPERTIES.getProperty("ide"          );
    		String onHash        = PROPERTIES.getProperty("hashPassword" );
    		Global.PATH          = PROPERTIES.getProperty("path"         );    		
    		TABLE_USERS          = PROPERTIES.getProperty("users"        );
    		TABLE_ORGANIZATIONS  = PROPERTIES.getProperty("organizations");
    		TABLE_DEPARTMENTS    = PROPERTIES.getProperty("departments"  );
    		String log           = PROPERTIES.getProperty("logDB"        );
    		
    		Global.logDB         = ((log    != null) && (log   .equalsIgnoreCase("TRUE")));
    		Global.onIDE         = ((ide    != null) && (ide   .equalsIgnoreCase("TRUE")));
    		Global.onHash        = ((onHash != null) && (onHash.equalsIgnoreCase("TRUE")));

    		if (Global.logDB)
    		{
    			Global.writeLog ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    			Global.writeLog (Global.LOG_SECTION_DATAMODULE + "static - load Properties : LOGIN = " + Global.LOGIN + ", PASSWORD = " + Global.PASSWORD);
    		}
    	} catch (IOException e) {
    		try {
    			throw new Exception("Cannot load properties file '" + PROP_FILE + "'.", e);
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
    	}
    }
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public DataModule(){};
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
			if (Global.DATABASE.length() > 0)
		        url = "jdbc:postgresql://" + Global.HOST + ":" + Global.PORT + "/" + Global.DATABASE;
			else
				url = "jdbc:sqlserver://" + Global.HOST + ":" + Global.PORT;
		}
		return url;
	};
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Процедура подключения к серверу БД
	 */
	public void Connect (String login, String pw)
	{
		if (Global.onIDE)
			return;
		try {
			try {
				// Регистрация драйвера JDBC
				Class.forName("org.postgresql.Driver").newInstance();
				Properties conProps = new Properties();
				conProps.setProperty("password"         , pw      );
				conProps.setProperty("user"             , login   );
				conProps.setProperty("useUnicode"       , "true"  );
				conProps.setProperty("characterEncoding", "utf8"  );
				connection = (Connection) DriverManager.getConnection(getURL (), conProps);
			} catch (SQLException e)
			{
				connection = null;
				System.err.println("ErrorCode : " + e.getErrorCode());
				e.printStackTrace();
			}
		} catch (Exception e)
		{
			connection = null;
			e.printStackTrace();
		}
	};
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Процедура подключения к серверу БД
	 */
	public void Connect ()
	{
		try {
			try {
				Properties conProps = new Properties();
				conProps.setProperty("password"         , Global.PASSWORD);
				conProps.setProperty("user"             , Global.LOGIN   );
				conProps.setProperty("useUnicode"       , "true"         );
				conProps.setProperty("characterEncoding", "utf8"         );
//			System.err.println("0. DataModule.Connect : " + conProps.toString() + ", url = " + getURL());
				Global.writeLog (Global.LOG_SECTION_DATAMODULE + "1. Connect : getURL () = " + getURL ());
				connection = (Connection) DriverManager.getConnection(getURL (), conProps);
				Global.writeLog (Global.LOG_SECTION_DATAMODULE + "1. Connect : connection = " + connection);
//			System.err.println("1. DataModule.Connect");
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
	public static int getValue (Connection connection, String sql, String table)
	{
		int result = -1;
		if (connection != null)
		{
			Statement st = null;
			ResultSet rs = null;
			String csql = sql + table;
			try
			{
				st = connection.createStatement();
				rs = st.executeQuery(csql);
				while (rs.next())
				{
					result = rs.getInt(1);
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public int insertUser (String table, int id, String lastname, String firstname, String middlename, 
			               String login, String password, int organizationID, int departmentID,
			               int positionID, String hash)
	{
		int result = -1;
		Connection connection = getConnection();
        Global.writeLog (Global.LOG_SECTION_DATAMODULE + "0. insertUser : connection " + connection);
		if (connection != null)
		{
			PreparedStatement st = null;
			// ResultSet rs = null;
			String sql = SQL_USER_INSERT.replace(STR_BRACKED_ZERO, table);
            Global.writeLog (Global.LOG_SECTION_DATAMODULE + "1. insertUser : sql " + sql);
			try
			{
				st = connection.prepareStatement(sql);
				st.setInt    ( 1, id            );
				st.setString ( 2, firstname     );
				st.setString ( 3, middlename    );
				st.setString ( 4, lastname      );
				st.setInt    ( 5, organizationID);
				st.setInt    ( 6, departmentID  );
				st.setInt    ( 7, positionID    );
				st.setString ( 8, login         );
				st.setString ( 9, password      );
				st.setString (10, hash          );
				result = st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        Global.writeLog (Global.LOG_SECTION_DATAMODULE + "2. insertUser : result " + result);
		return result;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static List<References> loadReferences (Connection connect, String table)
	{
		List<References> result = new ArrayList<References>();
		if (!Global.onIDE || (connect != null))
		{
			Statement st = null;
			ResultSet rs = null;
			try
			{
				String sql = SQL_SELECT_REFERENCESS.replaceFirst(STR_BRACKED_ZERO, table);
				st = connect.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next())
				{
					References ref = new References (rs.getInt(1), rs.getString(2));
					result.add(ref);
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
			Global.writeLog (Global.LOG_SECTION_DATAMODULE + "loadReferences : table = " + table + ", size = " + result.size());
		}
		return result;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public String getUser (String login, String password)
	{
		String result = null;
		if (Global.onIDE)
		{
			if ((login != null) && (login.length() > 0))
			{
				if (login.equalsIgnoreCase("qwerty"))
					result = login + '/' + STATUS_USER;
				else if (login.equalsIgnoreCase("asdfgh"))
					result = login + '/' + STATUS_SUPERUSER;
			}
		}
		return result;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public User getUser (String login, String password, boolean onHash )
	{
		User result = null;

		if (TABLE_USERS == null)
			return null;
		Connection connect = getConnection();
		if (connect != null)
		{
			PreparedStatement st = null;
			ResultSet         rs = null;
			try
			{
				String sql = null;
				if (onHash)
					sql = SQL_SELECT_USER_ON_HASH.replaceFirst(STR_BRACKED_ZERO, TABLE_USERS);
				else
					sql = SQL_SELECT_USER_ON_PASS.replaceFirst(STR_BRACKED_ZERO, TABLE_USERS);
				Global.writeLog (Global.LOG_SECTION_DATAMODULE + "0. getUser : " + sql + ", login " + login + ", password = " + password + ", onHash = " + onHash);
				st = connect.prepareStatement(sql);
				st.setString ( 1, login          );
				st.setString ( 2, password       );
				rs = st.executeQuery();
				while (rs.next())
				{
					int    id             = rs.getInt   ( 1);
					String name           = rs.getString( 2);
					String pname          = rs.getString( 3);
					String sname          = rs.getString( 4);
					String status         = rs.getString( 5);
					String active         = rs.getString( 6);
					int    organizationID = rs.getInt   ( 7);
					int    departmentID   = rs.getInt   ( 8);
					int    positionID     = rs.getInt   ( 9);
					
					result = new User(id, sname, name, pname, login, status, active,
						               organizationID, departmentID, positionID);
					break;
				}
				if (result != null)
					Global.writeLog (Global.LOG_SECTION_DATAMODULE + "1. getUser : user.isActive() = " + result.isActive());
				else
					Global.writeLog (Global.LOG_SECTION_DATAMODULE + "1. getUser : user not found");
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
		return result;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public boolean isNewUserDoubled (String login, String password, boolean onHash)
	{
		String sql;
		if (onHash)
			sql = SQL_LOGIN_DOUBLED_HASH.replaceFirst(STR_BRACKED_ZERO, TABLE_USERS);
		else
			sql = SQL_LOGIN_DOUBLED_PASS.replaceFirst(STR_BRACKED_ZERO, TABLE_USERS);
		
		sql = sql.replaceFirst("<1>", login);
		sql = sql.replaceFirst("<2>", password);
		
		int count = -1;
		
		Global.writeLog (Global.LOG_SECTION_DATAMODULE + "isNewUserDoubled : sql = " + sql);

		Connection connect = getConnection();
		if (connect != null)
		{
			Statement st = null;
			ResultSet rs = null;
			try
			{
				st = connection.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next())
				{
					count = rs.getInt(1);
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		if (count > 0)
			Global.writeLog (Global.LOG_SECTION_DATAMODULE + "check doubled record : login & password invalid");
		else
			Global.writeLog (Global.LOG_SECTION_DATAMODULE + "check doubled record : login & password valid");
		return (count > 0);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
