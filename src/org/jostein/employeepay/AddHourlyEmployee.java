package org.jostein.employeepay;


public class AddHourlyEmployee extends AddEmployeeTransaction {

    private int employeeId;
    private String name;
    private String address;
    private double hourlyRate;

    public AddHourlyEmployee(int employeeId, String name, String address, double hourlyRate) {
        super(employeeId, name, address);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new DailySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new HourlyClassification(hourlyRate);
    }

}
