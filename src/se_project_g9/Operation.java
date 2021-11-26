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
    
    protected static Number convert_number(String input){
        
        String[] splittedInput = input.split("\\+|-");  //regex meaning: + once
        
        double realPart = 0, imaginaryPart = 0, number = 0;
        boolean imaginaryPartNotDone = true, realPartNotDone = true;
        
        for (String s: splittedInput) {
            if(!imaginaryPartNotDone & !realPartNotDone)
                break;
            
            if(s.length() != 0){
                if(imaginaryPartNotDone & ((s.endsWith("i") | s.endsWith("j")))){
                    try {
                        int index = input.indexOf(s);
                        //System.out.println(s.substring(0, s.length()));
                        
                        imaginaryPart = Double.parseDouble(s.substring(0, s.length()-1)); 
                        if (index !=0)
                            if (Character.compare(input.charAt(index-1), '-')==0 ||
                                    (Character.compare(input.charAt(index-1), ' ')==0 && Character.compare(input.charAt(index-2), '-')==0)){
                                imaginaryPart = -imaginaryPart;
                            }
                                
                                    
                        imaginaryPartNotDone = false;
                    }
                    catch(NumberFormatException | NullPointerException e){
                        System.out.println(e);
                        
                    }
                    
                }
                if (realPartNotDone){
                    try {
                        realPart = Double.parseDouble(s);
                        if (Character.compare(input.charAt(0), '-')==0)
                            realPart = -realPart;                            
                        realPartNotDone = false;
                    }
                    catch(NumberFormatException | NullPointerException e){
                        System.out.println(e);
                        
                    }

                }
            }
                        
        }
        
        return new Number(realPart, imaginaryPart);
        
    }
}
