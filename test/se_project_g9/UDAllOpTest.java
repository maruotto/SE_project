/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luigi
 */
public class UDAllOpTest {
    
   
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addOperation method, of class UDAllOp.
     */
    @Test
    public void testAddOperation() throws Exception {
        System.out.println("addOperation");
        String name = "tris";
        String input = "+ +";
        ApplicationOperation ope = Operation.getInstance();
        UDAllOp instance = ope.getOperations();
        Interpreter.setOperation(ope);
        instance.addOperation(name, input);
        assertTrue(instance.containsKey(name));
    }
    
}
