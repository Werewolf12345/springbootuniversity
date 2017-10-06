package com.alexeiboriskin.university.repositories;

import com.alexeiboriskin.university.domain.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
