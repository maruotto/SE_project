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
public class PushCommand implements Command {
        private NumberStack<se_project_g9.Number> numberStack;
        private se_project_g9.Number n1;

        public PushCommand(NumberStack<se_project_g9.Number> numberStack, se_project_g9.Number n1) {
            assert numberStack != null;
            assert n1 != null;
            this.numberStack = numberStack;
            this.n1 = n1;
        }

        @Override
        public void execute() {
            n1 = numberStack.push(n1);
        }

        @Override
        public void undo() {
            if (n1 != null) {
                numberStack.drop();
            }
        }
    }
    
    
