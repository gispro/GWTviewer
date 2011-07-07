package ru.mos.gispro.client.geometry;

import java.util.ArrayList;
import java.util.List;

import ru.mos.gispro.client.GWTViewer;
import ru.mos.gispro.shared.Treatment;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class TreatmentManager
{
	private    List<Treatment>  treatmentsList;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static native void displayTreatmentFeature(boolean show)
	/*-{
	        $wnd.treats.display(show);
	        if (!show)
				$wnd.setStyleOpacity(0.01);
	        else
				$wnd.setStyleOpacity(0.9);
	}-*/;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static native void drawTreatment(double x, double y, int count, String id)
	/*-{
		$wnd.drawTreatment(x, y, count, id);
	}-*/;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	var s = "Callback";
//  this.@ru.mos.gispro.client.geometry.TreatmentManager::alertFeature(Ljava/lang/String;)(s);
	
//    tmpcallback = function(j)
//    {
//    	this.@ru.mos.gispro.client.geometry.TreatmentManager::alertFeature(Ljava/lang/String;)(s);
//      this.@org.example.foo.Flipper                       ::onFlip      (Ljava/lang/String;)(s);
//    };
//    eval( "window.CallbackName=tmpcallback" );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static native void removeTreatment(String id)
	/*-{
		$wnd.removeTreatment(id);
	}-*/;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void loadTreatmentsData()
	{
		GWTViewer.MapServiceInfoServlet.loadTreatments(new AsyncCallback<String>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(String content)
			{
				loadTreatments (content);
			}
		});
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void loadTreatments (String content)
	{
//		System.out.println ("0. loadTreatments : content = \n" + content);
//		com.google.gwt.user.client.Window.alert("0. loadTreatments : content = \n" + content);
		JSONValue  jsonValue = JSONParser.parseLenient(content);
		JSONObject json      = jsonValue.isObject(); 

		JSONArray list = json.get("treatments").isArray();

		if (list.size() > 0)
		{
//			com.google.gwt.user.client.Window.alert("1. loadTreatments : list.size() = " + list.size());
			treatmentsList = new ArrayList<Treatment>();
			
			for (int i = 0; i < list.size(); i++)
			{
				JSONObject rec = list.get(i).isObject();
				
				int    id    = Integer.valueOf(rec.get("id"   ).toString());
				double lon   = Double.valueOf (rec.get("lon"  ).toString());
				double lat   = Double.valueOf (rec.get("lat"  ).toString());
				int    count = Integer.valueOf(rec.get("count").toString());

//				System.out.println ("1. loadTreatments : id = " + id + ", lon= " + lon + ", lat = " + lat + ", count = " + count);
//				com.google.gwt.user.client.Window.alert("2. loadTreatments : id = " + id + ", lon= " + lon + ", lat = " + lat + ", count = " + count);

				drawTreatment(lon, lat, count, String.valueOf(id));

				Treatment treatment = new Treatment(id, count, lon, lat);
				treatmentsList.add(treatment);
			}
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void addNewTreatment (int id, double lon, double lat)
	{
		Treatment treatment = new Treatment(id, 1, lon, lat);
		treatmentsList.add(treatment);
		drawTreatment(lon, lat, 1, String.valueOf(id));
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void joinTreatment (Treatment treatment)
	{
		removeTreatment(String.valueOf(treatment.getId()));
		drawTreatment(treatment.getLon(), treatment.getLat(), treatment.getCount(), String.valueOf(treatment.getId()));
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void setTreatmentDesc(Treatment treatment, String jsonDesc)
	{
		JSONValue  jsonValue = JSONParser.parseLenient(jsonDesc);
		JSONObject json      = jsonValue.isObject();
		
		String category = json.get("category").toString();
		String reported = json.get("reported").toString();
		String content  = json.get("content" ).toString();
		String email    = json.get("email"   ).toString();
		
		treatment.setCategory(category.substring(1, category.length() - 1));
		treatment.setReported(reported.substring(1, reported.length() - 1));
		treatment.setContent (content .substring(1, content .length() - 1));
		treatment.setEmail   (email   .substring(1, email   .length() - 1));
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public Treatment isTreatmentChoosed (String cursorLocation, double resolution)
	{
		Treatment result = null;
		if ((treatmentsList != null) && (treatmentsList.size() > 0))
		{
			double lon;
			double lat;
			int    idx = cursorLocation.indexOf(',');
			lon = Double.valueOf(cursorLocation.substring(0, idx));
			lat = Double.valueOf(cursorLocation.substring(idx + 1));
//			System.out.println ("0. isTreatmentChoosed : treatmentsList.size() = " + treatmentsList.size());
			for (int i = 0; i < treatmentsList.size(); i++)
			{
				Treatment treatment = treatmentsList.get(i);
				int delta = (int) (Math.abs(lon - treatment.getLon()) / resolution);
				if (delta <= 12)
				{
//					delta = (int) (Math.abs(lat - treatment.getLat()) / resolution);
					delta = (int) ((lat - treatment.getLat()) / resolution);
//					System.out.println ("1. isTreatmentChoosed : delta = " + delta + ", (lat - treatment.getLat()) = " + (lat - treatment.getLat()) + ", resolution = " + resolution);
					if ((-1 <= delta) && (delta <= 20))
					{
						result = treatment;
						break;
					}
				}
			}
		}
		return result;
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
