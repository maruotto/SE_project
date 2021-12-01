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
public class OverCommand implements Command {
        private NumberStack<se_project_g9.Number> numberStack;

        public OverCommand(NumberStack<se_project_g9.Number> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
        }

        @Override
        public void execute() throws NotEnoughNumbersException {
            numberStack.over();
        }

        @Override
        public void undo(){
            numberStack.drop();
        }
    }
