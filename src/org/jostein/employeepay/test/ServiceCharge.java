
package org.jostein.employeepay.test;

public class ServiceCharge {

    private long date;
    private double money;

    public ServiceCharge(long date, double money) {
        this.date = date;
        this.money = money;
    }

    public double getAmount() {
        return money;
    }

    public long getDate() {
        return date;
    }

}
