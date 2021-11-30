/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package se_project_g9.exceptions;

/**
 *
 * @author idamaruotto
 */
public class NotEnoughNumbersException extends InputNumberException{

    /**
     * Creates a new instance of <code>NotEnoughNumberException</code> without
     * detail message.
     */
    public NotEnoughNumbersException() {
    }

    /**
     * Constructs an instance of <code>NotEnoughNumberException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotEnoughNumbersException(String msg) {
        super(msg);
    }
}
