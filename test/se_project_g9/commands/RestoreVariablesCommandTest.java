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
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author group 9
 */
public class RestoreVariablesCommandTest {
    private Variables vars;
    private PersonalizedStack<ComplexNumber> stack;
    
    
    public RestoreVariablesCommandTest() { 
    }
    
    @Before
    public void setUp() throws InputNumberException {
        stack = new NumberStack();
        vars = new Variables();
        stack.push(new ComplexNumber(1, 0));
        stack.push(new ComplexNumber(2, 0));
        
        VInsertCommand v2 = new VInsertCommand(vars,stack,'b');
        v2.execute();
        VInsertCommand v1 = new VInsertCommand(vars,stack,'a');
        v1.execute();
        
        SaveVariablesCommand save = new SaveVariablesCommand(vars);
        save.execute();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class RestoreVariablesCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("\nTest execute");
        vars.setVariableValue('a', new ComplexNumber(8, 0));
        vars.setVariableValue('b', new ComplexNumber(12, 3));
        
        assertEquals(new ComplexNumber(8, 0), vars.getVariableValue('a'));
        assertEquals(new ComplexNumber(12, 3), vars.getVariableValue('b'));
        
        System.out.println("Before:");
        System.out.println(vars.getVariableValue('a'));
        System.out.println(vars.getVariableValue('b'));
        
        RestoreVariablesCommand restore = new RestoreVariablesCommand(vars);
        restore.execute();
        
        System.out.println("\nAfter:");
        System.out.println(vars.getVariableValue('a'));
        System.out.println(vars.getVariableValue('b'));
        
        assertEquals(new ComplexNumber(1, 0), vars.getVariableValue('a'));
        assertEquals(new ComplexNumber(2, 0), vars.getVariableValue('b'));
    }

    /**
     * Test of undo method, of class RestoreVariablesCommand.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println("\nTest undo");
        vars.setVariableValue('a', new ComplexNumber(8, 0));
        vars.setVariableValue('b', new ComplexNumber(12, 3));
        
        assertEquals(new ComplexNumber(8, 0), vars.getVariableValue('a'));
        assertEquals(new ComplexNumber(12, 3), vars.getVariableValue('b'));
        
        System.out.println("Before:");
        System.out.println(vars.getVariableValue('a'));
        System.out.println(vars.getVariableValue('b'));
        
        RestoreVariablesCommand restore = new RestoreVariablesCommand(vars);
        restore.execute();
        
        System.out.println("\nAfter execute:");
        System.out.println(vars.getVariableValue('a'));
        System.out.println(vars.getVariableValue('b'));
        
        assertEquals(new ComplexNumber(1, 0), vars.getVariableValue('a'));
        assertEquals(new ComplexNumber(2, 0), vars.getVariableValue('b'));
        
        restore.undo();
        
        System.out.println("\nAfter undo:");
        System.out.println(vars.getVariableValue('a'));
        System.out.println(vars.getVariableValue('b'));
    }

    /**
     * Test of toString method, of class RestoreVariablesCommand.
     */
    @Test
    public void testToString() {
        System.out.println("\ntoString");
        RestoreVariablesCommand restore = new RestoreVariablesCommand(vars);
        System.out.println(restore.toString());
        String expResult = "restore";
        String result = restore.toString();
        assertEquals(expResult, result);
    }
    
}
