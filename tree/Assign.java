package tree;


/**
 * Write a description of class Assign here.
 * 
 * @author Andrew Blanco
 * @version 11/4/16
 */
public class Assign<E> extends Expr
{
    Variable left;
    public Assign(Expr left, Expr right)
    {
        this.left = (Variable) left;
        this.right = right;
    }
    
    public Expr simplify()
    {   
        return this;
    }
    
    public int eval()
    {
        int temp = right.eval();
        left.setValue(temp);
        return temp;
    }
    
    public boolean equals(Object obj)
    {
        return false;
    }
    
    public String toString()
    {
        return ("(" + left + "=" + right + ")");
    }
    
}
