package ru.mos.gispro.client.geometry;

import com.google.gwt.core.client.JavaScriptObject;
import ru.mos.gispro.client.json.JSONPoint;
import ru.mos.gispro.client.json.JSONPolyLine;
import ru.mos.gispro.client.json.JSONPolygon;

/**
 * User: dima
 * Date: 20.11.2010
 * Time: 16:22:00
 */

public class GeometryManager {

	public static native void clearGeometry() /*-{
	        $wnd.vectors.removeAllFeatures();
	}-*/;

	public static native void drawGeometry(String geoJsonString, boolean zoom, boolean move) /*-{
	        var features = $wnd.geojson.read(geoJsonString);
	        var bounds;
	        if(features) {
	            if(features.constructor != $wnd.Array) {
	                features = [features];
	            }
	            for(var i=0; i<features.length; ++i) {
	                if (!bounds) {
	                    bounds = features[i].geometry.getBounds();
	                } else {
	                    bounds.extend(features[i].geometry.getBounds());
	                }
	            }
	            $wnd.vectors.addFeatures(features);
	            if (move) {
					if (zoom) {
						$wnd.map.zoomToExtent(bounds);
					}else {
						$wnd.map.panTo(bounds.getCenterLonLat());
					}
	            }
	        }
	}-*/;

	public static native void drawPoint(float x, float y, boolean zoom, boolean move) /*-{
		var features = new $wnd.Array(1);
		features[0] = new $wnd.OpenLayers.Feature.Vector(
			new $wnd.OpenLayers.Geometry.Point(x, y),
			{
				type: 12
			}
		);

		$wnd.vectors.addFeatures(features);

		var bounds;
		for(var i=0; i<features.length; ++i) {
			if (!bounds) {
				bounds = features[i].geometry.getBounds();
			} else {
				bounds.extend(features[i].geometry.getBounds());
			}
		}

		if (move) {
			if (zoom) {
				$wnd.map.zoomToExtent(bounds);
			}else {
				$wnd.map.panTo(bounds.getCenterLonLat());
			}
		}
	}-*/;

	public static void draw(JavaScriptObject geometry, boolean pos, boolean move) {
		JSONPolygon polygon = geometry.cast();

		if (polygon.polygons() != null) {

			String poly = "";

			Integer polygonsLength = polygon.polygons().length;
			for (int i = 0; i < polygonsLength; i++) {

				poly += "[\n";

				Integer coordLength = polygon.coords(i).length;
				for (int j = 0; j < coordLength; j++) {

					poly += "          [\n" +
							"              " + polygon.coordx(i, j) + ", \n" +
							"              " + polygon.coordy(i, j) + "\n" +
							"          ]";

					if (j < coordLength - 1) {
						poly += ",\n";
					} else {
						poly += "\n";
					}

				}

				if (i < polygonsLength - 1) {
					poly += "],\n";
				} else {
					poly += "]\n";
				}

			}

			String geom = "{\n" +
					"    \"type\": \"FeatureCollection\",\n" +
					"    \"features\": [\n" +
					"        {\n" +
					"            \"type\": \"Feature\",\n" +
					"            \"id\": \"OpenLayers.Feature.Vector_95\",\n" +
					"            \"properties\": {\n" +
					"            },\n" +
					"            \"geometry\": {\n" +
					"                \"type\": \"Polygon\",\n" +
					"                \"coordinates\": [\n" +
					poly +
					"                ]\n" +
					"            }\n" +
					"        }\n" +
					"    ]\n" +
					"}";


//                            com.google.gwt.user.client.Window.alert(geom);

			GeometryManager.drawGeometry(geom, pos, move);

		}

		JSONPolyLine polyline = geometry.cast();

		if (polyline.polylines() != null) {

			Integer polyLineLength = polyline.polylines().length;

			String poly = "";

			for (int i = 0; i < polyLineLength; i++) {

				Integer coordLength = polyline.coords(i).length;

				for (int j = 0; j < coordLength; j++) {

					poly += "          [\n" +
							"              " + polyline.coordx(i, j) + ",\n" +
							"              " + polyline.coordy(i, j) + "\n" +
							"          ]";

					if (j < coordLength - 1) {
						poly += ",\n";
					} else {
						poly += "\n";
					}
				}

				String geom = "{\n" +
						"    \"type\": \"FeatureCollection\",\n" +
						"    \"features\": [\n" +
						"        {\n" +
						"            \"type\": \"Feature\",\n" +
						"            \"id\": \"OpenLayers.Feature.Vector_95\",\n" +
						"            \"properties\": {\n" +
						"            },\n" +
						"            \"geometry\": {\n" +
						"                \"type\": \"LineString\",\n" +
						"                \"coordinates\": [\n" +
						poly +
						"                ]\n" +
						"            }\n" +
						"        }\n" +
						"    ]\n" +
						"}";

				GeometryManager.drawGeometry(geom, pos, move);

			}

		}

		JSONPoint point = geometry.cast();

		try {
			if (point != null) {
				GeometryManager.drawPoint(new Float(point.coordx()), new Float(point.coordy()), pos, move);
			}
		} catch (NumberFormatException ignored) {
		}
	}


}
