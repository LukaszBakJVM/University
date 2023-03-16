package com.example.university.Course;

import com.example.university.Student.Student;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Id
    @Column(unique = true)
    private String course;


    public Course() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }




}
