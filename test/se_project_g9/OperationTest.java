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
    
    private Number n1;
    private Number n2;
    private Operation op;
    
    public OperationTest() {
    }
    
    @Before
    public void setUp() {
        n1 = new Number(9,5);
        n2 = new Number(6,3);
        op = new Operation();
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
        System.out.println("multiply");
        //When insered numbers with only real part 
        Number expResult = new Number(2,0);
        Operation instance = new Operation();
        instance.pushStack(new Number(1,0));
        instance.pushStack(new Number(2,0));
        instance.multiply();
        Number result = instance.popStack();
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
       //When insered numbers with real part and imaginary part 
        expResult = new Number(4,2);
        instance = new Operation();
        instance.pushStack(new Number(2,0));
        instance.pushStack(new Number(2,1));
        instance.multiply();
        result = instance.popStack();
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        
    }

    /**
     * Test of translate_input method, of class Operation.
     * When inserted numbers in cartesian notation
     */
    @Test
    public void testConvertNumber_inputCartesianNotationPlusPlus() {
        System.out.println("translate_input");
        String input = "1 + 2j";
        Number expResult = new Number(1.0, 2.0);
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Operation.
     * When inserted numbers in cartesian notation
     */
    @Test
    public void testConvertNumber_inputCartesianNotationPlusMinus() {
        System.out.println("translate_input");
        String input = "1 - 2j";
        Number expResult = new Number(1.0, -2.0);
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    
    /**
     * Test of translate_input method, of class Operation.
     * When inserted numbers in cartesian notation
     */
    @Test
    public void testConvertNumber_inputCartesianNotationMinusMinus() {
        System.out.println("translate_input");
        String input = "-1 - 2j";
        Number expResult = new Number(-1.0, -2.0);
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Operation.
     * When inserted numbers in cartesian notation
     */
    @Test
    public void testConvertNumber_inputCartesianNotationMinusPlus() {
        System.out.println("translate_input");
        String input = "-1 + 2j";
        Number expResult = new Number(-1.0, 2.0);
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
     /**
     * Test of translate_input method, of class Operation.
     * When inserted a number with only real part
     */
    @Test
    public void testConvertNumber_inputRealMinus() {
        System.out.println("translate_input");
        String input = "-1";
        Number expResult = new Number(-1.0);
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
     /**
     * Test of translate_input method, of class Operation.
     * When inserted a number with only real part
     */
    @Test
    public void testConvertNumber_inputRealPlus() {
        System.out.println("translate_input");
        String input = "+10";
        Number expResult = new Number(10.0);
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Operation.
     * When inserted a number with only imaginary part
     */
    @Test
    public void testConvertNumber_inputImaginaryMinus() {
        System.out.println("translate_input");
        String input = "-10j";
        Number expResult = new Number(0.0, -10.0);
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Operation.
     * When inserted a number with only imaginary part
     */
    @Test
    public void testConvertNumber_inputImaginaryPlus() {
        System.out.println("translate_input");
        String input = "+10j";
        Number expResult = new Number(0.0, +10.0);
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    
}
