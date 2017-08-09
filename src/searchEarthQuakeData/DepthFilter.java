package searchEarthQuakeData;

import filter.Filter;

public class DepthFilter implements Filter
{
    private double minDepth;
    private double maxDepth;
    private String filterName;

    public DepthFilter(double min, double max, String name)
    {
        minDepth = min;
        maxDepth = max;
        filterName = name;
    }
    
    @Override
    public boolean satisfies(filter.QuakeEntry qe){
        return (qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth);
    }

    public String getName() {
        return filterName;
    }

}
