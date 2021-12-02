/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.BasicOperation;
import se_project_g9.Command;
import se_project_g9.NumberStack;
import se_project_g9.exceptions.ZeroDivisionException;

/**
 *
 * @author idamaruotto
 */
public class DivideCommand implements Command {
        private NumberStack<se_project_g9.ComplexNumber> numberStack;
        private se_project_g9.ComplexNumber n1;
        private se_project_g9.ComplexNumber n2;

        public DivideCommand(NumberStack<se_project_g9.ComplexNumber> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
        }

        @Override
        public void execute() throws ZeroDivisionException {
            n1 = numberStack.pop();
            n2 = numberStack.pop();
            numberStack.push(BasicOperation.divide(n2, n1));
        }

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
    }