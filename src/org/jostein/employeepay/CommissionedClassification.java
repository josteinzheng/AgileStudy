
package org.jostein.employeepay;

import java.util.ArrayList;
import java.util.List;

public class CommissionedClassification extends PaymentClassification {

    private List<SalesReceipt> receiptList = new ArrayList<SalesReceipt>();

    public void addReceipt(SalesReceipt salesReceipt) {
        receiptList.add(salesReceipt);
    }

    public double getTotalAmount() {
        double amount = 0;
        for (SalesReceipt receipt : receiptList) {
            amount += receipt.getAmount();
        }
        return amount;
    }

}
