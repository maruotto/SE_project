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

    /**
     *
     * @param realPart the real part of the number
     * @param imaginaryPart the imaginary part of the number
     */
    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     *
     * @param realPart the real part
     */
    public ComplexNumber(double realPart) {
        this.realPart = realPart;
        this.imaginaryPart = .0;
    }

    /**
     *
     * @return the real part
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     *
     * @return the imaginary part
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     *
     * @param realPart the new real part
     */
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    /**
     *
     * @param imaginaryPart the new imaginary part
     */
    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    /**
     *
     * @return an object rappresentation as String
     */
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

    /**
     *
     * @param obj the object we want to verify with.
     * @return if this object and obj are equals or not
     */
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
