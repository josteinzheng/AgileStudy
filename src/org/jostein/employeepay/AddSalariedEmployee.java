package org.jostein.employeepay;


public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double mSalary;

    public AddSalariedEmployee(int employeeId, String name, String address, double salary) {
        super(employeeId, name, address);
        this.mSalary = salary;
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new SalariedClassification(mSalary);
    }

}
