/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package se_project_g9.exceptions;

import java.io.IOException;

/**
 *
 * @author idamaruotto
 */
public class InputNumberException extends IOException{

    /**
     * Creates a new instance of <code>InputNumberException</code> without
     * detail message.
     */
    public InputNumberException() {
    }

    /**
     * Constructs an instance of <code>InputNumberException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InputNumberException(String msg) {
        super(msg);
    }
}
