package ru.mos.gispro.client.window;

import ru.mos.gispro.shared.Treatment;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;

public class HintTreatment extends Canvas
{
	public     int             OFFSET_LEFT =   0;
	public     int             OFFSET_TOP  =  40;
    public     static int      WIDTH       = 290;
    public     static int      HEIGTH      =  90;
    private    int             LEFT        =   0;
    private    int             TOP         =   0;
    public     static String   COLOR       = "#f0f0f0";
    private    static String   BODER_COLOR = "1px solid #6a6a6a";
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public HintTreatment ()
    {
        createUI();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private void createUI()
    {
        setOverflow(Overflow.HIDDEN);
        setBorder            (BODER_COLOR);
        setBackgroundColor   (COLOR);
        setCanDragReposition (false);
        setCanDragResize     (false);
        setSmoothFade        (false);
        setWidth (WIDTH );
        setHeight(HEIGTH);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setOffsetParams (int left, int top)
    {
        OFFSET_LEFT = left;
        OFFSET_TOP  = top ;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setText (Treatment treatment, int left, int top)
    {
        setLeft (left - OFFSET_LEFT - 4);
        setTop  (top  - OFFSET_TOP  - 3);
        String text = "<b>&nbsp;"   + treatment.getShortCategory()+ "</b><br>" + 
                                      "<font style=\"font-style:italic\">" +
        		"&nbsp;Размещено :" + treatment.getReported()     + "<br>" +
                "&nbsp;Email :"     + treatment.getEmail()        + 
                "&nbsp;<hr>"        + treatment.getShortContent() + "<br>" + "</font>";
        setContents(text);
        this.LEFT = left;
        this.TOP  = top ;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public boolean isPointInside (int x, int y)
    {
        return (this.isVisible() && (x >= LEFT) && (x <= (LEFT + WIDTH )) && (y >= TOP ) && (y <= (TOP + HEIGTH)));
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
