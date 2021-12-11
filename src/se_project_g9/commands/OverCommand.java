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

    public OverCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    @Override
    public void execute() throws NotEnoughNumbersException {
        numberStack.over();
    }

    @Override
    public void undo() {
        numberStack.drop();
    }

    @Override
    public String toString() {
        return "over";
    }

}
