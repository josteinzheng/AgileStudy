
package org.jostein.employeepay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

    private static Map<Integer, List<Integer>> affiliations = new HashMap<Integer, List<Integer>>();

    public static void addUnionMember(int memberId, int employeeId) {
        List<Integer> employeeIdList = affiliations.get(memberId);
        if (employeeIdList == null) {
            affiliations.put(memberId, new LinkedList<Integer>());
        }
        affiliations.get(memberId).add(employeeId);
    }

    public static List<Employee> getEmployeesByMemberId(int memberId) {
        List<Employee> employees = new ArrayList<Employee>();
        List<Integer> employeeIds = affiliations.get(memberId);
        for (int employeeId : employeeIds) {
            employees.add(getEmployee(employeeId));
        }
        return employees;
    }

}
