/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package se_project_g9.commands;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se_project_g9.ComplexNumber;
import se_project_g9.NumberStack;
import se_project_g9.PersonalizedStack;
import se_project_g9.UDOperation;
import se_project_g9.Variables;
import se_project_g9.commands.*;
/**
 *
 * @author idamaruotto
 */
public class OperationCommandTest {
    
    private UDOperation<Command> op;
    private PersonalizedStack stack;
    private Variables vars;
    private OperationCommand cm;
    
    public OperationCommandTest() {
        
        
    }
    
    @Before
    public void setUp() {
        stack = new NumberStack();
        vars = new Variables();
        stack.push(new ComplexNumber(12, 8));
        stack.push(new ComplexNumber(1, 34));
        stack.push(new ComplexNumber(0, -2));
        stack.push(new ComplexNumber(4, 2));
        op = new UDOperation<>();
        op.add(new SumCommand(stack));
        op.add(new SubCommand(stack));
        op.add(new VInsertCommand(vars,stack,'a'));
        cm = new OperationCommand(op, vars, stack);
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
        vars = new Variables();
    }

    /**
     * Test of execute method, of class OperationCommand.
     */
    @Test
    public void testExecute() throws Exception {
        assertFalse(vars.getVariablesMap().containsKey('a'));
        cm.execute();
        assertEquals(new ComplexNumber(12, 8), stack.pop());
        assertEquals(new ComplexNumber(-3, 34), vars.getVariableValue('a'));
        
    }

    /**
     * Test of undo method, of class OperationCommand.
     */
    @Test
    public void testUndo() throws Exception {
        System.out.println(vars);
        cm.execute();
        System.out.println(vars);
        cm.undo();
        System.out.println(vars);
        PersonalizedStack expStack = new NumberStack();
        expStack.push(new ComplexNumber(12, 8));
        expStack.push(new ComplexNumber(1, 34));
        expStack.push(new ComplexNumber(0, -2));
        expStack.push(new ComplexNumber(4, 2));
        assertEquals(expStack, stack);
        Variables expVars = new Variables();
        assertEquals(expVars, vars);
    }
    
}
