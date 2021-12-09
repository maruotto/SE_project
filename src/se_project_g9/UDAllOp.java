package se_project_g9;

import java.io.Serializable;
import java.util.HashMap;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author idamaruotto
 */
public class UDAllOp extends HashMap<String, UDOperation> {

    /**
     * insert an operation represented by a name and a sequence of operations
     *
     * @param name name of the operation
     * @param input the string that represent the sequence of operations
     * @throws InputNumberException
     */
    public void addOperation(String name, String input) throws InputNumberException {

        if (this.containsKey(name)) {
            throw new InputNumberException("Operation already defined, try with another name");
        }

        if (name.contains(" ")) {
            throw new InputNumberException("Space not allowed in operation's name");
        }

        UDOperation op = new UDOperation<>(input);
        this.put(name, op);
    }

}
