/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package se_project_g9.exceptions;

/**
 *
 * @author idamaruotto
 */
public class CalculatorException extends Exception{

    /**
     * Creates a new instance of <code>CalculatorException</code> without detail
     * message.
     */
    public CalculatorException() {
    }

    /**
     * Constructs an instance of <code>CalculatorException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CalculatorException(String msg) {
        super(msg);
    }
}
