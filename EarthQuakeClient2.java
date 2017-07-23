import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        //Filter f = new MinMagFilter(4.0, "Mininum Magnitude");
        //Filter magFilter = new MagnitudeFilter(4.0, 5.0, "Magnitude");
        //Filter depthFilter = new DepthFilter(-35000.0, -12000.0, "Depth");
        
        //Location japan = new Location(35.42, 139.43);
        //Filter distFilter = new DistanceFilter(japan, 10000, "Distance");
        //Filter phraseFilter = new PhraseFilter("end", "Japan", "Phrase");
        
        // EXAME
        Location denver = new Location(39.7392, -104.9903);
        Filter distFilter = new DistanceFilter(denver, 1_000_000, "Distance");
        Filter phraseFilter = new PhraseFilter("end", "a", "Phrase");
        
        Filter magFilter = new MagnitudeFilter(3.5, 4.5, "Magnitude");
        Filter depthFilter = new DepthFilter(-55000.0, -20000.0, "Depth");
        
        
        //ArrayList<QuakeEntry> m7  = filter(list, f); 
        //ArrayList<QuakeEntry> result = filter(filter(list, magFilter), depthFilter);
        ArrayList<QuakeEntry> result = filter(filter(list, distFilter), phraseFilter);
   
        for (QuakeEntry qe: result) { 
            System.out.println(qe);
        } 
        System.out.println("There were " + result.size() + " earthquakes found");
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }
    
    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: "+list.size());
        
        MatchAllFilter maf = new MatchAllFilter();
        Filter mag = new MagnitudeFilter(1.0, 4.0, "Magnitude");
        Filter depth = new DepthFilter(-180000.0, -30000.0, "Depth");
        Filter phrase = new PhraseFilter("any", "o", "Phrase");
        maf.addFilter(mag);
        maf.addFilter(depth);
        maf.addFilter(phrase);
        for(QuakeEntry qe : filter(list, maf)){
            System.out.println(qe);
        }
        System.out.println("Filters used are: " + maf.getName());
        System.out.println("There were " + filter(list, maf).size() + " earthquakes found");
    }
    
    public void testMatchFilter2() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: "+list.size());
        
        MatchAllFilter maf = new MatchAllFilter();
        Filter mag = new MagnitudeFilter(0.0, 5.0,"Magnitude");
        Location billund = new Location(55.7308, 9.1153);
        Filter dist = new DistanceFilter(billund, 3_000_000,"Distance");
        Filter phrase = new PhraseFilter("any", "e", "Phrase");
        maf.addFilter(mag);
        maf.addFilter(dist);
        maf.addFilter(phrase);
        for(QuakeEntry qe : filter(list, maf)){
            System.out.println(qe);
        }
        System.out.println("Filters used are: " + maf.getName());
        System.out.println("There were " + filter(list, maf).size() + " earthquakes found");
    }
}
