/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.EmptyStackException;
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
public class VInsertCommand implements Command {

    private PersonalizedStack<ComplexNumber> stack;
    private Character key;
    private ComplexNumber elem;
    private Variables vars;
    private ComplexNumber old;

    public VInsertCommand(Variables vars, PersonalizedStack<ComplexNumber> stack, Character key) {
        this.vars = vars;
        this.stack = stack;
        this.key = key;
    }

    @Override
    public void execute() throws InputNumberException {

        try {
            elem = stack.pop();
            if (vars.getVariablesMap().containsKey(key)) {
                old = vars.getVariableValue(key);
            } else {
                old = null;
            }

            vars.setVariableValue(key, elem);

        } catch (NullPointerException ex) {
            throw new NullPointerException("value to add not defined..");
        } catch (Exception ex) {
            throw new InputNumberException("Empty stack");
        }

    }

    @Override
    public void undo() throws InputNumberException {
        stack.push(elem);
        if (old == null) {
            vars.getVariablesMap().remove(key);
        } else {
            try {
                vars.setVariableValue(key, old);
            } catch (Exception ex) {
                throw new InputNumberException("Impossible undo");
            }
        }

    }

    @Override
    public String toString() {
        return ">" + key;
    }
}
