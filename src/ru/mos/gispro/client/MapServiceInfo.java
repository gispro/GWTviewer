package ru.mos.gispro.client;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.mos.gispro.client.LegendInfo;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("MapServiceInfo")
public interface MapServiceInfo extends RemoteService
{
	Map<String, String> Legends(String name) throws IllegalArgumentException;
	public Map<String, List<LegendInfo>> legendsTrue(String input) throws IllegalArgumentException;

    String userConnect      (String login     , String password    ) throws IllegalArgumentException;
    String loadOrganizations(                                      ) throws IllegalArgumentException;
    String loadDepartments  (                                      ) throws IllegalArgumentException;
    String registration     (String sname     , String name        ,
                             String pname     , String login       ,
                             String password  , String organization,
                             String department, String position    ) throws IllegalArgumentException;
    String loadPeople       (String id                             ) throws IllegalArgumentException;
}
