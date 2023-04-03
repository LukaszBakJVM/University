package com.example.university.University.TeacherSubject;

import com.example.university.Subject.Subject;
import com.example.university.Teacher.Teacher;
import jakarta.persistence.*;


@Entity
@Table(name = "przedmioty")

public class TeacherSubjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne

    private Teacher teacher;
    @ManyToOne
    private Subject subject;

    public TeacherSubjects() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
