/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package se_project_g9;

import java.util.EmptyStackException;
import java.util.Iterator;
import javafx.collections.ObservableList;
import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author group9
 * @param <E>
 */
public interface PersonalizedStack<E> extends ObservableList<E>{
    public E pop() throws EmptyStackException;
    public E push(E item);
    public E peek()throws EmptyStackException;
    public void drop()throws EmptyStackException;
    @Override
    public Iterator<E> iterator();
    
    @Override
    public void clear();
    /**
     *
     * @throws EmptyStackException
     * @throws NotEnoughNumbersException
     */
    public void dup() throws EmptyStackException, NotEnoughNumbersException;;

    /**
     *
     * @throws EmptyStackException
     * @throws NotEnoughNumbersException
     */
    public void swap()throws EmptyStackException, NotEnoughNumbersException;

    /**
     *
     * @throws EmptyStackException
     * @throws NotEnoughNumbersException
     */
    public void over()throws EmptyStackException, NotEnoughNumbersException;
    
}
