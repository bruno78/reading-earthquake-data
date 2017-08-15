package earthQuakeMap;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

public class LandQuakeMarker extends EarthquakeMarker {
	
	
	public LandQuakeMarker(PointFeature quake) {
		
		// calling EarthquakeMarker constructor
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = true;
	}


	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		
		//float size = (float)((double)getRadius()*0.75);
		float size = (float)((double)getMagnitude()*1.2);
		pg.ellipse(x,y,size*2,size*2);
	    /*	
		if(super.getMagnitude() <= 4){
			pg.ellipse(x, y, 5, 5);
		}
		else if (super.getMagnitude() < 5){
			pg.ellipse(x, y, 10, 10);
		}
		else {
			pg.ellipse(x,  y, 15, 15);
		}
		*/
		
	}
	
	// Get the country the earthquake is in
	public String getCountry() {
		return (String) getProperty("country");
	}
		
}