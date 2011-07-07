package ru.mos.gispro.client.geometry;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import ru.mos.gispro.client.json.JSONPoint;
import ru.mos.gispro.client.json.JSONPolyLine;
import ru.mos.gispro.client.json.JSONPolygon;

public class GeometryManager
{
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static native void clearGeometry()
	/*-{
//	        $wnd.vectors.removeAllFeatures();
	        $wnd.clearGeometry();
	}-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static native void drawGeometry(String geoJsonString, boolean zoom, boolean move)
	/*-{
//	        var features = $wnd.geojson.read(geoJsonString);
//	        var bounds;
//	        if(features)
//	        {
//	            if(features.constructor != $wnd.Array)
//	            {
//	                features = [features];
//	            }
//	            for(var i=0; i<features.length; ++i)
//	            {
//	                if (!bounds)
//	                {
//	                    bounds = features[i].geometry.getBounds();
//	                } else {
//	                    bounds.extend(features[i].geometry.getBounds());
//	                }
//	            }
//	            $wnd.vectors.addFeatures(features);
//	            if (move)
//	            {
//					if (zoom)
//					{
//						$wnd.map.zoomToExtent(bounds);
//					}else {
//						$wnd.map.panTo(bounds.getCenterLonLat());
//					}
//	            }
//	        }
			$wnd.drawGeometry(geoJsonString, zoom, move);	        
	}-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static native void drawPoint(double x, double y, boolean zoom, boolean move)
	/*-{
		$wnd.drawPoint(x, y, zoom, move);
	}-*/;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@SuppressWarnings("unchecked")
	public static void draw(JavaScriptObject geometry, boolean pos, boolean move)
	{
		if (geometry == null)
			return;

		JSONPolygon polygon = geometry.cast();
		if ((polygon != null) && polygon.isPolygons())
		{
			StringBuilder poly = new StringBuilder();
			Integer polygonsLength = polygon.polygons().length();
//			System.out.println ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nGeometryManager.draw : polygon - polygonsLength = " + polygonsLength);
			try {
				for (int i = 0; i < polygonsLength; i++)
				{
					poly.append("[\n");
					int coordLength = polygon.coords(i).length();
					for (int j = 0; j < coordLength; j++)
					{
						poly.append("          [\n"  +
						            "              " + polygon.coordx(i, j) + ", \n" +
						            "              " + polygon.coordy(i, j) + "\n"   +
								    "          ]");
						if (j < coordLength - 1) 
							poly.append(",\n");
						else
							poly.append("\n");
					}

					if (i < polygonsLength - 1)
						poly.append("],\n");
					else
						poly.append("]\n");
				}

				String geom = "{\n" +
				              "    \"type\": \"FeatureCollection\",\n"                  +
				              "    \"features\": [\n"                                   +
				              "        {\n"                                             +
				              "            \"type\": \"Feature\",\n"                    +
				              "            \"id\": \"OpenLayers.Feature.Vector_95\",\n" +
				              "            \"properties\": {\n"                         +
				              "            },\n"                                        +
				              "            \"geometry\": {\n"                           +
				              "                \"type\": \"Polygon\",\n"                +
				              "                \"coordinates\": [\n"                    +
					                     	       poly.toString()                      +
					          "                ]\n"                                     +
					          "            }\n"                                         +
					          "        }\n"                                             +
					          "    ]\n"                                                 +
					          "}";
				GeometryManager.drawGeometry(geom, pos, move);
			}  catch (Exception e){}
		} else {
			JSONPolyLine polyline = (JSONPolyLine) geometry.cast();
			if ((polyline != null) && polyline.isPolylines())
			{
				try {
					JsArray<JavaScriptObject> polylinesItems = polyline.polylinesItems();
					int polyLineLength = polylinesItems.length();
					String poly = "";
					for (int i = 0; i < polyLineLength; i++)
					{
						// Integer coordLength = polyline.coords(i).length;
						JsArray<JavaScriptObject> polylinesItem = (JsArray<JavaScriptObject>) polylinesItems.get(i);
						int coordLength = polylinesItem.length();
						for (int j = 0; j < coordLength; j++)
						{
//							System.out.println ("x = " + x + ", y = " + y);
//							System.out.println ("x2 = " + polyline.coordx(i, j) + ", y2 = " + polyline.coordy(i, j));

							poly += "          [\n" +
							        "              " + polyline.coordx(i, j) + ",\n" +
							        "              " + polyline.coordy(i, j) + "\n"  +
							        "          ]";
							if (j < coordLength - 1)
							{
								poly += ",\n";
							} else {
								poly += "\n";
							}
						}
						String geom = "{\n"                                                     +
				                      "    \"type\": \"FeatureCollection\",\n"                  +
				                      "    \"features\": [\n"                                   +
				                      "        {\n"                                             +
				                      "            \"type\": \"Feature\",\n"                    +
				                      "            \"id\": \"OpenLayers.Feature.Vector_95\",\n" +
				                      "            \"properties\": {\n"                         +
				                      "            },\n"                                        +
				                      "            \"geometry\": {\n"                           +
				                      "                \"type\": \"LineString\",\n"             +
				                      "                \"coordinates\": [\n"                    +
					                       	      	  	  poly                                  +
					                  "                ]\n"                                     +
					                  "            }\n"                                         +
					                  "        }\n"                                             +
					                  "    ]\n"                                                 +
					                  "}";
//					System.out.println ("geom = " + geom);
						GeometryManager.drawGeometry(geom, pos, move);
					}
				} catch (Exception e){}
			} else {
				JSONPoint point = geometry.cast();
				try
				{
//					System.out.println ("0. GeometryManager.draw : point = " + point);
					if ((point != null) && point.isPoint())
					{
//						System.out.println ("1. GeometryManager.draw : point.coordx = " + point.coordx());
//						System.out.println ("1. GeometryManager.draw : geom = \n" + geom);
						GeometryManager.drawPoint(point.coordx(), point.coordy(), pos, move);
					}
				} catch (NumberFormatException ignored) {}
			}
		}
	}
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
