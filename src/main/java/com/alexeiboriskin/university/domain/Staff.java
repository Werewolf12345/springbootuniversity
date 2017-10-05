package com.alexeiboriskin.university.domain;

import java.util.Objects;

public abstract class Staff {
    Long id;
    String firstName;
    String lastName;
    Address address;

    public Staff() {

    }

    public Staff(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase(), address.getZipCode(),
                address.getAddress().toLowerCase(), address.getState());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return (((Staff) obj).getFirstName().equalsIgnoreCase(this.getFirstName())
                && ((Staff) obj).getLastName().equalsIgnoreCase(this.getLastName())
                && ((Staff) obj).getAddress().equals(this.getAddress()));
    }
}
