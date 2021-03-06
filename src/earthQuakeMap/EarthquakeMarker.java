package earthQuakeMap;

import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PGraphics;

public abstract class EarthquakeMarker extends SimplePointMarker
{
	
	protected boolean isOnLand;


	/** Greater than or equal to this threshold is a moderate earthquake */
	public static final float THRESHOLD_MODERATE = 5;
	/** Greater than or equal to this threshold is a light earthquake */
	public static final float THRESHOLD_LIGHT = 4;

	/** Greater than or equal to this threshold is an intermediate depth */
	public static final float THRESHOLD_INTERMEDIATE = 70;
	/** Greater than or equal to this threshold is a deep depth */
	public static final float THRESHOLD_DEEP = 300;

	// ADD constants for colors
    public static final int YELLOW = 0xFF0000FF;
    public static final int BLUE = 0xFFFFFF00;
    public static final int RED = 0xFFFF0000;
    
	
	// abstract method implemented in derived classes
	public abstract void drawEarthquake(PGraphics pg, float x, float y);
		
	
	// constructor
	public EarthquakeMarker (PointFeature feature) 
	{
		super(feature.getLocation());
		// Add a radius property and then set the properties
		java.util.HashMap<String, Object> properties = feature.getProperties();
		float magnitude = Float.parseFloat(properties.get("magnitude").toString());
		properties.put("radius", 2*magnitude );
		setProperties(properties);
		this.radius = 1.75f*getMagnitude();
	}
	

	// calls abstract method drawEarthquake and then checks age and draws X if needed
	public void draw(PGraphics pg, float x, float y) {
		// save previous styling
		pg.pushStyle();
			
		// determine color of marker from depth
		colorDetermine(pg);
		
		// call abstract method implemented in child class to draw marker shape
		drawEarthquake(pg, x, y);
		
		// OPTIONAL TODO: draw X over marker if within past day		
		if(this.getProperty("age").toString().equals("Past Day")) {
			// pg.line(x-10, y-10, x+10, y+10);
			// pg.line(x-10, y+10, x+10, y-10);
			pg.line(x-8, y-8, x+8, y+8);
		    pg.line(x-8, y+8, x+8, y-8);
		}
		// reset to previous styling
		pg.popStyle();
		
	}
	
	private void colorDetermine(PGraphics pg) {
		//TODO: Implement this method
		if(this.getDepth() < 70) {
			pg.fill(BLUE);
		}
		else if (this.getDepth() < 300) {
			pg.fill(YELLOW);
		}
		else {
			pg.fill(RED);
		}
	}
	
	
	/*
	 * getters for earthquake properties
	 */
	
	public float getMagnitude() {
		return Float.parseFloat(getProperty("magnitude").toString());
	}
	
	public float getDepth() {
		return Float.parseFloat(getProperty("depth").toString());	
	}
	
	public String getTitle() {
		return (String) getProperty("title");	
		
	}
	
	public float getRadius() {
		return Float.parseFloat(getProperty("radius").toString());
	}
	
	public boolean isOnLand()
	{
		return isOnLand;
	}
	
	
}
