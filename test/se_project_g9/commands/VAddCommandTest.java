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
public class VAddCommandTest {
    
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber n1;
    private Variables vars;
    private Character key;
    
    
    
    public VAddCommandTest() throws Exception {
        stack = new NumberStack();
        n1 = new ComplexNumber(3,4);
        stack.push(n1);
        vars = new Variables();
        key = Character.valueOf('c');
        vars.setVariableValue(key,new ComplexNumber(2,1));
    }
    
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class VAddCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("VAdd execute");
        Command cm = new VAddCommand(vars,key,stack);
        cm.execute();
        ComplexNumber exp = new ComplexNumber(5,5);
        assertEquals(0,stack.size());
        assertEquals(exp,vars.getVariableValue(key));
        
        
    }

    /**
     * Test of undo method, of class VAddCommand.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("undo");
        Command cm = new VAddCommand(vars,key,stack);
        cm.execute();
        cm.undo();
        ComplexNumber exp = new ComplexNumber(2,1);
        assertEquals(1,stack.size());
        assertEquals(n1,stack.peek());
        assertEquals(exp,vars.getVariableValue(key));
        
    }
    
}
