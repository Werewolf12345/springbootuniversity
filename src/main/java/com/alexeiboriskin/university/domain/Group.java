package com.alexeiboriskin.university.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group extends Board<Student> {

    private Long id;
    private String name;
    private Professor counselor;
    private Set<Lecture> lectures;
    
    public Group() {
    }
    
    public Group(String name, Professor counselor) {
        super();
        this.name = name;
        this.counselor = counselor;
    }

    public Group(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "group")
    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Professor getCounselor() {
        return counselor;
    }
    
    public void setCounselor(Professor counselor) {
        this.counselor = counselor;
    }

    @Override
    public boolean add(Student student) {
        student.setGroup(this);
        return super.add(student);
    }

    @OneToMany(targetEntity = Student.class, mappedBy = "group")
    @Override
    public Set<Student> getMembers() {
        return members;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ((Group) obj).getName().equals(this.getName());
    }

    public void remove(Student student) {
        members.remove(student);
    }

}
