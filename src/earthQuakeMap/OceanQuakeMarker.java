package earthQuakeMap;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

public class OceanQuakeMarker extends EarthquakeMarker {
	
	public OceanQuakeMarker(PointFeature quake) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
	}
	
	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {

		float size = (float)((double)getMagnitude()*1.2);
		pg.rect(x-size, y-size, size*2, size*2);
		
		/*
		float size = 0;
		if(super.getMagnitude() <= 4){
			size = 5;
			pg.rect(x-size/2, y-size/2, size, size);
		}
		else if (super.getMagnitude() < 5){
			size = 10;
			pg.rect(x-size/2, y-size/2, size, size);
		}
		else {
			size = 15;
			pg.rect(x-size/2, y-size/2, size, size);
		}
		*/
		
	}

}
