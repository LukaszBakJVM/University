package com.example.university.Course;

import com.example.university.Student.Student;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String course;
    @OneToMany(mappedBy = "course")
    private List<Student>studentList=new ArrayList<>();


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
