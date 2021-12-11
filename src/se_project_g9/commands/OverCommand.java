/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.ComplexNumber;
import se_project_g9.PersonalizedStack;
import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author group 9
 */
public class OverCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;

    /**
     * Constructs a new OverCommand
     * @param numberStack the reference PersonalizedStack that contains all the ComplexNumber
     */
    public OverCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    /**
     * Execute of the OverCommand
     * @throws NotEnoughNumbersException
     */
    @Override
    public void execute() throws NotEnoughNumbersException {
        numberStack.over();
    }

    /**
     * Undo of the OverCommand
     */
    @Override
    public void undo() {
        numberStack.drop();
    }

    /**
     * Returns a string representation of OverCommand
     * @return
     */ 
    @Override
    public String toString() {
        return "over";
    }

}
