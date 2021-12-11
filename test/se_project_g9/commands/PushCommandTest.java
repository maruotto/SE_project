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
public class PushCommandTest {
    private Command push;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber n1;
    private ComplexNumber n2;
    
    public PushCommandTest() {
        n1 = new ComplexNumber(13,7);
        stack = new NumberStack<>();
        push = new PushCommand(stack, n1);
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class PushCommand.
     */
    @Test
    public void testExecute() throws CalculatorException {
        push.execute();
        assertEquals(1, stack.size());
        assertEquals(n1, stack.pop());
    }
    
    /**
     * Test of undo method, of class PushCommand.
     */
    @Test
    public void testUndo() throws CalculatorException {
        push.execute();
        push.undo();
        assertEquals(0, stack.size());
    }
}
