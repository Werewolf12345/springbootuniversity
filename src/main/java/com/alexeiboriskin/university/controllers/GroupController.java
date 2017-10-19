package com.alexeiboriskin.university.controllers;

import com.alexeiboriskin.university.services.GroupService;
import com.alexeiboriskin.university.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GroupController {

    private final GroupService groupService;
    private final StudentService studentService;

    public GroupController(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @RequestMapping("/groups")
    public String getGroups(Model model) {

        model.addAttribute("groups", groupService.getGroups());

        return "groups";
    }

    @RequestMapping("/groups/{groupId}")
    public String getStudentsWithGroupId(@PathVariable("groupId") long id, Model model) {

        model.addAttribute("students", studentService.getByGroupId(id));
        model.addAttribute("groupName", groupService.getGroupName(id));

        return "students";
    }
}
