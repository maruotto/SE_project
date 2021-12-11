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
public class DropCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;
    private se_project_g9.ComplexNumber n1;

    /**
     * Constructs a new DropCommand
     * @param numberStack the reference PersonalizedStack that contains all the ComplexNumber
     */
    public DropCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    /**
     * Execute of the DropCommand
     * @throws NotEnoughNumbersException
     */
    @Override
    public void execute() {
        n1 = numberStack.peek();
        numberStack.drop();
    }

    /**
     * Undo of the DropCommand
     */
    @Override
    public void undo() {
        if (n1 != null) {
            numberStack.push(n1);
        }
    }

    /**
     * Returns a string representation of DropCommand
     * @return
     */ 
    @Override
    public String toString() {
        return "drop";
    }

}
