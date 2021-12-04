/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9.commands;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project_g9.ComplexNumber;
import se_project_g9.NumberStack;
import se_project_g9.PersonalizedStack;
import se_project_g9.Variables;

/**
 *
 * @author luigi
 */
public class VInsertCommandTest {
    
    private PersonalizedStack<ComplexNumber> stack;
    private Variables vars;
    private Character key;
    private ComplexNumber n1;
    
    
    
    
    public VInsertCommandTest() {
        stack = new NumberStack();
        vars = new Variables();
        n1 = new ComplexNumber(4,5);
        stack.push(n1);
        key = Character.valueOf('c');
        
    }
    
   
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class VInsertCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("VInsert execute");
        Command cm = new VInsertCommand(vars,stack,key);
        cm.execute();
        assertEquals(0,stack.size());
        assertEquals(n1,vars.getVariableValue(key));
        
        
    }

    /**
     * Test of undo method, of class VInsertCommand.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("VInsert undo");
        Command cm = new VInsertCommand(vars,stack,key);
        cm.execute();
        cm.undo();
        assertEquals(1,stack.size());
        assertEquals(n1,stack.peek());
        assertFalse(vars.getVariablesMap().containsKey(key));
    }
    
}
