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
public class SqrtCommandTest {
    
    private Command sqrt;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber n1;
    
    public SqrtCommandTest() {
        stack = new NumberStack<>();
        sqrt = new SqrtCommand(stack);
        
    }
    
    @Before
    public void setUp() {
       n1 = new ComplexNumber(3,5);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class SqrtCommand.
     */
    @Test
    public void testExecute() throws Exception {
        stack.push(n1);
        sqrt.execute();
        assertEquals(stack.pop(), BasicOperation.sqrt(n1));
    }

    /**
     * Test of undo method, of class SqrtCommand.
     */
    @Test
    public void testUndo() throws CalculatorException {
        stack.push(n1);
        sqrt.execute();
        sqrt.undo();
        assertEquals(stack.pop(), n1);
    }
    
}
