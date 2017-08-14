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

		if(super.getMagnitude() <= 4){
			pg.rect(x, y, 5, 5);
		}
		else if (super.getMagnitude() < 5){
			pg.rect(x, y, 10, 10);
		}
		else {
			pg.rect(x,  y, 15, 15);
		}
		
	}

}
