package hash;
import list.Iterator;

/**
 * Write a description of class TableIterator here.
 * 
 * @author Andrew Blanco
 * @version 11/11/16
 */
class TableIterator<E> implements Iterator<E>
{
   int ndx = 0; //which linked list
   Iterator<E> itty; //for a LinkedList
   HashTable<E> table;
   
   TableIterator(HashTable<E> table)
   {
       this.table = table;
       itty = table.lists.get(0).iterator();
   }
   
   public boolean hasNext()
   {
       if(itty.hasNext())
            return true;
       
       for(ndx++; ndx < table.lists.size(); ndx++)
       {
           if(!table.lists.get(ndx).isEmpty())
           {
                setItty(ndx);
                return true;
           }
       }
       return false;
   }
   
   public E next()
   {
       hasNext();
       return itty.next();
   }
   
   private void setItty(int ndx)
   {
       itty = table.lists.get(ndx).iterator();
   }
   
   public void remove()
   {
       itty.remove();
       table.keyCount--;
   }
   
   public boolean hasTwoMore()
   {
       return false;
   }
}
