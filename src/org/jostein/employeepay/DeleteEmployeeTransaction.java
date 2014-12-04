package org.jostein.employeepay;


public class DeleteEmployeeTransaction implements Transaction {

    private final int mEmployeeId;
    
    public DeleteEmployeeTransaction(int employeeId) {
        this.mEmployeeId = employeeId;
    }

    @Override
    public void execute() {
        PayrollDatabase.removeEmployee(mEmployeeId);
    }

}
