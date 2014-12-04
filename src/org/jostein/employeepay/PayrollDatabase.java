package org.jostein.employeepay;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

    private static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
    
    public static void addEmployee(int employeeId, Employee e) {
        employees.put(employeeId, e);
    }

    public static Employee getEmployee(int employeeId) {
        return employees.get(employeeId);
    }

    public static void removeEmployee(int employeeId) {
        employees.remove(employeeId);
    }

}
