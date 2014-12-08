
package org.jostein.employeepay.test;

import junit.framework.TestCase;

import org.jostein.employeepay.AddHourlyEmployee;
import org.jostein.employeepay.AddSalariedEmployee;
import org.jostein.employeepay.CommissionedClassification;
import org.jostein.employeepay.DeleteEmployeeTransaction;
import org.jostein.employeepay.Employee;
import org.jostein.employeepay.HoldMethod;
import org.jostein.employeepay.HourlyClassification;
import org.jostein.employeepay.MonthlySchedule;
import org.jostein.employeepay.PaymentClassification;
import org.jostein.employeepay.PaymentMethod;
import org.jostein.employeepay.PaymentSchedule;
import org.jostein.employeepay.PayrollDatabase;
import org.jostein.employeepay.SalariedClassification;
import org.jostein.employeepay.SalesReceiptTransaction;
import org.jostein.employeepay.TimeCard;
import org.jostein.employeepay.TimeCardTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class PayrollTest extends TestCase {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddSalariedEmployee() {
        int employeeId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(employeeId, "Bob", "Home", 1000.00);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(employeeId);
        assertEquals("Bob", e.getName());

        PaymentClassification pc = e.getClassification();
        SalariedClassification sc = (SalariedClassification) pc;
        assertNotNull(sc);

        assertEquals(1000.00, sc.getSalary(), .001);
        PaymentSchedule ps = e.getSchedule();
        MonthlySchedule ms = (MonthlySchedule) ps;
        assertNotNull(ms);

        PaymentMethod pm = e.getMethod();
        HoldMethod hm = (HoldMethod) pm;
        assertNotNull(hm);
    }

    public void testDeleteEmployee() {
        int employeeId = 20;
        AddSalariedEmployee t = new AddSalariedEmployee(employeeId, "Jostein", "HaiDian", 100000);
        t.execute();

        assertEquals("Jostein", PayrollDatabase.getEmployee(20).getName());

        DeleteEmployeeTransaction d = new DeleteEmployeeTransaction(employeeId);
        d.execute();

        assertNull(PayrollDatabase.getEmployee(employeeId));
    }

    public void testTimeCardTransaction() {
        @SuppressWarnings("deprecation")
        Date date = new Date(2014, 12, 4);
        int employeeId = 3;
        AddHourlyEmployee t = new AddHourlyEmployee(employeeId, "Jostein", "HaiDian", 20.34);
        t.execute();

        TimeCardTransaction tct = new TimeCardTransaction(date, 8, employeeId);
        tct.execute();

        Employee e = PayrollDatabase.getEmployee(employeeId);
        assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        HourlyClassification hc = (HourlyClassification) pc;
        TimeCard tc = hc.getTimeCard(date);
        assertNotNull(tc);
        assertEquals(8, tc.getHours());
    }

    public void testSalesReceiptTransaction() {
        int employeeId = 2;
        AddCommissionedEmployee t = new AddCommissionedEmployee(employeeId, "Jostein", "Haidian");
        t.execute();

        Employee e = PayrollDatabase.getEmployee(employeeId);
        assertNotNull(e);

        long date = 234;
        double amount = 20000;
        SalesReceiptTransaction srt = new SalesReceiptTransaction(employeeId, date, amount);
        srt.execute();

        PaymentClassification pc = e.getClassification();
        CommissionedClassification cc = (CommissionedClassification) pc;
        assertEquals(20000, cc.getTotalAmount(), 0);
    }

    public void testServiceChargeTransaction() {
        int employeeId = 3;
        AddSalariedEmployee t = new AddSalariedEmployee(employeeId, "Jostein", "ChangPing", 30000);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(employeeId);
        assertNotNull(e);
        int memberId = 86;
        PayrollDatabase.addUnionMember(memberId, employeeId);
        UnionAffiliation affiliation = new UnionAffiliation(memberId, 12.5);
        e.setAffiliation(affiliation);

        long date = 20111101;
        double money = 12.95;
        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, date, money);
        sct.execute();

        ServiceCharge sc = affiliation.getServiceCharge(date);
        assertEquals(money, sc.getAmount(), 0);
    }
}
