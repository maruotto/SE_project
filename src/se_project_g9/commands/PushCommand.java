/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.ComplexNumber;
import se_project_g9.PersonalizedStack;

/**
 *
 * @author group 9
 */
public class PushCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;
    private se_project_g9.ComplexNumber n1;

    /**
     * Constructs a new PushCommand
     * @param numberStack the reference PersonalizedStack that contains all the ComplexNumber
     * @param n1 the reference ComplexNumber that contains the ComplexNumber to push in the Stack
     */
    public PushCommand(PersonalizedStack<ComplexNumber> numberStack, se_project_g9.ComplexNumber n1) {
        assert numberStack != null;
        assert n1 != null;
        this.numberStack = numberStack;
        this.n1 = n1;
    }

    /**
     * Execute of the PushCommand
     */
    @Override
    public void execute() {
        n1 = numberStack.push(n1);
    }

    /**
     * Undo of the PushCommand
     */
    @Override
    public void undo() {
        if (n1 != null) {
            numberStack.drop();
        }
    }

    /**
     * Returns a string representation of PushCommand
     * @return
     */ 
    @Override
    public String toString() {
        return n1.toString();
    }

}
