package ru.mos.gispro.client;

import ru.mos.gispro.shared.Treatment;

public interface IBaseMap
{
    public void      setBaseMap         (String baseMapName   );
    public void      closeBaseMapWindow (                     );
    public void      removeBaseMap      (                     );
    public boolean   isIdentifySelected (                     );
    public Treatment isTreatmentChoosed (String cursorLocation);
    public void      setTreatmentDesc   (Treatment treatment, String jsonDesc);
    public void      joinTreatment      (Treatment treatment, int id, String email); 
    public void      saveTreatment      (String    email    , String lon, 
    		                             String    lat      , String category, String text);
}
