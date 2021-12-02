/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9;

import java.awt.font.NumericShaper;
import java.util.EmptyStackException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project_g9.exceptions.NotEnoughNumbersException;

/**
 *
 * @author idamaruotto
 */
public class NumberStackTest {

    private ComplexNumber n1, n2;
    private NumberStack stack;

    public NumberStackTest() {
        stack = new NumberStack();
    }

    @Before
    public void setUp() {
        n1 = new ComplexNumber(4, 6);
        n2 = new ComplexNumber(29, 6);

    }

    /**
     * Test of pop method, of class NumberStack.
     */
    @Test(expected = EmptyStackException.class)
    public void testPop_empty() {
        assertEquals(stack.pop(), n1);
    }

    /**
     * Test of clear method, of class NumberStack.
     */
    @Test
    public void testClear() {
        stack.push(n1);
        stack.clear();
        assertEquals(stack.size(), 0);
    }

    /**
     * Test of peek method, of class NumberStack.
     */
    @Test
    public void testPeek() {
        stack.push(n1);
        ComplexNumber peek = (ComplexNumber) stack.peek();
        assertEquals(peek, stack.pop());
        assertEquals(peek, n1);
    }

    /**
     * Test of peek method, of class NumberStack.
     */
    @Test(expected = EmptyStackException.class)
    public void testPeek_empty() {
        ComplexNumber peek = (ComplexNumber) stack.peek();
        assertEquals(peek, stack.pop());
        assertEquals(peek, n1);
    }

    /**
     * Test of drop method, of class NumberStack.
     */
    @Test
    public void testDrop() {
        stack.push(n1);
        int oldLen = stack.size();
        assertEquals(stack.peek(), n1);
        stack.drop();
        int newLen = stack.size();
        assertEquals(oldLen - 1, newLen);

    }

    /**
     * Test of peek method, of class NumberStack.
     */
    @Test(expected = EmptyStackException.class)
    public void testDrop_empty() {
        int oldLen = stack.size();
        assertEquals(stack.peek(), n1);
        stack.drop();
        int newLen = stack.size();
        assertEquals(oldLen - 1, newLen);
    }

    /**
     * Test of dup method, of class NumberStack.
     */
    @Test
    public void testDup() {
        stack.push(n1);
        int oldLen = stack.size();
        stack.dup();
        int newLen = stack.size();
        assertEquals(stack.pop(), n1);
        assertEquals(stack.pop(), n1);
        assertEquals(oldLen, newLen - 1);
    }

    /**
     * Test of dup method, of class NumberStack.
     */
    @Test(expected = EmptyStackException.class)
    public void testDup_empty() {
        int oldLen = stack.size();
        stack.dup();
        int newLen = stack.size();
        assertEquals(stack.pop(), n1);
        assertEquals(stack.pop(), n1);
        assertEquals(oldLen, newLen - 1);
    }

    /**
     * Test of swap method, of class NumberStack.
     */
    @Test
    public void testSwap() throws Exception {
        stack.push(n1);
        stack.push(n2);
        int oldLen = stack.size();
        stack.swap();
        int newLen = stack.size();
        assertEquals(stack.pop(), n1);
        assertEquals(stack.pop(), n2);
        assertEquals(oldLen, newLen);
    }

    /**
     * Test of swap method, of class NumberStack.
     */
    @Test(expected = NotEnoughNumbersException.class)
    public void testSwap_notEnough() throws Exception {
        stack.push(n2);
        int oldLen = stack.size();
        stack.swap();
        int newLen = stack.size();
        assertEquals(stack.pop(), n1);
        assertEquals(stack.pop(), n2);
        assertEquals(oldLen, newLen);
    }

    /**
     * Test of swap method, of class NumberStack.
     */
    @Test(expected = EmptyStackException.class)
    public void testSwap_empty() throws Exception {
        int oldLen = stack.size();
        stack.swap();
        int newLen = stack.size();
        assertEquals(stack.pop(), n1);
        assertEquals(stack.pop(), n2);
        assertEquals(oldLen, newLen);
    }

    /**
     * Test of over method, of class NumberStack.
     */
    @Test
    public void testOver() throws Exception {
        stack.push(n1);
        stack.push(n2);
        int oldLen = stack.size();
        stack.over();
        int newLen = stack.size();
        System.out.println(newLen);
        assertEquals(stack.pop(), n1);
        assertEquals(stack.pop(), n2);
        assertEquals(stack.pop(), n1);
        assertEquals(oldLen + 1, newLen);
    }

    /**
     * Test of over method, of class NumberStack.
     */
    @Test(expected = NotEnoughNumbersException.class)
    public void testOver_notEnough() throws Exception {
        stack.push(n1);
        int oldLen = stack.size();
        stack.over();
        int newLen = stack.size();
        System.out.println(newLen);
        assertEquals(stack.pop(), n1);
        assertEquals(stack.pop(), n2);
        assertEquals(stack.pop(), n1);
        assertEquals(oldLen + 1, newLen);
    }

    /**
     * Test of over method, of class NumberStack.
     */
    @Test(expected = EmptyStackException.class)
    public void testOver_empty() throws Exception {
        int oldLen = stack.size();
        stack.over();
        int newLen = stack.size();
        System.out.println(newLen);
        assertEquals(stack.pop(), n1);
        assertEquals(stack.pop(), n2);
        assertEquals(stack.pop(), n1);
        assertEquals(oldLen + 1, newLen);
    }

}
