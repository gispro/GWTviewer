package ru.mos.gispro.client;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.mos.gispro.client.LegendInfo;

public interface MapServiceInfoAsync
{

	void Legends(String name, AsyncCallback<Map<String, String>> callback);

	void legendsTrue(String input, AsyncCallback<Map<String, List<LegendInfo>>> async);

    void   userConnect      (String login       , String password    , AsyncCallback<String> callback) throws IllegalArgumentException;
    void   loadOrganizations(                                          AsyncCallback<String> callback) throws IllegalArgumentException;
    void   loadDepartments  (                                          AsyncCallback<String> callback) throws IllegalArgumentException;
    void   registration     (String sname       , String name        ,
                             String pname       , String login       ,
                             String password    , String organization,
                             String department  , String position    , AsyncCallback<String> callback) throws IllegalArgumentException;
}
