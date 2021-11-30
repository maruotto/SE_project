/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author lucia
 */
public class Variables {

    private final HashMap<Character, Number> variablesMap;
    private final Stack<HashMap> variableStack;

    public Variables() {
        this.variablesMap = new HashMap<Character, Number>();
        this.variableStack = new Stack<HashMap>();
    }

    public void setVariable(Character key, Number value) throws Exception {
        if (variablesMap.put(key, value) == null) {
            throw new Exception("Can't put value in variablesMap");
        }
    }

    public Number getVariable(Character key) throws Exception {
        if (variablesMap.containsKey(key)){
           return variablesMap.get(key); 
        }else{
            throw new Exception("Key not found");
        }
        
    }
    
    

}
