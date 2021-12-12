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

    /**
     * Constructs a new RestoreVariablesCommand
     * @param var the reference Variables that contains the map of all variables
     */
    public RestoreVariablesCommand(Variables var) {
        assert var != null;
        this.variables = var;
    }

    /**
     * Execute of the RestoreVariablesCommand
     * @throws EmptyStackException
     */
    @Override
    public void execute() throws EmptyStackException {
        tmp = this.variables.restoreVar();
    }
    
    /**
     * Undo of the RestoreVariablesCommand
     */
    @Override
    public void undo() {
        this.variables.insertVar(tmp);
    }

    /**
     * Returns a string representation of RestoreVariablesCommand
     * @return
     */ 
    @Override
    public String toString() {
        return "restore";
    }
}
