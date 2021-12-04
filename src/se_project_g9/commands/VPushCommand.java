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
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author luigi
 */
public class VPushCommand implements Command {

    private Character key;
    private PersonalizedStack<ComplexNumber> stack;
    private Variables vars;

    public VPushCommand(Variables vars, Character key, PersonalizedStack<ComplexNumber> stack) {

        this.vars = vars;
        this.key = key;
        this.stack = stack;

    }

    @Override
    public void execute() throws InputNumberException {

        try {

            //vedere se deve essere controllato se appartiene all'alfabeto
            stack.push(vars.getVariableValue(key));
        } catch (Exception ex) {
            throw new NullPointerException("value to push not defined");
        }
    }

    @Override
    public void undo() throws InputNumberException {
        stack.pop();

    }

    @Override
    public String toString() {
        return "<" + key;
    }
}
