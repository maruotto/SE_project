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
    
    @Override
    public synchronized E pop() {   
        E item = super.pop(); //throws EmptyStackException
        informListener(ChangeType.POP, item);
        return item;
    }
    
    @Override
    public synchronized E push(E item) {      
        super.push(item);
        informListener(ChangeType.PUSH, item);
        return item;
        
    }
    
    @Override
    public synchronized Iterator<E> iterator() {
        return new ReverseIterator<>(this);
        //return super.iterator();       
    }
    
    @Override
    public synchronized void clear() {
        super.clear();
        informListenerWholeStructure(ChangeType.POP);
    }
    
    @Override
    public synchronized E peek() {
        return super.peek(); //throws EmptyStackException
    }
    
    @Override
    public synchronized void drop() {
         informListener(ChangeType.POP, this.pop());//throws EmptyStackException  
    }
    
    @Override
    public synchronized void dup() {
        E e = this.peek(); //throws EmptyStackException
        this.push(e);
        informListener(ChangeType.PUSH, e);       
    }
    
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
     *
     * @param change the type of change performed, if push or pop
     * @param modified the element that has been modified
     */
    void informListener(ChangeType change, E modified) {
        change.setChangedObj(Collections.singletonList(modified));
        for (ListChangeListener observer : this.observers) {
            observer.onChanged(new StackChange(this, change));
        }
    }
    
    void informListenerWholeStructure(ChangeType change) {        
        change.setChangedObj(Collections.singletonList(this));        
        for (ListChangeListener observer : this.observers) {
            observer.onChanged(new StackChange(this, change));            
        }
        
    }
    
    @Override
    public void addListener(ListChangeListener<? super E> listener) {
        observers.add(listener);
    }
    
    @Override
    public void removeListener(ListChangeListener<? super E> listener) {
        observers.remove(listener);
    }
    
    @Override
    public boolean addAll(E... elements) {
        return obList.addAll(elements);
    }
    
    @Override
    public boolean setAll(E... elements) {
        return obList.setAll(elements);
    }
    
    @Override
    public boolean setAll(Collection<? extends E> clctn) {
        return obList.setAll(clctn);
    }
    
    @Override
    public boolean removeAll(E... elements) {
        return obList.removeAll(elements);
    }
    
    @Override
    public boolean retainAll(E... elements) {
        return obList.retainAll(elements);
    }
    
    @Override
    public void remove(int from, int to) {
        obList.remove(from, to);
    }
    
    @Override
    public void addListener(InvalidationListener listener) {
        obList.addListener(listener);
    }
    
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
