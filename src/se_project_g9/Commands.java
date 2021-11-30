/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.EmptyStackException;
import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author group 9
 */
public class Commands {

    public class SumCommand implements Command {
        private NumberStack<Number> numberStack;
        private Number n1;
        private Number n2;

        public SumCommand(NumberStack<Number> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
        }

        @Override
        public void execute() {
            n1 = numberStack.pop(); //throws EmptyStackException

            try {
                n2 = numberStack.pop();
            } catch (EmptyStackException e) {
                numberStack.push(n1);
                //throw new NotEnoughNumbersException();
            }
            numberStack.push(BasicOperation.sum(n2, n1));
        }

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
    }
}
