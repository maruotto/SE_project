/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import se_project_g9.commands.*;
import se_project_g9.exceptions.ImpossibleUndo;
import se_project_g9.exceptions.CalculatorException;
import se_project_g9.exceptions.OperationException;

/**
 *
 * @author group
 */
public class Operation implements ApplicationOperation {

    private final NumberStack<ComplexNumber> numberStack;
    private final Variables variables;
    private final UDAllOp operations;
    private final Stack<Command> operationsPerformed;
    private static Operation instance = null;

    /**
     *
     */
    private Operation() {
        this.numberStack = new NumberStack<>();
        this.variables = new Variables();
        this.operationsPerformed = new Stack<>();
        this.operations = new UDAllOp();
        Interpreter.setOperation(this);

    }

    public static Operation getInstance() {

        if (instance == null) {
            instance = new Operation();
        }

        return instance;

    }

    /**
     * this method returns the operations performed
     *
     * @return
     */
    protected Stack<Command> getOperationsPerfomed() {
        return operationsPerformed;
    }

    /**
     * this method returns the number stack
     *
     * @return
     */
    @Override
    public PersonalizedStack<ComplexNumber> getNumberStack() {
        return numberStack;
    }

    /**
     * this method returns the variables
     *
     * @return
     */
    @Override
    public Variables getVariables() {
        return variables;
    }

    /**
     * this methods returns the operations
     *
     * @return
     */
    @Override
    public UDAllOp getOperations() {
        return operations;
    }

    /**
     *
     * @param name the custom operation name
     * @param input the commands sequence
     * @throws CalculatorException
     */
    public void addUDOperation(String name, String input) throws CalculatorException {
        performCommand(new AddOperationCommand(operations, name, input));
    }

    /**
     * this methods allows to revoke the last operation done.
     *
     * @throws ImpossibleUndo
     */
    public void undo() throws ImpossibleUndo {
        Command op = operationsPerformed.pop(); //throw empty stack CalculatorException
        try {
            op.undo();
        } catch (CalculatorException ex) {
            throw new ImpossibleUndo("It's not possible to restore the status");
        }

    }

    /**
     * this method translate the input and execute the operation
     *
     * @param input the operation name
     * @throws CalculatorException
     */
    public void performOperation(String input) throws CalculatorException {
        performCommand(Interpreter.translateInput(input, false));
    }

    /**
     * this method execute the command passed as parameter
     *
     * @param op the command to execute
     * @throws CalculatorException
     */
    public void performCommand(Command op) throws CalculatorException {
        op.execute();
        operationsPerformed.push(op);
    }

    /**
     * this method takes the stack first element and add it into variable
     *
     * @param variable the variable name
     * @throws CalculatorException
     */
    public void addToVariable(Character variable) throws CalculatorException {

        Command cm = new VInsertCommand(variables, numberStack, variable);
        performCommand(cm);

    }

    /**
     * this method takes the variable value and push it into the stack
     *
     * @param variable the variable name
     * @throws CalculatorException
     */
    public void pushValueOf(Character variable) throws CalculatorException {
        performCommand(new VPushCommand(variables, variable, numberStack));
    }

    /**
     * this method takes the stack first element and sums it with the variable
     * value
     *
     * @param variable the variable name
     * @throws CalculatorException
     */
    public void addToValue(Character variable) throws CalculatorException {
        performCommand(new VAddCommand(variables, variable, numberStack));
    }

    /**
     * this method takes the stack first element and subtracts it with the
     * variable value
     *
     * @param variable the variable name
     * @throws CalculatorException
     */
    public void subToValue(Character variable) throws CalculatorException {
        performCommand(new VSubCommand(variables, variable, numberStack));

    }

    /**
     * this method remove a defined operation
     *
     * @param key the operation name
     * @throws CalculatorException
     */
    public void removeOperation(String key) throws CalculatorException {
        performCommand(new DeleteOperationCommand(operations, key));
    }

    /**
     * this method takes in input the operation name and the new operation
     * sequence and modifies it
     *
     * @param key the operation name
     * @param newValue the new sequence of operations to do
     * @throws CalculatorException
     */
    public void modifyOperation(String key, String newValue) throws CalculatorException {
        performCommand(new ModifyOperationCommand(operations, key, new UDOperation(newValue)));
    }

    /**
     * this method takes in input the operation name and the new name and
     * modifies it
     *
     * @param key the operation name
     * @param newKey the new operation name
     * @throws OperationException
     */
    public void modifyOperationName(String key, String newKey) throws CalculatorException {
        UDOperation op = new UDOperation();
        if (this.operations.containsKey(newKey)) {
            throw new OperationException("Choose another key, the new key already exists");
        }
        Command cmA = new AddOperationCommand(operations, newKey, operations.get(key));
        Command cmR = new DeleteOperationCommand(operations, key);
        op.add(cmR);
        op.add(cmA);
        Command cm = new OperationCommand(op, variables, numberStack);

        performCommand(cm);
    }

    /**
     * this method executes the drop operation
     *
     * @throws CalculatorException
     */
    public void drop() throws CalculatorException {
        performCommand(new DropCommand(numberStack));
    }

    /**
     * this method executes the dup operation
     *
     * @throws CalculatorException
     */
    public void dup() throws CalculatorException {
        performCommand(new DupCommand(numberStack));
    }

    /**
     * this method executes the swap operation
     *
     * @throws CalculatorException
     */
    public void swap() throws CalculatorException {
        performCommand(new SwapCommand(numberStack));
    }

    /**
     * this method executes the clear operation
     *
     * @throws CalculatorException
     */
    public void clear() throws CalculatorException {
        performCommand(new ClearCommand(numberStack));
    }

    /**
     * this method executes the over operation
     *
     * @throws CalculatorException
     */

    void over() throws CalculatorException {
        performCommand(new OverCommand(numberStack));
    }

    /**
     * this method executes the invert operation
     *
     * @throws CalculatorException
     */
    void invert() throws CalculatorException {
        performCommand(new InvertCommand(numberStack));
    }

    void mod() throws CalculatorException {
        performCommand(new ModCommand(numberStack));
    }

    void sqrt() throws CalculatorException {
        performCommand(new SqrtCommand(numberStack));
    }

    void saveVariables() throws CalculatorException {
        performCommand(new SaveVariablesCommand(variables));
    }

    void restoreVariables() throws CalculatorException {
        performCommand(new RestoreVariablesCommand(variables));
    }
    
    /**
     *
     * @param filename the file object.
     * @param map the operations to save
     * @throws IOException 
     */
    public void writeIn(File filename) throws IOException {

        try ( PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (String key : this.operations.keySet()) {
                writer.print(key + " : " + this.operations.get(key).toString() + '\n');
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param filename the file object
     * @param ope the operation class to load a command
     * @throws FileNotFoundException
     */
    public void loadFrom(File filename) throws FileNotFoundException {

        String key;

        try ( Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] splitted = line.split(" : ");
                key = splitted[0];
                try {
                    this.addUDOperation(key, splitted[splitted.length - 1]);
                } catch (CalculatorException ex) {
                    System.out.println("operation " + key + " already exists");
                }
            }
        }
    }

}
