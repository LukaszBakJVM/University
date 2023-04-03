package com.example.university.University.CourseStudent;

import com.example.university.Course.Course;
import com.example.university.Course.CourseRepository;
import com.example.university.Student.Student;
import com.example.university.Student.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseStudentMapper {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseStudentMapper(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }
CourseStudentDto map(CourseStudent cs){
        CourseStudentDto dto=new CourseStudentDto();
        Course course=cs.getCourse();
    Student student =cs.getStudent();
    dto.setId(cs.getId());
    dto.setCourseId(course.getId());
    dto.setStudentId(student.getId());
    return dto;

}

}
