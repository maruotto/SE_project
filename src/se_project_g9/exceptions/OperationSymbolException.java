/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package se_project_g9.exceptions;

/**
 *
 * @author idamaruotto
 */
public class OperationSymbolException extends InputNumberException{

    /**
     * Creates a new instance of <code>OperationSymbolException</code> without
     * detail message.
     */
    public OperationSymbolException() {
    }

    /**
     * Constructs an instance of <code>OperationSymbolException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public OperationSymbolException(String msg) {
        super(msg);
    }
}
