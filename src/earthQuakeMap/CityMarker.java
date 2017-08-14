package earthQuakeMap;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PGraphics;

public class CityMarker extends SimplePointMarker {

	// The size of the triangle marker
	// It's a good idea to use this variable in your draw method
	public static final int TRI_SIZE = 5;

	public CityMarker(Location location) {
		super(location);
	}


	public CityMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	}

	public void draw(PGraphics pg, float x, float y) {
		// Save previous drawing style
		pg.pushStyle();
		// TODO: Add code to draw a triangle to represent the CityMarker
		pg.fill(255, 125, 0);
		pg.triangle(x-TRI_SIZE, y+TRI_SIZE, x, y-TRI_SIZE, x+TRI_SIZE, y+TRI_SIZE);
		// Restore previous drawing style
		pg.popStyle();
	}


	public String getCity()
	{
		return getStringProperty("name");
	}

	public String getCountry()
	{
		return getStringProperty("country");
	}

	public float getPopulation()
	{
		return Float.parseFloat(getStringProperty("population"));
	}

}
