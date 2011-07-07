package ru.mos.gispro.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MapServiceInfoAsync
{
	void loadTreatments          (                                          AsyncCallback<String> callback) throws IllegalArgumentException;
	void loadTreatmentDesc       (int    id                               , AsyncCallback<String> callback) throws IllegalArgumentException;
	void loadTreatmentCategories (                                          AsyncCallback<String> callback) throws IllegalArgumentException;
	void saveTreatment           (String email, String lon,
                                  String lat  , String category,
                                  String text                             , AsyncCallback<String> callback) throws IllegalArgumentException;
	void joinTreatment           (int id, int count  , String email       , AsyncCallback<String> callback) throws IllegalArgumentException;
    void userConnect             (String login       , String password    , AsyncCallback<String> callback) throws IllegalArgumentException;
    void loadOrganizations       (                                          AsyncCallback<String> callback) throws IllegalArgumentException;
    void loadDepartments         (                                          AsyncCallback<String> callback) throws IllegalArgumentException;
    void registration            (String sname       , String name        ,
    	                          String pname       , String login       ,
    	                          String password    , String organization,
    	                          String department  , String position    , AsyncCallback<String> callback) throws IllegalArgumentException;
    void loadPeople              (String id                               , AsyncCallback<String> callback) throws IllegalArgumentException;
    void loadFileContent         (String path                             , AsyncCallback<String> callback) throws IllegalArgumentException;
}
