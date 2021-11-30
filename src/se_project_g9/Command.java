/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package se_project_g9;

import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author group 9
 */
public interface Command {
    void execute() throws NotEnoughNumbersException;
    void undo() throws NotEnoughNumbersException;
}
