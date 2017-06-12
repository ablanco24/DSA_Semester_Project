package tree;


/**
 * Write a description of class Mod here.
 * 
 * @author Andrew Blanco    
 * @version 11/3   /16
 */
public class Mod extends Expr
{
   public Mod(Expr left, Expr right)
   {
       super(left, right);
   }
   
   public Expr simplify()
   {
     
       left = left.simplify();
       right = right.simplify();
       
       if(right instanceof Constant && right.eval() == 0)
            return null;  //x % 0 = DNE
       if(left instanceof Constant && left.eval() == 0)
            return left;  //0 % x = 0
       if(left.equals(right))
            return new Constant(0);
       return this;
       
   }
   
   public int eval()
   {
       return left.eval() % right.eval();
   }
   
   public boolean equals(Object obj)
   {
       if(!(obj instanceof Mod))
           return false;
       Mod m = (Mod) obj;
       return (left.equals(m.left) && right.equals(m.right));

   }
   
  public String toString()
   {
       return ("(" + left.toString() + "%" + right.toString()) + ")"; 
   }
}
