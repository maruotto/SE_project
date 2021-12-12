/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.UDAllOp;
import se_project_g9.UDOperation;
import se_project_g9.exceptions.OperationException;

/**
 *
 * @author idamaruotto
 */
public class ModifyOperationCommand implements Command {

    private final String key;
    private UDOperation oldValue = null;
    private final UDOperation newValue;
    private final UDAllOp operations;
    
    /**
     * Constructs a new OperationCommand
     * @param operations the reference UDAllOp that contains all the commands
     * @param key the reference String that contains the label of command
     * @param newValue the reference UDOperation that contains the list of all commands of an operation
     */
    public ModifyOperationCommand(UDAllOp operations, String key, UDOperation newValue) {
        assert operations != null;
        assert key != null;
        assert newValue != null;
        this.key = key;
        this.operations = operations;
        this.newValue = newValue;
    }

    /**
     * Execute of the ModifyOperationCommand
     * @throws OperationException
     */
    @Override
    public void execute() throws OperationException {
        if(!operations.containsKey(key))
            throw new OperationException("Operation not present in map");
        oldValue = operations.put(key, newValue);
    }

    /**
     * Undo of the ModifyOperationCommand
     */
    @Override
    public void undo(){
        operations.put(key, oldValue);
    }

}
