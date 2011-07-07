package ru.mos.gispro.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("MapServiceInfo")
public interface MapServiceInfo extends RemoteService
{
    String loadTreatments          (                                      ) throws IllegalArgumentException;
    String loadTreatmentDesc       (int    id                             ) throws IllegalArgumentException;
    String loadTreatmentCategories (                                      ) throws IllegalArgumentException;
    String saveTreatment           (String email, String lon,
    		                        String lat  , String category,
    		                        String text                           ) throws IllegalArgumentException;
    String joinTreatment           (int id, int count  , String email     ) throws IllegalArgumentException;
    String userConnect             (String login       , String password  ) throws IllegalArgumentException;
    String loadOrganizations       (                                      ) throws IllegalArgumentException;
    String loadDepartments         (                                      ) throws IllegalArgumentException;
    String registration            (String sname       , String name        ,
    		                        String pname       , String login       ,
    		                        String password    , String organization,
    		                        String department  , String position  ) throws IllegalArgumentException;
    String loadPeople       	   (String id                             ) throws IllegalArgumentException;
    String loadFileContent  	   (String path                           ) throws IllegalArgumentException;
}
