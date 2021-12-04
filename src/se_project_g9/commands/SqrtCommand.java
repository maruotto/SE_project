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

/**
 *
 * @author idamaruotto
 */
public class SqrtCommand implements Command {

    private PersonalizedStack<ComplexNumber> numberStack;
    private se_project_g9.ComplexNumber square; //we could have performed the square operation to make undo, but decimal digits could be problematic

    public SqrtCommand(PersonalizedStack<ComplexNumber> numberStack) {
        assert numberStack != null;
        this.numberStack = numberStack;
    }

    @Override
    public void execute() throws EmptyStackException {
        se_project_g9.ComplexNumber top = numberStack.pop(); //throws empty stackException
        se_project_g9.ComplexNumber sqrt = BasicOperation.sqrt(top);
        square = top;
        numberStack.push(sqrt);
    }

    @Override
    public void undo() {
        numberStack.pop();
        numberStack.push(square);
    }

    @Override
    public String toString() {
        return "sqrt";
    }

}
