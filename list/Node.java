package list;


/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

//not public
class Node <E>
{
    E value;
    Node<E> next;
    Node<E> prev;
    Node (E value, Node<E> next, Node<E> prev)
    {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
    
}
