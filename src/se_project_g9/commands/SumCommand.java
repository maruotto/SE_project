/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.BasicOperation;
import se_project_g9.ComplexNumber;
import se_project_g9.PersonalizedStack;

/**
 *
 * @author group 9
 */
public class SumCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;
    private se_project_g9.ComplexNumber n1;
    private se_project_g9.ComplexNumber n2;

    /**
     * Constructs a new SumCommand
     * @param numberStack the reference PersonalizedStack taht contains all the ComplexNumber
     */
    public SumCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    /**
     * Execute of the SumCommand
     */
    @Override
    public void execute() {
        n1 = numberStack.pop();
        n2 = numberStack.pop();
        numberStack.push(BasicOperation.sum(n2, n1));
    }

    /**
     * Undo of the SumCommand
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
     * Returns a string representation of SumCommand
     * @return
     */ 
    @Override
    public String toString() {
        return "+";
    }

}
