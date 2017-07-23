
/**
 * Write a description of class DistanceFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter
{
    private Location location;
    private float maxDist;
    private String filterName;
    
    public DistanceFilter(Location loc, float dist, String name)
    {
        location = loc;
        maxDist = dist;
        filterName = name;
    }
    
    public boolean satisfies(QuakeEntry qe)
    {
        return (location.distanceTo(qe.getLocation())) < maxDist;
    }
    
    public String getName() {
        return filterName;
    }
}
