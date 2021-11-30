/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.EmptyStackException;
import se_project_g9.exceptions.NotEnoughNumbersException;
import se_project_g9.exceptions.OperationNotPresentException;
import se_project_g9.exceptions.OperationSymbolException;
import se_project_g9.exceptions.TooManyNumbersException;

/**
 *
 * @author group
 */
public class Operation implements ApplicationOperation {

    private final NumberStack<Number> numberStack;

    public Operation() {
        this.numberStack = new NumberStack<>();
    }

    protected PersonalizedStack<Number> getNumberStack() {
        return numberStack;
    }

    public boolean pushStack(Number n) {
        return numberStack.push(n) != null;
    }

    public Number popStack() throws EmptyStackException {
        return numberStack.pop();
    }

    public void invert() throws EmptyStackException{
        Number n1 = numberStack.pop(); //throws EmptyStackException
        n1 = BasicOperation.invert(n1);
        numberStack.push(n1);
    }

    public void multiply() throws NotEnoughNumbersException {
        Number n1, n2;
        n1 = numberStack.pop(); //throws EmptyStackException

        try {
            n2 = numberStack.pop();
        } catch (EmptyStackException e) {
            numberStack.push(n1);
            throw new NotEnoughNumbersException();
        }
        Number n3 = BasicOperation.multiply(n2, n1);
        numberStack.push(n3);
    }

    public void sqrt() throws EmptyStackException{ 

        Number top = numberStack.pop();
        Number sqrt = BasicOperation.sqrt(top);
        numberStack.push(sqrt);
    }

    public void sum() throws EmptyStackException, NotEnoughNumbersException {
        Number n1, n2;
        n1 = numberStack.pop(); //throws EmptyStackException

        try {
            n2 = numberStack.pop();
        } catch (EmptyStackException e) {
            numberStack.push(n1);
            throw new NotEnoughNumbersException();
        }
        Number n3 = BasicOperation.sum(n2, n1);
        numberStack.push(n3);
    }

    public void sub() throws EmptyStackException, NotEnoughNumbersException {
        Number n1, n2;
        n1 = numberStack.pop(); //throws EmptyStackException

        try {
            n2 = numberStack.pop();
        } catch (EmptyStackException e) {
            numberStack.push(n1);
            throw new NotEnoughNumbersException();
        }
        Number n3 = BasicOperation.sub(n2, n1);
        numberStack.push(n3);
    }

    public void divide() throws Exception {
        Number n1, n2;
        n1 = numberStack.pop(); //throws EmptyStackException

        try {
            n2 = numberStack.pop();
        } catch (EmptyStackException e) {
            numberStack.push(n1);
            throw new NotEnoughNumbersException();
        }
        Number n3 = BasicOperation.divide(n2, n1);
        numberStack.push(n3);
    }

    public void clear() {
        numberStack.clear();
    }

    private void dup() {
        numberStack.dup();
    }

    private void swap() throws NotEnoughNumbersException {
        numberStack.swap();
    }

    private void over() throws NotEnoughNumbersException {
        numberStack.over();
    }

    private void drop() {
        numberStack.drop();
    }

    protected void translateInput(String input) throws Exception {
        //ATTENTION!!!! if you want to add to the regular expression something like
        // the + sign or other things, use the operator |
        // example: if you want to add to this expression +, this will become " *?+"
        if (input.length() == 1 && !Character.isLetterOrDigit(input.charAt(0))) {
            switch (input) {
                case "-":
                    sub();
                    break;

                case "+":
                    sum();
                    break;

                case "*":
                    multiply();
                    break;
                case "/":
                    divide();
                    break;
                default:
                    throw new OperationSymbolException("This symbol does not correspond to an operation!");
            }
            //find operation
        } else if (input.startsWith("j") || input.startsWith("i")) {
            numberStack.push(convertNumber(input));
        } else if (Character.isAlphabetic(input.charAt(0))) {
            //is a function
            switch (input) {
                case "invert":
                    invert();
                    break;
                case "sqrt":
                    sqrt();
                    break;
                case "clear":
                    clear();
                    break;
                case "dup":
                    dup();
                    break;
                case "swap":
                    swap();
                    break;
                case "over":
                    over();
                    break;
                case "drop":
                    drop();
                    break;
                default:
                    throw new OperationNotPresentException("This operation is not supported");
            }

        } else {
            numberStack.push(convertNumber(input));
        }

    }

    protected static Number convertNumber(String input) throws Exception {
        if (input.length() == 0 || input.endsWith("+")) {
            throw new Exception("wrong input");
        }
        input = input.trim();
        String[] splittedInput = input.split("\\+|-");  //regex meaning: + once

        if (input.endsWith("-") || splittedInput.length > 3 || splittedInput.length == 0) {
            throw new Exception("wrong input");
        }

        double realPart = 0, imaginaryPart = 0;
        boolean imaginaryPartNotDone = true, realPartNotDone = true;

        for (String s : splittedInput) {

            //System.out.println("a" + s);
            if (!imaginaryPartNotDone & !realPartNotDone) {
                throw new TooManyNumbersException("You are trying to insert more than one number!");
            }

            if (s.length() != 0) {
                s = s.trim();
                if (((s.endsWith("i") | s.endsWith("j")))) {
                    if (!imaginaryPartNotDone) {
                        throw new Exception("imaginary part already present!");
                    }
                    int index = input.indexOf(s);

                    if (s.length() == 1) {
                        imaginaryPart = 1;
                    } else {
                        imaginaryPart = Double.parseDouble(s.substring(0, s.length() - 1)); //can throws NullPointerException or NumberFormatException
                    }
                    if (index != 0) {
                        if (Character.compare(input.charAt(index - 1), '-') == 0
                                || (Character.compare(input.charAt(index - 1), ' ') == 0 && Character.compare(input.charAt(index - 2), '-') == 0)) {
                            imaginaryPart = -imaginaryPart;
                        }
                    }

                    imaginaryPartNotDone = false;

                } else {
                    if (!realPartNotDone) {
                        throw new TooManyNumbersException("real part already present!");
                    }
                    int index = input.indexOf(s);
                    realPart = Double.parseDouble(s); //can throws NullPointerException or NumberFormatException
                    if (Character.compare(input.charAt(index == 0 ? 0 : index - 1), '-') == 0) {
                        realPart = -realPart;
                    }
                    realPartNotDone = false;

                }
            }

        }
        Number n = new Number(realPart, imaginaryPart);
        return n;

    }

}
