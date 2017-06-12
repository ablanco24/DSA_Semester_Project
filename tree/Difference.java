package tree;


/**
 * Write a description of class Difference here.
 * 
 * @author Andrew Blanco
 * @version 11/2/16
 */
public class Difference extends Expr
{
    public Difference(Expr left, Expr right)
    {
        super(left,right);
    }
    
    public Expr simplify()
    {
        left = left.simplify();
        right = right.simplify();
        
        if(right instanceof Constant && right.eval() == 0)
            return left; //x - 0 = x
        if(left.equals(right))
            return new Constant(0);
      //  if(left instanceof Constant && left.eval() == 0)
        //    return (right * -1); //0 - x = -x
        return this;
    }
    
    public int eval()
    {
        return left.eval() - right.eval();
    }
    
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Difference))
            return false;
        Difference d = (Difference) obj;
        return (left.equals(d.left) && right.equals(d.right));
    }
    
    public String toString()
    {
        return ("(" + left.toString() + "-" + right.toString() + ")");
    }
}
