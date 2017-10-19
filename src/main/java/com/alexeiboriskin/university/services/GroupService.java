package com.alexeiboriskin.university.services;

import com.alexeiboriskin.university.domain.Group;

import java.util.Set;

public interface GroupService {

    Set<Group> getGroups();
    String getGroupName(Long id);

}
