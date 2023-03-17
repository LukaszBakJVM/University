package com.example.university.Course;

import org.springframework.stereotype.Service;

@Service
public class CourseMapper {
    Course map(CourseDto dto){
        Course course =new Course();
        course.setId(dto.getId());
        course.setCourse(dto.getCourse());
        return course;
    }
    CourseDto map(Course course){
        CourseDto dto =new CourseDto();
        dto.setId(course.getId());
        dto.setCourse(course.getCourse());
        return dto;
    }
}
