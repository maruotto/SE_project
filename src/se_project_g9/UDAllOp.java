package se_project_g9;

import java.io.Serializable;
import java.util.HashMap;
import se_project_g9.exceptions.CalculatorException;
import se_project_g9.exceptions.InputNumberException;
import se_project_g9.exceptions.OperationException;

/**
 *
 * @author idamaruotto
 */
public class UDAllOp extends HashMap<String, UDOperation> {

    /**
     * insert an operation represented by a name and a sequence of operations
     *
     * @param name name of the operation
     * @param input the string that represents the sequence of operations
     * @throws CalculatorException
     */
    public void addOperation(String name, String input) throws CalculatorException {

        if (this.containsKey(name)) {
            throw new OperationException("Operation already defined, try with another name");
        }

        if (name.contains(" ")) {
            throw new OperationException("Space not allowed in operation's name");
        }
        UDOperation op = new UDOperation<>(input);
        this.put(name, op);
    }

}
