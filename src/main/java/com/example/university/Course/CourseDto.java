package com.example.university.Course;

import jakarta.persistence.Column;

public class CourseDto {
    private long id;

    private String course;

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
