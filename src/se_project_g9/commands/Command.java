/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author group 9
 */
public interface Command {
    void execute() throws InputNumberException;
    void undo() throws InputNumberException;
}
