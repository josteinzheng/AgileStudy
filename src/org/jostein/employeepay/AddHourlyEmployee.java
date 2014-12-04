package org.jostein.employeepay;


public class AddHourlyEmployee implements Transaction {

    private int employeeId;
    private String name;
    private String address;
    private double hourlyRate;

    public AddHourlyEmployee(int employeeId, String name, String address, double hourlyRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void execute() {
        Employee e = new Employee(employeeId, name, address);
        HourlyClassification hp = new HourlyClassification(hourlyRate);
        e.setClassification(hp);
        PayrollDatabase.addEmployee(employeeId, e);
    }

}
