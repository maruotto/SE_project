/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package se_project_g9;

import java.util.Iterator;
import javafx.collections.ObservableList;

/**
 *
 * @author group9
 * @param <E>
 */
public interface PersonalizedStack<E> extends ObservableList<E>{
    public E pop();
    public E push(E item);
    public E peek();
    public void drop();
    @Override
    public Iterator<E> iterator();
    @Override
    public void clear();
    public void dup();
    public void swap();
    public void over();
    
}
