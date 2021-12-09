/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.ArrayList;
import java.util.Iterator;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author group 9
 */
public class UDOperation<Command> extends ArrayList<Command>{

    static private Interpreter i;

    @Override
    public synchronized Iterator<Command> iterator() {
        return super.iterator();//To change body of generated methods, choose Tools | Templates.
    }

    public synchronized Iterator<Command> reverseIterator() {

        return new ReverseIterator<Command>(this);
    }

    public UDOperation() {
        super();
    }

    public UDOperation(String input) throws InputNumberException {
        super();
        String[] splittedInput = input.split(" +");
        for (String s : splittedInput) {
            if (s.length() > 0) {
                this.add((Command) i.translateInput(s, true)); //if exception thrown the execution is blocked
            }
        }
    }
    
    public UDOperation(String input, Interpreter in) throws InputNumberException {
        super();
        String[] splittedInput = input.split(" +");
        for (String s : splittedInput) {
            if (s.length() > 0) {
                this.add((Command) in.translateInput(s, true)); //if exception thrown the execution is blocked
            }
        }
    }

    public static void addInterpreter(Interpreter i) {
        UDOperation.i = i;
    }

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
