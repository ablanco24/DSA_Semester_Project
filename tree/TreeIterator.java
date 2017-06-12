package tree;
import list.Iterator;
import queue.*;
/**
 * InOrder Traversal
 * 
 * @author Andrew Blanco
 * @version 10/28
 */
public class TreeIterator<E> implements Iterator<E>
{
   BinaryTree<E> tree;
   QueueADT<E> queue = new Queue<E>();
   E lastGotten; //last value 
   public TreeIterator(BinaryTree<E> tree)
   {
       this.tree = tree;
       buildQ(tree);
   }
   
   //Build the queue with an InOrder traversal
   private void buildQ(BinaryTree<E> tree)
   {
       if(tree.isEmpty())
            return;
       buildQ(tree.getLeft());
       queue.add(tree.getValue());
       buildQ(tree.getRight());
   }
   
   public boolean hasNext()
   {
       return !(queue.isEmpty());
   }
   
   public E next()
   {
       lastGotten = queue.peek();
       return queue.remove();
   }
   
   public void remove()
   {
       tree = tree.remove(lastGotten);
   }
   
   public boolean hasTwoMore()
   {
       return !(queue.isEmpty());
   }
   
   public E getLastGotten()
   {
       return lastGotten;
   }

}
