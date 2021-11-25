/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;
import java.util.Stack;
import javafx.beans.InvalidationListener;

/**
 *
 * @author group9
 */
public class NumberStack<E> extends Stack<E> implements PersonalizedStack{
    public void drop(){
        this.pop();
    }

    @Override
    public boolean add(Object n) {
        return this.add(n);
    }

}
