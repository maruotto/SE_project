/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author group 9
 */
public class UDOperation<Command> extends Stack<Command> {

    @Override
    public synchronized Iterator<Command> iterator() {
        return super.iterator();//To change body of generated methods, choose Tools | Templates.
    }

    public synchronized Iterator<Command> reverseIterator() {

        return new ReverseIterator<Command>(this);
    }

    @Override
    public String toString() {
        String s = "";
        for (Command c : this) {
            s += c.toString();
            s += " ";
        }
        return s;
    }

}
