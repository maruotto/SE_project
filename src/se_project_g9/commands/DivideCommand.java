/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.EmptyStackException;
import se_project_g9.BasicOperation;
import se_project_g9.ComplexNumber;
import se_project_g9.PersonalizedStack;
import se_project_g9.exceptions.NotEnoughNumbersException;
import se_project_g9.exceptions.ZeroDivisionException;

/**
 *
 * @author group 9
 */
public class DivideCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;
    private se_project_g9.ComplexNumber n1;
    private se_project_g9.ComplexNumber n2;

    /**
     * Constructs a new DivideCommand
     *
     * @param numberStack the reference PersonalizedStack that contains all the
     * ComplexNumber
     */
    public DivideCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    /**
     * Execute of the DivideCommand
     *
     * @throws ZeroDivisionException
     */
    @Override
    public void execute() throws ZeroDivisionException, NotEnoughNumbersException {
        try {
            n1 = numberStack.pop();
            n2 = numberStack.pop();
            numberStack.push(BasicOperation.divide(n2, n1));
        } catch (EmptyStackException e) {
            throw new NotEnoughNumbersException("Not enough number to perform operation");
        } catch (RuntimeException e) {
            throw new NotEnoughNumbersException("Error in division");
        }
    }

    /**
     * Undo of the DivideCommand
     */
    @Override
    public void undo() {
        numberStack.drop();
        if (n2 != null) {
            numberStack.push(n2);
        }
        if (n1 != null) {
            numberStack.push(n1);
        }
    }

    /**
     * Returns a string representation of DivideCommand
     *
     * @return
     */
    @Override
    public String toString() {
        return "/";
    }
}
