/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.EmptyStackException;
import se_project_g9.BasicOperation;
import se_project_g9.ComplexNumber;
import se_project_g9.NumberStack;
import se_project_g9.PersonalizedStack;
import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author group 9
 */
public class SqrtCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;
    private se_project_g9.ComplexNumber square; //we could have performed the square operation to make undo, but decimal digits could be problematic

    /**
     * Constructs a new SqrtCommand
     *
     * @param numberStack the reference PersonalizedStack taht contains all the
     * ComplexNumber
     */
    public SqrtCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    /**
     * Execute of the SqrtCommand
     *
     * @throws EmptyStackException
     */
    @Override
    public void execute() throws NotEnoughNumbersException {
        try {
            se_project_g9.ComplexNumber top = numberStack.pop(); //throws empty stackException
            se_project_g9.ComplexNumber sqrt = BasicOperation.sqrt(top);
            square = top;
            numberStack.push(sqrt);
        } catch (EmptyStackException e) {
            throw new NotEnoughNumbersException("Not enough number to perform operation");
        } catch (RuntimeException e) {
            throw new NotEnoughNumbersException("Error in square root");
        }
    }

    /**
     * Undo of the SqrtCommand
     */
    @Override
    public void undo() {
        numberStack.pop();
        numberStack.push(square);
    }

    /**
     * Returns a string representation of SqrtCommand
     *
     * @return
     */
    @Override
    public String toString() {
        return "sqrt";
    }

}
