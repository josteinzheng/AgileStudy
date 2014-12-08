package org.jostein.employeepay.test;

public interface Affiliation {

    Affiliation NOAffiliation = new Affiliation() {

        @Override
        public void addServiceCharge(ServiceCharge serviceCharge) {
        }

    };

    void addServiceCharge(ServiceCharge serviceCharge);

}
