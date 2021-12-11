/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9.commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project_g9.ComplexNumber;
import se_project_g9.NumberStack;
import se_project_g9.PersonalizedStack;
import se_project_g9.exceptions.CalculatorException;

/**
 *
 * @author idamaruotto
 */
public class DupCommandTest {
    private Command dup;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber n1;
    private ComplexNumber n2;
    
    public DupCommandTest() {
        stack = new NumberStack<>();
        dup = new DupCommand(stack);
        
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
     * Test of execute method, of class DupCommand.
     */
    @Test
    public void testExecute() throws CalculatorException {
        stack.push(n1);
        System.out.println(stack);
        dup.execute();
        assertEquals(2, stack.size());
        assertEquals(n1, stack.pop());
        assertEquals(n1, stack.pop());
    }
    
    @Test (expected = Exception.class)
    public void testExecute_void() throws Exception {
        dup.execute();
    }

    /**
     * Test of undo method, of class DupCommand.
     */
    @Test
    public void testUndo() throws CalculatorException {
        stack.push(n1);
        dup.execute();
        dup.undo();
        assertEquals(1, stack.size());
        assertEquals(stack.pop(), n1);
        
    }
    
    
    
}
