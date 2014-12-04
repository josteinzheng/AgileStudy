
package org.jostein.employeepay;


import java.util.Date;

public class TimeCardTransaction implements Transaction {

    private int employeeId;
    private Date date;
    private int hour;

    public TimeCardTransaction(Date date, int hour, int employeeId) {
        this.date = date;
        this.hour = hour;
        this.employeeId = employeeId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(employeeId);
        PaymentClassification pc = e.getClassification();
        HourlyClassification hc = (HourlyClassification) pc;
        hc.addTimeCard(new TimeCard(date, hour));
    }

}
