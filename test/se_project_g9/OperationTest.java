/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author idamaruotto
 */
public class OperationTest {
    
    public OperationTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of invert method, of class Operation.
     */
    @Test
    public void testInvert() {
        /*System.out.println("invert");
        Operation instance = new Operation();
        instance.invert();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        */
    }

    /**
     * Test of multiply method, of class Operation.
     */
    @Test
    public void testMultiply() {
        /*System.out.println("multiply");
        Operation instance = new Operation();
        instance.multiply();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
        */
    }

    /**
     * Test of translate_input method, of class Operation.
     * When inserted a number in cartesian notation
     */
    @Test
    public void testTranslate_input_cartesian_notation() {
        System.out.println("translate_input");
        String input = "1 + 2j";
        Number expResult = new Number(1.0, 2.0);
        Number result = Operation.translate_input(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
     /**
     * Test of translate_input method, of class Operation.
     * When inserted a number with only real part
     */
    @Test
    public void testTranslate_input_real() {
        System.out.println("translate_input");
        String input = "-1";
        Number expResult = new Number(-1.0);
        Number result = Operation.translate_input(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Operation.
     * When inserted a number with only imaginary part
     */
    @Test
    public void testTranslate_input_imaginary() {
        System.out.println("translate_input");
        String input = "-10j";
        Number expResult = new Number(0.0, -10.0);
        Number result = Operation.translate_input(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    
}
