package ru.mos.gispro.tveravtodor.client;

public class References 
{
	private   int      id  ;
	private   String   name;
	
	public References(int id, String name)
	{
		this.id   = id  ;
		this.name = name;
	}
	public int getId()
	{
		return this.id;
	}
	public String getName()
	{
		return this.name;
	}
}
