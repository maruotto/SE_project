/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.exceptions.InputNumberException;
import java.io.Serializable;

/**
 *
 * @author group 9
 */
public interface Command extends Serializable{
    /**
     * Execute of the Command
     * @throws InputNumberException
     */
    void execute() throws InputNumberException; 
    /**
     * Undo of the Command
     * @throws InputNumberException
     */
    void undo() throws InputNumberException;
}
