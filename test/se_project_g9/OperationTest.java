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
import java.util.EmptyStackException;
import se_project_g9.exceptions.NotEnoughNumbersException;

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
    /**
     * Test of translate_input method, of class Operation.
     * When inserted numbers in cartesian notation
     */
    @Test
    public void testConvertNumber_inputCartesianNotationPlusPlus() throws Exception {
        System.out.println("translate_input");
        String input = "1 + 2j";
        Number expResult = new Number(1.0, 2.0);
        Number result = Operation.convertNumber(input);
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
        Number result = Operation.convertNumber(input);
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
        Number result = Operation.convertNumber(input);
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
        Number result = Operation.convertNumber(input);
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
        Number result = Operation.convertNumber(input);
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
        Number result = Operation.convertNumber(input);
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
        Number result = Operation.convertNumber(input);
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
        Number result = Operation.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Operation.
     * When inserted a number with only imaginary part
     */
    @Test
    public void testConvertNumber_startsJ() throws Exception {
        System.out.println("translate_input");
        String input = "j";
        Number expResult = new Number(0.0, 1);
        Number result = Operation.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Operation.
     * When inserted a number with only imaginary part
     */
    @Test
    public void testConvertNumber_startsJ_complex() throws Exception {
        System.out.println("translate_input");
        String input = "+j + 4.5";
        Number expResult = new Number(4.5, 1);
        Number result = Operation.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    
    /**
     * Test of translate_input method, of class Operation.
     */
    @Test (expected = Exception.class)
    public void testConvertNumber_wrongFormat() throws Exception {
        System.out.println("translate_input");
        String input = "10+";
        Number expResult = new Number(10.0, 0.0);
        Number result = Operation.convertNumber(input);
        assertEquals(expResult, result);
        System.out.println("works\n");
    }
    

    /**
     * Test of translateInput method, of class Operation.
     */
    @Test (expected = Exception.class)
    public void testTranslateInput() throws Exception {
        System.out.println("translate_input");
        String input = "abcd";
        Operation instance = new Operation();
        instance.translateInput(input);

    }

    /**
     * Test of convertNumber method, of class Operation.
     */
    @Test (expected = Exception.class)
    public void testConvertNumber() throws Exception {
        System.out.println("convertNumber");
        String input = "";
        Number expResult = null;
        Number result = Operation.convertNumber(input);
        assertEquals(expResult, result);

    }
    
    @Test (expected = Exception.class)
    public void testConvertNumber_wrong_input() throws Exception {
        System.out.println("convertNumber");
        String input = "abcd";
        Number expResult = null;
        Number result = Operation.convertNumber(input);

    }
    
    @Test (expected = Exception.class)
    public void testConvertNumber_more_number() throws Exception {
        System.out.println("convertNumber");
        String input = "10 -10j +10";
        Number expResult = null;
        Number result = Operation.convertNumber(input);
        assertEquals(expResult, result);

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
     * Test of multiply method, of class Operation.
     */
}
