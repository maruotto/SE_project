/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.Stack;
import se_project_g9.commands.*;
import se_project_g9.exceptions.ImpossibleUndo;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author group
 */
public class Operation implements ApplicationOperation {

    private final NumberStack<ComplexNumber> numberStack;
    private final Variables variables;
    private final UDAllOp operations;
    private final Stack<Command> operationsPerformed;
    private final Interpreter i;

    /**
     * 
     */
    public Operation() {
        this.numberStack = new NumberStack<>();
        this.variables = new Variables();      
        this.operationsPerformed = new Stack<>();
        this.operations = new UDAllOp();
        this.i = new Interpreter(numberStack, variables, operations);
        UDOperation.addInterpreter(i);
                
        
    }

    /**
     * this method returns the operations performed
     * @return
     */
    protected Stack<Command> getOperationsPerfomed() {
        return operationsPerformed;
    }

    /**
     * this method returns the number stack
     * @return
     */
    protected PersonalizedStack<ComplexNumber> getNumberStack() {
        return numberStack;
    }

    /**
     * this method returns the variables
     * @return
     */
    protected Variables getVariables() {
        return variables;
    }

    /**
     * this methods returns the operations
     * @return
     */
    protected UDAllOp getOperations() {
        return operations;
    }

    /**
     *
     * @param name the custom operation name
     * @param input the commands sequence
     * @throws InputNumberException
     */
    public void addUDOperation(String name, String input) throws InputNumberException {
        performCommand(new AddOperationCommand(operations,name,input));
    }

    /**
     * this methods allows to revoke the last operation done.
     * @throws ImpossibleUndo
     */
    public void undo() throws ImpossibleUndo {
        Command op = operationsPerformed.pop(); //throw empty stack exception
        try {
            op.undo();
        } catch (InputNumberException ex) {
            throw new ImpossibleUndo("It's not possible to restore the status");
        }

    }

    /**
     * this method translate the input and execute the operation
     * @param input the operation name 
     * @throws InputNumberException
     */
    public void performOperation(String input) throws InputNumberException {
        performCommand(i.translateInput(input, false));
    }
    
    /**
     * this method execute the command passed as parameter
     * @param op the command to execute
     * @throws InputNumberException
     */
    public void performCommand(Command op) throws InputNumberException {
        op.execute();
        operationsPerformed.push(op);
    }

    /**
     * this method takes the stack first element and add it into variable
     * @param variable the variable name
     * @throws Exception
     */
    public void addToVariable(Character variable) throws Exception {

        Command cm = new VInsertCommand(variables, numberStack, variable);
        performCommand(cm);

    }

    /**
     * this method takes the variable value and push it into the stack
     * @param variable the variable name
     * @throws Exception
     */
    public void pushValueOf(Character variable) throws Exception {
        performCommand(new VPushCommand(variables, variable, numberStack));
    }

    /**
     * this method takes the stack first element and sums it with the variable value
     * @param variable the variable name
     * @throws Exception
     */
    public void addToValue(Character variable) throws Exception {
        performCommand(new VAddCommand(variables, variable, numberStack));
    }

    /**
     * this method takes the stack first element and subtracts it with the variable value
     * @param variable the variable name
     * @throws Exception
     */
    public void subToValue(Character variable) throws Exception {
        performCommand(new VSubCommand(variables, variable, numberStack));

    }

    /**
     * this method remove a defined operation
     * @param key the operation name
     * @throws InputNumberException
     */
    public void removeOperation(String key) throws InputNumberException {
        performCommand(new DeleteCommand(operations, key));
    }
    
    /**
     * this method takes in input the operation name and the new operation sequence and modifies it
     * @param key the operation name
     * @param newValue the new sequence of operations to do
     * @throws InputNumberException
     */
    public void modifyOperation(String key, String newValue) throws InputNumberException {
        performCommand(new ModifyOperationCommand(operations, key, new UDOperation(newValue)));
    }
    
    /**
     * this method takes in input the operation name and the new name and modifies it
     * @param key the operation name
     * @param newKey the new operation name
     * @throws InputNumberException
     */
    public void modifyOperationName(String key, String newKey) throws InputNumberException {   
        UDOperation op = new UDOperation();
        if(this.operations.containsKey(newKey))
            throw new InputNumberException("Choose another key, the new key already exists");
        Command cmA = new AddOperationCommand(operations, newKey, operations.get(key));
        Command cmR = new DeleteCommand(operations, key);
        op.add(cmR);
        op.add(cmA);
        Command cm = new OperationCommand(op, variables, numberStack);
        
        performCommand(cm);
    }
    
    /**
     * this method executes the drop operation
     * @throws InputNumberException
     */
    public void drop() throws InputNumberException{
        performCommand(new DropCommand(numberStack));
    }

    /**
     * this method executes the dup operation
     * @throws InputNumberException
     */
    public void dup() throws InputNumberException {
        performCommand(new DupCommand(numberStack));
    }

    /**
     * this method executes the swap operation
     * @throws InputNumberException
     */
    public void swap() throws InputNumberException {
        performCommand(new SwapCommand(numberStack));
    }

    /**
     * this method executes the clear operation
     * @throws InputNumberException
     */
    public void clear() throws InputNumberException {
        performCommand(new ClearCommand(numberStack));
    }
    /**
     * this method executes the over operation
     * @throws InputNumberException 
     */
    
    void over() throws InputNumberException {
        performCommand(new OverCommand(numberStack));
    }
    /**
     * this method executes the invert operation
     * @throws InputNumberException 
     */
    void invert() throws InputNumberException {
        performCommand(new InvertCommand(numberStack));
    }

    void mod() throws InputNumberException {
       performCommand(new ModCommand(numberStack));
    }

}
