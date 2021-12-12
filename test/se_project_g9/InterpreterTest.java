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
public class InterpreterTest {
    
    private Operation op;
    public InterpreterTest() {
        op = Operation.getInstance();
        Interpreter.setOperation(op);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of translate_input method, of class Interpreter.
     * When inserted numbers in cartesian notation
     */
    @Test
    public void testConvertNumber_inputCartesianNotationPlusPlus() throws Exception {
        System.out.println("translate_input");
        String input = "1 + 2j";
        ComplexNumber expResult = new ComplexNumber(1.0, 2.0);
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Interpreter.
     * When inserted numbers in cartesian notation
     */
    @Test
    public void testConvertNumber_inputCartesianNotationPlusMinus() throws Exception {
        System.out.println("translate_input");
        String input = "1 - 2j";
        ComplexNumber expResult = new ComplexNumber(1.0, -2.0);
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    
    /**
     * Test of translate_input method, of class Interpreter.
     * When inserted numbers in cartesian notation
     */
    @Test
    public void testConvertNumber_inputCartesianNotationMinusMinus() throws Exception {
        System.out.println("translate_input");
        String input = "-1 - 2j";
        ComplexNumber expResult = new ComplexNumber(-1.0, -2.0);
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Interpreter.
     * When inserted numbers in cartesian notation
     */
    @Test
    public void testConvertNumber_inputCartesianNotationMinusPlus() throws Exception {
        System.out.println("translate_input");
        String input = "-1 + 2j";
        ComplexNumber expResult = new ComplexNumber(-1.0, 2.0);
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
     /**
     * Test of translate_input method, of class Interpreter.
     * When inserted a number with only real part
     */
    @Test
    public void testConvertNumber_inputRealMinus() throws Exception {
        System.out.println("translate_input");
        String input = "-1";
        ComplexNumber expResult = new ComplexNumber(-1.0);
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
     /**
     * Test of translate_input method, of class Interpreter.
     * When inserted a number with only real part
     */
    @Test
    public void testConvertNumber_inputRealPlus() throws Exception {
        System.out.println("translate_input");
        String input = "+10";
        ComplexNumber expResult = new ComplexNumber(10.0);
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    
    /**
     * Test of translate_input method, of class Interpreter.
     * When inserted a number with only imaginary part
     */
    @Test
    public void testConvertNumber_imaginarySimple() throws Exception {
        System.out.println("translate_input");
        String input = "-j";
        ComplexNumber expResult = new ComplexNumber(0.0, -1.0);
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Interpreter.
     * When inserted a number with only imaginary part
     */
    @Test
    public void testConvertNumber_inputImaginaryPlus() throws Exception {
        System.out.println("translate_input");
        String input = "+10j";
        ComplexNumber expResult = new ComplexNumber(0.0, +10.0);
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Interpreter.
     * When inserted a number with only imaginary part
     */
    @Test
    public void testConvertNumber_startsJ() throws Exception {
        System.out.println("translate_input");
        String input = "j";
        ComplexNumber expResult = new ComplexNumber(0.0, 1);
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Interpreter.
     * When inserted a number with only imaginary part
     */
    @Test
    public void testConvertNumber_startsJ_complex() throws Exception {
        System.out.println("translate_input");
        String input = "+j + 4.5";
        ComplexNumber expResult = new ComplexNumber(4.5, 1);
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Interpreter.
     */
    @Test (expected = Exception.class)
    public void testConvertNumber_wrongFormat() throws Exception {
        System.out.println("translate_input");
        String input = "10+";
        ComplexNumber expResult = new ComplexNumber(10.0, 0.0);
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    

    /**
     * Test of translateInput method, of class Interpreter.
     */
    @Test (expected = Exception.class)
    public void testTranslateInput() throws Exception {
        System.out.println("translate_input");
        String input = "abcd";
        Interpreter.setOperation(op);
        Interpreter.translateInput(input, false);

    }

    /**
     * Test of convertNumber method, of class Interpreter.
     */
    @Test (expected = Exception.class)
    public void testConvertNumber() throws Exception {
        System.out.println("convertNumber");
        String input = "";
        ComplexNumber expResult = null;
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);

    }
    
    @Test (expected = Exception.class)
    public void testConvertNumber_wrong_input() throws Exception {
        System.out.println("convertNumber");
        String input = "abcd";
        ComplexNumber expResult = null;
        ComplexNumber result = Interpreter.convertNumber(input);

    }
    
    @Test (expected = Exception.class)
    public void testConvertNumber_more_number() throws Exception {
        System.out.println("convertNumber");
        String input = "10 -10j +10";
        ComplexNumber expResult = null;
        ComplexNumber result = Interpreter.convertNumber(input);
        assertEquals(expResult, result);

    }
}
