/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

/**
 *
 * @author group
 */
public class Operation implements ApplicationOperation{
       
    private NumberStack<Number> numberStack;

    public Operation(){
        this.numberStack = new NumberStack<Number>();
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
    
    protected static Number translate_input(String input){
        //ATTENTION!!!! if you want to add to the regular expression something like
        // the + sign or other things, use the operator |
        // example: if you want to add to this expression +, this will become " *?+"
        
        String[] splittedInput = input.split("\\+");  //regex meaning: + once
        
        double realPart = 0, imaginaryPart = 0, number = 0;
        boolean imaginaryPartNotDone = true, realPartNotDone = true;
        
        for (String s: splittedInput) {
            if(!imaginaryPartNotDone & !realPartNotDone)
                break;
            
            if(s.length() != 0){
                if(imaginaryPartNotDone & ((s.endsWith("i") | s.endsWith("j")))){
                    try {
                        System.out.println(s.substring(0, s.length()));
                        imaginaryPart = Double.parseDouble(s.substring(0, s.length()-1)); 
                        
                        imaginaryPartNotDone = false;
                    }
                    catch(NumberFormatException | NullPointerException e){
                        System.out.println(e);
                    }
                    
                }
                if (realPartNotDone){
                    try {
                        realPart = Double.parseDouble(s);  
                        realPartNotDone = false;
                    }
                    catch(NumberFormatException | NullPointerException e){
                        System.out.println(e);
                        
                    }

                }
            }
                        
        }

        System.out.println(realPart + " + " + imaginaryPart);
        return new Number(realPart, imaginaryPart);
    }
}
