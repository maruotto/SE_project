/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luigi
 */
public class BasicOperationTest {
    
    private Number n1;
    private Number n2;
    private Number expResult;
    
    @Before
    public void setUp() {
        n1 = new Number(0,0);
        n2 = new Number(4,3);
        
    }
    
    /**
     * Test of sum method, of class BasicOperation.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Number expResult = new Number(4,3);
        Number result = BasicOperation.sum(n1, n2);
        assertEquals(expResult, result);
        System.out.println("work\n");
    }

    /**
     * Test of sub method, of class BasicOperation.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        Number expResult = new Number(-4,-3);
        Number result = BasicOperation.sub(n1, n2);
        assertEquals(expResult, result);
        System.out.println("work\n");
    }

    /**
     * Test of multiply method, of class BasicOperation.
     */
    @Test
    public void testMultiply_case1() {
        System.out.println("multiply");
        Number expResult = new Number(2,0);
        Number result = BasicOperation.multiply(new Number(2,0), new Number(1,0));
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        
        
        System.out.println("work\n");
    }

    /**
     * Test of multiply method, of class BasicOperation.
     */
    @Test
    public void testMultiply_case2() {
        expResult = new Number(4, 2);
        Number result = BasicOperation.multiply(new Number(2,0), new Number(2,1));
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
    }  
    /**
     * Test of invert method, of class BasicOperation.
     */
    @Test
    public void testInvert() {
        System.out.println("invert");
        Number expResult = new Number(-4,-3);
        Number result = BasicOperation.invert(n2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of divide method, of class BasicOperation.
     */
    @Test (expected=Exception.class)
    public void testDivide() throws Exception {
        System.out.println("divide");
        Number n = new Number(18,51);
        Number expResult = n2;
        Number result = BasicOperation.divide(n, n1);
        assertEquals(expResult, result);
        System.out.println("work\n");
    }

    /**
     * Test of sqrt method, of class BasicOperation.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        Number expResult = new Number(2,0);
        Number result = BasicOperation.sqrt(new Number(4,0));
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        
        expResult = new Number(2,-1);
        result = BasicOperation.sqrt(new Number(3,-4));
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0);
        assertEquals(expResult.getImaginaryPart(), result.getImaginaryPart(), 0);
        System.out.println("work\n");
    }
    
    
    
    
    
    
    
    
}
