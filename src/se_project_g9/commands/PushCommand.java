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
public class PushCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;
    private se_project_g9.ComplexNumber n1;

    public PushCommand(PersonalizedStack<ComplexNumber> numberStack, se_project_g9.ComplexNumber n1) {
        assert numberStack != null;
        assert n1 != null;
        this.numberStack = numberStack;
        this.n1 = n1;
    }

    /**
     *
     */
    @Override
    public void execute() {
        n1 = numberStack.push(n1);
    }

    /**
     *
     */
    @Override
    public void undo() {
        if (n1 != null) {
            numberStack.drop();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return n1.toString();
    }

}
