
package org.jostein.employeepay;


abstract public class AddEmployeeTransaction implements Transaction {

    private int mEmployeeId;
    private String mName;
    private String mAddress;

    public AddEmployeeTransaction(int employeeId, String name, String address) {
        this.mEmployeeId = employeeId;
        this.mName = name;
        this.mAddress = address;
    }

    @Override
    public void execute() {
        PaymentClassification pc = getClassification();
        PaymentSchedule ps = getSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(mEmployeeId, mName, mAddress);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setMethod(pm);
        PayrollDatabase.addEmployee(mEmployeeId, e);
    }

    abstract protected PaymentSchedule getSchedule();

    abstract protected PaymentClassification getClassification();

}
