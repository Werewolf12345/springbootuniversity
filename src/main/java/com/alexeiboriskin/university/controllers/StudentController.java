package com.alexeiboriskin.university.controllers;

import com.alexeiboriskin.university.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    private final StudentService studentsService;

    public StudentController(StudentService studentsService) {
        this.studentsService = studentsService;
    }

    @RequestMapping("/students")
    public String getStudentsPage(Model model) {

        model.addAttribute("students", studentsService.getStudents());

        return "students";
    }
}
