package org.jostein.employeepay.test;

import org.jostein.employeepay.AddEmployeeTransaction;
import org.jostein.employeepay.CommissionedClassification;
import org.jostein.employeepay.MonthlySchedule;
import org.jostein.employeepay.PaymentClassification;
import org.jostein.employeepay.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction {

    public AddCommissionedEmployee(int employeeId, String name, String address) {
        super(employeeId, name, address);
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new CommissionedClassification();
    }

}
