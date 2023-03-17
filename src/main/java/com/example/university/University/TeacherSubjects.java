package com.example.university.University;

import com.example.university.Subject.Subject;
import com.example.university.Teacher.Teacher;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


public class TeacherSubjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany
    List<Subject>subjectList=new ArrayList<>();


}
