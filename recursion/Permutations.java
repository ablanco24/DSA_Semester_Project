package recursion;

import java.util.*;


/**
 * Write a description of class Permutations here.
 * 
 * @author Andrew Blanco
 * @version 10/9/16
 */
@SuppressWarnings("unchecked")
public class Permutations
{
      /**
      *  @return The set of all permutations of the given list.
      *  Pre:  The given list is not empty.
      */
    public static Set <List <Character>>  generatePerms (List <Character> list) 
    {
        Set<List <Character>> result = new HashSet<List <Character>>();
        
        if(list.size() == 1)
        {
            result.add(list);   
            return result;
        }
        else
        {
           char head = list.remove(0);
           Set<List <Character>> temp = new HashSet<List <Character>>();
           
           
           temp = (generatePerms(list));
           for(List<Character> set : temp)
           {
               for(int i = 0; i < set.size(); i++)
               {
                   List<Character> tail = new LinkedList <Character> (set);
                   
                   tail.add(i,head);
                   result.add(tail);
                   
               }
               List<Character> tail = new LinkedList <Character> (set);
               tail.add(head);
               result.add(tail);
           }
           
            
           
            
            return result;
            
        }
        
        
    }

}
