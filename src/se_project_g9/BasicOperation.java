/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

/**
 *
 * @author idamaruotto
 */
public class BasicOperation {
    
    public static Number sum(Number n1,Number n2){
        
        double real1 = n1.getRealPart();
        double imaginary1 = n1.getImaginaryPart();
        double real2 = n2.getRealPart();
        double imaginary2 = n2.getImaginaryPart();
        
        return new Number(real1+real2,imaginary1+imaginary2);
        
    }
    
    public static Number sub(Number n1,Number n2){
        
        double real1 = n1.getRealPart();
        double imaginary1 = n1.getImaginaryPart();
        double real2 = n2.getRealPart();
        double imaginary2 = n2.getImaginaryPart();
        
        return new Number(real1-real2,imaginary1-imaginary2);
        
        
    }
    
     
    
    
    
}
