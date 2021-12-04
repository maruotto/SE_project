/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.*;
import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author group9
 */
    
    
    public class ClearCommand implements Command {
        private PersonalizedStack<ComplexNumber> numberStack;
        private PersonalizedStack<ComplexNumber> copyOfNumberStack;

        public ClearCommand(PersonalizedStack<ComplexNumber> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
        }

        @Override
        public void execute() throws NotEnoughNumbersException {
            this.copyOfNumberStack = (PersonalizedStack<ComplexNumber>) numberStack.clone();
            numberStack.clear();
        }

        @Override
        public void undo(){
            numberStack.addAll(copyOfNumberStack);
        }
    }
