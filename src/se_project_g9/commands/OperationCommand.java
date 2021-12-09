/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.Iterator;
import se_project_g9.PersonalizedStack;
import se_project_g9.UDAllOp;
import se_project_g9.exceptions.InputNumberException;
import se_project_g9.UDOperation;
import se_project_g9.Variables;

/**
 *
 * @author group 9
 */
public class OperationCommand implements Command {

    private UDOperation<Command> op;
    private PersonalizedStack stack;
    private Variables vars;
    private PersonalizedStack backupStack;
    private Variables backupVars;
    public OperationCommand(UDOperation op, Variables vars, PersonalizedStack stack) {
        this.op = op;
        this.stack = stack;
        this.vars = vars;

    }

    /**
     *
     * @throws InputNumberException
     */
    @Override
    public void execute() throws InputNumberException {
        this.backupStack = (PersonalizedStack) stack.clone();
        this.backupVars = vars.clone();

        for (Command c : op) {
            try {
                c.execute();
            } catch (Exception e) {
                this.stack.clear();
                this.stack.addAll(backupStack);
                this.vars.clear();
                this.vars.addAll(backupVars);
                throw new InputNumberException("Operation not executed successfully");
            }
        }

    }

    /**
     *
     * @throws InputNumberException
     */
    @Override
    public void undo() throws InputNumberException {
        Iterator<Command> i = op.reverseIterator();
        while(i.hasNext()){
            i.next().undo();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String commands = "";
        for (Command c : op) {
            commands += c.toString();
            commands += "\n";
        }
        return commands;
    }

}
