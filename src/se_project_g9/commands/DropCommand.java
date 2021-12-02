/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.Command;
import se_project_g9.NumberStack;

/**
 *
 * @author idamaruotto
 */
public class DropCommand implements Command {
        private NumberStack<se_project_g9.ComplexNumber> numberStack;
        private se_project_g9.ComplexNumber n1;

        public DropCommand(NumberStack<se_project_g9.ComplexNumber> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
        }

        @Override
        public void execute() {
            n1 = numberStack.peek();
            numberStack.drop();
        }

        @Override
        public void undo() {
            if (n1 != null) {
                numberStack.push(n1);
            }
        }
    }
    
    
