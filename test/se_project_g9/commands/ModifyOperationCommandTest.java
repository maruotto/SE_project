/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9.commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project_g9.Interpreter;
import se_project_g9.Operation;
import se_project_g9.UDAllOp;
import se_project_g9.UDOperation;
import se_project_g9.exceptions.CalculatorException;

/**
 *
 * @author idamaruotto
 */
public class ModifyOperationCommandTest {
    
    private String key = "nome";
    private UDAllOp map;
    private UDOperation value;
    private UDOperation oldValue;
    
    
    public ModifyOperationCommandTest() {
        Interpreter.setOperation(Operation.getInstance());
        UDOperation op = new UDOperation();
        map = new UDAllOp();
        map.put(key, op);
        try {
            value = new UDOperation("+ -");
        } catch (CalculatorException ex) {
            Logger.getLogger(ModifyOperationCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    /**
     * Test of execute method, of class ModifyOperationCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("ModifyOperation execute");
        Command cm = new ModifyOperationCommand(map, key, value);
        oldValue = map.get(key);
        System.out.println(value.toString());
        cm.execute();
        value = map.get(key);
        assertTrue(map.containsKey(key));
        assertEquals(map.get(key), value);
    }

    /**
     * Test of undo method, of class ModifyOperationCommand.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("ModifyOperation undo");       
        Command cm = new ModifyOperationCommand(map,key, value);
        oldValue = map.get(key);
        cm.execute();
        cm.undo();
        assertTrue(map.containsKey(key));
        assertEquals(map.get(key), oldValue);
        
    }
    
}
