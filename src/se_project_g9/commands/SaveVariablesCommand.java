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

    public SaveVariablesCommand(Variables var) {
        this.variables = var;
    }

    @Override
    public void execute(){
        this.variables.saveVar();
    }

    @Override
    public void undo() throws EmptyStackException{
        this.variables.restoreVar();
    }

    @Override
    public String toString() {
        return "save";
    }
}
