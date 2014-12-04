package org.jostein.employeepay;

public class SalariedClassification extends PaymentClassification {

    private double mSalary;
    
    public SalariedClassification(double salary) {
        this.mSalary = salary;
    }

    public double getSalary() {
        return mSalary;
    }

}
