/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.ArrayList;
import java.util.Iterator;
import se_project_g9.exceptions.CalculatorException;

/**
 *
 * @author group 9
 * @param <Command>
 */
public class UDOperation<Command> extends ArrayList<Command> {

    /**
     *
     * @return the iterator of UDOperation
     */
    @Override
    public synchronized Iterator<Command> iterator() {
        return super.iterator();//To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return the backward iterator of UDOperation
     */
    public synchronized Iterator<Command> reverseIterator() {

        return new ReverseIterator<>(this);
    }

    /**
     * constructor of class UDOperation
     */
    public UDOperation() {
        super();
    }

    /**
     * constructor of class UDOperator, using the interpreter that should be
     * setted with addInterpreter method, it translate the string input into a
     * sequence of operations and return the respective object
     *
     * @param input the string that will be translated
     * @throws CalculatorException
     */
    public UDOperation(String input) throws CalculatorException {
        super();
        String[] splittedInput = input.split(" +");
        for (String s : splittedInput) {
            if (s.length() > 0) {
                this.add((Command) Interpreter.translateInput(s, true)); //if exception thrown the execution is blocked
            }
        }
    }

    /**
     * constructor of class UDOperator, using the interpreter in, it translate
     * the string input into a sequence of operations and return the respective
     * object
     *
     * @param input the string that will be translated
     * @param in the interpreter that should be used to translate the input
     * @throws CalculatorException
     */
    public UDOperation(String input, Interpreter in) throws CalculatorException {
        super();
        String[] splittedInput = input.split(" +");
        for (String s : splittedInput) {
            if (s.length() > 0) {
                this.add((Command) Interpreter.translateInput(s, true)); //if exception thrown the execution is blocked
            }
        }
    }


    /**
     *
     * @return string representation of this command
     */
    @Override
    public String toString() {
        String s = "";
        for (Command c : this) {
            s += c.toString();
            s += " ";
        }
        return s;
    }

}
