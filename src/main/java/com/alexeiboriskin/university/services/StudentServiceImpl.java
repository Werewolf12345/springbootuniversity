package com.alexeiboriskin.university.services;

import com.alexeiboriskin.university.domain.Student;
import com.alexeiboriskin.university.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Set<Student> getStudents() {
        Set<Student> studentsSet = new HashSet<>();
        studentRepository.findAll().iterator().forEachRemaining(studentsSet::add);
        return studentsSet;
    }

    @Override
    public Set<Student> getByGroupId(Long id) {
        Set<Student> studentsSet = new HashSet<>();
        studentRepository.findAll().iterator().forEachRemaining(studentsSet::add);
        return studentsSet.stream().filter(g -> g.getGroupID().equals(id)).collect(Collectors.toSet());
    }
}
