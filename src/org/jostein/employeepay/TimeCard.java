
package org.jostein.employeepay;

import java.util.Date;

public class TimeCard {

    private Date date;
    private int hour;

    public TimeCard(Date date, int hour) {
        this.date = date;
        this.hour = hour;
    }

    public int getHours() {
        return hour;
    }

    public Date getDate() {
        return date;
    }

}
