/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.UDAllOp;
import se_project_g9.UDOperation;

/**
 *
 * @author group 9
 */
public class DeleteOperationCommand implements Command{
    
    private UDAllOp map;
    private String key;
    private UDOperation oldValue;
    
    
    /**
     * Constructs a new DeleteCommand
     * @param map the reference UDAllOp that contains all the commands
     * @param key the reference String that contains the label of command
     */
    public DeleteOperationCommand(UDAllOp map,String key){
        assert map != null;
        assert key != null;
        this.map = map;
        this.key = key;
    }

    /**
     * Execute of the DeleteOperationCommand
     */
    @Override
    public void execute(){
       oldValue = map.get(key);
       map.remove(key);
    }

    /**
     * Undo of the DeleteOperationCommand
     */
    @Override
    public void undo(){
        map.put(key, oldValue);
    }

    /**
     * Returns a string representation of DeleteOperationCommand
     * @return
     */ 
    @Override
    public String toString() {
        return "delete Operation";
    }
}
