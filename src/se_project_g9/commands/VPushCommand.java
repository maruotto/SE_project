/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import se_project_g9.ComplexNumber;
import se_project_g9.Operation;
import se_project_g9.PersonalizedStack;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author luigi
 */
public class VPushCommand implements Command{
    
    private Operation ope;
    private Character key;
    private PersonalizedStack<ComplexNumber> stack;
    
    
    public VPushCommand(Operation ope,Character key,PersonalizedStack<ComplexNumber> stack){
        
        this.ope = ope;
        this.key = key;
        this.stack = stack;
        
    }
    
    
    @Override
    public void execute() throws InputNumberException {
        
        try {
            ope.pushValueOf(key);
        } catch (Exception ex) {
            Logger.getLogger(VPushCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void undo() throws InputNumberException {
        stack.pop();
        
    }
    
}
