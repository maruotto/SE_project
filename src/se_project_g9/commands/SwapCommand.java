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
public class SwapCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;

    /**
     * Constructs a new SwapCommand
     * @param numberStack the reference PersonalizedStack taht contains all the ComplexNumber
     */
    public SwapCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    /**
     * Execute of the SwapCommand
     * @throws NotEnoughNumbersException
     */
    @Override
    public void execute() throws NotEnoughNumbersException {
        numberStack.swap();
    }

    /**
     * Undo of the SwapCommand
     * @throws NotEnoughNumbersException
     */
    @Override
    public void undo() throws NotEnoughNumbersException {
        numberStack.swap();
    }

    /**
     * Returns a string representation of SwapCommand
     * @return
     */  
    @Override
    public String toString() {
        return "swap";
    }

}
