package com.alexeiboriskin.university.repositories;

import com.alexeiboriskin.university.domain.Faculty;
import org.springframework.data.repository.CrudRepository;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {
}
