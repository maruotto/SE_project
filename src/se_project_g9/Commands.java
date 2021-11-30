/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.EmptyStackException;
import se_project_g9.exceptions.NotEnoughNumbersException;
import se_project_g9.exceptions.ZeroDivisionException;

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
    
    
    public class SubCommand implements Command {
        private NumberStack<Number> numberStack;
        private Number n1;
        private Number n2;

        public SubCommand(NumberStack<Number> numberStack) {
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
    
    public class DropCommand implements Command {
        private NumberStack<Number> numberStack;
        private Number n1;

        public DropCommand(NumberStack<Number> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
        }

        @Override
        public void execute() {
            n1 = numberStack.pop();
        }

        @Override
        public void undo() {
            if (n1 != null) {
                numberStack.push(n1);
            }
        }
    }
    
    public class PushCommand implements Command {
        private NumberStack<Number> numberStack;
        private Number n1;

        public PushCommand(NumberStack<Number> numberStack, Number n1) {
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
                numberStack.pop();
            }
        }
    }
    
    public class InvertCommand implements Command {
        private NumberStack<Number> numberStack;
        private Number n1;

        public InvertCommand(NumberStack<Number> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
        }

        @Override
        public void execute() {
            n1 = numberStack.pop();
            numberStack.push(BasicOperation.invert(n1));
        }

        @Override
        public void undo() {
            if (n1 != null) {
                numberStack.pop();
                numberStack.push(n1);
            }
        }
    }
    
    public class MultiplyCommand implements Command {
        private NumberStack<Number> numberStack;
        private Number n1;
        private Number n2;

        public MultiplyCommand(NumberStack<Number> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
        }

        @Override
        public void execute() {
            n1 = numberStack.pop();
            n2 = numberStack.pop();
            numberStack.push(BasicOperation.multiply(n2, n1));
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
    
    public class SwapCommand implements Command {
        private NumberStack<Number> numberStack;

        public SwapCommand(NumberStack<Number> numberStack) {
            assert numberStack != null;
            this.numberStack = numberStack;
        }

        @Override
        public void execute() throws NotEnoughNumbersException {
            numberStack.swap();
        }

        @Override
        public void undo() throws NotEnoughNumbersException {
            numberStack.swap();
        }
    }
    
    public class DupCommand implements Command {
        private NumberStack<Number> numberStack;

        public DupCommand(NumberStack<Number> numberStack) {
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
    
    public class DivideCommand implements Command {
        private NumberStack<Number> numberStack;
        private Number n1;
        private Number n2;

        public DivideCommand(NumberStack<Number> numberStack) {
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
}