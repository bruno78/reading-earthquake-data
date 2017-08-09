package filter;


/**
 * Write a description of class MagnitudeFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MagnitudeFilter implements Filter
{
    private double minMag;
    private double maxMag;
    private String filterName;
    
    public MagnitudeFilter(double min, double max, String name)
    {
        minMag = min;
        maxMag = max;
        filterName = name;
    }
    
    public boolean satisfies(QuakeEntry qe)
    {
        return (qe.getMagnitude() >= minMag && qe.getMagnitude() <= maxMag);
    }
    
    public String getName(){
        return filterName;
    }
}
