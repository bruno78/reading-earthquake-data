
/**
 * Write a description of class PhraseFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter
{
    private String position;
    private String phrase;
    private String filterName;
    
    public PhraseFilter(String pos, String phr, String name)
    {
        position = pos;
        phrase = phr;
        filterName = name;
    }
    
    public boolean satisfies(QuakeEntry qe)
    {
        switch (position) {
            case "start": 
                return qe.getInfo().startsWith(phrase);
   
            case "end":
                return qe.getInfo().endsWith(phrase);
            
            case "any": 
                return qe.getInfo().contains(phrase);
            
            default: return false;
            
        }
    }
    
    public String getName()
    {
        return filterName;
    }
}
