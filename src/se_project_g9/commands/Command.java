/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package se_project_g9.commands;

import java.io.Serializable;
import se_project_g9.exceptions.CalculatorException;

/**
 *
 * @author group 9
 */
public interface Command extends Serializable{
    void execute() throws CalculatorException;
    void undo() throws CalculatorException;
}
