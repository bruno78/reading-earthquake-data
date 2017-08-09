package searchEarthQuakeData;

import java.util.*;

public class ClosestQuakes {
    public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany) {
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copyData = new ArrayList<QuakeEntry>(quakeData);
        // TO DO
        for (int j=0; j < howMany; j++) {
            int minIndex = 0;
            for(int k = 1; k < copyData.size(); k++){
                QuakeEntry quake = copyData.get(k);

                if (quake.getLocation().distanceTo(current) <
                    copyData.get(minIndex).getLocation().distanceTo(current)){

                    minIndex = k;

                }
            }
            ret.add(copyData.get(minIndex));
            copyData.remove(minIndex);
        }
        return ret;
    }

    public void findClosestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());

        Location jakarta  = new Location(-6.211,106.845);

        ArrayList<QuakeEntry> close = getClosest(list,jakarta,3);
        for(int k=0; k < close.size(); k++){
            QuakeEntry entry = close.get(k);
            double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            System.out.printf("%4.2f\t %s\n", distanceInMeters/1000,entry);
        }
        System.out.println("number found: "+close.size());
    }

}
