package com.alexeiboriskin.university.services;

import com.alexeiboriskin.university.domain.Group;
import com.alexeiboriskin.university.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {

private GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Set<Group> getGroups() {
        Set<Group> groupsSet = new HashSet<>();
        groupRepository.findAll().iterator().forEachRemaining(groupsSet::add);
        return groupsSet;
    }
}
