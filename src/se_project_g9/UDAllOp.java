package se_project_g9;

import java.util.HashMap;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author idamaruotto
 */
public class UDAllOp extends HashMap<String, UDOperation>{
    private Interpreter i;

    public UDAllOp() {
        this.i = null;
    }
    
    
    public void addOperation(String name, String input) throws InputNumberException {
        if(i==null){
            throw new NullPointerException("Interpreter of class UDAllOp not setted");
        }
        
        if (this.containsKey(name)) {
            throw new InputNumberException("Operation already defined, try with another name");
        }

        if (name.contains(" ")) {
            throw new InputNumberException("Space not allowed in operation's name");
        }
        
        UDOperation op = new UDOperation<>(input);
        this.put(name, op);
    }

    void addInterpreter(Interpreter i) {
        this.i = i;
    }
    
}
