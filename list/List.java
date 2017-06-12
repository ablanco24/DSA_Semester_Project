 package list;
/**
 * Write a description of interface List here.
 * 
 * @author Andrew Blanco
 * @version 9/9/16
 */
public interface List<E>
{
        //@return the size of this List 
        int size();
        //return size var
        
        //@return true if this List is empty
        boolean isEmpty();
        // if size is 0 return true, else false
        
        //Remove all items from this List
        void clear();
        //set size = 0
        
        //Insert the given value at the end of this List
        void add(E value);
        
        //Insert the given value at given index(ndx) in the List
        //Pre: Index must be >= 0 and < = size 
        void add(int ndx, E value);
        
        /**
         * @return the value at given ndx
         * Pre: ndx >=0  ndx < size
         */
        E get(int ndx);
        
        /**
         * @return the former value
         * Pre: ndx >= 0, ndx < size
         * Change the given ndx to given value
         */ 
        E set(int ndx, E value);
        
        /** Remove the value at the given position
         * @return the removed value 
         * Pre: ndx >= 0 ndx < 0
         * 
         */
        E remove(int ndx);
        
        /**
         * @return the position of the first occurence given Object in this List
         * or -1, if not found
         */
        int indexOf(Object obj);
        
        /** 
         * @return true only if the given object is contained in this List 
         */
        boolean contains (Object obj);
        
        /** Remove the first occurrence of the given object from this List, if possible.
           *  @return true only if it was removed.
           */
        boolean remove (Object obj);
        
        /** 
         * @return the elements of this List as a String, with elements separated by commas, 
         * enclosed in square brackets: [a,b,c]
         */
        String toString( );

         
         /**
          * @return true only if this List is equal to the parameter, other 
          */
        boolean  equals (Object other);
        
         /**
         * @return an iterator for this List
         */
        Iterator<E> iterator();
        
        /**  @return true if this List contains at least one null reference.  */
        boolean containsNull();
          
        /** Add all elements of other to the end of this List */
        void addAll(List other);
        
        ListIterator<E> listIterator();
        
        ListIterator<E> listIterator(int start);
        
}
