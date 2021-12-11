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
public class SwapCommandTest {
    private Command swap;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber n1;
    private ComplexNumber n2;
    
    public SwapCommandTest() {
        stack = new NumberStack<>();
        swap = new SwapCommand(stack);
        
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
     * Test of execute method, of class SwapCommand.
     */
    @Test
    public void testExecute() throws CalculatorException {
        stack.push(n1);
        stack.push(n2);
        System.out.println(stack);
        swap.execute();
        assertEquals(2, stack.size());
        assertEquals(n1, stack.pop());
        assertEquals(n2, stack.pop());
    }
    
    @Test (expected = Exception.class)
    public void testExecute_void() throws Exception {
        swap.execute();
    }

    /**
     * Test of undo method, of class SwapCommand.
     */
    @Test
    public void testUndo() throws CalculatorException {
        stack.push(n1);
        stack.push(n2);
        swap.execute();
        swap.undo();
        assertEquals(2, stack.size());
        assertEquals(stack.pop(), n2);
        assertEquals(stack.pop(), n1);
        
    }
    
}
