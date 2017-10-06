package com.alexeiboriskin.university.repositories;

import com.alexeiboriskin.university.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
