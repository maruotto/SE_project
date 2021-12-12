/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9.commands;

import org.junit.Test;
import static org.junit.Assert.*;
import se_project_g9.UDAllOp;
import se_project_g9.UDOperation;

/**
 *
 * @author luigi
 */
public class DeleteOperationCommandTest {
    
    private String key = "key";
    private UDAllOp map;
    private UDOperation oldValue;
    
    
    public DeleteOperationCommandTest() {
        
        UDOperation op = new UDOperation();
        map = new UDAllOp();
        map.put(key, op);

        
    }

    /**
     * Test of execute method, of class DeleteOperationCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Delete execute");
        Command cm = new DeleteOperationCommand(map,key);
        oldValue = map.get(key);
        System.out.println(oldValue.toString());
        cm.execute();
        assertFalse(map.containsKey(key));
    }

    /**
     * Test of undo method, of class DeleteOperationCommand.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("Delete undo");
        Command cm = new DeleteOperationCommand(map,key);
        oldValue = map.get(key);
        cm.execute();
        cm.undo();
        assertEquals(oldValue,map.get(key));
        
    }
    
}
