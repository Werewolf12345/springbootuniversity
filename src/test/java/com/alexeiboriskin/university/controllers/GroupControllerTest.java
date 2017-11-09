package com.alexeiboriskin.university.controllers;

import com.alexeiboriskin.university.domain.Group;
import com.alexeiboriskin.university.services.GroupService;
import com.alexeiboriskin.university.services.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class GroupControllerTest {

    @Mock
    private GroupService groupService;

    @Mock
    private StudentService studentService;

    @Mock
    Model model;

    GroupController groupController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        groupController = new GroupController(groupService, studentService);
    }

    @Test
    public void getGroups() throws Exception {

        Set<Group> groupsSet = new HashSet<>();

        groupsSet.add(new Group("Grp1"));
        groupsSet.add(new Group("Grp2"));
        groupsSet.add(new Group("Grp3"));

        when(groupService.getGroups()).thenReturn(groupsSet);

        ArgumentCaptor<Set<Group>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String viewName = groupController.getGroups(model);

        assertEquals("groups", viewName);
        verify(groupService, times(1)).getGroups();
        verify(model, times(1)).addAttribute(eq("groups"), argumentCaptor.capture());
        Set<Group> setInController = argumentCaptor.getValue();
        assertEquals(3, setInController.size());

    }

    @Test
    public void getStudentsWithGroupId() throws Exception {
    }

}