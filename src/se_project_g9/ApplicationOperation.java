/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package se_project_g9;

/**
 *
 * @author group9
 */
public interface ApplicationOperation {

    /**
     *
     * @return the Number stack in the Operation
     */
    public PersonalizedStack<ComplexNumber> getNumberStack();

    /**
     *
     * @return the Variables in the Operation
     */
    public Variables getVariables();

    /**
     *
     * @return the User defined operation in the Operation
     */
    public UDAllOp getOperations();
    
}
