/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

/**
 *
 * @author gruppo9
 */
public class Number {
    private double realPart;
    private double imaginaryPart;

    public Number(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }
    
    public Number(double realPart) {
        this.realPart = realPart;
        this.imaginaryPart = .0;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
    
    @Override
    public String toString() {
        if(realPart == 0.0){
            return "" + imaginaryPart + "i";
        }
        else if(imaginaryPart == 0.0){
            return "" + realPart;
        }
        else{
            if(imaginaryPart > 0){
                return "" + realPart + " +" + imaginaryPart + "i";
            }
            else{
                return "" + realPart + " " + imaginaryPart + "i";
            }
        }
    }
}

