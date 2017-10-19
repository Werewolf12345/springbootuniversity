package com.alexeiboriskin.university.services;

import com.alexeiboriskin.university.domain.Group;
import com.alexeiboriskin.university.repositories.GroupRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Log4j2
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
        log.debug("Got " + groupsSet.size() + " group(s).");
        return groupsSet;
    }

    @Override
    public String getGroupName(Long id) {
        return groupRepository.findById(id).isPresent() ? groupRepository.findById(id).get().getName() : "No such group";
    }
}
