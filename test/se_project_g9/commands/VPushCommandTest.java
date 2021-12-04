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
public class VPushCommandTest {
    
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber n1;
    private Character key;
    private Variables vars;
    
    public VPushCommandTest() throws Exception {
        stack = new NumberStack();
        n1 = new ComplexNumber(3,4);
        key = Character.valueOf('c');
        vars = new Variables();
        vars.setVariableValue(key, n1);
        
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class VPushCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        Command cm = new VPushCommand(vars,key,stack);
        cm.execute();
        ComplexNumber exp = stack.peek();
        assertEquals(1,stack.size());
        assertEquals(exp,vars.getVariableValue(key));
        
    }

    /**
     * Test of undo method, of class VPushCommand.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("VPush undo");
        Command cm = new VPushCommand(vars,key,stack);
        cm.execute();
        cm.undo();
        assertEquals(0,stack.size());
        
    }
    
}
