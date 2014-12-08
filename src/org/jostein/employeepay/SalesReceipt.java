
package org.jostein.employeepay;

public class SalesReceipt {

    private double mAmount;
    private long mDate;

    public SalesReceipt(long date, double amount) {
        this.mDate = date;
        this.mAmount = amount;
    }

    public double getAmount() {
        return mAmount;
    }

}
