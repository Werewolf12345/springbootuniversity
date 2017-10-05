package com.alexeiboriskin.university.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "faculty")
public class Faculty extends Board<Professor> {

    private Long id;
    private Professor decan;

    @OneToMany(targetEntity = Professor.class, mappedBy = "faculty")
    @Override
    public Set<Professor> getMembers() {
        return super.getMembers();
    }

    @OneToOne
    public Professor getDecan() {
        return decan;
    }

    public void setDecan(Professor decan) {
        this.decan = decan;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
