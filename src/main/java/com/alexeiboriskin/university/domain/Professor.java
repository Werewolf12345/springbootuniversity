package com.alexeiboriskin.university.domain;

import javax.persistence.*;

@Entity
public class Professor extends Staff {

    private Faculty faculty;

    public Professor(String firstName, String lastName, Address address) {
        super(firstName, lastName, address);
    }
    
    public Professor() {
        super();
    }

    @ManyToOne
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Override
    public Long getId() {
        return id;
    }

    @ManyToOne
    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }
}

