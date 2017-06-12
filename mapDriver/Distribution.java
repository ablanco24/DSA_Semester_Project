package mapDriver;
import map.*;
import list.*;

/**
 * Find a distribution for text
 * 
 * @author Andrew Blanco
 * @version 11/21/16
 */
public class Distribution
{
    Map<String, Integer> map = new HashMap<String,Integer>();
   // Map<String, Integer> map = new TreeMap<String,Integer>();
    public void buildMap(List<String> text)
    {
        Iterator<String> itty = text.iterator();
        String word;
        Integer count;
        while(itty.hasNext())
        {
            word = itty.next();
            count = map.get(word);
            if(count == null)
                map.put(word,1);
            else
                map.put(word,count + 1);
        }
    }
}
