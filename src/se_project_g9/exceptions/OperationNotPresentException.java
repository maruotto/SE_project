/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package se_project_g9.exceptions;

/**
 *
 * @author idamaruotto
 */
public class OperationNotPresentException extends OperationException{

    /**
     * Creates a new instance of <code>OperationNotPresentException</code>
     * without detail message.
     */
    public OperationNotPresentException() {
    }

    /**
     * Constructs an instance of <code>OperationNotPresentException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public OperationNotPresentException(String msg) {
        super(msg);
    }
}
