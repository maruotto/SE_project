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
        this.operations.addInterpreter(i);
        
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
        operations.addOperation(name, input);
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
        Command op = i.translateInput(input, false);
        System.out.println("op" + op);
        op.execute();
        operationsPerformed.push(op);
    }

    public void addToVariable(Character variable) throws Exception {

        Command cm = new VInsertCommand(variables, numberStack, variable);
        cm.execute();
        operationsPerformed.push(cm);

    }

    public void pushValueOf(Character variable) throws Exception {

        Command cm = new VPushCommand(variables, variable, numberStack);
        cm.execute();
        operationsPerformed.push(cm);
    }

    public void addToValue(Character variable) throws Exception {

        Command cm = new VAddCommand(variables, variable, numberStack);
        cm.execute();
        operationsPerformed.push(cm);
    }

    public void subToValue(Character variable) throws Exception {

        Command cm = new VSubCommand(variables, variable, numberStack);
        cm.execute();
        operationsPerformed.push(cm);

    }

    public void removeOperation(String key) throws InputNumberException {
        Command cm = new DeleteCommand(operations, key);
        cm.execute();
        operationsPerformed.push(cm);
    }
    
    public void drop() throws InputNumberException{
        Command cm = new DropCommand(numberStack);
        cm.execute();
        operationsPerformed.push(cm);
    }

    public void dup() throws InputNumberException {
        Command cm = new DupCommand(numberStack);
        cm.execute();
        operationsPerformed.push(cm);
    }

    public void swap() throws InputNumberException {
        Command cm = new SwapCommand(numberStack);
        cm.execute();
        operationsPerformed.push(cm);
    }

    public void clear() throws InputNumberException {
        Command cm = new ClearCommand(numberStack);
        cm.execute();
        operationsPerformed.push(cm);
    }

    void over() throws InputNumberException {
        Command cm = new OverCommand(numberStack);
        cm.execute();
        operationsPerformed.push(cm);
    }
    

}
