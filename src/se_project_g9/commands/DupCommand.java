/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.Command;
import se_project_g9.NumberStack;
import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author idamaruotto
 */
public class DupCommand implements Command {
        private NumberStack<se_project_g9.ComplexNumber> numberStack;

        public DupCommand(NumberStack<se_project_g9.ComplexNumber> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
        }

        @Override
        public void execute() throws NotEnoughNumbersException {
            numberStack.dup();
        }

        @Override
        public void undo(){
            numberStack.drop();
        }
    }
    
    
