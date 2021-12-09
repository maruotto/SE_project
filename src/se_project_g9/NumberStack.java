/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author group9
 * @param <E>
 */
public class NumberStack<E> extends Stack<E> implements PersonalizedStack<E> {
    
    private final List<ListChangeListener> observers;
    private ObservableList<E> obList;
    
    public NumberStack() {
        super();
        observers = new ArrayList<>();
        obList = FXCollections.observableList(this);
    }
    
    /**
     * this method remove the stack first element 
     * @return the element removed 
     */
    @Override
    public synchronized E pop() {   
        E item = super.pop(); //throws EmptyStackException
        informListener(ChangeType.POP, item);
        return item;
    }
    
    /**
     * this method takes in input the element to insert and insert it in the stack
     * @param item the element to insert 
     * @return the element inserted
     */
    @Override
    public synchronized E push(E item) {      
        super.push(item);
        informListener(ChangeType.PUSH, item);
        return item;
        
    }
    
    /**
       this method returns an iterator on the stack
     * @return an iterator that start from the end 
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return new ReverseIterator<>(this);
        //return super.iterator();       
    }
    
    /**
     * this method removes all the elements from the stack
     */
    @Override
    public synchronized void clear() {
        super.clear();
        informListenerWholeStructure(ChangeType.POP);
    }
    
    /**
     *
     * @return the stack top element 
     */
    @Override
    public synchronized E peek() {
        return super.peek(); //throws EmptyStackException
    }
    
    /**
     * this method 
     */
    @Override
    public synchronized void drop() {
         informListener(ChangeType.POP, this.pop());//throws EmptyStackException  
    }
    
    /**
     * this method duplicates the stack top element
     */
    @Override
    public synchronized void dup() {
        E e = this.peek(); //throws EmptyStackException
        this.push(e);
        informListener(ChangeType.PUSH, e);       
    }
    
    /**
     * this method swaps the stack first two elements
     * @throws NotEnoughNumbersException
     */
    @Override
    public synchronized void swap() throws NotEnoughNumbersException{
        E last, secondlast;
        last = this.pop(); //throws EmptyStackException
        informListener(ChangeType.POP, last);    
        try{
            secondlast = this.pop();
            informListener(ChangeType.POP, secondlast);  
        }catch(EmptyStackException e){
            this.push(last);
            throw new NotEnoughNumbersException();
        }
        this.push(last);
        informListener(ChangeType.PUSH, last);
        this.push(secondlast);
        informListener(ChangeType.PUSH, secondlast);
    }
    
    /**
     * this method takes the stack second element and insert it on the top
     * @throws NotEnoughNumbersException
     */
    public synchronized void over() throws NotEnoughNumbersException {
         E last, secondlast;
         last = this.pop();
         informListener(ChangeType.POP, last);    
         try{
            secondlast = this.peek(); 
        }catch(EmptyStackException e){            
            throw new NotEnoughNumbersException();
        }finally{
             this.push(last);
        }
        informListener(ChangeType.PUSH, last);
        this.push(secondlast);
        informListener(ChangeType.PUSH, secondlast);
    }

