/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.EmptyStackException;
import se_project_g9.BasicOperation;
import se_project_g9.ComplexNumber;
import se_project_g9.PersonalizedStack;

/**
 *
 * @author lucia
 */
public class ModCommand implements Command{
    private PersonalizedStack<ComplexNumber> numberStack;
    private se_project_g9.ComplexNumber module; //we could have performed the square operation to make undo, but decimal digits could be problematic

    /**
     * Constructs a new ModCommand
     * @param numberStack the reference PersonalizedStack that contains all the ComplexNumber
     */
    public ModCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    /**
     * Execute of the ModCommand
     * @throws EmptyStackException
     */
    @Override
    public void execute() throws EmptyStackException {
        se_project_g9.ComplexNumber top = numberStack.pop(); //throws empty stackException
        se_project_g9.ComplexNumber mod = BasicOperation.mod(top);
        module = top;
        numberStack.push(mod);
    }

    /**
     * Undo of the ModCommand
     */
    @Override
    public void undo() {
        numberStack.pop();
        numberStack.push(module);
    }

    /**
     * Returns a string representation of ModCommand
     * @return
     */ 
    @Override
    public String toString() {
        return "mod";
    }

}
