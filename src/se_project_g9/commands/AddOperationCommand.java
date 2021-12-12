/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9.commands;

import se_project_g9.UDAllOp;
import se_project_g9.UDOperation;
import se_project_g9.exceptions.CalculatorException;
import se_project_g9.exceptions.OperationException;

/**
 *
 * @author idamaruotto
 */
public class AddOperationCommand implements Command{
    private UDAllOp op;
    private String key;
    private String operations;
    private UDOperation udOp;

    public AddOperationCommand(UDAllOp op, String key, String operations) {
        assert op != null;
        assert key != key;
        assert operations != null;
        this.op = op;
        this.key = key;
        this.operations = operations;
        this.udOp = null;
    }
    
    public AddOperationCommand(UDAllOp op, String key, UDOperation operations) {
        this.op = op;
        this.key = key;
        this.udOp = operations;
        this.operations = null;
    }
    
    /**
     *
     * @throws OperationException
     */
    @Override
    public void execute() throws OperationException {
        if(operations == null){
            op.put(key, udOp);
        } else {
            try {
                op.addOperation(this.key, this.operations);
            } catch (CalculatorException ex) {
                throw new OperationException("Error in sintax of operations' sequence");
            }
        }
    }

    @Override
    public void undo(){
        op.remove(key);
    }
    
    
    
}
