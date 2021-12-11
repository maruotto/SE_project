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
public class InvertCommandTest {
    
    private Command invert;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber n1;
    private ComplexNumber r1;
    
    public InvertCommandTest() {
        stack = new NumberStack<>();
        invert = new InvertCommand(stack);
        
    }
    
    @Before
    public void setUp() {
       n1 = new ComplexNumber(3,5);
       r1 = new ComplexNumber(-3,-5);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class InvertCommand.
     */
    @Test
    public void testExecute() throws CalculatorException {
        stack.push(n1);
        invert.execute();
        assertEquals(1, stack.size());
        assertEquals(r1, stack.pop());
    }
    
    @Test (expected = Exception.class)
    public void testExecute_void() throws Exception {
        invert.execute();
    }

    /**
     * Test of undo method, of class InvertCommand.
     */
    @Test
    public void testUndo() throws CalculatorException {
        stack.push(n1);
        invert.execute();
        invert.undo();
        assertEquals(1, stack.size());
        assertEquals(n1, stack.pop());
        
    }
    
}
