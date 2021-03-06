package org.jostein.employeepay;

import org.jostein.employeepay.test.Affiliation;
import org.jostein.employeepay.test.UnionAffiliation;

import java.util.List;

public class Employee {

    private PaymentClassification mClassification;
    private PaymentSchedule mSchedule;
    private PaymentMethod mMethod;
    private String mName;
    private int mEmployeeId;
    private String mAddress;

    public Employee(int employeeId, String name, String address) {
        this.mEmployeeId = employeeId;
        this.mName = name;
        this.mAddress = address;
    }

    public void setClassification(PaymentClassification pc) {
        this.mClassification = pc;
    }

    public void setSchedule(PaymentSchedule ps) {
        this.mSchedule = ps;
    }

    public void setMethod(PaymentMethod pm) {
        this.mMethod = pm;
    }

    public String getName() {
        return mName;
    }

    public PaymentClassification getClassification() {
        return mClassification;
    }

    public PaymentSchedule getSchedule() {
        return mSchedule;
    }

    public PaymentMethod getMethod() {
        return mMethod;
    }

    private Affiliation mAffiliation = Affiliation.NOAffiliation;
    public Affiliation getAffiliation() {
        return mAffiliation;
    }

    public void setAffiliation(UnionAffiliation affiliation) {
        mAffiliation = affiliation;
    }

}
