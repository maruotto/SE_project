/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.BasicOperation;
import se_project_g9.Command;
import se_project_g9.NumberStack;

/**
 *
 * @author idamaruotto
 */
public class SubCommand implements Command {
        private NumberStack<se_project_g9.Number> numberStack;
        private se_project_g9.Number n1;
        private se_project_g9.Number n2;

        public SubCommand(NumberStack<se_project_g9.Number> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
        }

        @Override
        public void execute() {
            n1 = numberStack.pop();
            n2 = numberStack.pop();
            numberStack.push(BasicOperation.sub(n2, n1));
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
    
    
