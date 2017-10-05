package com.alexeiboriskin.university.domain;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dateAndTime;
    @ManyToOne
    private Professor lector;
    @ManyToOne
    private Group group;
    private int auditoriumNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lecture() {
    }

    public Lecture(String name, Calendar dateAndTime, Professor lector,
            Group group, int auditorium) {
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.lector = lector;
        this.group = group;
        this.auditoriumNo = auditorium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Calendar dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Professor getLector() {
        return lector;
    }

    public void setLector(Professor lector) {
        this.lector = lector;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getAuditoriumNo() {
        return auditoriumNo;
    }
    
    public void setAuditoriumNo(int auditoriumNo) {
        this.auditoriumNo = auditoriumNo;
    }

    public void setAuditorium(int auditorium) {
        this.auditoriumNo = auditorium;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateAndTime, lector, group, auditoriumNo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ((Lecture) obj).getName().equalsIgnoreCase(this.getName())
                && ((Lecture) obj).getAuditoriumNo() == this.getAuditoriumNo()
                && ((Lecture) obj).getGroup().equals(this.getGroup())
                && ((Lecture) obj).getDateAndTime().equals(
                        this.getDateAndTime());
    }
}
