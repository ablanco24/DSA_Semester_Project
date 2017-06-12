package list;


/**
 * Iterate through an ArrayList
 * 
 * @author Andrew Blanco
 * @version 9/19/16
 */
class ArrayIterator<E> implements Iterator<E>
{
    int cursor = -1;
    List<E> list;
    
    ArrayIterator(List<E> list)
    {
        this.list = list;
    }
    
    public boolean hasNext()
    {
        return cursor < list.size() - 1;
    }
    
    public E next()
    {
        cursor++;
        return list.get(cursor);
    }
    
    //removes the last one in the ArrayList
    public void remove()
    {
        list.remove(cursor);
        cursor--;
    }
    
    /** @return true if there are two more values */
    public boolean hasTwoMore()
    {    
        return cursor < list.size() - 2;
    }
}
