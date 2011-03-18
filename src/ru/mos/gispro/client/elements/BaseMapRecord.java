package ru.mos.gispro.client.elements;

import com.smartgwt.client.widgets.tile.TileRecord;

public class BaseMapRecord extends TileRecord
{
    public BaseMapRecord() { }

    public BaseMapRecord(String name, String picture)
    {
        this(name, picture, null);
    }

    public BaseMapRecord(String name, String picture, String title)
    {
        setName(name);
        setPicture(picture);
        setTitle(title);
    }
    public void setName(String name)
    {
        setAttribute("name", name);
    }
    public String getName()
    {
        return getAttribute("name");
    }
    public void setPicture(String picture)
    {
        setAttribute("picture", picture);
    }
    public String getPicture()
    {
        return getAttribute("picture");
    }
    public void setTitle(String title)
    {
        setAttribute("title", title);
    }
    public String geTitle()
    {
        return getAttribute("title");
    }
}
