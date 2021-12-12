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
import se_project_g9.exceptions.CalculatorException;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author group 9
 */
public class VPushCommand implements Command {

    private Character key;
    private PersonalizedStack<ComplexNumber> stack;
    private Variables vars;

    /**
     * Constructs a new VPushCommand
     * @param vars the reference Variables that contains the map of all variables
     * @param key the reference Character that represent the label of variable
     * @param stack the reference PersonalizedStack taht contains all the ComplexNumber
     */
    public VPushCommand(Variables vars, Character key, PersonalizedStack<ComplexNumber> stack) {
        assert vars != null;
        assert stack != null;
        assert key != null;
        this.vars = vars;
        this.key = key;
        this.stack = stack;
    }
    
    /**
     * Execute of the VPushCommand
     * @throws CalculatorException
     */
    @Override
    public void execute() throws CalculatorException {
        try {
            //vedere se deve essere controllato se appartiene all'alfabeto
            stack.push(vars.getVariableValue(key));
        } catch (Exception ex) {
            throw new CalculatorException("variable to push not defined");
        }
    }
    
    /**
     * Undo of the VPushCommand
     * @throws InputNumberException
     */
    @Override
    public void undo() throws InputNumberException {
        stack.pop();
    }

    /**
     * Returns a string representation of VPushCommand
     * @return
     */
    @Override
    public String toString() {
        return "<" + key;
    }
}
