package com.alexeiboriskin.university.repositories;

import com.alexeiboriskin.university.domain.Lecture;
import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
}
