/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9.commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project_g9.BasicOperation;
import se_project_g9.ComplexNumber;
import se_project_g9.NumberStack;
import se_project_g9.PersonalizedStack;
import se_project_g9.exceptions.CalculatorException;

/**
 *
 * @author idamaruotto
 */
public class DropCommandTest {
    private Command drop;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber n1;
    private ComplexNumber n2;
    
    public DropCommandTest() {
        stack = new NumberStack<>();
        drop = new DropCommand(stack);
        
    }
    
    @Before
    public void setUp() {
       n1 = new ComplexNumber(3,5);
       n2 = new ComplexNumber(5,8);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class DropCommand.
     */
    @Test
    public void testExecute() throws CalculatorException {
        stack.push(n1);
        System.out.println(stack);
        drop.execute();
        assertEquals(0, stack.size());
    }
    
    @Test (expected = Exception.class)
    public void testExecute_void() throws Exception {
        drop.execute();
    }

    /**
     * Test of undo method, of class DropCommand.
     */
    @Test
    public void testUndo() throws CalculatorException {
        stack.push(n1);
        drop.execute();
        drop.undo();
        assertEquals(stack.pop(), n1);
        
    }
    
}
