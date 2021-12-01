/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.Command;
import se_project_g9.Number;
import se_project_g9.NumberStack;
import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author group 9
 */
    
    
    public class ClearCommand implements Command {
        private NumberStack<Number> numberStack;
        private NumberStack<Number> copyOfNumberStack;

        public ClearCommand(NumberStack<Number> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
            this.copyOfNumberStack = (NumberStack<Number>) numberStack.clone();
        }

        @Override
        public void execute() throws NotEnoughNumbersException {
            numberStack.clear();
        }

        @Override
        public void undo(){
            numberStack = (NumberStack<Number>) copyOfNumberStack.clone();
        }
    }
