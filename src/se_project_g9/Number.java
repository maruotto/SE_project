/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

/**
 *
 * @author Gruppo 9
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

    @Override
    public String toString() {
        if(realPart == 0.0){
            return "" + imaginaryPart + "j";
        }
        else if(imaginaryPart == 0.0){
            return "" + realPart;
        }
        else{
            return "" + realPart + " " + imaginaryPart + "j";
        }
    }
}
