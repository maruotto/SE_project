/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import se_project_g9.ComplexNumber;
import se_project_g9.PersonalizedStack;
import se_project_g9.Variables;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author luigi
 */
public class VInsertCommand implements Command{
    
    private PersonalizedStack<ComplexNumber> stack;
    private Character key;
    private ComplexNumber elem;
    private Variables vars;
    
    
    public VInsertCommand(Variables vars,PersonalizedStack<ComplexNumber> stack,Character key){
        this.vars = vars;
        this.stack = stack;
        this.key = key;
    }
    

    @Override
    public void execute() throws InputNumberException {
        
        elem = stack.pop();
        try {
            vars.setVariableValue(key, elem);
        } catch (Exception ex) {
            Logger.getLogger(VInsertCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    @Override
    public void undo() throws InputNumberException {
        stack.push(elem);
        vars.getVariablesMap().remove(key);
       
        
    }
    
}
