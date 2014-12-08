
package org.jostein.employeepay.test;

import org.jostein.employeepay.Employee;
import org.jostein.employeepay.PayrollDatabase;
import org.jostein.employeepay.Transaction;

import java.util.List;

public class ServiceChargeTransaction implements Transaction {

    private final int memberId;
    private final long date;
    private final double money;

    public ServiceChargeTransaction(int memberId, long date, double money) {
        this.memberId = memberId;
        this.date = date;
        this.money = money;
    }

    @Override
    public void execute() {
        List<Employee> employees = PayrollDatabase.getEmployeesByMemberId(memberId);
        for (Employee e : employees) {
            Affiliation affiliation = e.getAffiliation();
            if (affiliation instanceof UnionAffiliation) {
                affiliation.addServiceCharge(new ServiceCharge(date, money));
            }
        }
    }

}
