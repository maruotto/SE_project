/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.EmptyStackException;
import java.util.HashMap;
import se_project_g9.ComplexNumber;
import se_project_g9.Variables;

/**
 *
 * @author group 9
 */
public class RestoreVariablesCommand implements Command {
    private Variables variables;
    private HashMap<Character, ComplexNumber> tmp = new HashMap<Character, ComplexNumber>();

    public RestoreVariablesCommand(Variables var) {
        this.variables = var;
    }

    @Override
    public void execute() throws EmptyStackException {
        tmp = this.variables.restoreVar();
    }
    
    @Override
    public void undo() {
        this.variables.insertVar(tmp);
    }

    @Override
    public String toString() {
        return "restore";
    }
}
