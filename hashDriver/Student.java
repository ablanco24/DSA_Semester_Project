package hashDriver;


/**
 * Write a description of class Student here.
 * 
 * @author Andrew Blanco
 * @version 11/17/16
 */
public class Student<E>
{
   String name, id;
   int credits;
   HomeTown<E> home = new HomeTown<E>();
   public Student(String name, String id, int credits, HomeTown<E> home)
   {
       this.name = name;
       this.id = id;
       this.credits = credits;
       this.home = home;
   }
   
   /**
    * @return true when the names, credits, and homes are all equal between two students
    */
   public boolean equals(Object obj)
   {
       if(obj instanceof Student)
       {
           Student student = (Student) obj;
           return ((student.credits == credits) && (student.name.equals(name))
                                                                          && student.home.equals(home));
       }
       return false;
       
   }
   
   public int hashCode()
   {
       int code = 17;
       code = code * 31 + credits;
       code = code * 31 + home.hashCode();
       code = code * 31 + name.hashCode();
       return code;
   }
   
   public String toString()
   {
       return (name + "(" + id + ") " + credits + " cr " + home);
   }
}
