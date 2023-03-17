package com.example.university.Course;

import com.example.university.Subject.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course,Long> {
    List<Course> findAll();
    Optional<Course> findByCourseIgnoreCase(String course);
    Optional<Course>deleteByCourseIgnoreCase(String course);
}