    /**
     * this method clones this object
     * @return
     */
    @Override
    public synchronized Object clone() {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param o the object we want to compare with this.
     * @return if o and this object are equals or not
     */
    @Override
    public synchronized boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    /**
     * inform observers about modification on modified element
     * @param change the type of change performed, if push or pop
     * @param modified the element that has been modified
     */
    void informListener(ChangeType change, E modified) {
        change.setChangedObj(Collections.singletonList(modified));
        for (ListChangeListener observer : this.observers) {
            observer.onChanged(new StackChange(this, change));
        }
    }
    
    /**
     * inform observers about modification on the whole structure
     * 
     * @param modified the element that has been modified
     */
    
    void informListenerWholeStructure(ChangeType change) {        
        change.setChangedObj(Collections.singletonList(this));        
        for (ListChangeListener observer : this.observers) {
            observer.onChanged(new StackChange(this, change));            
        }
        
    }

    /**
     * Appends the specified element to the end of this Stack
     * @param c elements to be inserted into this Vector
     * @return true if this Vector changed as a result of the call
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        informListenerWholeStructure(ChangeType.PUSH);
        boolean ret = super.addAll(c);
        return ret;
    }
    
    /**
     * add listener to observers that will be informed about changes on structure
     * @param listener
     */
    @Override
    public void addListener(ListChangeListener<? super E> listener) {
        observers.add(listener);
    }
    
    /**
     * remove listener from observers and it will be no longer informed about changes on structure
     * @param listener
     */
    @Override
    public void removeListener(ListChangeListener<? super E> listener) {
        observers.remove(listener);
    }
    
    /**
     * Appends all of the elements in the specified collection to the end of this list,
     * in the order that they are returned by the specified collection's iterator 
     * @param elements
     * @return
     */
    @Override
    public boolean addAll(E... elements) {
        return obList.addAll(elements);
    }
    
    /**
     * Replaces the element at the specified position in this list with the 
     * specified element (optional operation).
     * @param elements
     * @return
     */
    @Override
    public boolean setAll(E... elements) {
        return obList.setAll(elements);
    }
    
    /**
     * Clears the ObservableList and adds all elements from the collection.
     * @param clctn
     * @return
     */
    @Override
    public boolean setAll(Collection<? extends E> clctn) {
        return obList.setAll(clctn);
    }
    
    /**
     * Removes the first occurrence of the specified element from this list, 
     * if it is present (optional operation). If this list does not contain 
     * the element, it is unchanged.
     * @param elements
     * @return
     */
    @Override
    public boolean removeAll(E... elements) {
        return obList.removeAll(elements);
    }
    
    /**
     * Retains only the elements in this list that are contained in the 
     * specified collection
     * @param elements
     * @return
     */
    @Override
    public boolean retainAll(E... elements) {
        return obList.retainAll(elements);
    }
    
    /**
     * Removes the first occurrence of the specified element from this list, 
     * if it is present
     * @param from
     * @param to
     */
    @Override
    public void remove(int from, int to) {
        obList.remove(from, to);
    }
    
    /**
     * Adds an InvalidationListener which will be notified whenever the 
     * Observable becomes invalid. If the same listener is added more than once, 
     * then it will be notified more than once. That is, no check is made to 
     * ensure uniqueness.

     * @param listener
     */
    @Override
    public void addListener(InvalidationListener listener) {
        obList.addListener(listener);
    }
    
    /**
     * Removes the first occurrence of the specified element from this list, if it is present
     * @param listener
     */
    @Override
    public void removeListener(InvalidationListener listener) {
        obList.removeListener(listener);
    }
    
    private final class StackChange extends ListChangeListener.Change {
        
        private final ChangeType type;
        private boolean onChange;

        /**
         * Constructs a new change done to a list.
         *
         * @param list that was changed
         */
        public StackChange(ObservableList<E> list, ChangeType type) {
            super(list);
            this.type = type;
            onChange = false;
        }
        
        @Override
        public boolean wasAdded() {
            return type == ChangeType.PUSH;
        }
        
        @Override
        public boolean wasRemoved() {
            return type == ChangeType.POP;
        }
        
        @Override
        public boolean next() {
            if (onChange) {
                return false;
            }
            onChange = true;
            return true;
        }
        
        @Override
        public void reset() {
            onChange = false;
        }

        /**
         * Because this is a stack, all push and pop happen to the first item in
         * the stack
         *
         * @return index of the first item
         */
        @Override
        public int getFrom() {
            if (!onChange) {
                throw new IllegalStateException(
                        "Invalid Change state: next() must be called before inspecting the Change.");
            }
            return 0;
        }

        /**
         * @return the size of the list returned which indicates the end of the
         * change
         */
        @Override
        public int getTo() {
            if (!onChange) {
                throw new IllegalStateException(
                        "Invalid Change state: next() must be called before inspecting the Change.");
            }
            return type.getChangedObj().size();
        }
        
        @Override
        public List<E> getRemoved() {
            return wasRemoved() ? type.getChangedObj()
                    : Collections.emptyList();
        }
        
        @Override
        protected int[] getPermutation() {
            return new int[0];
        }
    }
    
    private enum ChangeType {
        PUSH, POP;

        /**
         * The object that was changed
         */
        private List changedObj;

        /**
         * The changed object(s) are packaged as a list
         *
         * @return The list of changed objects
         */
        public List getChangedObj() {
            return changedObj;
        }

        /**
         * Method to accept the changed object
         *
         * @param obj the list of objects that were changed in the stack
         * @return this enum
         */
        public ChangeType setChangedObj(List obj) {
            this.changedObj = obj;
            return this;
        }
        
    }
}
