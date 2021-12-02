/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author group 9
 */
public class Variables {

    private final HashMap<Character, ComplexNumber> variablesMap;
    private final Stack<HashMap> variableStack;

    public Variables() {
        this.variablesMap = new HashMap<Character, ComplexNumber>();
        this.variableStack = new Stack<HashMap>();
    }

    public void setVariableValue(Character key, ComplexNumber value) throws Exception {
        if (variablesMap.put(key, value) == null) {
            throw new Exception("Can't put value in variablesMap");
        }
    }

    public ComplexNumber getVariableValue(Character key) throws Exception {
        if (variablesMap.containsKey(key)){
           return variablesMap.get(key); 
        }else{
            throw new Exception("Key not found");
        }
        
    }
    
    

}
