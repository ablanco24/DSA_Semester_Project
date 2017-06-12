package stackDriver;
import stack.*;
import java.util.Scanner;
/**
 * Evaluate postfix expressions
 * Assume that numbers and operators are separated by one space.
 * Assume that the expressions are well-formed.
 * @author (sdb and Andrew Blanco) 
 * @version (Sep 2016)
 */
public class LabPostfix
{
    // read postfix expressions from the keyboard, and evaluate
    public static void postfixEval()
    {   Stack <Integer> stack = new Stack <Integer> ();
        
        // read expression from the keyboard
        Scanner scanner = new Scanner (System.in);
        
        String input;       // store an entire expression
        String [] opInts;   // Each string is an operator or an int.
        int right;           // store right operand
            
        System.out.println ("Enter postfix expressions, or Enter to terminate");
        input = scanner.nextLine();
        while (input.length() > 0)
            {   opInts = input.split (" ");      // An array of Strings, delimiter is space
                char first;
                
                ////////////////  fill in the body of this loop:
                for (String s : opInts)
                    {   // Is the string s a number or operator?
                        // If the first character in the string is a numeric digit,
                        //    then it must be a number.
                        first = s.charAt(0);
                        
                        /**
                        if(Character.isDigit(first)) //get first char in s
                        {
                            int num = Integer.parseInt(s);
                            stack.push(num);
                        }
                        switch(s)
                        {
                            
                            case "+":
                                right = stack.pop();
                                stack.push(right + stack.pop());
                                break;
                            case "-":
                                right = stack.pop();
                                stack.push(right - stack.pop());
                                break;
                            case "*":
                                right = stack.pop();
                                stack.push(right * stack.pop());
                                break;
                            case "/":
                                right = stack.pop();
                                stack.push(right / stack.pop());
                                break;
                            case "%":
                                right = stack.pop();
                                stack.push(right % stack.pop());
                                break;
                            default: 
                                
                                break;
                        }
                        */
                       
                        
                        if(Character.isDigit(first)) //get first char in s
                        {
                            int num = Integer.parseInt(s);
                            stack.push(num);
                        }
                        else if(s.equals("+"))
                        {
                            right = stack.pop();
                            stack.push(right + stack.pop());
                        }
                        else if(s.equals("-"))
                        {
                            right = stack.pop();
                            stack.push(right + stack.pop());
                        }
                        else if(s.equals("*"))
                        {
                            right = stack.pop();
                            stack.push(right * stack.pop());
                        }
                        else if(s.equals("/"))
                        {
                            right = stack.pop();
                            stack.push(stack.pop() / right);
                        }
                        else if(s.equals("%"))
                        {
                            right = stack.pop();
                            stack.push(right % stack.pop());
                        }
                        
                        
                        
                        
                        
                        
                    }       // reached end of an expression
                    if (!stack.isEmpty())
                        System.out.println (stack.peek());
                    stack.clear();
                    
                    input = scanner.nextLine();
                }
            }
                
            
}