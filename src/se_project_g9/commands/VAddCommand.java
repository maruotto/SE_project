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
import se_project_g9.Variables;
import se_project_g9.BasicOperation;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author luigi
 */
public class VAddCommand implements Command{
    
    private Variables vars;
    private Character key;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber elem;
    
 
    public VAddCommand(Variables vars,Character key,PersonalizedStack<ComplexNumber> stack){
        this.vars = vars;
        this.key = key;
        this.stack = stack;
    }

    @Override
    public void execute() throws InputNumberException {
        
        elem = stack.pop();
        try {
            vars.setVariableValue(key, BasicOperation.sum(vars.getVariableValue(key),elem));
        } catch (Exception ex) {
            Logger.getLogger(VAddCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void undo() throws InputNumberException {
        
        stack.push(elem);
        try {
            vars.setVariableValue(key,BasicOperation.sub(vars.getVariableValue(key), elem));
        } catch (Exception ex) {
            Logger.getLogger(VAddCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}
