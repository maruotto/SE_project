/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9.commands;

import java.util.HashMap;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project_g9.ComplexNumber;
import se_project_g9.NumberStack;
import se_project_g9.UDOperation;

/**
 *
 * @author luigi
 */
public class DeleteCommandTest {
    
    private String key;
    private HashMap<String,UDOperation> map;
    private UDOperation oldValue;
    private NumberStack<ComplexNumber> stack;
    
    
    public DeleteCommandTest() {
        
        UDOperation op = new UDOperation();
        map = new HashMap<>();
        map.put(key, op);

        
    }

    /**
     * Test of execute method, of class DeleteCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Delete execute");
        Command cm = new DeleteCommand(map,key);
        oldValue = map.get(key);
        System.out.println(oldValue.toString());
        cm.execute();
        assertFalse(map.containsKey(key));
    }

    /**
     * Test of undo method, of class DeleteCommand.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("Delete undo");
        Command cm = new DeleteCommand(map,key);
        oldValue = map.get(key);
        cm.execute();
        cm.undo();
        assertEquals(oldValue,map.get(key));
        
    }
    
}
