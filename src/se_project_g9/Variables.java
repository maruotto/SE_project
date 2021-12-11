/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

/**
 *
 * @author group 9
 */
public class Variables {

    private HashMap<Character, ComplexNumber> variablesMap;
    private final Stack<HashMap> variableStack;

    /**
     * constructor of class Variables
     */
    public Variables() {
        this.variablesMap = new HashMap<Character, ComplexNumber>();
        this.variableStack = new Stack<HashMap>();

    }

    /**
     * constructor of class Variables
     *
     * @param variablesMap
     * @param variableStack
     */
    private Variables(HashMap<Character, ComplexNumber> variablesMap, Stack<HashMap> variableStack) {
        this.variablesMap = variablesMap;
        this.variableStack = variableStack;
    }

    /**
     *
     * insert a new variable with name key and value
     *
     * @param key
     * @param value
     * @throws Exception
     */
    public void setVariableValue(Character key, ComplexNumber value) throws Exception {
        if (key == null) {
            throw new Exception("key not specified...");
        }
        variablesMap.put(key, value);

    }

    /**
     *
     * @param key
     * @return the value associated with key
     * @throws Exception
     */
    public ComplexNumber getVariableValue(Character key) throws Exception {
        if (variablesMap.containsKey(key)) {
            return variablesMap.get(key);
        } else {
            throw new Exception("Key not found");
        }

    }

    /**
     *
     * @return variablesMap
     */
    public HashMap<Character, ComplexNumber> getVariablesMap() {
        return variablesMap;
    }
    
    /**
     *
     * @return variableStack
     */
    public Stack<HashMap> getVariableStack(){
        return variableStack;
    }

    /**
     *
     * @return a clone of this object
     */
    @Override
    public Variables clone() {
        return new Variables((HashMap<Character, ComplexNumber>) this.variablesMap.clone(), (Stack<HashMap>) this.variableStack.clone());
    }

    /**
     *
     * @return int code associated with this object
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.variablesMap);
        hash = 23 * hash + Objects.hashCode(this.variableStack);
        return hash;
    }

    /**
     *
     *
     * @param obj
     * @return true if the two objects contains the same values in map and in
     * stack
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Variables other = (Variables) obj;
        if (!Objects.equals(this.variablesMap, other.variablesMap)) {
            return false;
        }
        if (!Objects.equals(this.variableStack, other.variableStack)) {
            return false;
        }
        return true;
    }

    /**
     *
     * Add all values of other in this object
     *
     * @param other
     * @return
     */
    public boolean addAll(Variables other) {
        if (other.variablesMap == null || other.variableStack == null) {
            return false;
        }
        this.variableStack.addAll(other.variableStack);
        this.variablesMap.putAll(other.variablesMap);
        return true;
    }

    /**
     * save a copy of all variables on the stack
     */
    public void saveVar() {
        this.variableStack.push((HashMap) variablesMap.clone());
    }

    /**
     *
     * @param v contains the values that will be substituted to the ones inside
     * the variables map
     */
    public void insertVar(HashMap<Character, ComplexNumber> v) {
        this.variablesMap.clear();
        this.variablesMap.putAll((HashMap<Character, ComplexNumber>) v.clone());
    }

    /**
     *
     * @return restores the last value of variables saved on the stack
     * @throws EmptyStackException
     */
    public HashMap<Character, ComplexNumber> restoreVar() throws EmptyStackException {
        HashMap<Character, ComplexNumber> tmp = new HashMap<Character, ComplexNumber>();
        tmp = (HashMap<Character, ComplexNumber>) this.variablesMap.clone();
        this.variablesMap = this.variableStack.pop();
        return tmp;
    }

    /**
     *
     * @return Variables{variablesMap=Map, variableStack=Stack}
     */
    @Override
    public String toString() {
        return "Variables{" + "variablesMap=" + variablesMap + ", variableStack=" + variableStack + '}';
    }

    /**
     * clear all the value in variable stack and variable map
     */
    public void clear() {
        this.variableStack.clear();
        this.variablesMap.clear();
    }

}
