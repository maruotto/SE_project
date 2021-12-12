/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.EmptyStackException;
import java.util.logging.Level;
import java.util.logging.Logger;
import se_project_g9.ComplexNumber;
import se_project_g9.Operation;
import se_project_g9.PersonalizedStack;
import se_project_g9.Variables;
import se_project_g9.BasicOperation;
import se_project_g9.exceptions.InputNumberException;
import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author group 9
 */
public class VAddCommand implements Command {

    private Variables vars;
    private Character key;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber elem;

    /**
     * Constructs a new VAddCommand
     * @param vars the reference Variables that contains the map of all variables
     * @param key the reference Character that represent the label of variable
     * @param stack the reference PersonalizedStack taht contains all the ComplexNumber
     */
    public VAddCommand(Variables vars, Character key, PersonalizedStack<ComplexNumber> stack) {
        this.vars = vars;
        this.key = key;
        this.stack = stack;
    }

    /**
     * Execute of the VAddCommand
     * @throws InputNumberException
     */
    @Override
    public void execute() throws InputNumberException {

        try {
            elem = stack.pop();
            ComplexNumber lastValue = vars.getVariableValue(key);
            vars.setVariableValue(key, BasicOperation.sum(lastValue, elem));

        } catch (NullPointerException ex) {
            throw new NullPointerException("key not specified");
        } catch(EmptyStackException e){
            throw new NotEnoughNumbersException("Stack is empty");
        } catch(RuntimeException e){
            throw new NotEnoughNumbersException("Error in add");
        } catch (Exception ex) {
            throw new NotEnoughNumbersException("Error in add");
        }

    }

    /**
     * Undo of the VAddCommand
     * @throws InputNumberException
     */
    @Override
    public void undo() throws InputNumberException{

        try {
            stack.push(elem);
            vars.setVariableValue(key, BasicOperation.sub(vars.getVariableValue(key), elem));
        } catch (Exception ex) {
            throw new NullPointerException();
        }

    }
    /**
     * Returns a string representation of VAddCommand
     * @return
     */  
    @Override
    public String toString() {
        return "+" + key;
    }

}
