/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package se_project_g9.exceptions;

/**
 *
 * @author idamaruotto
 */
public class TooManyNumbersException extends InputNumberException{

    /**
     * Creates a new instance of <code>TooManyNumbers</code> without detail
     * message.
     */
    public TooManyNumbersException() {
    }

    /**
     * Constructs an instance of <code>TooManyNumbers</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public TooManyNumbersException(String msg) {
        super(msg);
    }
}
