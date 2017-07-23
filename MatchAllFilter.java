
/**
 * Write a description of class MatchAllFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class MatchAllFilter implements Filter
{
    private ArrayList<Filter> filters;
    
    public MatchAllFilter()
    {
        filters = new ArrayList<Filter>();
    }
    
    public void addFilter(Filter filter){
        filters.add(filter);
    }
    
    public boolean satisfies(QuakeEntry qe) {
        for(Filter f : filters) {
            if(!f.satisfies(qe)){
                return false;
            }
        }
        return true;
    }
    
    public String getName() {
        ArrayList<String> list = new ArrayList();
        for(Filter f : filters) {
            list.add(f.getName());
        }
        return String.join(" ", list);
    }
}
