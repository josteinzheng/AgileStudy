
package org.jostein.employeepay.test;

import java.util.ArrayList;
import java.util.List;

public class UnionAffiliation implements Affiliation {

    public UnionAffiliation(int memberId, double d) {
        // TODO Auto-generated constructor stub
    }

    private List<ServiceCharge> charges = new ArrayList<ServiceCharge>();

    @Override
    public void addServiceCharge(ServiceCharge serviceCharge) {
        charges.add(serviceCharge);
    }

    public ServiceCharge getServiceCharge(long date) {
        for (ServiceCharge charge : charges) {
            if (charge.getDate() == date) {
                return charge;
            }
        }
        return null;
    }

}
