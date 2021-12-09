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

    /**
     * return the element at the top of the stack and removes it
     * then it informs the observers
     * @return the element at the top of the stack
     * @throws EmptyStackException
     */
    public E pop() throws EmptyStackException;

    /**
     * insert the element at the top of the stack
     * then it informs the observers
     * @param item insert the element into the stack 
     * @return the element that have been insert, null if
     */
    public E push(E item);

    /**
     * return the element at the top of the stack without removing it
     * @return
     * @throws EmptyStackException
     */
    public E peek()throws EmptyStackException;

    /**
     * removes the top element from the stack
     * @throws EmptyStackException
     */
    public void drop()throws EmptyStackException;

    /**
     * 
     * @return
     */
    @Override
    public Iterator<E> iterator();
    
    /**
     *
     */
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
     *  takes the second last element and put it on top of the stack
     * @throws EmptyStackException
     * @throws NotEnoughNumbersException
     */
    public void over()throws EmptyStackException, NotEnoughNumbersException;
    
    /**
     *
     * @return a clone of the object
     */
    public Object clone();
    
}
