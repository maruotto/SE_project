/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import se_project_g9.commands.SqrtCommand;
import java.util.HashMap;
import java.util.Stack;
import se_project_g9.commands.*;
import se_project_g9.exceptions.ImpossibleUndo;
import se_project_g9.exceptions.InputNumberException;
import se_project_g9.exceptions.OperationNotPresentException;
import se_project_g9.exceptions.OperationSymbolException;
import se_project_g9.exceptions.TooManyNumbersException;

/**
 *
 * @author group
 */
public class Operation implements ApplicationOperation {

    private final NumberStack<ComplexNumber> numberStack;
    private final Variables variables;
    private final HashMap<String, UDOperation> operations;
    private final Stack<Command> operationsPerformed;

    public Operation() {
        this.numberStack = new NumberStack<>();
        this.variables = new Variables();
        this.operations = new HashMap<>();
        this.operationsPerformed = new Stack<>();
    }
    
    protected Stack<Command> getOperationsPerfomed(){
        return operationsPerformed;
    }

    protected PersonalizedStack<ComplexNumber> getNumberStack() {
        return numberStack;
    }
    
    protected Variables getVariables(){
        return variables;
    }
    
    protected HashMap<String,UDOperation> getOperations(){
        return operations;
    }

    
    public void addUDOperation(String name, String input) throws InputNumberException{
        if (operations.containsKey(name)){
            throw new InputNumberException("Operation already defined, try with another name");
        }
        
        if (name.contains(" ")){
            throw new InputNumberException("Space not allowed in operation's name");
        }
        
        
        String[] splittedInput = input.split(" +");
        UDOperation op = new UDOperation();
        for (String s: splittedInput){
            if (s.length() > 0){
                System.out.println(s + " g");
                op.push(translateInput(s, true)); //if exception thrown the execution is blocked
            }
        }
        operations.put(name, op);
    }
    
    
    public void undo() throws ImpossibleUndo{
        Command op = operationsPerformed.pop(); //throw empty stack exception
        try {
            op.undo();
        } catch (InputNumberException ex) {
            throw new ImpossibleUndo("It's not possible to restore the status");
        }
        
    }
    
    public void performOperation(String input) throws InputNumberException{
        Command op = translateInput(input, false);
        op.execute();
        operationsPerformed.push(op);
    }

    protected Command translateInput(String input, boolean operation) throws InputNumberException {
        input = input.trim();
        Command ret = null;
        //ATTENTION!!!! if you want to add to the regular expression something like
        // the + sign or other things, use the operator |
        // example: if you want to add to this expression +, this will become " *?+"
        
        if (operations.containsKey(input)){
            ret = new OperationCommand(operations.get(input),variables,numberStack);
        }
        else if (input.length() == 1 && !Character.isLetterOrDigit(input.charAt(0))) {
            switch (input) {
                case "-":
                    ret = new SubCommand(numberStack);
                    break;
                case "+":
                    ret = new SumCommand(numberStack);
                    break;
                case "*":
                    ret = new MultiplyCommand(numberStack);
                    break;
                case "/":
                    ret = new DivideCommand(numberStack);
                    break;
                default:
                    throw new OperationSymbolException("This symbol does not correspond to an operation!");
            }
            //find operation
        } else if (input.startsWith("in")){
            ret = new InvertCommand(numberStack);
        }else if ((input.startsWith("j") || input.startsWith("i")) && !operation) {
            numberStack.push(convertNumber(input));
        } else if (Character.isAlphabetic(input.charAt(0))) {
            //is a function
            System.out.println(input + "g");
            switch (input) {
                case "sqrt":
                    ret = new SqrtCommand(numberStack);
                    break;
                case "clear":
                    ret = new ClearCommand(numberStack);
                    break;
                case "dup":
                    ret = new DupCommand(numberStack);
                    break;
                case "swap":
                    ret = new SwapCommand(numberStack);
                    break;
                case "over":
                    ret = new OverCommand(numberStack);
                    break;
                case "drop":
                    ret = new DropCommand(numberStack);
                    break;
                default:
                    throw new OperationNotPresentException("This operation is not supported: " + input);
            }

        } else if(input.length() == 2 && Character.isAlphabetic(input.charAt(1))){
            switch (String.valueOf(input.charAt(0))){
                case ">":
                    ret = new VInsertCommand(variables,numberStack, input.charAt(1));
                    break;
                case "<":
                    ret = new VPushCommand(variables, input.charAt(1),numberStack);
                    break;
                case "+":
                    ret = new VAddCommand(variables, input.charAt(1), numberStack);
                    break;
                case "-":
                    ret = new VAddCommand(variables, input.charAt(1), numberStack);
                    break;
            }
                   
        }else if (!operation){          
            ret = new PushCommand(numberStack, convertNumber(input));
        } else{
            throw new OperationNotPresentException("This operation is not present in the library");
        }
        
        return ret;

    }

    protected static ComplexNumber convertNumber(String input) throws InputNumberException {
        if (input.length() == 0) {
            throw new NumberFormatException("Is not possible to insert nothing");
        }
        if (input.endsWith("+") || input.endsWith("-")) {
            throw new NumberFormatException("Number ends with a sign");
        }

        String[] splittedInput = input.split("\\+|-");  //regex meaning: + once

        if (splittedInput.length > 3 || splittedInput.length == 0) {
            throw new TooManyNumbersException("You are trying to insert more than one number!");
        }
        if (splittedInput.length == 0) {
            throw new TooManyNumbersException("You are trying to insert nothing!");
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
                        throw new TooManyNumbersException("imaginary part already present!");
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
        ComplexNumber n = new ComplexNumber(realPart, imaginaryPart);
        return n;

    }

    public void addToVariable(Character variable) throws Exception {

        Command cm = new VInsertCommand(variables,numberStack,variable);
        cm.execute();
        operationsPerformed.push(cm);
        
    }

    public void pushValueOf(Character variable) throws Exception {
        
        Command cm = new VPushCommand(variables,variable,numberStack);
        cm.execute();
        operationsPerformed.push(cm);
    }

    public void addToValue(Character variable) throws Exception {

        Command cm = new VAddCommand(variables,variable,numberStack);
        cm.execute();
        operationsPerformed.push(cm);
    }

    public void subToValue(Character variable) throws Exception {

        Command cm = new VSubCommand(variables,variable,numberStack);
        cm.execute();
        operationsPerformed.push(cm);

    }

}
