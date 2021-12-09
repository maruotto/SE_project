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

/**
 *
 * @author luigi
 */
public class BasicOperationTest {
    
    private ComplexNumber n1;
    private ComplexNumber n2;
    private ComplexNumber expResult;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        n1 = new ComplexNumber(0,0);
        n2 = new ComplexNumber(4,3);
        
    }

    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of sum method, of class BasicOperation.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        ComplexNumber expResult = new ComplexNumber(4,3);
        ComplexNumber result = BasicOperation.sum(n1, n2);
        assertEquals(expResult, result);
        System.out.println("work\n");
    }

    /**
     * Test of sub method, of class BasicOperation.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        ComplexNumber expResult = new ComplexNumber(-4,-3);
        ComplexNumber result = BasicOperation.sub(n1, n2);
        assertEquals(expResult, result);
        System.out.println("work\n");
    }

    /**
     * Test of multiply method, of class BasicOperation.
     */
    @Test
    public void testMultiply_case1() {
        System.out.println("multiply");
        ComplexNumber expResult = new ComplexNumber(2,0);
        ComplexNumber result = BasicOperation.multiply(new ComplexNumber(2,0), new ComplexNumber(1,0));
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        
        
        System.out.println("work\n");
    }

    /**
     * Test of multiply method, of class BasicOperation.
     */
    @Test
    public void testMultiply_case2() {
        expResult = new ComplexNumber(4, 2);
        ComplexNumber result = BasicOperation.multiply(new ComplexNumber(2,0), new ComplexNumber(2,1));
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
    }  
    /**
     * Test of invert method, of class BasicOperation.
     */
    @Test
    public void testInvert() {
        System.out.println("invert");
        ComplexNumber expResult = new ComplexNumber(-4,-3);
        ComplexNumber result = BasicOperation.invert(n2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of divide method, of class BasicOperation.
     */
    @Test (expected=Exception.class)
    public void testDivide() throws Exception{
        System.out.println("divide");
        ComplexNumber n = new ComplexNumber(18,51);
        ComplexNumber expResult = n2;
        ComplexNumber result = BasicOperation.divide(n, n1);
        assertEquals(expResult, result);
        System.out.println("work\n");
    }

    /**
     * Test of sqrt method, of class BasicOperation.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        ComplexNumber expResult = new ComplexNumber(2,0);
        ComplexNumber result = BasicOperation.sqrt(new ComplexNumber(4,0));
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        
        expResult = new ComplexNumber(2,-1);
        result = BasicOperation.sqrt(new ComplexNumber(3,-4));
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        System.out.println("work\n");
    }

    
    /**
     * Test of mod method, of class BasicOperation.
     */
    @Test
    public void testMod() {
        System.out.println("mod");
        ComplexNumber expResult = new ComplexNumber(5,0);
        ComplexNumber result = BasicOperation.mod(new ComplexNumber(3,4));
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        
        
        expResult = new ComplexNumber(Math.pow(13, 0.5));
        result = BasicOperation.mod(new ComplexNumber(-2,3));
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0.001*Math.pow(13, 0.5));
        System.out.println("work\n");
    }
    
    
    
    
    
    
    
    
}
