/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.EmptyStackException;
import se_project_g9.ComplexNumber;
import se_project_g9.NumberStack;
import se_project_g9.PersonalizedStack;
import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author group 9
 */
public class DupCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;

    /**
     * Constructs a new DupCommand
     * @param numberStack the reference PersonalizedStack that contains all the ComplexNumber
     */
    public DupCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    /**
     * Execute of the DupCommand
     * @throws NotEnoughNumbersException
     */
    @Override
    public void execute() throws NotEnoughNumbersException{
        try{
            numberStack.dup();
        } catch (EmptyStackException e) {
            throw new NotEnoughNumbersException("Not enough number to perform operation");
        } catch (RuntimeException e) {
            throw new NotEnoughNumbersException("Error in duplicating the elements");
        }
    }

    /**
     * Undo of the DupCommand
     */
    @Override
    public void undo() {
        numberStack.drop();
    }

    /**
     * Returns a string representation of DupCommand
     * @return
     */ 
    @Override
    public String toString() {
        return "dup";
    }

}
