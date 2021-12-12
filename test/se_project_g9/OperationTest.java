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
        op = Operation.getInstance();
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
    
    @Test
    public void testaddToVariable() throws Exception{
        
        System.out.println("addToVariable");
        ComplexNumber value = new ComplexNumber(3,4);
        op.getNumberStack().push(value);
        op.addToVariable(Character.valueOf('c'));
        assertEquals(op.getVariables().getVariableValue(Character.valueOf('c')),value);
        
        
    }
    
    @Test
    public void testpushValueOf() throws Exception{
        
        System.out.println("pushToValue");
        ComplexNumber value = new ComplexNumber(3,4);
        op.getNumberStack().push(value);
        op.addToVariable(Character.valueOf('c'));
        op.pushValueOf(Character.valueOf('c'));
        assertEquals(op.getNumberStack().pop(),value);  
        
    }
    
    
    
    
}
