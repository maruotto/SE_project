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
import se_project_g9.BasicOperation;

/**
 *
 * @author luigi
 */
public class VSubCommand implements Command {

    private Variables vars;
    private Character key;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber elem;

    public VSubCommand(Variables vars, Character key, PersonalizedStack<ComplexNumber> stack) {
        this.vars = vars;
        this.key = key;
        this.stack = stack;
    }

    @Override
    public void execute() throws InputNumberException {

        try {
            elem = stack.pop();
            ComplexNumber lastValue = vars.getVariableValue(key);
            vars.setVariableValue(key, BasicOperation.sub(lastValue, elem));

        } catch (NullPointerException ex) {
            throw new NullPointerException("key not specified");
        } catch (Exception ex) {
            throw new EmptyStackException();
        }

    }

    @Override
    public void undo() throws InputNumberException {
        try {
            stack.push(elem);
            vars.setVariableValue(key, BasicOperation.sum(vars.getVariableValue(key), elem));
        } catch (Exception ex) {
            throw new NullPointerException();
        }
    }

    @Override
    public String toString() {
        return "-" + key;
    }
}
