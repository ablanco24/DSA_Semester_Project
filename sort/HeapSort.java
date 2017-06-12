package sort;
import list.*;

/**
 * HeapSort a list, Assumed to be an ArrayList
 * 
 * @author Andrew Blanco 
 * @version 11/4/16
 */
@SuppressWarnings("unchecked")
public class HeapSort<E extends Comparable> implements Sorter<E>
{
    List<E> list;
    public void sort(List<E> list)
    {
        this.list = list;
        heapify(0);

        int last = list.size() - 1;
        while(last > 0)
        {
            swap(0, last);
            last--;
            percDown(0, last);
        }
        
    }
    
    private void heapify(int root)
    {
        int max = list.size() -1;
        if(root >= max) 
            return;
        heapify(2*root +1);  //left
        heapify(2*root +2);  //right
        percDown(root, max);            
    }
    
    private void percDown(int root, int max)
    {
        if((2*root+1) > max)    //no children
            return;
            
        int bc = biggerChildPos(root, max);
        while((2*root+1 <= max) && greater(bc,root))
        {
            swap(root,bc);
            root = bc;
            bc = biggerChildPos(root, max);
        }
    }
    
    /**
     * @return true if value at pos i greater than value at pos j
     */
    private boolean greater(int i, int j)
    {
        return list.get(i).compareTo(list.get(j)) > 0;
    }
    
    private int biggerChildPos(int root, int max)
    {
        int left = 2*root + 1;
        int right = left + 1;
        
        if(right > max)
            return left;
        if(greater(left,right))
            return left;
        return right;
    }
    
    /**
     * swaps position x with position y
     */
    private void swap(int x, int y)
    {
       E temp;
       temp = list.get(x);
       list.set(x, list.get(y));
       list.set(y, temp);
    }
    
     /** Sort the given list in descending order */ 
    public void sortDescending(List <E> list) 
    {
        this.list = list;
        heapifyDescending(0);

        int last = list.size() - 1;
        while(last > 0)
        {
            swap(0, last);
            last--;
            percDownDescending(0, last);
        }
    }
    
    /**
     * goes down a list swapping it with a lesser value, going in descending order
     */
    private void percDownDescending(int root, int max)
    {
        if((2*root+1) > max)    //no children
            return;
            
        int sc = smallerChildPos(root, max);
        while((2*root+1 <= max) && lesser(sc,root))
        {
            swap(root,sc);
            root = sc;
            sc = smallerChildPos(root, max);
        }
    }
    
    /**
     * @return smaller child of the heap
     */
    private int smallerChildPos(int root, int max)
    {
        int left = 2*root + 1;
        int right = left + 1;
        
        if(right > max)
            return left;
        if(lesser(left,right))
            return left;
        return right;
    }
    
    /**
     * @return true if value at pos i lesser than value at pos j
     */
    private boolean lesser(int i, int j)
    {
        return list.get(i).compareTo(list.get(j)) < 0;
    }
    
    /**
     * heapifies the list, in decending order
     */
    private void heapifyDescending(int root)
    {
        int max = list.size() -1;
        if(root >= max) 
            return;
        heapifyDescending(2*root +1);  //left
        heapifyDescending(2*root +2);  //right
        percDownDescending(root, max);            
    }
}
