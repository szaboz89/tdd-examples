package com.szabodev.examples.tdd.assertions.assertAll;

class Owner extends Person {

    private String city;
    private String phone;

    Owner(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    String getPhone() {
        return phone;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }
}
