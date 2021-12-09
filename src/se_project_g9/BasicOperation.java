/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import se_project_g9.exceptions.ZeroDivisionException;

/**
 *
 * @author group9
 */
public class BasicOperation {
    
    /**
     *  this method takes in input two complex number and returns their sum
     * @param n1 first complex number
     * @param n2 second complex number
     * @return the sum of n1 and n2
     */
    public static ComplexNumber sum(ComplexNumber n1,ComplexNumber n2){
        
        double real1 = n1.getRealPart();
        double imaginary1 = n1.getImaginaryPart();
        double real2 = n2.getRealPart();
        double imaginary2 = n2.getImaginaryPart();
        
        return new ComplexNumber(real1+real2,imaginary1+imaginary2);
        
    }
    
    /**
     * this method takes in input two complex number and returns their subtraction
     * @param n1 first complex number
     * @param n2 second complex number
     * @return the subtraction of n1 and n2
     */
    public static ComplexNumber sub(ComplexNumber n1,ComplexNumber n2){
        
        double real1 = n1.getRealPart();
        double imaginary1 = n1.getImaginaryPart();
        double real2 = n2.getRealPart();
        double imaginary2 = n2.getImaginaryPart();
        
        return new ComplexNumber(real1-real2,imaginary1-imaginary2);
        
        
    }
    
    /**
     * this method takes in input two complex number and returns their multiply
     * @param n1 the first complex number 
     * @param n2 the second complex number
     * @return the multiply of n1 and n2
     */
    public static ComplexNumber multiply(ComplexNumber n1,ComplexNumber n2){
        
        double real1 = n1.getRealPart();
        double imaginary1 = n1.getImaginaryPart();
        double real2 = n2.getRealPart();
        double imaginary2 = n2.getImaginaryPart();
        
        return new ComplexNumber((real1*real2-imaginary1*imaginary2),(real1*imaginary2+imaginary1*real2));
        
    }

    /**
     * this method takes in input a complex number and returns the number inverted
     * @param n1 the complex number
     * @return the complex number n1 with its sign inverted
     */
    public static ComplexNumber invert(ComplexNumber n1){
        double realpart = .0;
        double imaginaryPart = .0;
        
        if(n1.getRealPart() != 0){
            realpart = -n1.getRealPart();
        }
        if(n1.getImaginaryPart() != 0){
            imaginaryPart = -n1.getImaginaryPart();
        }
        return new ComplexNumber(realpart, imaginaryPart);
    }
    
    /**
     * this method takes in input two complex number and returns their division
     * @param n1 the first complex number
     * @param n2 the second complex number
     * @return the division of n1 and n2
     * @throws ZeroDivisionException if the second number is equal to 0
     */
    public static ComplexNumber divide(ComplexNumber n1,ComplexNumber n2) throws ZeroDivisionException{
        
        double real1 = n1.getRealPart();
        double imaginary1 = n1.getImaginaryPart();
        double real2 = n2.getRealPart();
        double imaginary2 = n2.getImaginaryPart();
        
        if(real2==0.0 && imaginary2==0.0){
            throw new ZeroDivisionException("the second complex number is 0..");
        }
        
        double real = ((real1*real2)+(imaginary1*imaginary2))/((real2*real2)+(imaginary2*imaginary2));
        double imaginary = ((imaginary1*real2)-(real1*imaginary2))/((real2*real2)+(imaginary2*imaginary2));
        
        return new ComplexNumber(real,imaginary);
    }
    
    /**
     * this method takes in input a complex number and returns its square root
     * @param n1 the complex number 
     * @return the complex number square root
     */
    public static ComplexNumber sqrt(ComplexNumber n1){
        
        if(n1.getImaginaryPart()==0){
           if (n1.getRealPart()>=0){
                return new ComplexNumber(Math.sqrt(n1.getRealPart()),0);
            }else{
                return new ComplexNumber(0,Math.sqrt(n1.getRealPart()*(-1)));
            }
        }else{     
            double module = Math.sqrt(Math.pow(n1.getImaginaryPart(), 2) + Math.pow(n1.getRealPart(), 2));
            double phase = 0;
            double a = n1.getRealPart();
            double b = n1.getImaginaryPart();
            if(a==0 && b>0){
                phase = Math.PI/2; 
            }
            else if(a==0 && b<0){
                phase = (-1)*(Math.PI/2);
            }
            else if(a>0){
                phase = Math.atan(b/a);
            }
            else if(a<0 && b>=0){
                phase = Math.atan(b/a) + Math.PI;
            }
            else if(a<0 && b<0){
                phase = Math.atan(b/a) - Math.PI;  
            }
            
            return new ComplexNumber((Math.sqrt(module)*Math.cos(phase/2)),(Math.sqrt(module)*Math.sin(phase/2)));
        }
    }
    
    public static ComplexNumber mod(ComplexNumber n1){
        double real1 = n1.getRealPart();
        double imaginary1 = n1.getImaginaryPart();
        return new ComplexNumber((Math.sqrt((Math.pow(real1, 2))+(Math.pow(imaginary1, 2)))));
    }
}
