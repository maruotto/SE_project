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

/**
 *
 * @author group 9
 */
public class SubCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;
    private ComplexNumber n1;
    private ComplexNumber n2;

    /**
     * Constructs a new SubCommand
     * @param numberStack the reference PersonalizedStack taht contains all the ComplexNumber
     */
    public SubCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    /**
     * Execute of the SubCommand
     */
    @Override
    public void execute() throws NotEnoughNumbersException {
        try{ n1 = numberStack.pop();
        n2 = numberStack.pop();
        numberStack.push(BasicOperation.sub(n2, n1));
        } catch (EmptyStackException e) {
            throw new NotEnoughNumbersException("Not enough number to perform operation");
        } catch (RuntimeException e) {
            throw new NotEnoughNumbersException("Error in subtracting to a variable");
        }
    }

    /**
     * Undo of the SubCommand
     */
    @Override
    public void undo() {
        numberStack.pop();
        if (n2 != null) {
            numberStack.push(n2);
        }
        if (n1 != null) {
            numberStack.push(n1);
        }
    }

    /**
     * Returns a string representation of SubCommand
     * @return
     */ 
    @Override
    public String toString() {
        return "-";
    }

}
