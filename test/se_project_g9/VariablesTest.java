/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9;

import java.util.HashMap;
import java.util.Stack;
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
public class VariablesTest {
    
    private Variables vars;
    
    
    @Before
    public void setUp() throws Exception {
        vars = new Variables();
        vars.setVariableValue('a',new ComplexNumber(3,4));
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setVariableValue method, of class Variables.
     */
    @Test
    public void testSetVariableValue() throws Exception {
        System.out.println("setVariableValue");
        Character key = Character.valueOf('a');
        ComplexNumber expected = new ComplexNumber(3,9);
        vars.setVariableValue(key,expected);
        assertEquals(expected,vars.getVariableValue(key));
        
        
    }

    /**
     * Test of getVariableValue method, of class Variables.
     */
    @Test
    public void testGetVariableValue() throws Exception {
        System.out.println("getVariableValue");
        Character key = Character.valueOf('a');
        ComplexNumber exp = new ComplexNumber(3,4);
        ComplexNumber c = vars.getVariableValue(key);
        assertEquals(exp,c);
    }

    /**
     * Test of getVariablesMap method, of class Variables.
     */
    @Test
    public void testGetVariablesMap() {
        System.out.println("getVariablesMap");
        HashMap<Character,ComplexNumber> exp = new HashMap<>();
        exp.put(Character.valueOf('a'),new ComplexNumber(3,4));
        HashMap<Character,ComplexNumber> test = vars.getVariablesMap();
        assertEquals(exp, test);
    }
    
    @Test
    public void testGetVariableStack(){
        System.out.println("getVariablesStack");
        Stack<HashMap> exp = new Stack<>();
        exp.push(new HashMap());
        vars.getVariableStack().push(new HashMap());
        assertEquals(exp,vars.getVariableStack());
                
        
        
        
    }

    /**
     * Test of clone method, of class Variables.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        Variables clone = vars.clone();
        assertEquals(vars, clone);
    }

    /**
     * Test of hashCode method, of class Variables.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        
        
    }

    /**
     * Test of equals method, of class Variables.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Variables test = vars;
        boolean result = vars.equals(test);
        assertEquals(true, result);
        test = vars.clone();
        result = vars.equals(test);
        assertEquals(true, result);
        ComplexNumber test2 = new ComplexNumber(2,4);
        result = vars.equals(test2);
        assertEquals(false,result);
        
    }

    /**
     * Test of addAll method, of class Variables.
     */
    @Test
    public void testAddAll() throws Exception {
        System.out.println("addAll");
        Variables test = new Variables();
        test.setVariableValue(Character.valueOf('b'),new ComplexNumber(2,3));
        test.setVariableValue(Character.valueOf('c'),new ComplexNumber(3,5));
        Variables exp = new Variables();
        exp.setVariableValue(Character.valueOf('a'),new ComplexNumber(3,4));
        exp.setVariableValue(Character.valueOf('b'),new ComplexNumber(2,3));
        exp.setVariableValue(Character.valueOf('c'),new ComplexNumber(3,5));
        vars.addAll(test);
        assertEquals(exp,vars);
        
        
        
    }

    /**
     * Test of saveVar method, of class Variables.
     */
    @Test
    public void testSaveVar() {
        System.out.println("saveVar");
        Stack<HashMap> test = new Stack<>();
        test.push(vars.getVariablesMap());
        vars.saveVar();
        assertEquals(test,vars.getVariableStack());
        
        
        
        
    }

    /**
     * Test of insertVar method, of class Variables.
     */
    @Test
    public void testInsertVar() {
        System.out.println("insertVar");
        HashMap<Character,ComplexNumber> test = new HashMap<>();
        test.put(Character.valueOf('a'),new ComplexNumber(3,4));
        test.put(Character.valueOf('b'),new ComplexNumber(4,5));
        vars.insertVar(test);
        assertEquals(vars.getVariablesMap(), test);
        
        
        
    }

    /**
     * Test of restoreVar method, of class Variables.
     */
    @Test
    public void testRestoreVar() {
        System.out.println("restoreVar");
        HashMap<Character,ComplexNumber> test = new HashMap<>();
        test.put(Character.valueOf('a'),new ComplexNumber(3,4));
        vars.saveVar();
        vars.getVariablesMap().clear();
        vars.restoreVar();
        assertEquals(test,vars.getVariablesMap());
        
       
    }

    /**
     * Test of toString method, of class Variables.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String exp = "Variables{variablesMap="+vars.getVariablesMap()+", variableStack="+ vars.getVariableStack()+'}';
        String result = vars.toString();
        assertEquals(exp, result);
        
    }

    /**
     * Test of clear method, of class Variables.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Variables test = new Variables();
        vars.clear();
        assertEquals(test,vars);
        
    }
    
}
