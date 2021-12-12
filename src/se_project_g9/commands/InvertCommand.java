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
public class InvertCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;
    private se_project_g9.ComplexNumber n1;

    /**
     * Constructs a new InvertCommand
     * @param numberStack the reference PersonalizedStack that contains all the ComplexNumber
     */
    public InvertCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    /**
     * Execute of the InvertCommand
     * @throws NotEnoughNumbersException
     */
    @Override
    public void execute() throws NotEnoughNumbersException {
        try{
            n1 = numberStack.pop();
            numberStack.push(BasicOperation.invert(n1));
        }  catch (EmptyStackException e) {
            throw new NotEnoughNumbersException("Not enough number to perform operation");
        } catch (RuntimeException e) {
            throw new NotEnoughNumbersException("Error in invert number");
        }
    }

    /**
     * Undo of the InvertCommand
     */
    @Override
    public void undo() {
        if (n1 != null) {
            numberStack.drop();
            numberStack.push(n1);
        }
    }

    /**
     * Returns a string representation of InvertCommand
     * @return
     */ 
    @Override
    public String toString() {
        return "invert";
    }

}
