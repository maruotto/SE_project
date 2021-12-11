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
public class DivideCommandTest {
    
    private Command divide;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber n1;
    private ComplexNumber n2;
    
    public DivideCommandTest() {
        stack = new NumberStack<>();
        divide = new DivideCommand(stack);
        
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
     * Test of execute method, of class DivideCommand.
     */
    @Test
    public void testExecute() throws Exception {
        stack.push(n1);
        stack.push(n2);
        divide.execute();
        assertEquals(stack.pop(), BasicOperation.divide(n1, n2));
    }

    /**
     * Test of undo method, of class DivideCommand.
     */
    @Test
    public void testUndo() throws CalculatorException {
        stack.push(n1);
        stack.push(n2);
        divide.execute();
        divide.undo();
        assertEquals(stack.pop(), n2);
        assertEquals(stack.pop(), n1);
    }
    
    /**
     * Test of divide method, of class Operation.
     */

    /**
     * Test of divide method, of class Operation.
     */
    @Test (expected = Exception.class)
    public void testDivide_zero() throws Exception {
        System.out.println("divide");
        stack.push(n1);
        stack.push(new ComplexNumber(0,0));
        divide.execute();
        
    }
    
}
