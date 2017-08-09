package filter;


public interface Filter
{
    public  boolean satisfies(QuakeEntry qe); 
    public String getName();
}
