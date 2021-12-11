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
import se_project_g9.exceptions.ZeroDivisionException;

/**
 *
 * @author idamaruotto
 */
public class MultiplyCommandTest {
    
    private Command multiply;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber n1;
    private ComplexNumber n2;
    
    public MultiplyCommandTest() {
        stack = new NumberStack<>();
        multiply = new MultiplyCommand(stack);
        
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
     * Test of execute method, of class MultiplyCommand.
     */
    @Test
    public void testExecute() throws Exception {
        stack.push(n1);
        stack.push(n2);
        multiply.execute();
        assertEquals(stack.pop(), BasicOperation.multiply(n1, n2));
    }

    /**
     * Test of undo method, of class MultiplyCommand.
     */
    @Test
    public void testUndo() throws CalculatorException {
        stack.push(n1);
        stack.push(n2);
        multiply.execute();
        multiply.undo();
        assertEquals(stack.pop(), n2);
        assertEquals(stack.pop(), n1);
    }

    
}
