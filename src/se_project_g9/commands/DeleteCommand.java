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
public class DeleteCommand implements Command{
    
    private UDAllOp map;
    private String key;
    private UDOperation oldValue;
    
    
    
    public DeleteCommand(UDAllOp map,String key){
        this.map = map;
        this.key = key;
    }

    @Override
    public void execute(){
       oldValue = map.get(key);
       map.remove(key);
    }

    @Override
    public void undo(){
        map.put(key, oldValue);
    }

    @Override
    public String toString() {
        return "delete Operation";
    }
}
