/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.HashMap;
import se_project_g9.UDOperation;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author group 9
 */
public class DeleteCommand implements Command{
    
    private HashMap<String,UDOperation> map;
    private String key;
    private UDOperation oldValue;
    
    
    
    public DeleteCommand(HashMap<String,UDOperation> map,String key){
        this.map = map;
        this.key = key;
    }

    @Override
    public void execute() throws InputNumberException {
       oldValue = map.get(key);
       map.remove(key);
    }

    @Override
    public void undo() throws InputNumberException {
        map.put(key, oldValue);
    }

    @Override
    public String toString() {
        return "delete";
    }
}
