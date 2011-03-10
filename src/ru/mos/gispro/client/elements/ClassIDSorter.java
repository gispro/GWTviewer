package ru.mos.gispro.client.elements;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: ekoklin
 * Date: 09.03.11
 * Time: 14:57
 * To change this template use File | Settings | File Templates.
 */
public class ClassIDSorter
{
    private Vector<ClassIDItem> list  = new Vector<ClassIDItem> ();

    public ClassIDSorter (){}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public int getItemCount()
    {
        return list.size();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void destroy()
    {
        list.clear();
        this.destroy();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void addItem (int i, String class_id)
    {
        long id = Integer.valueOf(class_id);
//        com.google.gwt.user.client.Window.alert("0. ClassIDSorter : i = " + i + ", class_id = " + class_id + ", size = " + list.size());
        ClassIDItem item     = new ClassIDItem (i, id);
        boolean     is_added = false;
        if (list.size() == 0)
            list.add(item);
        else
        {
            for (int j = 0; j < list.size(); j++)
            {
                if (id < list.get(j).class_id)
                {
                    list.insertElementAt(item, j);
                    is_added = true;
                    break;
                }
            }
            if (!is_added)
                list.add(item);
        }
//        com.google.gwt.user.client.Window.alert("1. ClassIDSorter : i = " + i + ", class_id = " + class_id + ", size = " + list.size());
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public ClassIDItem getItem(int i)
    {
        return list.get(i);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
