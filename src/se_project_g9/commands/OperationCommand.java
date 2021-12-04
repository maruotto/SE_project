/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.Iterator;
import se_project_g9.PersonalizedStack;
import se_project_g9.exceptions.InputNumberException;
import se_project_g9.UDOperation;
import se_project_g9.Variables;

/**
 *
 * @author idamaruotto
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
        this.backupStack = (PersonalizedStack) stack.clone();
        this.backupVars = vars.clone();

    }

    @Override
    public void execute() throws InputNumberException {
        boolean done = true;
        for (Command c : op) {
            try {
                c.execute();
            } catch (InputNumberException e) {
                done = false;
                break;
            }
        }
        if (done) {
            return;
        }
        this.stack = backupStack;
        this.vars = backupVars;

    }

    @Override
    public void undo() throws InputNumberException {
        this.stack = backupStack;
        this.vars = backupVars;
    }

    @Override
    public String toString() {
        String commands = "Commands:\n";
        for (Command c : op) {
            commands += c.toString();
            commands += "\n";
        }
        return commands;
    }

}
