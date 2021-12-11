/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.EmptyStackException;
import java.util.HashMap;
import se_project_g9.ComplexNumber;
import se_project_g9.Variables;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author group 9
 */
public class SaveVariablesCommand implements Command {
    private Variables variables;

    /**
     * Constructs a new SaveVariablesCommand
     * @param var the reference Variables that contains the map of all variables
     */
    public SaveVariablesCommand(Variables var) {
        this.variables = var;
    }

    /**
     * Execute of the SaveVariablesCommand
     */
    @Override
    public void execute(){
        this.variables.saveVar();
    }

    /**
     * Undo of the SaveVariablesCommand
     * @throws EmptyStackException
     */
    @Override
    public void undo() throws EmptyStackException{
        this.variables.restoreVar();
    }

    /**
     * Returns a string representation of SaveVariablesCommand
     * @return
     */ 
    @Override
    public String toString() {
        return "save";
    }
}
