package tree;


/**
 * Write a description of class Quotient here.
 * 
 * @author Andrew Blanco 
 * @version 11/2/16
 */
public class Quotient extends Expr
{
   public Quotient(Expr left, Expr right)
   {
       super(left, right);
   }
   
   public Expr simplify()
   {
        left = left.simplify();
        right = right.simplify();
        if(right instanceof Constant && right.eval() == 0)
             return null;  //x / 0 = DNE
        if(left instanceof Constant && left.eval() == 0)
            return left; //0 / x = 0
        if(left.equals(right))
            return new Constant(1); //x / x = 1
        if(left instanceof Product && left.right.equals(right))
            return left.left;
        if(left instanceof Product && left.left.equals(right))
            return left.right;
        return this;
   }
   
   public int eval()
   {
       return left.eval() / right.eval();
   }
   
   public boolean equals(Object obj)
   {
       if(!(obj instanceof Quotient))
           return false;
       Quotient q = (Quotient) obj;
       return (left.equals(q.left) && right.equals(q.right));

   }
   
   public String toString()
   {
       return ("(" + left.toString() + "/" + right.toString()) + ")"; 
   }
}
