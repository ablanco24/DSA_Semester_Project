package tree;


/**
 * Write a description of class Variable here.
 * 
 * @author Andrew Blanco
 * @version 11/3/16
 */
public class Variable extends Expr
{
    char name; 
    int value;
    boolean set = false;
    public Variable(char name)
    {
        this.name = name;
    }
    
    public boolean equals(Object obj)
    {
        
         if(!(obj instanceof Variable))
            return false;
         Variable v = (Variable) obj;
         return (v.name == this.name);
    }
   
    /**
     * @throw IllegalArgumentException()
     */
    public int eval()
    {
        if(!set)
            throw new IllegalArgumentException();
        return value;
        
    }
    
    public void setValue(int value)
    {
        this.value = value;
        set = true;
    }
    
    public Expr simplify()
    {
        return this;
    }
    
    public String toString()
    {
        return "" + name;
    }
    
    
}
