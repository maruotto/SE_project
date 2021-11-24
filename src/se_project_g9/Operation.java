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
}
