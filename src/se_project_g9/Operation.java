/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.EmptyStackException;

/**
 *
 * @author group
 */
public class Operation implements ApplicationOperation{
       
    private final NumberStack<Number> numberStack;

    public Operation(){
        this.numberStack = new NumberStack<>();
    }

    protected PersonalizedStack<Number> getNumberStack() {
        return numberStack;
    }
    
    public boolean pushStack(Number n){
        return numberStack.push(n) != null;      
    }
    
    public Number popStack() throws EmptyStackException{
        return numberStack.pop();      
    }
    
    public void invert(){
        Number n1 = numberStack.pop();      
        BasicOperation.invert(n1);
        numberStack.push(n1);
    }
    
    public void multiply () {       
       Number n1 = numberStack.pop();
       Number n2 = numberStack.pop();
       Number n3 = BasicOperation.multiply(n1, n2);
       numberStack.push(n3);
    }
    
    public void sqrt(){
        
        Number top = numberStack.pop();
        Number sqrt = BasicOperation.sqrt(top);
        numberStack.push(sqrt);   
    }
    
    public void sum(){
        Number n1 = numberStack.pop();      
        Number n2 = numberStack.pop();
        Number n3 = BasicOperation.sum(n1, n2);
        numberStack.push(n3);
    }
    
    public void sub(){
        Number n1 = numberStack.pop();
        Number n2 = numberStack.pop();
        Number n3 = BasicOperation.sub(n1, n2);
        numberStack.push(n3);
    }
    
    public void divide() throws Exception{
        Number n1 = numberStack.pop();
        Number n2 = numberStack.pop();
        Number n3 = BasicOperation.divide(n1, n2);
        numberStack.push(n3);   
    }
    
    public void clear(){
        numberStack.clear();   
    }
      
    
    protected void translate_input(String input) throws Exception{
        //ATTENTION!!!! if you want to add to the regular expression something like
        // the + sign or other things, use the operator |
        // example: if you want to add to this expression +, this will become " *?+"
        if(input.length() == 1 && !Character.isLetterOrDigit(input.charAt(0))){
            switch (input){
                case "-": 
                    sub();
                    break;
                          
                case "+": 
                    sum();
                    break;
                
                case "*": 
                    multiply();
                    break;
                case "/": 
                    divide();
                    break;
                default: throw new Exception("single charcter operation not supported");
            }
            //find operation
        }else if(Character.isAlphabetic(input.charAt(0))){
            //is a function
            switch (input){
                case "invert": 
                    invert();
                    break;
                case "sqrt": 
                    sqrt();
                    break;
                case "clear": 
                    clear();
                    break;
                default: throw new Exception("litteral expression not supported");
            }
            
        }else{
            numberStack.push(convert_number(input));
        }
        
        
            
    }
    
    protected static Number convert_number(String input) throws Exception{
        
        String[] splittedInput = input.split("\\+|-");  //regex meaning: + once
        /*System.out.println(splittedInput.length);
        
        for (int i = 0; i< splittedInput.length; i++)
                System.out.println(i + "->"+ splittedInput[i]);*/
                
        if (input.length() == 0 || splittedInput.length > 3 || splittedInput.length == 0)
            throw new Exception("wrong input");
        
        double realPart = 0, imaginaryPart = 0;
        boolean imaginaryPartNotDone = true, realPartNotDone = true;
        
        for (String s: splittedInput) {
            System.out.println("a" + s);
            if(!imaginaryPartNotDone & !realPartNotDone)
                throw new Exception("more input");
            
            if(s.length() != 0){
                System.out.println("a" + s);
                if(((s.endsWith("i") | s.endsWith("j")))){
                    if(!imaginaryPartNotDone)
                        throw new Exception("more input");
                    int index = input.indexOf(s);
                    //System.out.println(s.substring(0, s.length()));

                    if(s.length() == 1)
                        imaginaryPart = 1; 
                    else imaginaryPart = Double.parseDouble(s.substring(0, s.length()-1)); //can throws NullPointerException or NumberFormatException
                    if (index !=0)
                        if (Character.compare(input.charAt(index-1), '-')==0 ||
                                (Character.compare(input.charAt(index-1), ' ')==0 && Character.compare(input.charAt(index-2), '-')==0)){
                            imaginaryPart = -imaginaryPart;
                        }


                    imaginaryPartNotDone = false;                  
                }
                else{
                        if(!realPartNotDone)
                            throw new Exception("more input");
                        int index = input.indexOf(s);
                        realPart = Double.parseDouble(s); //can throws NullPointerException or NumberFormatException
                        if (Character.compare(input.charAt(index == 0 ? 0: index-1), '-')==0)
                            realPart = -realPart;                            
                        realPartNotDone = false;
                    

                }
            }
                        
        }
        Number n = new Number(realPart, imaginaryPart);
        System.out.println(n);
        return n;
        
    }
}
