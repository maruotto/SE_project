/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package se_project_g9.exceptions;

/**
 *
 * @author idamaruotto
 */
public class NotCompleteNumberException extends InputNumberException{

    /**
     * Creates a new instance of <code>NotCompleteNumberException</code> without
     * detail message.
     */
    public NotCompleteNumberException() {
    }

    /**
     * Constructs an instance of <code>NotCompleteNumberException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NotCompleteNumberException(String msg) {
        super(msg);
    }
}
