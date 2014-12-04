
package org.jostein.employeepay;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HourlyClassification extends PaymentClassification {

    private Map<Date, TimeCard> timeCardList = new HashMap<Date, TimeCard>();
    private double hourlyRate;

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public TimeCard getTimeCard(Date date) {
        return timeCardList.get(date);
    }

    public void addTimeCard(TimeCard timeCard) {
        timeCardList.put(timeCard.getDate(), timeCard);
    }

}
