/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

/**
 *
 * @author group9
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
    
    public static Number multiply(Number n1,Number n2){
        
        double real1 = n1.getRealPart();
        double imaginary1 = n1.getImaginaryPart();
        double real2 = n2.getRealPart();
        double imaginary2 = n2.getImaginaryPart();
        
        return new Number((real1*real2-imaginary1*imaginary2),(real1*imaginary2-imaginary1*real2));
        
    }

    public static void invert(Number n1){
        if(n1.getRealPart() != 0){
            n1.setRealPart(n1.getRealPart() * -1);
        }
        if(n1.getImaginaryPart() != 0){
            n1.setImaginaryPart(n1.getImaginaryPart() * -1);
        }
    }
    
    public static Number divide(Number n1,Number n2) throws Exception{
        
        double real1 = n1.getRealPart();
        double imaginary1 = n1.getImaginaryPart();
        double real2 = n2.getRealPart();
        double imaginary2 = n2.getImaginaryPart();
        
        if(real2==0.0 && imaginary2==0.0){
            throw new Exception("the second complex number is 0..");
        }
        
        double real = ((real1*real2)+(imaginary1*imaginary2))/((real2*real2)+(imaginary2*imaginary2));
        double imaginary = ((imaginary1*real2)-(real1*imaginary2))/((real2*real2)+(imaginary2*imaginary2));
        
        return new Number(real,imaginary);
    }
    

}
