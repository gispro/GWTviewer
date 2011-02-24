package ru.mos.gispro.tveravtodor.shared;

public class User 
{
	private   int      id   ;
	private   String   sname;
	private   String   name ;
	private   String   pname;
	private   String   login;
	private   int      organizationID;
	private   int      departmentID  ;
	private   int      positionID    ;
	private   String   status        ;
	private   String   active        ;
	
	public User (int id, String sname, String name, String pname, String login, String status, String active,
			     int organizationID, int departmentID, int positionID)
	{
		this.id             = id  ;
		this.sname          = sname;
		this.name           =  name;
		this.pname          = pname;
		this.login          = login;
		this.status         = status;
		this.active         = active;
		this.organizationID = organizationID;
		this.departmentID   = departmentID;
		this.positionID     = positionID;
	}
	public int getId()
	{
		return this.id;
	}
	public String getSname()
	{
		return this.sname;
	}
	public String getName()
	{
		return this.name;
	}
	public String getPname()
	{
		return this.pname;
	}
	public String getLogin()
	{
		return this.login;
	}
	public int getOrganizationID()
	{
		return this.organizationID;
	}
	public int getDepartmentID()
	{
		return this.departmentID;
	}
	public int getPositionID()
	{
		return this.positionID;
	}
	public String getStatus()
	{
		return this.status;
	}
	public String getActive()
	{
		return this.active;
	}
	public boolean isActive()
	{
		return (this.active.equals("1"));
	}
}
