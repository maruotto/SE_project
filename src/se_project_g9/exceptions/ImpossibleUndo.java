/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.exceptions;

/**
 *
 * @author idamaruotto
 */
public class ImpossibleUndo extends InputNumberException {
    
    public ImpossibleUndo() {
        super();
    }

    public ImpossibleUndo(String message) {
        super(message);
    }
    
}
