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
    
    private ComplexNumber n1;
    private ComplexNumber n2;
    private ComplexNumber m1;
    private ComplexNumber m2;
    private ComplexNumber m3;
    private ComplexNumber s1;
    private ComplexNumber r1;
    private Operation op;
    
    public OperationTest() {
        op = new Operation();
    }


    @Before
    public void setUp() {
        n1 = new ComplexNumber(9,5);
        n2 = new ComplexNumber(6,3);
        m1 = new ComplexNumber(2,0);
        m2 = new ComplexNumber(2,1);
        m3 = new ComplexNumber(1,0);
        s1 = new ComplexNumber(3, 4);
        r1 = new ComplexNumber(15, 8);
        
        
    }
    /**
     * Test of translate_input method, of class Operation.
     * When inserted numbers in cartesian notation
     */
    @Test
    public void testConvertNumber_inputCartesianNotationPlusPlus() throws Exception {
        System.out.println("translate_input");
        String input = "1 + 2j";
        ComplexNumber expResult = new ComplexNumber(1.0, 2.0);
        ComplexNumber result = Operation.convertNumber(input);
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
        ComplexNumber expResult = new ComplexNumber(1.0, -2.0);
        ComplexNumber result = Operation.convertNumber(input);
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
        ComplexNumber expResult = new ComplexNumber(-1.0, -2.0);
        ComplexNumber result = Operation.convertNumber(input);
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
        ComplexNumber expResult = new ComplexNumber(-1.0, 2.0);
        ComplexNumber result = Operation.convertNumber(input);
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
        ComplexNumber expResult = new ComplexNumber(-1.0);
        ComplexNumber result = Operation.convertNumber(input);
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
        ComplexNumber expResult = new ComplexNumber(10.0);
        ComplexNumber result = Operation.convertNumber(input);
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
        ComplexNumber expResult = new ComplexNumber(0.0, -1.0);
        ComplexNumber result = Operation.convertNumber(input);
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
        ComplexNumber expResult = new ComplexNumber(0.0, +10.0);
        ComplexNumber result = Operation.convertNumber(input);
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
        ComplexNumber expResult = new ComplexNumber(0.0, 1);
        ComplexNumber result = Operation.convertNumber(input);
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
        ComplexNumber expResult = new ComplexNumber(4.5, 1);
        ComplexNumber result = Operation.convertNumber(input);
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
        ComplexNumber expResult = new ComplexNumber(10.0, 0.0);
        ComplexNumber result = Operation.convertNumber(input);
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
        ComplexNumber expResult = null;
        ComplexNumber result = Operation.convertNumber(input);
        assertEquals(expResult, result);

    }
    
    @Test (expected = Exception.class)
    public void testConvertNumber_wrong_input() throws Exception {
        System.out.println("convertNumber");
        String input = "abcd";
        ComplexNumber expResult = null;
        ComplexNumber result = Operation.convertNumber(input);

    }
    
    @Test (expected = Exception.class)
    public void testConvertNumber_more_number() throws Exception {
        System.out.println("convertNumber");
        String input = "10 -10j +10";
        ComplexNumber expResult = null;
        ComplexNumber result = Operation.convertNumber(input);
        assertEquals(expResult, result);

    }

    /**
     * Test of getNumberStack method, of class Operation.
     */
    @Test
    public void testGetNumberStack() {
        System.out.println("getNumberStack");
        PersonalizedStack<ComplexNumber> expResult = new NumberStack<>();
        PersonalizedStack<ComplexNumber> result = op.getNumberStack();
        assertEquals(expResult, result);
        
    }
   

    /**
     * Test of multiply method, of class Operation.
     */
}
