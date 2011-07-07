package ru.mos.gispro.shared;

public class Treatment 
{
	private   int      id      ;
	private   int      count   ;
	private   double   lon     ;
	private   double   lat     ;
	private   String   category = null;
	private   String   reported = null;
	private   String   content  = null;
	private   String   email    = null;
	
	private  final  int  CONTENT_SIZE_MAX  = 80;
	private  final  int  CATEGORY_SIZE_MAX = 40;
	
	public Treatment(int id, int count, double lon, double lat)
	{
		this.id       = id      ;
		this.count    = count   ;
		this.lon      = lon     ;
		this.lat      = lat     ;
	}
	public Treatment(int id, String category, int count, double lon, double lat, String reported)
	{
		this.id       = id      ;
		this.category = category;
		this.count    = count   ;
		this.lon      = lon     ;
		this.lat      = lat     ;
		this.reported = reported;
	}
	public int getId()
	{
		return this.id;
	}
	public String getCategory()
	{
		return this.category;
	}
	public String getShortCategory()
	{
		if (category.trim().length() < CATEGORY_SIZE_MAX)
			return this.category;
		else
		{
			String txt = this.category.substring(0, CATEGORY_SIZE_MAX - 1);
			for (int i = txt.length() - 1; i > 0; i--)
			{
				if (txt.charAt(i) == ' ')
				{
					txt = txt.substring(0, i + 1) + "...";
					break;
				}
			}
			return txt;
//			return this.category.substring(0, CATEGORY_SIZE_MAX - 1) + " ...";
		}
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public int getCount()
	{
		return this.count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public double getLon()
	{
		return this.lon;
	}
	public double getLat()
	{
		return this.lat;
	}
	public String getReported()
	{
		return this.reported;
	}
	public void setReported(String reported)
	{
		this.reported = reported;
	}
	public String getContent()
	{
		return this.content;
	}
	public String getShortContent()
	{
		if (content.trim().length() < CONTENT_SIZE_MAX)
			return this.content;
		else
		{
			String txt = this.content.substring(0, CONTENT_SIZE_MAX - 1);
			txt = txt.replace("<br>", " ");
			for (int i = txt.length() - 1; i > 0; i--)
			{
				if (txt.charAt(i) == ' ')
				{
					txt = txt.substring(0, i + 1) + "...";
					break;
				}
			}
			return txt;
		}
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
}
