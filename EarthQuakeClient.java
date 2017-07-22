import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData){
            if(qe.getMagnitude() > magMin){
                answer.add(qe);
            }
        }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry qe : quakeData){
            if(from.distanceTo(qe.getLocation()) / 1000 < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes(double magMin) {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        ArrayList<QuakeEntry> bigQuakeList = filterByMagnitude(list, magMin);
        for(QuakeEntry qe : bigQuakeList){
            System.out.println(qe);
        }
        System.out.println("read data for "+list.size()+" quakes");
        System.out.println("Found " + bigQuakeList.size() + " that match that criteria");
    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        // String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        // Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);
        double dist = 1000;

        ArrayList<QuakeEntry> answer = filterByDistanceFrom(list, dist, city);
        for(QuakeEntry qe : answer) {
            System.out.println(city.distanceTo(qe.getLocation()) / 1000 + " " + qe.getInfo() );
        }
        System.out.println("Found " + answer.size() + " quake(s) that match that criteria"); 
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,
                                                double minDepth, double maxDepth){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        
        for (QuakeEntry qe : quakeData){
            if(qe.getDepth() > minDepth && qe.getDepth() < maxDepth){
                answer.add(qe);
            }
        }
        return answer;
    }
    
    public void quakesOfDepth() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        ArrayList<QuakeEntry> quakeDepthData = filterByDepth(list, -10000.0, -8000.0);
        
        System.out.println("read data for " + list.size() + " quakes");
        
        for(QuakeEntry qe : quakeDepthData){
            System.out.println(qe);
        }
        
        System.out.println("Found " + quakeDepthData.size() + " quakes that match that criteria");
    }

    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry>quakeData,
                               String position, String phrase){
           
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData){
            String info = qe.getInfo();
            
            switch(position){
                case "start":
                    if(info.startsWith(phrase)){
                        answer.add(qe);
                    }
                    break;
                case "end":
                    if(info.endsWith(phrase)){
                        answer.add(qe);
                    }
                    break;
                case "any":
                    if(info.contains(phrase)){
                        answer.add(qe);
                    }
                    break;
                default:
                    break;
            }
        }
        return answer;
    }
    
    public void quakesByPhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        ArrayList<QuakeEntry> quakePh1 = filterByPhrase(list, "end", "California");
        ArrayList<QuakeEntry> quakePh2 = filterByPhrase(list, "any", "Creek");
        ArrayList<QuakeEntry> quakePh3 = filterByPhrase(list, "start", "Explosion");
        
        for(QuakeEntry qe : quakePh1){
            System.out.println(qe);
        }
        System.out.println("Found " + quakePh1.size() + " quakes that match Californina at end");
        System.out.println("");
        for(QuakeEntry qe : quakePh2){
            System.out.println(qe);
        }
        System.out.println("Found " + quakePh2.size() + " quakes that match Can at any");
        System.out.println("");
        for(QuakeEntry qe : quakePh3){
            System.out.println(qe);
        }
        System.out.println("Found " + quakePh3.size() + " quakes that match Explosion at start");
        System.out.println("");
    }
    
}
