package tree;


/**
 * 
 * 
 * @author Andrew Blanco
 * @version (a version number or a date)
 */
public class Sum extends Expr
{
    public Sum(Expr left, Expr right)
    {
        super(left,right);
    }
    
    public Expr simplify()
    {
        left = left.simplify();
        right = right.simplify();
        if(right instanceof Constant && right.eval() == 0)
            return left;  //x + 0 = x
        if(left instanceof Constant && left.eval() == 0)
            return right; //0 + x = x
        return this;
    }
    
    public int eval()
    {
        return left.eval() + right.eval();
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Sum))
            return false;
        Sum s = (Sum) obj;
        return (left.equals(s.left) && right.equals(s.right)) || 
                                        (left.equals(s.right) && right.equals(s.left));

    }
    
    public String toString()
    {
        return ("(" + left.toString() + "+" + right.toString() + ")");
    }
}
