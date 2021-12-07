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

    public Variables() {
        this.variablesMap = new HashMap<Character, ComplexNumber>();
        this.variableStack = new Stack<HashMap>();
        
    }
    
    private Variables(HashMap<Character, ComplexNumber> variablesMap, Stack<HashMap> variableStack){
        this.variablesMap = variablesMap;
        this.variableStack = variableStack;
    }

    public void setVariableValue(Character key, ComplexNumber value) throws Exception {
        if(key == null){
            throw new Exception("key not specified...");
        }
        variablesMap.put(key, value); 
            
        
    }

    public ComplexNumber getVariableValue(Character key) throws Exception {
        if (variablesMap.containsKey(key)){
           return variablesMap.get(key); 
        }else{
            throw new Exception("Key not found");
        }
        
    }
    
    public HashMap<Character, ComplexNumber> getVariablesMap(){
        return variablesMap;
    }
    
    public Variables clone(){
        return new Variables((HashMap<Character, ComplexNumber>)this.variablesMap.clone(), (Stack<HashMap>) this.variableStack.clone());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.variablesMap);
        hash = 23 * hash + Objects.hashCode(this.variableStack);
        return hash;
    }

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

    public boolean addAll(Variables other){
        if(other.variablesMap==null || other.variableStack == null)
            return false;
        this.variableStack.addAll(other.variableStack);
        this.variablesMap.putAll(other.variablesMap);
        return true;
    }
    
    public void saveVar() {
        this.variableStack.push((HashMap) variablesMap.clone());
    }
    
    public void insertVar(HashMap<Character, ComplexNumber> v) {
        this.variablesMap = (HashMap) v.clone();
    }
    
    public HashMap<Character, ComplexNumber> restoreVar() throws EmptyStackException{
        HashMap<Character, ComplexNumber> tmp = new HashMap<Character, ComplexNumber>();
        tmp = (HashMap<Character, ComplexNumber>) this.variablesMap.clone();
        this.variablesMap = this.variableStack.pop();
        return tmp;
    }
    
    @Override
    public String toString() {
        return "Variables{" + "variablesMap=" + variablesMap + ", variableStack=" + variableStack + '}';
    }

    public void clear() {
        this.variableStack.clear();
        this.variablesMap.clear();
    }
    
    

}
