/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import se_project_g9.commands.ClearCommand;
import se_project_g9.commands.Command;
import se_project_g9.commands.DivideCommand;
import se_project_g9.commands.DropCommand;
import se_project_g9.commands.DupCommand;
import se_project_g9.commands.InvertCommand;
import se_project_g9.commands.ModCommand;
import se_project_g9.commands.MultiplyCommand;
import se_project_g9.commands.OperationCommand;
import se_project_g9.commands.OverCommand;
import se_project_g9.commands.PushCommand;
import se_project_g9.commands.RestoreVariablesCommand;
import se_project_g9.commands.SaveVariablesCommand;
import se_project_g9.commands.SqrtCommand;
import se_project_g9.commands.SubCommand;
import se_project_g9.commands.SumCommand;
import se_project_g9.commands.SwapCommand;
import se_project_g9.commands.VAddCommand;
import se_project_g9.commands.VInsertCommand;
import se_project_g9.commands.VPushCommand;
import se_project_g9.commands.VSubCommand;
import se_project_g9.exceptions.CalculatorException;
import se_project_g9.exceptions.InputNumberException;
import se_project_g9.exceptions.OperationNotPresentException;
import se_project_g9.exceptions.OperationSymbolException;
import se_project_g9.exceptions.TooManyNumbersException;

/**
 *
 * @author idamaruotto
 */
public class Interpreter {

    private static PersonalizedStack<ComplexNumber> numberStack = null;
    private static Variables variables = null;
    private static UDAllOp operations = null;

    /**
     *
     * @param input the input string to translate
     * @param operation true if input is an operation,false otherwise
     * @return the Command to execute
     * @throws CalculatorException
     */
    protected static Command translateInput(String input, boolean operation) throws CalculatorException {
        if (numberStack == null || variables == null || operations == null) {
            input = input.trim();
        }
        Command ret = null;
        //ATTENTION!!!! if you want to add to the regular expression something like
        // the + sign or other things, use the operator |
        // example: if you want to add to this expression +, this will become " *?+"

        if (operations.containsKey(input)) {
            ret = new OperationCommand(operations.get(input), variables, numberStack);
        } else if (input.length() == 1 && !Character.isLetterOrDigit(input.charAt(0))) {
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
        } else if (input.startsWith("in")) {
            ret = new InvertCommand(numberStack);
        } else if ((input.startsWith("j") || input.startsWith("i")) && !operation) {
            ret = new PushCommand(numberStack, convertNumber(input));
        } else if (Character.isAlphabetic(input.charAt(0))) {
            //is a function
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
                case "mod":
                    ret = new ModCommand(numberStack);
                    break;
                case "restore":
                    ret = new RestoreVariablesCommand(variables);
                    break;
                case "save":
                    ret = new SaveVariablesCommand(variables);
                    break;
                default:
                    throw new OperationNotPresentException("This operation is not supported: " + input);
            }

        } else if (input.length() == 2 && Character.isAlphabetic(input.charAt(1))) {
            switch (String.valueOf(input.charAt(0))) {
                case ">":
                    ret = new VInsertCommand(variables, numberStack, input.charAt(1));
                    break;
                case "<":
                    ret = new VPushCommand(variables, input.charAt(1), numberStack);
                    break;
                case "+":
                    ret = new VAddCommand(variables, input.charAt(1), numberStack);
                    break;
                case "-":
                    ret = new VSubCommand(variables, input.charAt(1), numberStack);
                    break;
                default:
                    throw new OperationNotPresentException("Operation on variables not defined");
            }

        } else 
            try {
            ret = new PushCommand(numberStack, convertNumber(input));
            } catch (InputNumberException e) {
                throw new OperationNotPresentException("This operation is not present in the library");
            }

        return ret;

    }

    /**
     *
     * @param input the input to string to convert
     * @return a complex number that represents the input
     * @throws InputNumberException
     */
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
    
    public static void setOperation(ApplicationOperation ope) {
        if(numberStack == null && variables == null && operations == null){
            numberStack = ope.getNumberStack();
            variables = ope.getVariables();
            operations = ope.getOperations();
        }
    }
    
    
    
    
}
