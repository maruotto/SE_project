/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import java.lang.Exception;

/**
 *
 * @author idamaruotto
 */
public class OperationTest {
    
    private Number n1;
    private Number n2;
    private Number m1;
    private Number m2;
    private Number m3;
    private Number s1;
    private Number r1;
    private Operation op;
    
    public OperationTest() {
        op = new Operation();
    }

    @Before
    public void setUp() {
        n1 = new Number(9,5);
        n2 = new Number(6,3);
        m1 = new Number(2,0);
        m2 = new Number(2,1);
        m3 = new Number(1,0);
        s1 = new Number(3, 4);
        r1 = new Number(15, 8);
        
        
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
    public void testMultiply_onlyReal() {
        System.out.println("multiply one");
        //When insered numbers with only real part 
        Number expResult = new Number(2,0);
        op.pushStack(m1);
        
        System.out.println(op.getNumberStack());
        op.pushStack(m3);
        System.out.println(op.getNumberStack());
        op.multiply();
        
        Number result = op.popStack();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of multiply method, of class Operation.
     */
    @Test
    public void testMultiply_complete() {
        System.out.println("multiply two");
        //When insered numbers with real part and imaginary part 
        Number expResult = new Number(4,2);
        op.pushStack(m1);
        op.pushStack(m2);
        
        op.multiply();
        
        Number result = op.popStack();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of translate_input method, of class Operation.
     * When inserted numbers in cartesian notation
     */
    @Test
    public void testConvertNumber_inputCartesianNotationPlusPlus() throws Exception {
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
    public void testConvertNumber_inputCartesianNotationPlusMinus() throws Exception {
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
    public void testConvertNumber_inputCartesianNotationMinusMinus() throws Exception {
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
    public void testConvertNumber_inputCartesianNotationMinusPlus() throws Exception {
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
    public void testConvertNumber_inputRealMinus() throws Exception {
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
    public void testConvertNumber_inputRealPlus() throws Exception {
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
    public void testConvertNumber_imaginarySimple() throws Exception {
        System.out.println("translate_input");
        String input = "-j";
        Number expResult = new Number(0.0, -1.0);
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Operation.
     * When inserted a number with only imaginary part
     */
    @Test
    public void testConvertNumber_inputImaginaryPlus() throws Exception {
        System.out.println("translate_input");
        String input = "+10j";
        Number expResult = new Number(0.0, +10.0);
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    

    /**
     * Test of translate_input method, of class Operation.
     */
    @Test (expected = Exception.class)
    public void testTranslate_input() throws Exception {
        System.out.println("translate_input");
        String input = "abcd";
        Operation instance = new Operation();
        instance.translate_input(input);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of convert_number method, of class Operation.
     */
    @Test (expected = Exception.class)
    public void testConvert_number() throws Exception {
        System.out.println("convert_number");
        String input = "";
        Number expResult = null;
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test (expected = Exception.class)
    public void testConvert_number_wrong_input() throws Exception {
        System.out.println("convert_number");
        String input = "abcd";
        Number expResult = null;
        Number result = Operation.convert_number(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test (expected = Exception.class)
    public void testConvert_number_more_number() throws Exception {
        System.out.println("convert_number");
        String input = "10 -10j +10";
        Number expResult = null;
        Number result = Operation.convert_number(input);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberStack method, of class Operation.
     */
    @Test
    public void testGetNumberStack() {
        System.out.println("getNumberStack");
        PersonalizedStack<Number> expResult = new NumberStack<>();
        PersonalizedStack<Number> result = op.getNumberStack();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of pushStack method, of class Operation.
     */
    @Test
    public void testPushStack() {
        System.out.println("pushStack");
        boolean expResult = true;
        boolean result = op.pushStack(n1);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of popStack method, of class Operation.
     */
    @Test
    public void testPopStack() {       
        System.out.println("popStack");
        op.pushStack(n1);
        Number expResult = n1;
        Number result = op.popStack();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of multiply method, of class Operation.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        op.pushStack(m1);
        op.pushStack(m3);
        op.multiply();
        assertEquals(op.popStack(), m1);

    }

    /**
     * Test of sqrt method, of class Operation.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        op.pushStack(s1);        
        op.sqrt();
        assertEquals(op.popStack(), m2);
    }

    /**
     * Test of sum method, of class Operation.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        op.pushStack(n1);
        op.pushStack(n2);
        op.sum();
        assertEquals(op.popStack(), r1);
    }

    /**
     * Test of sub method, of class Operation.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        op.pushStack(n1);
        op.pushStack(r1);
        op.sub();
        assertEquals(op.popStack(), n2);
    }

    /**
     * Test of divide method, of class Operation.
     */
    @Test
    public void testDivide() throws Exception {
        System.out.println("divide");
        op.pushStack(m3);
        op.pushStack(m1);
        op.divide();
        assertEquals(op.popStack(), m1);
    }

    /**
     * Test of clear method, of class Operation.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        op.clear();
        assertEquals(op.getNumberStack().size(), 0);
    }
    
    
    
    
}
