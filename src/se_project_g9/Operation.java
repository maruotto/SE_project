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

    public Operation() {
        this.numberStack = new NumberStack<>();
        this.variables = new Variables();      
        this.operationsPerformed = new Stack<>();
        this.operations = new UDAllOp();
        this.i = new Interpreter(numberStack, variables, operations);
        UDOperation.addInterpreter(i);
                
        
    }

    protected Stack<Command> getOperationsPerfomed() {
        return operationsPerformed;
    }

    protected PersonalizedStack<ComplexNumber> getNumberStack() {
        return numberStack;
    }

    protected Variables getVariables() {
        return variables;
    }

    protected UDAllOp getOperations() {
        return operations;
    }

    public void addUDOperation(String name, String input) throws InputNumberException {
        performCommand(new AddOperationCommand(operations,name,input));
    }

    public void undo() throws ImpossibleUndo {
        Command op = operationsPerformed.pop(); //throw empty stack exception
        try {
            op.undo();
        } catch (InputNumberException ex) {
            throw new ImpossibleUndo("It's not possible to restore the status");
        }

    }

    public void performOperation(String input) throws InputNumberException {
        performCommand(i.translateInput(input, false));
    }
    
    public void performCommand(Command op) throws InputNumberException {
        op.execute();
        operationsPerformed.push(op);
    }

    public void addToVariable(Character variable) throws Exception {

        Command cm = new VInsertCommand(variables, numberStack, variable);
        performCommand(cm);

    }

    public void pushValueOf(Character variable) throws Exception {
        performCommand(new VPushCommand(variables, variable, numberStack));
    }

    public void addToValue(Character variable) throws Exception {
        performCommand(new VAddCommand(variables, variable, numberStack));
    }

    public void subToValue(Character variable) throws Exception {
        performCommand(new VSubCommand(variables, variable, numberStack));

    }

    public void removeOperation(String key) throws InputNumberException {
        performCommand(new DeleteCommand(operations, key));
    }
    
    public void modifyOperation(String key, String newValue) throws InputNumberException {
        performCommand(new ModifyOperationCommand(operations, key, new UDOperation(newValue)));
    }
    
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
    
    public void drop() throws InputNumberException{
        performCommand(new DropCommand(numberStack));
    }

    public void dup() throws InputNumberException {
        performCommand(new DupCommand(numberStack));
    }

    public void swap() throws InputNumberException {
        performCommand(new SwapCommand(numberStack));
    }

    public void clear() throws InputNumberException {
        performCommand(new ClearCommand(numberStack));
    }

    void over() throws InputNumberException {
        performCommand(new OverCommand(numberStack));
    }

    void invert() throws InputNumberException {
        performCommand(new InvertCommand(numberStack));
    }

}
