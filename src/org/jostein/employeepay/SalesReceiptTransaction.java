
package org.jostein.employeepay;

public class SalesReceiptTransaction implements Transaction {

    private final int mEmployeeId;
    private final long mDate;
    private final double mAmount;

    public SalesReceiptTransaction(int employeeId, long date, double amount) {
        this.mEmployeeId = employeeId;
        this.mDate = date;
        this.mAmount = amount;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(mEmployeeId);
        PaymentClassification pc = e.getClassification();
        CommissionedClassification sc = (CommissionedClassification) pc;
        sc.addReceipt(new SalesReceipt(mDate, mAmount));
    }

}
