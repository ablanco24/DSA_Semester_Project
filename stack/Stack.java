package stack;
import list.*;

/**
 * A stack can be implemented with some kind of List
 * 
 * @author Andrew Blanco
 * @version 9/26/16
 */
@SuppressWarnings("unchecked")
public class Stack<E> implements StackADT<E>
{
    List<E> values = new ArrayList<E>();
    public Stack()
    {
    }
    
    public Stack(boolean refBased)
    {
        if(refBased)
            values = new LinkedList<E>();
    }
    
    public E push(E value)
    {
        values.add(value);
        return value;
    }
    
    public E pop()
    {
        return values.remove(values.size() -1);
    }
    
    public E peek()
    {
        return values.get(values.size() - 1);
    }
    
    public String toString()
    {
        return values.toString();
    }
    
    public void clear()
    {
        while(values.size() > 0)
            pop();
    }
    
    public boolean isEmpty()
    {
        return values.size() == 0;
    }
    
    /** @return true only if this Stack is equal to the parameter, other */
    public boolean equals(Object other)
    {
        if(!(other instanceof Stack))
            return false;
        Stack<E> temp = (Stack) other;
        return values.equals(temp.values);
    }
}
