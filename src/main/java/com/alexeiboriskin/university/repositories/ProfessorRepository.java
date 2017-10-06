package com.alexeiboriskin.university.repositories;

import com.alexeiboriskin.university.domain.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}
