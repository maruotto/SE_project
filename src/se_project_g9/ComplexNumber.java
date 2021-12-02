/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

/**
 *
 * @author gruppo9
 */
public class ComplexNumber {

    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumber(double realPart) {
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
        if (imaginaryPart == 0.0) {
            return "" + realPart;
        } else if (realPart == 0.0) {
            return "" + imaginaryPart + "i";
        } else {
            if (imaginaryPart > 0) {
                return "" + realPart + " +" + imaginaryPart + "i";
            } else {
                return "" + realPart + " " + imaginaryPart + "i";
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(this.realPart) != Double.doubleToLongBits(other.realPart)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imaginaryPart) != Double.doubleToLongBits(other.imaginaryPart)) {
            return false;
        }
        return true;
    }

}
