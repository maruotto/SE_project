/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author group9
 */
public class ComplexNumberTest {

    /**
     * Test of getRealPart method, of class ComplexNumber.
     */
    @Test
    public void testGetRealPart() {
        System.out.println("getRealPart");
        double realPart = 3;
        ComplexNumber instance = new ComplexNumber(realPart,0);
        assertEquals(realPart, instance.getRealPart(), 0);
        System.out.println("Works\n");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getImaginaryPart method, of class ComplexNumber.
     */
    @Test
    public void testGetImaginaryPart() {
        System.out.println("getImaginaryPart");
        double imaginaryPart = 6;
        ComplexNumber instance = new ComplexNumber(0,imaginaryPart);
        assertEquals(imaginaryPart, instance.getImaginaryPart(), 0);
        System.out.println("Works\n");
    }

    /**
     * Test of setRealPart method, of class ComplexNumber.
     */
    @Test
    public void testSetRealPart() {
        System.out.println("setRealPart");
        double realPart = 13;
        ComplexNumber instance = new ComplexNumber(0,0);
        instance.setRealPart(realPart);
        assertEquals(realPart, instance.getRealPart(), 0);
        System.out.println("Works\n");
    }

    /**
     * Test of setImaginaryPart method, of class ComplexNumber.
     */
    @Test
    public void testSetImaginaryPart() {
        System.out.println("setImaginaryPart");
        double imaginaryPart = 5;
        ComplexNumber instance = new ComplexNumber(0,0);
        instance.setImaginaryPart(imaginaryPart);
        assertEquals(imaginaryPart, instance.getImaginaryPart(), 0);
        System.out.println("Works\n");
    }

    /**
     * Test of toString method, of class ComplexNumber.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexNumber instance = new ComplexNumber(3, 6);
        String expResult = "3.0 +6.0i";
        String result = instance.toString();
        assertEquals(expResult, result);
        System.out.println("Works\n");
    }
    
}
