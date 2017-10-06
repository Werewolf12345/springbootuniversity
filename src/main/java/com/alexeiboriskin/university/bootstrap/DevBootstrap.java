package com.alexeiboriskin.university.bootstrap;

import com.alexeiboriskin.university.domain.*;
import com.alexeiboriskin.university.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private GroupRepository groupRepository;
    private LectureRepository lectureRepository;
    private ProfessorRepository professorRepository;
    private StudentRepository studentRepository;
    private FacultyRepository facultyRepository;

    public DevBootstrap(GroupRepository groupRepository, LectureRepository lectureRepository, ProfessorRepository professorRepository, StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.groupRepository = groupRepository;
        this.lectureRepository = lectureRepository;
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Professor professor1 = new Professor("Joe", "Doe", new Address(Address.US.ILLINOIS, "212 Elm st, Mettawa", 60061));
        Professor professor2 = new Professor("JOE", "doe", new Address(Address.US.ILLINOIS, "212 elm ST, mettawa", 60061));
        Professor professor3 = new Professor("Adam", "Smith", new Address(Address.US.ILLINOIS, "214 elm STREET mettawa", 60061));

        professorRepository.save(professor1);
        professorRepository.save(professor2);
        professorRepository.save(professor3);

        Faculty faculty = new Faculty();
        faculty.setDecan(professor1);
        facultyRepository.save(faculty);

        professor1.setFaculty(faculty);
        professor2.setFaculty(faculty);
        professor3.setFaculty(faculty);

        professorRepository.save(professor1);
        professorRepository.save(professor2);
        professorRepository.save(professor3);

        Student student1 = new Student("Joe", "Doe", new Address(Address.US.ILLINOIS, "212 Elm st, Mettawa", 60061));
        Student student2 = new Student("JOE", "doe", new Address(Address.US.ILLINOIS, "212 elm ST, mettawa", 60061));
        Student student3 = new Student("Adam", "Smith", new Address(Address.US.ILLINOIS, "214 elm STREET mettawa", 60061));

        Group group = new Group("GRP1", professor1);
        groupRepository.save(group);

        group.add(student1);
        group.add(student2);
        group.add(student3);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        Lecture lecture1 = new Lecture("Lecture1", Calendar.getInstance(), professor1, group, 1);
        Lecture lecture2 = new Lecture("Lecture2", Calendar.getInstance(), professor1, group, 2);
        Lecture lecture3 = new Lecture("Lecture3", Calendar.getInstance(), professor1, group, 3);

        lectureRepository.save(lecture1);
        lectureRepository.save(lecture2);
        lectureRepository.save(lecture3);
    }
}
