package stack;

import list.*;

/**
 * Stack ADT is a Last-In First-Out list
 * 
 * @author Andrew Blanco
 * @version 9/26
 */
public interface StackADT<E>
{
    /**
     * @return the pushed value
     */
    E push (E value);
    
    /**
     * Remove the top value
     * @return value removed
     */
    E pop();
    
    /**
     * @return the top value of this StackADT
     */
    E peek();
    
    /** Clear this StackADT */
    void clear();
    
    /** @return true only if this StackADT is empty */
    boolean isEmpty();
    
    /** @return true only if this Stack is equal to the parameter, other */
    boolean equals(Object other);
}
