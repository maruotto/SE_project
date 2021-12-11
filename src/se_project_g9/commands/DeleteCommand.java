/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import java.util.HashMap;
import se_project_g9.UDAllOp;
import se_project_g9.UDOperation;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author group 9
 */
public class DeleteCommand implements Command{
    
    private UDAllOp map;
    private String key;
    private UDOperation oldValue;
    
    
    /**
     * Constructs a new DeleteCommand
     * @param map the reference UDAllOp that contains all the commands
     * @param key the reference String that contains the label of command
     */
    public DeleteCommand(UDAllOp map,String key){
        this.map = map;
        this.key = key;
    }

    /**
     * Execute of the DeleteCommand
     * @throws InputNumberException
     */
    @Override
    public void execute() throws InputNumberException {
       oldValue = map.get(key);
       map.remove(key);
    }

    /**
     * Undo of the DeleteCommand
     * @throws InputNumberException
     */
    @Override
    public void undo() throws InputNumberException {
        map.put(key, oldValue);
    }

    /**
     * Returns a string representation of DeleteCommand
     * @return
     */ 
    @Override
    public String toString() {
        return "delete Operation";
    }
}
