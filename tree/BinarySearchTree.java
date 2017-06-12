package tree;
import list.*;

/**
 * A BinarySearchTree has a value, a left child, and a right child
 * 
 * @author Andrew Blanco
 * @version 10/20/16
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<E extends Comparable> implements BinaryTree<E>
{
    E value;
    BinaryTree<E> left = new EmptyBinarySearchTree<E>();
    BinaryTree<E> right = new EmptyBinarySearchTree<E>();
    
    
    public BinarySearchTree(E value)
    {
        this.value = value;
    }
    
    /**
     * @return an Iterator for this BST
     */
    public Iterator<E> iterator()
    {
        return new TreeIterator<E>(this);
    }
    
    public E getValue()
    {
        return value;
    }
    
    public BinaryTree<E> getLeft()
    {
        return left;
    }
    
    public BinaryTree<E> getRight()
    {
        return right;
    }
    
    public BinaryTree<E> add(E value)
    {
        
        int cmp = value.compareTo(this.value);
        if(cmp < 0)
            left = left.add(value);
        if(cmp > 0)
            right = right.add(value);
        return this;
    }
    
    public E get(E value)
    {
        int cmp = value.compareTo(this.value);
        if(cmp < 0)
            return left.get(value);
        if(cmp > 0)
            return right.get(value);
        return this.value;
    }
    
    public boolean containsKey(E value)
    { 
        BinaryTree<E> comp = this;
        if(comp == null)
        {
            return false;
        }
        
        while(!comp.isEmpty())
        {
            int cmp = value.compareTo(comp.getValue());
            if(cmp == 0)
            {    
                return true;
            }
            if(cmp < 0)
            {
                comp = comp.getLeft();         
            }
            if(cmp > 0)
            {
                comp = comp.getRight(); 
            }
        }
        return false;
        
        /**
        if(cmp < 0)
            return left.containsKey(value);
        if(cmp > 0)
            return right.containsKey(value);
        return true;
        */
    }
    
    /**
     * remove the given value from this BinarySearchTree 
     * @return the updated tree
     */
    public BinaryTree<E> remove(Object obj)
    {
        try
        {
            E value = (E) obj;
            int cmp = value.compareTo(this.value);
            if(cmp == 0) //remove the root
            {
                List<BinaryTree<E>> kids = children();
                if(kids.size() == 0)
                    return new EmptyBinarySearchTree<E>();
                
                if(kids.size() == 1)
                    return kids.get(0);
                    
                //two children
                BinaryTree<E> successor = ((BinarySearchTree) right).smallest();
                //move successor to root
                BinaryTree<E> result = remove(successor.getValue());
                result.setValue(successor.getValue());
                return result; 
            }
            
            if(cmp < 0)
                 left = left.remove(value);
            
            if(cmp > 0)
                right = right.remove(value);
            
        }
        catch(ClassCastException ccp)
        {}
        return this;
    }
    
   //@return a list if tgus v=BT children
   private List<BinaryTree<E>> children()
   {
       List<BinaryTree<E>> result = new ArrayList<BinaryTree<E>>();
       if(!left.isEmpty())
            result.add(left);
       if(!right.isEmpty())
            result.add(right);
       return result;
   }
   
   //@return smallest child
   private BinaryTree<E> smallest()
   {
       if(left.isEmpty())
            return this;
       return ((BinarySearchTree<E>)left).smallest();    
   }
    
   public boolean isEmpty()
   {
       return false;
   }
   
   public void setValue(E value)
   {
       this.value = value;
   }
   
   public void setLeft(BinaryTree<E> left)
   {
       this.left = left;
   }
   
   public void setRight(BinaryTree<E> right)
   {
       this.right = right;
   }
   
   /** @return true only if this BinaryTree is equal to the given obj */
   public boolean equals (Object obj)
   {
       
            
       try
       {
           BinarySearchTree<E> temp = (BinarySearchTree<E>) obj;
       
           if((this.isEmpty() && !temp.isEmpty()) || (!this.isEmpty() && temp.isEmpty()))
                return false;
           
           if(this.isEmpty() && temp.isEmpty())
                return true;
                
           if(this.value.equals(temp.getValue()) && 
           this.left.equals(temp.getLeft()) && 
           this.right.equals(temp.getRight()))
                return true;
           return false;
       }
       catch(ClassCastException e)
       {
            return false;
       }
   }
   
   /** @return the height of this Binary Tree */
   public int getHeight()
   {
       int rightHeight = right.getHeight();
       int leftHeight = left.getHeight();
       
       if(leftHeight > rightHeight)
            return (leftHeight + 1);
       else
            return (rightHeight + 1);
   }
   
   public int size()
   {
       int rightSize = right.size();
       int leftSize = left.size();
       
       return ((rightSize + leftSize) + 1);
   }
   
   public String toString()
   {
       String list = "[";
       int maxSize = size() - 1;
       int size = 0;
       Iterator<E> itty =  iterator();
       while(itty.hasNext())
       {
           if(size < maxSize)
                list = list + itty.next() + "," ;
           else
                list = list +  itty.next();
           size++;
       }
       list = list + "]";
       
       return list;
   }
    
}
