package searchEarthQuakeData;


import java.util.*;

public class LargestQuakes
{

    public LargestQuakes()
    {

    }

    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        ArrayList<QuakeEntry> quakeData = getLargest(list, 50);

        for(QuakeEntry qe : quakeData){
            System.out.println(qe);
        }
        System.out.println("Read data for " + list.size() + " quakes");
        //int idx = indexOfLargest(list);
        //System.out.println("The largest quake is of magnitude " + list.get(idx).getMagnitude() +
        //" at position " + idx);
    }

    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        int index = 0;
        for (QuakeEntry qe : data){

            if(qe.getMagnitude() > data.get(index).getMagnitude()){
                index = data.indexOf(qe);
            }
        }
        return index;
    }

    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        int maxIndex;
        for (int i = 0; i < howMany; i++){
            if(copy.size() != -1){
                maxIndex = indexOfLargest(copy);
                answer.add(copy.get(maxIndex));
                copy.remove(maxIndex);
            }
        }
        return answer;
    }
}
