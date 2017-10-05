package com.alexeiboriskin.university.domain;

import javax.persistence.*;

@Entity
public class Student extends Staff {

    private Group group;
   
    public Student() {
        super();
    }
    
    public Student(String firstName, String lastName, Address address) {
        super(firstName, lastName, address);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Override
    public Long getId() {
        return id;
    }

    @ManyToOne
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Transient
    public Long getGroupID() {
        return group.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @ManyToOne
    @Override
    public Address getAddress() {
        return address;
    }
}
