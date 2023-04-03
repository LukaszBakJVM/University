package com.example.university.University.CourseStudent;

import com.example.university.Course.Course;
import com.example.university.Course.CourseRepository;
import com.example.university.Student.Student;
import com.example.university.Student.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseStudentServices {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final CourseStudentRepository courseStudentRepository;
    private final CourseStudentMapper courseStudentMapper;

    public CourseStudentServices(CourseRepository courseRepository, StudentRepository studentRepository,
                                 CourseStudentRepository courseStudentRepository, CourseStudentMapper courseStudentMapper) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.courseStudentRepository = courseStudentRepository;
        this.courseStudentMapper = courseStudentMapper;
    }
    CourseStudentDto startCurse(CourseStudentDto dto){
        CourseStudent courseStudent =new CourseStudent();
        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow();
        Course course = courseRepository.findById(dto.getCourseId()).orElseThrow();
        courseStudent.setStudent(student);
        courseStudent.setCourse(course);
        return courseStudentMapper.map(courseStudentRepository.save(courseStudent));
    }
}
