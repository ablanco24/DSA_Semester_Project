package tree;
import list.Iterator;

/**
 * Binary Trees have values and no more than 2 children
 * 
 * @author Andrew Blanco
 * @version 10/21
 */
public interface BinaryTree<E>
{
    
   Iterator<E> iterator();
   
   /**
    * @return the value of this BinaryTree,
    * or null if empty
    */
   E getValue();
   
   /**
    * @return the left child of this BinaryTree, 
    * or null if empty
    */
   BinaryTree<E> getLeft();
   
   /**
    * @return the right child of this BinaryTree,
    * or null if empty
    */
   BinaryTree<E> getRight();
   
   /**
    * Add the given value to the family of this BinaryTree.
    * @return a ref to the updated tree
    */
   BinaryTree<E> add(E value);
   
   /**
    * search the family of this BinaryTree for the given value. 
    * @return it's value if found, or null if not found
    */
   E get(E value);
   
   /**
    * @return true if given value is in the family of this BinaryTree
    */
   boolean containsKey(E value);
   
   /**
    * Remove the given obj from this BinaryTree, if possible
    * @return the updated BinaryTree
    */
   BinaryTree<E> remove(Object obj);
   
   /** @return true if this BinaryTree is empty */
   boolean isEmpty();

   /**  Change the value of this BinaryTree to the given value */
   void setValue (E value);

   /** Change the left child of this BinaryTree to the given BinaryTree */
   void setLeft (BinaryTree <E> left);

   /** Change the right child of this BinaryTree to the given BinaryTree */
   void setRight (BinaryTree <E> right);
   
   /** @return true only if this BinaryTree is equal to the given obj */
   boolean equals (Object obj);
   
   /** @return the height of this Binary Tree */
   public int getHeight();
   
   /** @return the number of BinarySearchTrees in the family of this BinaryTree */
   int size();
   
   String toString();
}
