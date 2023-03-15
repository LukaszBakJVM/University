package com.example.university.University.Course;

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
    @OneToMany
         //   @JoinColumn(name = "email",referencedColumnName = "student_email")
    List<Student>studentList=new ArrayList<>();


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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course1 = (Course) o;
        return id == course1.id && Objects.equals(course, course1.course) && Objects.equals(studentList, course1.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, studentList);
    }
}
