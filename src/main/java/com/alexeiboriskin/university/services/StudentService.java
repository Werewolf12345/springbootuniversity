package com.alexeiboriskin.university.services;

import com.alexeiboriskin.university.domain.Student;

import java.util.Set;

public interface StudentService {

    Set<Student> getStudents();
    Set<Student> getByGroupId(Long id);

}
