/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9.commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project_g9.*;
import se_project_g9.PersonalizedStack;
import se_project_g9.exceptions.CalculatorException;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author idamaruotto
 */
public class ClearCommandTest {
    
    private Command clear;
    private PersonalizedStack<ComplexNumber> stack;
    private ComplexNumber n1;
    private ComplexNumber n2;
    
    public ClearCommandTest() {
        stack = new NumberStack<>();
        clear = new ClearCommand(stack);
        
        
    }
    
    @Before
    public void setUp() throws CalculatorException {       
        
        n1 = new ComplexNumber(18, 34);
        n2 =  new ComplexNumber(29, 102);
        stack.push(n1);
        stack.push(n2);
        assertEquals(2, stack.size());
        clear.execute();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class ClearCommand.
     */
    @Test
    public void testExecute() throws Exception {

        assertEquals(stack.size(), 0);
    }

    /**
     * Test of undo method, of class ClearCommand.
     * @throws se_project_g9.exceptions.InputNumberException
     */
    
    //* doesn't work
    @Test
    public void testUndo() throws CalculatorException {
        clear.undo();
        //System.out.println(stack);
        assertEquals(2, stack.size());
        ComplexNumber r2 = stack.pop();
        ComplexNumber r1 = stack.pop();
        assertEquals(n2, r2);
        assertEquals(n1, r1);
    }
    //*/
    
}
